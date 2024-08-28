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
package com.ericsson.oss.mediation.supervision.corba.translation;

import com.ericsson.irp.AlarmIRPConstDefs.*;
import com.ericsson.oss.mediation.translator.model.Constants;

public class AlarmSeverity {
	static public String getSeverity(final short shortSev) {
		String sevString = Constants.SEV_INDETERMINATE;
		switch (shortSev) {
		case PS_INDETERMINATE.value:
			sevString = Constants.SEV_INDETERMINATE;
			break;

		case PS_CRITICAL.value:
			sevString = Constants.SEV_CRITICAL;
			break;

		case PS_MAJOR.value:
			sevString = Constants.SEV_MAJOR;
			break;

		case PS_MINOR.value:
			sevString = Constants.SEV_MINOR;
			break;

		case PS_WARNING.value:
			sevString = Constants.SEV_WARNING;
			break;

		case PS_CLEARED.value:
			sevString = Constants.SEV_CLEARED;
			break;

		default:
			sevString = Constants.SEV_INDETERMINATE;
			break;
		}
		return sevString;
	}
}
