package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::EventType
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/EventType:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct EventType {
  ...
};
 * </pre>
 */
public final class EventType implements org.omg.CORBA.portable.IDLEntity {
  
  /**
	 * 
	 */
	private static final long serialVersionUID = -8975801997065696814L;

public java.lang.String domain_name;
  
  public java.lang.String type_name;

  public EventType () {
    domain_name = "";
    type_name = "";
  }

  public EventType (final java.lang.String domain_name, 
                    final java.lang.String type_name) {
    this.domain_name = domain_name;
    this.type_name = type_name;
  }

}
