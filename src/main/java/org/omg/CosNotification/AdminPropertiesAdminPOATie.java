
package org.omg.CosNotification;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotification.idl"
 * <li> <b>IDL Name</b>      ::CosNotification::AdminPropertiesAdmin
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotification/AdminPropertiesAdmin:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface AdminPropertiesAdmin {
  ...
};
 * </pre>
 */
public class AdminPropertiesAdminPOATie extends AdminPropertiesAdminPOA {
  private org.omg.CosNotification.AdminPropertiesAdminOperations _delegate;
  private org.omg.PortableServer.POA _poa;

  public AdminPropertiesAdminPOATie (final org.omg.CosNotification.AdminPropertiesAdminOperations _delegate) {
    this._delegate = _delegate;
  }

  public AdminPropertiesAdminPOATie (final org.omg.CosNotification.AdminPropertiesAdminOperations _delegate, 
                              final org.omg.PortableServer.POA _poa) {
    this._delegate = _delegate;
    this._poa = _poa;
  }

  public org.omg.CosNotification.AdminPropertiesAdminOperations _delegate () {
    return this._delegate;
  }

  public void _delegate (final org.omg.CosNotification.AdminPropertiesAdminOperations the_delegate) {
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
   *   void set_admin (in org.omg.CosNotification.AdminProperties admin)
    raises (org.omg.CosNotification.UnsupportedAdmin);
   * </pre>
   */
  public void set_admin (org.omg.CosNotification.Property[] admin) throws  org.omg.CosNotification.UnsupportedAdmin {
    this._delegate.set_admin(admin);
  }

  /**
   * <pre>
   *   org.omg.CosNotification.AdminProperties get_admin ();
   * </pre>
   */
  public org.omg.CosNotification.Property[] get_admin () {
    return this._delegate.get_admin();
  }

}
