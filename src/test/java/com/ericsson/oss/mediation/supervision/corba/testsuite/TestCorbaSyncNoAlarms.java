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

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.nms.fm.fm_communicator.Notification.NotificationType;
import com.ericsson.oss.mediation.supervision.corba.CorbaManagedElement;
import com.ericsson.oss.mediation.supervision.corba.component.CorbaSupervisionEndpoint;
import com.ericsson.oss.services.fm.service.alarm.AlarmSyncEndNotification;
import com.ericsson.oss.services.fm.service.util.DPSConstants;


public class TestCorbaSyncNoAlarms extends CorbaComponentTest {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(TestCorbaSyncNoAlarms.class);



	@AfterClass
	public static void cleanup() {
		CorbaComponentTest.cleanup();


	}

	//@Test
	@SuppressWarnings("rawtypes")
	public void testSynchOperation() {
		try {
			
			node1 = new MockCorbaNode();
			node1.startNode(httpport1, fdn1,orbport1);
			String url1 = "http://127.0.0.1:" + httpport1+ "/cello/ior_files/nameroot.ior";
			headers = CreateTestExchangeHeader.createHeaders();
	
			headers.put(CorbaManagedElement.NAMING_URL, url1);
			headers.put(DPSConstants.HEARTBEAT_TIMEOUT, "10");
			headers.put("task","FmMediationSupervisionRequest");
			headers.put("isSupervisionOn","true");
			headers.put("nodeAddress",fdn1);

			ex=endpoint.createExchange();
			ex.getIn().setHeaders(headers);
			producer.process(ex);
			Thread.sleep(2000);
			CorbaManagedElement me = ((CorbaSupervisionEndpoint) endpoint)
					.getMe(fdn2);
			Assert.assertEquals("TestSubcriptionId", me.getSupervision()
					.getSubscriptionId());
			Assert.assertEquals(0, eventSender.getRecdCount());
			headers.put("task","FmMediationAlarmSyncRequest");
			ex.getIn().setHeaders(headers);
			producer.process(ex);
			Thread.sleep(1000);
			
			Assert.assertEquals(1, eventSender.getRecdCount());
			List recdList=eventSender.getRecvList();
			Assert.assertNotNull(recdList);
			Assert.assertEquals(1, recdList.size());
			Assert.assertEquals(true,recdList.get(0) instanceof AlarmSyncEndNotification);
			AlarmSyncEndNotification syncEnd = (AlarmSyncEndNotification) recdList.get(0) ;
			Assert.assertEquals(fdn2,syncEnd.getNodeAddress());
			LOGGER.info("OSS Notification " + syncEnd.getNotificationsForOSS());
			Assert.assertEquals(1,syncEnd.getNotificationsForOSS().length);
			Assert.assertEquals(NotificationType.SYNC_END,syncEnd.getNotificationsForOSS()[0].getNotificationType());
			CorbaComponentTest.checkStopSupervision(fdn1,node1);

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Unexpected Exception " , e);
			fail("Exception while processing stop Supervision message " + e);

		}
	}
	@BeforeClass
	public static void setup() {
		CorbaComponentTest.setup();

	}
}
