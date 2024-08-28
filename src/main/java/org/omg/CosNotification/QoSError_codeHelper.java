package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::QoSError_code
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/QoSError_code:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * enum QoSError_code {UNSUPPORTED_PROPERTY, UNAVAILABLE_PROPERTY,
                    UNSUPPORTED_VALUE, UNAVAILABLE_VALUE, BAD_PROPERTY,
                    BAD_TYPE, BAD_VALUE};
 * </pre>
 */
public final class QoSError_codeHelper {
  private static org.omg.CORBA.TypeCode _type;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static org.omg.CosNotification.QoSError_code read (final org.omg.CORBA.portable.InputStream _input) {
    return org.omg.CosNotification.QoSError_code.from_int(_input.read_long());
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final org.omg.CosNotification.QoSError_code _vis_value) {
    if (_vis_value == null) {
      throw new org.omg.CORBA.BAD_PARAM("Invalid array length");
    }
    _output.write_long(_vis_value.value());
  }

  public static void insert (final org.omg.CORBA.Any any, final org.omg.CosNotification.QoSError_code _vis_value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    org.omg.CosNotification.QoSError_codeHelper.write(output, _vis_value);
    any.read_value(output.create_input_stream(), org.omg.CosNotification.QoSError_codeHelper.type());

  }

  public static org.omg.CosNotification.QoSError_code extract (final org.omg.CORBA.Any any) {
    org.omg.CosNotification.QoSError_code _vis_value;
    _vis_value = org.omg.CosNotification.QoSError_codeHelper.read(any.create_input_stream());
    return _vis_value;
  }

  public static org.omg.CORBA.TypeCode type () {
    if (_type == null) {
      synchronized (org.omg.CORBA.TypeCode.class) {
        if (_type == null) {
          final java.lang.String members[] = new java.lang.String[] {"UNSUPPORTED_PROPERTY",
                                                                     "UNAVAILABLE_PROPERTY",
                                                                     "UNSUPPORTED_VALUE",
                                                                     "UNAVAILABLE_VALUE",
                                                                     "BAD_PROPERTY",
                                                                     "BAD_TYPE",
                                                                     "BAD_VALUE"};
          _type = _orb().create_enum_tc(id(), "QoSError_code", members);
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:omg.org/CosNotification/QoSError_code:1.0";
  }
}
