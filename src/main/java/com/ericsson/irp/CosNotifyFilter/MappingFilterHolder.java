package com.ericsson.irp.CosNotifyFilter;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyFilter.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyFilter::MappingFilter
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyFilter/MappingFilter:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface MappingFilter {
  ...
};
 * </pre>
 */
public final class MappingFilterHolder implements org.omg.CORBA.portable.Streamable {
public com.ericsson.irp.CosNotifyFilter.MappingFilter value;

public MappingFilterHolder () {
}

public MappingFilterHolder (final com.ericsson.irp.CosNotifyFilter.MappingFilter _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = com.ericsson.irp.CosNotifyFilter.MappingFilterHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  com.ericsson.irp.CosNotifyFilter.MappingFilterHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return com.ericsson.irp.CosNotifyFilter.MappingFilterHelper.type();
}
}
