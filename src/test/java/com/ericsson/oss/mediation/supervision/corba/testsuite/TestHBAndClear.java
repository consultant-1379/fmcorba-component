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

import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.oss.mediation.supervision.corba.CorbaManagedElement;
import com.ericsson.oss.mediation.supervision.corba.component.CorbaSupervisionEndpoint;
import com.ericsson.oss.services.fm.service.util.DPSConstants;


public class TestHBAndClear extends CorbaComponentTest {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(TestHBAndClear.class);




	@AfterClass
	public static void cleanup() {
		CorbaComponentTest.cleanup();
	}
	//@Test
	public  void testHBandClear() {
		try {
			node1 = new MockCorbaNode();
			int httpport=httpport1;
			int orbport=orbport1;
			String url1 = "http://127.0.0.1:" + httpport+ "/cello/ior_files/nameroot.ior";

			headers = CreateTestExchangeHeader.createHeaders();
			headers.put(CorbaManagedElement.NAMING_URL, url1);
			headers.put(DPSConstants.HEARTBEAT_TIMEOUT, "10");
			headers.put("task","FmMediationSupervisionRequest");
			headers.put("isSupervisionOn","true");
			headers.put("nodeAddress",fdn1);
			ex=endpoint.createExchange();
			ex.getIn().setHeaders(headers);
			producer.process(ex);
			Thread.sleep(1000);
			CorbaManagedElement me = ((CorbaSupervisionEndpoint) endpoint)
					.getMe(fdn2);
			LOGGER.debug("Managed Element " + me);
			LOGGER.debug("Managed Element subscription ID"
					+ me.getSupervision().getSubscriptionId());
			Assert.assertNull(me.getSupervision().getSubscriptionId());
			Assert.assertEquals(true,node1.isDetached());
			CorbaComponentTest.checkHBAlarm("CRITICAL");
			node1.startNode(httpport, fdn1,orbport);
			Thread.sleep(15000);
			Assert.assertEquals(false,node1.isDetached());
			Assert.assertEquals(SUBSCRIBTION_ID,me.getSupervision().getSubscriptionId());
			Thread.sleep(15000);
			CorbaComponentTest.checkHBAlarm("CLEARED");
			
			// Check component is now able to process alarm.
			//CorbaComponentTest.sendAndVerifyAlarm(node1, fdn2);
			CorbaComponentTest.checkStopSupervision(fdn1,node1);
		} catch (Exception e) {
			LOGGER.error("Exception while processing start Supervision message",e);
			fail("Exception while processing start Supervision message " + e);
		}


	}	

	@BeforeClass
	public static void setup() {
		CorbaComponentTest.setup();

	}
}
