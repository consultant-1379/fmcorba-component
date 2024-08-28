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
package com.ericsson.oss.mediation.supervision.corba.testsuite;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.oss.itpf.sdk.eventbus.model.EventSender;

@SuppressWarnings("rawtypes")
class MockEventSender implements EventSender {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(MockEventSender.class);

	
	private List recvList = null;
	private int recdCount = 0;
	private boolean allOK = true;

	public boolean isAllOK() {
		return allOK;
	}


	public int getRecdCount() {
		return recdCount;
	}

	public void reset() {
		allOK = true;
		recdCount = 0;
		setRecvList(null);
	}


	@Override
	public void send(Object arg0) {
		LOGGER.debug(Thread.currentThread().getName() + "ID = " + Thread.currentThread().getId() + "Received Object " + arg0.toString());
		allOK = false;
	}


	@Override
	public void send(List arg0) {
		setRecvList(arg0);
		recdCount++;
		LOGGER.debug(Thread.currentThread().getName() + "ID = " + Thread.currentThread().getId() +"Received List " + arg0.toString() + " count=" + recdCount);

	}


	@Override
	public void send(Object arg0, String arg1) {
		allOK = false;
	}


	@Override
	public void send(List arg0, String arg1) {
		allOK = false;
	}


	/**
	 * @return the recvList
	 */
	public List getRecvList() {
		return recvList;
	}


	/**
	 * @param recvList the recvList to set
	 */
	public void setRecvList(List recvList) {
		this.recvList = recvList;
	}
}
