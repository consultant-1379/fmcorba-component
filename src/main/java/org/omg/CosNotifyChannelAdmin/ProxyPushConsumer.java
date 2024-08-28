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
public interface ProxyPushConsumer extends org.omg.CosNotifyChannelAdmin.ProxyPushConsumerOperations, org.omg.CosNotifyChannelAdmin.ProxyConsumer, 
                                                                                                      com.ericsson.irp.CosNotifyComm.PushConsumer, org.omg.CORBA.portable.IDLEntity {
}
