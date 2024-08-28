package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::StructuredProxyPushConsumer
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/StructuredProxyPushConsumer:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface StructuredProxyPushConsumer : org.omg.CosNotifyChannelAdmin.ProxyConsumer,
                                        com.ericsson.irp.CosNotifyComm.StructuredPushConsumer {
  ...
};
 * </pre>
 */
public final class StructuredProxyPushConsumerHolder implements org.omg.CORBA.portable.Streamable {
public org.omg.CosNotifyChannelAdmin.StructuredProxyPushConsumer value;

public StructuredProxyPushConsumerHolder () {
}

public StructuredProxyPushConsumerHolder (final org.omg.CosNotifyChannelAdmin.StructuredProxyPushConsumer _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.CosNotifyChannelAdmin.StructuredProxyPushConsumerHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.CosNotifyChannelAdmin.StructuredProxyPushConsumerHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.CosNotifyChannelAdmin.StructuredProxyPushConsumerHelper.type();
}
}
