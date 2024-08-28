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
public interface SequenceProxyPullConsumer extends org.omg.CosNotifyChannelAdmin.SequenceProxyPullConsumerOperations, org.omg.CosNotifyChannelAdmin.ProxyConsumer, 
                                                                                                                      com.ericsson.irp.CosNotifyComm.SequencePullConsumer, org.omg.CORBA.portable.IDLEntity {
}
