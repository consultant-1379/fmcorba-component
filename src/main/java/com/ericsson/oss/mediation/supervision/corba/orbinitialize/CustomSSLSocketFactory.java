package com.ericsson.oss.mediation.supervision.corba.orbinitialize;

import java.io.IOException;
import java.net.*;
import java.security.KeyStore;
import java.util.List;

import javax.net.SocketFactory;
import javax.net.ssl.*;

import org.jacorb.config.Configuration;
import org.jacorb.config.ConfigurationException;
import org.jacorb.orb.ORB;
import org.jacorb.orb.factory.AbstractSocketFactory;
import org.jacorb.orb.listener.SSLHandshakeListener;
import org.jacorb.orb.listener.SSLSessionListener;
import org.jacorb.security.ssl.sun_jsse.JSSEUtil;
import org.jacorb.security.ssl.sun_jsse.KeyStoreUtil;

public class CustomSSLSocketFactory
    extends AbstractSocketFactory
{
    private SocketFactory factory = null;
    private String[] cipher_suites = null;
    private String[] enabledProtocols = null;
    private TrustManager trustManager = null;

    private boolean trusteesFromKS = false;
    private short clientSupportedOptions = 0;
    private String keystore_location = null;
    private String keystore_passphrase = null;
    private final SSLSessionListener sslListener;
    private CustomSSLRandom sslRandom;

    public CustomSSLSocketFactory(ORB orb)
    {
         sslListener = orb.getTransportManager().getSocketFactoryManager().getSSLListener();
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public void configure(Configuration configuration)
        throws ConfigurationException
    {
        super.configure(configuration);

        final org.jacorb.config.Configuration config = (org.jacorb.config.Configuration) configuration;

        sslRandom = new CustomSSLRandom();
        sslRandom.configure(configuration);

        trusteesFromKS =
            configuration.getAttributeAsBoolean("jacorb.security.jsse.trustees_from_ks", false);

        keystore_location =
            configuration.getAttribute("jacorb.security.keystore", "UNSET");

        keystore_passphrase =
            configuration.getAttribute("jacorb.security.keystore_password", "UNSET");

        clientSupportedOptions =
            Short.parseShort(
                configuration.getAttribute("jacorb.security.ssl.client.supported_options", "0"),
                16);
        try
        {
            trustManager = (TrustManager) ((org.jacorb.config.Configuration)configuration).getAttributeAsObject
                                            ("jacorb.security.ssl.client.trust_manager");
        }
        catch (ConfigurationException e)
        {
            if (logger.isErrorEnabled())
            {
                logger.error("TrustManager object creation failed. Please check value of property "
                             + "'jacorb.security.ssl.client.trust_manager'. Current value: "
                             + configuration.getAttribute("jacorb.security.ssl.client.trust_manager", ""), e);
            }
        }

        if (JSSEUtil.isJDK14() && configuration.getAttribute("jacorb.security.ssl.client.protocols", null) != null)
        {
            enabledProtocols = (String[]) ((org.jacorb.config.Configuration)configuration).getAttributeList
                                            ("jacorb.security.ssl.client.protocols").toArray();
            if (logger.isDebugEnabled())
            {
                logger.debug("Setting user specified client enabled protocols : " +
                             configuration.getAttribute("jacorb.security.ssl.client.protocols", ""));
            }
        }

        try
        {
            factory = createSocketFactory();
        }
        catch( Exception e )
        {
            logger.error("Unable to create SSLSocketFactory!", e);
            throw new ConfigurationException("Unable to create SSLSocketFactory!", e);
        }

        final List cipher_suite_list =
            config.getAttributeList("jacorb.security.ssl.client.cipher_suites");

        cipher_suites = (String[]) cipher_suite_list.toArray(new String[cipher_suite_list.size()]);
    }

    public Socket createSocket( String host,
                                int port )
        throws IOException, UnknownHostException
    {
    	String bindingHost = AddressUtil.getBindingAddress();
        SSLSocket socket = (SSLSocket)factory.createSocket( host, port,InetAddress.getByName(bindingHost),0 );
        initSSLSocket(socket);

        return socket;
    }

    protected Socket doCreateSocket(String host, int port, int timeout) throws IOException
    {
        SSLSocket socket = (SSLSocket)factory.createSocket();
        String bindingHost = AddressUtil.getBindingAddress();
        socket.bind(new InetSocketAddress(bindingHost, 0));
        socket.connect(new InetSocketAddress(host, port), timeout);

        initSSLSocket(socket);

        return socket;
    }

    /**
     * common ssl socket initialization
     * @param socket
     */
    private void initSSLSocket(SSLSocket socket)
    {
        if( cipher_suites.length > 0)
        {
            socket.setEnabledCipherSuites( cipher_suites );
        }

        if (enabledProtocols != null)
        {
            JSSEUtil.setEnabledProtocols(socket, enabledProtocols);
        }

        socket.addHandshakeCompletedListener(new SSLHandshakeListener(logger, sslListener));
    }

    public boolean isSSL( java.net.Socket socket )
    {
        return (socket instanceof SSLSocket);
    }

    private SocketFactory createSocketFactory()
        throws IOException, java.security.GeneralSecurityException
    {
        JSSEUtil.registerSecurityProvider();

        KeyManagerFactory kmf = null;
        KeyStore key_store = null;

        if( trusteesFromKS || ( clientSupportedOptions & 0x40) != 0 )
        {
            key_store =
                KeyStoreUtil.getKeyStore( keystore_location,
                                          keystore_passphrase.toCharArray() );
            if( ( clientSupportedOptions & 0x40) != 0 )
            {
                kmf = KeyManagerFactory.getInstance( "SunX509" );
                kmf.init( key_store, keystore_passphrase.toCharArray() );
            }
        }

        TrustManagerFactory tmf =
            TrustManagerFactory.getInstance( "SunX509" );

        if( key_store != null && trusteesFromKS )
        {
            if (logger.isInfoEnabled())
            {
                logger.info("Loading certs from keystore " + key_store.getType() );
            }
            tmf.init( key_store );
        }
        else
        {
            tmf.init( (KeyStore) null );
        }

        TrustManager[] trustManagers;

        if (trustManager == null)
        {
            trustManagers = tmf.getTrustManagers();
        }
        else
        {
            if (logger.isDebugEnabled())
            {
                logger.debug("Setting user specified client TrustManger : " + trustManager.getClass().getName());
            }
            trustManagers = new TrustManager[] { trustManager };
        }

        SSLContext ctx = SSLContext.getInstance( "TLS" );

        ctx.init( (kmf == null)? null : kmf.getKeyManagers(),
                  trustManagers,
                  sslRandom.getSecureRandom() );

        return ctx.getSocketFactory();
    }
}
