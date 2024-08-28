package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::QoSError_code
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/QoSError_code:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * enum QoSError_code {UNSUPPORTED_PROPERTY, UNAVAILABLE_PROPERTY,
                    UNSUPPORTED_VALUE, UNAVAILABLE_VALUE, BAD_PROPERTY,
                    BAD_TYPE, BAD_VALUE};
 * </pre>
 */
public final class QoSError_codeHolder implements org.omg.CORBA.portable.Streamable {
public org.omg.CosNotification.QoSError_code value;

public QoSError_codeHolder () {
}

public QoSError_codeHolder (final org.omg.CosNotification.QoSError_code _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = org.omg.CosNotification.QoSError_codeHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  org.omg.CosNotification.QoSError_codeHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return org.omg.CosNotification.QoSError_codeHelper.type();
}
}
