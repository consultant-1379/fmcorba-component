package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::ClientType
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/ClientType:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * enum ClientType {ANY_EVENT, STRUCTURED_EVENT, SEQUENCE_EVENT};
 * </pre>
 */
public final class ClientTypeHolder implements org.omg.CORBA.portable.Streamable {
public org.omg.CosNotifyChannelAdmin.ClientType value;

public ClientTypeHolder () {
}

public ClientTypeHolder (final org.omg.CosNotifyChannelAdmin.ClientType _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.CosNotifyChannelAdmin.ClientTypeHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.CosNotifyChannelAdmin.ClientTypeHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.CosNotifyChannelAdmin.ClientTypeHelper.type();
}
}
