package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::ProxyPullConsumer
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/ProxyPullConsumer:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface ProxyPullConsumer : org.omg.CosNotifyChannelAdmin.ProxyConsumer,
                              com.ericsson.irp.CosNotifyComm.PullConsumer {
  ...
};
 * </pre>
 */
public interface ProxyPullConsumerOperations extends org.omg.CosNotifyChannelAdmin.ProxyConsumerOperations, 
                                                     com.ericsson.irp.CosNotifyComm.PullConsumerOperations {
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
   *   void connect_any_pull_supplier (in com.ericsson.irp.CosEventComm.PullSupplier pull_supplier)
    raises (com.ericsson.irp.CosEventChannelAdmin.AlreadyConnected,
            com.ericsson.irp.CosEventChannelAdmin.TypeError);
   * </pre>
   */
  public void connect_any_pull_supplier (com.ericsson.irp.CosEventComm.PullSupplier pull_supplier) throws com.ericsson.irp.CosEventChannelAdmin.AlreadyConnected, 
                                                                                                          com.ericsson.irp.CosEventChannelAdmin.TypeError;

}
