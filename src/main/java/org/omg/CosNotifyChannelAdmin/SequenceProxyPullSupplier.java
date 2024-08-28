package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::SequenceProxyPullSupplier
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/SequenceProxyPullSupplier:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface SequenceProxyPullSupplier : org.omg.CosNotifyChannelAdmin.ProxySupplier,
                                      com.ericsson.irp.CosNotifyComm.SequencePullSupplier {
  ...
};
 * </pre>
 */
public interface SequenceProxyPullSupplier extends org.omg.CosNotifyChannelAdmin.SequenceProxyPullSupplierOperations, org.omg.CosNotifyChannelAdmin.ProxySupplier, 
                                                                                                                      com.ericsson.irp.CosNotifyComm.SequencePullSupplier, org.omg.CORBA.portable.IDLEntity {
}
