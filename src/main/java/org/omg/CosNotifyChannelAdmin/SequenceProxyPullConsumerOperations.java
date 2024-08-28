package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::SequenceProxyPullConsumer
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/SequenceProxyPullConsumer:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface SequenceProxyPullConsumer : org.omg.CosNotifyChannelAdmin.ProxyConsumer,
                                      com.ericsson.irp.CosNotifyComm.SequencePullConsumer {
  ...
};
 * </pre>
 */
public interface SequenceProxyPullConsumerOperations extends org.omg.CosNotifyChannelAdmin.ProxyConsumerOperations, 
                                                             com.ericsson.irp.CosNotifyComm.SequencePullConsumerOperations {
  /**
   * <pre>
   *   void resume_connection ()
    raises (org.omg.CosNotifyChannelAdmin.ConnectionAlreadyActive,
            org.omg.CosNotifyChannelAdmin.NotConnected);
   * </pre>
   */
  public void resume_connection () throws org.omg.CosNotifyChannelAdmin.ConnectionAlreadyActive, 
                                          org.omg.CosNotifyChannelAdmin.NotConnected;

  /**
   * <pre>
   *   void suspend_connection ()
    raises (org.omg.CosNotifyChannelAdmin.ConnectionAlreadyInactive,
            org.omg.CosNotifyChannelAdmin.NotConnected);
   * </pre>
   */
  public void suspend_connection () throws org.omg.CosNotifyChannelAdmin.ConnectionAlreadyInactive, 
                                           org.omg.CosNotifyChannelAdmin.NotConnected;

  /**
   * <pre>
   *   void connect_sequence_pull_supplier (in com.ericsson.irp.CosNotifyComm.SequencePullSupplier pull_supplier)
    raises (com.ericsson.irp.CosEventChannelAdmin.AlreadyConnected,
            com.ericsson.irp.CosEventChannelAdmin.TypeError);
   * </pre>
   */
  public void connect_sequence_pull_supplier (com.ericsson.irp.CosNotifyComm.SequencePullSupplier pull_supplier) throws com.ericsson.irp.CosEventChannelAdmin.AlreadyConnected, 
                                                                                                                        com.ericsson.irp.CosEventChannelAdmin.TypeError;

}
