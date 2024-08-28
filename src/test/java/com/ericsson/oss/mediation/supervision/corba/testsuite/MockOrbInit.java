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

import java.util.*;

import org.jacorb.orb.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MockOrbInit {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(MockOrbInit.class);
	private static Map<String,String> commonProperties = new HashMap<String,String>();
	
	static {
		commonProperties.put("org.omg.CORBA.ORBClass", "org.jacorb.orb.ORB");
		commonProperties.put("org.omg.CORBA.ORBSingletonClass",
				"org.jacorb.orb.ORBSingleton");
		commonProperties.put("jacorb.poa.thread_pool_min","10");
		commonProperties.put("jacorb.poa.thread_pool_max","100");
		commonProperties.put("jacorb.poa.queue_max","5000");
		commonProperties.put("jacorb.security.support_ssl", "off");

	}
	private ORB orb;
	private POA unsecurePOA;
	public void initialize(final String unsecurePort, final String securePort) {
		initializeORB(unsecurePort);
	}
	public void initializeORB(final String portNo) {
		try {
			final String[] args = {"-ORBInitRef","NameService=corbaloc::localhost:1049/NameService"};
			final Properties props = java.lang.System.getProperties();

			props.putAll(commonProperties);
			props.put("OAPort", portNo);
			orb = (ORB) ORB.init(args, props);
			this.unsecurePOA = POAHelper.narrow(orb
					.resolve_initial_references("RootPOA"));
			this.unsecurePOA.the_POAManager().activate();
		} catch (Exception e) {
			LOGGER.error("Exception while initizalize unsecured ORB: ", (Throwable) e);
		}
	}


	public void shutdown() {
		if (orb != null) {
			try {
				LOGGER.info("Shutting down  orb");
				orb.shutdown(true);
			} catch (Exception e) {
				LOGGER.info(
						"Exception encountered while shutting down ORB: {}", e);
			}
		}	
	}
	public ORB getOrb() {
		return orb;
	}




}
