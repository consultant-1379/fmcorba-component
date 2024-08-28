package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::AdminLimitExceeded
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/AdminLimitExceeded:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * exception AdminLimitExceeded {
  ...
};
 * </pre>
 */
public final class AdminLimitExceededHelper {
  private static org.omg.CORBA.TypeCode _type;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static org.omg.CosNotifyChannelAdmin.AdminLimitExceeded read (final org.omg.CORBA.portable.InputStream _input) {
    if (!_input.read_string().equals(id())) {
      throw new org.omg.CORBA.MARSHAL("Mismatched repository id");
    }
    final org.omg.CosNotifyChannelAdmin.AdminLimitExceeded _result = new org.omg.CosNotifyChannelAdmin.AdminLimitExceeded();
    _result.admin_property_err = org.omg.CosNotifyChannelAdmin.AdminLimitHelper.read(_input);
    return _result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final org.omg.CosNotifyChannelAdmin.AdminLimitExceeded _vis_value) {
    _output.write_string(id());
    if (_vis_value.admin_property_err == null) {
      throw new org.omg.CORBA.BAD_PARAM("Invalid array length");
    }
    org.omg.CosNotifyChannelAdmin.AdminLimitHelper.write(_output, _vis_value.admin_property_err);
  }

  public static void insert (final org.omg.CORBA.Any any, final org.omg.CosNotifyChannelAdmin.AdminLimitExceeded _vis_value) {
    any.insert_Streamable(new org.omg.CosNotifyChannelAdmin.AdminLimitExceededHolder(_vis_value));
  }

  public static org.omg.CosNotifyChannelAdmin.AdminLimitExceeded extract (final org.omg.CORBA.Any any) {
    org.omg.CosNotifyChannelAdmin.AdminLimitExceeded _vis_value;
    _vis_value = org.omg.CosNotifyChannelAdmin.AdminLimitExceededHelper.read(any.create_input_stream());
    return _vis_value;
  }

  public static org.omg.CORBA.TypeCode type () {
    if (_type == null) {
      synchronized (org.omg.CORBA.TypeCode.class) {
        if (_type == null) {
          final org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[1];
          members[0] = new org.omg.CORBA.StructMember("admin_property_err", org.omg.CosNotifyChannelAdmin.AdminLimitHelper.type(), null);
          _type = _orb().create_exception_tc(id(), "AdminLimitExceeded", members);
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:omg.org/CosNotifyChannelAdmin/AdminLimitExceeded:1.0";
  }
}
