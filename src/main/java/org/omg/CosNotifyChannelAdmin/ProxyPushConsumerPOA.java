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
public abstract class ProxyPushConsumerPOA extends org.omg.PortableServer.Servant implements 
org.omg.CORBA.portable.InvokeHandler, org.omg.CosNotifyChannelAdmin.ProxyPushConsumerOperations {

  public org.omg.CosNotifyChannelAdmin.ProxyPushConsumer _this () {
   return org.omg.CosNotifyChannelAdmin.ProxyPushConsumerHelper.narrow(super._this_object());
  }

  public org.omg.CosNotifyChannelAdmin.ProxyPushConsumer _this (org.omg.CORBA.ORB orb) {
    return org.omg.CosNotifyChannelAdmin.ProxyPushConsumerHelper.narrow(super._this_object(orb));
  }

  public java.lang.String[] _all_interfaces (final org.omg.PortableServer.POA poa, final byte[] objectId) {
    return __ids;
  }

  private static java.lang.String[] __ids = {
    "IDL:omg.org/CosNotifyChannelAdmin/ProxyPushConsumer:1.0",
    "IDL:omg.org/CosNotifyChannelAdmin/ProxyConsumer:1.0",
    "IDL:omg.org/CosNotification/QoSAdmin:1.0",
    "IDL:omg.org/CosNotifyFilter/FilterAdmin:1.0",
    "IDL:omg.org/CosNotifyComm/PushConsumer:1.0",
    "IDL:omg.org/CosNotifyComm/NotifyPublish:1.0",
    "IDL:omg.org/CosEventComm/PushConsumer:1.0"
  };

  private static java.util.Dictionary<String, int[]> _methods = new java.util.Hashtable<String, int[]>();

  static {
  _methods.put("connect_any_push_supplier", new int[] { 0, 0 });
  _methods.put("_get_MyType", new int[] { 1, 0 });
  _methods.put("_get_MyAdmin", new int[] { 1, 1 });
  _methods.put("obtain_subscription_types", new int[] { 1, 2 });
  _methods.put("validate_event_qos", new int[] { 1, 3 });
  _methods.put("get_qos", new int[] { 2, 0 });
  _methods.put("set_qos", new int[] { 2, 1 });
  _methods.put("validate_qos", new int[] { 2, 2 });
  _methods.put("add_filter", new int[] { 3, 0 });
  _methods.put("remove_filter", new int[] { 3, 1 });
  _methods.put("get_filter", new int[] { 3, 2 });
  _methods.put("get_all_filters", new int[] { 3, 3 });
  _methods.put("remove_all_filters", new int[] { 3, 4 });
  _methods.put("offer_change", new int[] { 5, 0 });
  _methods.put("push", new int[] { 6, 0 });
  _methods.put("disconnect_push_consumer", new int[] { 6, 1 });
  }

  public org.omg.CORBA.portable.OutputStream _invoke (java.lang.String opName,
                                                      org.omg.CORBA.portable.InputStream _input,
                                                      org.omg.CORBA.portable.ResponseHandler handler) {
    int[] method = (int[]) _methods.get(opName);
    if (method == null) {
      throw new org.omg.CORBA.BAD_OPERATION();
    }
    switch (method[0]) {
      case 0: {
        return org.omg.CosNotifyChannelAdmin.ProxyPushConsumerPOA._invoke(this, method[1], _input, handler);
      }
      case 1: {
        return org.omg.CosNotifyChannelAdmin.ProxyConsumerPOA._invoke(this, method[1], _input, handler);
      }
      case 2: {
        return org.omg.CosNotification.QoSAdminPOA._invoke(this, method[1], _input, handler);
      }
      case 3: {
        return com.ericsson.irp.CosNotifyFilter.FilterAdminPOA._invoke(this, method[1], _input, handler);
      }
      case 4: {
        return com.ericsson.irp.CosNotifyComm.PushConsumerPOA._invoke(this, method[1], _input, handler);
      }
      case 5: {
        return com.ericsson.irp.CosNotifyComm.NotifyPublishPOA._invoke(this, method[1], _input, handler);
      }
      case 6: {
        return com.ericsson.irp.CosEventComm.PushConsumerPOA._invoke(this, method[1], _input, handler);
      }
    }
    throw new org.omg.CORBA.BAD_OPERATION(2, org.omg.CORBA.CompletionStatus.COMPLETED_NO);
  }

  public static org.omg.CORBA.portable.OutputStream _invoke (org.omg.CosNotifyChannelAdmin.ProxyPushConsumerOperations _self,
                                                             int _method_id,
                                                             org.omg.CORBA.portable.InputStream _input,
                                                             org.omg.CORBA.portable.ResponseHandler _handler) {
  org.omg.CORBA.portable.OutputStream _output = null;
  {
    switch (_method_id) {
    case 0: {
    try {
      com.ericsson.irp.CosEventComm.PushSupplier push_supplier;
      push_supplier = com.ericsson.irp.CosEventComm.PushSupplierHelper.read(_input);
      _self.connect_any_push_supplier(push_supplier);
      _output = _handler.createReply();
    }
    catch (com.ericsson.irp.CosEventChannelAdmin.AlreadyConnected _exception) {
      _output = _handler.createExceptionReply();
      com.ericsson.irp.CosEventChannelAdmin.AlreadyConnectedHelper.write(_output, _exception);
    }
      return _output;
    }
    }
    throw new org.omg.CORBA.BAD_OPERATION(2, org.omg.CORBA.CompletionStatus.COMPLETED_NO);
  }
  }
}
