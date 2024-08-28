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
package com.ericsson.oss.mediation.supervision.corba.component;

import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Set;

import javax.jms.*;
import javax.jms.Message;
import javax.naming.InitialContext;

import org.apache.camel.*;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.oss.mediation.supervision.corba.CorbaManagedElement;
import com.ericsson.oss.mediation.supervision.corba.heartbeat.component.HBComponent;
import com.ericsson.oss.mediation.supervision.corba.heartbeat.component.HBConsumer;
import com.ericsson.oss.mediation.supervision.corba.orbinitialize.AddressUtil;

public class CorbaSupervisionConsumer extends DefaultConsumer implements MessageListener, ExceptionListener{
	private static final Logger LOGGER = LoggerFactory
			.getLogger(CorbaSupervisionConsumer.class);
	public final CorbaSupervisionEndpoint endpoint;
	private static boolean failoverflag=true;
	private static  String jbossbindaddress="127.0.0.1";
	public static MessageProducer messageProducer=null;
	public static Message message=null;

	public CorbaSupervisionConsumer(final CorbaSupervisionEndpoint endpoint,
			final Processor processor) {

		super(endpoint, processor);
		this.endpoint = endpoint;
	}

	@Override
	public void doStart() {
		LOGGER.info("Starting Corba Endpoint, HB route and doStartUpgradeListener");
		endpoint.initializeORB();
		startHBSupervisionRoute();
		doStartUpgradeListener();
		try {
			jbossbindaddress=AddressUtil.getBindingAddress();
			LOGGER.info("jbossbindaddress in CorbaSupervisionConsumer is"+jbossbindaddress);
		} catch (UnknownHostException e) {
			LOGGER.error("UnknownHostException is"+e);
		}
		LOGGER.info("Corba Endpoint, HB route and doStartUpgradeListener started ");
	}

	@SuppressWarnings("unused")
	private void unusedaddJVMShutdownhook() {
		// TODO Auto-generated method stub
		LOGGER.info("shutdown hook called");
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {

				LOGGER.info("Will be calling do stop method inside hook");
				doStop();

			}
		});
	}

	private void startHBSupervisionRoute() {
		final CamelContext context = endpoint.getCamelContext();
		final RoutesBuilder rb = new RouteBuilder() {
			public void configure() {
				from("HBSupervision:start").routeId(HBComponent.routeId).to(
						"log:HB route end");
			}
		};

		try {
			context.addRoutes(rb);
			context.startRoute(HBComponent.routeId);
			HBConsumer consumer = (HBConsumer) context.getRoute(
					HBComponent.routeId).getConsumer();
			endpoint.setHbDispatcher(consumer.getDispatcher());
		} catch (Exception e) {
			LOGGER.error("Could not start Heartbeat supervision route "
					+ (Throwable) e);
		}
	}

	@Override
	public synchronized void doStop() {
		LOGGER.info("Stopping Corba Endpoint "
				+ endpoint.getSupervisedNes().keySet());
		try {
			endpoint.getHbDispatcher().terminate();
			endpoint.getHbDispatcher().clear();
		} catch (Exception e) {
			LOGGER.error("Some error while remove all elements " + e);
		}
		for (String fdn : endpoint.getSupervisedNes().keySet()) {
			LOGGER.info("Detaching consumer from node " + fdn);
			try {
				final CorbaManagedElement me = endpoint.getMe(fdn);
				LOGGER.info("Stopping HB Route for fdn " + fdn);
				try {
					endpoint.getHbDispatcher().stopSupervision(me);
				} catch (Exception e1) {
					LOGGER.error("Failed to stop HB Supervision " + e1);
				}
				me.getSupervision().stopSupervision();
				endpoint.removeMe(me.getFdn());

			} catch (Exception e) {
				LOGGER.error("Error during stop supervision for FDN: "
						+ fdn + (Throwable) e);
			}
		}

	//	this.endpoint.getOrbInit().shutdown();
		LOGGER.info("do stop method call is done");

	}


	public synchronized void doFailoverStop() {
		LOGGER.info("doFailoverStop called");
		failoverflag=false;
		LOGGER.info("failover falg is set to now before starting hbdispatcher thread: {}",failoverflag);
		endpoint.getHbDispatcher().terminate();
		endpoint.getHbDispatcher().clear();
		
		Set<String> keySet = new HashSet<String>(endpoint.getSupervisedNes().keySet());

		for (final String fdn : keySet) {
			LOGGER.info("Detaching consumer from node: {}" ,fdn);
			Thread t2 = new Thread(new Runnable() {
				public void run() { 
					try {
						final CorbaManagedElement me = endpoint.getMe(fdn);
						try {
							endpoint.getHbDispatcher().stopSupervision(me);
						} catch (Exception e1) {
							LOGGER.error("Failed to stop HB Supervision {}" , e1);
						}
						me.getSupervision().stopSupervision();
						endpoint.removeMe(me.getFdn());

					} catch (Exception e) {
						LOGGER.error("Error during stop supervision for FDN: {} and exception: {} "
								, fdn ,  e.toString());
					}

				}
			}
					);
			t2.start();
			LOGGER.info("Total active thread count is: {}", Thread.activeCount());

		}

		//this.endpoint.getOrbInit().shutdown();
		LOGGER.info("doFailoverStop method call is done");

	}

	@Override
	public void onException(JMSException ex) {
		LOGGER.error("Exception in  onException is: {}" , ex.toString());
	}

	@Override
	public void onMessage(Message message) {
		Object objectData=null;
		try {

			if (message instanceof ObjectMessage && failoverflag) { 

				objectData = ((ObjectMessage)message).getObject(); 

				if(objectData instanceof String){
					String failOverEvent=objectData.toString();
					LOGGER.info("Got failover event for Mediation Service with key: {} ",failOverEvent);
					Boolean state=failOverEvent.startsWith(jbossbindaddress)&&failOverEvent.contains("FmMediationServiceConsumer");

					if (state) {
						LOGGER.info("Got failover Notification for FMMS.will be closing the supervision and orb for all the nodes under this");
						doFailoverStop();
					}
				}
			}else if (message instanceof TextMessage && failoverflag) {
				String text=((TextMessage)message).getText();
				LOGGER.info("failover text is"+text);
				if(text.startsWith(jbossbindaddress)&&text.contains("FmMediationServiceConsumer")){
					doFailoverStop();
				}
			}

			else{
				LOGGER.info("The message received is not the right object");
			}
		}catch (Exception ex) {
			LOGGER.error("The exception in CorbaSupervisionConsumer onMessage : {}",ex.toString());
		}

	}






	public void doStartUpgradeListener()  {
		try{
			LOGGER.info("starting MS upgrade listener here");
			InitialContext ctx = new InitialContext();
			ConnectionFactory connFactory = (ConnectionFactory) ctx.
					lookup("java:/ConnectionFactory");
			LOGGER.info("connFactory:"+connFactory);
			Connection topicConn = connFactory.createConnection(); 
			LOGGER.info("topicConn:"+topicConn);
			topicConn.start();

			final String FMMSUpgradeListenerTopic = "topic/FMMSUpgradeListenerTopic";
			Destination topic = (Destination) ctx.lookup(FMMSUpgradeListenerTopic);
			LOGGER.info("topic:"+topic);

			if(topic instanceof Topic)
			{
				Session topicSession = topicConn.createSession(false,
						Session.AUTO_ACKNOWLEDGE);
				MessageConsumer topicSubscriber = topicSession.createConsumer(topic);
				messageProducer=topicSession.createProducer(topic);
				message=topicSession.createMessage();
				topicSubscriber.setMessageListener(this);

				topicConn.setExceptionListener(this);

			}
		}catch(Exception e){
			LOGGER.error("Exception in doStartUpgradeListener is: {}",e.toString());
		}
	}



}
