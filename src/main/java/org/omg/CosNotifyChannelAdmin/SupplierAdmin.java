package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::SupplierAdmin
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/SupplierAdmin:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface SupplierAdmin : org.omg.CosNotification.QoSAdmin,
                          com.ericsson.irp.CosNotifyComm.NotifyPublish,
                          com.ericsson.irp.CosNotifyFilter.FilterAdmin,
                          com.ericsson.irp.CosEventChannelAdmin.SupplierAdmin {
  ...
};
 * </pre>
 */
public interface SupplierAdmin extends org.omg.CosNotifyChannelAdmin.SupplierAdminOperations, org.omg.CosNotification.QoSAdmin, 
                                                                                              com.ericsson.irp.CosNotifyComm.NotifyPublish, 
                                                                                              com.ericsson.irp.CosNotifyFilter.FilterAdmin, 
                                                                                              com.ericsson.irp.CosEventChannelAdmin.SupplierAdmin, org.omg.CORBA.portable.IDLEntity {
}
