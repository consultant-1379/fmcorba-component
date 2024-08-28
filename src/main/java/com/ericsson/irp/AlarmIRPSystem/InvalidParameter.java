package com.ericsson.irp.AlarmIRPSystem;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "AlarmIRPSystem.idl"
 * <li> <b>IDL Name</b>      ::AlarmIRPSystem::InvalidParameter
 * <li> <b>Repository Id</b> IDL:3gppsa5.org/AlarmIRPSystem/InvalidParameter:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * exception InvalidParameter {
  ...
};
 * </pre>
 */
public final class InvalidParameter extends org.omg.CORBA.UserException {
  
  /**
	 * 
	 */
	private static final long serialVersionUID = -8734854916552965645L;
public java.lang.String parameter;

  public InvalidParameter () {
    super(com.ericsson.irp.AlarmIRPSystem.InvalidParameterHelper.id());
  }

  public InvalidParameter (java.lang.String parameter) {
    this();
    this.parameter = parameter;
  }

  public InvalidParameter (java.lang.String _reason, java.lang.String parameter) {
    super(com.ericsson.irp.AlarmIRPSystem.InvalidParameterHelper.id() + ' ' + _reason);
    this.parameter = parameter;
  }

}
