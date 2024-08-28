/*------------------------------------------------------------------------------
 *******************************************************************************
 * COPYRIGHT Ericsson 2013
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *******************************************************************************
 *----------------------------------------------------------------------------*/
package com.ericsson.oss.mediation.supervision.corba.common;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.irp.NotificationIRPSystem._NotificationIRPOperations;
import com.ericsson.oss.mediation.supervision.corba.CorbaManagedElement;
import com.ericsson.oss.mediation.supervision.corba.PushConsumer;
import com.ericsson.oss.mediation.supervision.corba.component.CorbaSupervisionEndpoint;
import com.ericsson.oss.mediation.supervision.corba.component.CorbaSupervisionProducer;
import com.ericsson.oss.mediation.supervision.corba.heartbeat.CommunicationFailureException;
import com.ericsson.oss.mediation.supervision.corba.orbinitialize.OrbInitializer;
import com.ericsson.oss.mediation.supervision.corba.util.Constants;
import com.ericsson.oss.mediation.supervision.corba.util.HBAlarmSender;
import com.ericsson.oss.mediation.translator.model.EventNotification;


public class CorbaSupervision {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CorbaSupervision.class);
	private Processor processor;
	private Exchange exchange;
	private org.omg.CORBA.Object secureServent;
	private org.omg.CORBA.Object unsecureServent;
	private IORControl ior;
	private OrbInitializer orbInit;
	private CorbaManagedElement managedElement;
	private String subscriptionId = "";
	private static final int DEFAULT_COMMUNICATION_TIMEOUT = 30;
	private static final int MAX_TICK_ACCORDING_TO_SPECIFICATION = 15;
	private static final int DEFAULT_TICK_MODIFIER = 2;
	private int communicationTimeout = DEFAULT_COMMUNICATION_TIMEOUT;
	private int tickModifier = DEFAULT_TICK_MODIFIER;

	public CorbaSupervision() {

	}

	public CorbaSupervision(final CorbaManagedElement managedElement,
			final OrbInitializer orbInit) {
		this.orbInit = orbInit;
		this.managedElement = managedElement;
		this.ior = new IORControl(managedElement, orbInit);
	}

	public IORControl getIor() {
		LOGGER.debug("ior:"+ior);
		return ior;
	}

	private _NotificationIRPOperations getNotificationIRP() {
		LOGGER.debug("_NotificationIRPOperations:"+ior.getNotifIrpObj());
		return ior.getNotifIrpObj();

	}

	public Processor getProcessor() {
		return processor;
	}

	public Exchange getExchange() {
		return exchange;
	}

	public void unsubscribe() {
		if (subscriptionId != null) {
		LOGGER.info("Detaching subscription id : {} for fdn: {}", subscriptionId, managedElement.getFdn());
			try {
				_NotificationIRPOperations notifIRP = getNotificationIRP();
				if (managedElement.isSecure()) {
					notifIRP.detach(secureServent, subscriptionId);
				} else {
					notifIRP.detach(unsecureServent, subscriptionId);
				}
			} catch (Exception e) {
				LOGGER.error("Unscribe failed for node : {} and exception is: {}", managedElement.getFdn() , e.toString());
			}finally{
				subscriptionId = null;
				ior.removeIRPReferences();
			}
		}
	}

	public void stopSupervision() {
		unsubscribe();
		removeServents();
		final EventNotification[] notifications = managedElement.setState(
				CorbaManagedElement.STATEESTABLISHED, null);
		if(notifications !=null && notifications.length > 0){
			CorbaSupervisionProducer.forwardEvents(notifications,
					managedElement, exchange.getFromEndpoint());
		    HBAlarmSender.sendHbAlarm(notifications[0].getManagedObjectInstance() + Constants.DELIMITER + notifications[0].getSeverity());
		}else{
			LOGGER.info("notification is null");
		}
	}

	public void reattachConsumer() throws CommunicationFailureException {
		LOGGER.info("Reattaching consume for node: {}"+ managedElement.getFdn());
		unsubscribe();
		subscribe();

	}

	public void removeServents() {
		try {
			if (orbInit.getSecurePOA(managedElement.isIPv6Node()) != null) {
				orbInit.getSecurePOA(managedElement.isIPv6Node()).deactivate_object(
						orbInit.getSecurePOA(managedElement.isIPv6Node()).reference_to_id(secureServent));
			}
			if (orbInit.getUnsecurePOA(managedElement.isIPv6Node()) != null) {
				orbInit.getUnsecurePOA(managedElement.isIPv6Node()).deactivate_object(
						orbInit.getUnsecurePOA(managedElement.isIPv6Node()).reference_to_id(
								unsecureServent));
			}
		} catch (Exception e) {
			LOGGER.error("Error during removeServents: {}" , e.toString());
		}
	}

	public EventNotification[] startSupervision() {
		EventNotification[] notifications = null;
		try {
			createServents();
			subscribe();
		} catch (Exception e) {
			notifications = managedElement.setState(
					CorbaManagedElement.STATEFAILED, e.getMessage());
			LOGGER.info("Could not attach consumer to Node. FDN: {}",
					managedElement.getFdn());

			if (notifications!=null && notifications.length > 0) {
				LOGGER.info(
						"Heartbeat alarm will be raised and reattach will be attempt when HB alarm clears. FDN {},+alarm: {}"+
								managedElement.getFdn()+ notifications[0].toString());
			}
		}
		LOGGER.info(
				"Supervision Started on node  FDN: {}, Subscription ID: {}",
				managedElement.getFdn(), subscriptionId);
		return notifications;
	}

	/**
	 * 
	 */
	private void subscribe() throws CommunicationFailureException {
		final String[] notificationCategory = new String[] { "1f1" };
			org.omg.CORBA.Object servent = unsecureServent;
			String message = "";
			_NotificationIRPOperations notifIRP = null;

			try{
				notifIRP = getNotificationIRP();
				subscriptionId = notifIRP.attach_push(servent,
						this.getNotificationTick(), notificationCategory,
						"");
			}
			catch(Exception e) {
				LOGGER.error("Exception: {} during subscribe operation for unsecureServent for fdn: {} ",e.toString(),managedElement.getFdn());
				managedElement.setSecure(true);
				getIor().setSecurityStateComputed(false);
				if(notifIRP!=null) {
				message = e.toString();
				} else {
				    message =Constants.NOTIF_IRP_ERROR;
				}
			}finally{
				ior.removeIRPReferences();
			}

			try{
				if(managedElement.isSecure()){
					notifIRP = getNotificationIRP();
					subscriptionId = notifIRP.attach_push(secureServent,
							this.getNotificationTick(), notificationCategory,
							"");
				}
			}catch(Exception e){
				LOGGER.error("Exception: {} during subscribe operation for secureServent: {} ",e.toString(),managedElement.getFdn());
				getIor().setSecurityStateComputed(false);
				if(notifIRP!=null) {
				message = e.toString();
				} else {
				    message =Constants.NOTIF_IRP_ERROR;
				}
			}finally{
				ior.removeIRPReferences();
			}

			LOGGER.debug("Servent Registerd: " + servent+"subscriptionId:"+subscriptionId);
			
		
			if(subscriptionId.length() == 0 || subscriptionId == null) {
			subscriptionId = null;
			throw new CommunicationFailureException(message);
			}
			
	}

	/**
	 * 
	 */
	private void createServents() {
		final PushConsumer unsecurePushConsumer = new PushConsumer(managedElement, processor,
				exchange);
		final PushConsumer securePushConsumer = new PushConsumer(managedElement, processor,
				exchange);
		try {

			orbInit.getUnsecurePOA(managedElement.isIPv6Node()).activate_object(unsecurePushConsumer);
			unsecureServent = orbInit.getUnsecurePOA(managedElement.isIPv6Node()).servant_to_reference(unsecurePushConsumer);


		} catch (Exception e) {
			managedElement.setSecure(true);
			getIor().setSecurityStateComputed(true);
			LOGGER.error("Could not activate PushConsumer for FDN="
					+ managedElement.getFdn()+ (Throwable) e);
		}
		
		try {

			orbInit.getSecurePOA(managedElement.isIPv6Node()).activate_object(securePushConsumer);
			secureServent = orbInit.getSecurePOA(managedElement.isIPv6Node()).servant_to_reference(securePushConsumer);
		} catch (Exception e) {
			managedElement.setSecure(false);
			getIor().setSecurityStateComputed(true);
			LOGGER.error("Could not activate Secured PushConsumer for FDN="
					+ managedElement.getFdn(), (Throwable) e);
		}
		LOGGER.debug("unsecureServent: " + unsecureServent+"secureServent:"+secureServent);
	}

	/**
	 * @param processor
	 */
	public void setProcessor(final Processor processor) {
		this.processor = processor;
	}

	/**
	 * @param createExchange
	 */
	public void setExchange(final Exchange exchange) {
		this.exchange = exchange;
	}

	/**
	 * @return the subscriptionId
	 */
	public String getSubscriptionId() {
		return subscriptionId;
	}

	// For Time Tick
	public int getNotificationTick() {
		int tick = 0;
		tickModifier = CorbaSupervisionEndpoint.TICKMODIFIER;
		communicationTimeout = managedElement.getCommunicationTimeout();
		if (communicationTimeout <= 0) {
			communicationTimeout = DEFAULT_COMMUNICATION_TIMEOUT;
		}
		if (communicationTimeout > (MAX_TICK_ACCORDING_TO_SPECIFICATION - 1) * 60) {
			communicationTimeout = ((MAX_TICK_ACCORDING_TO_SPECIFICATION - 1) * 60);
		}
		tick = Math.round(tickModifier * communicationTimeout / 60);

		if (tick > MAX_TICK_ACCORDING_TO_SPECIFICATION) {
			tick = MAX_TICK_ACCORDING_TO_SPECIFICATION;
		}
		return tick;
	}
}
