package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::AdminNotFound
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/AdminNotFound:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * exception AdminNotFound {
  ...
};
 * </pre>
 */
public final class AdminNotFound extends org.omg.CORBA.UserException {

  /**
	 * 
	 */
	private static final long serialVersionUID = 8773521960255479543L;

public AdminNotFound () {
    super(org.omg.CosNotifyChannelAdmin.AdminNotFoundHelper.id());
  }

  public AdminNotFound (java.lang.String _reason) {
    super(org.omg.CosNotifyChannelAdmin.AdminNotFoundHelper.id() + ' ' + _reason);
    
  }

}
