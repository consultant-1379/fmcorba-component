package org.omg.TimeBase;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "TimeBase.idl"
 * <li> <b>IDL Name</b>      ::TimeBase::InaccuracyT
 * <li> <b>Repository Id</b> IDL:omg.org/TimeBase/InaccuracyT:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * typedef org.omg.TimeBase.TimeT InaccuracyT;
 * </pre>
 */
public final class InaccuracyTHelper {
  private static org.omg.CORBA.TypeCode _type;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static long read (final org.omg.CORBA.portable.InputStream _input) {
    long result;
    result = _input.read_ulonglong();
    return result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final long _vis_value) {
    _output.write_ulonglong((long)_vis_value);
  }

  public static void insert (final org.omg.CORBA.Any any, final long _vis_value) {
    any.type(org.omg.TimeBase.InaccuracyTHelper.type());
    any.type(org.omg.TimeBase.TimeTHelper.type());
    any.insert_ulonglong((long)_vis_value);
  }

  public static long extract (final org.omg.CORBA.Any any) {
    long _vis_value;
    _vis_value = any.extract_ulonglong();

    return _vis_value;
  }

  public static org.omg.CORBA.TypeCode type () {
    if (_type == null) {
      synchronized (org.omg.CORBA.TypeCode.class) {
        if (_type == null) {
          org.omg.CORBA.TypeCode originalType = org.omg.TimeBase.TimeTHelper.type();
          _type = _orb().create_alias_tc(id(), "InaccuracyT", originalType);
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:omg.org/TimeBase/InaccuracyT:1.0";
  }
}
