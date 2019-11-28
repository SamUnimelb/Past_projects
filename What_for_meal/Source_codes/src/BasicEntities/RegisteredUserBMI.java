package BasicEntities;

import java.util.Calendar;

public class RegisteredUserBMI {

	private int rUserID;
	private Calendar measuredTime;
	private double height;
	private double weight;

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

	public Calendar getMeasuredTime() {
		return this.measuredTime;
	}

	/**
	 * 
	 * @param measuredTime
	 */
	public void setMeasuredTime(Calendar measuredTime) {
		this.measuredTime = measuredTime;
	}

	public double getHeight() {
		return this.height;
	}

	/**
	 * 
	 * @param height
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return this.weight;
	}

	/**
	 * 
	 * @param weight
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

}