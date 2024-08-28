
package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::ConsumerAdmin
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/ConsumerAdmin:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface ConsumerAdmin : org.omg.CosNotification.QoSAdmin,
                          com.ericsson.irp.CosNotifyComm.NotifySubscribe,
                          com.ericsson.irp.CosNotifyFilter.FilterAdmin,
                          com.ericsson.irp.CosEventChannelAdmin.ConsumerAdmin {
  ...
};
 * </pre>
 */
public class ConsumerAdminPOATie extends ConsumerAdminPOA {
  private org.omg.CosNotifyChannelAdmin.ConsumerAdminOperations _delegate;
  private org.omg.PortableServer.POA _poa;

  public ConsumerAdminPOATie (final org.omg.CosNotifyChannelAdmin.ConsumerAdminOperations _delegate) {
    this._delegate = _delegate;
  }

  public ConsumerAdminPOATie (final org.omg.CosNotifyChannelAdmin.ConsumerAdminOperations _delegate, 
                              final org.omg.PortableServer.POA _poa) {
    this._delegate = _delegate;
    this._poa = _poa;
  }

  public org.omg.CosNotifyChannelAdmin.ConsumerAdminOperations _delegate () {
    return this._delegate;
  }

  public void _delegate (final org.omg.CosNotifyChannelAdmin.ConsumerAdminOperations the_delegate) {
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
   *   void destroy ();
   * </pre>
   */
  public void destroy () {
    this._delegate.destroy();
  }

  /**
   * <pre>
   *   org.omg.CosNotifyChannelAdmin.ProxySupplier obtain_notification_push_supplier (in org.omg.CosNotifyChannelAdmin.ClientType ctype,
                                                                                 out org.omg.CosNotifyChannelAdmin.ProxyID proxy_id)
    raises (org.omg.CosNotifyChannelAdmin.AdminLimitExceeded);
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.ProxySupplier obtain_notification_push_supplier (org.omg.CosNotifyChannelAdmin.ClientType ctype, 
                                                                                        org.omg.CORBA.IntHolder proxy_id) throws  org.omg.CosNotifyChannelAdmin.AdminLimitExceeded {
    return this._delegate.obtain_notification_push_supplier(ctype, proxy_id);
  }

  /**
   * <pre>
   *   org.omg.CosNotifyChannelAdmin.ProxySupplier obtain_notification_pull_supplier (in org.omg.CosNotifyChannelAdmin.ClientType ctype,
                                                                                 out org.omg.CosNotifyChannelAdmin.ProxyID proxy_id)
    raises (org.omg.CosNotifyChannelAdmin.AdminLimitExceeded);
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.ProxySupplier obtain_notification_pull_supplier (org.omg.CosNotifyChannelAdmin.ClientType ctype, 
                                                                                        org.omg.CORBA.IntHolder proxy_id) throws  org.omg.CosNotifyChannelAdmin.AdminLimitExceeded {
    return this._delegate.obtain_notification_pull_supplier(ctype, proxy_id);
  }

  /**
   * <pre>
   *   org.omg.CosNotifyChannelAdmin.ProxySupplier get_proxy_supplier (in org.omg.CosNotifyChannelAdmin.ProxyID proxy_id)
    raises (org.omg.CosNotifyChannelAdmin.ProxyNotFound);
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.ProxySupplier get_proxy_supplier (int proxy_id) throws  org.omg.CosNotifyChannelAdmin.ProxyNotFound {
    return this._delegate.get_proxy_supplier(proxy_id);
  }

  /**
   * <pre>
   *   readonly attribute org.omg.CosNotifyChannelAdmin.ProxyIDSeq push_suppliers;
   * </pre>
   */
  public int[] push_suppliers () {
    return this._delegate.push_suppliers();
  }

  /**
   * <pre>
   *   readonly attribute org.omg.CosNotifyChannelAdmin.ProxyIDSeq pull_suppliers;
   * </pre>
   */
  public int[] pull_suppliers () {
    return this._delegate.pull_suppliers();
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
   *   readonly attribute org.omg.CosNotifyChannelAdmin.InterFilterGroupOperator MyOperator;
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.InterFilterGroupOperator MyOperator () {
    return this._delegate.MyOperator();
  }

  /**
   * <pre>
   *   readonly attribute org.omg.CosNotifyChannelAdmin.EventChannel MyChannel;
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.EventChannel MyChannel () {
    return this._delegate.MyChannel();
  }

  /**
   * <pre>
   *   readonly attribute org.omg.CosNotifyChannelAdmin.AdminID MyID;
   * </pre>
   */
  public int MyID () {
    return this._delegate.MyID();
  }

  /**
   * <pre>
   *   com.ericsson.irp.CosEventChannelAdmin.ProxyPullSupplier obtain_pull_supplier ();
   * </pre>
   */
  public com.ericsson.irp.CosEventChannelAdmin.ProxyPullSupplier obtain_pull_supplier () {
    return this._delegate.obtain_pull_supplier();
  }

  /**
   * <pre>
   *   com.ericsson.irp.CosEventChannelAdmin.ProxyPushSupplier obtain_push_supplier ();
   * </pre>
   */
  public com.ericsson.irp.CosEventChannelAdmin.ProxyPushSupplier obtain_push_supplier () {
    return this._delegate.obtain_push_supplier();
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
   *   void subscription_change (in org.omg.CosNotification.EventTypeSeq added,
                            in org.omg.CosNotification.EventTypeSeq removed)
    raises (com.ericsson.irp.CosNotifyComm.InvalidEventType);
   * </pre>
   */
  public void subscription_change (org.omg.CosNotification.EventType[] added, 
                                   org.omg.CosNotification.EventType[] removed) throws  com.ericsson.irp.CosNotifyComm.InvalidEventType {
    this._delegate.subscription_change(added, removed);
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
