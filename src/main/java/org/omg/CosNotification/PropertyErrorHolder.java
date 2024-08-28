package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::PropertyError
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/PropertyError:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct PropertyError {
  ...
};
 * </pre>
 */
public final class PropertyErrorHolder implements org.omg.CORBA.portable.Streamable {
public org.omg.CosNotification.PropertyError value;

public PropertyErrorHolder () {
}

public PropertyErrorHolder (final org.omg.CosNotification.PropertyError _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.CosNotification.PropertyErrorHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.CosNotification.PropertyErrorHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.CosNotification.PropertyErrorHelper.type();
}
}
