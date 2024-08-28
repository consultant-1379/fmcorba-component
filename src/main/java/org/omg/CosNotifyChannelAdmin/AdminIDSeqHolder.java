package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::AdminIDSeq
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/AdminIDSeq:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * typedef sequence&ltorg.omg.CosNotifyChannelAdmin.AdminID&gt AdminIDSeq;
 * </pre>
 */
public final class AdminIDSeqHolder implements org.omg.CORBA.portable.Streamable {
public int[] value;

public AdminIDSeqHolder () {
}

public AdminIDSeqHolder (final int[] _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.CosNotifyChannelAdmin.AdminIDSeqHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.CosNotifyChannelAdmin.AdminIDSeqHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.CosNotifyChannelAdmin.AdminIDSeqHelper.type();
}
}
