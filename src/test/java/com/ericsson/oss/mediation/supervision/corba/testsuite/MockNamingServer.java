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

public class MockNamingServer {
	static Process p;

	public static Thread runNamingServer() {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					p = Runtime.getRuntime().exec("orbd ");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		t.start();
		return t;
	}

	public static void stopNamingServer() {
		if (p != null) {
			p.destroy();
		}
	}
}
