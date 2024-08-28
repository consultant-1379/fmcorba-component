package com.ericsson.irp.CosNaming;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNaming.idl"
 * <li> <b>IDL Name</b>      ::CosNaming::NamingContext
 * <li> <b>Repository Id</b> IDL:omg.org/CosNaming/NamingContext:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface NamingContext {
  ...
};
 * </pre>
 */
public final class NamingContextHolder implements org.omg.CORBA.portable.Streamable {
public com.ericsson.irp.CosNaming.NamingContext value;

public NamingContextHolder () {
}

public NamingContextHolder (final com.ericsson.irp.CosNaming.NamingContext _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = com.ericsson.irp.CosNaming.NamingContextHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  com.ericsson.irp.CosNaming.NamingContextHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return com.ericsson.irp.CosNaming.NamingContextHelper.type();
}
}
