package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::FixedEventHeader
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/FixedEventHeader:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct FixedEventHeader {
  ...
};
 * </pre>
 */
public final class FixedEventHeaderHelper {
  private static org.omg.CORBA.TypeCode _type;
  private static boolean _initializing;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static org.omg.CosNotification.FixedEventHeader read (final org.omg.CORBA.portable.InputStream _input) {
    final org.omg.CosNotification.FixedEventHeader _result = new org.omg.CosNotification.FixedEventHeader();
    _result.event_type = org.omg.CosNotification.EventTypeHelper.read(_input);
    _result.event_name = _input.read_string();
    return _result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final org.omg.CosNotification.FixedEventHeader _vis_value) {
    if (_vis_value.event_type == null) {
      throw new org.omg.CORBA.BAD_PARAM("Invalid array length");
    }
    org.omg.CosNotification.EventTypeHelper.write(_output, _vis_value.event_type);
    _output.write_string((java.lang.String)_vis_value.event_name);
  }

  public static void insert (final org.omg.CORBA.Any any, final org.omg.CosNotification.FixedEventHeader _vis_value) {
    any.insert_Streamable(new org.omg.CosNotification.FixedEventHeaderHolder(_vis_value));
  }

  public static org.omg.CosNotification.FixedEventHeader extract (final org.omg.CORBA.Any any) {
    org.omg.CosNotification.FixedEventHeader _vis_value;
    _vis_value = org.omg.CosNotification.FixedEventHeaderHelper.read(any.create_input_stream());
    return _vis_value;
  }

  public static org.omg.CORBA.TypeCode type () {
    if (_type == null) {
      synchronized (org.omg.CORBA.TypeCode.class) {
        if (_type == null) {
          if (_initializing) {
            return _orb().create_recursive_tc(id());
          }
          _initializing = true;
          final org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[2];
          members[0] = new org.omg.CORBA.StructMember("event_type", org.omg.CosNotification.EventTypeHelper.type(), null);
          members[1] = new org.omg.CORBA.StructMember("event_name", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          _type = _orb().create_struct_tc(id(), "FixedEventHeader", members);
          _initializing = false;
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:omg.org/CosNotification/FixedEventHeader:1.0";
  }
}
