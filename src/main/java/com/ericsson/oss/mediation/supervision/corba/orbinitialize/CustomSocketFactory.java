package com.ericsson.oss.mediation.supervision.corba.orbinitialize;

import java.io.IOException;
import java.net.*;

import org.jacorb.orb.factory.DefaultSocketFactory;


public class CustomSocketFactory  extends DefaultSocketFactory
{
    public Socket createSocket (String host, int port)
        throws IOException, UnknownHostException
    {
    	String bindingHost = AddressUtil.getBindingAddress();
    	final Socket socket = new Socket(host,port,InetAddress.getByName(bindingHost),0);
        return socket;
    }

    protected Socket doCreateSocket(String host, int port, int timeout) throws IOException, UnknownHostException
    {
    	
    	String bindingHost = AddressUtil.getBindingAddress();
    	final Socket socket = new Socket();
    	socket.bind(new InetSocketAddress(bindingHost, 0));
        socket.connect(new InetSocketAddress(host, port), timeout);
        return socket;
    }

    public boolean isSSL(Socket socket)
    {
        return false;
    }
}
