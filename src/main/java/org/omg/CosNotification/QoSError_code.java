package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::QoSError_code
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/QoSError_code:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * enum QoSError_code {UNSUPPORTED_PROPERTY, UNAVAILABLE_PROPERTY,
                    UNSUPPORTED_VALUE, UNAVAILABLE_VALUE, BAD_PROPERTY,
                    BAD_TYPE, BAD_VALUE};
 * </pre>
 */
public final class QoSError_code implements org.omg.CORBA.portable.IDLEntity {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


private /* [JDK 1.1.x BUG] final */ int __value;

  
  public static final int _UNSUPPORTED_PROPERTY = 0;
  
  public static final int _UNAVAILABLE_PROPERTY = 1;
  
  public static final int _UNSUPPORTED_VALUE = 2;
  
  public static final int _UNAVAILABLE_VALUE = 3;
  
  public static final int _BAD_PROPERTY = 4;
  
  public static final int _BAD_TYPE = 5;
  
  public static final int _BAD_VALUE = 6;

  
  public static final QoSError_code UNSUPPORTED_PROPERTY = new QoSError_code(_UNSUPPORTED_PROPERTY);
  
  public static final QoSError_code UNAVAILABLE_PROPERTY = new QoSError_code(_UNAVAILABLE_PROPERTY);
  
  public static final QoSError_code UNSUPPORTED_VALUE = new QoSError_code(_UNSUPPORTED_VALUE);
  
  public static final QoSError_code UNAVAILABLE_VALUE = new QoSError_code(_UNAVAILABLE_VALUE);
  
  public static final QoSError_code BAD_PROPERTY = new QoSError_code(_BAD_PROPERTY);
  
  public static final QoSError_code BAD_TYPE = new QoSError_code(_BAD_TYPE);
  
  public static final QoSError_code BAD_VALUE = new QoSError_code(_BAD_VALUE);

  protected QoSError_code (final int _vis_value) {
    this.__value = _vis_value;
  }

  public int value () {
    return __value;
  }

  public static QoSError_code from_int (final int _vis_value) {
    switch (_vis_value) {
      case 0: return UNSUPPORTED_PROPERTY;
      case 1: return UNAVAILABLE_PROPERTY;
      case 2: return UNSUPPORTED_VALUE;
      case 3: return UNAVAILABLE_VALUE;
      case 4: return BAD_PROPERTY;
      case 5: return BAD_TYPE;
      case 6: return BAD_VALUE;
      default: throw new org.omg.CORBA.BAD_PARAM();
    }
  }

}
