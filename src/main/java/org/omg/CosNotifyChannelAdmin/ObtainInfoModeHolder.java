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
public final class ObtainInfoModeHolder implements org.omg.CORBA.portable.Streamable {
public org.omg.CosNotifyChannelAdmin.ObtainInfoMode value;

public ObtainInfoModeHolder () {
}

public ObtainInfoModeHolder (final org.omg.CosNotifyChannelAdmin.ObtainInfoMode _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.CosNotifyChannelAdmin.ObtainInfoModeHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.CosNotifyChannelAdmin.ObtainInfoModeHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.CosNotifyChannelAdmin.ObtainInfoModeHelper.type();
}
}
