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
package com.ericsson.oss.mediation.supervision.corba.common;

import java.io.*;
import java.net.URL;
import org.jacorb.orb.ORB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * Naming Context for the provided URI of CORBA Nodes
 * 
 */
public class CorbaNamingContext {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(CorbaNamingContext.class);

	public static org.omg.CosNaming.NamingContext getNamingContext(
			final URL agentUrl, final ORB orb) {

		org.omg.CosNaming.NamingContext rootContext = null;
		try {
			final InputStream inputStream = agentUrl.openStream();
			final InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream);
			final BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);
			final String line = bufferedReader.readLine();
			bufferedReader.close();
			final org.omg.CORBA.Object namingObject = orb
					.string_to_object(line);
			rootContext = org.omg.CosNaming.NamingContextHelper
					.narrow(namingObject);
		} catch (final Exception e) {
			releaseNamingContext(rootContext);
			LOGGER.debug("Exception in reading inputStream from agentURL. Exception: {} ",e.toString());
		}

		return rootContext;
	}

	public static void releaseNamingContext(
			org.omg.CosNaming.NamingContext rootContext) {
		try {
			if(rootContext != null){
				rootContext._release();
			}
		} catch (final Exception e) {
			LOGGER.error(
					"Exception in releasing naming context. Exception: {}",e.toString());
		}
	}
}
