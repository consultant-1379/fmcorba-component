/*------------------------------------------------------------------------------
 *******************************************************************************
 * COPYRIGHT Ericsson 2012
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *******************************************************************************
 *----------------------------------------------------------------------------*/
package com.ericsson.oss.mediation.supervision.corba.heartbeat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.oss.mediation.supervision.corba.CorbaExchangeHeaders;
import com.ericsson.oss.mediation.supervision.corba.CorbaManagedElement;
import com.ericsson.oss.mediation.supervision.corba.heartbeat.component.HBEndpoint;
import com.ericsson.oss.mediation.supervision.corba.translation.EventModelTranslator;
import com.ericsson.oss.mediation.supervision.corba.util.Constants;
import com.ericsson.oss.mediation.supervision.corba.util.HBAlarmSender;
import com.ericsson.oss.mediation.translator.model.EventNotification;

public class HBDispatcher implements Runnable {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(HBDispatcher.class);
	static final SimpleDateFormat df = new SimpleDateFormat("HHmmss-SSS");

	/**
	 * The supervision entry put in the "supervisionelements" list kept by the 
	 * SupervisionDispatcher. 
	 * 
	 * This implementation does not fulfil the general contract of the
	 * Set interface (java.util.Set):
	 * <ul>  
	 * <li>Implements Comparable by comparing nextTime and managed element. 
	 * <li>Implements equals by comparing managed element. 
	 * <li>Implements hashCode computed by managed element.
	 * </ul>
	 *  
	 * <p>This makes it possible to use the SupervisionEntry in both a sorted list 
	 * (like SortedSet) where the nextTime attribute is significant or in a non 
	 * sorted list (like HashSet) where the nextTime attribute is not significant.
	 * 
	 * <p>A constraint is that an entry put into a sorted list is not allowed to change 
	 * the nextTime attribute without first removing the entry, changing it and then
	 * put it back. In a non sorted list it is possible to change the timeEntry 
	 * while the entry is still in the list.
	 * 
	 * <p><b>Note!</b> This works for TreeSet and HashSet, however another 
	 * implementation of the Set interface may require that the equals, hashCode 
	 * and compareTo methods fulfills the contract of the Set interface.   
	 */
	@SuppressWarnings("rawtypes")
	private class SupervisionEntry implements Comparable {
		/**
		 * Holds managed element
		 */
		private CorbaManagedElement me;
		/**
		 * The supervision interval (heartbeat).
		 */
		private int interval;
		/**
		 * Next time to ping the interface.
		 */
		private long nextTime;

		/**
		 * Create new supervision entry.
		 * @param me	managed element
		 * @param interval	supervision interval
		 * @param nextTime	next time to ping
		 */
		SupervisionEntry(final CorbaManagedElement me, final int interval, final long nextTime ) {
			this.me = me;
			this.interval = interval;
			this.nextTime = nextTime;
		}

		/**
		 * Implements <code>compareTo</code> with the following attributes:<br> 
		 * <code>nextTime</code>and <code>managed element</code>.
		 * 
		 * <p>The attributes are compared in the following order:<br>
		 * <code>nextTime</code>and <code>managed element</code>  
		 * 
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		public int compareTo(final Object o) {
			if ( (o != null) && (o instanceof SupervisionEntry) ) {
				final SupervisionEntry se = (SupervisionEntry)o;
				// compare nextTime
				final long timediff = this.nextTime - se.nextTime;
				if ( timediff < 0) {
					return -1;		
				} else if ( timediff == 0 ) {
					// compare me
					return this.me.getFdn().compareTo(se.me.getFdn());
				} else {
					return 1;
				}			
			} else {		
				return -1;
			}	
		}

		/**
		 * Equals on type and me.
		 * 
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		public boolean equals(final Object obj) {
			if ( (obj != null) && (obj instanceof SupervisionEntry) ) {
				final SupervisionEntry se = (SupervisionEntry)obj;

				if ( this.me == se.me ) {
					return true;
				}
			}
			return false;
		}

		/**
		 * 
		 * @return managed element
		 */
		public CorbaManagedElement getManagedElement() {
			return me;
		}

		/**
		 * 
		 * @return supervision interval (heartbeat)
		 */
		@SuppressWarnings("unused")
		public int getInterval() {
			return interval;
		}

		/**
		 * 
		 * @return next time to ping interface
		 */
		public long getNextTime() {
			return nextTime;
		}

		/**
		 * Computes hashcode from type and me.
		 * @see java.lang.Object#hashCode()
		 */
		public int hashCode() {				
			return me.hashCode();
		}

		/**
		 * Set next time for this entry.
		 * @param nextTime
		 */
		void setNextTime( final long nextTime ) {
			this.nextTime = nextTime;
		}



		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		public String toString() {
			final StringBuffer buf = new StringBuffer();
			synchronized ( df ) { // simple date format is not synchronized
				buf.append( df.format( new Date( nextTime ) ) );
			}
			buf.append( ':' );
			try {		
				buf.append( me.getFdn() );
			} catch ( final NullPointerException e ) {
				buf.append( "null" );
			}		
			buf.append( ':' );
			buf.append( interval );		
			return buf.toString();
		}
	}

	/**
	 * Check heartbeat for managed element.
	 */
	private class HBTask implements Runnable{

		/**
		 * Contains supervision entry. This entry should be put back to 
		 * SupervisionControl when task has finished with a new time for
		 * next ping. 
		 */
		private SupervisionEntry se = null;

		public HBTask(final SupervisionEntry se) {
			this.se = se;
		}

		public void run() {			
			// Run heartbeat task for managed element
			if (interrupted) {
				return;
			}
			try {
				LOGGER.debug("About to check heartbeat for: "+se.getManagedElement().getFdn());
				if (ongoingTasks.contains(se) || supervisionElements.contains(se) || badSupervisionElements.contains(se)) {
				se.getManagedElement().checkHeartBeat();
				setState(CorbaManagedElement.STATEESTABLISHED,null,se.getManagedElement());
				} else {
				LOGGER.info("Ignoring as node is not present in any list: {}" , se.getManagedElement().getFdn());
				}
			} catch( final CommunicationFailureException e ) {
				// heartbeat failure
				if (interrupted) {
					return;
				}
				
				if (ongoingTasks.contains(se) || supervisionElements.contains(se) || badSupervisionElements.contains(se)) {
				LOGGER.debug("HB Failed for "+se.getManagedElement().getFdn());
				setState(CorbaManagedElement.STATEFAILED, e.getMessage(),
						se.getManagedElement());
				} else {
				LOGGER.info("Ignoring already started tasks after stop supervision for: {}" , se.getManagedElement().getFdn());
				}
			} catch ( final Exception e ) {
				LOGGER.debug("Unexpected error occured during heartbeat check {} {}",se.getManagedElement().getFdn(),e);
			}
			LOGGER.debug("Done checking heartbeat for: "+se.getManagedElement().getFdn());
			if (interrupted) {
				return;
			}
			// Set-up next ping interval				
			final long interval = se.getManagedElement().getHeartbeatTimeout();
			final long nextTime = System.currentTimeMillis()+interval*1000; // milliseconds
			se.setNextTime( nextTime );	

			// Add next ping to Supervision Control.
			try {			
				putSupervisionElement( se );
			} catch ( final Exception e ) {
			}			

		}

	}
	
	public void setState(final int presentState, final String s,CorbaManagedElement me) {
		EventNotification[] notifications = me.setState(
				presentState, s);
		if (notifications !=null && notifications.length > 0) {
			LOGGER.info("Heart beat state changed for ME: "+me.getFdn() +" EventNotification: "+notifications[0]);
			Exchange exchange = endpoint.createExchange();
			exchange.getIn().setHeader(CorbaExchangeHeaders.HEADER_TYPE,
					CorbaExchangeHeaders.TYPE_ALARM);
			exchange.getIn().setBody(notifications);
			EventModelTranslator eventModelTranslator=new EventModelTranslator();
			eventModelTranslator.process(exchange);
			HBAlarmSender.sendHbAlarm(notifications[0].getManagedObjectInstance() + Constants.DELIMITER + notifications[0].getSeverity());
		}
		
	}

	/**
	 * Controls the while loop in the run method. When true then the thread
	 * running the runnable will exit.
	 */
	private volatile boolean interrupted = false;

	/**
	 * Thread pool that perform the ping tasks.
	 */
	private ExecutorService threadPool = null;

	/**
	 * The minimum wait time. Milliseconds.
	 */
	static final long MINIMUM_WAIT_TIME = 1000; // milliseconds

	/**
	 * Contains all managed elements that a currently being pinged.
	 * This cannot be an ordered list where time attribute is significant.
	 */
	@SuppressWarnings("rawtypes")
	private Set ongoingTasks = null;

	/**
	 * Contains managed element that shall be supervised.
	 */
	@SuppressWarnings("rawtypes")
	private SortedSet supervisionElements = null;

	/**
	 * Contains all managed element that shall be supervised that have 
	 * communication failure problem.
	 *
	 * When there are many elements with communication problem the supervision
	 * mechanism might not have enough resources (threadpool) and time to check 
	 * status for all network elements.
	 */
	@SuppressWarnings("rawtypes")
	private SortedSet badSupervisionElements = null;
	private final HBEndpoint endpoint;

	/**
	 * Create new supervision dispatcher. 
	 * @param supervisionThreadPool
	 */
	@SuppressWarnings("rawtypes")
	public HBDispatcher(final ExecutorService supervisionThreadPool, HBEndpoint endpoint) {
		threadPool = supervisionThreadPool;
		this.endpoint = endpoint;
		supervisionElements = new TreeSet(); // must be ordered on time
		badSupervisionElements = new TreeSet();// must be ordered on time
		ongoingTasks = new HashSet(); // cannot be ordered on time because the time changes		

	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		
		SupervisionEntry se = null;
		Runnable pingTask = null;
		while ( !interrupted) {
			LOGGER.debug("In dispatcher run");
			try {

				// 1. Take first element to ping. 
				// This call will hang until there is an element to return and 
				// when that element should be pinged.
				se = getSupervisionElement();
				
				LOGGER.debug("got manage element for supervision "+se);

				// 2. Create task				
				pingTask = new HBTask( se ); 


				// 3. Assign task to thread pool	or		
				threadPool.execute( pingTask ); 	
				
				LOGGER.debug("Submitted task to pool");

			} catch ( final InterruptedException ie ) {
				break;	// quit thread
			} catch ( final Exception e ) {
			}

			// slight delay before next hb ping
			try {
				Thread.sleep( 25 );
			} catch (final InterruptedException e) {
				break;
			}

		}

	}

	/**
	 * Notify runnable that it should terminate as soon as possible. 
	 */
	synchronized void interrupted() {
		interrupted = true;
	}

	/**
	 * Terminate the this runnable as soon as possible.
	 */
	public void terminate() {
		this.interrupted();
	}

	/**
	 * Remove supervision on all managed elements. 
	 */
	public synchronized void clear() {
		ongoingTasks.clear();
		supervisionElements.clear();
		badSupervisionElements.clear();
	}


	/**
	 * Get first element to ping. The method will wait until there is an element
	 * in queue and the time for the ping
	 * 
	 * @return first element to ping
	 * @exception InterruptedException if interrupted while waiting for element to return
	 */
	@SuppressWarnings("unchecked")
	synchronized SupervisionEntry getSupervisionElement(  ) throws InterruptedException {

		SupervisionEntry se = null;
		while ( true )
		{					
			// 1. Wait until first element shall be pinged.				 
			long timeToPing = Long.MAX_VALUE;
			if ( !badSupervisionElements.isEmpty()) { 
				se = (SupervisionEntry)badSupervisionElements.first();
				timeToPing = se.getNextTime();
			} 

			if ( !supervisionElements.isEmpty()) {
				se = (SupervisionEntry)supervisionElements.first(); 
				timeToPing = Math.min( timeToPing, se.getNextTime() );
			} 

			// wait until time when element shall be pinged			
			timeToPing = timeToPing - System.currentTimeMillis() - MINIMUM_WAIT_TIME;
			LOGGER.debug("Checking time to ping "+timeToPing);
			if ( timeToPing <= 0 ) { // may also be a negative value
				break; // It is time to ping element.
			}

			// wait until time to ping or until notified
			wait( timeToPing ); 
		}// while 

		// 2. Select element to ping. 
		if ( badSupervisionElements.isEmpty() ) { 
			// remove element from list
			supervisionElements.remove(se);
		} 
		else if ( supervisionElements.isEmpty() ) { 
			// remove element from list
			badSupervisionElements.remove(se);
		} 
		else { 
			//Need to ping element based on the value fo the next ping time of the element in near future 
			final SupervisionEntry goodSe = (SupervisionEntry)supervisionElements.first();
			final SupervisionEntry badSe = (SupervisionEntry)badSupervisionElements.first();


			// We removed  the priority for the good element to be pinged in near future.
			//instaed we will compare for the next ping time for both good element and bad element.
			// so for whatever element next ping time is lower, will get the ping chance and will be added to supervision entry.
			// So no priority for the good or bad element
			if (goodSe.getNextTime() < badSe.getNextTime()) {
				se = goodSe;
				//remove element from list
				supervisionElements.remove(se);

			} else {
				se = badSe;
				// remove element from list
				badSupervisionElements.remove(se);
			}
		}		

		// add to ongoing tasks
		ongoingTasks.add( se );

		return se;
	}

	/**
	 * Put entry in supervision element list. 
	 * 
	 * The method check if the entry exist in ongoing tasks. If it does it 
	 * means supervision should continure. If not supervision is stopped and
	 * heartbeat supervision should not continue on managed element.
	 * 
	 * @param entry
	 */
	@SuppressWarnings("unchecked")
	public synchronized void putSupervisionElement( final SupervisionEntry entry ) {		

		final boolean entryRemoved = ongoingTasks.remove( entry );
		if ( entryRemoved ) {
			// entry existed, that means supervision should continue

			// put in bad set if STATE_FAILED
			if ( entry.getManagedElement().getState() == CorbaManagedElement.STATEFAILED ) { 			
				// put element into list
				badSupervisionElements.add(entry);

				// If element is put first in the list then notify to wake the 
				// dispatcher thread.
				if ( entry == badSupervisionElements.first() ) {
					notifyAll();
				}
			} 
			else {
				supervisionElements.add( entry );

				// If element is put first in the list then notify to wake the 
				// dispatcher thread.
				if ( entry == supervisionElements.first() ) {
					notifyAll();
				}							
			}

		} else {
		}
	}

	/**
	 * Remove managed element from heartbeat supervision. Alarm IRP and 
	 * Notification IRP entries are first searched for and removed from the 
	 * supervision elemnts list. If not found there a search is done in the 
	 * ongoing tasks list and if found the tasks are removed.
	 * 	
	 * @param me
	 */
	@SuppressWarnings("rawtypes")
	private synchronized void removeSupervision( final CorbaManagedElement me ) {	

		// remove task(s) from supervision elements list
		Iterator iter = supervisionElements.iterator();
		SupervisionEntry se = null;
		while ( iter.hasNext() ) {
			se = (SupervisionEntry) iter.next();
			if ( me.equals( se.getManagedElement() ) ) {
				iter.remove(); // remove element from list
				LOGGER.debug("Heart beat supervision stopped for: "+me.getFdn());
				return;
			}
		}

		// remove task(s) from bad supervision elements list
		iter = badSupervisionElements.iterator();
		while ( iter.hasNext() ) {
			se = (SupervisionEntry) iter.next();
			if ( me.equals( se.getManagedElement() ) ) {
				iter.remove(); // remove element from list
				LOGGER.debug("Heart beat supervision stopped for: "+me.getFdn());
				return;
			}
		}

		// Managed Element was not found in supervision list. Must be in the
		// ongoing task list.
		iter = ongoingTasks.iterator();
		while( iter.hasNext() ) {
			se = (SupervisionEntry) iter.next();
			if ( me.equals( se.getManagedElement() ) ) {
				iter.remove(); // remove element from list
				LOGGER.debug("Heart beat supervision stopped for: "+me.getFdn());
				return;
			}
		}
	}	

	/**
	 * Start supervision on managed element. Use heartbeat check interval given by 
	 * getHeartbeatCheckInterval() in AbstractManagedElement. 
	 *     
	 * @param me
	 */
	@SuppressWarnings("unchecked")
	public synchronized void startSupervision( final CorbaManagedElement me ) {

		if ( me == null ) {
			throw new NullPointerException( "ManagedElement is null" );
		}

		// First remove supervision if already started
		if ( isSupervised( me ) ) {		
			removeSupervision( me );
		}

		// Set-up heartbeat supervision check		
		final int interval = me.getHeartbeatTimeout();// seconds
		final long nextTime = System.currentTimeMillis()+interval*1000; // milliseconds
		final SupervisionEntry se = new SupervisionEntry(me,interval,nextTime);		



		// add to supervision set
		if ( me.getState()==CorbaManagedElement.STATEFAILED ) {	 	
			badSupervisionElements.add( se );
			// If element is put first in the list then notify. That is, wake the
			// dispatcher thread which is sleeping and would miss this entrys ping 
			// time.  
			if ( se == badSupervisionElements.first() ) {
				notifyAll();
			}
		} else {
			supervisionElements.add( se );
			// If element is put first in the list then notify. That is, wake the
			// dispatcher thread which is sleeping and would miss this entrys ping 
			// time.  
			if ( se == supervisionElements.first() ) {
				notifyAll();
			}
		}
		
		LOGGER.debug("Heart beat supervision started for: "+me.getFdn());

	}


	/**
	 * Check if a managed element is supervised. That is in either supervisionElements, 
	 * badSupervisionElements or in ongoingTasks.
	 *  
	 * @param me
	 */
	@SuppressWarnings("rawtypes")
	private boolean isSupervised( final CorbaManagedElement me ) {		
		if ( me==null ) {
			return false;
		}

		Iterator iter = supervisionElements.iterator();
		SupervisionEntry se = null;

		while ( iter.hasNext() ) {
			se = (SupervisionEntry) iter.next();
			if ( me.equals( se.getManagedElement() ) ) {
				return true;
			}					
		}

		iter = badSupervisionElements.iterator();
		while ( iter.hasNext() ) {
			se = (SupervisionEntry) iter.next();
			if ( me.equals( se.getManagedElement() ) ) {
				return true;
			}					
		}

		iter = ongoingTasks.iterator();
		while ( iter.hasNext() ) {
			se = (SupervisionEntry) iter.next();
			if ( me.equals( se.getManagedElement() ) ) {
				return true;
			}					
		}

		return false;
	}

	/**
	 * Stop heartbeat supervision for managed element.
	 * @param me
	 */
	public synchronized void stopSupervision( final CorbaManagedElement me ) {
		if ( me == null ) {
			throw new NullPointerException( "ManagedElement is null" );
		}
		removeSupervision( me );
	}

}

