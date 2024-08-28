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
package com.ericsson.oss.mediation.supervision.corba.ackrequest;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.irp.AlarmIRPConstDefs.AlarmInformationIdSeqHolder;
import com.ericsson.irp.AlarmIRPSystem.*;
import com.ericsson.irp.CommonIRPConstDefs.Signal;
import com.ericsson.oss.mediation.supervision.corba.CorbaManagedElement;
import com.ericsson.oss.mediation.supervision.corba.heartbeat.CommunicationFailureException;
import com.ericsson.oss.services.fm.service.model.FmMediationAckRequest.AckStatus;

public class CorbaAcknowledgeRequest {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(CorbaAcknowledgeRequest.class);
	final private CorbaManagedElement me;

	public CorbaAcknowledgeRequest(final CorbaManagedElement me) {
		this.me = me;
	}

	@SuppressWarnings("unchecked")
	public void acknowledge(final String nodeaddress,Map<String,Object>headers )
			throws CommunicationFailureException {
		LOGGER.debug("acknowledge starts ");
		final List<String> alrmList = (List<String>) headers.get("alarmIds");
		final String[] alarmInformationIdList = alrmList
				.toArray(new String[alrmList.size()]);
		final String ackUserId = (String) headers.get("operatorName");
		final String ackSystemId = "";
		Signal signal = null;
		final String getAckStatus=(String) headers.get("strAckStatus");
		final AlarmInformationIdSeqHolder badAlarmInformationIdList = new AlarmInformationIdSeqHolder();
		LOGGER.debug("ack ackUserId:"+ackUserId+"ackSystemId:"+ackSystemId+"getAckStatus:"+getAckStatus);
		try {
			if (getAckStatus.equals(AckStatus.ACKNOWLEDGE.toString())) {
				try {
					signal = me
							.getSupervision().getIor().getAlarmIRPObj()
							.acknowledge_alarms(alarmInformationIdList,
									ackUserId, ackSystemId,
									badAlarmInformationIdList);
					if ((signal == Signal.Failure)
							|| (signal == Signal.PartialFailure)) {
						LOGGER.error(
								"acknowledge acknowledge_alarms return value (Signal)={} indicate failure or partial failure. Request: {}",
								signal.value(),ackUserId);

					}
				} catch (final AcknowledgeAlarms | ParameterNotSupported
						| InvalidParameter e) {
					LOGGER.error(
							"Exception caught while performing ack on Node with FDN=" +
									me.getFdn() + "Request=" + ackUserId.toString()+ (Throwable) e);
				}
			} else if (getAckStatus
					.equals(AckStatus.UNACKNOWLEDGE.toString())) {
				try {
					signal = me
							.getSupervision().getIor().getAlarmIRPObj()
							.unacknowledge_alarms(alarmInformationIdList,
									ackUserId, ackSystemId,
									badAlarmInformationIdList);
					if ((signal == Signal.Failure)
							|| (signal == Signal.PartialFailure)) {

						LOGGER.error(
								"acknowledge unacknowledge_alarms return value (Signal)={} indicate failure or partial failure. Request={}"+
								signal.value()+ ackUserId);
					}
				} catch (final UnacknowledgeAlarms | OperationNotSupported
						| ParameterNotSupported | InvalidParameter e) {
					LOGGER.error(
							"Exception caught while performing unack on Node. FDN="+
									me.getFdn() + "Request=" + ackUserId.toString()+ (Throwable) e);
				}
			}
		} catch (final Exception e) {
			LOGGER.error(
					"Exception caught while performing ack/unack on Node. FDN="+
							me.getFdn() + "Request=" + ackUserId.toString()+ (Throwable) e);
			throw new CommunicationFailureException(e.toString());
		}finally{
			me.getSupervision().getIor().removeIRPReferences();
		}
	}

}
