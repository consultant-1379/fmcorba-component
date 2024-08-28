package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::ConsumerAdmin
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/ConsumerAdmin:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface ConsumerAdmin : org.omg.CosNotification.QoSAdmin,
                          com.ericsson.irp.CosNotifyComm.NotifySubscribe,
                          com.ericsson.irp.CosNotifyFilter.FilterAdmin,
                          com.ericsson.irp.CosEventChannelAdmin.ConsumerAdmin {
  ...
};
 * </pre>
 */
public interface ConsumerAdmin extends org.omg.CosNotifyChannelAdmin.ConsumerAdminOperations, org.omg.CosNotification.QoSAdmin, 
                                                                                              com.ericsson.irp.CosNotifyComm.NotifySubscribe, 
                                                                                              com.ericsson.irp.CosNotifyFilter.FilterAdmin, 
                                                                                              com.ericsson.irp.CosEventChannelAdmin.ConsumerAdmin, org.omg.CORBA.portable.IDLEntity {
}
