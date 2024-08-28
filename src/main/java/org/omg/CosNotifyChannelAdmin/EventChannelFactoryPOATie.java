
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
public class EventChannelFactoryPOATie extends EventChannelFactoryPOA {
  private org.omg.CosNotifyChannelAdmin.EventChannelFactoryOperations _delegate;
  private org.omg.PortableServer.POA _poa;

  public EventChannelFactoryPOATie (final org.omg.CosNotifyChannelAdmin.EventChannelFactoryOperations _delegate) {
    this._delegate = _delegate;
  }

  public EventChannelFactoryPOATie (final org.omg.CosNotifyChannelAdmin.EventChannelFactoryOperations _delegate, 
                              final org.omg.PortableServer.POA _poa) {
    this._delegate = _delegate;
    this._poa = _poa;
  }

  public org.omg.CosNotifyChannelAdmin.EventChannelFactoryOperations _delegate () {
    return this._delegate;
  }

  public void _delegate (final org.omg.CosNotifyChannelAdmin.EventChannelFactoryOperations the_delegate) {
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
   *   org.omg.CosNotifyChannelAdmin.EventChannel get_event_channel (in org.omg.CosNotifyChannelAdmin.ChannelID id)
    raises (org.omg.CosNotifyChannelAdmin.ChannelNotFound);
   * </pre>
   */
  public org.omg.CosNotifyChannelAdmin.EventChannel get_event_channel (int id) throws  org.omg.CosNotifyChannelAdmin.ChannelNotFound {
    return this._delegate.get_event_channel(id);
  }

  /**
   * <pre>
   *   org.omg.CosNotifyChannelAdmin.ChannelIDSeq get_all_channels ();
   * </pre>
   */
  public int[] get_all_channels () {
    return this._delegate.get_all_channels();
  }

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
                                                                    org.omg.CORBA.IntHolder id) throws  org.omg.CosNotification.UnsupportedQoS, 
                                                                                                        org.omg.CosNotification.UnsupportedAdmin {
    return this._delegate.create_channel(initial_qos, initial_admin, id);
  }

}
