package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::AdminLimit
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/AdminLimit:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct AdminLimit {
  ...
};
 * </pre>
 */
public final class AdminLimit implements org.omg.CORBA.portable.IDLEntity {
  
  /**
	 * 
	 */
	private static final long serialVersionUID = 183094232421449937L;

public java.lang.String name;
  
  public org.omg.CORBA.Any value;

  public AdminLimit () {
    name = "";
  }

  public AdminLimit (final java.lang.String name, 
                     final org.omg.CORBA.Any value) {
    this.name = name;
    this.value = value;
  }

}
