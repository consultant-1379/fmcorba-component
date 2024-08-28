package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::StructuredProxyPullSupplier
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/StructuredProxyPullSupplier:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface StructuredProxyPullSupplier : org.omg.CosNotifyChannelAdmin.ProxySupplier,
                                        com.ericsson.irp.CosNotifyComm.StructuredPullSupplier {
  ...
};
 * </pre>
 */
public interface StructuredProxyPullSupplierOperations extends org.omg.CosNotifyChannelAdmin.ProxySupplierOperations, 
                                                               com.ericsson.irp.CosNotifyComm.StructuredPullSupplierOperations {
  /**
   * <pre>
   *   void connect_structured_pull_consumer (in com.ericsson.irp.CosNotifyComm.StructuredPullConsumer pull_consumer)
    raises (com.ericsson.irp.CosEventChannelAdmin.AlreadyConnected);
   * </pre>
   */
  public void connect_structured_pull_consumer (com.ericsson.irp.CosNotifyComm.StructuredPullConsumer pull_consumer) throws com.ericsson.irp.CosEventChannelAdmin.AlreadyConnected;

}
