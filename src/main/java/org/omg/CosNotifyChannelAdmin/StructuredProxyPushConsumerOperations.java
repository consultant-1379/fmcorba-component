package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::StructuredProxyPushConsumer
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/StructuredProxyPushConsumer:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface StructuredProxyPushConsumer : org.omg.CosNotifyChannelAdmin.ProxyConsumer,
                                        com.ericsson.irp.CosNotifyComm.StructuredPushConsumer {
  ...
};
 * </pre>
 */
public interface StructuredProxyPushConsumerOperations extends org.omg.CosNotifyChannelAdmin.ProxyConsumerOperations, 
                                                               com.ericsson.irp.CosNotifyComm.StructuredPushConsumerOperations {
  /**
   * <pre>
   *   void connect_structured_push_supplier (in com.ericsson.irp.CosNotifyComm.StructuredPushSupplier push_supplier)
    raises (com.ericsson.irp.CosEventChannelAdmin.AlreadyConnected);
   * </pre>
   */
  public void connect_structured_push_supplier (com.ericsson.irp.CosNotifyComm.StructuredPushSupplier push_supplier) throws com.ericsson.irp.CosEventChannelAdmin.AlreadyConnected;

}
