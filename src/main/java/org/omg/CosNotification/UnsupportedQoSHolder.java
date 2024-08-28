package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::UnsupportedQoS
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/UnsupportedQoS:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * exception UnsupportedQoS {
  ...
};
 * </pre>
 */
public final class UnsupportedQoSHolder implements org.omg.CORBA.portable.Streamable {
public org.omg.CosNotification.UnsupportedQoS value;

public UnsupportedQoSHolder () {
}

public UnsupportedQoSHolder (final org.omg.CosNotification.UnsupportedQoS _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.CosNotification.UnsupportedQoSHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.CosNotification.UnsupportedQoSHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.CosNotification.UnsupportedQoSHelper.type();
}
}
