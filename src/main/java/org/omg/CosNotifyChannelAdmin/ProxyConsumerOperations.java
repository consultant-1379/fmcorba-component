package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::ProxyConsumer
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/ProxyConsumer:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface ProxyConsumer : org.omg.CosNotification.QoSAdmin,
                          com.ericsson.irp.CosNotifyFilter.FilterAdmin {
  ...
};
 * </pre>
 */
public interface ProxyConsumerOperations extends org.omg.CosNotification.QoSAdminOperations, 
                                                 com.ericsson.irp.CosNotifyFilter.FilterAdminOperations {
  /**
   * <pre>
   *   void validate_event_qos (in org.omg.CosNotification.QoSProperties required_qos,
                           out org.omg.CosNotification.NamedPropertyRangeSeq available_qos)
    raises (org.omg.CosNotification.UnsupportedQoS);
   * </pre>
   */
  public void validate_event_qos (org.omg.CosNotification.Property[] required_qos, 
                                  org.omg.CosNotification.NamedPropertyRangeSeqHolder available_qos) throws org.omg.CosNotification.UnsupportedQoS;

  /**
   * <pre>
   *   org.omg.CosNotification.EventTypeSeq obtain_subscription_types (in org.omg.CosNotifyChannelAdmin.ObtainInfoMode mode);
   * </pre>
   */
  public org.omg.CosNotification.EventType[] obtain_subscription_types (org.omg.CosNotifyChannelAdmin.ObtainInfoMode mode);

  /**
   * <pre>
   *   readonly attribute org.omg.CosNotifyChannelAdmin.SupplierAdmin MyAdmin;
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.SupplierAdmin MyAdmin ();

  /**
   * <pre>
   *   readonly attribute org.omg.CosNotifyChannelAdmin.ProxyType MyType;
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.ProxyType MyType ();

}
