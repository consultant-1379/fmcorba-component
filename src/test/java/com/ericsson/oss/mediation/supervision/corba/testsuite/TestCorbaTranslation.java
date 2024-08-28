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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.jacorb.orb.ORB;
import org.junit.*;
import org.omg.CosNotification.StructuredEvent;

import com.ericsson.irp.AlarmIRPConstDefs.*;
import com.ericsson.oss.mediation.supervision.corba.CorbaManagedElement;
import com.ericsson.oss.mediation.supervision.corba.translation.AlarmTranslation;
import com.ericsson.oss.mediation.translator.model.Constants;
import com.ericsson.oss.mediation.translator.model.EventNotification;
public class TestCorbaTranslation 
{
	private static CorbaManagedElement me;
	private static ORB orb;
	private static StructuredEvent[] structuredEventArray;
	private static final String COMMUNICATIONS_ALARM="1";
	@BeforeClass
	public static void initializeTestParameters()
	{
		me=new CorbaManagedElement();
		me.setNamingUrl("Test Url");
		me.setFdn("TopologyRoot=ONRM_ROOT_MO,ResourceGroup=RNC1,MeContext=TESTCORBA");
		
		MockOrbInit mockOrb=new MockOrbInit();
		mockOrb.initializeORB("2019");
		orb=mockOrb.getOrb();
	}
	//@Test
	public void testCreateManagedElement()
	{
		Assert.assertNotNull(me);
	}
	@Test
	public void testAlarmTypeTranslationOne()
	{
		final short probableCause = PC_COOLING_SYSTEM_FAILURE.value;
		final String specificProblem = "General alarm";
		structuredEventArray=TestStructuredEvent.createTestStructuredEvent(me.getFdn(),orb);
		final EventNotification resultTestArray=AlarmTranslation.extractStructEvent(structuredEventArray[0],me);
		Assert.assertNotNull(resultTestArray);
		assertEquals(COMMUNICATIONS_ALARM, resultTestArray.getEventType());
		assertEquals(String.valueOf(probableCause),resultTestArray.getProbableCause());
		assertEquals(Constants.SEV_CRITICAL,resultTestArray.getSeverity());
		assertEquals(specificProblem,resultTestArray.getSpecificProblem());
		//assertEquals(specificProblem,resultTestArray.getAdditionalAttributes());
		assertNotNull(resultTestArray.getManagedObjectInstance());
		assertNotNull(resultTestArray.getTimeZone());
		assertNotNull(resultTestArray.getAckTime());
	}
	@Test
	public void testAlarmTypeTranslationTwo()
	{
		final short probableCause = PC_COOLING_FAN_FAILURE.value;
		final String specificProblem = "General alarm";
		structuredEventArray=TestStructuredEvent.createTestStructuredEventOne(me.getFdn(),orb);
		final EventNotification resultTestArray=AlarmTranslation.extractStructEvent(structuredEventArray[0],me);
		assertEquals(COMMUNICATIONS_ALARM, resultTestArray.getEventType());
		assertEquals(String.valueOf(probableCause),resultTestArray.getProbableCause());
		assertEquals(Constants.SEV_MAJOR,resultTestArray.getSeverity());
		assertEquals(specificProblem,resultTestArray.getSpecificProblem());
		assertNotNull(resultTestArray.getManagedObjectInstance());
		assertNotNull(resultTestArray.getTimeZone());
		assertNotNull(resultTestArray.getAckTime());
	}
	@Test
	public void testAlarmTypeTranslationThree()
	{
		final short probableCause = PC_CLOCK_SYNCHRONISATION_PROBLEM.value;
		final String specificProblem = "General alarm";
		structuredEventArray=TestStructuredEvent.createTestStructuredEventTwo(me.getFdn(),orb);
		final EventNotification resultTestArray=AlarmTranslation.extractStructEvent(structuredEventArray[0],me);
		assertEquals(COMMUNICATIONS_ALARM, resultTestArray.getEventType());
		assertEquals(String.valueOf(probableCause),resultTestArray.getProbableCause());
		assertEquals(Constants.SEV_CLEARED,resultTestArray.getSeverity());
		assertEquals(specificProblem,resultTestArray.getSpecificProblem());
		assertNotNull(resultTestArray.getManagedObjectInstance());
		assertNotNull(resultTestArray.getTimeZone());
		assertNotNull(resultTestArray.getAckTime());
	}
	@Test
	public void testAlarmTypeTranslationFour()
	{
		final short probableCause = PC_ADAPTER_ERROR.value;
		final String specificProblem = "General alarm";
		structuredEventArray=TestStructuredEvent.createTestStructuredEventThree(me.getFdn(),orb);
		final EventNotification resultTestArray=AlarmTranslation.extractStructEvent(structuredEventArray[0],me);
		assertEquals(COMMUNICATIONS_ALARM, resultTestArray.getEventType());
		assertEquals(String.valueOf(probableCause),resultTestArray.getProbableCause());
		assertEquals(Constants.SEV_WARNING,resultTestArray.getSeverity());
		assertEquals(specificProblem,resultTestArray.getSpecificProblem());
		assertNotNull(resultTestArray.getManagedObjectInstance());
		assertNotNull(resultTestArray.getTimeZone());
		assertNotNull(resultTestArray.getAckTime());
	}
	//@Test
	public void testCelloTypeTranslationOne()
	{
		final short probableCause = PC_COOLING_SYSTEM_FAILURE.value;
		final String specificProblem = "General alarm";
		structuredEventArray=TestStructuredEvent.createTestCelloOneEvent(me.getFdn(),orb);
		final EventNotification resultTestArray=AlarmTranslation.extractStructEvent(structuredEventArray[0],me);
		assertEquals(String.valueOf(probableCause),resultTestArray.getProbableCause());
		assertEquals(Constants.SEV_CRITICAL,resultTestArray.getSeverity());
		assertEquals(specificProblem,resultTestArray.getSpecificProblem());
		assertNotNull(resultTestArray.getManagedObjectInstance());
		assertNotNull(resultTestArray.getTimeZone());
		assertNotNull(resultTestArray.getAckTime());
	}
	@Test
	public void testCelloTypeTranslationTwo()
	{
		final short probableCause = PC_CLOCK_SYNCHRONISATION_PROBLEM.value;
		final String specificProblem = "General alarm";
		structuredEventArray=TestStructuredEvent.createTestCelloTwoEvent(me.getFdn(),orb);
		final EventNotification resultTestArray=AlarmTranslation.extractStructEvent(structuredEventArray[0],me);
		assertEquals(String.valueOf(probableCause),resultTestArray.getProbableCause());
		assertEquals(Constants.SEV_CLEARED,resultTestArray.getSeverity());
		assertEquals(specificProblem,resultTestArray.getSpecificProblem());
		assertNotNull(resultTestArray.getManagedObjectInstance());
		assertNotNull(resultTestArray.getTimeZone());
		assertNotNull(resultTestArray.getAckTime());
	}
	@Test
	public void testCelloTypeTranslationThree()
	{
		final short probableCause = PC_AIR_DRYER_FAILURE.value;
		final String specificProblem = "General alarm";
		structuredEventArray=TestStructuredEvent.createTestCelloEventThree(me.getFdn(),orb);
		final EventNotification resultTestArray=AlarmTranslation.extractStructEvent(structuredEventArray[0],me);
		assertEquals(String.valueOf(probableCause),resultTestArray.getProbableCause());
		assertEquals(Constants.SEV_CLEARED,resultTestArray.getSeverity());
		assertEquals(specificProblem,resultTestArray.getSpecificProblem());
		assertNotNull(resultTestArray.getManagedObjectInstance());
		assertNotNull(resultTestArray.getTimeZone());
		assertNotNull(resultTestArray.getAckTime());
	}
	@AfterClass
	public static void cleanupTestSetup()
	{
		orb.shutdown(true);
	}
}
