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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.impl.DefaultProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.oss.mediation.supervision.corba.CorbaExchangeHeaders;
import com.ericsson.oss.mediation.supervision.corba.CorbaManagedElement;
import com.ericsson.oss.mediation.supervision.corba.NodeSuspenderConfiguration;
import com.ericsson.oss.mediation.supervision.corba.ackrequest.CorbaAcknowledgeRequest;
import com.ericsson.oss.mediation.supervision.corba.common.CorbaSupervision;
import com.ericsson.oss.mediation.supervision.corba.synchalarm.CorbaSynchronizeEvents;
import com.ericsson.oss.mediation.supervision.corba.translation.EventModelTranslator;
import com.ericsson.oss.mediation.supervision.corba.util.Constants;
import com.ericsson.oss.mediation.supervision.corba.util.HBAlarmSender;
import com.ericsson.oss.mediation.translator.model.EventNotification;
import com.ericsson.oss.services.fm.service.util.DPSConstants;
import com.ericsson.oss.services.fm.service.util.FDNConverter;


public class CorbaSupervisionProducer extends DefaultProducer {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(CorbaSupervisionProducer.class);
	private final CorbaSupervisionEndpoint endpoint;
	private final int noSynchMaxRetrival = 3;

	private static final List<String> SynchPendingNodeList = Collections.synchronizedList(new ArrayList<String>());

	private static int supervisionoffcounter=0;
	private NodeSuspenderConfiguration suspender = NodeSuspenderConfiguration.getInstance();


	public CorbaSupervisionProducer(final CorbaSupervisionEndpoint endpoint) {
		super(endpoint);
		this.endpoint = endpoint;
	}

	private void initializeManagedElement(final CorbaManagedElement me,
			final Map<String, Object> headers) {
		try{
			/*me.setSecure(Boolean.parseBoolean((String)headers
					.get("nodeSecurityState")));*/
			me.setAcknowledgeSupported(Boolean.parseBoolean((String)headers
					.get(DPSConstants.ACKNOWLEDGE_SUPPORTED)));
			me.setCommunicationTimeout(Integer.parseInt((String) headers
					.get(DPSConstants.COMMUNICATION_TIMEOUT)));
			me.setDeltaSynchSupported(Boolean.parseBoolean((String)headers
					.get(DPSConstants.DELTA_SYNCH_SUPPORTED)));
			me.setSourceType((String) headers.get(DPSConstants.SOURCE_TYPE));
			me.setFilterInfo((String) headers.get(DPSConstants.FILTER_INFO));
			me.setHeartbeatTimeout(Integer.parseInt((String)  headers
					.get(DPSConstants.HEARTBEAT_TIMEOUT)));
			me.setSourceSynchSupported(Boolean.parseBoolean((String) headers
					.get(DPSConstants.SOURCE_SYNCH_SUPPORTED)));
			me.setSubordinateObjectSyncSupported(Boolean.parseBoolean((String) headers
					.get(DPSConstants.SUBORDINATE_OBJECT_SYNCSUPPORTED)));
			me.setSyncOnCommitFailureClear(Boolean.parseBoolean((String) headers
					.get(DPSConstants.SYNCH_ON_COMMIT_FAILURE_CLEAR)));
			me.setAlarmIrpAgentVersion((String) headers
					.get(CorbaManagedElement.ALARM_IRP_AGENT_VERSION));
			me.setAlarmIrpNamingContext((String) headers
					.get(CorbaManagedElement.ALARM_IRP_NAMING_CONTEXT));
			me.setNamingUrl((String) headers.get(CorbaManagedElement.NAMING_URL));
			me.setNotifcationIrpAgentVersion((String) headers
					.get(CorbaManagedElement.NOTIFICATION_IRP_AGENT_VERSION));
			me.setNotifcationIrpNamingContext((String) headers
					.get(CorbaManagedElement.NOTIFICATION_IRP_NAMING_CONTEXT));
			me.setSourceType((String) headers.get(DPSConstants.SOURCE_TYPE));
			me.setProducer(this);
		}catch(Exception e){
			LOGGER.error("Error while initializing Me : {}",e.toString());
		}

	}

	private void processAcknowledge(final String NodeAddress,final Map<String, Object>headers) {
		LOGGER.debug("processAcknowledge starts..");
		final CorbaManagedElement me = endpoint.getMe(NodeAddress);
		if (me != null) {
			final CorbaAcknowledgeRequest corbaAckReq = new CorbaAcknowledgeRequest(
					me);
			try {
				corbaAckReq.acknowledge(NodeAddress,headers);
			} catch (Exception e) {
				LOGGER.error("Could not process acknowledge request for FDN: {} and exception is: {}"
						, me.getFdn() , (Throwable) e);
			}
		} else {
			LOGGER.info("Supervision is not started on FDN: {}"
					, NodeAddress);
		}
	}

	private void processSync(final String nodeAddress,
			final Map<String, Object> headers, final boolean skipJobId) {
		LOGGER.debug("ProcessSync called for node: {}",nodeAddress);
		final CorbaManagedElement me = endpoint.getMe(nodeAddress);
		if (me != null) {

			if(!skipJobId) {
			me.setCurrentMsec(Long.parseLong((String) headers.get(Constants.JOB_ID)));
			}
			final CorbaSynchronizeEvents corbaSynch = new CorbaSynchronizeEvents(me);
			try {
				EventNotification[] notifications = corbaSynch
						.getAlarmSynchList();

				final EventNotification[] syncEnd = corbaSynch.stopSynch();
				syncEnd[0].setSyncNotifications(notifications);
				forwardEvents(syncEnd, me,endpoint);
				LOGGER.info("ProcessSync completed for node: {}",nodeAddress);
			} catch (Exception e) {
				final EventNotification[] syncAbort = corbaSynch.abortSynch(me.getFdn(), me.getSourceType());
				forwardEvents(syncAbort, me,endpoint);
				
				LOGGER.error("Exception in processSync: {} for fdn : {}", e.toString(), nodeAddress);
			}
		}else{
			LOGGER.info("Adding the node to SynchPendingNodeMap as start supervision is not received for the node: {}",nodeAddress);

			if(!checkPendingList(nodeAddress)){
				SynchPendingNodeList.add(nodeAddress);
			}
		}

	}

	public static void forwardEvents(final EventNotification[] notifications,
			final CorbaManagedElement me,Endpoint endpoint) {
		if ((notifications != null) && (notifications.length > 0)) {
			final Processor modelTranslator = new EventModelTranslator();
			final Exchange exchange = endpoint.createExchange();
			exchange.getIn().setHeader(CorbaExchangeHeaders.HEADER_TYPE,
					CorbaExchangeHeaders.TYPE_ALARM);
			exchange.getIn().setHeader(CorbaExchangeHeaders.HEADER_ME, me);
			exchange.getIn().setBody(notifications);
			try {

				modelTranslator.process(exchange);
			} catch (Exception e) {
				LOGGER.error("Exception : {} while forwarding event generated during supervision for FDN: {}", e.toString(), me.getFdn());
			}
		}
	}
	
	/**
     * Initiates sync for the network element
     * 
     * @param me
     *            me
     */
    public void initiateSync(final CorbaManagedElement me) {
        LOGGER.info("initiateSync called due to re-connect for FDN : {}", me.getFdn());
        final CorbaSynchronizeEvents sync = new CorbaSynchronizeEvents(me);
        final String nodeAddress = me.getFdn();

        try {
            final EventNotification[] syncStart = sync.startSync();
            forwardEvents(syncStart, me, endpoint);	
            processSync(nodeAddress, new HashMap<String, Object>(),true);
        } catch (final Exception e) {
            LOGGER.error("Exception in initiateSync: {}", e.toString());
        }
    }

	private void processSupervisionOn(final String nodeAddress,
			final Map<String, Object> headers) {
		LOGGER.debug("processSupervisionOn starts for FDN: {}",nodeAddress);
		CorbaManagedElement managedElement = null;
		
		synchronized (this) {
		managedElement = this.endpoint.getMe(nodeAddress);
		if (managedElement != null) {
		managedElement.setCurrentMsec(Long.parseLong((String)headers.get("JobId")));
		LOGGER.info("Discarding supervision request as the supervision already started on this node: {}", nodeAddress);
		}
	}

		if (managedElement == null) {
			final CorbaManagedElement me = new CorbaManagedElement();
			me.setFdn(nodeAddress);
			me.setCurrentMsec(Long.parseLong((String) headers.get(Constants.JOB_ID)));
			initializeManagedElement(me, headers);

			final CorbaSupervision corbaSupervison = new CorbaSupervision(me,
					endpoint.getOrbInit());
			corbaSupervison.setProcessor(endpoint.getConsumer().getProcessor());
			corbaSupervison.setExchange(endpoint.createExchange());
			me.setSupervision(corbaSupervison);
			corbaSupervison.getIor().setSecurityStateComputed(true);
			me.computeIPStack();
			final EventNotification[] notifications = corbaSupervison
					.startSupervision();
			if(notifications !=null){
				forwardEvents(notifications, me,endpoint);
				HBAlarmSender.sendHbAlarm(notifications[0].getManagedObjectInstance() + Constants.DELIMITER + notifications[0].getSeverity());
			}

			endpoint.addMe(me.getFdn(), me);

			endpoint.getHbDispatcher().startSupervision(me);
			try{
				int count = 0;
				
				boolean isSyncPending = checkPendingList(nodeAddress);
				LOGGER.info("SynchPending status for the node: {} is: {}",nodeAddress,isSyncPending);
				if(isSyncPending){
					processSync(nodeAddress, headers, true);

					clearThePendingSynchlist(nodeAddress);
					
					LOGGER.info("Pending synch is completed for node: {}",nodeAddress);
				} else{
					try{
						while (!isSyncPending && count < noSynchMaxRetrival) {
							isSyncPending = checkPendingList(nodeAddress);
							count++;
							if(isSyncPending){
								LOGGER.info("Performing pending synch is for  node: {} , in iteration: {}",nodeAddress,count);
								processSync(nodeAddress, headers, true);
								clearThePendingSynchlist(nodeAddress);
								break;
							}else{
								LOGGER.info("Waiting for sync pending node: {} in iteration: {}",nodeAddress,count);
								Thread.sleep(150);								
							}

						}
					}catch(Exception e){
						LOGGER.error("Exception {} , in waiting and performing the pending sync for the node {}",e.toString(),nodeAddress);
					}
				}
			}catch (Exception e) {
				LOGGER.error("Exception in checking pending Synch for the node: {}",e.toString());
			}
		} 
	}


	private void processSupervisionOff(final String NodeAddress, final long currentMsec) {
        CorbaManagedElement me = null;
        boolean timeCheck = false;
        synchronized (this) {
        me = this.endpoint.getMe(NodeAddress);
        if ((me != null) && (currentMsec > me.getCurrentMsec())) {
		this.endpoint.removeMe(NodeAddress);
		timeCheck = true;
		}
	}
        if (timeCheck) {
            
                LOGGER.info("Stopping Supervision for node " + me.toString());
                try {
                    endpoint.getHbDispatcher().stopSupervision(me);
                    me.getSupervision().stopSupervision();
                } catch (Exception e) {
                    LOGGER.error("Failed to stop supervision fof ME:  {} ", e.toString());
                }

                if (endpoint.getSupervisedNes().size() == 0) {
                    supervisionoffcounter = 0;
                } else {
                    supervisionoffcounter++;
                    LOGGER.info("Total number of nodes under stop supervision is: {}", supervisionoffcounter);
                }
            } else {
                 LOGGER.info("The supervision stop request received in wrong order. So, Stoppong and starting supervision internally for fdn: {}",NodeAddress);
                endpoint.getHbDispatcher().stopSupervision(me);
                me.getSupervision().stopSupervision();

                final EventNotification[] notifications = me.getSupervision().startSupervision();
                if (notifications != null) {
                    forwardEvents(notifications, me, endpoint);
                }

                endpoint.getHbDispatcher().startSupervision(me);
            }
    }

	/**
	 * If no nodes is being supervised by corba component then shutdown the ORB
	 *//*
	private void unusedchekAndShutdownORB() {
		if(endpoint.getSupervisedNes().size() == 0){
			LOGGER.info("There is no more nodes for supervision so will shutdown the orb");
			endpoint.shutdownORB();
		}
	}*/

	private synchronized boolean checkPendingList(String nodeaddress) {
        final boolean isFdnPresent = SynchPendingNodeList.contains(nodeaddress);
        LOGGER.debug("checkPendingList:sync pending status for node: {} , is: {}", nodeaddress, isFdnPresent);
        return isFdnPresent;
    }

    private synchronized void clearThePendingSynchlist(String nodeaddress) {
        final boolean isFdnPresent = SynchPendingNodeList.contains(nodeaddress);
        LOGGER.info("clearThePendingSynchlist:sync pending status for node: {} , is: {}", nodeaddress, isFdnPresent);

        if (isFdnPresent) {
            synchronized (SynchPendingNodeList) {
                LOGGER.info("Removing the Entry from the list for FDN: {}", nodeaddress);
                SynchPendingNodeList.remove(nodeaddress);
            }
        }
    }


	public void process(final Exchange exchange) {
		LOGGER.debug("Process Method in corba Component ");

		final Map<String, Object> headers = exchange.getIn().getHeaders();

		Set<String> keys = headers.keySet();

		for (Iterator<String> i = keys.iterator(); i.hasNext(); )
		{
			String key =  i.next();
			Object value =  headers.get(key);
			LOGGER.debug(key + " = " + value);
		}
		final String task1 = (String)headers.get("task");
		if (task1.equalsIgnoreCase("FmMediationSupervisionRequest")) {
			try{
				final String NodeAddress=(String)headers.get("nodeAddress");
				final String isSupervisionOn=(String)headers.get("isSupervisionOn");

				LOGGER.debug("The task request received is: {}",task1);

				String ossFdn=FDNConverter.convertTorFdnToOssFdn(NodeAddress);
				ossFdn=ossFdn.replace(Constants.FDNATTR, "");
				
				
				
				if (isSupervisionOn.equalsIgnoreCase("true")) {
					
					suspender.setAlarmRateCheckInterval(Integer.parseInt((String)  headers
							.get(NodeSuspenderConfiguration.PARAM_ALARM_RATE_CHECK_INTERVAL)));
					suspender.setAlarmRateFlowControl(Boolean.parseBoolean((String) headers
							.get(NodeSuspenderConfiguration.PARAM_ALARM_RATE_FLOW_CONTROL)));
					suspender.setAlarmRateThreshold(Integer.parseInt((String)  headers
							.get(NodeSuspenderConfiguration.PARAM_ALARM_RATE_THRESHOLD)));
					suspender.setAlarmRateNormalThreshold(Integer.parseInt((String)  headers
							.get(NodeSuspenderConfiguration.PARAM_ALARM_RATE_NORMAL_THRESHOLD)));

					
					processSupervisionOn(ossFdn, headers);
				} else {
					final String jobId = (String) headers.get(Constants.JOB_ID);
					final long msec = Long.parseLong(jobId);
					processSupervisionOff(ossFdn, msec);
				}
			}catch(Exception e){
				LOGGER.error("Error while processing supervision request {}",e.toString());
			}
		} else if (task1.equalsIgnoreCase("FmMediationAlarmSyncRequest")) {
			final String NodeAddress=(String)headers.get("nodeAddress");
			String ossFdn=FDNConverter.convertTorFdnToOssFdn(NodeAddress);
			ossFdn=ossFdn.replace(Constants.FDNATTR, "");
			processSync(ossFdn, headers,false);
		} else if ((task1.equalsIgnoreCase("FmMediationAckRequest"))) {
			final String NodeAddress=(String)headers.get("nodeAddress");
			String ossFdn=FDNConverter.convertTorFdnToOssFdn(NodeAddress);
			ossFdn=ossFdn.replace(Constants.FDNATTR, "");
				processAcknowledge(ossFdn,headers);
		}
	}

}
