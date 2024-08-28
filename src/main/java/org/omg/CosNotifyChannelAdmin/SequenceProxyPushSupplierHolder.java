package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::SequenceProxyPushSupplier
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/SequenceProxyPushSupplier:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface SequenceProxyPushSupplier : org.omg.CosNotifyChannelAdmin.ProxySupplier,
                                      com.ericsson.irp.CosNotifyComm.SequencePushSupplier {
  ...
};
 * </pre>
 */
public final class SequenceProxyPushSupplierHolder implements org.omg.CORBA.portable.Streamable {
public org.omg.CosNotifyChannelAdmin.SequenceProxyPushSupplier value;

public SequenceProxyPushSupplierHolder () {
}

public SequenceProxyPushSupplierHolder (final org.omg.CosNotifyChannelAdmin.SequenceProxyPushSupplier _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.CosNotifyChannelAdmin.SequenceProxyPushSupplierHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.CosNotifyChannelAdmin.SequenceProxyPushSupplierHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.CosNotifyChannelAdmin.SequenceProxyPushSupplierHelper.type();
}
}
