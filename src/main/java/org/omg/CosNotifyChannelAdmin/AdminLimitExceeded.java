package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::AdminLimitExceeded
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/AdminLimitExceeded:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * exception AdminLimitExceeded {
  ...
};
 * </pre>
 */
public final class AdminLimitExceeded extends org.omg.CORBA.UserException {
  
  /**
	 * 
	 */
	private static final long serialVersionUID = 1384377044753053422L;
public org.omg.CosNotifyChannelAdmin.AdminLimit admin_property_err;

  public AdminLimitExceeded () {
    super(org.omg.CosNotifyChannelAdmin.AdminLimitExceededHelper.id());
  }

  public AdminLimitExceeded (org.omg.CosNotifyChannelAdmin.AdminLimit admin_property_err) {
    this();
    this.admin_property_err = admin_property_err;
  }

  public AdminLimitExceeded (java.lang.String _reason, org.omg.CosNotifyChannelAdmin.AdminLimit admin_property_err) {
    super(org.omg.CosNotifyChannelAdmin.AdminLimitExceededHelper.id() + ' ' + _reason);
    this.admin_property_err = admin_property_err;
  }

}
