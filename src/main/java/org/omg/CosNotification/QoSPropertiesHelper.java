package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::QoSProperties
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/QoSProperties:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * typedef org.omg.CosNotification.PropertySeq QoSProperties;
 * </pre>
 */
public final class QoSPropertiesHelper {
  private static org.omg.CORBA.TypeCode _type;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static org.omg.CosNotification.Property[] read (final org.omg.CORBA.portable.InputStream _input) {
    org.omg.CosNotification.Property[] result;
    result = org.omg.CosNotification.PropertySeqHelper.read(_input);
    return result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final org.omg.CosNotification.Property[] _vis_value) {
    org.omg.CosNotification.PropertySeqHelper.write(_output, _vis_value);
  }

  public static void insert (final org.omg.CORBA.Any any, final org.omg.CosNotification.Property[] _vis_value) {
    any.type(org.omg.CosNotification.QoSPropertiesHelper.type());
    any.type(org.omg.CosNotification.PropertySeqHelper.type());
    any.insert_Streamable(new org.omg.CosNotification.PropertySeqHolder(_vis_value));
  }

  public static org.omg.CosNotification.Property[] extract (final org.omg.CORBA.Any any) {
    org.omg.CosNotification.Property[] _vis_value;
    _vis_value = org.omg.CosNotification.PropertySeqHelper.read(any.create_input_stream());
    return _vis_value;
  }

  public static org.omg.CORBA.TypeCode type () {
    if (_type == null) {
      synchronized (org.omg.CORBA.TypeCode.class) {
        if (_type == null) {
          org.omg.CORBA.TypeCode originalType = org.omg.CosNotification.PropertySeqHelper.type();
          _type = _orb().create_alias_tc(id(), "QoSProperties", originalType);
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:omg.org/CosNotification/QoSProperties:1.0";
  }
  public final static org.omg.CosNotification.Property[] EMPTY_LIST = {};
}
