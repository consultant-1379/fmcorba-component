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

import org.omg.CosNaming.*;
import org.omg.CosNotification.StructuredEvent;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.irp.AlarmIRPSystem._AlarmIRPOperationsHelper;
import com.ericsson.irp.CommonIRPConstDefs.Signal;
import com.ericsson.irp.NotificationIRPSystem._NotificationIRPOperationsHelper;

public class MockCorbaNode {
	private MockHttpHandler httpHandler;
	private MockOrbInit orb;
	MockAlarmIRP alarmIRP;
	MockNotifcationIRP notifIRP;
	String fdn;
	POA aPOA;
	int port;
	boolean detached = true;
	private NamingContextExt ncRef;
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(MockCorbaNode.class);

	/**
	 * @return the detachCalled
	 */
	public boolean isDetached() {
		return detached;
	}

	public void setAckRC(Signal signalReturn) {
		alarmIRP.setSignalReturn(signalReturn);
	}

	public String getAckUserID() {
		return alarmIRP.getAck_user_id();
	}

	public String[] getAlarm_information_id_list() {
		return alarmIRP.getAlarm_information_id_list();
	}

	/**
	 * @param detachCalled
	 *            the detachCalled to set
	 */
	public void setDetached(boolean detached) {
		this.detached = detached;
	}

	public void failNotificationIRP() throws Exception {

		aPOA.deactivate_object(aPOA.servant_to_id(notifIRP));
		notifIRP = null;
		detached = true;

	}

	/**
	 * 
	 */
	public void failAlarmIRP() throws Exception {
		aPOA.deactivate_object(aPOA.servant_to_id(alarmIRP));
		alarmIRP = null;

	}

	/**
	 * 
	 */
	public void restartAlarmIRP() throws Exception {

		alarmIRP = new MockAlarmIRP();
		alarmIRP.setNode(this);
		aPOA.the_POAManager().activate();
		aPOA.activate_object(alarmIRP);
		final String name = "ALARM_IRP_VERSION_1_1";
		final NameComponent path[] = ncRef.to_name(name);
		ncRef.rebind(path, _AlarmIRPOperationsHelper.narrow(aPOA
				.servant_to_reference(alarmIRP)));

	}

	public void restartNotificationIRP() throws Exception {

		notifIRP = new MockNotifcationIRP();
		notifIRP.setNode(this);
		aPOA.the_POAManager().activate();
		aPOA.activate_object(notifIRP);
		final String name = "NOTIFICATION_IRP_VERSION_1_1";
		final NameComponent path[] = ncRef.to_name(name);
		ncRef.rebind(path, _NotificationIRPOperationsHelper.narrow(aPOA
				.servant_to_reference(notifIRP)));

	}

	public void stopNode() {
		if (httpHandler != null) {
			httpHandler.stopHttpServer();
		}
		if (orb != null) {
			try {
				final String alarmTestAgent = "ALARM_IRP_VERSION_1_1";
				final NameComponent pathOne[] = ncRef.to_name(alarmTestAgent);
				ncRef.unbind(pathOne);

				final String name = "NOTIFICATION_IRP_VERSION_1_1";
				final NameComponent path[] = ncRef.to_name(name);
				ncRef.unbind(path);
				aPOA.deactivate_object(aPOA.servant_to_id(notifIRP));
				aPOA.deactivate_object(aPOA.servant_to_id(alarmIRP));
			} catch (Exception e) {

			}
			orb.shutdown();
		}
		try {
			Thread.sleep(1000);
		} catch (Exception e) {

		}
	}

	public void setSyncEvents(StructuredEvent[] syncEvents) {
		alarmIRP.setSyncEvents(syncEvents);
	}

	public void startNode(final int port, final String fdn, int orbport) {
		try {
			this.fdn = fdn;
			this.port = port;
			this.httpHandler = new MockHttpHandler();
			httpHandler.startHttpServer(port);
			this.orb = new MockOrbInit();
			orb.initializeORB(Integer.toString(orbport));
			MockingORB.runORB(orb.getOrb());
			final org.omg.CORBA.Object objRef = orb.getOrb()
					.resolve_initial_references("NameService");

			ncRef = NamingContextExtHelper.narrow(objRef);
			aPOA = POAHelper.narrow(orb.getOrb().resolve_initial_references(
					"RootPOA"));

			notifIRP = new MockNotifcationIRP();
			notifIRP.setNode(this);
			aPOA.the_POAManager().activate();
			aPOA.activate_object(notifIRP);
			MockHttpHandler.iorString = orb.getOrb().object_to_string(objRef);

			final String name = "NOTIFICATION_IRP_VERSION_1_1";
			final NameComponent path[] = ncRef.to_name(name);
			ncRef.rebind(path, _NotificationIRPOperationsHelper.narrow(aPOA
					.servant_to_reference(notifIRP)));

			alarmIRP = new MockAlarmIRP();
			alarmIRP.setNode(this);
			aPOA.the_POAManager().activate();
			aPOA.activate_object(alarmIRP);

			final String alarmTestAgent = "ALARM_IRP_VERSION_1_1";
			final NameComponent pathOne[] = ncRef.to_name(alarmTestAgent);
			ncRef.rebind(pathOne, _AlarmIRPOperationsHelper.narrow(aPOA
					.servant_to_reference(alarmIRP)));

			LOGGER.debug("NODE STARTED");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void stopAlarmIRP() {
		alarmIRP.setStatus(true);
	}

	public void stopNotifcationIRP() {
		notifIRP.setStatus(true);
	}

	public void resumeAlarmIRP() {
		alarmIRP.setStatus(false);
	}

	public void resumeNotifcationIRP() {
		notifIRP.setStatus(false);
	}

	public void stopHttpServer() {
		httpHandler.stopHttpServer();
	}

	public void startHttpServer() {
		httpHandler.startHttpServer(port);
	}

	public StructuredEvent[] sendTestAlarmEvents(StructuredEvent[] t) {
		notifIRP.sendToConsumer(t);
		return t;
	}

	public StructuredEvent[] sendTestCelloEvents(StructuredEvent[] t) {
		notifIRP.sendToConsumer(t);
		return t;
	}

	/**
	 * 
	 */
	public void forceInactiveSubscription() {
		notifIRP.forceInactiveSubscription();
	}

}
