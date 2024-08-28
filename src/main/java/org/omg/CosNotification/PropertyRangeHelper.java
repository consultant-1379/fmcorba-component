package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::PropertyRange
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/PropertyRange:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct PropertyRange {
  ...
};
 * </pre>
 */
public final class PropertyRangeHelper {
  private static org.omg.CORBA.TypeCode _type;
  private static boolean _initializing;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static org.omg.CosNotification.PropertyRange read (final org.omg.CORBA.portable.InputStream _input) {
    final org.omg.CosNotification.PropertyRange _result = new org.omg.CosNotification.PropertyRange();
    _result.low_val = _input.read_any();
    _result.high_val = _input.read_any();
    return _result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final org.omg.CosNotification.PropertyRange _vis_value) {
    _output.write_any((org.omg.CORBA.Any)_vis_value.low_val);
    _output.write_any((org.omg.CORBA.Any)_vis_value.high_val);
  }

  public static void insert (final org.omg.CORBA.Any any, final org.omg.CosNotification.PropertyRange _vis_value) {
    any.insert_Streamable(new org.omg.CosNotification.PropertyRangeHolder(_vis_value));
  }

  public static org.omg.CosNotification.PropertyRange extract (final org.omg.CORBA.Any any) {
    org.omg.CosNotification.PropertyRange _vis_value;
    _vis_value = org.omg.CosNotification.PropertyRangeHelper.read(any.create_input_stream());
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
          members[0] = new org.omg.CORBA.StructMember("low_val", org.omg.CosNotification.PropertyValueHelper.type(), null);
          members[1] = new org.omg.CORBA.StructMember("high_val", org.omg.CosNotification.PropertyValueHelper.type(), null);
          _type = _orb().create_struct_tc(id(), "PropertyRange", members);
          _initializing = false;
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:omg.org/CosNotification/PropertyRange:1.0";
  }
}
