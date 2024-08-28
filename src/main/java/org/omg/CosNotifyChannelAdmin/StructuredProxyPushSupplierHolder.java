package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::StructuredProxyPushSupplier
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/StructuredProxyPushSupplier:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface StructuredProxyPushSupplier : org.omg.CosNotifyChannelAdmin.ProxySupplier,
                                        com.ericsson.irp.CosNotifyComm.StructuredPushSupplier {
  ...
};
 * </pre>
 */
public final class StructuredProxyPushSupplierHolder implements org.omg.CORBA.portable.Streamable {
public org.omg.CosNotifyChannelAdmin.StructuredProxyPushSupplier value;

public StructuredProxyPushSupplierHolder () {
}

public StructuredProxyPushSupplierHolder (final org.omg.CosNotifyChannelAdmin.StructuredProxyPushSupplier _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.CosNotifyChannelAdmin.StructuredProxyPushSupplierHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.CosNotifyChannelAdmin.StructuredProxyPushSupplierHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.CosNotifyChannelAdmin.StructuredProxyPushSupplierHelper.type();
}
}
