package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::FixedEventHeader
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/FixedEventHeader:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct FixedEventHeader {
  ...
};
 * </pre>
 */
public final class FixedEventHeader implements org.omg.CORBA.portable.IDLEntity {
  
  /**
	 * 
	 */
	private static final long serialVersionUID = -403033559517540428L;

public org.omg.CosNotification.EventType event_type;
  
  public java.lang.String event_name;

  public FixedEventHeader () {
    event_name = "";
  }

  public FixedEventHeader (final org.omg.CosNotification.EventType event_type, 
                           final java.lang.String event_name) {
    this.event_type = event_type;
    this.event_name = event_name;
  }

}
