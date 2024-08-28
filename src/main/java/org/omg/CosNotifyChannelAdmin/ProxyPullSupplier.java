package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::ProxyPullSupplier
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/ProxyPullSupplier:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface ProxyPullSupplier : org.omg.CosNotifyChannelAdmin.ProxySupplier,
                              com.ericsson.irp.CosNotifyComm.PullSupplier {
  ...
};
 * </pre>
 */
public interface ProxyPullSupplier extends org.omg.CosNotifyChannelAdmin.ProxyPullSupplierOperations, org.omg.CosNotifyChannelAdmin.ProxySupplier, 
                                                                                                      com.ericsson.irp.CosNotifyComm.PullSupplier, org.omg.CORBA.portable.IDLEntity {
}
