package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::InterFilterGroupOperator
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/InterFilterGroupOperator:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * enum InterFilterGroupOperator {AND_OP, OR_OP};
 * </pre>
 */
public final class InterFilterGroupOperator implements org.omg.CORBA.portable.IDLEntity {
  /**
	 * 
	 */
	private static final long serialVersionUID = 8886146154326549515L;


private /* [JDK 1.1.x BUG] final */ int __value;

  
  public static final int _AND_OP = 0;
  
  public static final int _OR_OP = 1;

  
  public static final InterFilterGroupOperator AND_OP = new InterFilterGroupOperator(_AND_OP);
  
  public static final InterFilterGroupOperator OR_OP = new InterFilterGroupOperator(_OR_OP);

  protected InterFilterGroupOperator (final int _vis_value) {
    this.__value = _vis_value;
  }

  public int value () {
    return __value;
  }

  public static InterFilterGroupOperator from_int (final int _vis_value) {
    switch (_vis_value) {
      case 0: return AND_OP;
      case 1: return OR_OP;
      default: throw new org.omg.CORBA.BAD_PARAM();
    }
  }

}
