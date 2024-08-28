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
public final class EventBatchHolder implements org.omg.CORBA.portable.Streamable {
public org.omg.CosNotification.StructuredEvent[] value;

public EventBatchHolder () {
}

public EventBatchHolder (final org.omg.CosNotification.StructuredEvent[] _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.CosNotification.EventBatchHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.CosNotification.EventBatchHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.CosNotification.EventBatchHelper.type();
}
}
