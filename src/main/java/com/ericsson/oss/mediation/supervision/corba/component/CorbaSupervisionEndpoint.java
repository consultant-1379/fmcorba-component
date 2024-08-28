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
package com.ericsson.oss.mediation.supervision.corba.component;

import java.util.*;

import org.apache.camel.*;
import org.apache.camel.impl.DefaultEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.oss.mediation.supervision.corba.CorbaManagedElement;
import com.ericsson.oss.mediation.supervision.corba.heartbeat.HBDispatcher;
import com.ericsson.oss.mediation.supervision.corba.orbinitialize.OrbInitializer;

/**
 * Represents a Corba endpoint.
 */
public class CorbaSupervisionEndpoint extends DefaultEndpoint {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(CorbaSupervisionEndpoint.class);
	public static final int TICKMODIFIER = 5;
	private CorbaSupervisionConsumer consumer;
	private CorbaSupervisionProducer producer;
	
	private OrbInitializer orbInit;
	//private final Map<String, CorbaManagedElement> supervisedNEs =new ConcurrentHashMap<String, CorbaManagedElement>();
	private final Map<String, CorbaManagedElement> supervisedNEs=	Collections
			.synchronizedMap(new HashMap<String, CorbaManagedElement>());
	private HBDispatcher hbDispatcher;
	private String portNo;
	private String securePortNo;

	public CorbaSupervisionEndpoint() {
	}

	public CorbaSupervisionEndpoint(final String uri,
			final CorbaSupervisionComponent component) {
		super(uri, component);
		String[] ports=uri.substring(8).split(":"); 
		this.portNo = ports[0];
		this.securePortNo = ports[1];
		orbInit = new OrbInitializer();
		LOGGER.info("Corba Endpoint is created on unsecure ports={} securePort={}" ,portNo,securePortNo);
	}

	public Producer createProducer() {
		if (producer == null) {
			producer = new CorbaSupervisionProducer(this);
		}
		return producer;
	}

	public Consumer createConsumer(final Processor processor) {
		if (consumer == null) {
			consumer = new CorbaSupervisionConsumer(this, processor);
		}
		return consumer;
	}

	public CorbaSupervisionConsumer getConsumer() {
		return consumer;
	}

	/**
	 * @return the portNo
	 */
	public String getPortNo() {
		return portNo;
	}

	public String getSecurePortNo() {
		return securePortNo;
	}

	public boolean isSingleton() {
		return true;
	}

	public OrbInitializer getOrbInit() {
		return orbInit;
	}

	public void addMe(final String fdn, final CorbaManagedElement me) {
		supervisedNEs.put(fdn, me);
	}

	public CorbaManagedElement getMe(final String fdn) {
		return supervisedNEs.get(fdn);
	}

	public void removeMe(final String fdn) {
		supervisedNEs.remove(fdn);
	}
	public Map<String,CorbaManagedElement> getSupervisedNes() {
		return supervisedNEs;
	}

	public void initializeORB() {
		LOGGER.debug("initializeORB called unsecure:secure"+getPortNo()+":"+getSecurePortNo());
		orbInit.initialize(getPortNo(), getSecurePortNo());
	}
	public void shutdownORB() {
		LOGGER.debug("shutdownORB called unsecure:secure");
		orbInit.shutdown();
	}

	/**
	 * @return the hbDispatcher
	 */
	public HBDispatcher getHbDispatcher() {
		return hbDispatcher;
	}

	/**
	 * @param hbDispatcher the hbDispatcher to set
	 */
	public void setHbDispatcher(HBDispatcher hbDispatcher) {
		this.hbDispatcher = hbDispatcher;
	}
}
