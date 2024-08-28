package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::ProxyConsumer
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/ProxyConsumer:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface ProxyConsumer : org.omg.CosNotification.QoSAdmin,
                          com.ericsson.irp.CosNotifyFilter.FilterAdmin {
  ...
};
 * </pre>
 */
public interface ProxyConsumer extends org.omg.CosNotifyChannelAdmin.ProxyConsumerOperations, org.omg.CosNotification.QoSAdmin, 
                                                                                              com.ericsson.irp.CosNotifyFilter.FilterAdmin, org.omg.CORBA.portable.IDLEntity {
}
