package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::ProxyPushSupplier
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/ProxyPushSupplier:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface ProxyPushSupplier : org.omg.CosNotifyChannelAdmin.ProxySupplier,
                              com.ericsson.irp.CosNotifyComm.PushSupplier {
  ...
};
 * </pre>
 */
public class _ProxyPushSupplierStub extends org.omg.CosNotifyChannelAdmin._ProxySupplierStub implements org.omg.CosNotifyChannelAdmin.ProxyPushSupplier {
  /**
	 * 
	 */
	private static final long serialVersionUID = -223644832406142899L;
final public static Class<ProxyPushSupplierOperations> _opsClass = org.omg.CosNotifyChannelAdmin.ProxyPushSupplierOperations.class;

  public java.lang.String[] _ids () {
    return __ids;
  }

  private static java.lang.String[] __ids = {
    "IDL:omg.org/CosNotifyChannelAdmin/ProxyPushSupplier:1.0",
    "IDL:omg.org/CosNotifyChannelAdmin/ProxySupplier:1.0",
    "IDL:omg.org/CosNotification/QoSAdmin:1.0",
    "IDL:omg.org/CosNotifyFilter/FilterAdmin:1.0",
    "IDL:omg.org/CosNotifyComm/PushSupplier:1.0",
    "IDL:omg.org/CosNotifyComm/NotifySubscribe:1.0",
    "IDL:omg.org/CosEventComm/PushSupplier:1.0"
  };

  /**
   * <pre>
   *   void resume_connection ()
    raises (org.omg.CosNotifyChannelAdmin.ConnectionAlreadyActive,
            org.omg.CosNotifyChannelAdmin.NotConnected);
   * </pre>
   */
  public void resume_connection () throws  org.omg.CosNotifyChannelAdmin.ConnectionAlreadyActive, 
                                           org.omg.CosNotifyChannelAdmin.NotConnected {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        try {
          _output = this._request("resume_connection", true);
          _input = this._invoke(_output);
        }
        catch (org.omg.CORBA.portable.ApplicationException _exception) {
          java.lang.String _exception_id = _exception.getId();
          if (_exception_id.equals(org.omg.CosNotifyChannelAdmin.ConnectionAlreadyActiveHelper.id())) {
            throw             org.omg.CosNotifyChannelAdmin.ConnectionAlreadyActiveHelper.read(_exception.getInputStream());
          }
          if (_exception_id.equals(org.omg.CosNotifyChannelAdmin.NotConnectedHelper.id())) {
            throw             org.omg.CosNotifyChannelAdmin.NotConnectedHelper.read(_exception.getInputStream());
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("resume_connection", _opsClass);
        if (_so == null) {
          continue;
        }
        final org.omg.CosNotifyChannelAdmin.ProxyPushSupplierOperations _self = (org.omg.CosNotifyChannelAdmin.ProxyPushSupplierOperations)_so.servant;
        try {
          _self.resume_connection();
          if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
            ((org.omg.CORBA.portable.ServantObjectExt)_so).normalCompletion();
          }
        } catch (org.omg.CosNotifyChannelAdmin.ConnectionAlreadyActive x_1) {
          if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
            ((org.omg.CORBA.portable.ServantObjectExt)_so).exceptionalCompletion((Throwable)x_1);
          }
          throw x_1;
        } catch (org.omg.CosNotifyChannelAdmin.NotConnected x_2) {
          if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
            ((org.omg.CORBA.portable.ServantObjectExt)_so).exceptionalCompletion((Throwable)x_2);
          }
          throw x_2;

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

  /**
   * <pre>
   *   void suspend_connection ()
    raises (org.omg.CosNotifyChannelAdmin.ConnectionAlreadyInactive,
            org.omg.CosNotifyChannelAdmin.NotConnected);
   * </pre>
   */
  public void suspend_connection () throws  org.omg.CosNotifyChannelAdmin.ConnectionAlreadyInactive, 
                                            org.omg.CosNotifyChannelAdmin.NotConnected {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        try {
          _output = this._request("suspend_connection", true);
          _input = this._invoke(_output);
        }
        catch (org.omg.CORBA.portable.ApplicationException _exception) {
          java.lang.String _exception_id = _exception.getId();
          if (_exception_id.equals(org.omg.CosNotifyChannelAdmin.ConnectionAlreadyInactiveHelper.id())) {
            throw             org.omg.CosNotifyChannelAdmin.ConnectionAlreadyInactiveHelper.read(_exception.getInputStream());
          }
          if (_exception_id.equals(org.omg.CosNotifyChannelAdmin.NotConnectedHelper.id())) {
            throw             org.omg.CosNotifyChannelAdmin.NotConnectedHelper.read(_exception.getInputStream());
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("suspend_connection", _opsClass);
        if (_so == null) {
          continue;
        }
        final org.omg.CosNotifyChannelAdmin.ProxyPushSupplierOperations _self = (org.omg.CosNotifyChannelAdmin.ProxyPushSupplierOperations)_so.servant;
        try {
          _self.suspend_connection();
          if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
            ((org.omg.CORBA.portable.ServantObjectExt)_so).normalCompletion();
          }
        } catch (org.omg.CosNotifyChannelAdmin.ConnectionAlreadyInactive x_1) {
          if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
            ((org.omg.CORBA.portable.ServantObjectExt)_so).exceptionalCompletion((Throwable)x_1);
          }
          throw x_1;
        } catch (org.omg.CosNotifyChannelAdmin.NotConnected x_2) {
          if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
            ((org.omg.CORBA.portable.ServantObjectExt)_so).exceptionalCompletion((Throwable)x_2);
          }
          throw x_2;

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

  /**
   * <pre>
   *   void connect_any_push_consumer (in com.ericsson.irp.CosEventComm.PushConsumer push_consumer)
    raises (com.ericsson.irp.CosEventChannelAdmin.AlreadyConnected,
            com.ericsson.irp.CosEventChannelAdmin.TypeError);
   * </pre>
   */
  public void connect_any_push_consumer (com.ericsson.irp.CosEventComm.PushConsumer push_consumer) throws  com.ericsson.irp.CosEventChannelAdmin.AlreadyConnected, 
                                                                                                           com.ericsson.irp.CosEventChannelAdmin.TypeError {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        try {
          _output = this._request("connect_any_push_consumer", true);
          com.ericsson.irp.CosEventComm.PushConsumerHelper.write(_output, push_consumer);
          _input = this._invoke(_output);
        }
        catch (org.omg.CORBA.portable.ApplicationException _exception) {
          java.lang.String _exception_id = _exception.getId();
          if (_exception_id.equals(com.ericsson.irp.CosEventChannelAdmin.AlreadyConnectedHelper.id())) {
            throw             com.ericsson.irp.CosEventChannelAdmin.AlreadyConnectedHelper.read(_exception.getInputStream());
          }
          if (_exception_id.equals(com.ericsson.irp.CosEventChannelAdmin.TypeErrorHelper.id())) {
            throw             com.ericsson.irp.CosEventChannelAdmin.TypeErrorHelper.read(_exception.getInputStream());
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("connect_any_push_consumer", _opsClass);
        if (_so == null) {
          continue;
        }
        final org.omg.CosNotifyChannelAdmin.ProxyPushSupplierOperations _self = (org.omg.CosNotifyChannelAdmin.ProxyPushSupplierOperations)_so.servant;
        try {
          _self.connect_any_push_consumer(push_consumer);
          if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
            ((org.omg.CORBA.portable.ServantObjectExt)_so).normalCompletion();
          }
        } catch (com.ericsson.irp.CosEventChannelAdmin.AlreadyConnected x_1) {
          if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
            ((org.omg.CORBA.portable.ServantObjectExt)_so).exceptionalCompletion((Throwable)x_1);
          }
          throw x_1;
        } catch (com.ericsson.irp.CosEventChannelAdmin.TypeError x_2) {
          if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
            ((org.omg.CORBA.portable.ServantObjectExt)_so).exceptionalCompletion((Throwable)x_2);
          }
          throw x_2;

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

  public com.ericsson.irp.CosNotifyComm.PushSupplier __com_ericsson_irp_CosNotifyComm_PushSupplier;
  public com.ericsson.irp.CosNotifyComm.NotifySubscribe __com_ericsson_irp_CosNotifyComm_NotifySubscribe;
  public com.ericsson.irp.CosEventComm.PushSupplier __com_ericsson_irp_CosEventComm_PushSupplier;

  public void _set_delegate (org.omg.CORBA.portable.Delegate _vis_obj_delegate) {
    super._set_delegate(_vis_obj_delegate);
    this.__com_ericsson_irp_CosNotifyComm_PushSupplier = new com.ericsson.irp.CosNotifyComm._PushSupplierStub();
    ((org.omg.CORBA.portable.ObjectImpl) this.__com_ericsson_irp_CosNotifyComm_PushSupplier)._set_delegate(_vis_obj_delegate);
    this.__com_ericsson_irp_CosNotifyComm_NotifySubscribe = new com.ericsson.irp.CosNotifyComm._NotifySubscribeStub();
    ((org.omg.CORBA.portable.ObjectImpl) this.__com_ericsson_irp_CosNotifyComm_NotifySubscribe)._set_delegate(_vis_obj_delegate);
    this.__com_ericsson_irp_CosEventComm_PushSupplier = new com.ericsson.irp.CosEventComm._PushSupplierStub();
    ((org.omg.CORBA.portable.ObjectImpl) this.__com_ericsson_irp_CosEventComm_PushSupplier)._set_delegate(_vis_obj_delegate);
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

  /**
   * <pre>
   *   void disconnect_push_supplier ();
   * </pre>
   */
  public void disconnect_push_supplier () {
    this.__com_ericsson_irp_CosEventComm_PushSupplier.disconnect_push_supplier();
  }

}
