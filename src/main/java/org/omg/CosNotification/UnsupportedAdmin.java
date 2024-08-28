package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::UnsupportedAdmin
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/UnsupportedAdmin:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * exception UnsupportedAdmin {
  ...
};
 * </pre>
 */
public final class UnsupportedAdmin extends org.omg.CORBA.UserException {
  
  /**
	 * 
	 */
	private static final long serialVersionUID = 4884527543489139600L;
public org.omg.CosNotification.PropertyError[] admin_err;

  public UnsupportedAdmin () {
    super(org.omg.CosNotification.UnsupportedAdminHelper.id());
  }

  public UnsupportedAdmin (org.omg.CosNotification.PropertyError[] admin_err) {
    this();
    this.admin_err = admin_err;
  }

  public UnsupportedAdmin (java.lang.String _reason, org.omg.CosNotification.PropertyError[] admin_err) {
    super(org.omg.CosNotification.UnsupportedAdminHelper.id() + ' ' + _reason);
    this.admin_err = admin_err;
  }

}
