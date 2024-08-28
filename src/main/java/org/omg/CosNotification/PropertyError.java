package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::PropertyError
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/PropertyError:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct PropertyError {
  ...
};
 * </pre>
 */
public final class PropertyError implements org.omg.CORBA.portable.IDLEntity {
  
  /**
	 * 
	 */
	private static final long serialVersionUID = -6119136130819592299L;

public org.omg.CosNotification.QoSError_code code;
  
  public java.lang.String name;
  
  public org.omg.CosNotification.PropertyRange available_range;

  public PropertyError () {
    name = "";
  }

  public PropertyError (final org.omg.CosNotification.QoSError_code code, 
                        final java.lang.String name, 
                        final org.omg.CosNotification.PropertyRange available_range) {
    this.code = code;
    this.name = name;
    this.available_range = available_range;
  }

}
