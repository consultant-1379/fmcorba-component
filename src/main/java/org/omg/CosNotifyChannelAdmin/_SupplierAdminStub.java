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
public class _SupplierAdminStub extends org.omg.CosNotification._QoSAdminStub implements org.omg.CosNotifyChannelAdmin.SupplierAdmin {
  /**
	 * 
	 */
	private static final long serialVersionUID = 5334509884774308003L;
final public static Class<SupplierAdminOperations> _opsClass = org.omg.CosNotifyChannelAdmin.SupplierAdminOperations.class;

  public java.lang.String[] _ids () {
    return __ids;
  }

  private static java.lang.String[] __ids = {
    "IDL:omg.org/CosNotifyChannelAdmin/SupplierAdmin:1.0",
    "IDL:omg.org/CosNotification/QoSAdmin:1.0",
    "IDL:omg.org/CosNotifyComm/NotifyPublish:1.0",
    "IDL:omg.org/CosNotifyFilter/FilterAdmin:1.0",
    "IDL:omg.org/CosEventChannelAdmin/SupplierAdmin:1.0"
  };

  /**
   * <pre>
   *   void destroy ();
   * </pre>
   */
  public void destroy () {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        try {
          _output = this._request("destroy", true);
          _input = this._invoke(_output);
        }
        catch (org.omg.CORBA.portable.ApplicationException _exception) {
          java.lang.String _exception_id = _exception.getId();
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("destroy", _opsClass);
        if (_so == null) {
          continue;
        }
        final org.omg.CosNotifyChannelAdmin.SupplierAdminOperations _self = (org.omg.CosNotifyChannelAdmin.SupplierAdminOperations)_so.servant;
        try {
          _self.destroy();
          if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
            ((org.omg.CORBA.portable.ServantObjectExt)_so).normalCompletion();
          }

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
   *   org.omg.CosNotifyChannelAdmin.ProxyConsumer obtain_notification_push_consumer (in org.omg.CosNotifyChannelAdmin.ClientType ctype,
                                                                                 out org.omg.CosNotifyChannelAdmin.ProxyID proxy_id)
    raises (org.omg.CosNotifyChannelAdmin.AdminLimitExceeded);
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.ProxyConsumer obtain_notification_push_consumer (org.omg.CosNotifyChannelAdmin.ClientType ctype, 
                                                                                        org.omg.CORBA.IntHolder proxy_id) throws  org.omg.CosNotifyChannelAdmin.AdminLimitExceeded {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        org.omg.CosNotifyChannelAdmin.ProxyConsumer _result;
        try {
          _output = this._request("obtain_notification_push_consumer", true);
          org.omg.CosNotifyChannelAdmin.ClientTypeHelper.write(_output, ctype);
          _input = this._invoke(_output);
          _result = org.omg.CosNotifyChannelAdmin.ProxyConsumerHelper.read(_input);
          proxy_id.value = _input.read_long();
          return _result;
        }
        catch (org.omg.CORBA.portable.ApplicationException _exception) {
          java.lang.String _exception_id = _exception.getId();
          if (_exception_id.equals(org.omg.CosNotifyChannelAdmin.AdminLimitExceededHelper.id())) {
            throw             org.omg.CosNotifyChannelAdmin.AdminLimitExceededHelper.read(_exception.getInputStream());
          }
          throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: " + _exception_id);
        }
        catch (org.omg.CORBA.NO_RESPONSE _vis_nm ) {
          if(_vis_nm.minor == (org.omg.CORBA.OMGVMCID.value | 99)) {
            return null;
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("obtain_notification_push_consumer", _opsClass);
        if (_so == null) {
          continue;
        }
        final org.omg.CosNotifyChannelAdmin.SupplierAdminOperations _self = (org.omg.CosNotifyChannelAdmin.SupplierAdminOperations)_so.servant;
        try {
          org.omg.CosNotifyChannelAdmin.ProxyConsumer _ret = _self.obtain_notification_push_consumer(ctype, 
                                                                                                     proxy_id);
          if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
            ((org.omg.CORBA.portable.ServantObjectExt)_so).normalCompletion();
          }
          return _ret;
        } catch (org.omg.CosNotifyChannelAdmin.AdminLimitExceeded x_1) {
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
    }

  }

  /**
   * <pre>
   *   org.omg.CosNotifyChannelAdmin.ProxyConsumer obtain_notification_pull_consumer (in org.omg.CosNotifyChannelAdmin.ClientType ctype,
                                                                                 out org.omg.CosNotifyChannelAdmin.ProxyID proxy_id)
    raises (org.omg.CosNotifyChannelAdmin.AdminLimitExceeded);
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.ProxyConsumer obtain_notification_pull_consumer (org.omg.CosNotifyChannelAdmin.ClientType ctype, 
                                                                                        org.omg.CORBA.IntHolder proxy_id) throws  org.omg.CosNotifyChannelAdmin.AdminLimitExceeded {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        org.omg.CosNotifyChannelAdmin.ProxyConsumer _result;
        try {
          _output = this._request("obtain_notification_pull_consumer", true);
          org.omg.CosNotifyChannelAdmin.ClientTypeHelper.write(_output, ctype);
          _input = this._invoke(_output);
          _result = org.omg.CosNotifyChannelAdmin.ProxyConsumerHelper.read(_input);
          proxy_id.value = _input.read_long();
          return _result;
        }
        catch (org.omg.CORBA.portable.ApplicationException _exception) {
          java.lang.String _exception_id = _exception.getId();
          if (_exception_id.equals(org.omg.CosNotifyChannelAdmin.AdminLimitExceededHelper.id())) {
            throw             org.omg.CosNotifyChannelAdmin.AdminLimitExceededHelper.read(_exception.getInputStream());
          }
          throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: " + _exception_id);
        }
        catch (org.omg.CORBA.NO_RESPONSE _vis_nm ) {
          if(_vis_nm.minor == (org.omg.CORBA.OMGVMCID.value | 99)) {
            return null;
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("obtain_notification_pull_consumer", _opsClass);
        if (_so == null) {
          continue;
        }
        final org.omg.CosNotifyChannelAdmin.SupplierAdminOperations _self = (org.omg.CosNotifyChannelAdmin.SupplierAdminOperations)_so.servant;
        try {
          org.omg.CosNotifyChannelAdmin.ProxyConsumer _ret = _self.obtain_notification_pull_consumer(ctype, 
                                                                                                     proxy_id);
          if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
            ((org.omg.CORBA.portable.ServantObjectExt)_so).normalCompletion();
          }
          return _ret;
        } catch (org.omg.CosNotifyChannelAdmin.AdminLimitExceeded x_1) {
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
    }

  }

  /**
   * <pre>
   *   org.omg.CosNotifyChannelAdmin.ProxyConsumer get_proxy_consumer (in org.omg.CosNotifyChannelAdmin.ProxyID proxy_id)
    raises (org.omg.CosNotifyChannelAdmin.ProxyNotFound);
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.ProxyConsumer get_proxy_consumer (int proxy_id) throws  org.omg.CosNotifyChannelAdmin.ProxyNotFound {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        org.omg.CosNotifyChannelAdmin.ProxyConsumer _result;
        try {
          _output = this._request("get_proxy_consumer", true);
          _output.write_long((int)proxy_id);
          _input = this._invoke(_output);
          _result = org.omg.CosNotifyChannelAdmin.ProxyConsumerHelper.read(_input);
          return _result;
        }
        catch (org.omg.CORBA.portable.ApplicationException _exception) {
          java.lang.String _exception_id = _exception.getId();
          if (_exception_id.equals(org.omg.CosNotifyChannelAdmin.ProxyNotFoundHelper.id())) {
            throw             org.omg.CosNotifyChannelAdmin.ProxyNotFoundHelper.read(_exception.getInputStream());
          }
          throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: " + _exception_id);
        }
        catch (org.omg.CORBA.NO_RESPONSE _vis_nm ) {
          if(_vis_nm.minor == (org.omg.CORBA.OMGVMCID.value | 99)) {
            return null;
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("get_proxy_consumer", _opsClass);
        if (_so == null) {
          continue;
        }
        final org.omg.CosNotifyChannelAdmin.SupplierAdminOperations _self = (org.omg.CosNotifyChannelAdmin.SupplierAdminOperations)_so.servant;
        try {
          org.omg.CosNotifyChannelAdmin.ProxyConsumer _ret = _self.get_proxy_consumer(proxy_id);
          if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
            ((org.omg.CORBA.portable.ServantObjectExt)_so).normalCompletion();
          }
          return _ret;
        } catch (org.omg.CosNotifyChannelAdmin.ProxyNotFound x_1) {
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
    }

  }

  /**
   * <pre>
   *   readonly attribute org.omg.CosNotifyChannelAdmin.ProxyIDSeq push_consumers;
   * </pre>
   */
  public int[] push_consumers () {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        int[] _result;
        try {
          _output = this._request("_get_push_consumers", true);
          _input = this._invoke(_output);
          _result = org.omg.CosNotifyChannelAdmin.ProxyIDSeqHelper.read(_input);
          return _result;
        }
        catch (org.omg.CORBA.portable.ApplicationException _exception) {
          java.lang.String _exception_id = _exception.getId();
          throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: " + _exception_id);
        }
        catch (org.omg.CORBA.NO_RESPONSE _vis_nm ) {
          if(_vis_nm.minor == (org.omg.CORBA.OMGVMCID.value | 99)) {
            return null;
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_push_consumers", _opsClass);
        if (_so == null) {
          continue;
        }
        final org.omg.CosNotifyChannelAdmin.SupplierAdminOperations _self = (org.omg.CosNotifyChannelAdmin.SupplierAdminOperations)_so.servant;
        try {
          int[] _ret = _self.push_consumers();
          if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
            ((org.omg.CORBA.portable.ServantObjectExt)_so).normalCompletion();
          }
          return _ret;

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
    }

  }

  /**
   * <pre>
   *   readonly attribute org.omg.CosNotifyChannelAdmin.ProxyIDSeq pull_consumers;
   * </pre>
   */
  public int[] pull_consumers () {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        int[] _result;
        try {
          _output = this._request("_get_pull_consumers", true);
          _input = this._invoke(_output);
          _result = org.omg.CosNotifyChannelAdmin.ProxyIDSeqHelper.read(_input);
          return _result;
        }
        catch (org.omg.CORBA.portable.ApplicationException _exception) {
          java.lang.String _exception_id = _exception.getId();
          throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: " + _exception_id);
        }
        catch (org.omg.CORBA.NO_RESPONSE _vis_nm ) {
          if(_vis_nm.minor == (org.omg.CORBA.OMGVMCID.value | 99)) {
            return null;
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_pull_consumers", _opsClass);
        if (_so == null) {
          continue;
        }
        final org.omg.CosNotifyChannelAdmin.SupplierAdminOperations _self = (org.omg.CosNotifyChannelAdmin.SupplierAdminOperations)_so.servant;
        try {
          int[] _ret = _self.pull_consumers();
          if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
            ((org.omg.CORBA.portable.ServantObjectExt)_so).normalCompletion();
          }
          return _ret;

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
    }

  }

  /**
   * <pre>
   *   readonly attribute org.omg.CosNotifyChannelAdmin.InterFilterGroupOperator MyOperator;
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.InterFilterGroupOperator MyOperator () {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        org.omg.CosNotifyChannelAdmin.InterFilterGroupOperator _result;
        try {
          _output = this._request("_get_MyOperator", true);
          _input = this._invoke(_output);
          _result = org.omg.CosNotifyChannelAdmin.InterFilterGroupOperatorHelper.read(_input);
          return _result;
        }
        catch (org.omg.CORBA.portable.ApplicationException _exception) {
          java.lang.String _exception_id = _exception.getId();
          throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: " + _exception_id);
        }
        catch (org.omg.CORBA.NO_RESPONSE _vis_nm ) {
          if(_vis_nm.minor == (org.omg.CORBA.OMGVMCID.value | 99)) {
            return null;
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_MyOperator", _opsClass);
        if (_so == null) {
          continue;
        }
        final org.omg.CosNotifyChannelAdmin.SupplierAdminOperations _self = (org.omg.CosNotifyChannelAdmin.SupplierAdminOperations)_so.servant;
        try {
          org.omg.CosNotifyChannelAdmin.InterFilterGroupOperator _ret = _self.MyOperator();
          if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
            ((org.omg.CORBA.portable.ServantObjectExt)_so).normalCompletion();
          }
          return _ret;

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
    }

  }

  /**
   * <pre>
   *   readonly attribute org.omg.CosNotifyChannelAdmin.EventChannel MyChannel;
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.EventChannel MyChannel () {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        org.omg.CosNotifyChannelAdmin.EventChannel _result;
        try {
          _output = this._request("_get_MyChannel", true);
          _input = this._invoke(_output);
          _result = org.omg.CosNotifyChannelAdmin.EventChannelHelper.read(_input);
          return _result;
        }
        catch (org.omg.CORBA.portable.ApplicationException _exception) {
          java.lang.String _exception_id = _exception.getId();
          throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: " + _exception_id);
        }
        catch (org.omg.CORBA.NO_RESPONSE _vis_nm ) {
          if(_vis_nm.minor == (org.omg.CORBA.OMGVMCID.value | 99)) {
            return null;
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_MyChannel", _opsClass);
        if (_so == null) {
          continue;
        }
        final org.omg.CosNotifyChannelAdmin.SupplierAdminOperations _self = (org.omg.CosNotifyChannelAdmin.SupplierAdminOperations)_so.servant;
        try {
          org.omg.CosNotifyChannelAdmin.EventChannel _ret = _self.MyChannel();
          if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
            ((org.omg.CORBA.portable.ServantObjectExt)_so).normalCompletion();
          }
          return _ret;

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
    }

  }

  /**
   * <pre>
   *   readonly attribute org.omg.CosNotifyChannelAdmin.AdminID MyID;
   * </pre>
   */
  public int MyID () {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        int _result;
        try {
          _output = this._request("_get_MyID", true);
          _input = this._invoke(_output);
          _result = _input.read_long();
          return _result;
        }
        catch (org.omg.CORBA.portable.ApplicationException _exception) {
          java.lang.String _exception_id = _exception.getId();
          throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: " + _exception_id);
        }
        catch (org.omg.CORBA.NO_RESPONSE _vis_nm ) {
          if(_vis_nm.minor == (org.omg.CORBA.OMGVMCID.value | 99)) {
            return 0;
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_MyID", _opsClass);
        if (_so == null) {
          continue;
        }
        final org.omg.CosNotifyChannelAdmin.SupplierAdminOperations _self = (org.omg.CosNotifyChannelAdmin.SupplierAdminOperations)_so.servant;
        try {
          int _ret = _self.MyID();
          if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
            ((org.omg.CORBA.portable.ServantObjectExt)_so).normalCompletion();
          }
          return _ret;

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
    }

  }

  public com.ericsson.irp.CosNotifyComm.NotifyPublish __com_ericsson_irp_CosNotifyComm_NotifyPublish;
  public com.ericsson.irp.CosNotifyFilter.FilterAdmin __com_ericsson_irp_CosNotifyFilter_FilterAdmin;
  public com.ericsson.irp.CosEventChannelAdmin.SupplierAdmin __com_ericsson_irp_CosEventChannelAdmin_SupplierAdmin;

  public void _set_delegate (org.omg.CORBA.portable.Delegate _vis_obj_delegate) {
    super._set_delegate(_vis_obj_delegate);
    this.__com_ericsson_irp_CosNotifyComm_NotifyPublish = new com.ericsson.irp.CosNotifyComm._NotifyPublishStub();
    ((org.omg.CORBA.portable.ObjectImpl) this.__com_ericsson_irp_CosNotifyComm_NotifyPublish)._set_delegate(_vis_obj_delegate);
    this.__com_ericsson_irp_CosNotifyFilter_FilterAdmin = new com.ericsson.irp.CosNotifyFilter._FilterAdminStub();
    ((org.omg.CORBA.portable.ObjectImpl) this.__com_ericsson_irp_CosNotifyFilter_FilterAdmin)._set_delegate(_vis_obj_delegate);
    this.__com_ericsson_irp_CosEventChannelAdmin_SupplierAdmin = new com.ericsson.irp.CosEventChannelAdmin._SupplierAdminStub();
    ((org.omg.CORBA.portable.ObjectImpl) this.__com_ericsson_irp_CosEventChannelAdmin_SupplierAdmin)._set_delegate(_vis_obj_delegate);
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

  /**
   * <pre>
   *   com.ericsson.irp.CosNotifyFilter.FilterID add_filter (in com.ericsson.irp.CosNotifyFilter.Filter new_filter);
   * </pre>
   */
  public int add_filter (com.ericsson.irp.CosNotifyFilter.Filter new_filter) {
    return this.__com_ericsson_irp_CosNotifyFilter_FilterAdmin.add_filter(new_filter);
  }

  /**
   * <pre>
   *   void remove_filter (in com.ericsson.irp.CosNotifyFilter.FilterID filter)
    raises (com.ericsson.irp.CosNotifyFilter.FilterNotFound);
   * </pre>
   */
  public void remove_filter (int filter) throws  com.ericsson.irp.CosNotifyFilter.FilterNotFound {
    this.__com_ericsson_irp_CosNotifyFilter_FilterAdmin.remove_filter(filter);
  }

  /**
   * <pre>
   *   com.ericsson.irp.CosNotifyFilter.Filter get_filter (in com.ericsson.irp.CosNotifyFilter.FilterID filter)
    raises (com.ericsson.irp.CosNotifyFilter.FilterNotFound);
   * </pre>
   */
  public com.ericsson.irp.CosNotifyFilter.Filter get_filter (int filter) throws  com.ericsson.irp.CosNotifyFilter.FilterNotFound {
    return this.__com_ericsson_irp_CosNotifyFilter_FilterAdmin.get_filter(filter);
  }

  /**
   * <pre>
   *   com.ericsson.irp.CosNotifyFilter.FilterIDSeq get_all_filters ();
   * </pre>
   */
  public int[] get_all_filters () {
    return this.__com_ericsson_irp_CosNotifyFilter_FilterAdmin.get_all_filters();
  }

  /**
   * <pre>
   *   void remove_all_filters ();
   * </pre>
   */
  public void remove_all_filters () {
    this.__com_ericsson_irp_CosNotifyFilter_FilterAdmin.remove_all_filters();
  }

  /**
   * <pre>
   *   com.ericsson.irp.CosEventChannelAdmin.ProxyPushConsumer obtain_push_consumer ();
   * </pre>
   */
  public com.ericsson.irp.CosEventChannelAdmin.ProxyPushConsumer obtain_push_consumer () {
    return this.__com_ericsson_irp_CosEventChannelAdmin_SupplierAdmin.obtain_push_consumer();
  }

  /**
   * <pre>
   *   com.ericsson.irp.CosEventChannelAdmin.ProxyPullConsumer obtain_pull_consumer ();
   * </pre>
   */
  public com.ericsson.irp.CosEventChannelAdmin.ProxyPullConsumer obtain_pull_consumer () {
    return this.__com_ericsson_irp_CosEventChannelAdmin_SupplierAdmin.obtain_pull_consumer();
  }

}
