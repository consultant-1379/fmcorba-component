package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::EventChannelFactory
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/EventChannelFactory:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface EventChannelFactory {
  ...
};
 * </pre>
 */
public final class EventChannelFactoryHolder implements org.omg.CORBA.portable.Streamable {
public org.omg.CosNotifyChannelAdmin.EventChannelFactory value;

public EventChannelFactoryHolder () {
}

public EventChannelFactoryHolder (final org.omg.CosNotifyChannelAdmin.EventChannelFactory _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.CosNotifyChannelAdmin.EventChannelFactoryHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.CosNotifyChannelAdmin.EventChannelFactoryHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.CosNotifyChannelAdmin.EventChannelFactoryHelper.type();
}
}
