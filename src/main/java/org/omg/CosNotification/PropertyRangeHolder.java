package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::PropertyRange
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/PropertyRange:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct PropertyRange {
  ...
};
 * </pre>
 */
public final class PropertyRangeHolder implements org.omg.CORBA.portable.Streamable {
public org.omg.CosNotification.PropertyRange value;

public PropertyRangeHolder () {
}

public PropertyRangeHolder (final org.omg.CosNotification.PropertyRange _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.CosNotification.PropertyRangeHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.CosNotification.PropertyRangeHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.CosNotification.PropertyRangeHelper.type();
}
}
