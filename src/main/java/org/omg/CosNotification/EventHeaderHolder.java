package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::EventHeader
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/EventHeader:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct EventHeader {
  ...
};
 * </pre>
 */
public final class EventHeaderHolder implements org.omg.CORBA.portable.Streamable {
public org.omg.CosNotification.EventHeader value;

public EventHeaderHolder () {
}

public EventHeaderHolder (final org.omg.CosNotification.EventHeader _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.CosNotification.EventHeaderHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.CosNotification.EventHeaderHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.CosNotification.EventHeaderHelper.type();
}
}
