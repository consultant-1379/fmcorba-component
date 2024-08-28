package org.omg.TimeBase;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "TimeBase.idl"
 * <li> <b>IDL Name</b>      ::TimeBase::UtcT
 * <li> <b>Repository Id</b> IDL:omg.org/TimeBase/UtcT:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct UtcT {
  ...
};
 * </pre>
 */
public final class UtcTHolder implements org.omg.CORBA.portable.Streamable {
public org.omg.TimeBase.UtcT value;

public UtcTHolder () {
}

public UtcTHolder (final org.omg.TimeBase.UtcT _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.TimeBase.UtcTHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.TimeBase.UtcTHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.TimeBase.UtcTHelper.type();
}
}
