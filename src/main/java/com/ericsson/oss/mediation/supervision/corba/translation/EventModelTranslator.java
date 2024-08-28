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

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.oss.itpf.sdk.eventbus.model.EventSender;
import com.ericsson.oss.itpf.sdk.eventbus.model.classic.EventSenderBean;
import com.ericsson.oss.mediation.supervision.corba.CorbaExchangeHeaders;
import com.ericsson.oss.mediation.translator.model.EventNotification;
import com.ericsson.oss.services.fm.service.alarm.FmMediationNotification;
import com.ericsson.oss.services.fm.service.util.ConvertEventNotificationToAlarm;






public class EventModelTranslator implements Processor {

	@SuppressWarnings("rawtypes")
	private static EventSender modeledEventSender;


	private static final Logger LOGGER = LoggerFactory
			.getLogger(EventModelTranslator.class);



	@SuppressWarnings("rawtypes")
	public static void setModeledEventSender(EventSender sender) {
		modeledEventSender = sender;
	}

	@SuppressWarnings("rawtypes")
	private void updateEventSender() throws ClassNotFoundException {

		if (modeledEventSender == null) {
			Class<?> clazz = null;

			final FmMediationNotification x = new FmMediationNotification();
			clazz = Class.forName(x.getClass().getCanonicalName());

			modeledEventSender = new EventSenderBean(clazz);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.camel.Processor#process(org.apache.camel.Exchange)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void process(final Exchange exchange) {
		try {

			final String type = (String) exchange.getIn().getHeader(
					CorbaExchangeHeaders.HEADER_TYPE);
			if (CorbaExchangeHeaders.TYPE_ALARM.equals(type)) {
				updateEventSender();
				final EventNotification[] notif = (EventNotification[]) exchange
						.getIn().getBody();
				List<FmMediationNotification> alarmNotifcation = new ArrayList<FmMediationNotification>();
				for (int i = 0; i < notif.length; i++) {
					if(notif[i] != null) {
						LOGGER.debug("Alarm Received from translator: {}",
								notif[i].toString());
						alarmNotifcation.add(ConvertEventNotificationToAlarm
								.converEventNotificationToAlarmNotification(notif[i]));
					} else{
						LOGGER.debug("The EventNotification received from Translator is NULL, Will be discarded");
					}
				}
				modeledEventSender.send(alarmNotifcation);
				LOGGER.debug("send to fm service channel"+modeledEventSender);

			}
		} catch (Exception e) {
			LOGGER.error("Exception in EventModelTranslator. Exception: {}",
					 e.toString());
		}
	}

}
