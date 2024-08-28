package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::ProxyIDSeq
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/ProxyIDSeq:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * typedef sequence&ltorg.omg.CosNotifyChannelAdmin.ProxyID&gt ProxyIDSeq;
 * </pre>
 */
public final class ProxyIDSeqHolder implements org.omg.CORBA.portable.Streamable {
public int[] value;

public ProxyIDSeqHolder () {
}

public ProxyIDSeqHolder (final int[] _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.CosNotifyChannelAdmin.ProxyIDSeqHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.CosNotifyChannelAdmin.ProxyIDSeqHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.CosNotifyChannelAdmin.ProxyIDSeqHelper.type();
}
}
