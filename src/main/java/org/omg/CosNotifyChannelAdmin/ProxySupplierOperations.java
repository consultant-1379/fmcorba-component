package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::ProxySupplier
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/ProxySupplier:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface ProxySupplier : org.omg.CosNotification.QoSAdmin,
                          com.ericsson.irp.CosNotifyFilter.FilterAdmin {
  ...
};
 * </pre>
 */
public interface ProxySupplierOperations extends org.omg.CosNotification.QoSAdminOperations, 
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
   *   org.omg.CosNotification.EventTypeSeq obtain_offered_types (in org.omg.CosNotifyChannelAdmin.ObtainInfoMode mode);
   * </pre>
   */
  public org.omg.CosNotification.EventType[] obtain_offered_types (org.omg.CosNotifyChannelAdmin.ObtainInfoMode mode);

  /**
   * <pre>
   *   attribute com.ericsson.irp.CosNotifyFilter.MappingFilter lifetime_filter;
   * </pre>
   */
  public com.ericsson.irp.CosNotifyFilter.MappingFilter lifetime_filter ();

  /**
   * <pre>
   *   attribute com.ericsson.irp.CosNotifyFilter.MappingFilter lifetime_filter;
   * </pre>
   */
  public void lifetime_filter (com.ericsson.irp.CosNotifyFilter.MappingFilter arg0);

  /**
   * <pre>
   *   attribute com.ericsson.irp.CosNotifyFilter.MappingFilter priority_filter;
   * </pre>
   */
  public com.ericsson.irp.CosNotifyFilter.MappingFilter priority_filter ();

  /**
   * <pre>
   *   attribute com.ericsson.irp.CosNotifyFilter.MappingFilter priority_filter;
   * </pre>
   */
  public void priority_filter (com.ericsson.irp.CosNotifyFilter.MappingFilter arg0);

  /**
   * <pre>
   *   readonly attribute org.omg.CosNotifyChannelAdmin.ConsumerAdmin MyAdmin;
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.ConsumerAdmin MyAdmin ();

  /**
   * <pre>
   *   readonly attribute org.omg.CosNotifyChannelAdmin.ProxyType MyType;
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.ProxyType MyType ();

}
