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
public interface EventChannelOperations extends org.omg.CosNotification.QoSAdminOperations, 
                                                org.omg.CosNotification.AdminPropertiesAdminOperations, 
                                                com.ericsson.irp.CosEventChannelAdmin.EventChannelOperations {
  /**
   * <pre>
   *   org.omg.CosNotifyChannelAdmin.AdminIDSeq get_all_supplieradmins ();
   * </pre>
   */
  public int[] get_all_supplieradmins ();

  /**
   * <pre>
   *   org.omg.CosNotifyChannelAdmin.AdminIDSeq get_all_consumeradmins ();
   * </pre>
   */
  public int[] get_all_consumeradmins ();

  /**
   * <pre>
   *   org.omg.CosNotifyChannelAdmin.SupplierAdmin get_supplieradmin (in org.omg.CosNotifyChannelAdmin.AdminID id)
    raises (org.omg.CosNotifyChannelAdmin.AdminNotFound);
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.SupplierAdmin get_supplieradmin (int id) throws org.omg.CosNotifyChannelAdmin.AdminNotFound;

  /**
   * <pre>
   *   org.omg.CosNotifyChannelAdmin.ConsumerAdmin get_consumeradmin (in org.omg.CosNotifyChannelAdmin.AdminID id)
    raises (org.omg.CosNotifyChannelAdmin.AdminNotFound);
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.ConsumerAdmin get_consumeradmin (int id) throws org.omg.CosNotifyChannelAdmin.AdminNotFound;

  /**
   * <pre>
   *   org.omg.CosNotifyChannelAdmin.SupplierAdmin new_for_suppliers (in org.omg.CosNotifyChannelAdmin.InterFilterGroupOperator op,
                                                                 out org.omg.CosNotifyChannelAdmin.AdminID id);
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.SupplierAdmin new_for_suppliers (org.omg.CosNotifyChannelAdmin.InterFilterGroupOperator op, 
                                                                        org.omg.CORBA.IntHolder id);

  /**
   * <pre>
   *   org.omg.CosNotifyChannelAdmin.ConsumerAdmin new_for_consumers (in org.omg.CosNotifyChannelAdmin.InterFilterGroupOperator op,
                                                                 out org.omg.CosNotifyChannelAdmin.AdminID id);
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.ConsumerAdmin new_for_consumers (org.omg.CosNotifyChannelAdmin.InterFilterGroupOperator op, 
                                                                        org.omg.CORBA.IntHolder id);

  /**
   * <pre>
   *   readonly attribute com.ericsson.irp.CosNotifyFilter.FilterFactory default_filter_factory;
   * </pre>
   */
  public com.ericsson.irp.CosNotifyFilter.FilterFactory default_filter_factory ();

  /**
   * <pre>
   *   readonly attribute org.omg.CosNotifyChannelAdmin.SupplierAdmin default_supplier_admin;
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.SupplierAdmin default_supplier_admin ();

  /**
   * <pre>
   *   readonly attribute org.omg.CosNotifyChannelAdmin.ConsumerAdmin default_consumer_admin;
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.ConsumerAdmin default_consumer_admin ();

  /**
   * <pre>
   *   readonly attribute org.omg.CosNotifyChannelAdmin.EventChannelFactory MyFactory;
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.EventChannelFactory MyFactory ();

}
