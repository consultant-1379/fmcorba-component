package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::PropertyErrorSeq
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/PropertyErrorSeq:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * typedef sequence&ltorg.omg.CosNotification.PropertyError&gt PropertyErrorSeq;
 * </pre>
 */
public final class PropertyErrorSeqHelper {
  private static org.omg.CORBA.TypeCode _type;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static org.omg.CosNotification.PropertyError[] read (final org.omg.CORBA.portable.InputStream _input) {
    org.omg.CosNotification.PropertyError[] result;
    final int $length9 = _input.read_long();
    if($length9 != 0) {
    result = new org.omg.CosNotification.PropertyError[$length9];
    for (int $counter10 = 0; $counter10 < $length9; $counter10++) {
    result[$counter10] = org.omg.CosNotification.PropertyErrorHelper.read(_input);
    }
    }
    else {
    result = org.omg.CosNotification.PropertyErrorSeqHelper.EMPTY_LIST;
    }
    return result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final org.omg.CosNotification.PropertyError[] _vis_value) {
    if(_vis_value == null){
      throw new org.omg.CORBA.BAD_PARAM("Null parameter");
    }
    _output.write_long(_vis_value.length);
    for (int $counter11 = 0;  $counter11 < _vis_value.length; $counter11++) {
    if (_vis_value[$counter11] == null) {
      throw new org.omg.CORBA.BAD_PARAM("Invalid array length");
    }
    org.omg.CosNotification.PropertyErrorHelper.write(_output, _vis_value[$counter11]);
    }
  }

  public static void insert (final org.omg.CORBA.Any any, final org.omg.CosNotification.PropertyError[] _vis_value) {
    any.type(org.omg.CosNotification.PropertyErrorSeqHelper.type());
    any.insert_Streamable(new org.omg.CosNotification.PropertyErrorSeqHolder(_vis_value));
  }

  public static org.omg.CosNotification.PropertyError[] extract (final org.omg.CORBA.Any any) {
    org.omg.CosNotification.PropertyError[] _vis_value;
    _vis_value = org.omg.CosNotification.PropertyErrorSeqHelper.read(any.create_input_stream());
    return _vis_value;
  }

  public static org.omg.CORBA.TypeCode type () {
    if (_type == null) {
      synchronized (org.omg.CORBA.TypeCode.class) {
        if (_type == null) {
          org.omg.CORBA.TypeCode originalType = _orb().create_sequence_tc(0, org.omg.CosNotification.PropertyErrorHelper.type());
          _type = _orb().create_alias_tc(id(), "PropertyErrorSeq", originalType);
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:omg.org/CosNotification/PropertyErrorSeq:1.0";
  }
  public final static org.omg.CosNotification.PropertyError[] EMPTY_LIST = {};
}
