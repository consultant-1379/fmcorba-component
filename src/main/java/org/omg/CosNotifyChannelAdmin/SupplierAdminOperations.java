package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::SupplierAdmin
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/SupplierAdmin:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface SupplierAdmin : org.omg.CosNotification.QoSAdmin,
                          com.ericsson.irp.CosNotifyComm.NotifyPublish,
                          com.ericsson.irp.CosNotifyFilter.FilterAdmin,
                          com.ericsson.irp.CosEventChannelAdmin.SupplierAdmin {
  ...
};
 * </pre>
 */
public interface SupplierAdminOperations extends org.omg.CosNotification.QoSAdminOperations, 
                                                 com.ericsson.irp.CosNotifyComm.NotifyPublishOperations, 
                                                 com.ericsson.irp.CosNotifyFilter.FilterAdminOperations, 
                                                 com.ericsson.irp.CosEventChannelAdmin.SupplierAdminOperations {
  /**
   * <pre>
   *   void destroy ();
   * </pre>
   */
  public void destroy ();

  /**
   * <pre>
   *   org.omg.CosNotifyChannelAdmin.ProxyConsumer obtain_notification_push_consumer (in org.omg.CosNotifyChannelAdmin.ClientType ctype,
                                                                                 out org.omg.CosNotifyChannelAdmin.ProxyID proxy_id)
    raises (org.omg.CosNotifyChannelAdmin.AdminLimitExceeded);
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.ProxyConsumer obtain_notification_push_consumer (org.omg.CosNotifyChannelAdmin.ClientType ctype, 
                                                                                        org.omg.CORBA.IntHolder proxy_id) throws org.omg.CosNotifyChannelAdmin.AdminLimitExceeded;

  /**
   * <pre>
   *   org.omg.CosNotifyChannelAdmin.ProxyConsumer obtain_notification_pull_consumer (in org.omg.CosNotifyChannelAdmin.ClientType ctype,
                                                                                 out org.omg.CosNotifyChannelAdmin.ProxyID proxy_id)
    raises (org.omg.CosNotifyChannelAdmin.AdminLimitExceeded);
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.ProxyConsumer obtain_notification_pull_consumer (org.omg.CosNotifyChannelAdmin.ClientType ctype, 
                                                                                        org.omg.CORBA.IntHolder proxy_id) throws org.omg.CosNotifyChannelAdmin.AdminLimitExceeded;

  /**
   * <pre>
   *   org.omg.CosNotifyChannelAdmin.ProxyConsumer get_proxy_consumer (in org.omg.CosNotifyChannelAdmin.ProxyID proxy_id)
    raises (org.omg.CosNotifyChannelAdmin.ProxyNotFound);
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.ProxyConsumer get_proxy_consumer (int proxy_id) throws org.omg.CosNotifyChannelAdmin.ProxyNotFound;

  /**
   * <pre>
   *   readonly attribute org.omg.CosNotifyChannelAdmin.ProxyIDSeq push_consumers;
   * </pre>
   */
  public int[] push_consumers ();

  /**
   * <pre>
   *   readonly attribute org.omg.CosNotifyChannelAdmin.ProxyIDSeq pull_consumers;
   * </pre>
   */
  public int[] pull_consumers ();

  /**
   * <pre>
   *   readonly attribute org.omg.CosNotifyChannelAdmin.InterFilterGroupOperator MyOperator;
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.InterFilterGroupOperator MyOperator ();

  /**
   * <pre>
   *   readonly attribute org.omg.CosNotifyChannelAdmin.EventChannel MyChannel;
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.EventChannel MyChannel ();

  /**
   * <pre>
   *   readonly attribute org.omg.CosNotifyChannelAdmin.AdminID MyID;
   * </pre>
   */
  public int MyID ();

}
