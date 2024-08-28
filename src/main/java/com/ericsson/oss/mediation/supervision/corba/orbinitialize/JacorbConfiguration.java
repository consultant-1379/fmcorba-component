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

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JacorbConfiguration {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(JacorbConfiguration.class);
	public static final List<String> configurableProperties = new ArrayList<String>();
	private static final String keyStorePath = "/ericsson/tor/data/certificates/fm/";
	private static final String fmJacorbPropertiesFile = "/opt/ericsson/data/fmJacorbPropertiesFile.properties";
	private static final String keyStoreName = "fm.keystore";
	private static final String keyStorePassword = "changeit";
	public static final Properties ipV4UnsecureConfiguration = new Properties();
	public static final Properties ipV4secureConfiguration = new Properties();
	public static final Properties ipV6UnsecureConfiguration = new Properties();
	public static final Properties ipV6SecureConfiguration = new Properties();
	public static final Properties commonConfiguration = new Properties();
	public static final String HB_POOL_SIZE = "hb.pool_size";
	public static final String HB_MAX_POOL_SIZE = "hb.max_pool_size";
	private static Properties propertiesInConfigFile = null;
	static{
		configurableProperties.add("jacorb.retries");
		configurableProperties.add("jacorb.retry_interval");
		configurableProperties.add("jacorb.poa.thread_pool_max");
		configurableProperties.add("jacorb.poa.thread_pool_min");
		configurableProperties.add("jacorb.poa.queue_max");
		configurableProperties.add("jacorb.poa.queue_min");
		configurableProperties.add("jacorb.connection.server.timeout");
		configurableProperties.add("jacorb.connection.client.connect_timeout");
		configurableProperties.add("jacorb.connection.client.max_receptor_threads");
		configurableProperties.add("jacorb.connection.server.max_receptor_threads");
		configurableProperties.add("jacorb.connection.client.max_idle_receptor_threads");
		configurableProperties.add("jacorb.connection.server.max_idle_receptor_threads");
		
		configurableProperties.add("jacorb.connection.client.idle_timeout");
		configurableProperties.add("jacorb.connection.server.timeout");
		configurableProperties.add("jacorb.connection.max_server_connections");
		configurableProperties.add("jacorb.connection.wait_for_idle_interval");
		configurableProperties.add("jacorb.connection.client.idle_timeout");
		configurableProperties.add("jacorb.connection.selection_strategy_class");
		configurableProperties.add("jacorb.connection.statistics_provider_class");
		configurableProperties.add("jacorb.connection.delay_close");
		
		commonConfiguration.put("org.omg.CORBA.ORBClass", "org.jacorb.orb.ORB");
		commonConfiguration.put("org.omg.CORBA.ORBSingletonClass", "org.jacorb.orb.ORBSingleton");
		commonConfiguration.put("jacorb.poa.thread_pool_min","10");
		commonConfiguration.put("jacorb.poa.thread_pool_max","100");
		commonConfiguration.put("jacorb.poa.queue_max","5000");
		commonConfiguration.put("jacorb.connection.client.connect_timeout","10000");
		commonConfiguration.put("jacorb.retries","3");
		
		ipV4UnsecureConfiguration.put("jacorb.net.socket_factory", "com.ericsson.oss.mediation.supervision.corba.orbinitialize.CustomSocketFactory");
		ipV4UnsecureConfiguration.put("jacorb.security.support_ssl", "off");
		ipV6UnsecureConfiguration.put("jacorb.net.socket_factory", "com.ericsson.oss.mediation.supervision.corba.orbinitialize.IPv6CustomSocketFactory");
		ipV6UnsecureConfiguration.put("jacorb.security.support_ssl", "off");
		
		
		
		ipV4secureConfiguration.put("jacorb.security.support_ssl", "on"); 
		ipV4secureConfiguration.put("jacorb.security.ssl.server.supported_options", 
                        "60"); 
		ipV4secureConfiguration.put("jacorb.security.ssl.server.required_options", 
                        "60");
		ipV4secureConfiguration.put(
			"jacorb.ssl.socket_factory",
			"com.ericsson.oss.mediation.supervision.corba.orbinitialize.CustomSSLSocketFactory");
		ipV4secureConfiguration.put("jacorb.ssl.server_socket_factory", 
                        "org.jacorb.security.ssl.sun_jsse.SSLServerSocketFactory"); 
		ipV4secureConfiguration.put("jacorb.security.keystore", keyStorePath + keyStoreName); 
		ipV4secureConfiguration.put("jacorb.security.keystore_password", keyStorePassword); 
		ipV4secureConfiguration.put("jacorb.security.jsse.trustees_from_ks", "on"); 
		ipV4secureConfiguration.put("javax.net.ssl.trustStore", keyStorePath + keyStoreName); 
		ipV4secureConfiguration.put("javax.net.ssl.trustStorePassword", keyStorePassword);
		
		
		ipV6SecureConfiguration.put("jacorb.security.support_ssl", "on"); 
		ipV6SecureConfiguration.put("jacorb.security.ssl.server.supported_options", 
                        "60"); 
		ipV6SecureConfiguration.put("jacorb.security.ssl.server.required_options", 
                        "60");
		ipV6SecureConfiguration.put(
			"jacorb.ssl.socket_factory",
			"com.ericsson.oss.mediation.supervision.corba.orbinitialize.IPv6CustomSSLSocketFactory");
		ipV6SecureConfiguration.put("jacorb.ssl.server_socket_factory", 
                        "org.jacorb.security.ssl.sun_jsse.SSLServerSocketFactory"); 
		ipV6SecureConfiguration.put("jacorb.security.keystore", keyStorePath + keyStoreName); 
		ipV6SecureConfiguration.put("jacorb.security.keystore_password", keyStorePassword); 
		ipV6SecureConfiguration.put("jacorb.security.jsse.trustees_from_ks", "on"); 
		ipV6SecureConfiguration.put("javax.net.ssl.trustStore", keyStorePath + keyStoreName); 
		ipV6SecureConfiguration.put("javax.net.ssl.trustStorePassword", keyStorePassword);
		
	}
	
	private static Properties loadPropertiesFromConfigFile(){
		if(propertiesInConfigFile != null ){
			return propertiesInConfigFile;
		}
		propertiesInConfigFile = new Properties();
		try {
			propertiesInConfigFile.load(new FileInputStream(fmJacorbPropertiesFile));
		} catch (FileNotFoundException e) {
			LOGGER.error("Exception while loading properties from config file:  "+ fmJacorbPropertiesFile + " : ", 
                    (Throwable) e); 
		} catch (IOException e) {
			LOGGER.error("Exception while loading properties from config file:  "+ fmJacorbPropertiesFile + " : ", 
                    (Throwable) e); 
		}
		return propertiesInConfigFile;
	}
	
	 public static Properties getConfiguredProperties(){
		Properties jacorbProperties = new Properties();
		Properties loadedProperties = loadPropertiesFromConfigFile();
		for( Entry<Object, Object> property : loadedProperties.entrySet()){
				jacorbProperties.put(property.getKey(), property.getValue());
			
			LOGGER.info("Configured properties "+jacorbProperties);
		}
		return jacorbProperties;
	}
	 
	 public static Properties getHBThreadpoolProperties(){
		 Properties properties = new Properties();
			Properties loadedProperties = loadPropertiesFromConfigFile();
			for( Entry<Object, Object> property : loadedProperties.entrySet()){
				if(HB_POOL_SIZE.equals(property.getKey()) || HB_MAX_POOL_SIZE.equals(property.getKey())){
					properties.put(property.getKey(), property.getValue());
				}
				LOGGER.info("Configured HB threadpool properties "+properties);
			}
			return properties;
	 }

}
 