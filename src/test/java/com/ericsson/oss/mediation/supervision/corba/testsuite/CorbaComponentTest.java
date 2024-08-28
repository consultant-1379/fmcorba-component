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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Route;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.junit.Assert;
import org.omg.CosNotification.StructuredEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.oss.mediation.supervision.corba.CorbaManagedElement;
import com.ericsson.oss.mediation.supervision.corba.component.CorbaSupervisionEndpoint;
import com.ericsson.oss.mediation.supervision.corba.component.CorbaSupervisionProducer;
import com.ericsson.oss.mediation.supervision.corba.translation.*;
import com.ericsson.oss.mediation.translator.model.Constants;
import com.ericsson.oss.services.fm.service.alarm.AlarmNotification;

public class CorbaComponentTest {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(CorbaComponentTest.class);

	public static MockEventSender eventSender;
	public static MockCorbaNode node1;
	public static CorbaManagedElement me1;
	public static String fdn1 = "NW=ONRM_ROOT_MO,SN=RNC1,MeC=TESTCORBA,ManagedElement=1,FmAccess=1";
	public static String fdn2 = "SubNetwork=ONRM_ROOT_MO,SubNetwork=RNC1,MeContext=TESTCORBA";
	public static int httpport1 = 9413;
	public static int orbport1 = 9614;
	public static CorbaManagedElement me2;
	public static Route route;
	public static CorbaSupervisionEndpoint endpoint;
	public static CorbaSupervisionProducer producer;
	public static Exchange ex;
	public static DefaultCamelContext context;
	public static MockOrbInit orbRunner;
	public final static SimpleDateFormat timeformat = new SimpleDateFormat(
			"yyyyMMddHHmmss");
	public final static String SUBSCRIBTION_ID = "TestSubcriptionId";
	public final static String SUBSCRIBTION_ID2 = "TestSubcriptionIdAfterInactive";

	public static Map<String, Object> headers;

	public static void checkStopSupervision(String fdn, MockCorbaNode node1)
			throws InterruptedException {

		headers = CreateTestExchangeHeader.createHeaders();
		headers.put("task","FmMediationSupervisionRequest");
		headers.put("isSupervisionOn","false");
		headers.put("nodeAddress",fdn1);
		ex = endpoint.createExchange();
		ex.getIn().setHeaders(headers);

		producer.process(ex);
		Thread.sleep(1000);
		Assert.assertEquals(true, node1.isDetached());
		Assert.assertNull(endpoint.getMe(fdn2));


	}

	@SuppressWarnings("rawtypes")
	public static void sendAndVerifyAlarm(MockCorbaNode node1, String fdn1)
			throws InterruptedException {
     	StructuredEvent[] event = TestStructuredEvent
				.createTestStructuredEvent(fdn1, orbRunner.getOrb());
		node1.sendTestAlarmEvents(event);
		Thread.sleep(1000);
		Assert.assertEquals(1, CorbaComponentTest.eventSender.getRecdCount());
		List recvList = CorbaComponentTest.eventSender.getRecvList();
		Assert.assertNotNull(recvList);
		Assert.assertEquals(1, recvList.size());
		Assert.assertEquals(true, recvList.get(0) instanceof AlarmNotification);
		AlarmNotification alarm = (AlarmNotification) recvList.get(0);
		TestStructuredEvent.checkAlarm(alarm);

	}
	@SuppressWarnings("rawtypes")
	public static void sendAndVerifyCello(MockCorbaNode node1, String fdn1)
			throws InterruptedException {
		StructuredEvent[] event = TestStructuredEvent
				.createTestCelloEvent(fdn1, orbRunner.getOrb());
		node1.sendTestAlarmEvents(event);
		Thread.sleep(1000);
		Assert.assertEquals(2, CorbaComponentTest.eventSender.getRecdCount());
		List recvList = CorbaComponentTest.eventSender.getRecvList();
		Assert.assertNotNull(recvList);
		Assert.assertEquals(1, recvList.size());
		Assert.assertEquals(true, recvList.get(0) instanceof AlarmNotification);
		AlarmNotification alarm = (AlarmNotification) recvList.get(0);
		TestStructuredEvent.checkAlarm(alarm);
		CorbaComponentTest.eventSender.reset();
	}

	public static void cleanup() {
		/*
		 * Executed before each test using corba/orb so that each test starts with
		 * a clean state.
		 */
		try {

			//context.stopRoute("CorbaTestRoute");
			context.stop();
			orbRunner.shutdown();
			MockNamingServer.stopNamingServer();
			if (node1 != null) {
				node1.stopNode();
			}
			LOGGER.info("Cleanup Completed ");
		} catch (Exception e) {
			LOGGER.info("Cleanup Failed for Test: " ,e);
		}
	}

	@SuppressWarnings("rawtypes")
	public static void checkHBAlarm(String severity) throws ParseException {
		LOGGER.debug("checkHBAlarm");
		Assert.assertEquals(1, CorbaComponentTest.eventSender.getRecdCount());
		List recvList = CorbaComponentTest.eventSender.getRecvList();
		LOGGER.debug("recvList");
		Assert.assertNotNull(recvList);
		Assert.assertEquals(1, recvList.size());
		AlarmNotification notif =  (AlarmNotification) recvList.get(0);
		LOGGER.debug(" Received Alarm " + notif);
		Assert.assertEquals(true, recvList.get(0) instanceof AlarmNotification);
		AlarmNotification hbAlarm = (AlarmNotification) recvList.get(0);
		timeformat.parse(hbAlarm.getTheTime());
		Assert.assertNotNull(timeformat.parse(hbAlarm.getTheTime()));
		Assert.assertEquals("UTC", hbAlarm.getTimeZone());
		Assert.assertEquals(severity, hbAlarm.getPerceivedSeverity());
		Assert.assertEquals(Constants.HB_EVENT_TYPE, hbAlarm.getEventType());
		Assert.assertEquals(Constants.HB_SPECIFIC_PROBLEM,
				hbAlarm.getSpecificProblem());
		Assert.assertEquals(Constants.HB_PROBABLE_CAUSE,
				hbAlarm.getProbableCause());
		Assert.assertEquals(true, CorbaComponentTest.eventSender.isAllOK());
		CorbaComponentTest.eventSender.reset();
	}

	
	public static void setup() {
		/*
		 * Executed after each test using corba/orb.
		 */
		// Run Naming Service

		MockNamingServer.runNamingServer();
		context = new DefaultCamelContext();
		orbRunner = new MockOrbInit();
		orbRunner.initializeORB("4123");
		CorbaComponentTest.eventSender = new MockEventSender();
		EventModelTranslator.setModeledEventSender(eventSender);
		try {
			context.start();
			context.addRoutes(new RouteBuilder() {
				public void configure() throws Exception {
					LOGGER.debug("Starting Test Route");
					from("Corba://9025:9026").routeId("CorbaTestRoute")
							.process(new NodeSuspenderProcessor())
							.process(new CorbaEventTranslateProcessor())
							.process(new EventConversions())
							.process(new EventModelTranslator());
					LOGGER.debug("Completed Starting Route");
				}
			});
			route = context.getRoute("CorbaTestRoute");
			endpoint = (CorbaSupervisionEndpoint) route.getEndpoint();
			producer = (CorbaSupervisionProducer) endpoint.createProducer();

		} catch (Exception e) {
			LOGGER.error("Exception in test Supervision alarm Events Test "
					+ e.getMessage());
			LOGGER.error("Exception ", e);
			e.printStackTrace();
		}

	}

}
