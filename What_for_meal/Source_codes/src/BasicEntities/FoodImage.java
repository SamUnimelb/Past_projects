package BasicEntities;

import javax.swing.ImageIcon;

public class FoodImage {

	private int foodDrinkID;
	private ImageIcon foodImage;

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

	public ImageIcon getFoodImage() {
		return this.foodImage;
	}

	/**
	 * 
	 * @param foodImage
	 */
	public void setFoodImage(ImageIcon foodImage) {
		this.foodImage = foodImage;
	}

}