package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::ProxyPushSupplier
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/ProxyPushSupplier:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface ProxyPushSupplier : org.omg.CosNotifyChannelAdmin.ProxySupplier,
                              com.ericsson.irp.CosNotifyComm.PushSupplier {
  ...
};
 * </pre>
 */
public final class ProxyPushSupplierHolder implements org.omg.CORBA.portable.Streamable {
public org.omg.CosNotifyChannelAdmin.ProxyPushSupplier value;

public ProxyPushSupplierHolder () {
}

public ProxyPushSupplierHolder (final org.omg.CosNotifyChannelAdmin.ProxyPushSupplier _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.CosNotifyChannelAdmin.ProxyPushSupplierHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.CosNotifyChannelAdmin.ProxyPushSupplierHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.CosNotifyChannelAdmin.ProxyPushSupplierHelper.type();
}
}
