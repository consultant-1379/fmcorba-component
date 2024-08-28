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
public class _EventChannelStub extends org.omg.CosNotification._QoSAdminStub implements org.omg.CosNotifyChannelAdmin.EventChannel {
  /**
	 * 
	 */
	private static final long serialVersionUID = 8469602558097417095L;
final public static Class<EventChannelOperations> _opsClass = org.omg.CosNotifyChannelAdmin.EventChannelOperations.class;

  public java.lang.String[] _ids () {
    return __ids;
  }

  private static java.lang.String[] __ids = {
    "IDL:omg.org/CosNotifyChannelAdmin/EventChannel:1.0",
    "IDL:omg.org/CosNotification/QoSAdmin:1.0",
    "IDL:omg.org/CosNotification/AdminPropertiesAdmin:1.0",
    "IDL:omg.org/CosEventChannelAdmin/EventChannel:1.0"
  };

  /**
   * <pre>
   *   org.omg.CosNotifyChannelAdmin.AdminIDSeq get_all_supplieradmins ();
   * </pre>
   */
  public int[] get_all_supplieradmins () {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        int[] _result;
        try {
          _output = this._request("get_all_supplieradmins", true);
          _input = this._invoke(_output);
          _result = org.omg.CosNotifyChannelAdmin.AdminIDSeqHelper.read(_input);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("get_all_supplieradmins", _opsClass);
        if (_so == null) {
          continue;
        }
        final org.omg.CosNotifyChannelAdmin.EventChannelOperations _self = (org.omg.CosNotifyChannelAdmin.EventChannelOperations)_so.servant;
        try {
          int[] _ret = _self.get_all_supplieradmins();
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
   *   org.omg.CosNotifyChannelAdmin.AdminIDSeq get_all_consumeradmins ();
   * </pre>
   */
  public int[] get_all_consumeradmins () {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        int[] _result;
        try {
          _output = this._request("get_all_consumeradmins", true);
          _input = this._invoke(_output);
          _result = org.omg.CosNotifyChannelAdmin.AdminIDSeqHelper.read(_input);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("get_all_consumeradmins", _opsClass);
        if (_so == null) {
          continue;
        }
        final org.omg.CosNotifyChannelAdmin.EventChannelOperations _self = (org.omg.CosNotifyChannelAdmin.EventChannelOperations)_so.servant;
        try {
          int[] _ret = _self.get_all_consumeradmins();
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
   *   org.omg.CosNotifyChannelAdmin.SupplierAdmin get_supplieradmin (in org.omg.CosNotifyChannelAdmin.AdminID id)
    raises (org.omg.CosNotifyChannelAdmin.AdminNotFound);
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.SupplierAdmin get_supplieradmin (int id) throws  org.omg.CosNotifyChannelAdmin.AdminNotFound {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        org.omg.CosNotifyChannelAdmin.SupplierAdmin _result;
        try {
          _output = this._request("get_supplieradmin", true);
          _output.write_long((int)id);
          _input = this._invoke(_output);
          _result = org.omg.CosNotifyChannelAdmin.SupplierAdminHelper.read(_input);
          return _result;
        }
        catch (org.omg.CORBA.portable.ApplicationException _exception) {
          java.lang.String _exception_id = _exception.getId();
          if (_exception_id.equals(org.omg.CosNotifyChannelAdmin.AdminNotFoundHelper.id())) {
            throw             org.omg.CosNotifyChannelAdmin.AdminNotFoundHelper.read(_exception.getInputStream());
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("get_supplieradmin", _opsClass);
        if (_so == null) {
          continue;
        }
        final org.omg.CosNotifyChannelAdmin.EventChannelOperations _self = (org.omg.CosNotifyChannelAdmin.EventChannelOperations)_so.servant;
        try {
          org.omg.CosNotifyChannelAdmin.SupplierAdmin _ret = _self.get_supplieradmin(id);
          if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
            ((org.omg.CORBA.portable.ServantObjectExt)_so).normalCompletion();
          }
          return _ret;
        } catch (org.omg.CosNotifyChannelAdmin.AdminNotFound x_1) {
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
   *   org.omg.CosNotifyChannelAdmin.ConsumerAdmin get_consumeradmin (in org.omg.CosNotifyChannelAdmin.AdminID id)
    raises (org.omg.CosNotifyChannelAdmin.AdminNotFound);
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.ConsumerAdmin get_consumeradmin (int id) throws  org.omg.CosNotifyChannelAdmin.AdminNotFound {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        org.omg.CosNotifyChannelAdmin.ConsumerAdmin _result;
        try {
          _output = this._request("get_consumeradmin", true);
          _output.write_long((int)id);
          _input = this._invoke(_output);
          _result = org.omg.CosNotifyChannelAdmin.ConsumerAdminHelper.read(_input);
          return _result;
        }
        catch (org.omg.CORBA.portable.ApplicationException _exception) {
          java.lang.String _exception_id = _exception.getId();
          if (_exception_id.equals(org.omg.CosNotifyChannelAdmin.AdminNotFoundHelper.id())) {
            throw             org.omg.CosNotifyChannelAdmin.AdminNotFoundHelper.read(_exception.getInputStream());
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("get_consumeradmin", _opsClass);
        if (_so == null) {
          continue;
        }
        final org.omg.CosNotifyChannelAdmin.EventChannelOperations _self = (org.omg.CosNotifyChannelAdmin.EventChannelOperations)_so.servant;
        try {
          org.omg.CosNotifyChannelAdmin.ConsumerAdmin _ret = _self.get_consumeradmin(id);
          if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
            ((org.omg.CORBA.portable.ServantObjectExt)_so).normalCompletion();
          }
          return _ret;
        } catch (org.omg.CosNotifyChannelAdmin.AdminNotFound x_1) {
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
   *   org.omg.CosNotifyChannelAdmin.SupplierAdmin new_for_suppliers (in org.omg.CosNotifyChannelAdmin.InterFilterGroupOperator op,
                                                                 out org.omg.CosNotifyChannelAdmin.AdminID id);
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.SupplierAdmin new_for_suppliers (org.omg.CosNotifyChannelAdmin.InterFilterGroupOperator op, 
                                                                        org.omg.CORBA.IntHolder id) {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        org.omg.CosNotifyChannelAdmin.SupplierAdmin _result;
        try {
          _output = this._request("new_for_suppliers", true);
          org.omg.CosNotifyChannelAdmin.InterFilterGroupOperatorHelper.write(_output, op);
          _input = this._invoke(_output);
          _result = org.omg.CosNotifyChannelAdmin.SupplierAdminHelper.read(_input);
          id.value = _input.read_long();
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("new_for_suppliers", _opsClass);
        if (_so == null) {
          continue;
        }
        final org.omg.CosNotifyChannelAdmin.EventChannelOperations _self = (org.omg.CosNotifyChannelAdmin.EventChannelOperations)_so.servant;
        try {
          org.omg.CosNotifyChannelAdmin.SupplierAdmin _ret = _self.new_for_suppliers(op, 
                                                                                     id);
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
   *   org.omg.CosNotifyChannelAdmin.ConsumerAdmin new_for_consumers (in org.omg.CosNotifyChannelAdmin.InterFilterGroupOperator op,
                                                                 out org.omg.CosNotifyChannelAdmin.AdminID id);
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.ConsumerAdmin new_for_consumers (org.omg.CosNotifyChannelAdmin.InterFilterGroupOperator op, 
                                                                        org.omg.CORBA.IntHolder id) {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        org.omg.CosNotifyChannelAdmin.ConsumerAdmin _result;
        try {
          _output = this._request("new_for_consumers", true);
          org.omg.CosNotifyChannelAdmin.InterFilterGroupOperatorHelper.write(_output, op);
          _input = this._invoke(_output);
          _result = org.omg.CosNotifyChannelAdmin.ConsumerAdminHelper.read(_input);
          id.value = _input.read_long();
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("new_for_consumers", _opsClass);
        if (_so == null) {
          continue;
        }
        final org.omg.CosNotifyChannelAdmin.EventChannelOperations _self = (org.omg.CosNotifyChannelAdmin.EventChannelOperations)_so.servant;
        try {
          org.omg.CosNotifyChannelAdmin.ConsumerAdmin _ret = _self.new_for_consumers(op, 
                                                                                     id);
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
   *   readonly attribute com.ericsson.irp.CosNotifyFilter.FilterFactory default_filter_factory;
   * </pre>
   */
  public com.ericsson.irp.CosNotifyFilter.FilterFactory default_filter_factory () {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        com.ericsson.irp.CosNotifyFilter.FilterFactory _result;
        try {
          _output = this._request("_get_default_filter_factory", true);
          _input = this._invoke(_output);
          _result = com.ericsson.irp.CosNotifyFilter.FilterFactoryHelper.read(_input);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_default_filter_factory", _opsClass);
        if (_so == null) {
          continue;
        }
        final org.omg.CosNotifyChannelAdmin.EventChannelOperations _self = (org.omg.CosNotifyChannelAdmin.EventChannelOperations)_so.servant;
        try {
          com.ericsson.irp.CosNotifyFilter.FilterFactory _ret = _self.default_filter_factory();
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
   *   readonly attribute org.omg.CosNotifyChannelAdmin.SupplierAdmin default_supplier_admin;
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.SupplierAdmin default_supplier_admin () {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        org.omg.CosNotifyChannelAdmin.SupplierAdmin _result;
        try {
          _output = this._request("_get_default_supplier_admin", true);
          _input = this._invoke(_output);
          _result = org.omg.CosNotifyChannelAdmin.SupplierAdminHelper.read(_input);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_default_supplier_admin", _opsClass);
        if (_so == null) {
          continue;
        }
        final org.omg.CosNotifyChannelAdmin.EventChannelOperations _self = (org.omg.CosNotifyChannelAdmin.EventChannelOperations)_so.servant;
        try {
          org.omg.CosNotifyChannelAdmin.SupplierAdmin _ret = _self.default_supplier_admin();
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
   *   readonly attribute org.omg.CosNotifyChannelAdmin.ConsumerAdmin default_consumer_admin;
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.ConsumerAdmin default_consumer_admin () {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        org.omg.CosNotifyChannelAdmin.ConsumerAdmin _result;
        try {
          _output = this._request("_get_default_consumer_admin", true);
          _input = this._invoke(_output);
          _result = org.omg.CosNotifyChannelAdmin.ConsumerAdminHelper.read(_input);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_default_consumer_admin", _opsClass);
        if (_so == null) {
          continue;
        }
        final org.omg.CosNotifyChannelAdmin.EventChannelOperations _self = (org.omg.CosNotifyChannelAdmin.EventChannelOperations)_so.servant;
        try {
          org.omg.CosNotifyChannelAdmin.ConsumerAdmin _ret = _self.default_consumer_admin();
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
   *   readonly attribute org.omg.CosNotifyChannelAdmin.EventChannelFactory MyFactory;
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.EventChannelFactory MyFactory () {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        org.omg.CosNotifyChannelAdmin.EventChannelFactory _result;
        try {
          _output = this._request("_get_MyFactory", true);
          _input = this._invoke(_output);
          _result = org.omg.CosNotifyChannelAdmin.EventChannelFactoryHelper.read(_input);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_MyFactory", _opsClass);
        if (_so == null) {
          continue;
        }
        final org.omg.CosNotifyChannelAdmin.EventChannelOperations _self = (org.omg.CosNotifyChannelAdmin.EventChannelOperations)_so.servant;
        try {
          org.omg.CosNotifyChannelAdmin.EventChannelFactory _ret = _self.MyFactory();
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

  public org.omg.CosNotification.AdminPropertiesAdmin __org_omg_CosNotification_AdminPropertiesAdmin;
  public com.ericsson.irp.CosEventChannelAdmin.EventChannel __com_ericsson_irp_CosEventChannelAdmin_EventChannel;

  public void _set_delegate (org.omg.CORBA.portable.Delegate _vis_obj_delegate) {
    super._set_delegate(_vis_obj_delegate);
    this.__org_omg_CosNotification_AdminPropertiesAdmin = new org.omg.CosNotification._AdminPropertiesAdminStub();
    ((org.omg.CORBA.portable.ObjectImpl) this.__org_omg_CosNotification_AdminPropertiesAdmin)._set_delegate(_vis_obj_delegate);
    this.__com_ericsson_irp_CosEventChannelAdmin_EventChannel = new com.ericsson.irp.CosEventChannelAdmin._EventChannelStub();
    ((org.omg.CORBA.portable.ObjectImpl) this.__com_ericsson_irp_CosEventChannelAdmin_EventChannel)._set_delegate(_vis_obj_delegate);
  }

  /**
   * <pre>
   *   org.omg.CosNotification.AdminProperties get_admin ();
   * </pre>
   */
  public org.omg.CosNotification.Property[] get_admin () {
    return this.__org_omg_CosNotification_AdminPropertiesAdmin.get_admin();
  }

  /**
   * <pre>
   *   void set_admin (in org.omg.CosNotification.AdminProperties admin)
    raises (org.omg.CosNotification.UnsupportedAdmin);
   * </pre>
   */
  public void set_admin (org.omg.CosNotification.Property[] admin) throws  org.omg.CosNotification.UnsupportedAdmin {
    this.__org_omg_CosNotification_AdminPropertiesAdmin.set_admin(admin);
  }

  /**
   * <pre>
   *   com.ericsson.irp.CosEventChannelAdmin.ConsumerAdmin for_consumers ();
   * </pre>
   */
  public com.ericsson.irp.CosEventChannelAdmin.ConsumerAdmin for_consumers () {
    return this.__com_ericsson_irp_CosEventChannelAdmin_EventChannel.for_consumers();
  }

  /**
   * <pre>
   *   com.ericsson.irp.CosEventChannelAdmin.SupplierAdmin for_suppliers ();
   * </pre>
   */
  public com.ericsson.irp.CosEventChannelAdmin.SupplierAdmin for_suppliers () {
    return this.__com_ericsson_irp_CosEventChannelAdmin_EventChannel.for_suppliers();
  }

  /**
   * <pre>
   *   void destroy ();
   * </pre>
   */
  public void destroy () {
    this.__com_ericsson_irp_CosEventChannelAdmin_EventChannel.destroy();
  }

}
