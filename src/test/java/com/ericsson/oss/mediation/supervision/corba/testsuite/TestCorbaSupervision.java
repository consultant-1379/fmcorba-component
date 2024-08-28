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


public class TestCorbaSupervision extends CorbaComponentTest {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(TestCorbaSupervision.class);



	@AfterClass
	public static void cleanup() {
		CorbaComponentTest.cleanup();
		Assert.assertEquals(0, CorbaComponentTest.eventSender.getRecdCount());
	}

	//@Test
	public void testSupervisionStartStop() {
		try {
			
			node1 = new MockCorbaNode();
			int httpport=httpport1;
			node1.startNode(httpport1, fdn1,orbport1);
			String url1 = "http://127.0.0.1:" + httpport+ "/cello/ior_files/nameroot.ior";
			headers = CreateTestExchangeHeader.createHeaders();
	
			headers.put(CorbaManagedElement.NAMING_URL, url1);
			headers.put(DPSConstants.HEARTBEAT_TIMEOUT, "1");
			/*FmMediationSupervisionRequest req = new FmMediationSupervisionRequest(
					fdn1, "jobId", true);*/
			headers.put("task","FmMediationSupervisionRequest");
			headers.put("isSupervisionOn","true");
			headers.put("nodeAddress",fdn1);
			//ex.getIn().setBody(req);
			ex=endpoint.createExchange();
			ex.getIn().setHeaders(headers);

	
			
			producer.process(ex);
			Thread.sleep(2000);
			CorbaManagedElement me = ((CorbaSupervisionEndpoint) endpoint)
					.getMe(fdn2);
			Assert.assertEquals("TestSubcriptionId", me.getSupervision()
					.getSubscriptionId());
			Assert.assertEquals(0, CorbaComponentTest.eventSender.getRecdCount());
			//Route hbRoute = context.getRoute(fdn1);
			//Assert.assertNotNull(hbRoute);

			LOGGER.info("Managed Element " + me);
			LOGGER.info("Managed Element subscription ID"
					+ me.getSupervision().getSubscriptionId());
			// Make sure components can talk to node for at least 5 HB cycles.
			Thread.sleep(10000);
			Assert.assertEquals(0, CorbaComponentTest.eventSender.getRecdCount());
			//CorbaComponentTest.sendAndVerifyAlarm(node1, fdn1);
			//CorbaComponentTest.checkStopSupervision(fdn1,node1);
			
		} catch (Exception e) {
			LOGGER.error("Exception " , e);
			e.printStackTrace();
			fail("Exception while processing stop Supervision message " + e);
		}

	}

	@BeforeClass
	public static void setup() {
		CorbaComponentTest.setup();

	}
}
