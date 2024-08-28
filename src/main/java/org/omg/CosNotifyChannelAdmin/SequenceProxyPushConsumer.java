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
public interface SequenceProxyPushConsumer extends org.omg.CosNotifyChannelAdmin.SequenceProxyPushConsumerOperations, org.omg.CosNotifyChannelAdmin.ProxyConsumer, 
                                                                                                                      com.ericsson.irp.CosNotifyComm.SequencePushConsumer, org.omg.CORBA.portable.IDLEntity {
}
