package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::EventChannel
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/EventChannel:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface EventChannel : org.omg.CosNotification.QoSAdmin,
                         org.omg.CosNotification.AdminPropertiesAdmin,
                         com.ericsson.irp.CosEventChannelAdmin.EventChannel {
  ...
};
 * </pre>
 */
public final class EventChannelHolder implements org.omg.CORBA.portable.Streamable {
public org.omg.CosNotifyChannelAdmin.EventChannel value;

public EventChannelHolder () {
}

public EventChannelHolder (final org.omg.CosNotifyChannelAdmin.EventChannel _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.CosNotifyChannelAdmin.EventChannelHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.CosNotifyChannelAdmin.EventChannelHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.CosNotifyChannelAdmin.EventChannelHelper.type();
}
}
