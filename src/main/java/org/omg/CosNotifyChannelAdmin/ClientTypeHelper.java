
package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::ClientType
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/ClientType:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * enum ClientType {ANY_EVENT, STRUCTURED_EVENT, SEQUENCE_EVENT};
 * </pre>
 */
public final class ClientTypeHelper {
  private static org.omg.CORBA.TypeCode _type;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static org.omg.CosNotifyChannelAdmin.ClientType read (final org.omg.CORBA.portable.InputStream _input) {
    return org.omg.CosNotifyChannelAdmin.ClientType.from_int(_input.read_long());
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final org.omg.CosNotifyChannelAdmin.ClientType _vis_value) {
    if (_vis_value == null) {
      throw new org.omg.CORBA.BAD_PARAM("Invalid array length");
    }
    _output.write_long(_vis_value.value());
  }

  public static void insert (final org.omg.CORBA.Any any, final org.omg.CosNotifyChannelAdmin.ClientType _vis_value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    org.omg.CosNotifyChannelAdmin.ClientTypeHelper.write(output, _vis_value);
    any.read_value(output.create_input_stream(), org.omg.CosNotifyChannelAdmin.ClientTypeHelper.type());

  }

  public static org.omg.CosNotifyChannelAdmin.ClientType extract (final org.omg.CORBA.Any any) {
    org.omg.CosNotifyChannelAdmin.ClientType _vis_value;
    _vis_value = org.omg.CosNotifyChannelAdmin.ClientTypeHelper.read(any.create_input_stream());
    return _vis_value;
  }

  public static org.omg.CORBA.TypeCode type () {
    if (_type == null) {
      synchronized (org.omg.CORBA.TypeCode.class) {
        if (_type == null) {
          final java.lang.String members[] = new java.lang.String[] {"ANY_EVENT",
                                                                     "STRUCTURED_EVENT",
                                                                     "SEQUENCE_EVENT"};
          _type = _orb().create_enum_tc(id(), "ClientType", members);
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:omg.org/CosNotifyChannelAdmin/ClientType:1.0";
  }
}
