package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::ProxyPushConsumer
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/ProxyPushConsumer:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface ProxyPushConsumer : org.omg.CosNotifyChannelAdmin.ProxyConsumer,
                              com.ericsson.irp.CosNotifyComm.PushConsumer {
  ...
};
 * </pre>
 */
public interface ProxyPushConsumerOperations extends org.omg.CosNotifyChannelAdmin.ProxyConsumerOperations, 
                                                     com.ericsson.irp.CosNotifyComm.PushConsumerOperations {
  /**
   * <pre>
   *   void connect_any_push_supplier (in com.ericsson.irp.CosEventComm.PushSupplier push_supplier)
    raises (com.ericsson.irp.CosEventChannelAdmin.AlreadyConnected);
   * </pre>
   */
  public void connect_any_push_supplier (com.ericsson.irp.CosEventComm.PushSupplier push_supplier) throws com.ericsson.irp.CosEventChannelAdmin.AlreadyConnected;

}
