package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::ConnectionAlreadyInactive
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/ConnectionAlreadyInactive:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * exception ConnectionAlreadyInactive {
  ...
};
 * </pre>
 */
public final class ConnectionAlreadyInactiveHelper {
  private static org.omg.CORBA.TypeCode _type;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static org.omg.CosNotifyChannelAdmin.ConnectionAlreadyInactive read (final org.omg.CORBA.portable.InputStream _input) {
    if (!_input.read_string().equals(id())) {
      throw new org.omg.CORBA.MARSHAL("Mismatched repository id");
    }
    final org.omg.CosNotifyChannelAdmin.ConnectionAlreadyInactive _result = new org.omg.CosNotifyChannelAdmin.ConnectionAlreadyInactive();
    return _result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final org.omg.CosNotifyChannelAdmin.ConnectionAlreadyInactive _vis_value) {
    _output.write_string(id());
  }

  public static void insert (final org.omg.CORBA.Any any, final org.omg.CosNotifyChannelAdmin.ConnectionAlreadyInactive _vis_value) {
    any.insert_Streamable(new org.omg.CosNotifyChannelAdmin.ConnectionAlreadyInactiveHolder(_vis_value));
  }

  public static org.omg.CosNotifyChannelAdmin.ConnectionAlreadyInactive extract (final org.omg.CORBA.Any any) {
    org.omg.CosNotifyChannelAdmin.ConnectionAlreadyInactive _vis_value;
    _vis_value = org.omg.CosNotifyChannelAdmin.ConnectionAlreadyInactiveHelper.read(any.create_input_stream());
    return _vis_value;
  }

  public static org.omg.CORBA.TypeCode type () {
    if (_type == null) {
      synchronized (org.omg.CORBA.TypeCode.class) {
        if (_type == null) {
          final org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[0];
          
          _type = _orb().create_exception_tc(id(), "ConnectionAlreadyInactive", members);
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:omg.org/CosNotifyChannelAdmin/ConnectionAlreadyInactive:1.0";
  }
}
