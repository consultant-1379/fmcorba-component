package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::UnsupportedQoS
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/UnsupportedQoS:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * exception UnsupportedQoS {
  ...
};
 * </pre>
 */
public final class UnsupportedQoS extends org.omg.CORBA.UserException {
  
  /**
	 * 
	 */
	private static final long serialVersionUID = -4847378476586722593L;
public org.omg.CosNotification.PropertyError[] qos_err;

  public UnsupportedQoS () {
    super(org.omg.CosNotification.UnsupportedQoSHelper.id());
  }

  public UnsupportedQoS (org.omg.CosNotification.PropertyError[] qos_err) {
    this();
    this.qos_err = qos_err;
  }

  public UnsupportedQoS (java.lang.String _reason, org.omg.CosNotification.PropertyError[] qos_err) {
    super(org.omg.CosNotification.UnsupportedQoSHelper.id() + ' ' + _reason);
    this.qos_err = qos_err;
  }

}
