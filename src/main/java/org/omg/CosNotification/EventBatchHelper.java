package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::EventBatch
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/EventBatch:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * typedef sequence&ltorg.omg.CosNotification.StructuredEvent&gt EventBatch;
 * </pre>
 */
public final class EventBatchHelper {
  private static org.omg.CORBA.TypeCode _type;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static org.omg.CosNotification.StructuredEvent[] read (final org.omg.CORBA.portable.InputStream _input) {
    org.omg.CosNotification.StructuredEvent[] result;
    final int $length12 = _input.read_long();
    if($length12 != 0) {
    result = new org.omg.CosNotification.StructuredEvent[$length12];
    for (int $counter13 = 0; $counter13 < $length12; $counter13++) {
    result[$counter13] = org.omg.CosNotification.StructuredEventHelper.read(_input);
    }
    }
    else {
    result = org.omg.CosNotification.EventBatchHelper.EMPTY_LIST;
    }
    return result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final org.omg.CosNotification.StructuredEvent[] _vis_value) {
    if(_vis_value == null){
      throw new org.omg.CORBA.BAD_PARAM("Null parameter");
    }
    _output.write_long(_vis_value.length);
    for (int $counter14 = 0;  $counter14 < _vis_value.length; $counter14++) {
    if (_vis_value[$counter14] == null) {
      throw new org.omg.CORBA.BAD_PARAM("Invalid array length");
    }
    org.omg.CosNotification.StructuredEventHelper.write(_output, _vis_value[$counter14]);
    }
  }

  public static void insert (final org.omg.CORBA.Any any, final org.omg.CosNotification.StructuredEvent[] _vis_value) {
    any.type(org.omg.CosNotification.EventBatchHelper.type());
    any.insert_Streamable(new org.omg.CosNotification.EventBatchHolder(_vis_value));
  }

  public static org.omg.CosNotification.StructuredEvent[] extract (final org.omg.CORBA.Any any) {
    org.omg.CosNotification.StructuredEvent[] _vis_value;
    _vis_value = org.omg.CosNotification.EventBatchHelper.read(any.create_input_stream());
    return _vis_value;
  }

  public static org.omg.CORBA.TypeCode type () {
    if (_type == null) {
      synchronized (org.omg.CORBA.TypeCode.class) {
        if (_type == null) {
          org.omg.CORBA.TypeCode originalType = _orb().create_sequence_tc(0, org.omg.CosNotification.StructuredEventHelper.type());
          _type = _orb().create_alias_tc(id(), "EventBatch", originalType);
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:omg.org/CosNotification/EventBatch:1.0";
  }
  public final static org.omg.CosNotification.StructuredEvent[] EMPTY_LIST = {};
}
