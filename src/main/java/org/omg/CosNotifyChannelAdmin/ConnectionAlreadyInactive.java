package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::ConnectionAlreadyInactive
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/ConnectionAlreadyInactive:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * exception ConnectionAlreadyInactive {
  ...
};
 * </pre>
 */
public final class ConnectionAlreadyInactive extends org.omg.CORBA.UserException {

  /**
	 * 
	 */
	private static final long serialVersionUID = 5176137768265731228L;

public ConnectionAlreadyInactive () {
    super(org.omg.CosNotifyChannelAdmin.ConnectionAlreadyInactiveHelper.id());
  }

  public ConnectionAlreadyInactive (java.lang.String _reason) {
    super(org.omg.CosNotifyChannelAdmin.ConnectionAlreadyInactiveHelper.id() + ' ' + _reason);
    
  }

}
