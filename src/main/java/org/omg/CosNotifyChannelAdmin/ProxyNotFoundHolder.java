package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::ProxyNotFound
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/ProxyNotFound:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * exception ProxyNotFound {
  ...
};
 * </pre>
 */
public final class ProxyNotFoundHolder implements org.omg.CORBA.portable.Streamable {
public org.omg.CosNotifyChannelAdmin.ProxyNotFound value;

public ProxyNotFoundHolder () {
}

public ProxyNotFoundHolder (final org.omg.CosNotifyChannelAdmin.ProxyNotFound _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.CosNotifyChannelAdmin.ProxyNotFoundHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.CosNotifyChannelAdmin.ProxyNotFoundHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.CosNotifyChannelAdmin.ProxyNotFoundHelper.type();
}
}
