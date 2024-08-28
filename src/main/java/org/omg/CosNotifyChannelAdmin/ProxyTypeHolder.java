package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::ProxyType
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/ProxyType:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * enum ProxyType {PUSH_ANY, PULL_ANY, PUSH_STRUCTURED, PULL_STRUCTURED,
                PUSH_SEQUENCE, PULL_SEQUENCE, PUSH_TYPED, PULL_TYPED};
 * </pre>
 */
public final class ProxyTypeHolder implements org.omg.CORBA.portable.Streamable {
public org.omg.CosNotifyChannelAdmin.ProxyType value;

public ProxyTypeHolder () {
}

public ProxyTypeHolder (final org.omg.CosNotifyChannelAdmin.ProxyType _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.CosNotifyChannelAdmin.ProxyTypeHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.CosNotifyChannelAdmin.ProxyTypeHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.CosNotifyChannelAdmin.ProxyTypeHelper.type();
}
}
