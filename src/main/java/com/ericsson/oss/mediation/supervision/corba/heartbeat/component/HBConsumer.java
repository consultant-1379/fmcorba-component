/**

* Licensed to the Apache Software Foundation (ASF) under one or more

* contributor license agreements.  See the NOTICE file distributed with

* this work for additional information regarding copyright ownership.

* The ASF licenses this file to You under the Apache License, Version 2.0

* (the "License"); you may not use this file except in compliance with

* the License.  You may obtain a copy of the License at

*

*      http://www.apache.org/licenses/LICENSE-2.0

*

* Unless required by applicable law or agreed to in writing, software

* distributed under the License is distributed on an "AS IS" BASIS,

* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.

* See the License for the specific language governing permissions and

* limitations under the License.

*/

package com.ericsson.oss.mediation.supervision.corba.heartbeat.component;

 

import java.util.Properties;

import java.util.concurrent.ExecutorService;

 

import org.apache.camel.Processor;

import org.apache.camel.impl.DefaultConsumer;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

 

import com.ericsson.oss.mediation.supervision.corba.heartbeat.HBDispatcher;

import com.ericsson.oss.mediation.supervision.corba.orbinitialize.JacorbConfiguration;

 

/**

* The MyConsumer.

*/

public class HBConsumer extends DefaultConsumer {

       private static final Logger LOGGER = LoggerFactory

                     .getLogger(HBConsumer.class);

 

       private final HBEndpoint endpoint;

       private ExecutorService executor;

       private ExecutorService pool;

       private HBDispatcher dispatcher;

 

       public HBConsumer(HBEndpoint endpoint, Processor processor) {

              super(endpoint, processor);

              this.endpoint = endpoint;

       }

 

       @Override

       protected void doStart() throws Exception {

              super.doStart();

              executor = endpoint.getCamelContext().getExecutorServiceManager()

                           .newSingleThreadExecutor(this, "Single_Thread");

              

              

              ExecutorService gces = endpoint.getCamelContext().getExecutorServiceManager()

              .newSingleThreadExecutor(this, "GC_Single_Thread");

              

              gces.execute(getGCThread());

 

              Properties properties = JacorbConfiguration.getHBThreadpoolProperties();

              String poolSize = (String) properties

                           .get(JacorbConfiguration.HB_POOL_SIZE);

              String maxPoolSizeString = (String) properties

                           .get(JacorbConfiguration.HB_MAX_POOL_SIZE);

              pool = endpoint

                           .getCamelContext()

                           .getExecutorServiceManager()

                           .newThreadPool(this, "Thread_Pool", getValue(poolSize, 100),

                                         getValue(maxPoolSizeString, 500));

              setDispatcher(new HBDispatcher(pool, endpoint));

              executor.execute(getDispatcher());

       }

 

       /**

       * 

        */

       private Runnable getGCThread() {

              

              LOGGER.info("creating GC thread");

              return new Runnable() {

 

                     @Override

                     public void run() {

                           

                           LOGGER.info("GC Thread started");

 

                           while (true) {

                                  try {

                                         Thread.sleep(1800000);

                                         LOGGER.debug("IN GC thread");

                                         System.gc();

                                  } catch (Exception e) {

                                         e.printStackTrace();

                                  }

                                  

                           }

                     }

              };

              

       }

 

       /**

       * @param poolSizeString

       * @return

       */

       private int getValue(String poolSizeString, int defaultValue) {

              return ((poolSizeString == null) || (Integer.parseInt(poolSizeString)) <= 0) ? defaultValue

                           : Integer.parseInt(poolSizeString);

       }

 

       @Override

       protected void doStop() throws Exception {

              dispatcher.terminate();

              // shutdown the thread pool

              endpoint.getCamelContext().getExecutorServiceManager()

                           .shutdown(executor);

              endpoint.getCamelContext().getExecutorServiceManager().shutdown(pool);

              super.doStop();

       }

 

       /**

       * @return the dispatcher

       */

       public HBDispatcher getDispatcher() {

              return dispatcher;

       }

 

       /**

       * @param dispatcher

       *            the dispatcher to set

       */

       public void setDispatcher(HBDispatcher dispatcher) {

              this.dispatcher = dispatcher;

       }

 

}

