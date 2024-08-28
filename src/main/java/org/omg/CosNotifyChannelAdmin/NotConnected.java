package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::NotConnected
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/NotConnected:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * exception NotConnected {
  ...
};
 * </pre>
 */
public final class NotConnected extends org.omg.CORBA.UserException {

  /**
	 * 
	 */
	private static final long serialVersionUID = -4346931655432157262L;

public NotConnected () {
    super(org.omg.CosNotifyChannelAdmin.NotConnectedHelper.id());
  }

  public NotConnected (java.lang.String _reason) {
    super(org.omg.CosNotifyChannelAdmin.NotConnectedHelper.id() + ' ' + _reason);
    
  }

}
