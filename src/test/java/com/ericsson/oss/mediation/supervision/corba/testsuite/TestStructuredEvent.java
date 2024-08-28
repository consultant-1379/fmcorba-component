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
package com.ericsson.oss.mediation.supervision.corba.testsuite;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.jacorb.orb.ORB;
import org.omg.CORBA.Any;
import org.omg.CosNotification.*;
import org.omg.Security.UtcTHelper;
import org.omg.TimeBase.UtcT;

import com.ericsson.irp.AlarmIRPConstDefs.*;
import com.ericsson.irp.NotificationIRPConstDefs.*;
import com.ericsson.oss.mediation.supervision.corba.CorbaManagedElement;
import com.ericsson.oss.mediation.supervision.corba.translation.AlarmTranslation;
import com.ericsson.oss.services.fm.service.alarm.AlarmNotification;
import com.ericsson.oss.services.fm.service.util.DPSConstants;

public class TestStructuredEvent {
	private static final int notificId = 1;
	private static final String specificProblem = "General alarm";
	private static final String managedObjectInst = "TopologyRoot=ONRM_ROOT_MO,ResourceGroup=RNC1,MeContext=TESTCORBA";
	private static final String MANAGED_OBJECT_CLASS = "ManagedElement";
	private static final long GREGORIAN_EPOCH_MILLIS = 12219292800000L;
	final static SimpleDateFormat timeformat = new SimpleDateFormat(
			"yyyyMMddHHmmss");

	public static StructuredEvent[] createTestStructuredEvent(final String fdn,
			final ORB orb) {
		final StructuredEvent alarm = new StructuredEvent();
		final EventType type = new EventType(ALARM_IRP_VERSION_1_1.value,
				ET_COMMUNICATIONS_ALARM.value);

		final FixedEventHeader fixed = new FixedEventHeader(type,
				NOTIFY_FM_NEW_ALARM.value);
		final short probableCause = PC_COOLING_SYSTEM_FAILURE.value;
		final short perceivedSeverity = PS_CRITICAL.value;

		final Property variable[] = new Property[0];
		final Any data = orb.create_any();
		data.insert_long(12);

		final Property alarmIdHolder = new Property();
		final Property eventTimeHolder = new Property();
		final Property perceivedSeverityHolder = new Property();
		final Property specificProblemHolder = new Property();
		final Property probableCauseHolder = new Property();
		final Property notificationIdHolder = new Property();
		final Property managedObjectInstance = new Property();
		final Property managedObjectClass = new Property();
		final Property correlation = new Property();

		final Property[] filterableData = { alarmIdHolder, eventTimeHolder,
				probableCauseHolder, perceivedSeverityHolder,
				specificProblemHolder, notificationIdHolder,
				managedObjectInstance, managedObjectClass, correlation };

		filterableData[0].name = "";
		filterableData[0].value = orb.create_any();
		filterableData[0].value.insert_string("");

		// EventTime is a UtcT struct, defined in org.omg.TimeBase.idl
		// Set the time attribute to the number of 100 nanoseconds since
		// 1582-10-15 00:00:00 UTC
		final UtcT utcTime = new UtcT();
		utcTime.time = (System.currentTimeMillis() + GREGORIAN_EPOCH_MILLIS) * 10000;
		utcTime.tdf = 0;

		filterableData[1].name = NV_EVENT_TIME.value;
		filterableData[1].value = orb.create_any();
		UtcTHelper.insert(filterableData[1].value, utcTime);

		filterableData[2].name = NV_PROBABLE_CAUSE.value;
		filterableData[2].value = orb.create_any();
		filterableData[2].value.insert_short(probableCause);

		filterableData[3].name = NV_PERCEIVED_SEVERITY.value;
		filterableData[3].value = orb.create_any();
		filterableData[3].value.insert_short(perceivedSeverity);

		filterableData[4].name = NV_SPECIFIC_PROBLEM.value;
		filterableData[4].value = orb.create_any();
		filterableData[4].value.insert_string(specificProblem);

		filterableData[5].name = NV_NOTIFICATION_ID.value;
		filterableData[5].value = orb.create_any();
		filterableData[5].value.insert_long(notificId);

		filterableData[6].name = NV_MANAGED_OBJECT_INSTANCE.value;
		filterableData[6].value = orb.create_any();
		filterableData[6].value.insert_string(managedObjectInst);

		filterableData[7].name = NV_MANAGED_OBJECT_CLASS.value;
		filterableData[7].value = orb.create_any();
		filterableData[7].value.insert_string("ManagedElement");

		filterableData[8].name = NV_CORRELATED_NOTIFICATIONS.value;
		filterableData[8].value = orb.create_any();
		final int[] notifId = { 1, 2 };
		final CorrelatedNotification[] corr = { new CorrelatedNotification(
				"SOURCE1", notifId) };
		CorrelatedNotificationSetTypeHelper.insert(filterableData[8].value,
				corr);

		alarm.header = new EventHeader(fixed, variable);
		alarm.filterable_data = filterableData;
		alarm.remainder_of_body = data;

		final StructuredEvent[] structuEventArray = new StructuredEvent[] { alarm };
		AlarmTranslation.printStructuredEvent(structuEventArray[0]);
		return structuEventArray;
	}

	public static void checkAlarm(AlarmNotification alarm) {
		Assert.assertEquals("URAN", alarm.getSourceType());
		try {
			Assert.assertNotNull(timeformat.parse(alarm.getTheTime()));
		} catch (ParseException e) {
			Assert.fail("Time format not correct in alarm");
		}
		Assert.assertEquals("UTC", alarm.getTimeZone());
		Assert.assertEquals("CRITICAL", alarm.getPerceivedSeverity());
		// Translator Generated.
		Assert.assertEquals(
				"TopologyRoot=ONRM_ROOT_MO,ResourceGroup=RNC1,MeContext=TESTCORBA",
				alarm.getNodeAddress());
		Assert.assertEquals("General alarm", alarm.getSpecificProblem());
		Assert.assertEquals("549", alarm.getProbableCause());
	}

	public static StructuredEvent[] createTestStructuredEventOne(
			final String fdn, final ORB orb) {
		final StructuredEvent alarm = new StructuredEvent();
		final EventType type = new EventType(ALARM_IRP_VERSION_1_1.value,
				ET_COMMUNICATIONS_ALARM.value);
		final FixedEventHeader fixed = new FixedEventHeader(type,
				NOTIFY_FM_NEW_ALARM.value);
		final short probableCause = PC_COOLING_FAN_FAILURE.value;
		final short perceivedSeverity = PS_MAJOR.value;

		final Property variable[] = new Property[0];
		final Any data = orb.create_any();
		data.insert_long(12);

		final Property alarmIdHolder = new Property();
		final Property eventTimeHolder = new Property();
		final Property perceivedSeverityHolder = new Property();
		final Property specificProblemHolder = new Property();
		final Property probableCauseHolder = new Property();
		final Property notificationIdHolder = new Property();
		final Property managedObjectInstance = new Property();
		final Property managedObjectClass = new Property();
		final Property correlation = new Property();

		final Property[] filterableData = { alarmIdHolder, eventTimeHolder,
				probableCauseHolder, perceivedSeverityHolder,
				specificProblemHolder, notificationIdHolder,
				managedObjectInstance, managedObjectClass, correlation };

		filterableData[0].name = "";
		filterableData[0].value = orb.create_any();
		filterableData[0].value.insert_string("");

		// EventTime is a UtcT struct, defined in org.omg.TimeBase.idl
		// Set the time attribute to the number of 100 nanoseconds since
		// 1582-10-15 00:00:00 UTC
		final UtcT utcTime = new UtcT();
		utcTime.time = (System.currentTimeMillis() + GREGORIAN_EPOCH_MILLIS) * 10000;
		utcTime.tdf = 0;

		filterableData[1].name = NV_EVENT_TIME.value;
		filterableData[1].value = orb.create_any();
		UtcTHelper.insert(filterableData[1].value, utcTime);

		filterableData[2].name = NV_PROBABLE_CAUSE.value;
		filterableData[2].value = orb.create_any();
		filterableData[2].value.insert_short(probableCause);

		filterableData[3].name = NV_PERCEIVED_SEVERITY.value;
		filterableData[3].value = orb.create_any();
		filterableData[3].value.insert_short(perceivedSeverity);

		filterableData[4].name = NV_SPECIFIC_PROBLEM.value;
		filterableData[4].value = orb.create_any();
		filterableData[4].value.insert_string(specificProblem);

		filterableData[5].name = NV_NOTIFICATION_ID.value;
		filterableData[5].value = orb.create_any();
		filterableData[5].value.insert_long(notificId);

		filterableData[6].name = NV_MANAGED_OBJECT_INSTANCE.value;
		filterableData[6].value = orb.create_any();
		filterableData[6].value.insert_string(managedObjectInst);

		filterableData[7].name = NV_MANAGED_OBJECT_CLASS.value;
		filterableData[7].value = orb.create_any();
		filterableData[7].value.insert_string("ManagedElement");

		filterableData[8].name = NV_CORRELATED_NOTIFICATIONS.value;
		filterableData[8].value = orb.create_any();
		final int[] notifId = { 1, 2 };
		final CorrelatedNotification[] corr = { new CorrelatedNotification(
				"SOURCE1", notifId) };
		CorrelatedNotificationSetTypeHelper.insert(filterableData[8].value,
				corr);

		alarm.header = new EventHeader(fixed, variable);
		alarm.filterable_data = filterableData;
		alarm.remainder_of_body = data;

		final StructuredEvent[] structuEventArray = new StructuredEvent[] { alarm };
		return structuEventArray;
	}

	public static StructuredEvent[] createTestStructuredEventTwo(
			final String fdn, final ORB orb) {
		final StructuredEvent alarm = new StructuredEvent();
		final EventType type = new EventType(ALARM_IRP_VERSION_1_1.value,
				ET_COMMUNICATIONS_ALARM.value);

		final FixedEventHeader fixed = new FixedEventHeader(type,
				NOTIFY_FM_NEW_ALARM.value);
		final short probableCause = PC_CLOCK_SYNCHRONISATION_PROBLEM.value;
		final short perceivedSeverity = PS_CLEARED.value;

		final Property variable[] = new Property[0];
		final Any data = orb.create_any();
		data.insert_long(12);

		final Property alarmIdHolder = new Property();
		final Property eventTimeHolder = new Property();
		final Property perceivedSeverityHolder = new Property();
		final Property specificProblemHolder = new Property();
		final Property probableCauseHolder = new Property();
		final Property notificationIdHolder = new Property();
		final Property managedObjectInstance = new Property();
		final Property managedObjectClass = new Property();
		final Property correlation = new Property();

		final Property[] filterableData = { alarmIdHolder, eventTimeHolder,
				probableCauseHolder, perceivedSeverityHolder,
				specificProblemHolder, notificationIdHolder,
				managedObjectInstance, managedObjectClass, correlation };

		filterableData[0].name = "";
		filterableData[0].value = orb.create_any();
		filterableData[0].value.insert_string("");

		// EventTime is a UtcT struct, defined in org.omg.TimeBase.idl
		// Set the time attribute to the number of 100 nanoseconds since
		// 1582-10-15 00:00:00 UTC
		final UtcT utcTime = new UtcT();
		utcTime.time = (System.currentTimeMillis() + GREGORIAN_EPOCH_MILLIS) * 10000;
		utcTime.tdf = 0;

		filterableData[1].name = NV_EVENT_TIME.value;
		filterableData[1].value = orb.create_any();
		UtcTHelper.insert(filterableData[1].value, utcTime);

		filterableData[2].name = NV_PROBABLE_CAUSE.value;
		filterableData[2].value = orb.create_any();
		filterableData[2].value.insert_short(probableCause);

		filterableData[3].name = NV_PERCEIVED_SEVERITY.value;
		filterableData[3].value = orb.create_any();
		filterableData[3].value.insert_short(perceivedSeverity);

		filterableData[4].name = NV_SPECIFIC_PROBLEM.value;
		filterableData[4].value = orb.create_any();
		filterableData[4].value.insert_string(specificProblem);

		filterableData[5].name = NV_NOTIFICATION_ID.value;
		filterableData[5].value = orb.create_any();
		filterableData[5].value.insert_long(notificId);

		filterableData[6].name = NV_MANAGED_OBJECT_INSTANCE.value;
		filterableData[6].value = orb.create_any();
		filterableData[6].value.insert_string(managedObjectInst);

		filterableData[7].name = NV_MANAGED_OBJECT_CLASS.value;
		filterableData[7].value = orb.create_any();
		filterableData[7].value.insert_string("ManagedElement");

		filterableData[8].name = NV_CORRELATED_NOTIFICATIONS.value;
		filterableData[8].value = orb.create_any();
		final int[] notifId = { 1, 2 };
		final CorrelatedNotification[] corr = { new CorrelatedNotification(
				"SOURCE1", notifId) };
		CorrelatedNotificationSetTypeHelper.insert(filterableData[8].value,
				corr);

		alarm.header = new EventHeader(fixed, variable);
		alarm.filterable_data = filterableData;
		alarm.remainder_of_body = data;

		final StructuredEvent[] structuEventArray = new StructuredEvent[] { alarm };
		return structuEventArray;
	}

	public static StructuredEvent[] createTestStructuredEventThree(
			final String fdn, final ORB orb) {
		final StructuredEvent alarm = new StructuredEvent();
		final EventType type = new EventType(ALARM_IRP_VERSION_1_1.value,
				ET_COMMUNICATIONS_ALARM.value);

		final FixedEventHeader fixed = new FixedEventHeader(type,
				NOTIFY_FM_NEW_ALARM.value);
		final short probableCause = PC_ADAPTER_ERROR.value;
		final short perceivedSeverity = PS_WARNING.value;

		final Property variable[] = new Property[0];
		final Any data = orb.create_any();
		data.insert_long(12);

		final Property alarmIdHolder = new Property();
		final Property eventTimeHolder = new Property();
		final Property perceivedSeverityHolder = new Property();
		final Property specificProblemHolder = new Property();
		final Property probableCauseHolder = new Property();
		final Property notificationIdHolder = new Property();
		final Property managedObjectInstance = new Property();
		final Property managedObjectClass = new Property();
		final Property correlation = new Property();

		final Property[] filterableData = { alarmIdHolder, eventTimeHolder,
				probableCauseHolder, perceivedSeverityHolder,
				specificProblemHolder, notificationIdHolder,
				managedObjectInstance, managedObjectClass, correlation };

		filterableData[0].name = "";
		filterableData[0].value = orb.create_any();
		filterableData[0].value.insert_string("");

		// EventTime is a UtcT struct, defined in org.omg.TimeBase.idl
		// Set the time attribute to the number of 100 nanoseconds since
		// 1582-10-15 00:00:00 UTC
		final UtcT utcTime = new UtcT();
		utcTime.time = (System.currentTimeMillis() + GREGORIAN_EPOCH_MILLIS) * 10000;
		utcTime.tdf = 0;

		filterableData[1].name = NV_EVENT_TIME.value;
		filterableData[1].value = orb.create_any();
		UtcTHelper.insert(filterableData[1].value, utcTime);

		filterableData[2].name = NV_PROBABLE_CAUSE.value;
		filterableData[2].value = orb.create_any();
		filterableData[2].value.insert_short(probableCause);

		filterableData[3].name = NV_PERCEIVED_SEVERITY.value;
		filterableData[3].value = orb.create_any();
		filterableData[3].value.insert_short(perceivedSeverity);

		filterableData[4].name = NV_SPECIFIC_PROBLEM.value;
		filterableData[4].value = orb.create_any();
		filterableData[4].value.insert_string(specificProblem);

		filterableData[5].name = NV_NOTIFICATION_ID.value;
		filterableData[5].value = orb.create_any();
		filterableData[5].value.insert_long(notificId);

		filterableData[6].name = NV_MANAGED_OBJECT_INSTANCE.value;
		filterableData[6].value = orb.create_any();
		filterableData[6].value.insert_string(managedObjectInst);

		filterableData[7].name = NV_MANAGED_OBJECT_CLASS.value;
		filterableData[7].value = orb.create_any();
		filterableData[7].value.insert_string("ManagedElement");

		filterableData[8].name = NV_CORRELATED_NOTIFICATIONS.value;
		filterableData[8].value = orb.create_any();
		final int[] notifId = { 1, 2 };
		final CorrelatedNotification[] corr = { new CorrelatedNotification(
				"SOURCE1", notifId) };
		CorrelatedNotificationSetTypeHelper.insert(filterableData[8].value,
				corr);

		alarm.header = new EventHeader(fixed, variable);
		alarm.filterable_data = filterableData;
		alarm.remainder_of_body = data;

		final StructuredEvent[] structuEventArray = new StructuredEvent[] { alarm };
		return structuEventArray;
	}

	public static StructuredEvent[] createTestCelloOneEvent(final String fdn,
			final ORB orb) {
		final EventType type = new EventType(
				NOTIFICATION_IRP_VERSION_1_1.value, "0");
		final FixedEventHeader fixed = new FixedEventHeader(type,
				"NOTIFY_FM_NEW_ALARM");
		final short probableCause = PC_COOLING_SYSTEM_FAILURE.value;
		final short perceivedSeverity = PS_CRITICAL.value;
		final Property variable[] = new Property[0];
		final Any data = orb.create_any();
		data.insert_long(12);
		final Property alarmIdHolder = new Property();
		final Property eventTimeHolder = new Property();
		final Property perceivedSeverityHolder = new Property();
		final Property specificProblemHolder = new Property();
		final Property probableCauseHolder = new Property();
		final Property notificationIdHolder = new Property();
		final Property managedObjectInstance = new Property();
		final Property managedObjectClass = new Property();
		final Property correlation = new Property();
		final Property ackState = new Property();
		final Property backedUpStatus = new Property();
		final Property[] filterableData = { alarmIdHolder, eventTimeHolder,
				probableCauseHolder, perceivedSeverityHolder,
				specificProblemHolder, notificationIdHolder,
				managedObjectInstance, managedObjectClass, correlation,
				ackState, backedUpStatus };

		filterableData[0].name = "";
		filterableData[0].value = orb.create_any();
		filterableData[0].value.insert_string("");

		final UtcT utcTime = new UtcT();
		utcTime.time = (System.currentTimeMillis() + GREGORIAN_EPOCH_MILLIS) * 10000;
		utcTime.tdf = 0;
		utcTime.inacchi = 0;
		utcTime.inacclo = 0;

		filterableData[1].name = NV_EVENT_TIME.value;
		filterableData[1].value = orb.create_any();
		UtcTHelper.insert(filterableData[1].value, utcTime);

		filterableData[2].name = NV_PROBABLE_CAUSE.value;
		filterableData[2].value = orb.create_any();
		filterableData[2].value.insert_short(probableCause);

		filterableData[3].name = NV_PERCEIVED_SEVERITY.value;
		filterableData[3].value = orb.create_any();
		filterableData[3].value.insert_short(perceivedSeverity);

		filterableData[4].name = NV_SPECIFIC_PROBLEM.value;
		filterableData[4].value = orb.create_any();
		filterableData[4].value.insert_string(specificProblem);

		filterableData[5].name = NV_NOTIFICATION_ID.value;
		filterableData[5].value = orb.create_any();
		filterableData[5].value.insert_long(notificId);

		filterableData[6].name = NV_MANAGED_OBJECT_INSTANCE.value;
		filterableData[6].value = orb.create_any();
		filterableData[6].value.insert_string(managedObjectInst);

		filterableData[7].name = NV_MANAGED_OBJECT_CLASS.value;
		filterableData[7].value = orb.create_any();
		filterableData[7].value.insert_string("ManagedElement");

		filterableData[8].name = NV_CORRELATED_NOTIFICATIONS.value;
		filterableData[8].value = orb.create_any();
		final int[] notifId = { 1, 2 };
		final CorrelatedNotification[] corr = { new CorrelatedNotification(
				"SOURCE1", notifId) };
		CorrelatedNotificationSetTypeHelper.insert(filterableData[8].value,
				corr);

		filterableData[9].name = NV_ACK_STATE.value;
		filterableData[9].value = orb.create_any();
		filterableData[9].value.insert_string(MANAGED_OBJECT_CLASS);

		filterableData[10].name = NV_BACKED_UP_STATUS.value;
		filterableData[10].value = orb.create_any();
		filterableData[10].value.insert_string(MANAGED_OBJECT_CLASS);
		final StructuredEvent structuEvent = new StructuredEvent();
		structuEvent.header = new EventHeader(fixed, variable);
		structuEvent.filterable_data = filterableData;
		structuEvent.remainder_of_body = data;
		final StructuredEvent[] structuEventArray = new StructuredEvent[] { structuEvent };
		return structuEventArray;
	}

	public static StructuredEvent[] createTestCelloTwoEvent(final String fdn,
			final ORB orb) {
		final EventType type = new EventType(
				NOTIFICATION_IRP_VERSION_1_1.value, "0");
		final FixedEventHeader fixed = new FixedEventHeader(type,
				"NOTIFY_FM_NEW_ALARM");
		final short probableCause = PC_CLOCK_SYNCHRONISATION_PROBLEM.value;
		final short perceivedSeverity = PS_CLEARED.value;
		final Property variable[] = new Property[0];
		final Any data = orb.create_any();
		data.insert_long(12);
		final Property alarmIdHolder = new Property();
		final Property eventTimeHolder = new Property();
		final Property perceivedSeverityHolder = new Property();
		final Property specificProblemHolder = new Property();
		final Property probableCauseHolder = new Property();
		final Property notificationIdHolder = new Property();
		final Property managedObjectInstance = new Property();
		final Property managedObjectClass = new Property();
		final Property correlation = new Property();
		final Property ackState = new Property();
		final Property backedUpStatus = new Property();
		final Property[] filterableData = { alarmIdHolder, eventTimeHolder,
				probableCauseHolder, perceivedSeverityHolder,
				specificProblemHolder, notificationIdHolder,
				managedObjectInstance, managedObjectClass, correlation,
				ackState, backedUpStatus };

		filterableData[0].name = "";
		filterableData[0].value = orb.create_any();
		filterableData[0].value.insert_string("");

		final UtcT utcTime = new UtcT();
		utcTime.time = (System.currentTimeMillis() + GREGORIAN_EPOCH_MILLIS) * 10000;
		utcTime.tdf = 0;
		utcTime.inacchi = 0;
		utcTime.inacclo = 0;

		filterableData[1].name = NV_EVENT_TIME.value;
		filterableData[1].value = orb.create_any();
		UtcTHelper.insert(filterableData[1].value, utcTime);

		filterableData[2].name = NV_PROBABLE_CAUSE.value;
		filterableData[2].value = orb.create_any();
		filterableData[2].value.insert_short(probableCause);

		filterableData[3].name = NV_PERCEIVED_SEVERITY.value;
		filterableData[3].value = orb.create_any();
		filterableData[3].value.insert_short(perceivedSeverity);

		filterableData[4].name = NV_SPECIFIC_PROBLEM.value;
		filterableData[4].value = orb.create_any();
		filterableData[4].value.insert_string(specificProblem);

		filterableData[5].name = NV_NOTIFICATION_ID.value;
		filterableData[5].value = orb.create_any();
		filterableData[5].value.insert_long(notificId);

		filterableData[6].name = NV_MANAGED_OBJECT_INSTANCE.value;
		filterableData[6].value = orb.create_any();
		filterableData[6].value.insert_string(managedObjectInst);

		filterableData[7].name = NV_MANAGED_OBJECT_CLASS.value;
		filterableData[7].value = orb.create_any();
		filterableData[7].value.insert_string("ManagedElement");

		filterableData[8].name = NV_CORRELATED_NOTIFICATIONS.value;
		filterableData[8].value = orb.create_any();
		final int[] notifId = { 1, 2 };
		final CorrelatedNotification[] corr = { new CorrelatedNotification(
				"SOURCE1", notifId) };
		CorrelatedNotificationSetTypeHelper.insert(filterableData[8].value,
				corr);

		filterableData[9].name = NV_ACK_STATE.value;
		filterableData[9].value = orb.create_any();
		filterableData[9].value.insert_string(MANAGED_OBJECT_CLASS);

		filterableData[10].name = NV_BACKED_UP_STATUS.value;
		filterableData[10].value = orb.create_any();
		filterableData[10].value.insert_string(MANAGED_OBJECT_CLASS);
		final StructuredEvent structuEvent = new StructuredEvent();
		structuEvent.header = new EventHeader(fixed, variable);
		structuEvent.filterable_data = filterableData;
		structuEvent.remainder_of_body = data;
		final StructuredEvent[] structuEventArray = new StructuredEvent[] { structuEvent };
		return structuEventArray;
	}

	public static StructuredEvent[] createTestCelloEventThree(final String fdn,
			final ORB orb) {
		final EventType type = new EventType(
				NOTIFICATION_IRP_VERSION_1_1.value, "1");
		final FixedEventHeader fixed = new FixedEventHeader(type,
				"NOTIFY_FM_NEW_ALARM");
		final short probableCause = PC_AIR_DRYER_FAILURE.value;
		final short perceivedSeverity = PS_CLEARED.value;
		final Property variable[] = new Property[0];
		final Any data = orb.create_any();
		data.insert_long(12);
		final Property alarmIdHolder = new Property();
		final Property eventTimeHolder = new Property();
		final Property perceivedSeverityHolder = new Property();
		final Property specificProblemHolder = new Property();
		final Property probableCauseHolder = new Property();
		final Property notificationIdHolder = new Property();
		final Property managedObjectInstance = new Property();
		final Property managedObjectClass = new Property();
		final Property correlation = new Property();
		final Property ackState = new Property();
		final Property backedUpStatus = new Property();
		final Property[] filterableData = { alarmIdHolder, eventTimeHolder,
				probableCauseHolder, perceivedSeverityHolder,
				specificProblemHolder, notificationIdHolder,
				managedObjectInstance, managedObjectClass, correlation,
				ackState, backedUpStatus };

		filterableData[0].name = "";
		filterableData[0].value = orb.create_any();
		filterableData[0].value.insert_string("");

		final UtcT utcTime = new UtcT();
		utcTime.time = (System.currentTimeMillis() + GREGORIAN_EPOCH_MILLIS) * 10000;
		utcTime.tdf = 0;
		utcTime.inacchi = 0;
		utcTime.inacclo = 0;

		filterableData[1].name = NV_EVENT_TIME.value;
		filterableData[1].value = orb.create_any();
		UtcTHelper.insert(filterableData[1].value, utcTime);

		filterableData[2].name = NV_PROBABLE_CAUSE.value;
		filterableData[2].value = orb.create_any();
		filterableData[2].value.insert_short(probableCause);

		filterableData[3].name = NV_PERCEIVED_SEVERITY.value;
		filterableData[3].value = orb.create_any();
		filterableData[3].value.insert_short(perceivedSeverity);

		filterableData[4].name = NV_SPECIFIC_PROBLEM.value;
		filterableData[4].value = orb.create_any();
		filterableData[4].value.insert_string(specificProblem);

		filterableData[5].name = NV_NOTIFICATION_ID.value;
		filterableData[5].value = orb.create_any();
		filterableData[5].value.insert_long(notificId);

		filterableData[6].name = NV_MANAGED_OBJECT_INSTANCE.value;
		filterableData[6].value = orb.create_any();
		filterableData[6].value.insert_string(managedObjectInst);

		filterableData[7].name = NV_MANAGED_OBJECT_CLASS.value;
		filterableData[7].value = orb.create_any();
		filterableData[7].value.insert_string("ManagedElement");

		filterableData[8].name = NV_CORRELATED_NOTIFICATIONS.value;
		filterableData[8].value = orb.create_any();
		final int[] notifId = { 1, 2 };
		final CorrelatedNotification[] corr = { new CorrelatedNotification(
				"SOURCE1", notifId) };
		CorrelatedNotificationSetTypeHelper.insert(filterableData[8].value,
				corr);

		filterableData[9].name = NV_ACK_STATE.value;
		filterableData[9].value = orb.create_any();
		filterableData[9].value.insert_string(MANAGED_OBJECT_CLASS);

		filterableData[10].name = NV_BACKED_UP_STATUS.value;
		filterableData[10].value = orb.create_any();
		filterableData[10].value.insert_string(MANAGED_OBJECT_CLASS);
		final StructuredEvent structuEvent = new StructuredEvent();
		structuEvent.header = new EventHeader(fixed, variable);
		structuEvent.filterable_data = filterableData;
		structuEvent.remainder_of_body = data;
		final StructuredEvent[] structuEventArray = new StructuredEvent[] { structuEvent };
		return structuEventArray;
	}

	public static StructuredEvent[] createTestCelloEvent(final String fdn,
			final ORB orb) {
		final EventType type = new EventType(
				NOTIFICATION_IRP_VERSION_1_1.value, "0");
		final FixedEventHeader fixed = new FixedEventHeader(type,
				"NOTIFY_FM_NEW_ALARM");
		final short probableCause = PC_COOLING_SYSTEM_FAILURE.value;
		final short perceivedSeverity = PS_CRITICAL.value;
		final Property variable[] = new Property[0];
		final Any data = orb.create_any();
		data.insert_long(12);
		final Property alarmIdHolder = new Property();
		final Property eventTimeHolder = new Property();
		final Property perceivedSeverityHolder = new Property();
		final Property specificProblemHolder = new Property();
		final Property probableCauseHolder = new Property();
		final Property notificationIdHolder = new Property();
		final Property managedObjectInstance = new Property();
		final Property managedObjectClass = new Property();
		final Property correlation = new Property();
		final Property ackState = new Property();
		final Property backedUpStatus = new Property();
		final Property[] filterableData = { alarmIdHolder, eventTimeHolder,
				probableCauseHolder, perceivedSeverityHolder,
				specificProblemHolder, notificationIdHolder,
				managedObjectInstance, managedObjectClass, correlation,
				ackState, backedUpStatus };

		filterableData[0].name = "";
		filterableData[0].value = orb.create_any();
		filterableData[0].value.insert_string("");

		final UtcT utcTime = new UtcT();
		utcTime.time = (System.currentTimeMillis() + GREGORIAN_EPOCH_MILLIS) * 10000;
		utcTime.tdf = 0;
		utcTime.inacchi = 0;
		utcTime.inacclo = 0;

		filterableData[1].name = NV_EVENT_TIME.value;
		filterableData[1].value = orb.create_any();
		UtcTHelper.insert(filterableData[1].value, utcTime);

		filterableData[2].name = NV_PROBABLE_CAUSE.value;
		filterableData[2].value = orb.create_any();
		filterableData[2].value.insert_short(probableCause);

		filterableData[3].name = NV_PERCEIVED_SEVERITY.value;
		filterableData[3].value = orb.create_any();
		filterableData[3].value.insert_short(perceivedSeverity);

		filterableData[4].name = NV_SPECIFIC_PROBLEM.value;
		filterableData[4].value = orb.create_any();
		filterableData[4].value.insert_string(specificProblem);

		filterableData[5].name = NV_NOTIFICATION_ID.value;
		filterableData[5].value = orb.create_any();
		filterableData[5].value.insert_long(notificId);

		filterableData[6].name = NV_MANAGED_OBJECT_INSTANCE.value;
		filterableData[6].value = orb.create_any();
		filterableData[6].value.insert_string(managedObjectInst);

		filterableData[7].name = NV_MANAGED_OBJECT_CLASS.value;
		filterableData[7].value = orb.create_any();
		filterableData[7].value.insert_string("ManagedElement");

		filterableData[8].name = NV_CORRELATED_NOTIFICATIONS.value;
		filterableData[8].value = orb.create_any();
		final int[] notifId = { 1, 2 };
		final CorrelatedNotification[] corr = { new CorrelatedNotification(
				"SOURCE1", notifId) };
		CorrelatedNotificationSetTypeHelper.insert(filterableData[8].value,
				corr);

		filterableData[9].name = NV_ACK_STATE.value;
		filterableData[9].value = orb.create_any();
		filterableData[9].value.insert_string(MANAGED_OBJECT_CLASS);

		filterableData[10].name = NV_BACKED_UP_STATUS.value;
		filterableData[10].value = orb.create_any();
		filterableData[10].value.insert_string(MANAGED_OBJECT_CLASS);
		final StructuredEvent structuEvent = new StructuredEvent();
		structuEvent.header = new EventHeader(fixed, variable);
		structuEvent.filterable_data = filterableData;
		structuEvent.remainder_of_body = data;
		final StructuredEvent[] structuEventArray = new StructuredEvent[] { structuEvent };
		return structuEventArray;
	}

	public static CorbaManagedElement createTestCorbaManagedElement() {
		final CorbaManagedElement me = new CorbaManagedElement();
		me.setAcknowledgeSupported(true);
		me.setClearAllBehavior(true);
		me.setCommunicationTimeout(3);
		me.setDeltaSynchSupported(true);
		me.setFilterInfo("");
		me.setHeartbeatTimeout(300);
		me.setSourceSynchSupported(true);
		me.setSubordinateObjectSyncSupported(true);
		me.setSyncOnCommitFailureClear(true);
		me.setAlarmIrpAgentVersion("ALARM_IRP_VERSION_1_1");
		me.setNamingUrl("http://127.0.0.1:8000/cello/ior_files/nameroot.ior");
		me.setNotifcationIrpAgentVersion("NOTIFICATION_IRP_VERSION_1_1");
		return me;
	}

	public static Map<String, Object> createDefaultRequestTestHeaders() {
		final Map<String, Object> headers = new HashMap<String, Object>();
		headers.put(DPSConstants.AUTOMATIC_SYNCHRONIZATION, true);
		headers.put(DPSConstants.IS_NODESUSPENDED, false);
		headers.put(DPSConstants.ALARM_SUPERVISION, true);
		headers.put(DPSConstants.HEARTBEAT_SUPERVISON, true);
		headers.put(DPSConstants.HEARTBEAT_TIMEOUT, 300);
		headers.put(DPSConstants.DELTA_SYNCH_SUPPORTED, true);
		headers.put(DPSConstants.SOURCE_SYNCH_SUPPORTED, true);
		headers.put(DPSConstants.SYNCH_ON_COMMIT_FAILURE_CLEAR, true);
		headers.put(DPSConstants.ACKNOWLEDGE_SUPPORTED, true);
		headers.put(DPSConstants.CLOSED_SUPPORTED, true);
		headers.put(DPSConstants.COMMUNICATION_TIMEOUT, 20);
		headers.put(DPSConstants.SUBORDINATE_OBJECT_SYNCSUPPORTED, true);
		headers.put(DPSConstants.FILTER_INFO, "");
		headers.put(DPSConstants.CLEARALL_BEHAVIOUR, true);
		headers.put(CorbaManagedElement.NAMING_URL,
				"http://127.0.0.1:8000/cello/ior_files/nameroot.ior");
		headers.put(CorbaManagedElement.ALARM_IRP_AGENT_VERSION,
				"ALARM_IRP_VERSION_1_1");
		headers.put(CorbaManagedElement.NOTIFICATION_IRP_AGENT_VERSION,
				"NOTIFICATION_IRP_VERSION_1_1");
		return headers;
	}
	/**
	 * @param alarm
	 */

}
