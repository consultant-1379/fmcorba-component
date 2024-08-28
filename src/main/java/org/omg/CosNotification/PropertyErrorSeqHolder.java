package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::PropertyErrorSeq
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/PropertyErrorSeq:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * typedef sequence&ltorg.omg.CosNotification.PropertyError&gt PropertyErrorSeq;
 * </pre>
 */
public final class PropertyErrorSeqHolder implements org.omg.CORBA.portable.Streamable {
public org.omg.CosNotification.PropertyError[] value;

public PropertyErrorSeqHolder () {
}

public PropertyErrorSeqHolder (final org.omg.CosNotification.PropertyError[] _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.CosNotification.PropertyErrorSeqHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.CosNotification.PropertyErrorSeqHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.CosNotification.PropertyErrorSeqHelper.type();
}
}
