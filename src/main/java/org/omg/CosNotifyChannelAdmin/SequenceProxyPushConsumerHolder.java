package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::SequenceProxyPushConsumer
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/SequenceProxyPushConsumer:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface SequenceProxyPushConsumer : org.omg.CosNotifyChannelAdmin.ProxyConsumer,
                                      com.ericsson.irp.CosNotifyComm.SequencePushConsumer {
  ...
};
 * </pre>
 */
public final class SequenceProxyPushConsumerHolder implements org.omg.CORBA.portable.Streamable {
public org.omg.CosNotifyChannelAdmin.SequenceProxyPushConsumer value;

public SequenceProxyPushConsumerHolder () {
}

public SequenceProxyPushConsumerHolder (final org.omg.CosNotifyChannelAdmin.SequenceProxyPushConsumer _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.CosNotifyChannelAdmin.SequenceProxyPushConsumerHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.CosNotifyChannelAdmin.SequenceProxyPushConsumerHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.CosNotifyChannelAdmin.SequenceProxyPushConsumerHelper.type();
}
}
