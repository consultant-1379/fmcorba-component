package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::EventChannelFactory
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/EventChannelFactory:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface EventChannelFactory {
  ...
};
 * </pre>
 */
public abstract class EventChannelFactoryPOA extends org.omg.PortableServer.Servant implements 
org.omg.CORBA.portable.InvokeHandler, org.omg.CosNotifyChannelAdmin.EventChannelFactoryOperations {

  public org.omg.CosNotifyChannelAdmin.EventChannelFactory _this () {
   return org.omg.CosNotifyChannelAdmin.EventChannelFactoryHelper.narrow(super._this_object());
  }

  public org.omg.CosNotifyChannelAdmin.EventChannelFactory _this (org.omg.CORBA.ORB orb) {
    return org.omg.CosNotifyChannelAdmin.EventChannelFactoryHelper.narrow(super._this_object(orb));
  }

  public java.lang.String[] _all_interfaces (final org.omg.PortableServer.POA poa, final byte[] objectId) {
    return __ids;
  }

  private static java.lang.String[] __ids = {
    "IDL:omg.org/CosNotifyChannelAdmin/EventChannelFactory:1.0"
  };

  private static java.util.Dictionary<String, int[]> _methods = new java.util.Hashtable<String, int[]>();

  static {
  _methods.put("create_channel", new int[] { 0, 0 });
  _methods.put("get_all_channels", new int[] { 0, 1 });
  _methods.put("get_event_channel", new int[] { 0, 2 });
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
        return org.omg.CosNotifyChannelAdmin.EventChannelFactoryPOA._invoke(this, method[1], _input, handler);
      }
    }
    throw new org.omg.CORBA.BAD_OPERATION(2, org.omg.CORBA.CompletionStatus.COMPLETED_NO);
  }

  public static org.omg.CORBA.portable.OutputStream _invoke (org.omg.CosNotifyChannelAdmin.EventChannelFactoryOperations _self,
                                                             int _method_id,
                                                             org.omg.CORBA.portable.InputStream _input,
                                                             org.omg.CORBA.portable.ResponseHandler _handler) {
  org.omg.CORBA.portable.OutputStream _output = null;
  {
    switch (_method_id) {
    case 0: {
    try {
      org.omg.CosNotification.Property[] initial_qos;
      initial_qos = org.omg.CosNotification.PropertySeqHelper.read(_input);
      org.omg.CosNotification.Property[] initial_admin;
      initial_admin = org.omg.CosNotification.PropertySeqHelper.read(_input);
      org.omg.CORBA.IntHolder id = new org.omg.CORBA.IntHolder();
      org.omg.CosNotifyChannelAdmin.EventChannel _result = _self.create_channel(initial_qos, 
                                                                                initial_admin, 
                                                                                id);
      _output = _handler.createReply();
      org.omg.CosNotifyChannelAdmin.EventChannelHelper.write(_output, _result);
      _output.write_long((int)id.value);
    }
    catch (org.omg.CosNotification.UnsupportedQoS _exception) {
      _output = _handler.createExceptionReply();
      org.omg.CosNotification.UnsupportedQoSHelper.write(_output, _exception);
    }
    catch (org.omg.CosNotification.UnsupportedAdmin _exception) {
      _output = _handler.createExceptionReply();
      org.omg.CosNotification.UnsupportedAdminHelper.write(_output, _exception);
    }
      return _output;
    }
    case 1: {
      int[] _result = _self.get_all_channels();
      _output = _handler.createReply();
      org.omg.CosNotifyChannelAdmin.ChannelIDSeqHelper.write(_output, _result);
      return _output;
    }
    case 2: {
    try {
      int id;
      id = _input.read_long();
      org.omg.CosNotifyChannelAdmin.EventChannel _result = _self.get_event_channel(id);
      _output = _handler.createReply();
      org.omg.CosNotifyChannelAdmin.EventChannelHelper.write(_output, _result);
    }
    catch (org.omg.CosNotifyChannelAdmin.ChannelNotFound _exception) {
      _output = _handler.createExceptionReply();
      org.omg.CosNotifyChannelAdmin.ChannelNotFoundHelper.write(_output, _exception);
    }
      return _output;
    }
    }
    throw new org.omg.CORBA.BAD_OPERATION(2, org.omg.CORBA.CompletionStatus.COMPLETED_NO);
  }
  }
}
