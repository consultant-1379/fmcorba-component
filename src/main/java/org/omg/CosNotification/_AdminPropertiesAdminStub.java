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
public class _AdminPropertiesAdminStub extends org.omg.CORBA.portable.ObjectImpl implements org.omg.CosNotification.AdminPropertiesAdmin {
  /**
	 * 
	 */
	private static final long serialVersionUID = 8298602166607642486L;
final public static Class<AdminPropertiesAdminOperations> _opsClass = org.omg.CosNotification.AdminPropertiesAdminOperations.class;

  public java.lang.String[] _ids () {
    return __ids;
  }

  private static java.lang.String[] __ids = {
    "IDL:omg.org/CosNotification/AdminPropertiesAdmin:1.0"
  };

  /**
   * <pre>
   *   void set_admin (in org.omg.CosNotification.AdminProperties admin)
    raises (org.omg.CosNotification.UnsupportedAdmin);
   * </pre>
   */
  public void set_admin (org.omg.CosNotification.Property[] admin) throws  org.omg.CosNotification.UnsupportedAdmin {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        try {
          _output = this._request("set_admin", true);
          org.omg.CosNotification.PropertySeqHelper.write(_output, admin);
          _input = this._invoke(_output);
        }
        catch (org.omg.CORBA.portable.ApplicationException _exception) {
          java.lang.String _exception_id = _exception.getId();
          if (_exception_id.equals(org.omg.CosNotification.UnsupportedAdminHelper.id())) {
            throw             org.omg.CosNotification.UnsupportedAdminHelper.read(_exception.getInputStream());
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("set_admin", _opsClass);
        if (_so == null) {
          continue;
        }
        final org.omg.CosNotification.AdminPropertiesAdminOperations _self = (org.omg.CosNotification.AdminPropertiesAdminOperations)_so.servant;
        try {
          _self.set_admin(admin);
          if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
            ((org.omg.CORBA.portable.ServantObjectExt)_so).normalCompletion();
          }
        } catch (org.omg.CosNotification.UnsupportedAdmin x_1) {
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

  /**
   * <pre>
   *   org.omg.CosNotification.AdminProperties get_admin ();
   * </pre>
   */
  public org.omg.CosNotification.Property[] get_admin () {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        org.omg.CosNotification.Property[] _result;
        try {
          _output = this._request("get_admin", true);
          _input = this._invoke(_output);
          _result = org.omg.CosNotification.PropertySeqHelper.read(_input);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("get_admin", _opsClass);
        if (_so == null) {
          continue;
        }
        final org.omg.CosNotification.AdminPropertiesAdminOperations _self = (org.omg.CosNotification.AdminPropertiesAdminOperations)_so.servant;
        try {
          org.omg.CosNotification.Property[] _ret = _self.get_admin();
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

}
