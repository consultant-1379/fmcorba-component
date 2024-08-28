package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::StructuredEvent
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/StructuredEvent:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct StructuredEvent {
  ...
};
 * </pre>
 */
public final class StructuredEvent implements org.omg.CORBA.portable.IDLEntity {
  
  /**
	 * 
	 */
	private static final long serialVersionUID = -3715316000037216409L;

public org.omg.CosNotification.EventHeader header;
  
  public org.omg.CosNotification.Property[] filterable_data;
  
  public org.omg.CORBA.Any remainder_of_body;

  public StructuredEvent () {
  }

  public StructuredEvent (final org.omg.CosNotification.EventHeader header, 
                          final org.omg.CosNotification.Property[] filterable_data, 
                          final org.omg.CORBA.Any remainder_of_body) {
    this.header = header;
    this.filterable_data = filterable_data;
    this.remainder_of_body = remainder_of_body;
  }

}
