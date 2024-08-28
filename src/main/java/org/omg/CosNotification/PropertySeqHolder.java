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
public final class PropertySeqHolder implements org.omg.CORBA.portable.Streamable {
public org.omg.CosNotification.Property[] value;

public PropertySeqHolder () {
}

public PropertySeqHolder (final org.omg.CosNotification.Property[] _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.CosNotification.PropertySeqHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.CosNotification.PropertySeqHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.CosNotification.PropertySeqHelper.type();
}
}
