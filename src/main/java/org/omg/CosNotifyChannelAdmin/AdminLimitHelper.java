package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::AdminLimit
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/AdminLimit:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct AdminLimit {
  ...
};
 * </pre>
 */
public final class AdminLimitHelper {
  private static org.omg.CORBA.TypeCode _type;
  private static boolean _initializing;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static org.omg.CosNotifyChannelAdmin.AdminLimit read (final org.omg.CORBA.portable.InputStream _input) {
    final org.omg.CosNotifyChannelAdmin.AdminLimit _result = new org.omg.CosNotifyChannelAdmin.AdminLimit();
    _result.name = _input.read_string();
    _result.value = _input.read_any();
    return _result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final org.omg.CosNotifyChannelAdmin.AdminLimit _vis_value) {
    _output.write_string((java.lang.String)_vis_value.name);
    _output.write_any((org.omg.CORBA.Any)_vis_value.value);
  }

  public static void insert (final org.omg.CORBA.Any any, final org.omg.CosNotifyChannelAdmin.AdminLimit _vis_value) {
    any.insert_Streamable(new org.omg.CosNotifyChannelAdmin.AdminLimitHolder(_vis_value));
  }

  public static org.omg.CosNotifyChannelAdmin.AdminLimit extract (final org.omg.CORBA.Any any) {
    org.omg.CosNotifyChannelAdmin.AdminLimit _vis_value;
    _vis_value = org.omg.CosNotifyChannelAdmin.AdminLimitHelper.read(any.create_input_stream());
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
          final org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[2];
          members[0] = new org.omg.CORBA.StructMember("name", org.omg.CosNotification.PropertyNameHelper.type(), null);
          members[1] = new org.omg.CORBA.StructMember("value", org.omg.CosNotification.PropertyValueHelper.type(), null);
          _type = _orb().create_struct_tc(id(), "AdminLimit", members);
          _initializing = false;
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:omg.org/CosNotifyChannelAdmin/AdminLimit:1.0";
  }
}
