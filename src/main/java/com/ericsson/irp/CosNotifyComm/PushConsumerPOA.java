package com.ericsson.irp.CosNotifyComm;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyComm.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyComm::PushConsumer
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyComm/PushConsumer:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface PushConsumer : com.ericsson.irp.CosNotifyComm.NotifyPublish,
                         com.ericsson.irp.CosEventComm.PushConsumer {
  ...
};
 * </pre>
 */
public abstract class PushConsumerPOA extends org.omg.PortableServer.Servant implements 
org.omg.CORBA.portable.InvokeHandler, com.ericsson.irp.CosNotifyComm.PushConsumerOperations {

  public com.ericsson.irp.CosNotifyComm.PushConsumer _this () {
   return com.ericsson.irp.CosNotifyComm.PushConsumerHelper.narrow(super._this_object());
  }

  public com.ericsson.irp.CosNotifyComm.PushConsumer _this (org.omg.CORBA.ORB orb) {
    return com.ericsson.irp.CosNotifyComm.PushConsumerHelper.narrow(super._this_object(orb));
  }

  public java.lang.String[] _all_interfaces (final org.omg.PortableServer.POA poa, final byte[] objectId) {
    return __ids;
  }

  private static java.lang.String[] __ids = {
    "IDL:omg.org/CosNotifyComm/PushConsumer:1.0",
    "IDL:omg.org/CosNotifyComm/NotifyPublish:1.0",
    "IDL:omg.org/CosEventComm/PushConsumer:1.0"
  };

  private static java.util.Dictionary<String, int[]> _methods = new java.util.Hashtable<String, int[]>();

  static {
  _methods.put("offer_change", new int[] { 1, 0 });
  _methods.put("push", new int[] { 2, 0 });
  _methods.put("disconnect_push_consumer", new int[] { 2, 1 });
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
        return com.ericsson.irp.CosNotifyComm.PushConsumerPOA._invoke(this, method[1], _input, handler);
      }
      case 1: {
        return com.ericsson.irp.CosNotifyComm.NotifyPublishPOA._invoke(this, method[1], _input, handler);
      }
      case 2: {
        return com.ericsson.irp.CosEventComm.PushConsumerPOA._invoke(this, method[1], _input, handler);
      }
    }
    throw new org.omg.CORBA.BAD_OPERATION(2, org.omg.CORBA.CompletionStatus.COMPLETED_NO);
  }

  public static org.omg.CORBA.portable.OutputStream _invoke (com.ericsson.irp.CosNotifyComm.PushConsumerOperations _self,
                                                             int _method_id,
                                                             org.omg.CORBA.portable.InputStream _input,
                                                             org.omg.CORBA.portable.ResponseHandler _handler) {
  org.omg.CORBA.portable.OutputStream _output = null;
  return _output;
  }
}
