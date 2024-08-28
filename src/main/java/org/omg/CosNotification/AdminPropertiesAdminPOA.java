package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::AdminPropertiesAdmin
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/AdminPropertiesAdmin:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface AdminPropertiesAdmin {
  ...
};
 * </pre>
 */
public abstract class AdminPropertiesAdminPOA extends org.omg.PortableServer.Servant implements 
org.omg.CORBA.portable.InvokeHandler, org.omg.CosNotification.AdminPropertiesAdminOperations {

  public org.omg.CosNotification.AdminPropertiesAdmin _this () {
   return org.omg.CosNotification.AdminPropertiesAdminHelper.narrow(super._this_object());
  }

  public org.omg.CosNotification.AdminPropertiesAdmin _this (org.omg.CORBA.ORB orb) {
    return org.omg.CosNotification.AdminPropertiesAdminHelper.narrow(super._this_object(orb));
  }

  public java.lang.String[] _all_interfaces (final org.omg.PortableServer.POA poa, final byte[] objectId) {
    return __ids;
  }

  private static java.lang.String[] __ids = {
    "IDL:omg.org/CosNotification/AdminPropertiesAdmin:1.0"
  };

  private static java.util.Dictionary<String, int[]> _methods = new java.util.Hashtable<String, int[]>();

  static {
  _methods.put("get_admin", new int[] { 0, 0 });
  _methods.put("set_admin", new int[] { 0, 1 });
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
        return org.omg.CosNotification.AdminPropertiesAdminPOA._invoke(this, method[1], _input, handler);
      }
    }
    throw new org.omg.CORBA.BAD_OPERATION(2, org.omg.CORBA.CompletionStatus.COMPLETED_NO);
  }

  public static org.omg.CORBA.portable.OutputStream _invoke (org.omg.CosNotification.AdminPropertiesAdminOperations _self,
                                                             int _method_id,
                                                             org.omg.CORBA.portable.InputStream _input,
                                                             org.omg.CORBA.portable.ResponseHandler _handler) {
  org.omg.CORBA.portable.OutputStream _output = null;
  {
    switch (_method_id) {
    case 0: {
      org.omg.CosNotification.Property[] _result = _self.get_admin();
      _output = _handler.createReply();
      org.omg.CosNotification.PropertySeqHelper.write(_output, _result);
      return _output;
    }
    case 1: {
    try {
      org.omg.CosNotification.Property[] admin;
      admin = org.omg.CosNotification.PropertySeqHelper.read(_input);
      _self.set_admin(admin);
      _output = _handler.createReply();
    }
    catch (org.omg.CosNotification.UnsupportedAdmin _exception) {
      _output = _handler.createExceptionReply();
      org.omg.CosNotification.UnsupportedAdminHelper.write(_output, _exception);
    }
      return _output;
    }
    }
    throw new org.omg.CORBA.BAD_OPERATION(2, org.omg.CORBA.CompletionStatus.COMPLETED_NO);
  }
  }
}
