package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::ChannelNotFound
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/ChannelNotFound:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * exception ChannelNotFound {
  ...
};
 * </pre>
 */
public final class ChannelNotFoundHolder implements org.omg.CORBA.portable.Streamable {
public org.omg.CosNotifyChannelAdmin.ChannelNotFound value;

public ChannelNotFoundHolder () {
}

public ChannelNotFoundHolder (final org.omg.CosNotifyChannelAdmin.ChannelNotFound _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.CosNotifyChannelAdmin.ChannelNotFoundHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.CosNotifyChannelAdmin.ChannelNotFoundHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.CosNotifyChannelAdmin.ChannelNotFoundHelper.type();
}
}
