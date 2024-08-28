package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::StructuredProxyPullConsumer
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/StructuredProxyPullConsumer:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface StructuredProxyPullConsumer : org.omg.CosNotifyChannelAdmin.ProxyConsumer,
                                        com.ericsson.irp.CosNotifyComm.StructuredPullConsumer {
  ...
};
 * </pre>
 */
public interface StructuredProxyPullConsumerOperations extends org.omg.CosNotifyChannelAdmin.ProxyConsumerOperations, 
                                                               com.ericsson.irp.CosNotifyComm.StructuredPullConsumerOperations {
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
   *   void connect_structured_pull_supplier (in com.ericsson.irp.CosNotifyComm.StructuredPullSupplier pull_supplier)
    raises (com.ericsson.irp.CosEventChannelAdmin.AlreadyConnected,
            com.ericsson.irp.CosEventChannelAdmin.TypeError);
   * </pre>
   */
  public void connect_structured_pull_supplier (com.ericsson.irp.CosNotifyComm.StructuredPullSupplier pull_supplier) throws com.ericsson.irp.CosEventChannelAdmin.AlreadyConnected, 
                                                                                                                            com.ericsson.irp.CosEventChannelAdmin.TypeError;

}
