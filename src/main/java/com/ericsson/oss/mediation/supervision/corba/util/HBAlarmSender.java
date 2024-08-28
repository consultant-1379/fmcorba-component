/*------------------------------------------------------------------------------
 *******************************************************************************
 * COPYRIGHT Ericsson 2014
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *******************************************************************************
 *----------------------------------------------------------------------------*/
package com.ericsson.oss.mediation.supervision.corba.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.oss.itpf.sdk.eventbus.Channel;
import com.ericsson.oss.itpf.sdk.eventbus.ChannelLocator;
import com.ericsson.oss.itpf.sdk.eventbus.classic.ChannelLocatorBean;

public class HBAlarmSender {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(HBAlarmSender.class);

    private static final String HB_ALARM_TOPIC = "jms:/topic/hbalarmtopic";

    private static final ChannelLocator locatorBean = new ChannelLocatorBean();

    private static Channel channel;

    public static void sendHbAlarm(final String hbNotification) {
        if (channel == null) {
            LOGGER.info("The channel is null,  Looking up first time");
            channel = locatorBean.lookupChannel(HB_ALARM_TOPIC);
        }

        channel.send(hbNotification);
    }

}
