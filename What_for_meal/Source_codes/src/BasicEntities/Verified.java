package BasicEntities;

public class Verified {

	private int foodDrinkID;
	private int expertID;
	private int rUserID;
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