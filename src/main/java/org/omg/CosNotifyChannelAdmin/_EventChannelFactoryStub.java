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
public class _EventChannelFactoryStub extends org.omg.CORBA.portable.ObjectImpl implements org.omg.CosNotifyChannelAdmin.EventChannelFactory {
  /**
	 * 
	 */
	private static final long serialVersionUID = -8330727369492086814L;
final public static Class<EventChannelFactoryOperations> _opsClass = org.omg.CosNotifyChannelAdmin.EventChannelFactoryOperations.class;

  public java.lang.String[] _ids () {
    return __ids;
  }

  private static java.lang.String[] __ids = {
    "IDL:omg.org/CosNotifyChannelAdmin/EventChannelFactory:1.0"
  };

  /**
   * <pre>
   *   org.omg.CosNotifyChannelAdmin.EventChannel get_event_channel (in org.omg.CosNotifyChannelAdmin.ChannelID id)
    raises (org.omg.CosNotifyChannelAdmin.ChannelNotFound);
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.EventChannel get_event_channel (int id) throws  org.omg.CosNotifyChannelAdmin.ChannelNotFound {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        org.omg.CosNotifyChannelAdmin.EventChannel _result;
        try {
          _output = this._request("get_event_channel", true);
          _output.write_long((int)id);
          _input = this._invoke(_output);
          _result = org.omg.CosNotifyChannelAdmin.EventChannelHelper.read(_input);
          return _result;
        }
        catch (org.omg.CORBA.portable.ApplicationException _exception) {
          java.lang.String _exception_id = _exception.getId();
          if (_exception_id.equals(org.omg.CosNotifyChannelAdmin.ChannelNotFoundHelper.id())) {
            throw             org.omg.CosNotifyChannelAdmin.ChannelNotFoundHelper.read(_exception.getInputStream());
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("get_event_channel", _opsClass);
        if (_so == null) {
          continue;
        }
        final org.omg.CosNotifyChannelAdmin.EventChannelFactoryOperations _self = (org.omg.CosNotifyChannelAdmin.EventChannelFactoryOperations)_so.servant;
        try {
          org.omg.CosNotifyChannelAdmin.EventChannel _ret = _self.get_event_channel(id);
          if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
            ((org.omg.CORBA.portable.ServantObjectExt)_so).normalCompletion();
          }
          return _ret;
        } catch (org.omg.CosNotifyChannelAdmin.ChannelNotFound x_1) {
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
   *   org.omg.CosNotifyChannelAdmin.ChannelIDSeq get_all_channels ();
   * </pre>
   */
  public int[] get_all_channels () {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        int[] _result;
        try {
          _output = this._request("get_all_channels", true);
          _input = this._invoke(_output);
          _result = org.omg.CosNotifyChannelAdmin.ChannelIDSeqHelper.read(_input);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("get_all_channels", _opsClass);
        if (_so == null) {
          continue;
        }
        final org.omg.CosNotifyChannelAdmin.EventChannelFactoryOperations _self = (org.omg.CosNotifyChannelAdmin.EventChannelFactoryOperations)_so.servant;
        try {
          int[] _ret = _self.get_all_channels();
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
   *   org.omg.CosNotifyChannelAdmin.EventChannel create_channel (in org.omg.CosNotification.QoSProperties initial_qos,
                                                             in org.omg.CosNotification.AdminProperties initial_admin,
                                                             out org.omg.CosNotifyChannelAdmin.ChannelID id)
    raises (org.omg.CosNotification.UnsupportedQoS,
            org.omg.CosNotification.UnsupportedAdmin);
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.EventChannel create_channel (org.omg.CosNotification.Property[] initial_qos, 
                                                                    org.omg.CosNotification.Property[] initial_admin, 
                                                                    org.omg.CORBA.IntHolder id) throws  org.omg.CosNotification.UnsupportedQoS, 
                                                                                                        org.omg.CosNotification.UnsupportedAdmin {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        org.omg.CosNotifyChannelAdmin.EventChannel _result;
        try {
          _output = this._request("create_channel", true);
          org.omg.CosNotification.PropertySeqHelper.write(_output, initial_qos);
          org.omg.CosNotification.PropertySeqHelper.write(_output, initial_admin);
          _input = this._invoke(_output);
          _result = org.omg.CosNotifyChannelAdmin.EventChannelHelper.read(_input);
          id.value = _input.read_long();
          return _result;
        }
        catch (org.omg.CORBA.portable.ApplicationException _exception) {
          java.lang.String _exception_id = _exception.getId();
          if (_exception_id.equals(org.omg.CosNotification.UnsupportedQoSHelper.id())) {
            throw             org.omg.CosNotification.UnsupportedQoSHelper.read(_exception.getInputStream());
          }
          if (_exception_id.equals(org.omg.CosNotification.UnsupportedAdminHelper.id())) {
            throw             org.omg.CosNotification.UnsupportedAdminHelper.read(_exception.getInputStream());
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("create_channel", _opsClass);
        if (_so == null) {
          continue;
        }
        final org.omg.CosNotifyChannelAdmin.EventChannelFactoryOperations _self = (org.omg.CosNotifyChannelAdmin.EventChannelFactoryOperations)_so.servant;
        try {
          org.omg.CosNotifyChannelAdmin.EventChannel _ret = _self.create_channel(initial_qos, 
                                                                                 initial_admin, 
                                                                                 id);
          if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
            ((org.omg.CORBA.portable.ServantObjectExt)_so).normalCompletion();
          }
          return _ret;
        } catch (org.omg.CosNotification.UnsupportedQoS x_1) {
          if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
            ((org.omg.CORBA.portable.ServantObjectExt)_so).exceptionalCompletion((Throwable)x_1);
          }
          throw x_1;
        } catch (org.omg.CosNotification.UnsupportedAdmin x_2) {
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
    }

  }

}
