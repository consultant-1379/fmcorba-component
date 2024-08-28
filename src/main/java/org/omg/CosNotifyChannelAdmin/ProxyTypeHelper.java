package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::ProxyType
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/ProxyType:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * enum ProxyType {PUSH_ANY, PULL_ANY, PUSH_STRUCTURED, PULL_STRUCTURED,
                PUSH_SEQUENCE, PULL_SEQUENCE, PUSH_TYPED, PULL_TYPED};
 * </pre>
 */
public final class ProxyTypeHelper {
  private static org.omg.CORBA.TypeCode _type;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static org.omg.CosNotifyChannelAdmin.ProxyType read (final org.omg.CORBA.portable.InputStream _input) {
    return org.omg.CosNotifyChannelAdmin.ProxyType.from_int(_input.read_long());
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final org.omg.CosNotifyChannelAdmin.ProxyType _vis_value) {
    if (_vis_value == null) {
      throw new org.omg.CORBA.BAD_PARAM("Invalid array length");
    }
    _output.write_long(_vis_value.value());
  }

  public static void insert (final org.omg.CORBA.Any any, final org.omg.CosNotifyChannelAdmin.ProxyType _vis_value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    org.omg.CosNotifyChannelAdmin.ProxyTypeHelper.write(output, _vis_value);
    any.read_value(output.create_input_stream(), org.omg.CosNotifyChannelAdmin.ProxyTypeHelper.type());

  }

  public static org.omg.CosNotifyChannelAdmin.ProxyType extract (final org.omg.CORBA.Any any) {
    org.omg.CosNotifyChannelAdmin.ProxyType _vis_value;
    _vis_value = org.omg.CosNotifyChannelAdmin.ProxyTypeHelper.read(any.create_input_stream());
    return _vis_value;
  }

  public static org.omg.CORBA.TypeCode type () {
    if (_type == null) {
      synchronized (org.omg.CORBA.TypeCode.class) {
        if (_type == null) {
          final java.lang.String members[] = new java.lang.String[] {"PUSH_ANY",
                                                                     "PULL_ANY",
                                                                     "PUSH_STRUCTURED",
                                                                     "PULL_STRUCTURED",
                                                                     "PUSH_SEQUENCE",
                                                                     "PULL_SEQUENCE",
                                                                     "PUSH_TYPED",
                                                                     "PULL_TYPED"};
          _type = _orb().create_enum_tc(id(), "ProxyType", members);
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:omg.org/CosNotifyChannelAdmin/ProxyType:1.0";
  }
}
