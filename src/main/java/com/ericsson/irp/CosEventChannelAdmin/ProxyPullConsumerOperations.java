package com.ericsson.irp.CosEventChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosEventChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosEventChannelAdmin::ProxyPullConsumer
 * <li> <b>Repository Id</b> IDL:omg.org/CosEventChannelAdmin/ProxyPullConsumer:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface ProxyPullConsumer : com.ericsson.irp.CosEventComm.PullConsumer {
  ...
};
 * </pre>
 */
public interface ProxyPullConsumerOperations extends com.ericsson.irp.CosEventComm.PullConsumerOperations {
  /**
   * <pre>
   *   void connect_pull_supplier (in com.ericsson.irp.CosEventComm.PullSupplier pull_supplier)
    raises (com.ericsson.irp.CosEventChannelAdmin.AlreadyConnected,
            com.ericsson.irp.CosEventChannelAdmin.TypeError);
   * </pre>
   */
  public void connect_pull_supplier (com.ericsson.irp.CosEventComm.PullSupplier pull_supplier) throws com.ericsson.irp.CosEventChannelAdmin.AlreadyConnected, 
                                                                                                      com.ericsson.irp.CosEventChannelAdmin.TypeError;

}
