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
public interface SequenceProxyPullSupplierOperations extends org.omg.CosNotifyChannelAdmin.ProxySupplierOperations, 
                                                             com.ericsson.irp.CosNotifyComm.SequencePullSupplierOperations {
  /**
   * <pre>
   *   void connect_sequence_pull_consumer (in com.ericsson.irp.CosNotifyComm.SequencePullConsumer pull_consumer)
    raises (com.ericsson.irp.CosEventChannelAdmin.AlreadyConnected);
   * </pre>
   */
  public void connect_sequence_pull_consumer (com.ericsson.irp.CosNotifyComm.SequencePullConsumer pull_consumer) throws com.ericsson.irp.CosEventChannelAdmin.AlreadyConnected;

}
