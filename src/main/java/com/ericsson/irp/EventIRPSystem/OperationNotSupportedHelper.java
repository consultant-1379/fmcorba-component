package com.ericsson.irp.EventIRPSystem;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "EventIRPSystem.idl"
 * <li> <b>IDL Name</b>      ::EventIRPSystem::OperationNotSupported
 * <li> <b>Repository Id</b> IDL:EventIRPSystem/OperationNotSupported:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * exception OperationNotSupported {
  ...
};
 * </pre>
 */
public final class OperationNotSupportedHelper {
  private static org.omg.CORBA.TypeCode _type;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static com.ericsson.irp.EventIRPSystem.OperationNotSupported read (final org.omg.CORBA.portable.InputStream _input) {
    if (!_input.read_string().equals(id())) {
      throw new org.omg.CORBA.MARSHAL("Mismatched repository id");
    }
    final com.ericsson.irp.EventIRPSystem.OperationNotSupported _result = new com.ericsson.irp.EventIRPSystem.OperationNotSupported();
    return _result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final com.ericsson.irp.EventIRPSystem.OperationNotSupported _vis_value) {
    _output.write_string(id());
  }

  public static void insert (final org.omg.CORBA.Any any, final com.ericsson.irp.EventIRPSystem.OperationNotSupported _vis_value) {
    any.insert_Streamable(new com.ericsson.irp.EventIRPSystem.OperationNotSupportedHolder(_vis_value));
  }

  public static com.ericsson.irp.EventIRPSystem.OperationNotSupported extract (final org.omg.CORBA.Any any) {
    com.ericsson.irp.EventIRPSystem.OperationNotSupported _vis_value;
    _vis_value = com.ericsson.irp.EventIRPSystem.OperationNotSupportedHelper.read(any.create_input_stream());
    return _vis_value;
  }

  public static org.omg.CORBA.TypeCode type () {
    if (_type == null) {
      synchronized (org.omg.CORBA.TypeCode.class) {
        if (_type == null) {
          final org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[0];
          
          _type = _orb().create_exception_tc(id(), "OperationNotSupported", members);
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:EventIRPSystem/OperationNotSupported:1.0";
  }
}
