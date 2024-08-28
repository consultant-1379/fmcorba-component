package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::ProxyPullSupplier
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/ProxyPullSupplier:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface ProxyPullSupplier : org.omg.CosNotifyChannelAdmin.ProxySupplier,
                              com.ericsson.irp.CosNotifyComm.PullSupplier {
  ...
};
 * </pre>
 */
public final class ProxyPullSupplierHolder implements org.omg.CORBA.portable.Streamable {
public org.omg.CosNotifyChannelAdmin.ProxyPullSupplier value;

public ProxyPullSupplierHolder () {
}

public ProxyPullSupplierHolder (final org.omg.CosNotifyChannelAdmin.ProxyPullSupplier _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.CosNotifyChannelAdmin.ProxyPullSupplierHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.CosNotifyChannelAdmin.ProxyPullSupplierHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.CosNotifyChannelAdmin.ProxyPullSupplierHelper.type();
}
}
