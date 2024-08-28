package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::NotConnected
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/NotConnected:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * exception NotConnected {
  ...
};
 * </pre>
 */
public final class NotConnectedHolder implements org.omg.CORBA.portable.Streamable {
public org.omg.CosNotifyChannelAdmin.NotConnected value;

public NotConnectedHolder () {
}

public NotConnectedHolder (final org.omg.CosNotifyChannelAdmin.NotConnected _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.CosNotifyChannelAdmin.NotConnectedHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.CosNotifyChannelAdmin.NotConnectedHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.CosNotifyChannelAdmin.NotConnectedHelper.type();
}
}
