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
package com.ericsson.oss.mediation.supervision.corba;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.omg.CosNotification.EventType;
import org.omg.CosNotification.StructuredEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.irp.CosEventComm.Disconnected;
import com.ericsson.irp.CosNotifyComm.InvalidEventType;
import com.ericsson.irp.CosNotifyComm.SequencePushConsumerPOA;


public class PushConsumer extends SequencePushConsumerPOA {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(PushConsumer.class);
	private CorbaManagedElement managedElement = null;
	private Exchange exchange;
	private Processor processor = null;

	public PushConsumer() {

	}

	public PushConsumer(final CorbaManagedElement managedElement,
			final Processor processor, final Exchange exchange) {
		this.managedElement = managedElement;
		this.exchange = exchange;
		this.processor = processor;
	}

	@Override
	public void disconnect_sequence_push_consumer() {
		LOGGER.info("disconnect_sequence_push_consumer: Not Supported fdn: {}"+
				managedElement.getFdn());
	}

	@Override
	public void offer_change(final EventType[] arg0, final EventType[] arg1)
			throws InvalidEventType {
		LOGGER.info("offer_change: Not Supported fdn: {}"+
				managedElement.getFdn());
	}

	public void push_structured_events(
			final StructuredEvent[] structuredEventSeq) throws Disconnected {
		processStructuredEvent(structuredEventSeq);
	}

	public void processStructuredEvent(final StructuredEvent[] event) {
		LOGGER.debug("Received StructuredEvent from FDN: {}" , managedElement.getFdn());
		try {
			exchange.getIn().setHeader(CorbaExchangeHeaders.HEADER_TYPE, CorbaExchangeHeaders.TYPE_STRUCTURED_EVENT);
			exchange.getIn().setHeader(CorbaExchangeHeaders.HEADER_ME, managedElement);
			exchange.getIn().setBody(event);
		    this.processor.process(exchange);
			LOGGER.debug("StructuredEvent processing done for: {}"+managedElement.getFdn());
		
		} catch (Exception e) {
			LOGGER.error(
					"Could not process structured event from node with fdn: {} {} ",
					managedElement.getFdn(),(Throwable) e);
			return;
		}
	}

}