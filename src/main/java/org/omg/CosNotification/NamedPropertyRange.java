package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::NamedPropertyRange
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/NamedPropertyRange:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct NamedPropertyRange {
  ...
};
 * </pre>
 */
public final class NamedPropertyRange implements org.omg.CORBA.portable.IDLEntity {
  
  /**
	 * 
	 */
	private static final long serialVersionUID = -7571639997038149131L;

public java.lang.String name;
  
  public org.omg.CosNotification.PropertyRange range;

  public NamedPropertyRange () {
    name = "";
  }

  public NamedPropertyRange (final java.lang.String name, 
                             final org.omg.CosNotification.PropertyRange range) {
    this.name = name;
    this.range = range;
  }

}
