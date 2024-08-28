package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::ProxyPushConsumer
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/ProxyPushConsumer:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface ProxyPushConsumer : org.omg.CosNotifyChannelAdmin.ProxyConsumer,
                              com.ericsson.irp.CosNotifyComm.PushConsumer {
  ...
};
 * </pre>
 */
public final class ProxyPushConsumerHolder implements org.omg.CORBA.portable.Streamable {
public org.omg.CosNotifyChannelAdmin.ProxyPushConsumer value;

public ProxyPushConsumerHolder () {
}

public ProxyPushConsumerHolder (final org.omg.CosNotifyChannelAdmin.ProxyPushConsumer _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.CosNotifyChannelAdmin.ProxyPushConsumerHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.CosNotifyChannelAdmin.ProxyPushConsumerHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.CosNotifyChannelAdmin.ProxyPushConsumerHelper.type();
}
}
