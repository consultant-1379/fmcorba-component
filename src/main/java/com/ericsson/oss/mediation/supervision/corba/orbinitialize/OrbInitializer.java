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
package com.ericsson.oss.mediation.supervision.corba.orbinitialize;

import java.net.UnknownHostException;
import java.util.Properties;

import org.jacorb.orb.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrbInitializer {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(OrbInitializer.class);
	private ORB orb;
	private POA unsecurePOA;
	private ORB secureOrb;
	private POA securePOA;
	private ORB orbIPv6;
	private POA unsecurePOAIPv6;
	private ORB secureOrbIPv6;
	private POA securePOAIPv6;
	private boolean orbsStarted = false;

	public void initialize(final String unsecurePort, final String securePort) {
		initializeORB(unsecurePort);
		initializeSecureORB(securePort);
		initializeORBIPv6(unsecurePort);
		initializeSecureORBIPv6(securePort);
		orbsStarted = true;

	}

	public void shutdown() {
		if (orb != null) {
			try {
				LOGGER.info("Shutting down unsecure orb");

				orb.shutdown(true);
				orb.shutdown(false);
				orb.destroy();
			} catch (Exception e) {
				LOGGER.error(
						"Exception encountered while shutting down ORB: {}", e.toString());
			}
		}

		if (secureOrb != null) {
			try {
				LOGGER.info("Shutting down secure orb");
				secureOrb.destroy();
				secureOrb.shutdown(false);
				secureOrb.shutdown(true);
				
			} catch (Exception e) {
				LOGGER.error(
						"Exception encountered while shutting down Secure ORB: {}",
								e.toString());
			}
		}

		if (orbIPv6 != null) {
			try {
				LOGGER.info("Shutting down unsecure IPv6 orb");
				orbIPv6.destroy();
				orbIPv6.shutdown(false);
				orbIPv6.shutdown(true);
				
			} catch (Exception e) {
				LOGGER.error(
						"Exception encountered while shutting down unsecure IPv6 ORB: {}", e.toString());
			}
		}

		if (secureOrbIPv6 != null) {
			try {
				LOGGER.info("Shutting down secure IPv6 orb");
				secureOrbIPv6.shutdown(true);
				secureOrbIPv6.shutdown(false);
				secureOrbIPv6.destroy();

			} catch (Exception e) {
				LOGGER.error(
						"Exception encountered while shutting down Secure IPv6 ORB: {}",
								e);
			}
		}
		/*
		try{
			
			
			orb.getGIOPConnectionManager().shutdown();
			secureOrb.getGIOPConnectionManager().shutdown();
			secureOrbIPv6.getGIOPConnectionManager().shutdown();
			orbIPv6.getGIOPConnectionManager().shutdown();
			
			//orb.destroy();
		}catch (Exception e) {
			LOGGER.error("Exception in closing the connection managers: {}",e.toString());
		}*/
		orbsStarted = false;

	}

	public void initializeORB(final String portNo) {
		try {
			String OAIAddr = getBindingAddress();
			
			final String[] args = {};
			final Properties props = System.getProperties();
			props.put("OAPort", portNo);
			props.put("OAIAddr", OAIAddr);
			props.putAll(JacorbConfiguration.commonConfiguration);
			props.putAll(JacorbConfiguration.ipV4UnsecureConfiguration);
			props.putAll(JacorbConfiguration.getConfiguredProperties());
			orb = (ORB) ORB.init(args, props);
			this.unsecurePOA = POAHelper.narrow(orb
					.resolve_initial_references("RootPOA"));
			this.unsecurePOA.the_POAManager().activate();
			
		} catch (Exception e) {
			LOGGER.error("Exception while initizalize unsecured ORB: {} ",
					 e.toString());
		}
	}

	public void initializeSecureORB(final String portNo) {
		try {
			String OAIAddr = getBindingAddress();
			LOGGER.debug("secureOAIAddr:IPV4Host: {}",  OAIAddr);
			final String[] args = {};
			final Properties props = System.getProperties();
			props.put("OASSLPort", portNo);
			props.put("OAIAddr", OAIAddr);
			props.putAll(JacorbConfiguration.commonConfiguration);
			props.putAll(JacorbConfiguration.ipV4secureConfiguration);
			props.putAll(JacorbConfiguration.getConfiguredProperties());
			this.secureOrb = (ORB) ORB.init(args, props);
			this.securePOA = POAHelper.narrow(secureOrb
					.resolve_initial_references("RootPOA"));
			this.securePOA.the_POAManager().activate();
			LOGGER.info("secure ORB initialized secureOrb: {} and securePOA: {}", this.secureOrb,this.securePOA);

		} catch (Exception e) {
			LOGGER.error("Exception while initizalize secured ORB: {} ",
					 e.toString());
		}
	}

	public void initializeORBIPv6(String portNo)
	{
		try
		{
			String ipV6Host = getIPv6IP();
			LOGGER.debug("unsecureOAIAddr:IPV6Host: {}" , ipV6Host);
			String args[] = new String[0];
			Properties props = System.getProperties();
			props.putAll(JacorbConfiguration.commonConfiguration);
			props.putAll(JacorbConfiguration.ipV6UnsecureConfiguration);
			props.putAll(JacorbConfiguration.getConfiguredProperties());
			props.put("OAPort", portNo);
			props.put("OAIAddr", ipV6Host);
			orbIPv6 = (ORB)ORB.init(args, props);
			unsecurePOAIPv6 = POAHelper.narrow(orbIPv6.resolve_initial_references("RootPOA"));
			unsecurePOAIPv6.the_POAManager().activate();
			LOGGER.info("unsecure IPv6 ORB initialized: unsecureOrb: {} and unsecurePOA: {}", this.orbIPv6,this.unsecurePOAIPv6);
		}
		catch(Exception e)
		{
			LOGGER.error("Exception while initizalize unsecured IPv6 ORB: {}", e.toString());
		}
	}

	public void initializeSecureORBIPv6(String portNo)
	{
		try
		{
			String ipV6Host = getIPv6IP();
			String args[] = new String[0];
			Properties props = System.getProperties();
			props.putAll(JacorbConfiguration.commonConfiguration);
			props.putAll(JacorbConfiguration.ipV6SecureConfiguration);
			props.putAll(JacorbConfiguration.getConfiguredProperties());
			props.put("OASSLPort", portNo);
			props.put("OAIAddr", ipV6Host);
			secureOrbIPv6 = (ORB)ORB.init(args, props);
			securePOAIPv6 = POAHelper.narrow(secureOrbIPv6.resolve_initial_references("RootPOA"));
			securePOAIPv6.the_POAManager().activate();
			LOGGER.info("secure IPv6 ORB initialized secureOrb: {} and securePOAIPv6: {}", this.secureOrbIPv6,this.securePOAIPv6);
		}
		catch(Exception e)
		{
			LOGGER.error("Exception while initizalize secured IPv6 ORB: {}  ", e.toString());
		}
	}

	/**
	 * @return Binding IP Address of the JBOSS server
	 */

	public String getBindingAddress() throws UnknownHostException {
		return AddressUtil.getBindingAddress();
	}

	public String getIPv6IP() throws UnknownHostException {
		return AddressUtil.getIPv6Address();
	}

	public ORB getOrb(boolean isIPv6)
	{
		if(isIPv6)
		{
			LOGGER.debug((new StringBuilder()).append("unsecureorbIPv6:").append(orbIPv6).toString());
			return orbIPv6;
		} else
		{
			LOGGER.debug((new StringBuilder()).append("unsecureorb:").append(orb).toString());
			return orb;
		}
	}

	public ORB getSecureOrb(boolean isIPv6)
	{
		if(isIPv6)
		{
			LOGGER.debug((new StringBuilder()).append("v6secureOrb:").append(secureOrbIPv6).toString());
			return secureOrbIPv6;
		} else
		{
			LOGGER.debug((new StringBuilder()).append("secureOrb:").append(secureOrb).toString());
			return secureOrb;
		}
	}

	public POA getSecurePOA(boolean isIPv6)
	{
		if(isIPv6)
		{
			LOGGER.debug((new StringBuilder()).append("securePOAIPv6:").append(securePOAIPv6).toString());
			return securePOAIPv6;
		} else
		{
			LOGGER.debug((new StringBuilder()).append("securePOA:").append(securePOA).toString());
			return securePOA;
		}
	}

	public POA getUnsecurePOA(boolean isIPv6)
	{
		if(isIPv6)
		{
			LOGGER.debug((new StringBuilder()).append("unsecurePOAIPv6:").append(unsecurePOAIPv6).toString());
			return unsecurePOAIPv6;
		} else
		{
			LOGGER.debug((new StringBuilder()).append("unsecurePOA:").append(unsecurePOA).toString());
			return unsecurePOA;
		}
	}



	/**
	 * @return the orbsStarted
	 */
	public boolean isOrbsStarted() {
		return orbsStarted;
	}

}