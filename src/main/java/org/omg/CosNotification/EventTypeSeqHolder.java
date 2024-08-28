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
public final class EventTypeSeqHolder implements org.omg.CORBA.portable.Streamable {
public org.omg.CosNotification.EventType[] value;

public EventTypeSeqHolder () {
}

public EventTypeSeqHolder (final org.omg.CosNotification.EventType[] _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.CosNotification.EventTypeSeqHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.CosNotification.EventTypeSeqHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.CosNotification.EventTypeSeqHelper.type();
}
}
