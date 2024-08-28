
package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::SequenceProxyPullConsumer
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/SequenceProxyPullConsumer:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface SequenceProxyPullConsumer : org.omg.CosNotifyChannelAdmin.ProxyConsumer,
                                      com.ericsson.irp.CosNotifyComm.SequencePullConsumer {
  ...
};
 * </pre>
 */
public class SequenceProxyPullConsumerPOATie extends SequenceProxyPullConsumerPOA {
  private org.omg.CosNotifyChannelAdmin.SequenceProxyPullConsumerOperations _delegate;
  private org.omg.PortableServer.POA _poa;

  public SequenceProxyPullConsumerPOATie (final org.omg.CosNotifyChannelAdmin.SequenceProxyPullConsumerOperations _delegate) {
    this._delegate = _delegate;
  }

  public SequenceProxyPullConsumerPOATie (final org.omg.CosNotifyChannelAdmin.SequenceProxyPullConsumerOperations _delegate, 
                              final org.omg.PortableServer.POA _poa) {
    this._delegate = _delegate;
    this._poa = _poa;
  }

  public org.omg.CosNotifyChannelAdmin.SequenceProxyPullConsumerOperations _delegate () {
    return this._delegate;
  }

  public void _delegate (final org.omg.CosNotifyChannelAdmin.SequenceProxyPullConsumerOperations the_delegate) {
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
   *   void resume_connection ()
    raises (org.omg.CosNotifyChannelAdmin.ConnectionAlreadyActive,
            org.omg.CosNotifyChannelAdmin.NotConnected);
   * </pre>
   */
  public void resume_connection () throws  org.omg.CosNotifyChannelAdmin.ConnectionAlreadyActive, 
                                           org.omg.CosNotifyChannelAdmin.NotConnected {
    this._delegate.resume_connection();
  }

  /**
   * <pre>
   *   void suspend_connection ()
    raises (org.omg.CosNotifyChannelAdmin.ConnectionAlreadyInactive,
            org.omg.CosNotifyChannelAdmin.NotConnected);
   * </pre>
   */
  public void suspend_connection () throws  org.omg.CosNotifyChannelAdmin.ConnectionAlreadyInactive, 
                                            org.omg.CosNotifyChannelAdmin.NotConnected {
    this._delegate.suspend_connection();
  }

  /**
   * <pre>
   *   void connect_sequence_pull_supplier (in com.ericsson.irp.CosNotifyComm.SequencePullSupplier pull_supplier)
    raises (com.ericsson.irp.CosEventChannelAdmin.AlreadyConnected,
            com.ericsson.irp.CosEventChannelAdmin.TypeError);
   * </pre>
   */
  public void connect_sequence_pull_supplier (com.ericsson.irp.CosNotifyComm.SequencePullSupplier pull_supplier) throws  com.ericsson.irp.CosEventChannelAdmin.AlreadyConnected, 
                                                                                                                         com.ericsson.irp.CosEventChannelAdmin.TypeError {
    this._delegate.connect_sequence_pull_supplier(pull_supplier);
  }

  /**
   * <pre>
   *   void offer_change (in org.omg.CosNotification.EventTypeSeq added,
                     in org.omg.CosNotification.EventTypeSeq removed)
    raises (com.ericsson.irp.CosNotifyComm.InvalidEventType);
   * </pre>
   */
  public void offer_change (org.omg.CosNotification.EventType[] added, 
                            org.omg.CosNotification.EventType[] removed) throws  com.ericsson.irp.CosNotifyComm.InvalidEventType {
    this._delegate.offer_change(added, removed);
  }

  /**
   * <pre>
   *   void disconnect_sequence_pull_consumer ();
   * </pre>
   */
  public void disconnect_sequence_pull_consumer () {
    this._delegate.disconnect_sequence_pull_consumer();
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
   *   org.omg.CosNotification.EventTypeSeq obtain_subscription_types (in org.omg.CosNotifyChannelAdmin.ObtainInfoMode mode);
   * </pre>
   */
  public org.omg.CosNotification.EventType[] obtain_subscription_types (org.omg.CosNotifyChannelAdmin.ObtainInfoMode mode) {
    return this._delegate.obtain_subscription_types(mode);
  }

  /**
   * <pre>
   *   readonly attribute org.omg.CosNotifyChannelAdmin.SupplierAdmin MyAdmin;
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.SupplierAdmin MyAdmin () {
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
