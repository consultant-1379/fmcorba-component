
package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::SequenceProxyPullSupplier
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/SequenceProxyPullSupplier:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface SequenceProxyPullSupplier : org.omg.CosNotifyChannelAdmin.ProxySupplier,
                                      com.ericsson.irp.CosNotifyComm.SequencePullSupplier {
  ...
};
 * </pre>
 */
public class SequenceProxyPullSupplierPOATie extends SequenceProxyPullSupplierPOA {
  private org.omg.CosNotifyChannelAdmin.SequenceProxyPullSupplierOperations _delegate;
  private org.omg.PortableServer.POA _poa;

  public SequenceProxyPullSupplierPOATie (final org.omg.CosNotifyChannelAdmin.SequenceProxyPullSupplierOperations _delegate) {
    this._delegate = _delegate;
  }

  public SequenceProxyPullSupplierPOATie (final org.omg.CosNotifyChannelAdmin.SequenceProxyPullSupplierOperations _delegate, 
                              final org.omg.PortableServer.POA _poa) {
    this._delegate = _delegate;
    this._poa = _poa;
  }

  public org.omg.CosNotifyChannelAdmin.SequenceProxyPullSupplierOperations _delegate () {
    return this._delegate;
  }

  public void _delegate (final org.omg.CosNotifyChannelAdmin.SequenceProxyPullSupplierOperations the_delegate) {
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
   *   void connect_sequence_pull_consumer (in com.ericsson.irp.CosNotifyComm.SequencePullConsumer pull_consumer)
    raises (com.ericsson.irp.CosEventChannelAdmin.AlreadyConnected);
   * </pre>
   */
  public void connect_sequence_pull_consumer (com.ericsson.irp.CosNotifyComm.SequencePullConsumer pull_consumer) throws  com.ericsson.irp.CosEventChannelAdmin.AlreadyConnected {
    this._delegate.connect_sequence_pull_consumer(pull_consumer);
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
   *   void disconnect_sequence_pull_supplier ();
   * </pre>
   */
  public void disconnect_sequence_pull_supplier () {
    this._delegate.disconnect_sequence_pull_supplier();
  }

  /**
   * <pre>
   *   org.omg.CosNotification.EventBatch try_pull_structured_events (in long max_number,
                                                                 out boolean has_event)
    raises (com.ericsson.irp.CosEventComm.Disconnected);
   * </pre>
   */
  public org.omg.CosNotification.StructuredEvent[] try_pull_structured_events (int max_number, 
                                                                               org.omg.CORBA.BooleanHolder has_event) throws  com.ericsson.irp.CosEventComm.Disconnected {
    return this._delegate.try_pull_structured_events(max_number, has_event);
  }

  /**
   * <pre>
   *   org.omg.CosNotification.EventBatch pull_structured_events (in long max_number)
    raises (com.ericsson.irp.CosEventComm.Disconnected);
   * </pre>
   */
  public org.omg.CosNotification.StructuredEvent[] pull_structured_events (int max_number) throws  com.ericsson.irp.CosEventComm.Disconnected {
    return this._delegate.pull_structured_events(max_number);
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

}
