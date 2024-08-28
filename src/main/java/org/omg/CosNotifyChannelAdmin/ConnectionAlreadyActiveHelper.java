package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::ConnectionAlreadyActive
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/ConnectionAlreadyActive:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * exception ConnectionAlreadyActive {
  ...
};
 * </pre>
 */
public final class ConnectionAlreadyActiveHelper {
  private static org.omg.CORBA.TypeCode _type;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static org.omg.CosNotifyChannelAdmin.ConnectionAlreadyActive read (final org.omg.CORBA.portable.InputStream _input) {
    if (!_input.read_string().equals(id())) {
      throw new org.omg.CORBA.MARSHAL("Mismatched repository id");
    }
    final org.omg.CosNotifyChannelAdmin.ConnectionAlreadyActive _result = new org.omg.CosNotifyChannelAdmin.ConnectionAlreadyActive();
    return _result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final org.omg.CosNotifyChannelAdmin.ConnectionAlreadyActive _vis_value) {
    _output.write_string(id());
  }

  public static void insert (final org.omg.CORBA.Any any, final org.omg.CosNotifyChannelAdmin.ConnectionAlreadyActive _vis_value) {
    any.insert_Streamable(new org.omg.CosNotifyChannelAdmin.ConnectionAlreadyActiveHolder(_vis_value));
  }

  public static org.omg.CosNotifyChannelAdmin.ConnectionAlreadyActive extract (final org.omg.CORBA.Any any) {
    org.omg.CosNotifyChannelAdmin.ConnectionAlreadyActive _vis_value;
    _vis_value = org.omg.CosNotifyChannelAdmin.ConnectionAlreadyActiveHelper.read(any.create_input_stream());
    return _vis_value;
  }

  public static org.omg.CORBA.TypeCode type () {
    if (_type == null) {
      synchronized (org.omg.CORBA.TypeCode.class) {
        if (_type == null) {
          final org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[0];
          
          _type = _orb().create_exception_tc(id(), "ConnectionAlreadyActive", members);
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:omg.org/CosNotifyChannelAdmin/ConnectionAlreadyActive:1.0";
  }
}
