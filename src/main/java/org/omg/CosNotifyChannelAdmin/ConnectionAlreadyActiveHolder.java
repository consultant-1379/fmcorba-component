package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::ConnectionAlreadyActive
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/ConnectionAlreadyActive:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * exception ConnectionAlreadyActive {
  ...
};
 * </pre>
 */
public final class ConnectionAlreadyActiveHolder implements org.omg.CORBA.portable.Streamable {
public org.omg.CosNotifyChannelAdmin.ConnectionAlreadyActive value;

public ConnectionAlreadyActiveHolder () {
}

public ConnectionAlreadyActiveHolder (final org.omg.CosNotifyChannelAdmin.ConnectionAlreadyActive _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.CosNotifyChannelAdmin.ConnectionAlreadyActiveHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.CosNotifyChannelAdmin.ConnectionAlreadyActiveHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.CosNotifyChannelAdmin.ConnectionAlreadyActiveHelper.type();
}
}
