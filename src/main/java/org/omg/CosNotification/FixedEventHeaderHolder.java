package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::FixedEventHeader
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/FixedEventHeader:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct FixedEventHeader {
  ...
};
 * </pre>
 */
public final class FixedEventHeaderHolder implements org.omg.CORBA.portable.Streamable {
public org.omg.CosNotification.FixedEventHeader value;

public FixedEventHeaderHolder () {
}

public FixedEventHeaderHolder (final org.omg.CosNotification.FixedEventHeader _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.CosNotification.FixedEventHeaderHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.CosNotification.FixedEventHeaderHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.CosNotification.FixedEventHeaderHelper.type();
}
}
