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
package com.ericsson.oss.mediation.supervision.corba.synchalarm;

import java.util.ArrayList;
import java.util.Arrays;

import org.omg.CORBA.BooleanHolder;
import org.omg.CosNotification.EventBatchHolder;
import org.omg.CosNotification.StructuredEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.irp.AlarmIRPSystem.*;
import com.ericsson.oss.mediation.supervision.corba.CorbaManagedElement;
import com.ericsson.oss.mediation.supervision.corba.common.IORControl;
import com.ericsson.oss.mediation.supervision.corba.heartbeat.CommunicationFailureException;
import com.ericsson.oss.mediation.supervision.corba.translation.AlarmTranslation;
import com.ericsson.oss.mediation.translator.model.Constants;
import com.ericsson.oss.mediation.translator.model.EventNotification;

public class CorbaSynchronizeEvents {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(CorbaSynchronizeEvents.class);
	private final CorbaManagedElement managedElement;

	public CorbaSynchronizeEvents(final CorbaManagedElement managedElement) {
		this.managedElement = managedElement;
	}

	public EventNotification[] startSync()
			throws SynchronizationAbortedException,
			CommunicationFailureException {
		final EventNotification[] notifications = new EventNotification[1];
		notifications[0] = EventNotification
				.createSynchronizationStartNotification(
						managedElement.getFdn(), managedElement.getSourceType());
		return notifications;
	}

	public String convertFdn(String origfdn) {
		String[] fdnParts = origfdn.split(",");
		if (fdnParts[0].endsWith("_R")) {
			fdnParts[0] = fdnParts[0].substring(0, fdnParts[0].length() - 2);
		}
		String fdn = null;
		for (int j = 0; j < fdnParts.length; j++) {
			if (j == 0) {
				fdn = fdnParts[j];
			} else {
				fdn += "," + fdnParts[j];
			}
		}
		return fdn;
	}

	public EventNotification[] stopSynch() {
		final EventNotification[] notifications = new EventNotification[1];
		notifications[0] = EventNotification
				.createSynchronizationEndNotification(managedElement.getFdn(),
						managedElement.getSourceType());
		return notifications;
	}

	public EventNotification[] abortSynch(String fdn, String sourceType) {
		final EventNotification[] notifications = new EventNotification[1];
		if (managedElement != null) {
			notifications[0] = EventNotification
					.createSynchronizationAbortedNotification(
							managedElement.getFdn(),
							managedElement.getSourceType());
		} else {
			LOGGER.debug("Generating Synch Abort Notification if Start Supervision Fails");
			notifications[0] = EventNotification
					.createSynchronizationAbortedNotification(fdn, sourceType);
		}
		return notifications;
	}

	public EventNotification[] getAlarmSynchList()
			throws SynchronizationAbortedException,
			CommunicationFailureException {
		final BooleanHolder useIter = new BooleanHolder(false);
		final AlarmInformationIteratorHolder iter = new AlarmInformationIteratorHolder();
		final ArrayList<EventNotification> syncAlarmsList = new ArrayList<EventNotification>();
		try {
			StructuredEvent[] synchAlarm = null;
			final String filter = "";
			_AlarmIRPOperations alarmIRPOperations = this
					.getAlarmIRPReference();
			if (alarmIRPOperations == null) {
				LOGGER.info("Alarm IRP reference is not resolved");
			}
			synchAlarm = alarmIRPOperations.get_alarm_list(filter, useIter,
					iter);

			if (useIter.value) {
				syncAlarmsList.addAll(Arrays
						.asList(getSynchEventNotification(synchAlarm)));
			} else {
				final AlarmInformationIterator aiter = iter.value; // AlarmInformation
				EventBatchHolder aseqHolder = new EventBatchHolder();
				boolean moreAlarms;
				do {
					moreAlarms = aiter.next_alarmInformations(
							CorbaManagedElement.PARAM_ALARM_DELAY, aseqHolder);
					synchAlarm = aseqHolder.value;
					syncAlarmsList.addAll(Arrays
							.asList(getSynchEventNotification(synchAlarm)));
				} while (moreAlarms);
				aseqHolder = null;
			}
			// Modification ends
		} catch (final com.ericsson.irp.AlarmIRPSystem.GetAlarmList
				| com.ericsson.irp.AlarmIRPSystem.ParameterNotSupported
				| com.ericsson.irp.AlarmIRPSystem.InvalidParameter e) {
			LOGGER.error(
					"Failed to retreive the Alarm list from agent. Exception: {}  ",
					 e.toString());
			throw new SynchronizationAbortedException(
					"Failed to retreive alarm list from agent.");
		} catch (final Exception e) {
			LOGGER.error(
					"Exception: {} caught when trying to get alarm list from agent. ",
					 e.toString());
			setAlarmIrpStatus(CorbaManagedElement.STATEFAILED);
			throw new SynchronizationAbortedException(
					"Failed to get Alarm IRP.");
		}finally{
			this.managedElement.getSupervision().getIor().removeIRPReferences();
		}
		return (EventNotification[]) syncAlarmsList
				.toArray(new EventNotification[syncAlarmsList.size()]);
	}

	private _AlarmIRPOperations getAlarmIRPReference() {
		return this.managedElement.getSupervision().getIor().getAlarmIRPObj();
	}

	private EventNotification[] getSynchEventNotification(
			final StructuredEvent[] structuredEvent) {
		EventNotification[] eventNotification = null;
		eventNotification = new EventNotification[structuredEvent.length];
		for (int i = 0; i < structuredEvent.length; i++) {

			eventNotification[i] = EventNotification.createEventNotification(managedElement.getSourceType());
			eventNotification[i].setFmEventType(Constants.NOTIF_TYPE_SYNCALARM);
			eventNotification[i] = AlarmTranslation.translateAlarmEvents(
					structuredEvent[i], managedElement , eventNotification[i]);
			eventNotification[i]
					.setManagedObjectInstance(this
							.convertFdn(eventNotification[i]
									.getManagedObjectInstance()));
			eventNotification[i].setFmEventType(Constants.NOTIF_TYPE_SYNCALARM);
		}
		return eventNotification;
	}

	public IORControl getIor() {
		return managedElement.getSupervision().getIor();
	}

	/**
	 * @return the alarmIrpStatus
	 */
	public int getAlarmIrpStatus() {
		return managedElement.getAlarmIRPStatus();
	}

	/**
	 * @param alarmIrpStatus
	 *            the alarmIrpStatus to set
	 */
	public void setAlarmIrpStatus(final int alarmIrpStatus) {
		managedElement.setAlarmIRPStatus(alarmIrpStatus);
	}
}
