package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::NamedPropertyRangeSeq
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/NamedPropertyRangeSeq:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * typedef sequence&ltorg.omg.CosNotification.NamedPropertyRange&gt NamedPropertyRangeSeq;
 * </pre>
 */
public final class NamedPropertyRangeSeqHolder implements org.omg.CORBA.portable.Streamable {
public org.omg.CosNotification.NamedPropertyRange[] value;

public NamedPropertyRangeSeqHolder () {
}

public NamedPropertyRangeSeqHolder (final org.omg.CosNotification.NamedPropertyRange[] _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.CosNotification.NamedPropertyRangeSeqHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.CosNotification.NamedPropertyRangeSeqHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.CosNotification.NamedPropertyRangeSeqHelper.type();
}
}
