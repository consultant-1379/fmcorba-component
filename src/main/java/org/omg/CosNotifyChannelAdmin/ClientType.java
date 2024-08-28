package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::ClientType
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/ClientType:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * enum ClientType {ANY_EVENT, STRUCTURED_EVENT, SEQUENCE_EVENT};
 * </pre>
 */
public final class ClientType implements org.omg.CORBA.portable.IDLEntity {
  /**
	 * 
	 */
	private static final long serialVersionUID = 7271461024610102292L;


private /* [JDK 1.1.x BUG] final */ int __value;

  
  public static final int _ANY_EVENT = 0;
  
  public static final int _STRUCTURED_EVENT = 1;
  
  public static final int _SEQUENCE_EVENT = 2;

  
  public static final ClientType ANY_EVENT = new ClientType(_ANY_EVENT);
  
  public static final ClientType STRUCTURED_EVENT = new ClientType(_STRUCTURED_EVENT);
  
  public static final ClientType SEQUENCE_EVENT = new ClientType(_SEQUENCE_EVENT);

  protected ClientType (final int _vis_value) {
    this.__value = _vis_value;
  }

  public int value () {
    return __value;
  }

  public static ClientType from_int (final int _vis_value) {
    switch (_vis_value) {
      case 0: return ANY_EVENT;
      case 1: return STRUCTURED_EVENT;
      case 2: return SEQUENCE_EVENT;
      default: throw new org.omg.CORBA.BAD_PARAM();
    }
  }

}
