/*------------------------------------------------------------------------------
 *******************************************************************************
 * COPYRIGHT Ericsson 2012
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *******************************************************************************
 *----------------------------------------------------------------------------*/
package com.ericsson.oss.mediation.supervision.corba.testsuite;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import org.jboss.com.sun.net.httpserver.*;

public class MockHttpHandler implements HttpHandler {
	static public String iorString;
	private HttpServer server;

	public void handle(final HttpExchange t) throws IOException {
		String response = iorString;
		t.sendResponseHeaders(200, response.length());
		OutputStream os = t.getResponseBody();
		os.write(response.getBytes());
		os.close();
	}

	public void startHttpServer(final int port) {
		try {
			server = HttpServer.create(new InetSocketAddress(port), 0);
			server.createContext("/cello/ior_files/nameroot.ior", this);
			server.setExecutor(null); // creates a default executor
			server.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void stopHttpServer() {
		server.stop(0);
	}

}
