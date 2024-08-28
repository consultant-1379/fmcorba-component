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
public abstract class ProxyConsumerPOA extends org.omg.PortableServer.Servant implements 
org.omg.CORBA.portable.InvokeHandler, org.omg.CosNotifyChannelAdmin.ProxyConsumerOperations {

  public org.omg.CosNotifyChannelAdmin.ProxyConsumer _this () {
   return org.omg.CosNotifyChannelAdmin.ProxyConsumerHelper.narrow(super._this_object());
  }

  public org.omg.CosNotifyChannelAdmin.ProxyConsumer _this (org.omg.CORBA.ORB orb) {
    return org.omg.CosNotifyChannelAdmin.ProxyConsumerHelper.narrow(super._this_object(orb));
  }

  public java.lang.String[] _all_interfaces (final org.omg.PortableServer.POA poa, final byte[] objectId) {
    return __ids;
  }

  private static java.lang.String[] __ids = {
    "IDL:omg.org/CosNotifyChannelAdmin/ProxyConsumer:1.0",
    "IDL:omg.org/CosNotification/QoSAdmin:1.0",
    "IDL:omg.org/CosNotifyFilter/FilterAdmin:1.0"
  };

  private static java.util.Dictionary<String, int[]> _methods = new java.util.Hashtable<String, int[]>();

  static {
  _methods.put("_get_MyType", new int[] { 0, 0 });
  _methods.put("_get_MyAdmin", new int[] { 0, 1 });
  _methods.put("obtain_subscription_types", new int[] { 0, 2 });
  _methods.put("validate_event_qos", new int[] { 0, 3 });
  _methods.put("get_qos", new int[] { 1, 0 });
  _methods.put("set_qos", new int[] { 1, 1 });
  _methods.put("validate_qos", new int[] { 1, 2 });
  _methods.put("add_filter", new int[] { 2, 0 });
  _methods.put("remove_filter", new int[] { 2, 1 });
  _methods.put("get_filter", new int[] { 2, 2 });
  _methods.put("get_all_filters", new int[] { 2, 3 });
  _methods.put("remove_all_filters", new int[] { 2, 4 });
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
        return org.omg.CosNotifyChannelAdmin.ProxyConsumerPOA._invoke(this, method[1], _input, handler);
      }
      case 1: {
        return org.omg.CosNotification.QoSAdminPOA._invoke(this, method[1], _input, handler);
      }
      case 2: {
        return com.ericsson.irp.CosNotifyFilter.FilterAdminPOA._invoke(this, method[1], _input, handler);
      }
    }
    throw new org.omg.CORBA.BAD_OPERATION(2, org.omg.CORBA.CompletionStatus.COMPLETED_NO);
  }

  public static org.omg.CORBA.portable.OutputStream _invoke (org.omg.CosNotifyChannelAdmin.ProxyConsumerOperations _self,
                                                             int _method_id,
                                                             org.omg.CORBA.portable.InputStream _input,
                                                             org.omg.CORBA.portable.ResponseHandler _handler) {
  org.omg.CORBA.portable.OutputStream _output = null;
  {
    switch (_method_id) {
    case 0: {
      org.omg.CosNotifyChannelAdmin.ProxyType _result = _self.MyType();
      _output = _handler.createReply();
      org.omg.CosNotifyChannelAdmin.ProxyTypeHelper.write(_output, _result);
      return _output;
    }
    case 1: {
      org.omg.CosNotifyChannelAdmin.SupplierAdmin _result = _self.MyAdmin();
      _output = _handler.createReply();
      org.omg.CosNotifyChannelAdmin.SupplierAdminHelper.write(_output, _result);
      return _output;
    }
    case 2: {
      org.omg.CosNotifyChannelAdmin.ObtainInfoMode mode;
      mode = org.omg.CosNotifyChannelAdmin.ObtainInfoModeHelper.read(_input);
      org.omg.CosNotification.EventType[] _result = _self.obtain_subscription_types(mode);
      _output = _handler.createReply();
      org.omg.CosNotification.EventTypeSeqHelper.write(_output, _result);
      return _output;
    }
    case 3: {
    try {
      org.omg.CosNotification.Property[] required_qos;
      required_qos = org.omg.CosNotification.PropertySeqHelper.read(_input);
      org.omg.CosNotification.NamedPropertyRangeSeqHolder available_qos = new org.omg.CosNotification.NamedPropertyRangeSeqHolder();
      _self.validate_event_qos(required_qos, available_qos);
      _output = _handler.createReply();
      org.omg.CosNotification.NamedPropertyRangeSeqHelper.write(_output, available_qos.value);
    }
    catch (org.omg.CosNotification.UnsupportedQoS _exception) {
      _output = _handler.createExceptionReply();
      org.omg.CosNotification.UnsupportedQoSHelper.write(_output, _exception);
    }
      return _output;
    }
    }
    throw new org.omg.CORBA.BAD_OPERATION(2, org.omg.CORBA.CompletionStatus.COMPLETED_NO);
  }
  }
}
