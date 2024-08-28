package org.omg.TimeBase;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "TimeBase.idl"
 * <li> <b>IDL Name</b>      ::TimeBase::TdfT
 * <li> <b>Repository Id</b> IDL:omg.org/TimeBase/TdfT:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * typedef short TdfT;
 * </pre>
 */
public final class TdfTHelper {
  private static org.omg.CORBA.TypeCode _type;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static short read (final org.omg.CORBA.portable.InputStream _input) {
    short result;
    result = _input.read_short();
    return result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final short _vis_value) {
    _output.write_short((short)_vis_value);
  }

  public static void insert (final org.omg.CORBA.Any any, final short _vis_value) {
    any.type(org.omg.TimeBase.TdfTHelper.type());
    any.insert_short((short)_vis_value);
  }

  public static short extract (final org.omg.CORBA.Any any) {
    short _vis_value;
    _vis_value = any.extract_short();

    return _vis_value;
  }

  public static org.omg.CORBA.TypeCode type () {
    if (_type == null) {
      synchronized (org.omg.CORBA.TypeCode.class) {
        if (_type == null) {
          org.omg.CORBA.TypeCode originalType = _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_short);
          _type = _orb().create_alias_tc(id(), "TdfT", originalType);
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:omg.org/TimeBase/TdfT:1.0";
  }
}
