
package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::QoSAdmin
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/QoSAdmin:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface QoSAdmin {
  ...
};
 * </pre>
 */
public class QoSAdminPOATie extends QoSAdminPOA {
  private org.omg.CosNotification.QoSAdminOperations _delegate;
  private org.omg.PortableServer.POA _poa;

  public QoSAdminPOATie (final org.omg.CosNotification.QoSAdminOperations _delegate) {
    this._delegate = _delegate;
  }

  public QoSAdminPOATie (final org.omg.CosNotification.QoSAdminOperations _delegate, 
                              final org.omg.PortableServer.POA _poa) {
    this._delegate = _delegate;
    this._poa = _poa;
  }

  public org.omg.CosNotification.QoSAdminOperations _delegate () {
    return this._delegate;
  }

  public void _delegate (final org.omg.CosNotification.QoSAdminOperations the_delegate) {
    this._delegate = the_delegate;
  }

  public org.omg.PortableServer.POA _default_POA () {
    if (_poa != null) {
      return _poa;
    } 
    else {
      return super._default_POA();
    }
  }

  /**
   * <pre>
   *   void validate_qos (in org.omg.CosNotification.QoSProperties required_qos,
                     out org.omg.CosNotification.NamedPropertyRangeSeq available_qos)
    raises (org.omg.CosNotification.UnsupportedQoS);
   * </pre>
   */
  public void validate_qos (org.omg.CosNotification.Property[] required_qos, 
                            org.omg.CosNotification.NamedPropertyRangeSeqHolder available_qos) throws  org.omg.CosNotification.UnsupportedQoS {
    this._delegate.validate_qos(required_qos, available_qos);
  }

  /**
   * <pre>
   *   void set_qos (in org.omg.CosNotification.QoSProperties qos)
    raises (org.omg.CosNotification.UnsupportedQoS);
   * </pre>
   */
  public void set_qos (org.omg.CosNotification.Property[] qos) throws  org.omg.CosNotification.UnsupportedQoS {
    this._delegate.set_qos(qos);
  }

  /**
   * <pre>
   *   org.omg.CosNotification.QoSProperties get_qos ();
   * </pre>
   */
  public org.omg.CosNotification.Property[] get_qos () {
    return this._delegate.get_qos();
  }

}
