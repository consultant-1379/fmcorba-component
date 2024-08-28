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
package com.ericsson.oss.mediation.supervision.corba.orbinitialize;

import java.net.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddressUtil {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AddressUtil.class);
	public static String getBindingAddress() throws UnknownHostException {
		String finalListeningIP = System.getProperty("jboss.bind.address");
		if (finalListeningIP != null) {
			if (finalListeningIP.equalsIgnoreCase("0.0.0.0")
					|| finalListeningIP.equalsIgnoreCase("127.0.0.1") || finalListeningIP.equals("localhost")) {
				finalListeningIP = InetAddress.getLocalHost().getHostAddress()
						.toString();
			}
		} else {
			finalListeningIP = InetAddress.getLocalHost().getHostAddress()
					.toString();
		}
		return finalListeningIP;
	}
	
	public static String getIPv6Address() {
		String ipAddressV6 = "";
		try {
			String hostnameV6 = (new StringBuilder())
					.append(Inet6Address.getLocalHost().getHostName())
					.append("-v6").toString();
			LOGGER.debug((new StringBuilder()).append("hostname-v6:")
					.append(hostnameV6).toString());
			ipAddressV6 = Inet6Address.getByName(hostnameV6).getHostAddress();
			LOGGER.debug((new StringBuilder())
					.append("getIPv6IP():").append(ipAddressV6)
					.toString());
		} catch (UnknownHostException e) {
			LOGGER.error("UnknownHostException: ", e);
		}
		return ipAddressV6;
	}
}