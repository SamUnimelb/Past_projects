package BasicEntities;

import java.util.Calendar;

public class Supplies {

	private int vendorID;
	private int foodDrinkID;
	private Calendar producedTime;
	private String storageDuration;
	private int clickingAmount;
	private Calendar expireTime;

	public int getVendorID() {
		return this.vendorID;
	}

	/**
	 * 
	 * @param vendorID
	 */
	public void setVendorID(int vendorID) {
		this.vendorID = vendorID;
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

	public Calendar getProducedTime() {
		return this.producedTime;
	}

	/**
	 * 
	 * @param producedTime
	 */
	public void setProducedTime(Calendar producedTime) {
		this.producedTime = producedTime;
	}

	public String getStorageDuration() {
		return this.storageDuration;
	}

	/**
	 * 
	 * @param storageDuration
	 */
	public String setStorageDuration(String storageDuration) {
		throw new UnsupportedOperationException();
	}

	public int getClickingAmount() {
		return this.clickingAmount;
	}

	/**
	 * 
	 * @param clickingAmount
	 */
	public void setClickingAmount(int clickingAmount) {
		this.clickingAmount = clickingAmount;
	}

	public Calendar getExpireTime() {
		return this.expireTime;
	}

	/**
	 * 
	 * @param expireTime
	 */
	public void setExpireTime(Calendar expireTime) {
		this.expireTime = expireTime;
	}

}