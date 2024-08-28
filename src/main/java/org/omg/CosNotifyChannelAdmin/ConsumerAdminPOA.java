package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::ConsumerAdmin
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/ConsumerAdmin:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface ConsumerAdmin : org.omg.CosNotification.QoSAdmin,
                          com.ericsson.irp.CosNotifyComm.NotifySubscribe,
                          com.ericsson.irp.CosNotifyFilter.FilterAdmin,
                          com.ericsson.irp.CosEventChannelAdmin.ConsumerAdmin {
  ...
};
 * </pre>
 */
public abstract class ConsumerAdminPOA extends org.omg.PortableServer.Servant implements 
org.omg.CORBA.portable.InvokeHandler, org.omg.CosNotifyChannelAdmin.ConsumerAdminOperations {

  public org.omg.CosNotifyChannelAdmin.ConsumerAdmin _this () {
   return org.omg.CosNotifyChannelAdmin.ConsumerAdminHelper.narrow(super._this_object());
  }

  public org.omg.CosNotifyChannelAdmin.ConsumerAdmin _this (org.omg.CORBA.ORB orb) {
    return org.omg.CosNotifyChannelAdmin.ConsumerAdminHelper.narrow(super._this_object(orb));
  }

  public java.lang.String[] _all_interfaces (final org.omg.PortableServer.POA poa, final byte[] objectId) {
    return __ids;
  }

  private static java.lang.String[] __ids = {
    "IDL:omg.org/CosNotifyChannelAdmin/ConsumerAdmin:1.0",
    "IDL:omg.org/CosNotification/QoSAdmin:1.0",
    "IDL:omg.org/CosNotifyComm/NotifySubscribe:1.0",
    "IDL:omg.org/CosNotifyFilter/FilterAdmin:1.0",
    "IDL:omg.org/CosEventChannelAdmin/ConsumerAdmin:1.0"
  };

  private static java.util.Dictionary<String, int[]> _methods = new java.util.Hashtable<String, int[]>();

  static {
  _methods.put("_get_MyID", new int[] { 0, 0 });
  _methods.put("_get_MyChannel", new int[] { 0, 1 });
  _methods.put("_get_MyOperator", new int[] { 0, 2 });
  _methods.put("_get_priority_filter", new int[] { 0, 3 });
  _methods.put("_set_priority_filter", new int[] { 0, 4 });
  _methods.put("_get_lifetime_filter", new int[] { 0, 5 });
  _methods.put("_set_lifetime_filter", new int[] { 0, 6 });
  _methods.put("_get_pull_suppliers", new int[] { 0, 7 });
  _methods.put("_get_push_suppliers", new int[] { 0, 8 });
  _methods.put("get_proxy_supplier", new int[] { 0, 9 });
  _methods.put("obtain_notification_pull_supplier", new int[] { 0, 10 });
  _methods.put("obtain_notification_push_supplier", new int[] { 0, 11 });
  _methods.put("destroy", new int[] { 0, 12 });
  _methods.put("get_qos", new int[] { 1, 0 });
  _methods.put("set_qos", new int[] { 1, 1 });
  _methods.put("validate_qos", new int[] { 1, 2 });
  _methods.put("subscription_change", new int[] { 2, 0 });
  _methods.put("add_filter", new int[] { 3, 0 });
  _methods.put("remove_filter", new int[] { 3, 1 });
  _methods.put("get_filter", new int[] { 3, 2 });
  _methods.put("get_all_filters", new int[] { 3, 3 });
  _methods.put("remove_all_filters", new int[] { 3, 4 });
  _methods.put("obtain_push_supplier", new int[] { 4, 0 });
  _methods.put("obtain_pull_supplier", new int[] { 4, 1 });
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
        return org.omg.CosNotifyChannelAdmin.ConsumerAdminPOA._invoke(this, method[1], _input, handler);
      }
      case 1: {
        return org.omg.CosNotification.QoSAdminPOA._invoke(this, method[1], _input, handler);
      }
      case 2: {
        return com.ericsson.irp.CosNotifyComm.NotifySubscribePOA._invoke(this, method[1], _input, handler);
      }
      case 3: {
        return com.ericsson.irp.CosNotifyFilter.FilterAdminPOA._invoke(this, method[1], _input, handler);
      }
      case 4: {
        return com.ericsson.irp.CosEventChannelAdmin.ConsumerAdminPOA._invoke(this, method[1], _input, handler);
      }
    }
    throw new org.omg.CORBA.BAD_OPERATION(2, org.omg.CORBA.CompletionStatus.COMPLETED_NO);
  }

  public static org.omg.CORBA.portable.OutputStream _invoke (org.omg.CosNotifyChannelAdmin.ConsumerAdminOperations _self,
                                                             int _method_id,
                                                             org.omg.CORBA.portable.InputStream _input,
                                                             org.omg.CORBA.portable.ResponseHandler _handler) {
  org.omg.CORBA.portable.OutputStream _output = null;
  {
    switch (_method_id) {
    case 0: {
      int _result = _self.MyID();
      _output = _handler.createReply();
      _output.write_long((int)_result);
      return _output;
    }
    case 1: {
      org.omg.CosNotifyChannelAdmin.EventChannel _result = _self.MyChannel();
      _output = _handler.createReply();
      org.omg.CosNotifyChannelAdmin.EventChannelHelper.write(_output, _result);
      return _output;
    }
    case 2: {
      org.omg.CosNotifyChannelAdmin.InterFilterGroupOperator _result = _self.MyOperator();
      _output = _handler.createReply();
      org.omg.CosNotifyChannelAdmin.InterFilterGroupOperatorHelper.write(_output, _result);
      return _output;
    }
    case 3: {
      com.ericsson.irp.CosNotifyFilter.MappingFilter _result = _self.priority_filter();
      _output = _handler.createReply();
      com.ericsson.irp.CosNotifyFilter.MappingFilterHelper.write(_output, _result);
      return _output;
    }
    case 4: {
      com.ericsson.irp.CosNotifyFilter.MappingFilter arg0;
      arg0 = com.ericsson.irp.CosNotifyFilter.MappingFilterHelper.read(_input);
      _self.priority_filter(arg0);
      _output = _handler.createReply();
      return _output;
    }
    case 5: {
      com.ericsson.irp.CosNotifyFilter.MappingFilter _result = _self.lifetime_filter();
      _output = _handler.createReply();
      com.ericsson.irp.CosNotifyFilter.MappingFilterHelper.write(_output, _result);
      return _output;
    }
    case 6: {
      com.ericsson.irp.CosNotifyFilter.MappingFilter arg0;
      arg0 = com.ericsson.irp.CosNotifyFilter.MappingFilterHelper.read(_input);
      _self.lifetime_filter(arg0);
      _output = _handler.createReply();
      return _output;
    }
    case 7: {
      int[] _result = _self.pull_suppliers();
      _output = _handler.createReply();
      org.omg.CosNotifyChannelAdmin.ProxyIDSeqHelper.write(_output, _result);
      return _output;
    }
    case 8: {
      int[] _result = _self.push_suppliers();
      _output = _handler.createReply();
      org.omg.CosNotifyChannelAdmin.ProxyIDSeqHelper.write(_output, _result);
      return _output;
    }
    case 9: {
    try {
      int proxy_id;
      proxy_id = _input.read_long();
      org.omg.CosNotifyChannelAdmin.ProxySupplier _result = _self.get_proxy_supplier(proxy_id);
      _output = _handler.createReply();
      org.omg.CosNotifyChannelAdmin.ProxySupplierHelper.write(_output, _result);
    }
    catch (org.omg.CosNotifyChannelAdmin.ProxyNotFound _exception) {
      _output = _handler.createExceptionReply();
      org.omg.CosNotifyChannelAdmin.ProxyNotFoundHelper.write(_output, _exception);
    }
      return _output;
    }
    case 10: {
    try {
      org.omg.CosNotifyChannelAdmin.ClientType ctype;
      ctype = org.omg.CosNotifyChannelAdmin.ClientTypeHelper.read(_input);
      org.omg.CORBA.IntHolder proxy_id = new org.omg.CORBA.IntHolder();
      org.omg.CosNotifyChannelAdmin.ProxySupplier _result = _self.obtain_notification_pull_supplier(ctype, 
                                                                                                    proxy_id);
      _output = _handler.createReply();
      org.omg.CosNotifyChannelAdmin.ProxySupplierHelper.write(_output, _result);
      _output.write_long((int)proxy_id.value);
    }
    catch (org.omg.CosNotifyChannelAdmin.AdminLimitExceeded _exception) {
      _output = _handler.createExceptionReply();
      org.omg.CosNotifyChannelAdmin.AdminLimitExceededHelper.write(_output, _exception);
    }
      return _output;
    }
    case 11: {
    try {
      org.omg.CosNotifyChannelAdmin.ClientType ctype;
      ctype = org.omg.CosNotifyChannelAdmin.ClientTypeHelper.read(_input);
      org.omg.CORBA.IntHolder proxy_id = new org.omg.CORBA.IntHolder();
      org.omg.CosNotifyChannelAdmin.ProxySupplier _result = _self.obtain_notification_push_supplier(ctype, 
                                                                                                    proxy_id);
      _output = _handler.createReply();
      org.omg.CosNotifyChannelAdmin.ProxySupplierHelper.write(_output, _result);
      _output.write_long((int)proxy_id.value);
    }
    catch (org.omg.CosNotifyChannelAdmin.AdminLimitExceeded _exception) {
      _output = _handler.createExceptionReply();
      org.omg.CosNotifyChannelAdmin.AdminLimitExceededHelper.write(_output, _exception);
    }
      return _output;
    }
    case 12: {
      _self.destroy();
      _output = _handler.createReply();
      return _output;
    }
    }
    throw new org.omg.CORBA.BAD_OPERATION(2, org.omg.CORBA.CompletionStatus.COMPLETED_NO);
  }
  }
}
