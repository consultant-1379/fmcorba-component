package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::SequenceProxyPushConsumer
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/SequenceProxyPushConsumer:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface SequenceProxyPushConsumer : org.omg.CosNotifyChannelAdmin.ProxyConsumer,
                                      com.ericsson.irp.CosNotifyComm.SequencePushConsumer {
  ...
};
 * </pre>
 */
public interface SequenceProxyPushConsumerOperations extends org.omg.CosNotifyChannelAdmin.ProxyConsumerOperations, 
                                                             com.ericsson.irp.CosNotifyComm.SequencePushConsumerOperations {
  /**
   * <pre>
   *   void connect_sequence_push_supplier (in com.ericsson.irp.CosNotifyComm.SequencePushSupplier push_supplier)
    raises (com.ericsson.irp.CosEventChannelAdmin.AlreadyConnected);
   * </pre>
   */
  public void connect_sequence_push_supplier (com.ericsson.irp.CosNotifyComm.SequencePushSupplier push_supplier) throws com.ericsson.irp.CosEventChannelAdmin.AlreadyConnected;

}
