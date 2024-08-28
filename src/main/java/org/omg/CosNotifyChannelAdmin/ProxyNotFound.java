package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::ProxyNotFound
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/ProxyNotFound:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * exception ProxyNotFound {
  ...
};
 * </pre>
 */
public final class ProxyNotFound extends org.omg.CORBA.UserException {

  /**
	 * 
	 */
	private static final long serialVersionUID = 2923048638705248299L;

public ProxyNotFound () {
    super(org.omg.CosNotifyChannelAdmin.ProxyNotFoundHelper.id());
  }

  public ProxyNotFound (java.lang.String _reason) {
    super(org.omg.CosNotifyChannelAdmin.ProxyNotFoundHelper.id() + ' ' + _reason);
    
  }

}
