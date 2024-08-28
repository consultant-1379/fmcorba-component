package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::NamedPropertyRangeSeq
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/NamedPropertyRangeSeq:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * typedef sequence&ltorg.omg.CosNotification.NamedPropertyRange&gt NamedPropertyRangeSeq;
 * </pre>
 */
public final class NamedPropertyRangeSeqHelper {
  private static org.omg.CORBA.TypeCode _type;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static org.omg.CosNotification.NamedPropertyRange[] read (final org.omg.CORBA.portable.InputStream _input) {
    org.omg.CosNotification.NamedPropertyRange[] result;
    final int $length6 = _input.read_long();
    if($length6 != 0) {
    result = new org.omg.CosNotification.NamedPropertyRange[$length6];
    for (int $counter7 = 0; $counter7 < $length6; $counter7++) {
    result[$counter7] = org.omg.CosNotification.NamedPropertyRangeHelper.read(_input);
    }
    }
    else {
    result = org.omg.CosNotification.NamedPropertyRangeSeqHelper.EMPTY_LIST;
    }
    return result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final org.omg.CosNotification.NamedPropertyRange[] _vis_value) {
    if(_vis_value == null){
      throw new org.omg.CORBA.BAD_PARAM("Null parameter");
    }
    _output.write_long(_vis_value.length);
    for (int $counter8 = 0;  $counter8 < _vis_value.length; $counter8++) {
    if (_vis_value[$counter8] == null) {
      throw new org.omg.CORBA.BAD_PARAM("Invalid array length");
    }
    org.omg.CosNotification.NamedPropertyRangeHelper.write(_output, _vis_value[$counter8]);
    }
  }

  public static void insert (final org.omg.CORBA.Any any, final org.omg.CosNotification.NamedPropertyRange[] _vis_value) {
    any.type(org.omg.CosNotification.NamedPropertyRangeSeqHelper.type());
    any.insert_Streamable(new org.omg.CosNotification.NamedPropertyRangeSeqHolder(_vis_value));
  }

  public static org.omg.CosNotification.NamedPropertyRange[] extract (final org.omg.CORBA.Any any) {
    org.omg.CosNotification.NamedPropertyRange[] _vis_value;
    _vis_value = org.omg.CosNotification.NamedPropertyRangeSeqHelper.read(any.create_input_stream());
    return _vis_value;
  }

  public static org.omg.CORBA.TypeCode type () {
    if (_type == null) {
      synchronized (org.omg.CORBA.TypeCode.class) {
        if (_type == null) {
          org.omg.CORBA.TypeCode originalType = _orb().create_sequence_tc(0, org.omg.CosNotification.NamedPropertyRangeHelper.type());
          _type = _orb().create_alias_tc(id(), "NamedPropertyRangeSeq", originalType);
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:omg.org/CosNotification/NamedPropertyRangeSeq:1.0";
  }
  public final static org.omg.CosNotification.NamedPropertyRange[] EMPTY_LIST = {};
}
