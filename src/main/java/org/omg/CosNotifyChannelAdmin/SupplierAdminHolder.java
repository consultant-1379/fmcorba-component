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
public final class SupplierAdminHolder implements org.omg.CORBA.portable.Streamable {
public org.omg.CosNotifyChannelAdmin.SupplierAdmin value;

public SupplierAdminHolder () {
}

public SupplierAdminHolder (final org.omg.CosNotifyChannelAdmin.SupplierAdmin _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.CosNotifyChannelAdmin.SupplierAdminHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.CosNotifyChannelAdmin.SupplierAdminHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.CosNotifyChannelAdmin.SupplierAdminHelper.type();
}
}
