package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::ProxyPushSupplier
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/ProxyPushSupplier:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface ProxyPushSupplier : org.omg.CosNotifyChannelAdmin.ProxySupplier,
                              com.ericsson.irp.CosNotifyComm.PushSupplier {
  ...
};
 * </pre>
 */
public interface ProxyPushSupplierOperations extends org.omg.CosNotifyChannelAdmin.ProxySupplierOperations, 
                                                     com.ericsson.irp.CosNotifyComm.PushSupplierOperations {
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
   *   void connect_any_push_consumer (in com.ericsson.irp.CosEventComm.PushConsumer push_consumer)
    raises (com.ericsson.irp.CosEventChannelAdmin.AlreadyConnected,
            com.ericsson.irp.CosEventChannelAdmin.TypeError);
   * </pre>
   */
  public void connect_any_push_consumer (com.ericsson.irp.CosEventComm.PushConsumer push_consumer) throws com.ericsson.irp.CosEventChannelAdmin.AlreadyConnected, 
                                                                                                          com.ericsson.irp.CosEventChannelAdmin.TypeError;

}
