
package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::EventChannel
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/EventChannel:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface EventChannel : org.omg.CosNotification.QoSAdmin,
                         org.omg.CosNotification.AdminPropertiesAdmin,
                         com.ericsson.irp.CosEventChannelAdmin.EventChannel {
  ...
};
 * </pre>
 */
public class EventChannelPOATie extends EventChannelPOA {
  private org.omg.CosNotifyChannelAdmin.EventChannelOperations _delegate;
  private org.omg.PortableServer.POA _poa;

  public EventChannelPOATie (final org.omg.CosNotifyChannelAdmin.EventChannelOperations _delegate) {
    this._delegate = _delegate;
  }

  public EventChannelPOATie (final org.omg.CosNotifyChannelAdmin.EventChannelOperations _delegate, 
                              final org.omg.PortableServer.POA _poa) {
    this._delegate = _delegate;
    this._poa = _poa;
  }

  public org.omg.CosNotifyChannelAdmin.EventChannelOperations _delegate () {
    return this._delegate;
  }

  public void _delegate (final org.omg.CosNotifyChannelAdmin.EventChannelOperations the_delegate) {
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
   *   org.omg.CosNotifyChannelAdmin.AdminIDSeq get_all_supplieradmins ();
   * </pre>
   */
  public int[] get_all_supplieradmins () {
    return this._delegate.get_all_supplieradmins();
  }

  /**
   * <pre>
   *   org.omg.CosNotifyChannelAdmin.AdminIDSeq get_all_consumeradmins ();
   * </pre>
   */
  public int[] get_all_consumeradmins () {
    return this._delegate.get_all_consumeradmins();
  }

  /**
   * <pre>
   *   org.omg.CosNotifyChannelAdmin.SupplierAdmin get_supplieradmin (in org.omg.CosNotifyChannelAdmin.AdminID id)
    raises (org.omg.CosNotifyChannelAdmin.AdminNotFound);
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.SupplierAdmin get_supplieradmin (int id) throws  org.omg.CosNotifyChannelAdmin.AdminNotFound {
    return this._delegate.get_supplieradmin(id);
  }

  /**
   * <pre>
   *   org.omg.CosNotifyChannelAdmin.ConsumerAdmin get_consumeradmin (in org.omg.CosNotifyChannelAdmin.AdminID id)
    raises (org.omg.CosNotifyChannelAdmin.AdminNotFound);
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.ConsumerAdmin get_consumeradmin (int id) throws  org.omg.CosNotifyChannelAdmin.AdminNotFound {
    return this._delegate.get_consumeradmin(id);
  }

  /**
   * <pre>
   *   org.omg.CosNotifyChannelAdmin.SupplierAdmin new_for_suppliers (in org.omg.CosNotifyChannelAdmin.InterFilterGroupOperator op,
                                                                 out org.omg.CosNotifyChannelAdmin.AdminID id);
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.SupplierAdmin new_for_suppliers (org.omg.CosNotifyChannelAdmin.InterFilterGroupOperator op, 
                                                                        org.omg.CORBA.IntHolder id) {
    return this._delegate.new_for_suppliers(op, id);
  }

  /**
   * <pre>
   *   org.omg.CosNotifyChannelAdmin.ConsumerAdmin new_for_consumers (in org.omg.CosNotifyChannelAdmin.InterFilterGroupOperator op,
                                                                 out org.omg.CosNotifyChannelAdmin.AdminID id);
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.ConsumerAdmin new_for_consumers (org.omg.CosNotifyChannelAdmin.InterFilterGroupOperator op, 
                                                                        org.omg.CORBA.IntHolder id) {
    return this._delegate.new_for_consumers(op, id);
  }

  /**
   * <pre>
   *   readonly attribute com.ericsson.irp.CosNotifyFilter.FilterFactory default_filter_factory;
   * </pre>
   */
  public com.ericsson.irp.CosNotifyFilter.FilterFactory default_filter_factory () {
    return this._delegate.default_filter_factory();
  }

  /**
   * <pre>
   *   readonly attribute org.omg.CosNotifyChannelAdmin.SupplierAdmin default_supplier_admin;
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.SupplierAdmin default_supplier_admin () {
    return this._delegate.default_supplier_admin();
  }

  /**
   * <pre>
   *   readonly attribute org.omg.CosNotifyChannelAdmin.ConsumerAdmin default_consumer_admin;
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.ConsumerAdmin default_consumer_admin () {
    return this._delegate.default_consumer_admin();
  }

  /**
   * <pre>
   *   readonly attribute org.omg.CosNotifyChannelAdmin.EventChannelFactory MyFactory;
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.EventChannelFactory MyFactory () {
    return this._delegate.MyFactory();
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
   *   com.ericsson.irp.CosEventChannelAdmin.SupplierAdmin for_suppliers ();
   * </pre>
   */
  public com.ericsson.irp.CosEventChannelAdmin.SupplierAdmin for_suppliers () {
    return this._delegate.for_suppliers();
  }

  /**
   * <pre>
   *   com.ericsson.irp.CosEventChannelAdmin.ConsumerAdmin for_consumers ();
   * </pre>
   */
  public com.ericsson.irp.CosEventChannelAdmin.ConsumerAdmin for_consumers () {
    return this._delegate.for_consumers();
  }

  /**
   * <pre>
   *   void set_admin (in org.omg.CosNotification.AdminProperties admin)
    raises (org.omg.CosNotification.UnsupportedAdmin);
   * </pre>
   */
  public void set_admin (org.omg.CosNotification.Property[] admin) throws  org.omg.CosNotification.UnsupportedAdmin {
    this._delegate.set_admin(admin);
  }

  /**
   * <pre>
   *   org.omg.CosNotification.AdminProperties get_admin ();
   * </pre>
   */
  public org.omg.CosNotification.Property[] get_admin () {
    return this._delegate.get_admin();
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
