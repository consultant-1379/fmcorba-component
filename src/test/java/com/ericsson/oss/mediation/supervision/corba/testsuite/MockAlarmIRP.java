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
package com.ericsson.oss.mediation.supervision.corba.testsuite;

import org.omg.CORBA.BooleanHolder;
import org.omg.CORBA.IntHolder;
import org.omg.CosNotification.StructuredEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.irp.AlarmIRPConstDefs.AlarmInformationIdSeqHolder;
import com.ericsson.irp.AlarmIRPSystem.*;
import com.ericsson.irp.CommonIRPConstDefs.Signal;

public class MockAlarmIRP extends _AlarmIRPOperationsPOA {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(MockAlarmIRP.class);
	@SuppressWarnings("unused")
	private boolean stopped = false;
	private StructuredEvent[] syncEvents=new StructuredEvent[0];
	//private List<String> alarmInformationIdList=new ArrayList<String>();
	MockCorbaNode node;
	private String ack_user_id;
	private String[] alarm_information_id_list;
	private Signal SignalReturn = Signal.OK;
	@Override
	public String[] get_alarm_IRP_version() throws GetAlarmIRPVersion {
		String[] alarmIRPVersion = new String[1];
		alarmIRPVersion[0] = "ALARM_IRP_VERSION_1_1";
		return alarmIRPVersion;
	}



	/**
	 * @return the ack_user_id
	 */
	public String getAck_user_id() {
		return ack_user_id;
	}



	/**
	 * @param ack_user_id the ack_user_id to set
	 */
	public void setAck_user_id(String ack_user_id) {
		this.ack_user_id = ack_user_id;
	}



	/**
	 * @return the alarm_information_id_list
	 */
	public String[] getAlarm_information_id_list() {
		return alarm_information_id_list;
	}



	/**
	 * @param alarm_information_id_list the alarm_information_id_list to set
	 */
	public void setAlarm_information_id_list(String[] alarm_information_id_list) {
		this.alarm_information_id_list = alarm_information_id_list;
	}



	/**
	 * @param signalReturn the signalReturn to set
	 */
	public void setSignalReturn(Signal signalReturn) {
		SignalReturn = signalReturn;
	}


	/**
	 * @param syncEvents the syncEvents to set
	 */
	public void setSyncEvents(StructuredEvent[] syncEvents) {
		this.syncEvents = syncEvents;
	}



	/**
	 * @return the node
	 */
	public MockCorbaNode getNode() {
		return node;
	}

	/**
	 * @param node the node to set
	 */
	public void setNode(MockCorbaNode node) {
		this.node = node;
	}
	@Override
	public void get_alarm_count(final String filter,
			final IntHolder critical_count, final IntHolder major_count,
			final IntHolder minor_count, final IntHolder warning_count,
			final IntHolder indeterminate_count, final IntHolder cleared_count)
			throws GetAlarmCount, OperationNotSupported, ParameterNotSupported,
			InvalidParameter {
		LOGGER.debug("Un supporting get_alarm_count");
	}

	@Override
	public StructuredEvent[] get_alarm_list(final String filter,
			final BooleanHolder flag, final AlarmInformationIteratorHolder iter)
			throws GetAlarmList, ParameterNotSupported, InvalidParameter {
		LOGGER.debug("Un supporting get_alarm_list in TestAlarmIRP");
		flag.value=true;
		return syncEvents;
	}

	@Override
	public Signal unacknowledge_alarms(
			final String[] alarm_information_id_list, final String ack_user_id,
			final String ack_system_id,
			final AlarmInformationIdSeqHolder bad_alarm_information_id_list)
			throws UnacknowledgeAlarms, OperationNotSupported,
			ParameterNotSupported, InvalidParameter {
		LOGGER.debug("unacknowledge_alarms alarm called");
		this.ack_user_id = ack_user_id;
		this.alarm_information_id_list = alarm_information_id_list;
		bad_alarm_information_id_list.value=new String[0];
		return SignalReturn;
	}

	@Override
	public Signal acknowledge_alarms(final String[] alarm_information_id_list,
			final String ack_user_id, final String ack_system_id,
			final AlarmInformationIdSeqHolder bad_alarm_information_id_list)
			throws AcknowledgeAlarms, ParameterNotSupported, InvalidParameter {
		LOGGER.debug("acknowledge_alarms alarm called");

		this.ack_user_id = ack_user_id;
		this.alarm_information_id_list = alarm_information_id_list;
		bad_alarm_information_id_list.value=new String[0];
		return SignalReturn;
	}

	/**
	 * @param b
	 */
	public void setStatus(final boolean stopped) {
		this.stopped = stopped;
	}

}
