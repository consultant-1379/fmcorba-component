package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::ObtainInfoMode
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/ObtainInfoMode:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * enum ObtainInfoMode {ALL_NOW_UPDATES_OFF, ALL_NOW_UPDATES_ON,
                     NONE_NOW_UPDATES_OFF, NONE_NOW_UPDATES_ON};
 * </pre>
 */
public final class ObtainInfoMode implements org.omg.CORBA.portable.IDLEntity {
  /**
	 * 
	 */
	private static final long serialVersionUID = -4474008650595010192L;


private /* [JDK 1.1.x BUG] final */ int __value;

  
  public static final int _ALL_NOW_UPDATES_OFF = 0;
  
  public static final int _ALL_NOW_UPDATES_ON = 1;
  
  public static final int _NONE_NOW_UPDATES_OFF = 2;
  
  public static final int _NONE_NOW_UPDATES_ON = 3;

  
  public static final ObtainInfoMode ALL_NOW_UPDATES_OFF = new ObtainInfoMode(_ALL_NOW_UPDATES_OFF);
  
  public static final ObtainInfoMode ALL_NOW_UPDATES_ON = new ObtainInfoMode(_ALL_NOW_UPDATES_ON);
  
  public static final ObtainInfoMode NONE_NOW_UPDATES_OFF = new ObtainInfoMode(_NONE_NOW_UPDATES_OFF);
  
  public static final ObtainInfoMode NONE_NOW_UPDATES_ON = new ObtainInfoMode(_NONE_NOW_UPDATES_ON);

  protected ObtainInfoMode (final int _vis_value) {
    this.__value = _vis_value;
  }

  public int value () {
    return __value;
  }

  public static ObtainInfoMode from_int (final int _vis_value) {
    switch (_vis_value) {
      case 0: return ALL_NOW_UPDATES_OFF;
      case 1: return ALL_NOW_UPDATES_ON;
      case 2: return NONE_NOW_UPDATES_OFF;
      case 3: return NONE_NOW_UPDATES_ON;
      default: throw new org.omg.CORBA.BAD_PARAM();
    }
  }

}
