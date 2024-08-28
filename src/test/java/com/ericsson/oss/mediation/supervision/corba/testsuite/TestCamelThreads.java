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

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.oss.mediation.supervision.corba.CorbaManagedElement;
import com.ericsson.oss.services.fm.service.util.DPSConstants;


public class TestCamelThreads extends CorbaComponentTest {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(TestCamelThreads.class);



	@AfterClass
	public static void cleanup() {
		CorbaComponentTest.cleanup();


	}

	//@Test
	public void testSupervisionStartStop() {
		try {
			
			node1 = new MockCorbaNode();
			int httpport=httpport1;
			String url1 = "http://127.0.0.1:" + httpport+ "/cello/ior_files/nameroot.ior";
			node1.startNode(httpport1, fdn1,orbport1);
			headers = CreateTestExchangeHeader.createHeaders();	
			headers.put(CorbaManagedElement.NAMING_URL, url1);
			headers.put(DPSConstants.HEARTBEAT_TIMEOUT, "10");
			headers.put("task","FmMediationSupervisionRequest");
			headers.put("isSupervisionOn","true");
			headers.put("nodeAddress",fdn1);
			ex=endpoint.createExchange();
			ex.getIn().setHeaders(headers);
			producer.process(ex);
			for (int i=0;i<10;i++) {
				String tmpfdn= "NW=ONRM_ROOT_MO,SN=RNC1,MeC=TESTCORBA"+i+",ManagedElement=1,FmAccess=1";
				headers.put("nodeAddress",tmpfdn);
				ex.getIn().setHeaders(headers);
				producer.process(ex);
			}
			node1.stopNode();
			Thread.sleep(60000);
			LOGGER.debug("RECD COUNT " + CorbaComponentTest.eventSender.getRecdCount());
			
			
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
