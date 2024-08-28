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
package com.ericsson.oss.mediation.supervision.corba.translation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.omg.CORBA.Any;
import org.omg.CosNotification.*;
import org.omg.TimeBase.UtcT;
import org.omg.TimeBase.UtcTHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.irp.AlarmIRPConstDefs.*;
import com.ericsson.irp.NotificationIRPConstDefs.*;
import com.ericsson.oss.mediation.supervision.corba.CorbaManagedElement;
import com.ericsson.oss.mediation.translator.model.Constants;
import com.ericsson.oss.mediation.translator.model.EventNotification;



public class AlarmTranslation {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AlarmTranslation.class);

	public static final long GREGORIAN_EPOCH_MILLIS = 12219292800000L;
	private static final String FM_EVENT_VERSION_1_1 = "1z1";
	private static final String NV_SPECIFIC_EVENT = "z";
	/*private static final String ET_FM_EVENT = "0";
	private static final String NOTIFY_FM_NEW_EVENT = "z1";*/
	public static EventNotification translateAlarmEvents(
			final StructuredEvent structEv, final CorbaManagedElement me , EventNotification notif) {
		//EventNotification myNotif = notif;
		if (structEv != null) {
			if (structEv.header.fixed_header.event_name
					.equals(NOTIFY_FM_ACK_STATE_CHANGED.value)) {
				if (!(notif.getFmEventType() == Constants.NOTIF_TYPE_SYNCALARM)) {
					notif = null;
					return notif;

				}
			}// End of NOTIFY_FM_ACK_STATE_CHANGED

			notif = extractStructEvent(structEv, me);
			if (!isCelloEvent(structEv)
					&& (CorbaManagedElement.PARAM_GENERATE_ALARM_ID)) {
				if (notif.getManagedObjectInstance() != null) {
					final StringBuffer buf = new StringBuffer(
							notif.getManagedObjectInstance());
					buf.append(notif.getEventType());
					buf.append(notif.getProbableCause());
					final String specificProblem = notif.getSpecificProblem();
					if (specificProblem != null) {
						buf.append(specificProblem);
					}
					final int hash = buf.toString().hashCode()
							& (Integer.MAX_VALUE >> 1);
					notif.addAdditionalAttribute("generatedAlarmId",
							Integer.toString(hash));
				}
			}

		} else {
			return null;
		}
		return notif;
	}

	public static boolean isCelloEvent(final StructuredEvent se) {
		return FM_EVENT_VERSION_1_1
				.equals(se.header.fixed_header.event_type.domain_name);
	}

	private static void translateEventName(final StructuredEvent structEvent,
			final EventNotification notification) {
		if (!isCelloEvent(structEvent)) {
			if (structEvent.header.fixed_header.event_name != null) {
				if (structEvent.header.fixed_header.event_name
						.equals(NOTIFY_FM_NEW_ALARM.value)) {
					notification.setFmEventType(Constants.NOTIF_TYPE_ALARM);
				} else if (structEvent.header.fixed_header.event_name
						.equals(NOTIFY_FM_CHANGED_ALARM.value)) {
					notification.setFmEventType(Constants.NOTIF_TYPE_ALARM);
					notification.addAdditionalAttribute("notifyChangedAlarm",
							"true");
				} else if (structEvent.header.fixed_header.event_name
						.equals(NOTIFY_FM_CLEARED_ALARM.value)) {
					notification.setFmEventType(Constants.NOTIF_TYPE_ALARM);
					notification.setSeverity(Constants.SEV_CLEARED);
				} else {
					notification.setFmEventType(Constants.NOTIF_TYPE_ERROR);
				}
			}
		} else {
			notification.setFmEventType(Constants.NOTIF_TYPE_ERROR);
		}
	}

	public static EventNotification extractStructEvent(
			final StructuredEvent structEvent, CorbaManagedElement me) {
		String eventType = structEvent.header.fixed_header.event_type.type_name;
		final Property fd[] = structEvent.filterable_data;
		final EventNotification myNotif = EventNotification
				.createEventNotification(me.getSourceType());
		if ((eventType.length() > 0) && eventType.startsWith("x")) {
			eventType = eventType.substring(1);
			myNotif.setEventType(eventType);
		}
		
		if (structEvent.header.fixed_header.event_name.equals(NOTIFY_FM_ALARM_LIST_REBUILT.value)) {
			createClearAllNotification(myNotif, me.getFdn());
		} else {
		
		for (int i = 0; i < fd.length; i++) {
			try {
				if ((fd[i].name != null) && (fd[i].value != null)) {
					translateAttribute(fd[i].name, fd[i].value, myNotif,isCelloEvent(structEvent));
				}
			} catch (Exception e) {
				LOGGER.error("Exception while retrieving attribute: "
						+ fd[i].name, (Throwable) e);
			}
		}
		translateEventName(structEvent, myNotif);
		if ((myNotif.getExternalEventId().length() == 0)
				|| (myNotif.getExternalEventId().equals(""))) {
			final String newId = myNotif.getManagedObjectInstance()
					+ myNotif.getEventType() + myNotif.getProbableCause()
					+ myNotif.getSpecificProblem();
			myNotif.setExternalEventId(whiteSpaceWasher(newId));
		}
	}
		return myNotif;
	}
	
	/**
     * Sets attributes for CLEARALL notification when alarm list re-built is received from node.
     * 
     * @param eventNotif
     *            eventNotif
     * @param fdn
     *            fdn
     */
    private static void createClearAllNotification(final EventNotification eventNotif, final String fdn) {
        LOGGER.info("Creeating CLEARALL notification for node : {}", fdn);
        eventNotif.setManagedObjectInstance(fdn);
        eventNotif.setFmEventType(Constants.NOTIF_TYPE_CLEARALL);
        eventNotif.setManagedObjectInstance(fdn);
    }

	/**
	 * @param name
	 * @param value
	 * @param myNotif
	 * @param isCello 
	 */
	private static void translateAttribute(final String name, final Any value,
			EventNotification myNotif, boolean isCello) throws ParseException {
		switch (name) {
		case NV_EVENT_TIME.value: {
			final UtcT utct = UtcTHelper.extract(value);
			myNotif.setTime(createTimeString(utct));
			myNotif.setTimeZone("UTC");
			break;
		}
		case NV_MANAGED_OBJECT_INSTANCE.value: {
			myNotif.setManagedObjectInstance(whiteSpaceWasher(value
					.extract_string()));
			break;
		}
		case NV_PERCEIVED_SEVERITY.value: {
			myNotif.setSeverity(AlarmSeverity.getSeverity(value.extract_short()));
			break;
		}
		case NV_PROBABLE_CAUSE.value: {
			myNotif.setProbableCause(String.valueOf(value.extract_short()));
			break;
		}
		case NV_SPECIFIC_PROBLEM.value: {
			myNotif.setSpecificProblem(value.extract_string());
			break;
		}
		case NV_SYSTEM_DN.value: {
			myNotif.setEventAgentId(value.extract_string());
			break;
		}
		case NV_ALARM_ID.value: {
			myNotif.setExternalEventId(value.extract_string());
			break;
		}
		case NV_ACK_TIME.value: {
			UtcT utct = UtcTHelper.extract(value);
			myNotif.setAckTime(createTimeString(utct));
			break;
		}
		case NV_ACK_USER_ID.value: {
			myNotif.setOperator(value.extract_string());
			break;
		}
		case NV_ACK_STATE.value: {
			myNotif.setAcknowledged(value.extract_short() == ACK_STATE_ACKNOWLEDGED.value);
			break;
		}
		case NV_NOTIFICATION_ID.value: {
			myNotif.addAdditionalAttribute("notificationId",
					Integer.toString(value.extract_long()));
			break;
		}
		case NV_BACKED_UP_STATUS.value: {
			myNotif.addAdditionalAttribute("backedUpStatus",
					Boolean.toString(value.extract_boolean()));
			break;
		}
		case NV_BACK_UP_OBJECT.value: {
			myNotif.addAdditionalAttribute("backUpObject",
					value.extract_string());
			break;
		}
		case NV_THRESHOLD_INFO.value: {
			myNotif.addAdditionalAttribute("thresholdInfo",
					Integer.toString(value.extract_long()));
			break;
		}
		case NV_TREND_INDICATION.value: {
			myNotif.addAdditionalAttribute("trendIndication",
					Integer.toString(value.extract_long()));
			break;
		}
		case NV_STATE_CHANGE_DEFINITION.value:
		case NV_MONITORED_ATTRIBUTES.value: {
			break;
		}
		case NV_ACK_SYSTEM_ID.value: {
			myNotif.addAdditionalAttribute("ackSystemId",
					value.extract_string());
			break;
		}
		case NV_ADDITIONAL_TEXT.value: {
			myNotif.addAdditionalAttribute("additionalText",
					value.extract_string());
			break;
		}
		case NV_MANAGED_OBJECT_CLASS.value: {
			myNotif.addAdditionalAttribute("managedObjectClass",
					value.extract_string());
			break;
		}
		case NV_PROPOSED_REPAIR_ACTIONS.value: {
			myNotif.addAdditionalAttribute("proposedRepairActions",
					value.extract_string());
			break;
		}
		case NV_SPECIFIC_EVENT: {
			if (isCello) {
				myNotif.setSpecificProblem(value.extract_string());
			}
			break;
		}
		default:
			try {
				myNotif.addAdditionalAttribute(name, value.toString());
			} catch (final Exception e) {
				LOGGER.error(
						"Exception while setting Up Additional Atrributes: ",
						(Throwable) e);
			}
		}
	}

	private static String createTimeString(final UtcT utcObject)
			throws ParseException {
		final Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
		cal.setTime(new Date((utcObject.time / 10000) - GREGORIAN_EPOCH_MILLIS));

		final SimpleDateFormat timeformat = new SimpleDateFormat(
				"yyyyMMddHHmmss");
		timeformat.setTimeZone(TimeZone.getTimeZone("UTC"));
		return timeformat.format(cal.getTime());

	}

	private static String whiteSpaceWasher(String inString) {
		String returnString = "", token;
		StringTokenizer st = new StringTokenizer(inString, ",", true);
		while (st.hasMoreTokens()) {
			token = st.nextToken();
			token = token.trim();
			returnString = returnString + token;
		}
		st = null;
		inString = null;
		return returnString;
	}

	public static String printStructuredEvent(StructuredEvent notification) {
		final StringBuffer buffer = new StringBuffer();
		try {
			FixedEventHeader fixedHeader = notification.header.fixed_header;
			Property pf[] = notification.filterable_data;
			buffer.append("Notif type:(" + fixedHeader.event_name + ")=");
			if (fixedHeader.event_name.equals(NOTIFY_FM_NEW_ALARM.value)) {
				buffer.append("NOTIFY_FM_NEW_ALARM");
			} else if (fixedHeader.event_name
					.equals(NOTIFY_FM_ACK_STATE_CHANGED.value)) {
				buffer.append("NOTIFY_FM_ACK_STATE_CHANGED");
			} else if (fixedHeader.event_name
					.equals(NOTIFY_FM_ALARM_LIST_REBUILT.value)) {
				buffer.append("NOTIFY_FM_ALARM_LIST_REBUILT");
			} else if (fixedHeader.event_name
					.equals(NOTIFY_FM_CHANGED_ALARM.value)) {
				buffer.append("NOTIFY_FM_CHANGED_ALARM");
			} else if (fixedHeader.event_name
					.equals(NOTIFY_FM_CLEARED_ALARM.value)) {
				buffer.append("NOTIFY_FM_CLEARED_ALARM");
			} else {
				buffer.append("**Not defined**");
			}
			buffer.append(",event type:(" + fixedHeader.event_type.type_name
					+ ")=");
			if (fixedHeader.event_type.type_name
					.equals(ET_COMMUNICATIONS_ALARM.value)) {
				buffer.append("ET_COMMUNICATIONS_ALARM");
			} else if (fixedHeader.event_type.type_name
					.equals(ET_ENVIRONMENTAL_ALARM.value)) {
				buffer.append("ET_ENVIRONMENTAL_ALARM");
			} else if (fixedHeader.event_type.type_name
					.equals(ET_EQUIPMENT_ALARM.value)) {
				buffer.append("ET_EQUIPMENT_ALARM");
			} else if (fixedHeader.event_type.type_name
					.equals(ET_PROCESSING_ERROR_ALARM.value)) {
				buffer.append("ET_PROCESSING_ERROR_ALARM");
			} else if (fixedHeader.event_type.type_name
					.equals(ET_QUALITY_OF_SERVICE_ALARM.value)) {
				buffer.append("ET_QUALITY_OF_SERVICE_ALARM");
			} else {
				buffer.append("**Not defined**");
			}

			buffer.append('\n');
			for (int i = 0; i < pf.length; i++) {
				buffer.append("(" + i + "):" + pf[i].name);
				if (pf[i].name.equals(NV_NOTIFICATION_ID.value)) {
					buffer.append(",NV_NOTIFICATION_ID");
				} else if (pf[i].name.equals(NV_CORRELATED_NOTIFICATIONS.value)) {
					buffer.append(",NV_CORRELATED_NOTIFICATIONS");
				} else if (pf[i].name.equals(NV_EVENT_TIME.value)) {
					buffer.append(",NV_EVENT_TIME");
				} else if (pf[i].name.equals(NV_SYSTEM_DN.value)) {
					buffer.append(",NV_SYSTEM_DN");
				} else if (pf[i].name.equals(NV_MANAGED_OBJECT_CLASS.value)) {
					buffer.append(",NV_MANAGED_OBJECT_CLASS");
				} else if (pf[i].name.equals(NV_MANAGED_OBJECT_INSTANCE.value)) {
					buffer.append(",NV_MANAGED_OBJECT_INSTANCE");
				} else if (pf[i].name.equals(NV_PROBABLE_CAUSE.value)) {
					buffer.append(",NV_PROBABLE_CAUSE");
				} else if (pf[i].name.equals(NV_PERCEIVED_SEVERITY.value)) {
					buffer.append(",NV_PERCEIVED_SEVERITY=");
					switch (pf[i].value.extract_short()) {
					case PS_INDETERMINATE.value:
						buffer.append("PS_INDETERMINATE");
						break;
					case PS_CRITICAL.value:
						buffer.append("PS_CRITICAL");
						break;
					case PS_MAJOR.value:
						buffer.append("PS_MAJOR");
						break;
					case PS_MINOR.value:
						buffer.append("PS_MINOR");
						break;
					case PS_WARNING.value:
						buffer.append("PS_WARNING");
						break;
					case PS_CLEARED.value:
						buffer.append("PS_CLEARED");
						break;
					default:
						buffer.append("*unknown*");
						break;
					}
				} else if (pf[i].name.equals(NV_SPECIFIC_EVENT)) {
					buffer.append(",NV_SPECIFIC_EVENT");
				} else if (pf[i].name.equals(NV_SPECIFIC_PROBLEM.value)) {
					buffer.append(",NV_SPECIFIC_PROBLEM");
				} else if (pf[i].name.equals(NV_ADDITIONAL_TEXT.value)) {
					buffer.append(",NV_ADDITIONAL_TEXT");
				} else if (pf[i].name.equals(NV_ALARM_ID.value)) {
					buffer.append(",NV_ALARM_ID");
				} else if (pf[i].name.equals(NV_ACK_USER_ID.value)) {
					buffer.append(",NV_ACK_USER_ID");
				} else if (pf[i].name.equals(NV_ACK_TIME.value)) {
					buffer.append(",NV_ACK_TIME");
				} else if (pf[i].name.equals(NV_ACK_SYSTEM_ID.value)) {
					buffer.append(",NV_ACK_SYSTEM_ID");
				} else if (pf[i].name.equals(NV_ACK_STATE.value)) {
					buffer.append(",NV_ACK_STATE=");
					switch (pf[i].value.extract_short()) {
					case ACK_STATE_ACKNOWLEDGED.value:
						buffer.append("ACKNOWLEDGED");
						break;

					case ACK_STATE_UNACKNOWLEDGED.value:
						buffer.append("UNACKNOWLEDGED");
						break;

					default:
						buffer.append("(unknown)");
						break;
					}

				} else if (pf[i].name.equals(NV_BACKED_UP_STATUS.value)) {
					buffer.append(",NV_BACKED_UP_STATUS");
				} else if (pf[i].name.equals(NV_BACK_UP_OBJECT.value)) {
					buffer.append(",NV_BACK_UP_OBJECT");
				} else if (pf[i].name.equals(NV_THRESHOLD_INFO.value)) {
					buffer.append(",NV_THRESHOLD_INFO");
				} else if (pf[i].name.equals(NV_TREND_INDICATION.value)) {
					buffer.append(",NV_TREND_INDICATION");
				} else if (pf[i].name.equals(NV_STATE_CHANGE_DEFINITION.value)) {
					buffer.append(",NV_STATE_CHANGE_DEFINITIONS");
				} else if (pf[i].name.equals(NV_MONITORED_ATTRIBUTES.value)) {
					buffer.append(",NV_MONITORED_ATTRIBUTES");
				} else if (pf[i].name.equals(NV_PROPOSED_REPAIR_ACTIONS.value)) {
					buffer.append(",NV_PROPOSED_REPAIRED_ACTIONS");
				} else {
					buffer.append("**Not defined**");
				}
				buffer.append("=" + pf[i].value + "\n");
			}
			// Clean up
			pf = null;
			fixedHeader = null;
			notification = null;

		} catch (final Exception e) {
			LOGGER.info("printStructuredEvent " + buffer.toString()
					+ ". Exception" + e.getMessage() + ","
					+ e.getLocalizedMessage());
			buffer.append(e);
		}
		return buffer.toString();
	}
}
