package BasicEntities;

import java.util.Calendar;

public class ActualDiet {

	private int userID;
	private int foodDrinkID;
	private Calendar timeAte;
	private double unitAmount;
	private int measurementID;
	private String measurementUnit;

	public int getUserID() {
		return this.userID;
	}

	/**
	 * 
	 * @param userID
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getFoodDrinkID() {
		return this.foodDrinkID;
	}

	/**
	 * 
	 * @param fooddrinkID
	 */
	public void setFoodDrinkID(int fooddrinkID) {
		this.foodDrinkID = fooddrinkID;
	}

	public Calendar getTimeAte() {
		return this.timeAte;
	}

	/**
	 * 
	 * @param timeAte
	 */
	public void setTimeAte(Calendar timeAte) {
		this.timeAte = timeAte;
	}

	public double getUnitAmount() {
		return this.unitAmount;
	}

	/**
	 * 
	 * @param unitAmount
	 */
	public void setUnitAmount(double unitAmount) {
		this.unitAmount = unitAmount;
	}

	public String getMeasurementUnit() {
		return this.measurementUnit;
	}

	/**
	 * 
	 * @param measurementUnit
	 */
	public void setMeasurementUnit(String measurementUnit) {
		this.measurementUnit = measurementUnit;
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

}