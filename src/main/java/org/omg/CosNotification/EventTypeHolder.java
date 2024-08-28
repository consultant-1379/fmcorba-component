package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::EventType
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/EventType:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct EventType {
  ...
};
 * </pre>
 */
public final class EventTypeHolder implements org.omg.CORBA.portable.Streamable {
public org.omg.CosNotification.EventType value;

public EventTypeHolder () {
}

public EventTypeHolder (final org.omg.CosNotification.EventType _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.CosNotification.EventTypeHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.CosNotification.EventTypeHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.CosNotification.EventTypeHelper.type();
}
}
