package org.omg.TimeBase;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "TimeBase.idl"
 * <li> <b>IDL Name</b>      ::TimeBase::IntervalT
 * <li> <b>Repository Id</b> IDL:omg.org/TimeBase/IntervalT:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct IntervalT {
  ...
};
 * </pre>
 */
public final class IntervalT implements org.omg.CORBA.portable.IDLEntity {
  
  /**
	 * 
	 */
	private static final long serialVersionUID = -8494194045094770105L;

public long lower_bound;
  
  public long upper_bound;

  public IntervalT () {
  }

  public IntervalT (final long lower_bound, 
                    final long upper_bound) {
    this.lower_bound = lower_bound;
    this.upper_bound = upper_bound;
  }

}
