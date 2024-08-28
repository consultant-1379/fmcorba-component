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
package com.ericsson.oss.mediation.supervision.corba;


public class NodeSuspenderConfiguration {
	
	private NodeSuspenderConfiguration() {
		this.alarmRateCheckInterval = 5;
		this.alarmRateFlowControl = true;
		this.alarmRateNormalThreshold =250;
		this.alarmRateThreshold = 500;
	}

	/**
	 * The NodeSuspender singleton instance
	 */
	private static final NodeSuspenderConfiguration theInstance = new NodeSuspenderConfiguration();

	private Boolean alarmRateFlowControl;
	private int alarmRateThreshold;
	private int alarmRateNormalThreshold;
	private int alarmRateCheckInterval;
	
	
	/**
	 * Alarm rate flow control. Boolean. 
	 *  default is true.
	 */
	public static final String PARAM_ALARM_RATE_FLOW_CONTROL = "AlarmRateFlowControl";
	/**
	 * Alarm rate threshold. Integer. Allowed number of alarms within alarm rate check interval.
	 *  default is 500.
	 * @see #PARAM_ALARM_RATE_CHECK_INTERVAL 
	 */
	public static final String PARAM_ALARM_RATE_THRESHOLD = "AlarmRateThreshold";
	/**
	 * Alarm rate normal threshold. Integer. Percentage of alarm rate threshold.
	 *  default is 50 percent.
	 */
	public static final String PARAM_ALARM_RATE_NORMAL_THRESHOLD = "AlarmRateNormalThreshold";
	
	/**
	 * Alarm rate check interval. Integer. Check interval in minutes.
	 *  default is 5 minutes.
	 */
	public static final String PARAM_ALARM_RATE_CHECK_INTERVAL = "AlarmRateCheckInterval";
	
	/**
     * Returns the NodeSuspender singleton instance.
     * @return The NodeSuspender singleton
     */
    public static NodeSuspenderConfiguration getInstance() {
        return theInstance;
    }


	/**
	 * @return the alarmRateFlowControl
	 */
	public Boolean getAlarmRateFlowControl() {
		return alarmRateFlowControl;
	}


	/**
	 * @param alarmRateFlowControl the alarmRateFlowControl to set
	 */
	public void setAlarmRateFlowControl(final boolean alarmRateFlowControl) {
		this.alarmRateFlowControl = alarmRateFlowControl;
	}


	/**
	 * @return the alarmRateThreshold
	 */
	public Integer getAlarmRateThreshold() {
		return alarmRateThreshold;
	}


	/**
	 * @param alarmRateThreshold the alarmRateThreshold to set
	 */
	public void setAlarmRateThreshold(final int alarmRateThreshold) {
		this.alarmRateThreshold = alarmRateThreshold;
	}


	/**
	 * @return the alarmRateNormalThreshold
	 */
	public Integer getAlarmRateNormalThreshold() {
		return alarmRateNormalThreshold;
	}


	/**
	 * @param alarmRateNormalThreshold the alarmRateNormalThreshold to set
	 */
	public void setAlarmRateNormalThreshold(final int percentaghe) {
		final Integer normal = (int) (((double) alarmRateThreshold * (percentaghe / 100.0)) + 0.5);
		this.alarmRateNormalThreshold = normal;
	}


	/**
	 * @return the alarmRateCheckInterval
	 */
	public int getAlarmRateCheckInterval() {
		return alarmRateCheckInterval;
	}


	/**
	 * @param alarmRateCheckInterval the alarmRateCheckInterval to set
	 */
	public void setAlarmRateCheckInterval(final int alarmRateCheckInterval) {
		this.alarmRateCheckInterval = alarmRateCheckInterval;
	}




}
