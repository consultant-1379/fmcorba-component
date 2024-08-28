package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::ProxySupplier
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/ProxySupplier:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface ProxySupplier : org.omg.CosNotification.QoSAdmin,
                          com.ericsson.irp.CosNotifyFilter.FilterAdmin {
  ...
};
 * </pre>
 */
public interface ProxySupplier extends org.omg.CosNotifyChannelAdmin.ProxySupplierOperations, org.omg.CosNotification.QoSAdmin, 
                                                                                              com.ericsson.irp.CosNotifyFilter.FilterAdmin, org.omg.CORBA.portable.IDLEntity {
}
