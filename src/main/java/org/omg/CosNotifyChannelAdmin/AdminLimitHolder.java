package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::AdminLimit
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/AdminLimit:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct AdminLimit {
  ...
};
 * </pre>
 */
public final class AdminLimitHolder implements org.omg.CORBA.portable.Streamable {
public org.omg.CosNotifyChannelAdmin.AdminLimit value;

public AdminLimitHolder () {
}

public AdminLimitHolder (final org.omg.CosNotifyChannelAdmin.AdminLimit _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.CosNotifyChannelAdmin.AdminLimitHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.CosNotifyChannelAdmin.AdminLimitHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.CosNotifyChannelAdmin.AdminLimitHelper.type();
}
}
