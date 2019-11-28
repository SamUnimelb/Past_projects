package BasicEntities;

import java.util.Calendar;

public class Peforms {

	private int rUserID;
	private int activityID;
	private Calendar startTime;
	private Calendar endTime;

	public int getRUserID() {
		return this.rUserID;
	}

	/**
	 * 
	 * @param rUserID
	 */
	public void setRUserID(int rUserID) {
		this.rUserID = rUserID;
	}

	public int getActivityID() {
		return this.activityID;
	}

	/**
	 * 
	 * @param activityID
	 */
	public void setActivityID(int activityID) {
		this.activityID = activityID;
	}

	public Calendar getStartTime() {
		return this.startTime;
	}

	/**
	 * 
	 * @param startTime
	 */
	public void setStartTime(Calendar startTime) {
            this.startTime = startTime;
	}

	public Calendar getEndTime() {
		return this.endTime;
	}

	/**
	 * 
	 * @param endTime
	 */
	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}

}