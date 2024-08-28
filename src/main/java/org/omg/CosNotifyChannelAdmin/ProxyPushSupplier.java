package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::ProxyPushSupplier
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/ProxyPushSupplier:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface ProxyPushSupplier : org.omg.CosNotifyChannelAdmin.ProxySupplier,
                              com.ericsson.irp.CosNotifyComm.PushSupplier {
  ...
};
 * </pre>
 */
public interface ProxyPushSupplier extends org.omg.CosNotifyChannelAdmin.ProxyPushSupplierOperations, org.omg.CosNotifyChannelAdmin.ProxySupplier, 
                                                                                                      com.ericsson.irp.CosNotifyComm.PushSupplier, org.omg.CORBA.portable.IDLEntity {
}
