package BasicEntities;

public class Conflict {

	private int foodDrinkID1;
	private int foodDrinkID2;
	private String note;
	private String noteInChinese;

	public int getFoodDrinkID1() {
		return this.foodDrinkID1;
	}

	/**
	 * 
	 * @param foodDrink1
	 */
	public void setFoodDrink1(int foodDrinkID1) {
		this.foodDrinkID1 = foodDrinkID1;
	}

	public int getFoodDrink2() {
		return this.foodDrinkID2;
	}

	/**
	 * 
	 * @param foodDrink2
	 */
	public void setFoodDrink2(int foodDrinkID2) {
		this.foodDrinkID2 = foodDrinkID2;
	}

	public String getNote() {
		return this.note;
	}

	/**
	 * 
	 * @param note
	 */
	public void setNote(String note) {
		this.note = note;
	}

	public String getNoteInChinese() {
		return this.noteInChinese;
	}

	/**
	 * 
	 * @param noteInChinese
	 */
	public void setNoteInChinese(String noteInChinese) {
		this.noteInChinese = noteInChinese;
	}

}