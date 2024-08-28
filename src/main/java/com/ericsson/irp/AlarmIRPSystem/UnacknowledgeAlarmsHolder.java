package com.ericsson.irp.AlarmIRPSystem;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "AlarmIRPSystem.idl"
 * <li> <b>IDL Name</b>      ::AlarmIRPSystem::UnacknowledgeAlarms
 * <li> <b>Repository Id</b> IDL:3gppsa5.org/AlarmIRPSystem/UnacknowledgeAlarms:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * exception UnacknowledgeAlarms {
  ...
};
 * </pre>
 */
public final class UnacknowledgeAlarmsHolder implements org.omg.CORBA.portable.Streamable {
public com.ericsson.irp.AlarmIRPSystem.UnacknowledgeAlarms value;

public UnacknowledgeAlarmsHolder () {
}

public UnacknowledgeAlarmsHolder (final com.ericsson.irp.AlarmIRPSystem.UnacknowledgeAlarms _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = com.ericsson.irp.AlarmIRPSystem.UnacknowledgeAlarmsHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  com.ericsson.irp.AlarmIRPSystem.UnacknowledgeAlarmsHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return com.ericsson.irp.AlarmIRPSystem.UnacknowledgeAlarmsHelper.type();
}
}
