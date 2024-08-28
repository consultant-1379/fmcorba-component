package org.omg.TimeBase;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "TimeBase.idl"
 * <li> <b>IDL Name</b>      ::TimeBase::IntervalT
 * <li> <b>Repository Id</b> IDL:omg.org/TimeBase/IntervalT:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct IntervalT {
  ...
};
 * </pre>
 */
public final class IntervalTHelper {
  private static org.omg.CORBA.TypeCode _type;
  private static boolean _initializing;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static org.omg.TimeBase.IntervalT read (final org.omg.CORBA.portable.InputStream _input) {
    final org.omg.TimeBase.IntervalT _result = new org.omg.TimeBase.IntervalT();
    _result.lower_bound = _input.read_ulonglong();
    _result.upper_bound = _input.read_ulonglong();
    return _result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final org.omg.TimeBase.IntervalT _vis_value) {
    _output.write_ulonglong((long)_vis_value.lower_bound);
    _output.write_ulonglong((long)_vis_value.upper_bound);
  }

  public static void insert (final org.omg.CORBA.Any any, final org.omg.TimeBase.IntervalT _vis_value) {
    any.insert_Streamable(new org.omg.TimeBase.IntervalTHolder(_vis_value));
  }

  public static org.omg.TimeBase.IntervalT extract (final org.omg.CORBA.Any any) {
    org.omg.TimeBase.IntervalT _vis_value;
    _vis_value = org.omg.TimeBase.IntervalTHelper.read(any.create_input_stream());
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
          members[0] = new org.omg.CORBA.StructMember("lower_bound", org.omg.TimeBase.TimeTHelper.type(), null);
          members[1] = new org.omg.CORBA.StructMember("upper_bound", org.omg.TimeBase.TimeTHelper.type(), null);
          _type = _orb().create_struct_tc(id(), "IntervalT", members);
          _initializing = false;
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:omg.org/TimeBase/IntervalT:1.0";
  }
}
