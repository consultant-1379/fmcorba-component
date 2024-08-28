package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::EventHeader
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/EventHeader:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct EventHeader {
  ...
};
 * </pre>
 */
public final class EventHeaderHelper {
  private static org.omg.CORBA.TypeCode _type;
  private static boolean _initializing;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static org.omg.CosNotification.EventHeader read (final org.omg.CORBA.portable.InputStream _input) {
    final org.omg.CosNotification.EventHeader _result = new org.omg.CosNotification.EventHeader();
    _result.fixed_header = org.omg.CosNotification.FixedEventHeaderHelper.read(_input);
    _result.variable_header = org.omg.CosNotification.PropertySeqHelper.read(_input);
    return _result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final org.omg.CosNotification.EventHeader _vis_value) {
    if (_vis_value.fixed_header == null) {
      throw new org.omg.CORBA.BAD_PARAM("Invalid array length");
    }
    org.omg.CosNotification.FixedEventHeaderHelper.write(_output, _vis_value.fixed_header);
    org.omg.CosNotification.PropertySeqHelper.write(_output, _vis_value.variable_header);
  }

  public static void insert (final org.omg.CORBA.Any any, final org.omg.CosNotification.EventHeader _vis_value) {
    any.insert_Streamable(new org.omg.CosNotification.EventHeaderHolder(_vis_value));
  }

  public static org.omg.CosNotification.EventHeader extract (final org.omg.CORBA.Any any) {
    org.omg.CosNotification.EventHeader _vis_value;
    _vis_value = org.omg.CosNotification.EventHeaderHelper.read(any.create_input_stream());
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
          members[0] = new org.omg.CORBA.StructMember("fixed_header", org.omg.CosNotification.FixedEventHeaderHelper.type(), null);
          members[1] = new org.omg.CORBA.StructMember("variable_header", org.omg.CosNotification.OptionalHeaderFieldsHelper.type(), null);
          _type = _orb().create_struct_tc(id(), "EventHeader", members);
          _initializing = false;
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:omg.org/CosNotification/EventHeader:1.0";
  }
}
