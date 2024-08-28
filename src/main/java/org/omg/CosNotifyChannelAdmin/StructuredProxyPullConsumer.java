package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::StructuredProxyPullConsumer
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/StructuredProxyPullConsumer:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface StructuredProxyPullConsumer : org.omg.CosNotifyChannelAdmin.ProxyConsumer,
                                        com.ericsson.irp.CosNotifyComm.StructuredPullConsumer {
  ...
};
 * </pre>
 */
public interface StructuredProxyPullConsumer extends org.omg.CosNotifyChannelAdmin.StructuredProxyPullConsumerOperations, org.omg.CosNotifyChannelAdmin.ProxyConsumer, 
                                                                                                                          com.ericsson.irp.CosNotifyComm.StructuredPullConsumer, org.omg.CORBA.portable.IDLEntity {
}
