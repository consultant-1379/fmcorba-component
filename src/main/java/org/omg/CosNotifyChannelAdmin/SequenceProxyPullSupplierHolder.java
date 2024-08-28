package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::SequenceProxyPullSupplier
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/SequenceProxyPullSupplier:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface SequenceProxyPullSupplier : org.omg.CosNotifyChannelAdmin.ProxySupplier,
                                      com.ericsson.irp.CosNotifyComm.SequencePullSupplier {
  ...
};
 * </pre>
 */
public final class SequenceProxyPullSupplierHolder implements org.omg.CORBA.portable.Streamable {
public org.omg.CosNotifyChannelAdmin.SequenceProxyPullSupplier value;

public SequenceProxyPullSupplierHolder () {
}

public SequenceProxyPullSupplierHolder (final org.omg.CosNotifyChannelAdmin.SequenceProxyPullSupplier _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.CosNotifyChannelAdmin.SequenceProxyPullSupplierHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.CosNotifyChannelAdmin.SequenceProxyPullSupplierHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.CosNotifyChannelAdmin.SequenceProxyPullSupplierHelper.type();
}
}
