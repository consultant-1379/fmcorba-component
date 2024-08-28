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
package com.ericsson.oss.mediation.supervision.corba;

import org.omg.CORBA.IntHolder;
import org.omg.CORBA.StringHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.irp.AlarmIRPSystem._AlarmIRPOperations;
import com.ericsson.irp.NotificationIRPConstDefs.SubscriptionState;
import com.ericsson.irp.NotificationIRPConstDefs.SubscriptionStateHolder;
import com.ericsson.irp.NotificationIRPSystem.GetSubscriptionStatus;
import com.ericsson.irp.NotificationIRPSystem.InvalidParameter;
import com.ericsson.irp.NotificationIRPSystem.OperationNotSupported;
import com.ericsson.irp.NotificationIRPSystem._NotificationIRPOperations;
import com.ericsson.oss.mediation.fm.me.AbstractManagedElement;
import com.ericsson.oss.mediation.supervision.corba.common.CorbaSupervision;
import com.ericsson.oss.mediation.supervision.corba.component.CorbaSupervisionEndpoint;
import com.ericsson.oss.mediation.supervision.corba.component.CorbaSupervisionProducer;
import com.ericsson.oss.mediation.supervision.corba.heartbeat.CommunicationFailureException;
import com.ericsson.oss.mediation.translator.model.EventNotification;



public class CorbaManagedElement extends AbstractManagedElement {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(AbstractManagedElement.class);
	public static final String NAMING_URL = "namingUrl";
	public static final String ALARM_IRP_NAMING_CONTEXT = "alarmIRPNamingContext";
	public static final String ALARM_IRP_AGENT_VERSION = "alarmIRPAgentVersion";
	public static final String NOTIFICATION_IRP_NAMING_CONTEXT = "notificationIRPNamingContext";
	public static final String NOTIFICATION_IRP_AGENT_VERSION = "notificationIRPAgentVersion";
	public static final boolean PARAM_GENERATE_ALARM_ID=true;
	public static final String NODE_SECURITY = "nodeSecurityState";
	public static final int PARAM_ALARM_DELAY = 0;
	private String namingUrl;
	private String alarmIrpNamingContext;
	private String alarmIrpAgentVersion;
	private String notifcationIrpNamingContext;
	private String notifcationIrpAgentVersion;
	private CorbaSupervision supervision;
	private boolean secure = false;
	private boolean iPv6Node;

	public static final int STATEESTABLISHED = 1;
	public static final int STATEFAILED = 2;

	private int notificationIRPstatus = STATEESTABLISHED;
	private int alarmIRPStatus = STATEESTABLISHED;
	private int state = STATEESTABLISHED;
	private int alarmIn = 0;
	private long lastCheckTimeMillis = 0;
	private boolean nodeSuspended = false;
	private int stateChanged = 0;
	boolean timerExpired = false;
	private long currentMsec;
	final NodeSuspenderConfiguration nodeSuspender = NodeSuspenderConfiguration.getInstance();
	private CorbaSupervisionProducer producer;

	/**
	 * @return the isSecure
	 */
	public boolean isSecure() {
		return secure;
	}

	/**
	 * @param isSecure the isSecure to set
	 */
	public void setSecure(final boolean isSecure) {
		this.secure = isSecure;
	}

	/**
	 * @return the notificationIRPstatus
	 */
	public int getNotificationIRPstatus() {
		return notificationIRPstatus;
	}

	/**
	 * @param notificationIRPstatus
	 *            the notificationIRPstatus to set
	 */
	public void setNotificationIRPstatus(final int notificationIRPstatus) {
		this.notificationIRPstatus = notificationIRPstatus;
		if (notificationIRPstatus == STATEFAILED) {
			supervision.getIor().removeNotifIRPObj();
		}
	}

	/**
	 * @return the alarmIRPStatus
	 */
	public int getAlarmIRPStatus() {
		return alarmIRPStatus;
	}

	/**
	 * @param alarmIRPStatus
	 *            the alarmIRPStatus to set
	 */
	public void setAlarmIRPStatus(final int alarmIRPStatus) {
		this.alarmIRPStatus = alarmIRPStatus;
		if (alarmIRPStatus == STATEFAILED) {
			supervision.getIor().removeAlarmIRPObj();
		}
	}

	/**
	 * @return the state
	 */
	public int getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	private void setState(final int state) {
		this.state = state;
	}
	/**
	 * @return the alarmIn
	 */
	public int getAlarmIn() {
		return alarmIn;
	}

	/**
	 * @param alarmIn
	 *            the alarmIn to set
	 */
	public void setAlarmIn(int alarmIn) {
		this.alarmIn = alarmIn;
	}
	/*
	 * @return the namingUrl
	 */
	public String getNamingUrl() {
		return namingUrl;
	}

	/**
	 * @param namingUrl
	 *            the namingUrl to set
	 */
	public void setNamingUrl(final String namingUrl) {
		this.namingUrl = namingUrl;
	}

	/**
	 * @return the alarmIrpNamingContext
	 */
	public String getAlarmIrpNamingContext() {
		return alarmIrpNamingContext;
	}

	/**
	 * @param alarmIrpNamingContext
	 *            the alarmIrpNamingContext to set
	 */
	public void setAlarmIrpNamingContext(final String alarmIrpNamingContext) {
		this.alarmIrpNamingContext = alarmIrpNamingContext;
	}

	/**
	 * @return the alarmIrpAgentVersion
	 */
	public String getAlarmIrpAgentVersion() {
		return alarmIrpAgentVersion;
	}

	/**
	 * @param alarmIrpAgentVersion
	 *            the alarmIrpAgentVersion to set
	 */
	public void setAlarmIrpAgentVersion(final String alarmIrpAgentVersion) {
		this.alarmIrpAgentVersion = alarmIrpAgentVersion;
	}

	/**
	 * @return the notifcationIrpNamingContext
	 */
	public String getNotifcationIrpNamingContext() {
		return notifcationIrpNamingContext;
	}

	/**
	 * @param notifcationIrpNamingContext
	 *            the notifcationIrpNamingContext to set
	 */
	public void setNotifcationIrpNamingContext(
			final String notifcationIrpNamingContext) {
		this.notifcationIrpNamingContext = notifcationIrpNamingContext;
	}

	/**
	 * @return the notifcationIrpAgentVersion
	 */
	public String getNotifcationIrpAgentVersion() {
		return notifcationIrpAgentVersion;
	}

	/**
	 * @param notifcationIrpAgentVersion
	 *            the notifcationIrpAgentVersion to set
	 */
	public void setNotifcationIrpAgentVersion(
			final String notifcationIrpAgentVersion) {
		this.notifcationIrpAgentVersion = notifcationIrpAgentVersion;
	}

	/**
	 * @return the supervision
	 */
	public CorbaSupervision getSupervision() {
		return supervision;
	}

	/**
	 * @param supervision
	 *            the supervision to set
	 */
	public void setSupervision(final CorbaSupervision supervision) {
		this.supervision = supervision;
	}

	public EventNotification[] setState(final int presentState, final String s) {
		EventNotification[] eventnotification = new EventNotification[2];
		final boolean flag = getState() != presentState;

		LOGGER.debug("State " + getState());
		LOGGER.debug("presentState " + presentState);
		LOGGER.debug("flag " + flag);
		LOGGER.debug("nodeSuspended in HB check " + nodeSuspended);
		if (flag) {
			if (getState() == CorbaManagedElement.STATEFAILED
					&& presentState == CorbaManagedElement.STATEESTABLISHED) {

				eventnotification[0] = EventNotification
						.createHeartbeatAlarmClearing(getFdn(),
								getSourceType(), s);
				// Clearing Node Suspended Alarm after HB Clear
				if (nodeSuspended == true) {
					LOGGER.info("Node Suspended in HB clear");
					EventNotification[] notifications = checkNodeSuspended(true);
					if (notifications != null && notifications.length > 0) {
						eventnotification[1] = notifications[0];
					}
				}
			} else if (getState() == CorbaManagedElement.STATEESTABLISHED
					&& presentState == CorbaManagedElement.STATEFAILED) {
				setNotificationIRPstatus(STATEFAILED);
				setAlarmIRPStatus(STATEFAILED);
				eventnotification[0] = EventNotification.createHeartbeatAlarm(
						getFdn(), getSourceType(), s);
			}
			setState(presentState);
		}else {
			// Clearing Node Suspended Alarm after HB Clear
			if (nodeSuspended == true) {
				LOGGER.info("Node Suspended in HB clear");
				EventNotification[] notifications = checkNodeSuspended(true);
				eventnotification[0]=notifications[0];
			}
		}

		if(eventnotification[0]!=null && eventnotification[1]!=null){
			return eventnotification;
		}else if(eventnotification[0]!=null && eventnotification[1]==null){
			EventNotification[] eventnotification1 = new EventNotification[1];
			eventnotification1[0]=eventnotification[0];
			return eventnotification1;
		}else if (eventnotification[0]==null && eventnotification[1]!=null) {
			EventNotification[] eventnotification2 = new EventNotification[1];
			eventnotification2[0]=eventnotification[1];
			return eventnotification2;	
		} else {
			return null;
		}

	}
	

	public EventNotification[] checkNodeSuspended(boolean resumeStatusFlag) {
		EventNotification[] eventnotification = new EventNotification[0];

		if(nodeSuspender.getAlarmRateFlowControl()) {

			long currentMillis = System.currentTimeMillis();
			LOGGER.debug("The node suspend alarm Count: {}" , nodeSuspender.getAlarmRateThreshold());
			LOGGER.debug("The value of alarmIn: {} for FDN: {} ",alarmIn,getFdn());
			
			final long interval = nodeSuspender.getAlarmRateCheckInterval();
					

			if (!((currentMillis - lastCheckTimeMillis) < (interval*60000))) {
				reset();
			}

			final boolean currentState = nodeSuspended;
			++alarmIn;
			
			if (currentState) {
				if ((timerExpired || alarmIn < nodeSuspender.getAlarmRateNormalThreshold()) &&stateChanged ==2) {

					eventnotification = new EventNotification[1];
					eventnotification[0] = EventNotification.createNodeResumed(
							getFdn(), getSourceType());
					reset();
					setSuspended(false);
					LOGGER.debug("Node SUspneded CLEAR alarm raised for FDN: {}",getFdn());
				} else {
					LOGGER.debug("The node is already Suspended:{}",getFdn());
				}

			} else {
				if((!currentState && alarmIn > nodeSuspender.getAlarmRateThreshold()) ||stateChanged ==1) {
					eventnotification = new EventNotification[1];
					eventnotification[0] = EventNotification
							.createNodeSuspensed(getFdn(), getSourceType());
					reset();
					setSuspended(true);
					LOGGER.debug("Node SUspneded alarm raised for FDN: {}",getFdn());
				}
			}
		}
		return eventnotification;
	}

	/** 
	 * Resets number of alarms and sets startTime to current time.
	 */
	void reset() {
		if(alarmIn > nodeSuspender.getAlarmRateThreshold()) {
			if(stateChanged!=1 && !isNodeSuspended()){
				stateChanged = 1;
			}
		} else if(alarmIn < nodeSuspender.getAlarmRateNormalThreshold()) {
			if(stateChanged!=2 && isNodeSuspended()){
				stateChanged = 2;
			}
		}
		alarmIn=0;
		lastCheckTimeMillis=System.currentTimeMillis();
		timerExpired = true;
		LOGGER.debug("Node suspenser timer and alarm count resetting for FDN: {}",getFdn());
	} 


	public void computeSecurityState() {
		setSecure(getSupervision().getIor().isNodeSecure());
	}

	public void checkHeartBeat() throws CommunicationFailureException {
		try {
			_NotificationIRPOperations notificationIRP = this
					.getNotificationIRPReference();
			if (notificationIRP != null) {
				if (getSupervision().getSubscriptionId() == null) {
					getSupervision().reattachConsumer();
				}
				final SubscriptionStateHolder subscriptionState = new SubscriptionStateHolder(
						SubscriptionState.DontKnow);
				final StringHolder filterInEffect = new org.omg.CORBA.StringHolder(
						getFilterInfo());
				final IntHolder timeInterval = new org.omg.CORBA.IntHolder(
						CorbaSupervisionEndpoint.TICKMODIFIER);
				final String subscriptionId = getSupervision()
						.getSubscriptionId();
				try {
					LOGGER.debug("get_subscription_status (subscriptionId: "+subscriptionId+" ,filterInEffect: "+filterInEffect+" ,subscriptionState: "+subscriptionState+" ,timeInterval: "+timeInterval);

					notificationIRP.get_subscription_status(subscriptionId,
							filterInEffect, subscriptionState, timeInterval);

					LOGGER.debug("Subscrition status is "+subscriptionState.value.value() + " for "+getFdn());

					if (subscriptionState.value.value() == SubscriptionState._Inactive) {

						throw new GetSubscriptionStatus("Subscription "
								+ subscriptionId + " is inactive.");
					}
					setNotificationIRPstatus(CorbaManagedElement.STATEESTABLISHED);
				} catch (GetSubscriptionStatus | OperationNotSupported | InvalidParameter e) {
					getSupervision().reattachConsumer();
					producer.initiateSync(this);
				} catch (Exception e) {
					setNotificationIRPstatus(CorbaManagedElement.STATEFAILED);
					setAlarmIRPStatus(CorbaManagedElement.STATEFAILED);
					throw new CommunicationFailureException(e.getMessage());
				}
			} else {
				setNotificationIRPstatus(CorbaManagedElement.STATEFAILED);
				setAlarmIRPStatus(CorbaManagedElement.STATEFAILED);
				throw new CommunicationFailureException(
						"Failed to resolve Notification IRP");
			}
			if (this.getNotificationIRPstatus() == CorbaManagedElement.STATEESTABLISHED) {
				_AlarmIRPOperations alarmIRPReference = this
						.getAlarmIRPReference();
				if (alarmIRPReference != null) {
					try {
						alarmIRPReference.get_alarm_IRP_version();
						LOGGER.debug("Alarm IRP is fine for "+getFdn());
						setAlarmIRPStatus(CorbaManagedElement.STATEESTABLISHED);
					} catch (Exception e) {
						setNotificationIRPstatus(CorbaManagedElement.STATEFAILED);
						setAlarmIRPStatus(CorbaManagedElement.STATEFAILED);
						throw new CommunicationFailureException(e.getMessage());
					}
				} else {
					setAlarmIRPStatus(CorbaManagedElement.STATEFAILED);
					throw new CommunicationFailureException(
							"Failed to resolve Alarm IRP");
				}
			} else {
				setAlarmIRPStatus(CorbaManagedElement.STATEFAILED);
				throw new CommunicationFailureException(
						"Failed to resolve Notification IRP");
			}
		} finally {
			getSupervision().getIor().removeIRPReferences();
		}

	}

	public _NotificationIRPOperations getNotificationIRPReference() {
		_NotificationIRPOperations notificationIRPOperations = null;
		if(!getSupervision().getIor().isSecurityStateComputed()){
			computeSecurityState();
		}

		if (getSupervision().getIor().isSecurityStateComputed()) {
			try {
				notificationIRPOperations = getSupervision().getIor()
						.getNotifIrpObj();
				if (notificationIRPOperations != null) {
					setNotificationIRPstatus(CorbaManagedElement.STATEESTABLISHED);
				} else {
					setNotificationIRPstatus(CorbaManagedElement.STATEFAILED);
					setAlarmIRPStatus(CorbaManagedElement.STATEFAILED);
				}
			} catch (final Exception e) {
				setNotificationIRPstatus(CorbaManagedElement.STATEFAILED);
				setAlarmIRPStatus(CorbaManagedElement.STATEFAILED);
			}
		}

		return notificationIRPOperations;
	}

	public _AlarmIRPOperations getAlarmIRPReference() {
		_AlarmIRPOperations alarmIRPOperations = null;
		try {
			alarmIRPOperations = getSupervision().getIor().getAlarmIRPObj();
			if (alarmIRPOperations == null) {
				setAlarmIRPStatus(CorbaManagedElement.STATEFAILED);
			}
		} catch (final Exception e) {
		}
		return alarmIRPOperations;
	}

	public boolean isIPv6Node()
	{
		return iPv6Node;
	}

	public void setIPv6Node(boolean iPv6Node)
	{
		this.iPv6Node = iPv6Node;
	}
	
	/**
     * @return the currentMsec
     */
    public long getCurrentMsec() {
        return currentMsec;
    }

    /**
     * @param currentMsec
     *            the currentMsec to set
     */
    public void setCurrentMsec(long currentMsec) {
        this.currentMsec = currentMsec;
    }

    /**
     * @param producer
     *            the producer to set
     */
    public void setProducer(final CorbaSupervisionProducer producer) {
        this.producer = producer;
    }

	public void computeIPStack()
	{
		boolean iPv6Node = false;
		int numberofColon = getNamingUrl().replaceAll("[^:]", "").length();
		if(numberofColon > 2)
			iPv6Node = true;
		setIPv6Node(iPv6Node);
	}

	@Override
	public boolean equals(final Object obj){
		if ( (obj != null) && (obj instanceof CorbaManagedElement)){
			final CorbaManagedElement me = (CorbaManagedElement) obj;
			if(me.getFdn().equals(this.getFdn())){
				return true;
			}
		}

		return false;
	}

	@Override
	public int hashCode(){
		int hash = 7;
		hash = 31 * hash + (null == this.getFdn() ? 0 : this.getFdn().hashCode());
		return hash;


	}

	public boolean isNodeSuspended() {
		return nodeSuspended;
	}

	private void setSuspended(boolean nodeSuspended) {
		this.nodeSuspended = nodeSuspended;
	}

	@Override
	public String toString() {
		return "CorbaManagedElement [namingUrl=" + namingUrl
				+ ", alarmIrpNamingContext=" + alarmIrpNamingContext
				+ ", alarmIrpAgentVersion=" + alarmIrpAgentVersion
				+ ", isSecure=" + secure
				+ ", notifcationIrpNamingContext="
				+ notifcationIrpNamingContext + ", notifcationIrpAgentVersion="
				+ notifcationIrpAgentVersion + ", supervision=" + supervision
				+ ", notificationIRPstatus=" + notificationIRPstatus
				+ ", alarmIRPStatus=" + alarmIRPStatus + ", state=" + state
				+ ", toString()=" + super.toString() + "]";
	}




}
