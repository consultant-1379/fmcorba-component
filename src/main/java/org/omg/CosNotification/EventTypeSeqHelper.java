package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::EventTypeSeq
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/EventTypeSeq:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * typedef sequence&ltorg.omg.CosNotification.EventType&gt EventTypeSeq;
 * </pre>
 */
public final class EventTypeSeqHelper {
  private static org.omg.CORBA.TypeCode _type;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static org.omg.CosNotification.EventType[] read (final org.omg.CORBA.portable.InputStream _input) {
    org.omg.CosNotification.EventType[] result;
    final int $length3 = _input.read_long();
    if($length3 != 0) {
    result = new org.omg.CosNotification.EventType[$length3];
    for (int $counter4 = 0; $counter4 < $length3; $counter4++) {
    result[$counter4] = org.omg.CosNotification.EventTypeHelper.read(_input);
    }
    }
    else {
    result = org.omg.CosNotification.EventTypeSeqHelper.EMPTY_LIST;
    }
    return result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final org.omg.CosNotification.EventType[] _vis_value) {
    if(_vis_value == null){
      throw new org.omg.CORBA.BAD_PARAM("Null parameter");
    }
    _output.write_long(_vis_value.length);
    for (int $counter5 = 0;  $counter5 < _vis_value.length; $counter5++) {
    if (_vis_value[$counter5] == null) {
      throw new org.omg.CORBA.BAD_PARAM("Invalid array length");
    }
    org.omg.CosNotification.EventTypeHelper.write(_output, _vis_value[$counter5]);
    }
  }

  public static void insert (final org.omg.CORBA.Any any, final org.omg.CosNotification.EventType[] _vis_value) {
    any.type(org.omg.CosNotification.EventTypeSeqHelper.type());
    any.insert_Streamable(new org.omg.CosNotification.EventTypeSeqHolder(_vis_value));
  }

  public static org.omg.CosNotification.EventType[] extract (final org.omg.CORBA.Any any) {
    org.omg.CosNotification.EventType[] _vis_value;
    _vis_value = org.omg.CosNotification.EventTypeSeqHelper.read(any.create_input_stream());
    return _vis_value;
  }

  public static org.omg.CORBA.TypeCode type () {
    if (_type == null) {
      synchronized (org.omg.CORBA.TypeCode.class) {
        if (_type == null) {
          org.omg.CORBA.TypeCode originalType = _orb().create_sequence_tc(0, org.omg.CosNotification.EventTypeHelper.type());
          _type = _orb().create_alias_tc(id(), "EventTypeSeq", originalType);
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:omg.org/CosNotification/EventTypeSeq:1.0";
  }
  public final static org.omg.CosNotification.EventType[] EMPTY_LIST = {};
}
