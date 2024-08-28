package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::UnsupportedQoS
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/UnsupportedQoS:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * exception UnsupportedQoS {
  ...
};
 * </pre>
 */
public final class UnsupportedQoSHelper {
  private static org.omg.CORBA.TypeCode _type;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static org.omg.CosNotification.UnsupportedQoS read (final org.omg.CORBA.portable.InputStream _input) {
    if (!_input.read_string().equals(id())) {
      throw new org.omg.CORBA.MARSHAL("Mismatched repository id");
    }
    final org.omg.CosNotification.UnsupportedQoS _result = new org.omg.CosNotification.UnsupportedQoS();
    _result.qos_err = org.omg.CosNotification.PropertyErrorSeqHelper.read(_input);
    return _result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final org.omg.CosNotification.UnsupportedQoS _vis_value) {
    _output.write_string(id());
    org.omg.CosNotification.PropertyErrorSeqHelper.write(_output, _vis_value.qos_err);
  }

  public static void insert (final org.omg.CORBA.Any any, final org.omg.CosNotification.UnsupportedQoS _vis_value) {
    any.insert_Streamable(new org.omg.CosNotification.UnsupportedQoSHolder(_vis_value));
  }

  public static org.omg.CosNotification.UnsupportedQoS extract (final org.omg.CORBA.Any any) {
    org.omg.CosNotification.UnsupportedQoS _vis_value;
    _vis_value = org.omg.CosNotification.UnsupportedQoSHelper.read(any.create_input_stream());
    return _vis_value;
  }

  public static org.omg.CORBA.TypeCode type () {
    if (_type == null) {
      synchronized (org.omg.CORBA.TypeCode.class) {
        if (_type == null) {
          final org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[1];
          members[0] = new org.omg.CORBA.StructMember("qos_err", org.omg.CosNotification.PropertyErrorSeqHelper.type(), null);
          _type = _orb().create_exception_tc(id(), "UnsupportedQoS", members);
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:omg.org/CosNotification/UnsupportedQoS:1.0";
  }
}
