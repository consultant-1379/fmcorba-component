package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::SequenceProxyPullConsumer
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/SequenceProxyPullConsumer:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface SequenceProxyPullConsumer : org.omg.CosNotifyChannelAdmin.ProxyConsumer,
                                      com.ericsson.irp.CosNotifyComm.SequencePullConsumer {
  ...
};
 * </pre>
 */
public final class SequenceProxyPullConsumerHolder implements org.omg.CORBA.portable.Streamable {
public org.omg.CosNotifyChannelAdmin.SequenceProxyPullConsumer value;

public SequenceProxyPullConsumerHolder () {
}

public SequenceProxyPullConsumerHolder (final org.omg.CosNotifyChannelAdmin.SequenceProxyPullConsumer _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.CosNotifyChannelAdmin.SequenceProxyPullConsumerHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.CosNotifyChannelAdmin.SequenceProxyPullConsumerHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.CosNotifyChannelAdmin.SequenceProxyPullConsumerHelper.type();
}
}
