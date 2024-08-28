package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::ConnectionAlreadyActive
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/ConnectionAlreadyActive:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * exception ConnectionAlreadyActive {
  ...
};
 * </pre>
 */
public final class ConnectionAlreadyActive extends org.omg.CORBA.UserException {

  /**
	 * 
	 */
	private static final long serialVersionUID = 9202358895622860760L;

public ConnectionAlreadyActive () {
    super(org.omg.CosNotifyChannelAdmin.ConnectionAlreadyActiveHelper.id());
  }

  public ConnectionAlreadyActive (java.lang.String _reason) {
    super(org.omg.CosNotifyChannelAdmin.ConnectionAlreadyActiveHelper.id() + ' ' + _reason);
    
  }

}
