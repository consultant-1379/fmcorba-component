package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::EventHeader
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/EventHeader:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct EventHeader {
  ...
};
 * </pre>
 */
public final class EventHeader implements org.omg.CORBA.portable.IDLEntity {
  
  /**
	 * 
	 */
	private static final long serialVersionUID = 1191491647404567216L;

public org.omg.CosNotification.FixedEventHeader fixed_header;
  
  public org.omg.CosNotification.Property[] variable_header;

  public EventHeader () {
  }

  public EventHeader (final org.omg.CosNotification.FixedEventHeader fixed_header, 
                      final org.omg.CosNotification.Property[] variable_header) {
    this.fixed_header = fixed_header;
    this.variable_header = variable_header;
  }

}
