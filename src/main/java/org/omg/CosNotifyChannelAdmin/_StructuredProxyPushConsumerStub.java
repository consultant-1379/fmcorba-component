package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::StructuredProxyPushConsumer
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/StructuredProxyPushConsumer:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface StructuredProxyPushConsumer : org.omg.CosNotifyChannelAdmin.ProxyConsumer,
                                        com.ericsson.irp.CosNotifyComm.StructuredPushConsumer {
  ...
};
 * </pre>
 */
public class _StructuredProxyPushConsumerStub extends org.omg.CosNotifyChannelAdmin._ProxyConsumerStub implements org.omg.CosNotifyChannelAdmin.StructuredProxyPushConsumer {
  /**
	 * 
	 */
	private static final long serialVersionUID = 5430661527691374912L;
final public static Class<StructuredProxyPushConsumerOperations> _opsClass = org.omg.CosNotifyChannelAdmin.StructuredProxyPushConsumerOperations.class;

  public java.lang.String[] _ids () {
    return __ids;
  }

  private static java.lang.String[] __ids = {
    "IDL:omg.org/CosNotifyChannelAdmin/StructuredProxyPushConsumer:1.0",
    "IDL:omg.org/CosNotifyChannelAdmin/ProxyConsumer:1.0",
    "IDL:omg.org/CosNotification/QoSAdmin:1.0",
    "IDL:omg.org/CosNotifyFilter/FilterAdmin:1.0",
    "IDL:omg.org/CosNotifyComm/StructuredPushConsumer:1.0",
    "IDL:omg.org/CosNotifyComm/NotifyPublish:1.0"
  };

  /**
   * <pre>
   *   void connect_structured_push_supplier (in com.ericsson.irp.CosNotifyComm.StructuredPushSupplier push_supplier)
    raises (com.ericsson.irp.CosEventChannelAdmin.AlreadyConnected);
   * </pre>
   */
  public void connect_structured_push_supplier (com.ericsson.irp.CosNotifyComm.StructuredPushSupplier push_supplier) throws  com.ericsson.irp.CosEventChannelAdmin.AlreadyConnected {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        try {
          _output = this._request("connect_structured_push_supplier", true);
          com.ericsson.irp.CosNotifyComm.StructuredPushSupplierHelper.write(_output, push_supplier);
          _input = this._invoke(_output);
        }
        catch (org.omg.CORBA.portable.ApplicationException _exception) {
          java.lang.String _exception_id = _exception.getId();
          if (_exception_id.equals(com.ericsson.irp.CosEventChannelAdmin.AlreadyConnectedHelper.id())) {
            throw             com.ericsson.irp.CosEventChannelAdmin.AlreadyConnectedHelper.read(_exception.getInputStream());
          }
          throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: " + _exception_id);
        }
        catch (org.omg.CORBA.NO_RESPONSE _vis_nm ) {
          if(_vis_nm.minor == (org.omg.CORBA.OMGVMCID.value | 99)) {
            return;
          }
          throw _vis_nm;
        }
        catch (org.omg.CORBA.portable.RemarshalException _exception) {
          continue;
        }
        finally {
          this._releaseReply(_input);
        }
      } else {
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("connect_structured_push_supplier", _opsClass);
        if (_so == null) {
          continue;
        }
        final org.omg.CosNotifyChannelAdmin.StructuredProxyPushConsumerOperations _self = (org.omg.CosNotifyChannelAdmin.StructuredProxyPushConsumerOperations)_so.servant;
        try {
          _self.connect_structured_push_supplier(push_supplier);
          if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
            ((org.omg.CORBA.portable.ServantObjectExt)_so).normalCompletion();
          }
        } catch (com.ericsson.irp.CosEventChannelAdmin.AlreadyConnected x_1) {
          if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
            ((org.omg.CORBA.portable.ServantObjectExt)_so).exceptionalCompletion((Throwable)x_1);
          }
          throw x_1;

        } catch (java.lang.RuntimeException _vis_re) {
          if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
            ((org.omg.CORBA.portable.ServantObjectExt)_so).exceptionalCompletion((Throwable)_vis_re);
          }
          throw _vis_re;
        } catch (java.lang.Error _vis_err) {
          if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
            ((org.omg.CORBA.portable.ServantObjectExt)_so).exceptionalCompletion((Throwable)_vis_err);
          }
          throw _vis_err;
        } finally {
          _servant_postinvoke(_so);
        }
      }
      break;
    }

  }

  public com.ericsson.irp.CosNotifyComm.StructuredPushConsumer __com_ericsson_irp_CosNotifyComm_StructuredPushConsumer;
  public com.ericsson.irp.CosNotifyComm.NotifyPublish __com_ericsson_irp_CosNotifyComm_NotifyPublish;

  public void _set_delegate (org.omg.CORBA.portable.Delegate _vis_obj_delegate) {
    super._set_delegate(_vis_obj_delegate);
    this.__com_ericsson_irp_CosNotifyComm_StructuredPushConsumer = new com.ericsson.irp.CosNotifyComm._StructuredPushConsumerStub();
    ((org.omg.CORBA.portable.ObjectImpl) this.__com_ericsson_irp_CosNotifyComm_StructuredPushConsumer)._set_delegate(_vis_obj_delegate);
    this.__com_ericsson_irp_CosNotifyComm_NotifyPublish = new com.ericsson.irp.CosNotifyComm._NotifyPublishStub();
    ((org.omg.CORBA.portable.ObjectImpl) this.__com_ericsson_irp_CosNotifyComm_NotifyPublish)._set_delegate(_vis_obj_delegate);
  }

  /**
   * <pre>
   *   void push_structured_event (in org.omg.CosNotification.StructuredEvent notification)
    raises (com.ericsson.irp.CosEventComm.Disconnected);
   * </pre>
   */
  public void push_structured_event (org.omg.CosNotification.StructuredEvent notification) throws  com.ericsson.irp.CosEventComm.Disconnected {
    this.__com_ericsson_irp_CosNotifyComm_StructuredPushConsumer.push_structured_event(notification);
  }

  /**
   * <pre>
   *   void disconnect_structured_push_consumer ();
   * </pre>
   */
  public void disconnect_structured_push_consumer () {
    this.__com_ericsson_irp_CosNotifyComm_StructuredPushConsumer.disconnect_structured_push_consumer();
  }

  /**
   * <pre>
   *   void offer_change (in org.omg.CosNotification.EventTypeSeq added,
                     in org.omg.CosNotification.EventTypeSeq removed)
    raises (com.ericsson.irp.CosNotifyComm.InvalidEventType);
   * </pre>
   */
  public void offer_change (org.omg.CosNotification.EventType[] added, 
                            org.omg.CosNotification.EventType[] removed) throws  com.ericsson.irp.CosNotifyComm.InvalidEventType {
    this.__com_ericsson_irp_CosNotifyComm_NotifyPublish.offer_change(added, removed);
  }

}
