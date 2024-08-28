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
public final class PropertyErrorHelper {
  private static org.omg.CORBA.TypeCode _type;
  private static boolean _initializing;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static org.omg.CosNotification.PropertyError read (final org.omg.CORBA.portable.InputStream _input) {
    final org.omg.CosNotification.PropertyError _result = new org.omg.CosNotification.PropertyError();
    _result.code = org.omg.CosNotification.QoSError_codeHelper.read(_input);
    _result.name = _input.read_string();
    _result.available_range = org.omg.CosNotification.PropertyRangeHelper.read(_input);
    return _result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final org.omg.CosNotification.PropertyError _vis_value) {
    org.omg.CosNotification.QoSError_codeHelper.write(_output, _vis_value.code);
    _output.write_string((java.lang.String)_vis_value.name);
    if (_vis_value.available_range == null) {
      throw new org.omg.CORBA.BAD_PARAM("Invalid array length");
    }
    org.omg.CosNotification.PropertyRangeHelper.write(_output, _vis_value.available_range);
  }

  public static void insert (final org.omg.CORBA.Any any, final org.omg.CosNotification.PropertyError _vis_value) {
    any.insert_Streamable(new org.omg.CosNotification.PropertyErrorHolder(_vis_value));
  }

  public static org.omg.CosNotification.PropertyError extract (final org.omg.CORBA.Any any) {
    org.omg.CosNotification.PropertyError _vis_value;
    _vis_value = org.omg.CosNotification.PropertyErrorHelper.read(any.create_input_stream());
    return _vis_value;
  }

  public static org.omg.CORBA.TypeCode type () {
    if (_type == null) {
      synchronized (org.omg.CORBA.TypeCode.class) {
        if (_type == null) {
          if (_initializing) {
            return _orb().create_recursive_tc(id());
          }
          _initializing = true;
          final org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[3];
          members[0] = new org.omg.CORBA.StructMember("code", org.omg.CosNotification.QoSError_codeHelper.type(), null);
          members[1] = new org.omg.CORBA.StructMember("name", org.omg.CosNotification.PropertyNameHelper.type(), null);
          members[2] = new org.omg.CORBA.StructMember("available_range", org.omg.CosNotification.PropertyRangeHelper.type(), null);
          _type = _orb().create_struct_tc(id(), "PropertyError", members);
          _initializing = false;
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:omg.org/CosNotification/PropertyError:1.0";
  }
}
