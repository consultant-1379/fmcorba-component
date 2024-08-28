package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::StructuredEvent
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/StructuredEvent:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct StructuredEvent {
  ...
};
 * </pre>
 */
public final class StructuredEventHelper {
  private static org.omg.CORBA.TypeCode _type;
  private static boolean _initializing;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static org.omg.CosNotification.StructuredEvent read (final org.omg.CORBA.portable.InputStream _input) {
    final org.omg.CosNotification.StructuredEvent _result = new org.omg.CosNotification.StructuredEvent();
    _result.header = org.omg.CosNotification.EventHeaderHelper.read(_input);
    _result.filterable_data = org.omg.CosNotification.PropertySeqHelper.read(_input);
    _result.remainder_of_body = _input.read_any();
    return _result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final org.omg.CosNotification.StructuredEvent _vis_value) {
    if (_vis_value.header == null) {
      throw new org.omg.CORBA.BAD_PARAM("Invalid array length");
    }
    org.omg.CosNotification.EventHeaderHelper.write(_output, _vis_value.header);
    org.omg.CosNotification.PropertySeqHelper.write(_output, _vis_value.filterable_data);
    _output.write_any((org.omg.CORBA.Any)_vis_value.remainder_of_body);
  }

  public static void insert (final org.omg.CORBA.Any any, final org.omg.CosNotification.StructuredEvent _vis_value) {
    any.insert_Streamable(new org.omg.CosNotification.StructuredEventHolder(_vis_value));
  }

  public static org.omg.CosNotification.StructuredEvent extract (final org.omg.CORBA.Any any) {
    org.omg.CosNotification.StructuredEvent _vis_value;
    _vis_value = org.omg.CosNotification.StructuredEventHelper.read(any.create_input_stream());
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
          final org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[3];
          members[0] = new org.omg.CORBA.StructMember("header", org.omg.CosNotification.EventHeaderHelper.type(), null);
          members[1] = new org.omg.CORBA.StructMember("filterable_data", org.omg.CosNotification.FilterableEventBodyHelper.type(), null);
          members[2] = new org.omg.CORBA.StructMember("remainder_of_body", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_any), null);
          _type = _orb().create_struct_tc(id(), "StructuredEvent", members);
          _initializing = false;
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:omg.org/CosNotification/StructuredEvent:1.0";
  }
}
