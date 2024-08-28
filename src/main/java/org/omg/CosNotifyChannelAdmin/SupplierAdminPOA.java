package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::SupplierAdmin
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/SupplierAdmin:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface SupplierAdmin : org.omg.CosNotification.QoSAdmin,
                          com.ericsson.irp.CosNotifyComm.NotifyPublish,
                          com.ericsson.irp.CosNotifyFilter.FilterAdmin,
                          com.ericsson.irp.CosEventChannelAdmin.SupplierAdmin {
  ...
};
 * </pre>
 */
public abstract class SupplierAdminPOA extends org.omg.PortableServer.Servant implements 
org.omg.CORBA.portable.InvokeHandler, org.omg.CosNotifyChannelAdmin.SupplierAdminOperations {

  public org.omg.CosNotifyChannelAdmin.SupplierAdmin _this () {
   return org.omg.CosNotifyChannelAdmin.SupplierAdminHelper.narrow(super._this_object());
  }

  public org.omg.CosNotifyChannelAdmin.SupplierAdmin _this (org.omg.CORBA.ORB orb) {
    return org.omg.CosNotifyChannelAdmin.SupplierAdminHelper.narrow(super._this_object(orb));
  }

  public java.lang.String[] _all_interfaces (final org.omg.PortableServer.POA poa, final byte[] objectId) {
    return __ids;
  }

  private static java.lang.String[] __ids = {
    "IDL:omg.org/CosNotifyChannelAdmin/SupplierAdmin:1.0",
    "IDL:omg.org/CosNotification/QoSAdmin:1.0",
    "IDL:omg.org/CosNotifyComm/NotifyPublish:1.0",
    "IDL:omg.org/CosNotifyFilter/FilterAdmin:1.0",
    "IDL:omg.org/CosEventChannelAdmin/SupplierAdmin:1.0"
  };

  private static java.util.Dictionary<String, int[]> _methods = new java.util.Hashtable<String, int[]>();

  static {
  _methods.put("_get_MyID", new int[] { 0, 0 });
  _methods.put("_get_MyChannel", new int[] { 0, 1 });
  _methods.put("_get_MyOperator", new int[] { 0, 2 });
  _methods.put("_get_pull_consumers", new int[] { 0, 3 });
  _methods.put("_get_push_consumers", new int[] { 0, 4 });
  _methods.put("get_proxy_consumer", new int[] { 0, 5 });
  _methods.put("obtain_notification_pull_consumer", new int[] { 0, 6 });
  _methods.put("obtain_notification_push_consumer", new int[] { 0, 7 });
  _methods.put("destroy", new int[] { 0, 8 });
  _methods.put("get_qos", new int[] { 1, 0 });
  _methods.put("set_qos", new int[] { 1, 1 });
  _methods.put("validate_qos", new int[] { 1, 2 });
  _methods.put("offer_change", new int[] { 2, 0 });
  _methods.put("add_filter", new int[] { 3, 0 });
  _methods.put("remove_filter", new int[] { 3, 1 });
  _methods.put("get_filter", new int[] { 3, 2 });
  _methods.put("get_all_filters", new int[] { 3, 3 });
  _methods.put("remove_all_filters", new int[] { 3, 4 });
  _methods.put("obtain_push_consumer", new int[] { 4, 0 });
  _methods.put("obtain_pull_consumer", new int[] { 4, 1 });
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
        return org.omg.CosNotifyChannelAdmin.SupplierAdminPOA._invoke(this, method[1], _input, handler);
      }
      case 1: {
        return org.omg.CosNotification.QoSAdminPOA._invoke(this, method[1], _input, handler);
      }
      case 2: {
        return com.ericsson.irp.CosNotifyComm.NotifyPublishPOA._invoke(this, method[1], _input, handler);
      }
      case 3: {
        return com.ericsson.irp.CosNotifyFilter.FilterAdminPOA._invoke(this, method[1], _input, handler);
      }
      case 4: {
        return com.ericsson.irp.CosEventChannelAdmin.SupplierAdminPOA._invoke(this, method[1], _input, handler);
      }
    }
    throw new org.omg.CORBA.BAD_OPERATION(2, org.omg.CORBA.CompletionStatus.COMPLETED_NO);
  }

  public static org.omg.CORBA.portable.OutputStream _invoke (org.omg.CosNotifyChannelAdmin.SupplierAdminOperations _self,
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
      int[] _result = _self.pull_consumers();
      _output = _handler.createReply();
      org.omg.CosNotifyChannelAdmin.ProxyIDSeqHelper.write(_output, _result);
      return _output;
    }
    case 4: {
      int[] _result = _self.push_consumers();
      _output = _handler.createReply();
      org.omg.CosNotifyChannelAdmin.ProxyIDSeqHelper.write(_output, _result);
      return _output;
    }
    case 5: {
    try {
      int proxy_id;
      proxy_id = _input.read_long();
      org.omg.CosNotifyChannelAdmin.ProxyConsumer _result = _self.get_proxy_consumer(proxy_id);
      _output = _handler.createReply();
      org.omg.CosNotifyChannelAdmin.ProxyConsumerHelper.write(_output, _result);
    }
    catch (org.omg.CosNotifyChannelAdmin.ProxyNotFound _exception) {
      _output = _handler.createExceptionReply();
      org.omg.CosNotifyChannelAdmin.ProxyNotFoundHelper.write(_output, _exception);
    }
      return _output;
    }
    case 6: {
    try {
      org.omg.CosNotifyChannelAdmin.ClientType ctype;
      ctype = org.omg.CosNotifyChannelAdmin.ClientTypeHelper.read(_input);
      org.omg.CORBA.IntHolder proxy_id = new org.omg.CORBA.IntHolder();
      org.omg.CosNotifyChannelAdmin.ProxyConsumer _result = _self.obtain_notification_pull_consumer(ctype, 
                                                                                                    proxy_id);
      _output = _handler.createReply();
      org.omg.CosNotifyChannelAdmin.ProxyConsumerHelper.write(_output, _result);
      _output.write_long((int)proxy_id.value);
    }
    catch (org.omg.CosNotifyChannelAdmin.AdminLimitExceeded _exception) {
      _output = _handler.createExceptionReply();
      org.omg.CosNotifyChannelAdmin.AdminLimitExceededHelper.write(_output, _exception);
    }
      return _output;
    }
    case 7: {
    try {
      org.omg.CosNotifyChannelAdmin.ClientType ctype;
      ctype = org.omg.CosNotifyChannelAdmin.ClientTypeHelper.read(_input);
      org.omg.CORBA.IntHolder proxy_id = new org.omg.CORBA.IntHolder();
      org.omg.CosNotifyChannelAdmin.ProxyConsumer _result = _self.obtain_notification_push_consumer(ctype, 
                                                                                                    proxy_id);
      _output = _handler.createReply();
      org.omg.CosNotifyChannelAdmin.ProxyConsumerHelper.write(_output, _result);
      _output.write_long((int)proxy_id.value);
    }
    catch (org.omg.CosNotifyChannelAdmin.AdminLimitExceeded _exception) {
      _output = _handler.createExceptionReply();
      org.omg.CosNotifyChannelAdmin.AdminLimitExceededHelper.write(_output, _exception);
    }
      return _output;
    }
    case 8: {
      _self.destroy();
      _output = _handler.createReply();
      return _output;
    }
    }
    throw new org.omg.CORBA.BAD_OPERATION(2, org.omg.CORBA.CompletionStatus.COMPLETED_NO);
  }
  }
}
