/*------------------------------------------------------------------------------
 *******************************************************************************
 * COPYRIGHT Ericsson 2013
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *******************************************************************************
 *----------------------------------------------------------------------------*/
package com.ericsson.oss.mediation.supervision.corba.testsuite;

import org.omg.CORBA.*;
import org.omg.CORBA.Object;
import org.omg.CosNotification.StructuredEvent;
import org.omg.CosNotifyChannelAdmin.SequenceProxyPullSupplierHolder;
import org.omg.CosNotifyChannelAdmin.SequenceProxyPushSupplierHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.irp.CosEventComm.Disconnected;
import com.ericsson.irp.CosNotifyComm.SequencePushConsumer;
import com.ericsson.irp.CosNotifyComm.SequencePushConsumerHelper;
import com.ericsson.irp.NotificationIRPConstDefs.*;
import com.ericsson.irp.NotificationIRPSystem.*;

public class MockNotifcationIRP extends _NotificationIRPOperationsPOA {
	@SuppressWarnings("unused")
	private ORB orb;
	private SequencePushConsumer consumer;
	@SuppressWarnings("unused")
	private boolean stopped = false;
	MockCorbaNode node;
	private boolean forceinactive;
	private static final Logger LOGGER = LoggerFactory
			.getLogger(MockNotifcationIRP.class);

	/**
	 * @return the node
	 */
	public MockCorbaNode getNode() {
		return node;
	}

	/**
	 * @param node the node to set
	 */
	public void setNode(MockCorbaNode node) {
		this.node = node;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ericsson.irp.NotificationIRPSystem._NotificationIRPOperationsOperations
	 * #get_notification_categories(com.ericsson.irp.NotificationIRPConstDefs.
	 * EventTypesSetHolder,
	 * com.ericsson.irp.NotificationIRPConstDefs.ExtendedEventTypesSetHolder)
	 */
	@Override
	public String[] get_notification_categories(
			final EventTypesSetHolder event_type_list,
			final ExtendedEventTypesSetHolder extended_event_type_list)
			throws GetNotificationCategories, OperationNotSupported {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ericsson.irp.NotificationIRPSystem._NotificationIRPOperationsOperations
	 * #change_subscription_filter(java.lang.String, java.lang.String)
	 */
	@Override
	public void change_subscription_filter(final String subscription_id,
			final String filter) throws ChangeSubscriptionFilter,
			OperationNotSupported, InvalidParameter {
		LOGGER.debug("change_subscription_filter is Not Supported");

	}

	void setORB(final ORB orb) {
		this.orb = orb;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ericsson.irp.NotificationIRPSystem._NotificationIRPOperationsOperations
	 * #get_subscription_ids(org.omg.CORBA.Object)
	 */
	@Override
	public String[] get_subscription_ids(final Object manager_reference)
			throws GetSubscriptionIds, OperationNotSupported, InvalidParameter {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ericsson.irp.NotificationIRPSystem._NotificationIRPOperationsOperations
	 * #get_subscription_status(java.lang.String, org.omg.CORBA.StringHolder,
	 * com.ericsson.irp.NotificationIRPConstDefs.SubscriptionStateHolder,
	 * org.omg.CORBA.IntHolder)
	 */
	@Override
	public String[] get_subscription_status(final String subscription_id,
			StringHolder filter_in_effect,
			SubscriptionStateHolder subscription_state,
			final IntHolder time_tick) throws GetSubscriptionStatus,
			OperationNotSupported, InvalidParameter {
		LOGGER.debug("get_subscription_status for " + subscription_id);
		String[] retstatus = new String[1];
		filter_in_effect.value = "test";
		if (!forceinactive) {
			subscription_state.value = SubscriptionState.DontKnow;
			retstatus[0] = "TestSubcriptionId";

		} else {
			subscription_state.value = SubscriptionState.Inactive;
			retstatus[0] = "unknown";
		}

		if (node.isDetached()) {
			throw new GetSubscriptionStatus("NOT ATTACHED");
		}
		return retstatus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ericsson.irp.NotificationIRPSystem._NotificationIRPOperationsOperations
	 * #get_notification_IRP_version()
	 */
	@Override
	public String[] get_notification_IRP_version()
			throws GetNotificationIRPVersion {
		String[] notifcationIRPVersion = new String[1];
		notifcationIRPVersion[0] = "NOTIFICATION_IRP_VERSION_1_1";
		return notifcationIRPVersion;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ericsson.irp.NotificationIRPSystem._NotificationIRPOperationsOperations
	 * #detach(org.omg.CORBA.Object, java.lang.String)
	 */
	@Override
	public void detach(Object manager_reference, String subscription_id)
			throws DetachException, InvalidParameter {
		node.setDetached(true);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ericsson.irp.NotificationIRPSystem._NotificationIRPOperationsOperations
	 * #attach_pull(org.omg.CORBA.Object, int, java.lang.String[],
	 * java.lang.String,
	 * org.omg.CosNotifyChannelAdmin.SequenceProxyPullSupplierHolder)
	 */
	@Override
	public String attach_pull(Object manager_reference, int time_tick,
			String[] notification_category_set, String filter,
			SequenceProxyPullSupplierHolder system_reference) throws Attach,
			OperationNotSupported, ParameterNotSupported, InvalidParameter,
			AlreadySubscribed, AtLeastOneNotificationCategoryNotSupported {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ericsson.irp.NotificationIRPSystem._NotificationIRPOperationsOperations
	 * #attach_push_b(org.omg.CORBA.Object, int, java.lang.String[],
	 * java.lang.String,
	 * org.omg.CosNotifyChannelAdmin.SequenceProxyPushSupplierHolder)
	 */
	@Override
	public String attach_push_b(Object manager_reference, int time_tick,
			String[] notification_category_set, String filter,
			SequenceProxyPushSupplierHolder system_reference) throws Attach,
			OperationNotSupported, ParameterNotSupported, InvalidParameter,
			AlreadySubscribed, AtLeastOneNotificationCategoryNotSupported {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ericsson.irp.NotificationIRPSystem._NotificationIRPOperationsOperations
	 * #attach_push(org.omg.CORBA.Object, int, java.lang.String[],
	 * java.lang.String)
	 */
	@Override
	public String attach_push(Object manager_reference, int time_tick,
			String[] notification_category_set, String filter) throws Attach,
			ParameterNotSupported, InvalidParameter, AlreadySubscribed,
			AtLeastOneNotificationCategoryNotSupported {
		consumer = SequencePushConsumerHelper.narrow(manager_reference);
		node.setDetached(false);
		LOGGER.debug("Attach push called "  + forceinactive);
		if (forceinactive == false) {
			return "TestSubcriptionId";
		} else {
			forceinactive=false;
			return "TestSubcriptionIdAfterInactive";
		}

	}

	/**
	 * @param b
	 */
	public void setStatus(boolean b) {
		// TODO Auto-generated method stub
		this.stopped = b;
	}

	/**
	 * @param createTestStructuredEvent
	 * @return
	 */
	public void sendToConsumer(StructuredEvent[] testEvents) {
		try {
			consumer.push_structured_events(testEvents);
		} catch (Disconnected e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public void forceInactiveSubscription() {
		forceinactive=true;
		
	}

}