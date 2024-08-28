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
package com.ericsson.oss.mediation.supervision.corba.common;

import java.net.URL;

import org.jacorb.orb.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.irp.AlarmIRPSystem._AlarmIRPOperations;
import com.ericsson.irp.AlarmIRPSystem._AlarmIRPOperationsHelper;
import com.ericsson.irp.NotificationIRPSystem._NotificationIRPOperations;
import com.ericsson.irp.NotificationIRPSystem._NotificationIRPOperationsHelper;
import com.ericsson.oss.mediation.supervision.corba.CorbaManagedElement;
import com.ericsson.oss.mediation.supervision.corba.orbinitialize.OrbInitializer;

public class IORControl {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(IORControl.class);
	private final CorbaManagedElement managedElement;
	private final OrbInitializer orbInit;
	private boolean securityStateComputed;

	private final String Uri;
	private _AlarmIRPOperations alarmIrpObj = null;
	private _NotificationIRPOperations notifIrpObj = null;

	public IORControl(final CorbaManagedElement managedElement,
			final OrbInitializer orbInit) {
		this.managedElement = managedElement;
		this.Uri = managedElement.getNamingUrl();
		this.orbInit = orbInit;

	}


	public _AlarmIRPOperations getAlarmIRPObj() {
		if (alarmIrpObj == null) {
			alarmIrpObj = getAlarmIRPCORBAObject();

		}

		return alarmIrpObj;
	}

	public _AlarmIRPOperations getAlarmIRPCORBAObject() {
		if (!managedElement.isSecure()) {

			alarmIrpObj = getAlarmIRPCORBAObject(orbInit.getOrb(managedElement.isIPv6Node()));

		} else {

			alarmIrpObj = getAlarmIRPCORBAObject(orbInit.getSecureOrb(managedElement.isIPv6Node()));

		}

		return alarmIrpObj;
	}

	private _AlarmIRPOperations getAlarmIRPCORBAObject(final ORB orb) {
		_AlarmIRPOperations tmpAlarmIrpObj = null;
		NamingContext rootContext = null;
		URL url = null;
		try {
			url = new URL(Uri);
			rootContext = CorbaNamingContext.getNamingContext(url,orb);
			Object myAlarmIRPObj = null;
			final NameComponent[] names = new NameComponent[1];
			names[0] = new NameComponent(
					managedElement.getAlarmIrpNamingContext(), "");
			myAlarmIRPObj = rootContext.resolve(names);
			tmpAlarmIrpObj = _AlarmIRPOperationsHelper
					.narrow((org.omg.CORBA.Object) myAlarmIRPObj);
		} catch (Exception e) {
			tmpAlarmIrpObj = null;
			LOGGER.error("Could not get AlarmIRP reference for FDN: "
					+ managedElement.getFdn()+ (Throwable) e);
		}finally{
			if(rootContext != null){
				CorbaNamingContext.releaseNamingContext(rootContext);
			}
		}

		return tmpAlarmIrpObj;
	}

	public _NotificationIRPOperations getNotifIrpObj() {
		if (notifIrpObj == null) {
			notifIrpObj = getNotifIRPCORBAObject();
		}
		return notifIrpObj;
	}

	private _NotificationIRPOperations getNotifIRPCORBAObject() {
		_NotificationIRPOperations tmpNotifIrpObj = null;
		if (!managedElement.isSecure()) {
			tmpNotifIrpObj = getNotifIRPCORBAObject(orbInit.getOrb(managedElement.isIPv6Node()));
		} 
		else {
			tmpNotifIrpObj = getNotifIRPCORBAObject(orbInit.getSecureOrb(managedElement.isIPv6Node()));
		}
		return tmpNotifIrpObj;
	}

	private _NotificationIRPOperations getNotifIRPCORBAObject(final ORB orb) {
		Object myNotifIRPObj;
		_NotificationIRPOperations tmpNotifIrpObj = null;
		URL url = null;
		NamingContext rootContext = null;
		try {
			url = new URL(Uri);
			rootContext = CorbaNamingContext.getNamingContext(url,orb);
			final NameComponent[] names = new NameComponent[1];
			names[0] = new NameComponent(
					managedElement.getNotifcationIrpNamingContext(), "");
			myNotifIRPObj = rootContext.resolve(names);
			tmpNotifIrpObj = _NotificationIRPOperationsHelper
					.narrow((org.omg.CORBA.Object) myNotifIRPObj);
		} catch (org.omg.CORBA.NO_PERMISSION e1) {
			tmpNotifIrpObj = null;
		} catch (Exception e) {
			tmpNotifIrpObj = null;
			LOGGER.debug("Failed to resolve notification IRP for FDN: {} ,Exception is : {}",managedElement.getFdn(),e.toString());
		}finally{
			if(rootContext != null){
				CorbaNamingContext.releaseNamingContext(rootContext);
			}
		}
		return tmpNotifIrpObj;
	}
	
	public void removeIRPReferences(){
		removeNotifIRPObj();
		removeAlarmIRPObj();
	}

	public void removeNotifIRPObj() {
		if(notifIrpObj != null){
			try{
			notifIrpObj._release();
			}catch(Exception e){
				LOGGER.error("removeNotifIRPObj failed "+e);
			}
		}
		notifIrpObj = null;
	}

	public void removeAlarmIRPObj() {
		if(alarmIrpObj != null){
			try{
				alarmIrpObj._release();
			}catch(Exception e){
				LOGGER.error("removeAlarmIRPObj failed "+e);
			}
		}
		alarmIrpObj = null;
	}
	public boolean isNodeSecure(){
		_NotificationIRPOperations tmpNotifIrpObj = null;
		boolean secure = false;
		tmpNotifIrpObj = getNotifIRPCORBAObject(orbInit.getOrb(managedElement.isIPv6Node()));
		if(tmpNotifIrpObj != null){
			secure =  false;
		}else{
			tmpNotifIrpObj = getNotifIRPCORBAObject(orbInit.getSecureOrb(managedElement.isIPv6Node()));
			if(tmpNotifIrpObj != null){
				secure = true;
			}
		}
		
		notifIrpObj = tmpNotifIrpObj;
		if(notifIrpObj == null){
			setSecurityStateComputed(false);
		}else{
			setSecurityStateComputed(true);
		}
		LOGGER.debug("notifIrpObj:"+notifIrpObj+"secure:"+secure);
		return secure;
	}


	/**
	 * @return the securityStateComputed
	 */
	public boolean isSecurityStateComputed() {
		return securityStateComputed;
	}


	/**
	 * @param securityStateComputed the securityStateComputed to set
	 */
	public void setSecurityStateComputed(boolean securityStateComputed) {
		this.securityStateComputed = securityStateComputed;
	}
	
}
