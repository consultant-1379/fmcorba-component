package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::PropertySeq
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/PropertySeq:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * typedef sequence&ltorg.omg.CosNotification.Property&gt PropertySeq;
 * </pre>
 */
public final class PropertySeqHelper {
  private static org.omg.CORBA.TypeCode _type;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static org.omg.CosNotification.Property[] read (final org.omg.CORBA.portable.InputStream _input) {
    org.omg.CosNotification.Property[] result;
    final int $length0 = _input.read_long();
    if($length0 != 0) {
    result = new org.omg.CosNotification.Property[$length0];
    for (int $counter1 = 0; $counter1 < $length0; $counter1++) {
    result[$counter1] = org.omg.CosNotification.PropertyHelper.read(_input);
    }
    }
    else {
    result = org.omg.CosNotification.AdminPropertiesHelper.EMPTY_LIST;
    }
    return result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final org.omg.CosNotification.Property[] _vis_value) {
    if(_vis_value == null){
      throw new org.omg.CORBA.BAD_PARAM("Null parameter");
    }
    _output.write_long(_vis_value.length);
    for (int $counter2 = 0;  $counter2 < _vis_value.length; $counter2++) {
    if (_vis_value[$counter2] == null) {
      throw new org.omg.CORBA.BAD_PARAM("Invalid array length");
    }
    org.omg.CosNotification.PropertyHelper.write(_output, _vis_value[$counter2]);
    }
  }

  public static void insert (final org.omg.CORBA.Any any, final org.omg.CosNotification.Property[] _vis_value) {
    any.type(org.omg.CosNotification.PropertySeqHelper.type());
    any.insert_Streamable(new org.omg.CosNotification.PropertySeqHolder(_vis_value));
  }

  public static org.omg.CosNotification.Property[] extract (final org.omg.CORBA.Any any) {
    org.omg.CosNotification.Property[] _vis_value;
    _vis_value = org.omg.CosNotification.PropertySeqHelper.read(any.create_input_stream());
    return _vis_value;
  }

  public static org.omg.CORBA.TypeCode type () {
    if (_type == null) {
      synchronized (org.omg.CORBA.TypeCode.class) {
        if (_type == null) {
          org.omg.CORBA.TypeCode originalType = _orb().create_sequence_tc(0, org.omg.CosNotification.PropertyHelper.type());
          _type = _orb().create_alias_tc(id(), "PropertySeq", originalType);
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:omg.org/CosNotification/PropertySeq:1.0";
  }
  public final static org.omg.CosNotification.Property[] EMPTY_LIST = {};
}
