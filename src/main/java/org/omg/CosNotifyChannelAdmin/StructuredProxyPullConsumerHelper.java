
package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::StructuredProxyPullConsumer
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/StructuredProxyPullConsumer:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface StructuredProxyPullConsumer : org.omg.CosNotifyChannelAdmin.ProxyConsumer,
                                        com.ericsson.irp.CosNotifyComm.StructuredPullConsumer {
  ...
};
 * </pre>
 */
public final class StructuredProxyPullConsumerHelper {
  public static org.omg.CosNotifyChannelAdmin.StructuredProxyPullConsumer narrow (final org.omg.CORBA.Object obj) {
    return narrow(obj, false);
  }

  public static org.omg.CosNotifyChannelAdmin.StructuredProxyPullConsumer unchecked_narrow (org.omg.CORBA.Object obj) {
    return narrow(obj, true);
  }

  private static org.omg.CosNotifyChannelAdmin.StructuredProxyPullConsumer narrow (final org.omg.CORBA.Object obj, final boolean is_a) {
    if (obj == null) {
      return null;
    }
    if (obj instanceof org.omg.CosNotifyChannelAdmin.StructuredProxyPullConsumer) {
      return (org.omg.CosNotifyChannelAdmin.StructuredProxyPullConsumer)obj;
    }
    if (is_a || obj._is_a(id())) {
      final org.omg.CORBA.portable.ObjectImpl _obj = (org.omg.CORBA.portable.ObjectImpl)obj;
      org.omg.CosNotifyChannelAdmin._StructuredProxyPullConsumerStub result = new org.omg.CosNotifyChannelAdmin._StructuredProxyPullConsumerStub();
      final org.omg.CORBA.portable.Delegate _delegate = _obj._get_delegate();
      result._set_delegate(_delegate);
      return result;
    }
    throw new org.omg.CORBA.BAD_PARAM();
  }

  public java.lang.Object read_Object (final org.omg.CORBA.portable.InputStream istream) {
    return read(istream);
  }

  public void write_Object (final org.omg.CORBA.portable.OutputStream ostream, final java.lang.Object obj) {
    if (!(obj instanceof org.omg.CosNotifyChannelAdmin.StructuredProxyPullConsumer)) {
      throw new org.omg.CORBA.BAD_PARAM();
    }
    write(ostream, (org.omg.CosNotifyChannelAdmin.StructuredProxyPullConsumer)obj);
  }

  public java.lang.String get_id () {
    return id();
  }

  public org.omg.CORBA.TypeCode get_type () {
    return type();
  }

  private static org.omg.CORBA.TypeCode _type;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static org.omg.CosNotifyChannelAdmin.StructuredProxyPullConsumer read (final org.omg.CORBA.portable.InputStream _input) {
    return narrow(_input.read_Object(org.omg.CosNotifyChannelAdmin._StructuredProxyPullConsumerStub.class), true);
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final org.omg.CosNotifyChannelAdmin.StructuredProxyPullConsumer _vis_value) {
    if (_vis_value != null && !(_vis_value instanceof org.omg.CORBA.portable.ObjectImpl)) {
      throw new org.omg.CORBA.BAD_PARAM();
    }
    _output.write_Object((org.omg.CORBA.Object)_vis_value);
  }

  public static void insert (final org.omg.CORBA.Any any, final org.omg.CosNotifyChannelAdmin.StructuredProxyPullConsumer _vis_value) {
    any.insert_Object((org.omg.CORBA.Object)_vis_value, org.omg.CosNotifyChannelAdmin.StructuredProxyPullConsumerHelper.type());
  }

  public static org.omg.CosNotifyChannelAdmin.StructuredProxyPullConsumer extract (final org.omg.CORBA.Any any) {
    org.omg.CosNotifyChannelAdmin.StructuredProxyPullConsumer _vis_value;
    final org.omg.CORBA.Object _obj = any.extract_Object();
    _vis_value = org.omg.CosNotifyChannelAdmin.StructuredProxyPullConsumerHelper.narrow(_obj);
    return _vis_value;
  }

  public static org.omg.CORBA.TypeCode type () {
    if (_type == null) {
      synchronized (org.omg.CORBA.TypeCode.class) {
        if (_type == null) {
          _type = _orb().create_interface_tc(id(), "StructuredProxyPullConsumer");
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:omg.org/CosNotifyChannelAdmin/StructuredProxyPullConsumer:1.0";
  }
}
