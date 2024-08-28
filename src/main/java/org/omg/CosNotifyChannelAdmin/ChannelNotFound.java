package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::ChannelNotFound
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/ChannelNotFound:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * exception ChannelNotFound {
  ...
};
 * </pre>
 */
public final class ChannelNotFound extends org.omg.CORBA.UserException {

  /**
	 * 
	 */
	private static final long serialVersionUID = -6376337155700517513L;

public ChannelNotFound () {
    super(org.omg.CosNotifyChannelAdmin.ChannelNotFoundHelper.id());
  }

  public ChannelNotFound (java.lang.String _reason) {
    super(org.omg.CosNotifyChannelAdmin.ChannelNotFoundHelper.id() + ' ' + _reason);
    
  }

}
