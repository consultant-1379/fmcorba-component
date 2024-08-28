package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::ChannelIDSeq
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/ChannelIDSeq:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * typedef sequence&ltorg.omg.CosNotifyChannelAdmin.ChannelID&gt ChannelIDSeq;
 * </pre>
 */
public final class ChannelIDSeqHolder implements org.omg.CORBA.portable.Streamable {
public int[] value;

public ChannelIDSeqHolder () {
}

public ChannelIDSeqHolder (final int[] _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.CosNotifyChannelAdmin.ChannelIDSeqHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.CosNotifyChannelAdmin.ChannelIDSeqHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.CosNotifyChannelAdmin.ChannelIDSeqHelper.type();
}
}
