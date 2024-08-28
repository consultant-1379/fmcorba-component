package com.ericsson.oss.mediation.supervision.corba.heartbeat.component;

import java.util.Map;

import org.apache.camel.Endpoint;
import org.apache.camel.impl.DefaultComponent;

/**
 * A custom component using {@link org.apache.camel.spi.ExecutorServiceManager} to create a thread pool.
 *
 * @version $Revision: 356 $
 */
public class HBComponent extends DefaultComponent {

    public static final String routeId = "heartbeatsupervisionRoute";

    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {
        Endpoint endpoint = new HBEndpoint(uri, this);
        setProperties(endpoint, parameters);
        return endpoint;
    }


    

}
