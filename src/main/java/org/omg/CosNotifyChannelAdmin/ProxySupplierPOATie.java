
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
public class ProxySupplierPOATie extends ProxySupplierPOA {
  private org.omg.CosNotifyChannelAdmin.ProxySupplierOperations _delegate;
  private org.omg.PortableServer.POA _poa;

  public ProxySupplierPOATie (final org.omg.CosNotifyChannelAdmin.ProxySupplierOperations _delegate) {
    this._delegate = _delegate;
  }

  public ProxySupplierPOATie (final org.omg.CosNotifyChannelAdmin.ProxySupplierOperations _delegate, 
                              final org.omg.PortableServer.POA _poa) {
    this._delegate = _delegate;
    this._poa = _poa;
  }

  public org.omg.CosNotifyChannelAdmin.ProxySupplierOperations _delegate () {
    return this._delegate;
  }

  public void _delegate (final org.omg.CosNotifyChannelAdmin.ProxySupplierOperations the_delegate) {
    this._delegate = the_delegate;
  }

  public org.omg.PortableServer.POA _default_POA () {
    if (_poa != null) {
      return _poa;
    } 
    else {
      return super._default_POA();
    }
  }

  /**
   * <pre>
   *   void validate_event_qos (in org.omg.CosNotification.QoSProperties required_qos,
                           out org.omg.CosNotification.NamedPropertyRangeSeq available_qos)
    raises (org.omg.CosNotification.UnsupportedQoS);
   * </pre>
   */
  public void validate_event_qos (org.omg.CosNotification.Property[] required_qos, 
                                  org.omg.CosNotification.NamedPropertyRangeSeqHolder available_qos) throws  org.omg.CosNotification.UnsupportedQoS {
    this._delegate.validate_event_qos(required_qos, available_qos);
  }

  /**
   * <pre>
   *   org.omg.CosNotification.EventTypeSeq obtain_offered_types (in org.omg.CosNotifyChannelAdmin.ObtainInfoMode mode);
   * </pre>
   */
  public org.omg.CosNotification.EventType[] obtain_offered_types (org.omg.CosNotifyChannelAdmin.ObtainInfoMode mode) {
    return this._delegate.obtain_offered_types(mode);
  }

  /**
   * <pre>
   *   attribute com.ericsson.irp.CosNotifyFilter.MappingFilter lifetime_filter;
   * </pre>
   */
  public com.ericsson.irp.CosNotifyFilter.MappingFilter lifetime_filter () {
    return this._delegate.lifetime_filter();
  }

  /**
   * <pre>
   *   attribute com.ericsson.irp.CosNotifyFilter.MappingFilter lifetime_filter;
   * </pre>
   */
  public void lifetime_filter (com.ericsson.irp.CosNotifyFilter.MappingFilter arg0) {
    this._delegate.lifetime_filter(arg0);
  }

  /**
   * <pre>
   *   attribute com.ericsson.irp.CosNotifyFilter.MappingFilter priority_filter;
   * </pre>
   */
  public com.ericsson.irp.CosNotifyFilter.MappingFilter priority_filter () {
    return this._delegate.priority_filter();
  }

  /**
   * <pre>
   *   attribute com.ericsson.irp.CosNotifyFilter.MappingFilter priority_filter;
   * </pre>
   */
  public void priority_filter (com.ericsson.irp.CosNotifyFilter.MappingFilter arg0) {
    this._delegate.priority_filter(arg0);
  }

  /**
   * <pre>
   *   readonly attribute org.omg.CosNotifyChannelAdmin.ConsumerAdmin MyAdmin;
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.ConsumerAdmin MyAdmin () {
    return this._delegate.MyAdmin();
  }

  /**
   * <pre>
   *   readonly attribute org.omg.CosNotifyChannelAdmin.ProxyType MyType;
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.ProxyType MyType () {
    return this._delegate.MyType();
  }

  /**
   * <pre>
   *   void remove_all_filters ();
   * </pre>
   */
  public void remove_all_filters () {
    this._delegate.remove_all_filters();
  }

  /**
   * <pre>
   *   com.ericsson.irp.CosNotifyFilter.FilterIDSeq get_all_filters ();
   * </pre>
   */
  public int[] get_all_filters () {
    return this._delegate.get_all_filters();
  }

  /**
   * <pre>
   *   com.ericsson.irp.CosNotifyFilter.Filter get_filter (in com.ericsson.irp.CosNotifyFilter.FilterID filter)
    raises (com.ericsson.irp.CosNotifyFilter.FilterNotFound);
   * </pre>
   */
  public com.ericsson.irp.CosNotifyFilter.Filter get_filter (int filter) throws  com.ericsson.irp.CosNotifyFilter.FilterNotFound {
    return this._delegate.get_filter(filter);
  }

  /**
   * <pre>
   *   void remove_filter (in com.ericsson.irp.CosNotifyFilter.FilterID filter)
    raises (com.ericsson.irp.CosNotifyFilter.FilterNotFound);
   * </pre>
   */
  public void remove_filter (int filter) throws  com.ericsson.irp.CosNotifyFilter.FilterNotFound {
    this._delegate.remove_filter(filter);
  }

  /**
   * <pre>
   *   com.ericsson.irp.CosNotifyFilter.FilterID add_filter (in com.ericsson.irp.CosNotifyFilter.Filter new_filter);
   * </pre>
   */
  public int add_filter (com.ericsson.irp.CosNotifyFilter.Filter new_filter) {
    return this._delegate.add_filter(new_filter);
  }

  /**
   * <pre>
   *   void validate_qos (in org.omg.CosNotification.QoSProperties required_qos,
                     out org.omg.CosNotification.NamedPropertyRangeSeq available_qos)
    raises (org.omg.CosNotification.UnsupportedQoS);
   * </pre>
   */
  public void validate_qos (org.omg.CosNotification.Property[] required_qos, 
                            org.omg.CosNotification.NamedPropertyRangeSeqHolder available_qos) throws  org.omg.CosNotification.UnsupportedQoS {
    this._delegate.validate_qos(required_qos, available_qos);
  }

  /**
   * <pre>
   *   void set_qos (in org.omg.CosNotification.QoSProperties qos)
    raises (org.omg.CosNotification.UnsupportedQoS);
   * </pre>
   */
  public void set_qos (org.omg.CosNotification.Property[] qos) throws  org.omg.CosNotification.UnsupportedQoS {
    this._delegate.set_qos(qos);
  }

  /**
   * <pre>
   *   org.omg.CosNotification.QoSProperties get_qos ();
   * </pre>
   */
  public org.omg.CosNotification.Property[] get_qos () {
    return this._delegate.get_qos();
  }

}
