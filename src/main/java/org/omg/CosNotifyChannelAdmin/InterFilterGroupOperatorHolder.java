package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::InterFilterGroupOperator
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/InterFilterGroupOperator:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * enum InterFilterGroupOperator {AND_OP, OR_OP};
 * </pre>
 */
public final class InterFilterGroupOperatorHolder implements org.omg.CORBA.portable.Streamable {
public org.omg.CosNotifyChannelAdmin.InterFilterGroupOperator value;

public InterFilterGroupOperatorHolder () {
}

public InterFilterGroupOperatorHolder (final org.omg.CosNotifyChannelAdmin.InterFilterGroupOperator _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.CosNotifyChannelAdmin.InterFilterGroupOperatorHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.CosNotifyChannelAdmin.InterFilterGroupOperatorHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.CosNotifyChannelAdmin.InterFilterGroupOperatorHelper.type();
}
}
