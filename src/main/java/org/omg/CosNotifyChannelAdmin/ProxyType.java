package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::ProxyType
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/ProxyType:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * enum ProxyType {PUSH_ANY, PULL_ANY, PUSH_STRUCTURED, PULL_STRUCTURED,
                PUSH_SEQUENCE, PULL_SEQUENCE, PUSH_TYPED, PULL_TYPED};
 * </pre>
 */
public final class ProxyType implements org.omg.CORBA.portable.IDLEntity {
  /**
	 * 
	 */
	private static final long serialVersionUID = -4928617838503895965L;


private /* [JDK 1.1.x BUG] final */ int __value;

  
  public static final int _PUSH_ANY = 0;
  
  public static final int _PULL_ANY = 1;
  
  public static final int _PUSH_STRUCTURED = 2;
  
  public static final int _PULL_STRUCTURED = 3;
  
  public static final int _PUSH_SEQUENCE = 4;
  
  public static final int _PULL_SEQUENCE = 5;
  
  public static final int _PUSH_TYPED = 6;
  
  public static final int _PULL_TYPED = 7;

  
  public static final ProxyType PUSH_ANY = new ProxyType(_PUSH_ANY);
  
  public static final ProxyType PULL_ANY = new ProxyType(_PULL_ANY);
  
  public static final ProxyType PUSH_STRUCTURED = new ProxyType(_PUSH_STRUCTURED);
  
  public static final ProxyType PULL_STRUCTURED = new ProxyType(_PULL_STRUCTURED);
  
  public static final ProxyType PUSH_SEQUENCE = new ProxyType(_PUSH_SEQUENCE);
  
  public static final ProxyType PULL_SEQUENCE = new ProxyType(_PULL_SEQUENCE);
  
  public static final ProxyType PUSH_TYPED = new ProxyType(_PUSH_TYPED);
  
  public static final ProxyType PULL_TYPED = new ProxyType(_PULL_TYPED);

  protected ProxyType (final int _vis_value) {
    this.__value = _vis_value;
  }

  public int value () {
    return __value;
  }

  public static ProxyType from_int (final int _vis_value) {
    switch (_vis_value) {
      case 0: return PUSH_ANY;
      case 1: return PULL_ANY;
      case 2: return PUSH_STRUCTURED;
      case 3: return PULL_STRUCTURED;
      case 4: return PUSH_SEQUENCE;
      case 5: return PULL_SEQUENCE;
      case 6: return PUSH_TYPED;
      case 7: return PULL_TYPED;
      default: throw new org.omg.CORBA.BAD_PARAM();
    }
  }

}
