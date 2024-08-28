package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::PropertyRange
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/PropertyRange:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct PropertyRange {
  ...
};
 * </pre>
 */
public final class PropertyRange implements org.omg.CORBA.portable.IDLEntity {
  
  /**
	 * 
	 */
	private static final long serialVersionUID = 6255604880420631694L;

public org.omg.CORBA.Any low_val;
  
  public org.omg.CORBA.Any high_val;

  public PropertyRange () {
  }

  public PropertyRange (final org.omg.CORBA.Any low_val, 
                        final org.omg.CORBA.Any high_val) {
    this.low_val = low_val;
    this.high_val = high_val;
  }

}
