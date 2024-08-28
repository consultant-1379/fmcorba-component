package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::PropertyValue
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/PropertyValue:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * typedef any PropertyValue;
 * </pre>
 */
public final class PropertyValueHelper {
  private static org.omg.CORBA.TypeCode _type;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static org.omg.CORBA.Any read (final org.omg.CORBA.portable.InputStream _input) {
    org.omg.CORBA.Any result;
    result = _input.read_any();
    return result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final org.omg.CORBA.Any _vis_value) {
    _output.write_any((org.omg.CORBA.Any)_vis_value);
  }

  public static void insert (final org.omg.CORBA.Any any, final org.omg.CORBA.Any _vis_value) {
    any.type(org.omg.CosNotification.PropertyValueHelper.type());
    any.insert_any((org.omg.CORBA.Any)_vis_value);
  }

  public static org.omg.CORBA.Any extract (final org.omg.CORBA.Any any) {
    org.omg.CORBA.Any _vis_value;
    _vis_value = any.extract_any();

    return _vis_value;
  }

  public static org.omg.CORBA.TypeCode type () {
    if (_type == null) {
      synchronized (org.omg.CORBA.TypeCode.class) {
        if (_type == null) {
          org.omg.CORBA.TypeCode originalType = _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_any);
          _type = _orb().create_alias_tc(id(), "PropertyValue", originalType);
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:omg.org/CosNotification/PropertyValue:1.0";
  }
}
