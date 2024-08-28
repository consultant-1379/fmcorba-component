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
public interface ProxyPullSupplierOperations extends org.omg.CosNotifyChannelAdmin.ProxySupplierOperations, 
                                                     com.ericsson.irp.CosNotifyComm.PullSupplierOperations {
  /**
   * <pre>
   *   void connect_any_pull_consumer (in com.ericsson.irp.CosEventComm.PullConsumer pull_consumer)
    raises (com.ericsson.irp.CosEventChannelAdmin.AlreadyConnected);
   * </pre>
   */
  public void connect_any_pull_consumer (com.ericsson.irp.CosEventComm.PullConsumer pull_consumer) throws com.ericsson.irp.CosEventChannelAdmin.AlreadyConnected;

}
