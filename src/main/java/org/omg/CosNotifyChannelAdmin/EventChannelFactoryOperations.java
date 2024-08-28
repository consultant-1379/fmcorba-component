package org.omg.CosNotifyChannelAdmin;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "CosNotifyChannelAdmin.idl"
 * <li> <b>IDL Name</b>      ::CosNotifyChannelAdmin::EventChannelFactory
 * <li> <b>Repository Id</b> IDL:omg.org/CosNotifyChannelAdmin/EventChannelFactory:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface EventChannelFactory {
  ...
};
 * </pre>
 */
public interface EventChannelFactoryOperations {
  /**
   * <pre>
   *   org.omg.CosNotifyChannelAdmin.EventChannel get_event_channel (in org.omg.CosNotifyChannelAdmin.ChannelID id)
    raises (org.omg.CosNotifyChannelAdmin.ChannelNotFound);
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.EventChannel get_event_channel (int id) throws org.omg.CosNotifyChannelAdmin.ChannelNotFound;

  /**
   * <pre>
   *   org.omg.CosNotifyChannelAdmin.ChannelIDSeq get_all_channels ();
   * </pre>
   */
  public int[] get_all_channels ();

  /**
   * <pre>
   *   org.omg.CosNotifyChannelAdmin.EventChannel create_channel (in org.omg.CosNotification.QoSProperties initial_qos,
                                                             in org.omg.CosNotification.AdminProperties initial_admin,
                                                             out org.omg.CosNotifyChannelAdmin.ChannelID id)
    raises (org.omg.CosNotification.UnsupportedQoS,
            org.omg.CosNotification.UnsupportedAdmin);
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.EventChannel create_channel (org.omg.CosNotification.Property[] initial_qos, 
                                                                    org.omg.CosNotification.Property[] initial_admin, 
                                                                    org.omg.CORBA.IntHolder id) throws org.omg.CosNotification.UnsupportedQoS, 
                                                                                                       org.omg.CosNotification.UnsupportedAdmin;

}
