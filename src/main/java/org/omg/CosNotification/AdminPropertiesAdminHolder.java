package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::AdminPropertiesAdmin
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/AdminPropertiesAdmin:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface AdminPropertiesAdmin {
  ...
};
 * </pre>
 */
public final class AdminPropertiesAdminHolder implements org.omg.CORBA.portable.Streamable {
public org.omg.CosNotification.AdminPropertiesAdmin value;

public AdminPropertiesAdminHolder () {
}

public AdminPropertiesAdminHolder (final org.omg.CosNotification.AdminPropertiesAdmin _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.CosNotification.AdminPropertiesAdminHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.CosNotification.AdminPropertiesAdminHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.CosNotification.AdminPropertiesAdminHelper.type();
}
}
