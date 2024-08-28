package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::EventChannel
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/EventChannel:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface EventChannel : org.omg.CosNotification.QoSAdmin,
                         org.omg.CosNotification.AdminPropertiesAdmin,
                         com.ericsson.irp.CosEventChannelAdmin.EventChannel {
  ...
};
 * </pre>
 */
public abstract class EventChannelPOA extends org.omg.PortableServer.Servant implements 
org.omg.CORBA.portable.InvokeHandler, org.omg.CosNotifyChannelAdmin.EventChannelOperations {

  public org.omg.CosNotifyChannelAdmin.EventChannel _this () {
   return org.omg.CosNotifyChannelAdmin.EventChannelHelper.narrow(super._this_object());
  }

  public org.omg.CosNotifyChannelAdmin.EventChannel _this (org.omg.CORBA.ORB orb) {
    return org.omg.CosNotifyChannelAdmin.EventChannelHelper.narrow(super._this_object(orb));
  }

  public java.lang.String[] _all_interfaces (final org.omg.PortableServer.POA poa, final byte[] objectId) {
    return __ids;
  }

  private static java.lang.String[] __ids = {
    "IDL:omg.org/CosNotifyChannelAdmin/EventChannel:1.0",
    "IDL:omg.org/CosNotification/QoSAdmin:1.0",
    "IDL:omg.org/CosNotification/AdminPropertiesAdmin:1.0",
    "IDL:omg.org/CosEventChannelAdmin/EventChannel:1.0"
  };

  private static java.util.Dictionary<String, int[]> _methods = new java.util.Hashtable<String, int[]>();

  static {
  _methods.put("_get_MyFactory", new int[] { 0, 0 });
  _methods.put("_get_default_consumer_admin", new int[] { 0, 1 });
  _methods.put("_get_default_supplier_admin", new int[] { 0, 2 });
  _methods.put("_get_default_filter_factory", new int[] { 0, 3 });
  _methods.put("new_for_consumers", new int[] { 0, 4 });
  _methods.put("new_for_suppliers", new int[] { 0, 5 });
  _methods.put("get_consumeradmin", new int[] { 0, 6 });
  _methods.put("get_supplieradmin", new int[] { 0, 7 });
  _methods.put("get_all_consumeradmins", new int[] { 0, 8 });
  _methods.put("get_all_supplieradmins", new int[] { 0, 9 });
  _methods.put("get_qos", new int[] { 1, 0 });
  _methods.put("set_qos", new int[] { 1, 1 });
  _methods.put("validate_qos", new int[] { 1, 2 });
  _methods.put("get_admin", new int[] { 2, 0 });
  _methods.put("set_admin", new int[] { 2, 1 });
  _methods.put("for_consumers", new int[] { 3, 0 });
  _methods.put("for_suppliers", new int[] { 3, 1 });
  _methods.put("destroy", new int[] { 3, 2 });
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
        return org.omg.CosNotifyChannelAdmin.EventChannelPOA._invoke(this, method[1], _input, handler);
      }
      case 1: {
        return org.omg.CosNotification.QoSAdminPOA._invoke(this, method[1], _input, handler);
      }
      case 2: {
        return org.omg.CosNotification.AdminPropertiesAdminPOA._invoke(this, method[1], _input, handler);
      }
      case 3: {
        return com.ericsson.irp.CosEventChannelAdmin.EventChannelPOA._invoke(this, method[1], _input, handler);
      }
    }
    throw new org.omg.CORBA.BAD_OPERATION(2, org.omg.CORBA.CompletionStatus.COMPLETED_NO);
  }

  public static org.omg.CORBA.portable.OutputStream _invoke (org.omg.CosNotifyChannelAdmin.EventChannelOperations _self,
                                                             int _method_id,
                                                             org.omg.CORBA.portable.InputStream _input,
                                                             org.omg.CORBA.portable.ResponseHandler _handler) {
  org.omg.CORBA.portable.OutputStream _output = null;
  {
    switch (_method_id) {
    case 0: {
      org.omg.CosNotifyChannelAdmin.EventChannelFactory _result = _self.MyFactory();
      _output = _handler.createReply();
      org.omg.CosNotifyChannelAdmin.EventChannelFactoryHelper.write(_output, _result);
      return _output;
    }
    case 1: {
      org.omg.CosNotifyChannelAdmin.ConsumerAdmin _result = _self.default_consumer_admin();
      _output = _handler.createReply();
      org.omg.CosNotifyChannelAdmin.ConsumerAdminHelper.write(_output, _result);
      return _output;
    }
    case 2: {
      org.omg.CosNotifyChannelAdmin.SupplierAdmin _result = _self.default_supplier_admin();
      _output = _handler.createReply();
      org.omg.CosNotifyChannelAdmin.SupplierAdminHelper.write(_output, _result);
      return _output;
    }
    case 3: {
      com.ericsson.irp.CosNotifyFilter.FilterFactory _result = _self.default_filter_factory();
      _output = _handler.createReply();
      com.ericsson.irp.CosNotifyFilter.FilterFactoryHelper.write(_output, _result);
      return _output;
    }
    case 4: {
      org.omg.CosNotifyChannelAdmin.InterFilterGroupOperator op;
      op = org.omg.CosNotifyChannelAdmin.InterFilterGroupOperatorHelper.read(_input);
      org.omg.CORBA.IntHolder id = new org.omg.CORBA.IntHolder();
      org.omg.CosNotifyChannelAdmin.ConsumerAdmin _result = _self.new_for_consumers(op, 
                                                                                    id);
      _output = _handler.createReply();
      org.omg.CosNotifyChannelAdmin.ConsumerAdminHelper.write(_output, _result);
      _output.write_long((int)id.value);
      return _output;
    }
    case 5: {
      org.omg.CosNotifyChannelAdmin.InterFilterGroupOperator op;
      op = org.omg.CosNotifyChannelAdmin.InterFilterGroupOperatorHelper.read(_input);
      org.omg.CORBA.IntHolder id = new org.omg.CORBA.IntHolder();
      org.omg.CosNotifyChannelAdmin.SupplierAdmin _result = _self.new_for_suppliers(op, 
                                                                                    id);
      _output = _handler.createReply();
      org.omg.CosNotifyChannelAdmin.SupplierAdminHelper.write(_output, _result);
      _output.write_long((int)id.value);
      return _output;
    }
    case 6: {
    try {
      int id;
      id = _input.read_long();
      org.omg.CosNotifyChannelAdmin.ConsumerAdmin _result = _self.get_consumeradmin(id);
      _output = _handler.createReply();
      org.omg.CosNotifyChannelAdmin.ConsumerAdminHelper.write(_output, _result);
    }
    catch (org.omg.CosNotifyChannelAdmin.AdminNotFound _exception) {
      _output = _handler.createExceptionReply();
      org.omg.CosNotifyChannelAdmin.AdminNotFoundHelper.write(_output, _exception);
    }
      return _output;
    }
    case 7: {
    try {
      int id;
      id = _input.read_long();
      org.omg.CosNotifyChannelAdmin.SupplierAdmin _result = _self.get_supplieradmin(id);
      _output = _handler.createReply();
      org.omg.CosNotifyChannelAdmin.SupplierAdminHelper.write(_output, _result);
    }
    catch (org.omg.CosNotifyChannelAdmin.AdminNotFound _exception) {
      _output = _handler.createExceptionReply();
      org.omg.CosNotifyChannelAdmin.AdminNotFoundHelper.write(_output, _exception);
    }
      return _output;
    }
    case 8: {
      int[] _result = _self.get_all_consumeradmins();
      _output = _handler.createReply();
      org.omg.CosNotifyChannelAdmin.AdminIDSeqHelper.write(_output, _result);
      return _output;
    }
    case 9: {
      int[] _result = _self.get_all_supplieradmins();
      _output = _handler.createReply();
      org.omg.CosNotifyChannelAdmin.AdminIDSeqHelper.write(_output, _result);
      return _output;
    }
    }
    throw new org.omg.CORBA.BAD_OPERATION(2, org.omg.CORBA.CompletionStatus.COMPLETED_NO);
  }
  }
}
