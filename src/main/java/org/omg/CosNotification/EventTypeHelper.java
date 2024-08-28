package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::EventType
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/EventType:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct EventType {
  ...
};
 * </pre>
 */
public final class EventTypeHelper {
  private static org.omg.CORBA.TypeCode _type;
  private static boolean _initializing;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static org.omg.CosNotification.EventType read (final org.omg.CORBA.portable.InputStream _input) {
    final org.omg.CosNotification.EventType _result = new org.omg.CosNotification.EventType();
    _result.domain_name = _input.read_string();
    _result.type_name = _input.read_string();
    return _result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final org.omg.CosNotification.EventType _vis_value) {
    _output.write_string((java.lang.String)_vis_value.domain_name);
    _output.write_string((java.lang.String)_vis_value.type_name);
  }

  public static void insert (final org.omg.CORBA.Any any, final org.omg.CosNotification.EventType _vis_value) {
    any.insert_Streamable(new org.omg.CosNotification.EventTypeHolder(_vis_value));
  }

  public static org.omg.CosNotification.EventType extract (final org.omg.CORBA.Any any) {
    org.omg.CosNotification.EventType _vis_value;
    _vis_value = org.omg.CosNotification.EventTypeHelper.read(any.create_input_stream());
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
          members[0] = new org.omg.CORBA.StructMember("domain_name", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[1] = new org.omg.CORBA.StructMember("type_name", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          _type = _orb().create_struct_tc(id(), "EventType", members);
          _initializing = false;
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:omg.org/CosNotification/EventType:1.0";
  }
}
