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
public interface AdminPropertiesAdminOperations {
  /**
   * <pre>
   *   void set_admin (in org.omg.CosNotification.AdminProperties admin)
    raises (org.omg.CosNotification.UnsupportedAdmin);
   * </pre>
   */
  public void set_admin (org.omg.CosNotification.Property[] admin) throws org.omg.CosNotification.UnsupportedAdmin;

  /**
   * <pre>
   *   org.omg.CosNotification.AdminProperties get_admin ();
   * </pre>
   */
  public org.omg.CosNotification.Property[] get_admin ();

}
