package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::QoSAdmin
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/QoSAdmin:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface QoSAdmin {
  ...
};
 * </pre>
 */
public final class QoSAdminHolder implements org.omg.CORBA.portable.Streamable {
public org.omg.CosNotification.QoSAdmin value;

public QoSAdminHolder () {
}

public QoSAdminHolder (final org.omg.CosNotification.QoSAdmin _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.CosNotification.QoSAdminHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.CosNotification.QoSAdminHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.CosNotification.QoSAdminHelper.type();
}
}
