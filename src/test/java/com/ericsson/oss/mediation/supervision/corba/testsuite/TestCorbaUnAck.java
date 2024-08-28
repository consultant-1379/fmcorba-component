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

import java.util.ArrayList;
import java.util.List;

import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.oss.mediation.supervision.corba.CorbaManagedElement;
import com.ericsson.oss.mediation.supervision.corba.component.CorbaSupervisionEndpoint;
import com.ericsson.oss.services.fm.service.model.FmMediationAckRequest.AckStatus;
import com.ericsson.oss.services.fm.service.util.DPSConstants;


public class TestCorbaUnAck extends CorbaComponentTest {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(TestCorbaUnAck.class);



	@AfterClass
	public static void cleanup() {
		CorbaComponentTest.cleanup();
	}

	//@Test
	public void testAckOperation() {
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
			
			
			headers.put("task","FmMediationAckRequest");
			headers.put("operatorName","ackOperator");
			List<String> ackList=new ArrayList<String>();
			ackList.add("874124860");
			headers.put("alarmIds",ackList);
			headers.put("strAckStatus",AckStatus.UNACKNOWLEDGE.toString());
			ex.getIn().setHeaders(headers);
			LOGGER.debug("Seding Ack Request");
			producer.process(ex);
			Assert.assertEquals("ackOperator", node1.getAckUserID());
			Assert.assertEquals(1, node1.getAlarm_information_id_list().length);
			Assert.assertEquals("874124860", node1.getAlarm_information_id_list()[0]);
			LOGGER.debug("Checking stop supervision");
			CorbaComponentTest.checkStopSupervision(fdn1,node1);

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Exception " , e);
			fail("Exception while processing stop Supervision message " + e);

		}
	}
	@BeforeClass
	public static void setup() {
		CorbaComponentTest.setup();

	}
}
