package org.omg.TimeBase;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "TimeBase.idl"
 * <li> <b>IDL Name</b>      ::TimeBase::UtcT
 * <li> <b>Repository Id</b> IDL:omg.org/TimeBase/UtcT:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct UtcT {
  ...
};
 * </pre>
 */
public final class UtcT implements org.omg.CORBA.portable.IDLEntity {
  
  /**
	 * 
	 */
	private static final long serialVersionUID = 9021678054497174234L;

public long time;
  
  public int inacclo;
  
  public short inacchi;
  
  public short tdf;

  public UtcT () {
  }

  public UtcT (final long time, 
               final int inacclo, 
               final short inacchi, 
               final short tdf) {
    this.time = time;
    this.inacclo = inacclo;
    this.inacchi = inacchi;
    this.tdf = tdf;
  }

}
