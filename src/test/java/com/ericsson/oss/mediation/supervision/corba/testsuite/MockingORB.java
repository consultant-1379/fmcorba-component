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

import org.jacorb.orb.ORB;
public class MockingORB {
	public static void runORB(final ORB orb) {
		Thread t = new Thread(new Runnable()
    	{
			@Override
			public void run() {
				orb.run();
				
			}
		});

    	t.start();		
	}
}
