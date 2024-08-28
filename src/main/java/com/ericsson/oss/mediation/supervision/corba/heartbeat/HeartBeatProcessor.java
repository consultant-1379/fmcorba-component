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

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.omg.CORBA.IntHolder;
import org.omg.CORBA.StringHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.irp.AlarmIRPSystem._AlarmIRPOperations;
import com.ericsson.irp.NotificationIRPConstDefs.SubscriptionState;
import com.ericsson.irp.NotificationIRPConstDefs.SubscriptionStateHolder;
import com.ericsson.irp.NotificationIRPSystem.*;
import com.ericsson.oss.mediation.supervision.corba.CorbaExchangeHeaders;
import com.ericsson.oss.mediation.supervision.corba.CorbaManagedElement;
import com.ericsson.oss.mediation.supervision.corba.common.IORControl;
import com.ericsson.oss.mediation.supervision.corba.component.CorbaSupervisionEndpoint;
import com.ericsson.oss.mediation.translator.model.EventNotification;


public class HeartBeatProcessor implements Processor {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(HeartBeatProcessor.class);

	private CorbaManagedElement managedElement;

	public HeartBeatProcessor(final CorbaManagedElement managedElement) {
		this.managedElement = managedElement;
	}

	public int getNotificationIRPstatus() {
		return managedElement.getNotificationIRPstatus();
	}

	public int getAlarmIRPstatus() {
		return managedElement.getAlarmIRPStatus();
	}

	private void setNotificationIRPstatus(final int irpStatus) {
		managedElement.setNotificationIRPstatus(irpStatus);
	}

	private void setAlarmIRPstatus(final int irpStatus) {
		managedElement.setAlarmIRPStatus(irpStatus);
	}

	private IORControl getIor() {
		return managedElement.getSupervision().getIor();
	}

	public void checkHeartBeat() throws CommunicationFailureException {
		try {
			_NotificationIRPOperations notificationIRP = this
					.getNotificationIRPReference();
			LOGGER.info("notificationIRP Reference {}", notificationIRP
					+ " ME=" + managedElement);
			if (notificationIRP != null) {
				if (managedElement.getSupervision().getSubscriptionId() == null) {
					LOGGER.info("Notification IRP reference obtained but no subscription present. Reattaching consumer");
					managedElement.getSupervision().reattachConsumer();
				}
				final SubscriptionStateHolder subscriptionState = new SubscriptionStateHolder(
						SubscriptionState.DontKnow);
				final StringHolder filterInEffect = new org.omg.CORBA.StringHolder(
						managedElement.getFilterInfo());
				final IntHolder timeInterval = new org.omg.CORBA.IntHolder(
						CorbaSupervisionEndpoint.TICKMODIFIER);
				final String subscriptionId = managedElement.getSupervision()
						.getSubscriptionId();
				LOGGER.info("subscriptionId", subscriptionId);
				try {

					notificationIRP.get_subscription_status(subscriptionId,
							filterInEffect, subscriptionState, timeInterval);

					if (subscriptionState.value.value() == SubscriptionState._Inactive) {
						LOGGER.info("Subscription is inactive");

						throw new GetSubscriptionStatus("Subscription "
								+ subscriptionId + " is inactive.");
					}
				} catch (GetSubscriptionStatus | OperationNotSupported e) {
					managedElement.getSupervision().reattachConsumer();
					// TODO: Should we auto initiate a synchronize here?
					LOGGER.info(
							"Could not get subscription status for FDN: {}. Exception {}",
							managedElement.getFdn(), e);
					

				} catch (Exception e) {
					setNotificationIRPstatus(CorbaManagedElement.STATEFAILED);
					setAlarmIRPstatus(CorbaManagedElement.STATEFAILED);
					throw new CommunicationFailureException(e.getMessage());
				}
				setNotificationIRPstatus(CorbaManagedElement.STATEESTABLISHED);
			} else {
				setNotificationIRPstatus(CorbaManagedElement.STATEFAILED);
				setAlarmIRPstatus(CorbaManagedElement.STATEFAILED);
				throw new CommunicationFailureException(
						"Failed to resolve Notification IRP");
			}
			if (this.getNotificationIRPstatus() == CorbaManagedElement.STATEESTABLISHED) {
				_AlarmIRPOperations alarmIRPReference = this
						.getAlarmIRPReference();
				if (alarmIRPReference != null) {
					try {
						alarmIRPReference.get_alarm_IRP_version();
						setAlarmIRPstatus(CorbaManagedElement.STATEESTABLISHED);
					} catch (Exception e) {
						LOGGER.error(
								"Failed to Resolve AlarmIRPReference for FDN: "
										+ managedElement.getFdn(),
								(Throwable) e);
						setNotificationIRPstatus(CorbaManagedElement.STATEFAILED);
						setAlarmIRPstatus(CorbaManagedElement.STATEFAILED);
						throw new CommunicationFailureException(e.getMessage());
					}
				} else {
					setAlarmIRPstatus(CorbaManagedElement.STATEFAILED);
					throw new CommunicationFailureException(
							"Failed to resolve Alarm IRP");
				}
			} else {
				setAlarmIRPstatus(CorbaManagedElement.STATEFAILED);
				throw new CommunicationFailureException(
						"Failed to resolve Notification IRP");
			}
		} finally {
			getIor().removeIRPReferences();
		}

	}

	public _NotificationIRPOperations getNotificationIRPReference() {
		_NotificationIRPOperations notificationIRPOperations = null;
		try {
			notificationIRPOperations = getIor().getNotifIrpObj();
			if (notificationIRPOperations != null) {
				setNotificationIRPstatus(CorbaManagedElement.STATEESTABLISHED);
			} else {
				setNotificationIRPstatus(CorbaManagedElement.STATEFAILED);
				setAlarmIRPstatus(CorbaManagedElement.STATEFAILED);
			}
		} catch (final Exception e) {
			LOGGER.error(
					"Failed to resolve NotificationIRPReference for node with FDN: " + managedElement.getFdn(),
					(Throwable) e);
			setNotificationIRPstatus(CorbaManagedElement.STATEFAILED);
			setAlarmIRPstatus(CorbaManagedElement.STATEFAILED);
		}
		LOGGER.info("notificationIRPOperations", notificationIRPOperations);

		return notificationIRPOperations;
	}

	public _AlarmIRPOperations getAlarmIRPReference() {
		_AlarmIRPOperations alarmIRPOperations = null;
		try {
			alarmIRPOperations = getIor().getAlarmIRPObj();
			if (alarmIRPOperations == null) {
				setAlarmIRPstatus(CorbaManagedElement.STATEFAILED);
			}
		} catch (final Exception e) {
			LOGGER.error(
					"Failed to resolve Alarm IRP reference for Node with FDN: " + managedElement.getFdn(),
					(Throwable) e);
		}
		LOGGER.info("alarmIRPOperations", alarmIRPOperations);
		return alarmIRPOperations;
	}

	public void setState(final int presentState, final String s,
			final Exchange exchange) {
		EventNotification[] notifications = managedElement.setState(
				presentState, s);
		if (notifications.length > 0) {
			exchange.getIn().setHeader(CorbaExchangeHeaders.HEADER_TYPE,
					CorbaExchangeHeaders.TYPE_ALARM);
			exchange.getIn().setBody(notifications);
		}
	}

	@Override
	public void process(final Exchange exchange) {
		if (managedElement.getFdn().equals(
				exchange.getProperty(Exchange.TIMER_NAME))) {
			exchange.getIn().setHeader(CorbaExchangeHeaders.HEADER_TYPE,
					CorbaExchangeHeaders.TYPE_NONE);
			exchange.getIn().setBody("unused");

			try {
				checkHeartBeat();
				setState(CorbaManagedElement.STATEESTABLISHED, null, exchange);
			} catch (Exception e) {

				setState(CorbaManagedElement.STATEFAILED, e.getMessage(),
						exchange);
				LOGGER.info("Heartbeat Failed for node: {}. Exception {}",
						managedElement.getFdn(), e);
			}

		} else {
			exchange.getIn().setHeader(CorbaExchangeHeaders.HEADER_TYPE,
					CorbaExchangeHeaders.TYPE_NONE);
			exchange.getIn().setBody("unused");

		}
	}
}
