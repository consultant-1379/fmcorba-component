package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::StructuredProxyPullSupplier
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/StructuredProxyPullSupplier:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface StructuredProxyPullSupplier : org.omg.CosNotifyChannelAdmin.ProxySupplier,
                                        com.ericsson.irp.CosNotifyComm.StructuredPullSupplier {
  ...
};
 * </pre>
 */
public class _StructuredProxyPullSupplierStub extends org.omg.CosNotifyChannelAdmin._ProxySupplierStub implements org.omg.CosNotifyChannelAdmin.StructuredProxyPullSupplier {
  /**
	 * 
	 */
	private static final long serialVersionUID = 223662998746305333L;
final public static Class<StructuredProxyPullSupplierOperations> _opsClass = org.omg.CosNotifyChannelAdmin.StructuredProxyPullSupplierOperations.class;

  public java.lang.String[] _ids () {
    return __ids;
  }

  private static java.lang.String[] __ids = {
    "IDL:omg.org/CosNotifyChannelAdmin/StructuredProxyPullSupplier:1.0",
    "IDL:omg.org/CosNotifyChannelAdmin/ProxySupplier:1.0",
    "IDL:omg.org/CosNotification/QoSAdmin:1.0",
    "IDL:omg.org/CosNotifyFilter/FilterAdmin:1.0",
    "IDL:omg.org/CosNotifyComm/StructuredPullSupplier:1.0",
    "IDL:omg.org/CosNotifyComm/NotifySubscribe:1.0"
  };

  /**
   * <pre>
   *   void connect_structured_pull_consumer (in com.ericsson.irp.CosNotifyComm.StructuredPullConsumer pull_consumer)
    raises (com.ericsson.irp.CosEventChannelAdmin.AlreadyConnected);
   * </pre>
   */
  public void connect_structured_pull_consumer (com.ericsson.irp.CosNotifyComm.StructuredPullConsumer pull_consumer) throws  com.ericsson.irp.CosEventChannelAdmin.AlreadyConnected {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        try {
          _output = this._request("connect_structured_pull_consumer", true);
          com.ericsson.irp.CosNotifyComm.StructuredPullConsumerHelper.write(_output, pull_consumer);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("connect_structured_pull_consumer", _opsClass);
        if (_so == null) {
          continue;
        }
        final org.omg.CosNotifyChannelAdmin.StructuredProxyPullSupplierOperations _self = (org.omg.CosNotifyChannelAdmin.StructuredProxyPullSupplierOperations)_so.servant;
        try {
          _self.connect_structured_pull_consumer(pull_consumer);
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

  public com.ericsson.irp.CosNotifyComm.StructuredPullSupplier __com_ericsson_irp_CosNotifyComm_StructuredPullSupplier;
  public com.ericsson.irp.CosNotifyComm.NotifySubscribe __com_ericsson_irp_CosNotifyComm_NotifySubscribe;

  public void _set_delegate (org.omg.CORBA.portable.Delegate _vis_obj_delegate) {
    super._set_delegate(_vis_obj_delegate);
    this.__com_ericsson_irp_CosNotifyComm_StructuredPullSupplier = new com.ericsson.irp.CosNotifyComm._StructuredPullSupplierStub();
    ((org.omg.CORBA.portable.ObjectImpl) this.__com_ericsson_irp_CosNotifyComm_StructuredPullSupplier)._set_delegate(_vis_obj_delegate);
    this.__com_ericsson_irp_CosNotifyComm_NotifySubscribe = new com.ericsson.irp.CosNotifyComm._NotifySubscribeStub();
    ((org.omg.CORBA.portable.ObjectImpl) this.__com_ericsson_irp_CosNotifyComm_NotifySubscribe)._set_delegate(_vis_obj_delegate);
  }

  /**
   * <pre>
   *   org.omg.CosNotification.StructuredEvent pull_structured_event ()
    raises (com.ericsson.irp.CosEventComm.Disconnected);
   * </pre>
   */
  public org.omg.CosNotification.StructuredEvent pull_structured_event () throws  com.ericsson.irp.CosEventComm.Disconnected {
    return this.__com_ericsson_irp_CosNotifyComm_StructuredPullSupplier.pull_structured_event();
  }

  /**
   * <pre>
   *   org.omg.CosNotification.StructuredEvent try_pull_structured_event (out boolean has_event)
    raises (com.ericsson.irp.CosEventComm.Disconnected);
   * </pre>
   */
  public org.omg.CosNotification.StructuredEvent try_pull_structured_event (org.omg.CORBA.BooleanHolder has_event) throws  com.ericsson.irp.CosEventComm.Disconnected {
    return this.__com_ericsson_irp_CosNotifyComm_StructuredPullSupplier.try_pull_structured_event(has_event);
  }

  /**
   * <pre>
   *   void disconnect_structured_pull_supplier ();
   * </pre>
   */
  public void disconnect_structured_pull_supplier () {
    this.__com_ericsson_irp_CosNotifyComm_StructuredPullSupplier.disconnect_structured_pull_supplier();
  }

  /**
   * <pre>
   *   void subscription_change (in org.omg.CosNotification.EventTypeSeq added,
                            in org.omg.CosNotification.EventTypeSeq removed)
    raises (com.ericsson.irp.CosNotifyComm.InvalidEventType);
   * </pre>
   */
  public void subscription_change (org.omg.CosNotification.EventType[] added, 
                                   org.omg.CosNotification.EventType[] removed) throws  com.ericsson.irp.CosNotifyComm.InvalidEventType {
    this.__com_ericsson_irp_CosNotifyComm_NotifySubscribe.subscription_change(added, 
                                                                              removed);
  }

}
