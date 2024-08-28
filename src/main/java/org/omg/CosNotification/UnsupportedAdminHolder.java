package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::UnsupportedAdmin
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/UnsupportedAdmin:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * exception UnsupportedAdmin {
  ...
};
 * </pre>
 */
public final class UnsupportedAdminHolder implements org.omg.CORBA.portable.Streamable {
public org.omg.CosNotification.UnsupportedAdmin value;

public UnsupportedAdminHolder () {
}

public UnsupportedAdminHolder (final org.omg.CosNotification.UnsupportedAdmin _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.CosNotification.UnsupportedAdminHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.CosNotification.UnsupportedAdminHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.CosNotification.UnsupportedAdminHelper.type();
}
}
