package org.omg.TimeBase;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "TimeBase.idl"
 * <li> <b>IDL Name</b>      ::TimeBase::IntervalT
 * <li> <b>Repository Id</b> IDL:omg.org/TimeBase/IntervalT:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct IntervalT {
  ...
};
 * </pre>
 */
public final class IntervalTHolder implements org.omg.CORBA.portable.Streamable {
public org.omg.TimeBase.IntervalT value;

public IntervalTHolder () {
}

public IntervalTHolder (final org.omg.TimeBase.IntervalT _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.TimeBase.IntervalTHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.TimeBase.IntervalTHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.TimeBase.IntervalTHelper.type();
}
}
