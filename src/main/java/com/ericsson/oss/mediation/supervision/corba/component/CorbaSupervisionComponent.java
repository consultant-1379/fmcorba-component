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

import java.util.Map;

import org.apache.camel.Endpoint;
import org.apache.camel.impl.DefaultComponent;

/**
 * Represents the component that manages {@link CorbaSupervisionEndpoint}.
 */
public class CorbaSupervisionComponent extends DefaultComponent {
	public  Endpoint endpoint;


	public Endpoint createEndpoint(final String uri, final String remaining,
			final Map<String, Object> parameters) {
		endpoint = new CorbaSupervisionEndpoint(uri, this);
		try {
			setProperties(endpoint, parameters);
		} catch (Exception e) {
		}
		return endpoint;
	}
}
