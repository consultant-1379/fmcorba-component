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
package com.ericsson.oss.mediation.supervision.corba.translation;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.oss.mediation.supervision.corba.CorbaExchangeHeaders;
import com.ericsson.oss.mediation.supervision.corba.CorbaManagedElement;
import com.ericsson.oss.mediation.translator.model.EventNotification;

public class NodeSuspenderProcessor implements Processor {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(NodeSuspenderProcessor.class);

	@Override
	public void process(final Exchange exchange) {
		try {
			LOGGER.debug("Inside NodeSuspenderProcessor");
			final String eventType = (String) exchange.getIn().getHeader(
					CorbaExchangeHeaders.HEADER_TYPE);
			final CorbaManagedElement me = (CorbaManagedElement) exchange
					.getIn().getHeader(CorbaExchangeHeaders.HEADER_ME);
			if (eventType != null
					&& eventType
							.equalsIgnoreCase(CorbaExchangeHeaders.TYPE_STRUCTURED_EVENT)) {
				EventNotification[] notifications = me
						.checkNodeSuspended(false);
				if (notifications != null && notifications.length > 0) {
					LOGGER.info("Node Suspended Alarm true Condition for NE: {}",me.getFdn());
					exchange.getIn().setHeader(
							CorbaExchangeHeaders.HEADER_TYPE,
							CorbaExchangeHeaders.TYPE_ALARM);
					exchange.getIn().setBody(notifications);
				} else {
					if (me.isNodeSuspended()) {
						exchange.getIn().setHeader(
								CorbaExchangeHeaders.HEADER_TYPE,
								CorbaExchangeHeaders.TYPE_NONE);
					}
				}
			} else {
				LOGGER.info("No Alarm found for Translation in NodeSuspenderProcessor");
			}
		} catch (Exception e) {
			// Ignore
		}
	}

}
