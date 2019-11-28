package BasicEntities;

import java.util.Calendar;

public class RecommendDiet {

	private int rUserID;
	private int foodDrinkID;
	private Calendar recommendTime;
	private int measurementID;
	private int unitAmount;

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

	public int getFoodDrinkID() {
		return this.foodDrinkID;
	}

	/**
	 * 
	 * @param foodDrinkID
	 */
	public void setFoodDrinkID(int foodDrinkID) {
		this.foodDrinkID = foodDrinkID;
	}

	public Calendar getRecommendTime() {
		return this.recommendTime;
	}

	/**
	 * 
	 * @param recommendTime
	 */
	public void setRecommendTime(Calendar recommendTime) {
		this.recommendTime = recommendTime;
	}

	public int getMeasurementID() {
		return this.measurementID;
	}

	/**
	 * 
	 * @param measurementID
	 */
	public void setMeasurementID(int measurementID) {
		this.measurementID = measurementID;
	}

	public int getUnitAmount() {
		return this.unitAmount;
	}

	/**
	 * 
	 * @param unitAmount
	 */
	public void setUnitAmount(int unitAmount) {
		this.unitAmount = unitAmount;
	}

}