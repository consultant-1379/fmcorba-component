package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::StructuredEvent
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/StructuredEvent:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct StructuredEvent {
  ...
};
 * </pre>
 */
public final class StructuredEventHolder implements org.omg.CORBA.portable.Streamable {
public org.omg.CosNotification.StructuredEvent value;

public StructuredEventHolder () {
}

public StructuredEventHolder (final org.omg.CosNotification.StructuredEvent _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.CosNotification.StructuredEventHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.CosNotification.StructuredEventHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.CosNotification.StructuredEventHelper.type();
}
}
