package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::Property
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/Property:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct Property {
  ...
};
 * </pre>
 */
public final class PropertyHolder implements org.omg.CORBA.portable.Streamable {
public org.omg.CosNotification.Property value;

public PropertyHolder () {
}

public PropertyHolder (final org.omg.CosNotification.Property _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.CosNotification.PropertyHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.CosNotification.PropertyHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.CosNotification.PropertyHelper.type();
}
}
