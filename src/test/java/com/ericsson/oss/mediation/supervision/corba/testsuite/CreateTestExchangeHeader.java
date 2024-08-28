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

import java.util.HashMap;
import java.util.Map;
import com.ericsson.oss.mediation.supervision.corba.CorbaManagedElement;
import com.ericsson.oss.services.fm.service.util.DPSConstants;

public class CreateTestExchangeHeader {
	public static Map<String,Object> createHeaders() {
		final Map<String, Object>  headers = new HashMap<String, Object>();

		headers.put(DPSConstants.AUTOMATIC_SYNCHRONIZATION,
				"true");
		headers.put(DPSConstants.IS_NODESUSPENDED,
				"false");
		headers.put(DPSConstants.ALARM_SUPERVISION,
				"true");
		headers.put(DPSConstants.HEARTBEAT_SUPERVISON,
				"true");
		headers.put(DPSConstants.HEARTBEAT_TIMEOUT,
				"300");
		headers.put(DPSConstants.DELTA_SYNCH_SUPPORTED,
				"true");
		headers.put(DPSConstants.SOURCE_SYNCH_SUPPORTED,
				"true");
		headers.put(DPSConstants.SYNCH_ON_COMMIT_FAILURE_CLEAR,
				"true");
		headers.put(DPSConstants.ACKNOWLEDGE_SUPPORTED,
				"true");
		headers.put(DPSConstants.CLOSED_SUPPORTED,
				"true");
		headers.put(DPSConstants.COMMUNICATION_TIMEOUT,
				"20");
		headers.put(DPSConstants.SUBORDINATE_OBJECT_SYNCSUPPORTED,
				"true");
		headers.put(DPSConstants.FILTER_INFO, "");
		headers.put(DPSConstants.SOURCE_TYPE, "URAN");
		headers.put(DPSConstants.CLEARALL_BEHAVIOUR, "true");
		headers.put(CorbaManagedElement.NAMING_URL, "http://127.0.0.1:8080/cello/ior_files/nameroot.ior");
		headers.put(CorbaManagedElement.ALARM_IRP_NAMING_CONTEXT,"ALARM_IRP_VERSION_1_1");
		headers.put(CorbaManagedElement.NOTIFICATION_IRP_NAMING_CONTEXT,"NOTIFICATION_IRP_VERSION_1_1");
		return headers;
	}
}
