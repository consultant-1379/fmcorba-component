package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::StructuredProxyPushSupplier
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/StructuredProxyPushSupplier:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface StructuredProxyPushSupplier : org.omg.CosNotifyChannelAdmin.ProxySupplier,
                                        com.ericsson.irp.CosNotifyComm.StructuredPushSupplier {
  ...
};
 * </pre>
 */
public interface StructuredProxyPushSupplierOperations extends org.omg.CosNotifyChannelAdmin.ProxySupplierOperations, 
                                                               com.ericsson.irp.CosNotifyComm.StructuredPushSupplierOperations {
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
   *   void connect_structured_push_consumer (in com.ericsson.irp.CosNotifyComm.StructuredPushConsumer push_consumer)
    raises (com.ericsson.irp.CosEventChannelAdmin.AlreadyConnected,
            com.ericsson.irp.CosEventChannelAdmin.TypeError);
   * </pre>
   */
  public void connect_structured_push_consumer (com.ericsson.irp.CosNotifyComm.StructuredPushConsumer push_consumer) throws com.ericsson.irp.CosEventChannelAdmin.AlreadyConnected, 
                                                                                                                            com.ericsson.irp.CosEventChannelAdmin.TypeError;

}
