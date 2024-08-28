package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::StructuredProxyPullSupplier
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/StructuredProxyPullSupplier:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface StructuredProxyPullSupplier : org.omg.CosNotifyChannelAdmin.ProxySupplier,
                                        com.ericsson.irp.CosNotifyComm.StructuredPullSupplier {
  ...
};
 * </pre>
 */
public final class StructuredProxyPullSupplierHolder implements org.omg.CORBA.portable.Streamable {
public org.omg.CosNotifyChannelAdmin.StructuredProxyPullSupplier value;

public StructuredProxyPullSupplierHolder () {
}

public StructuredProxyPullSupplierHolder (final org.omg.CosNotifyChannelAdmin.StructuredProxyPullSupplier _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.CosNotifyChannelAdmin.StructuredProxyPullSupplierHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.CosNotifyChannelAdmin.StructuredProxyPullSupplierHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.CosNotifyChannelAdmin.StructuredProxyPullSupplierHelper.type();
}
}
