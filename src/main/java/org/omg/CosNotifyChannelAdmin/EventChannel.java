package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::EventChannel
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/EventChannel:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface EventChannel : org.omg.CosNotification.QoSAdmin,
                         org.omg.CosNotification.AdminPropertiesAdmin,
                         com.ericsson.irp.CosEventChannelAdmin.EventChannel {
  ...
};
 * </pre>
 */
public interface EventChannel extends org.omg.CosNotifyChannelAdmin.EventChannelOperations, org.omg.CosNotification.QoSAdmin, 
                                                                                            org.omg.CosNotification.AdminPropertiesAdmin, 
                                                                                            com.ericsson.irp.CosEventChannelAdmin.EventChannel, org.omg.CORBA.portable.IDLEntity {
}
