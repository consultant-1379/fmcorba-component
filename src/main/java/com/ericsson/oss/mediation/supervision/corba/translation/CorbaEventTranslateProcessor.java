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
package com.ericsson.oss.mediation.supervision.corba.translation;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.omg.CosNotification.StructuredEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.oss.mediation.supervision.corba.CorbaExchangeHeaders;
import com.ericsson.oss.mediation.supervision.corba.CorbaManagedElement;
import com.ericsson.oss.mediation.translator.model.EventNotification;



public class CorbaEventTranslateProcessor implements Processor {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(CorbaEventTranslateProcessor.class);

	@Override
	public void process(final Exchange exchange) {
		try {
			final CorbaManagedElement me = (CorbaManagedElement) exchange
					.getIn().getHeader(CorbaExchangeHeaders.HEADER_ME);
			if(!me.isNodeSuspended()) {
				final String eventType = (String) exchange.getIn().getHeader(
						CorbaExchangeHeaders.HEADER_TYPE);

				if (eventType != null
						&& eventType
						.equalsIgnoreCase(CorbaExchangeHeaders.TYPE_STRUCTURED_EVENT)) {
					final StructuredEvent[] structuredEvent = (StructuredEvent[]) exchange
							.getIn().getBody();
					final EventNotification eventNotification[] = new EventNotification[structuredEvent.length];
					for (int i = 0; i < structuredEvent.length; i++) {
						eventNotification[i] = EventNotification.createEventNotification(me.getSourceType());
						eventNotification[i] = AlarmTranslation
								.translateAlarmEvents(structuredEvent[i], me , eventNotification[i]);
						logEvent(structuredEvent, eventNotification);
					}
					exchange.getIn().setHeader(CorbaExchangeHeaders.HEADER_TYPE,
							CorbaExchangeHeaders.TYPE_ALARM);
					exchange.getIn().setBody(eventNotification);
				} else {
					LOGGER.info("No Alarm found for Translation.");
				}
			} else {
				LOGGER.debug("The node is currently suspended, So discarding the alarms");
			}
		} catch (Exception e) {
			LOGGER.error("Failed translate alarm {}", e.toString() );
		}
	}

	private void logEvent(final StructuredEvent[] structuredEvent,
			final EventNotification[] eventNotification) {
		for (int i = 0; i < structuredEvent.length; i++) {
			if(structuredEvent[i] != null && eventNotification[i] != null) {
				LOGGER.debug("Structured Event notification: {}"
						, AlarmTranslation.printStructuredEvent(structuredEvent[i]));
				LOGGER.debug("Event Notification after translation: {}"
						, eventNotification[i].toString());
			}
		}
	}
}
