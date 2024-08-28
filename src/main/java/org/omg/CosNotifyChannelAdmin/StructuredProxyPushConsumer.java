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
public interface StructuredProxyPushConsumer extends org.omg.CosNotifyChannelAdmin.StructuredProxyPushConsumerOperations, org.omg.CosNotifyChannelAdmin.ProxyConsumer, 
                                                                                                                          com.ericsson.irp.CosNotifyComm.StructuredPushConsumer, org.omg.CORBA.portable.IDLEntity {
}
