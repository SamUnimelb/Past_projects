package BasicEntities;

public class Qualified {

	private int foodDrinkID;
	private int expertID;
	private int vendorID;
	private boolean status;

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

	public int getExpertID() {
		return this.expertID;
	}

	/**
	 * 
	 * @param expertID
	 */
	public void setExpertID(int expertID) {
		this.expertID = expertID;
	}

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

	public boolean getStatus() {
		return this.status;
	}

	/**
	 * 
	 * @param status
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

}