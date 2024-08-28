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
import com.ericsson.oss.mediation.translator.model.EventNotification;



public class EventConversions implements Processor {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(EventConversions.class);
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.camel.Processor#process(org.apache.camel.Exchange)
	 */
	
	@Override
	public void process(final Exchange exchange) {
		try {

			final String type = (String) exchange.getIn().getHeader(
					CorbaExchangeHeaders.HEADER_TYPE);
			if (CorbaExchangeHeaders.TYPE_ALARM.equals(type)) {

				final EventNotification[] notif = (EventNotification[]) exchange
						.getIn().getBody();
				for (int i = 0; i < notif.length; i++) {
					String[] fdnParts = notif[i].getManagedObjectInstance()
							.split(",");
					if (fdnParts[0].endsWith("_R")) {
						fdnParts[0]=fdnParts[0].substring(0, fdnParts[0].length() - 2);
					}
					String fdn = null;
					for (int j = 0; j < fdnParts.length; j++) {
						if (j == 0) {
							fdn = fdnParts[j];
						} else {
							fdn += ","+fdnParts[j];
						}
					}
					notif[i].setManagedObjectInstance(fdn);
					LOGGER.debug("Alarm Notifications after conversion: {}",notif[i].toString());
				}
			}
		} catch (Exception e) {
		}
	}
	
}
