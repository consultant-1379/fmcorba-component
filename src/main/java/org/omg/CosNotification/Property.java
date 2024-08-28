package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::Property
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/Property:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct Property {
  ...
};
 * </pre>
 */
public final class Property implements org.omg.CORBA.portable.IDLEntity {
  
  /**
	 * 
	 */
	private static final long serialVersionUID = -6108112447028566815L;

public java.lang.String name;
  
  public org.omg.CORBA.Any value;

  public Property () {
    name = "";
  }

  public Property (final java.lang.String name, 
                   final org.omg.CORBA.Any value) {
    this.name = name;
    this.value = value;
  }

}
