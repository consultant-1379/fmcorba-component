package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::ObtainInfoMode
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/ObtainInfoMode:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * enum ObtainInfoMode {ALL_NOW_UPDATES_OFF, ALL_NOW_UPDATES_ON,
                     NONE_NOW_UPDATES_OFF, NONE_NOW_UPDATES_ON};
 * </pre>
 */
public final class ObtainInfoModeHelper {
  private static org.omg.CORBA.TypeCode _type;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static org.omg.CosNotifyChannelAdmin.ObtainInfoMode read (final org.omg.CORBA.portable.InputStream _input) {
    return org.omg.CosNotifyChannelAdmin.ObtainInfoMode.from_int(_input.read_long());
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final org.omg.CosNotifyChannelAdmin.ObtainInfoMode _vis_value) {
    if (_vis_value == null) {
      throw new org.omg.CORBA.BAD_PARAM("Invalid array length");
    }
    _output.write_long(_vis_value.value());
  }

  public static void insert (final org.omg.CORBA.Any any, final org.omg.CosNotifyChannelAdmin.ObtainInfoMode _vis_value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    org.omg.CosNotifyChannelAdmin.ObtainInfoModeHelper.write(output, _vis_value);
    any.read_value(output.create_input_stream(), org.omg.CosNotifyChannelAdmin.ObtainInfoModeHelper.type());

  }

  public static org.omg.CosNotifyChannelAdmin.ObtainInfoMode extract (final org.omg.CORBA.Any any) {
    org.omg.CosNotifyChannelAdmin.ObtainInfoMode _vis_value;
    _vis_value = org.omg.CosNotifyChannelAdmin.ObtainInfoModeHelper.read(any.create_input_stream());
    return _vis_value;
  }

  public static org.omg.CORBA.TypeCode type () {
    if (_type == null) {
      synchronized (org.omg.CORBA.TypeCode.class) {
        if (_type == null) {
          final java.lang.String members[] = new java.lang.String[] {"ALL_NOW_UPDATES_OFF",
                                                                     "ALL_NOW_UPDATES_ON",
                                                                     "NONE_NOW_UPDATES_OFF",
                                                                     "NONE_NOW_UPDATES_ON"};
          _type = _orb().create_enum_tc(id(), "ObtainInfoMode", members);
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:omg.org/CosNotifyChannelAdmin/ObtainInfoMode:1.0";
  }
}
