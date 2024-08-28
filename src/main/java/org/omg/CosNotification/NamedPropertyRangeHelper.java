package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::NamedPropertyRange
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/NamedPropertyRange:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct NamedPropertyRange {
  ...
};
 * </pre>
 */
public final class NamedPropertyRangeHelper {
  private static org.omg.CORBA.TypeCode _type;
  private static boolean _initializing;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static org.omg.CosNotification.NamedPropertyRange read (final org.omg.CORBA.portable.InputStream _input) {
    final org.omg.CosNotification.NamedPropertyRange _result = new org.omg.CosNotification.NamedPropertyRange();
    _result.name = _input.read_string();
    _result.range = org.omg.CosNotification.PropertyRangeHelper.read(_input);
    return _result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final org.omg.CosNotification.NamedPropertyRange _vis_value) {
    _output.write_string((java.lang.String)_vis_value.name);
    if (_vis_value.range == null) {
      throw new org.omg.CORBA.BAD_PARAM("Invalid array length");
    }
    org.omg.CosNotification.PropertyRangeHelper.write(_output, _vis_value.range);
  }

  public static void insert (final org.omg.CORBA.Any any, final org.omg.CosNotification.NamedPropertyRange _vis_value) {
    any.insert_Streamable(new org.omg.CosNotification.NamedPropertyRangeHolder(_vis_value));
  }

  public static org.omg.CosNotification.NamedPropertyRange extract (final org.omg.CORBA.Any any) {
    org.omg.CosNotification.NamedPropertyRange _vis_value;
    _vis_value = org.omg.CosNotification.NamedPropertyRangeHelper.read(any.create_input_stream());
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
          members[0] = new org.omg.CORBA.StructMember("name", org.omg.CosNotification.PropertyNameHelper.type(), null);
          members[1] = new org.omg.CORBA.StructMember("range", org.omg.CosNotification.PropertyRangeHelper.type(), null);
          _type = _orb().create_struct_tc(id(), "NamedPropertyRange", members);
          _initializing = false;
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:omg.org/CosNotification/NamedPropertyRange:1.0";
  }
}
