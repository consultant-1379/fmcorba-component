package org.omg.TimeBase;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "TimeBase.idl"
 * <li> <b>IDL Name</b>      ::TimeBase::UtcT
 * <li> <b>Repository Id</b> IDL:omg.org/TimeBase/UtcT:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct UtcT {
  ...
};
 * </pre>
 */
public final class UtcTHelper {
  private static org.omg.CORBA.TypeCode _type;
  private static boolean _initializing;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static org.omg.TimeBase.UtcT read (final org.omg.CORBA.portable.InputStream _input) {
    final org.omg.TimeBase.UtcT _result = new org.omg.TimeBase.UtcT();
    _result.time = _input.read_ulonglong();
    _result.inacclo = _input.read_ulong();
    _result.inacchi = _input.read_ushort();
    _result.tdf = _input.read_short();
    return _result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final org.omg.TimeBase.UtcT _vis_value) {
    _output.write_ulonglong((long)_vis_value.time);
    _output.write_ulong((int)_vis_value.inacclo);
    _output.write_ushort((short)_vis_value.inacchi);
    _output.write_short((short)_vis_value.tdf);
  }

  public static void insert (final org.omg.CORBA.Any any, final org.omg.TimeBase.UtcT _vis_value) {
    any.insert_Streamable(new org.omg.TimeBase.UtcTHolder(_vis_value));
  }

  public static org.omg.TimeBase.UtcT extract (final org.omg.CORBA.Any any) {
    org.omg.TimeBase.UtcT _vis_value;
    _vis_value = org.omg.TimeBase.UtcTHelper.read(any.create_input_stream());
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
          final org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[4];
          members[0] = new org.omg.CORBA.StructMember("time", org.omg.TimeBase.TimeTHelper.type(), null);
          members[1] = new org.omg.CORBA.StructMember("inacclo", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_ulong), null);
          members[2] = new org.omg.CORBA.StructMember("inacchi", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_ushort), null);
          members[3] = new org.omg.CORBA.StructMember("tdf", org.omg.TimeBase.TdfTHelper.type(), null);
          _type = _orb().create_struct_tc(id(), "UtcT", members);
          _initializing = false;
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:omg.org/TimeBase/UtcT:1.0";
  }
}
