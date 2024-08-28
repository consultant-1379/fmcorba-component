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


public class TestHBDuringSupervision extends CorbaComponentTest {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(TestHBDuringSupervision.class);


	@AfterClass
	public static void cleanup() {
		CorbaComponentTest.cleanup();
	}

	//@Test
	public  void testHBDuringSupervision() {
		final String url = "http://127.0.0.1:" + "1234"
				+ "/cello/ior_files/nameroot.ior";
		try {

			headers = CreateTestExchangeHeader.createHeaders();
			headers.put(CorbaManagedElement.NAMING_URL, url);
			ex=endpoint.createExchange();
			headers.put("task","FmMediationSupervisionRequest");
			headers.put("isSupervisionOn","true");
			headers.put("nodeAddress",fdn1);
			ex.getIn().setHeaders(headers);
			producer.process(ex);
			Thread.sleep(100);
			CorbaManagedElement me = ((CorbaSupervisionEndpoint) endpoint)
					.getMe(fdn2);
			Assert.assertNull(me.getSupervision().getSubscriptionId());
			CorbaComponentTest.checkHBAlarm("CRITICAL");
			node1 = new MockCorbaNode();
			CorbaComponentTest.checkStopSupervision(fdn1,node1);
			Assert.assertEquals(1, CorbaComponentTest.eventSender.getRecdCount());
			CorbaComponentTest.checkHBAlarm("CLEARED");
			
		} catch (Exception e) {
			LOGGER.error("Exception " , e);
			fail("Exception while processing start Supervision message " + e);

		}

	}



	@BeforeClass
	public static void setup() {
		CorbaComponentTest.setup();
	}
}
