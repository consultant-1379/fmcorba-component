package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::ProxyPullConsumer
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/ProxyPullConsumer:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface ProxyPullConsumer : org.omg.CosNotifyChannelAdmin.ProxyConsumer,
                              com.ericsson.irp.CosNotifyComm.PullConsumer {
  ...
};
 * </pre>
 */
public interface ProxyPullConsumer extends org.omg.CosNotifyChannelAdmin.ProxyPullConsumerOperations, org.omg.CosNotifyChannelAdmin.ProxyConsumer, 
                                                                                                      com.ericsson.irp.CosNotifyComm.PullConsumer, org.omg.CORBA.portable.IDLEntity {
}
