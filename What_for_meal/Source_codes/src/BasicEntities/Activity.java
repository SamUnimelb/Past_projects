package BasicEntities;

public class Activity {

	private int activityID;
	private String activityName;
	private String activityChineseName;
	private double kcalPerUnit;

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

	public String getActivityName() {
		return this.activityName;
	}

	/**
	 * 
	 * @param activityName
	 */
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getActivityChineseName() {
		return this.activityChineseName;
	}

	/**
	 * 
	 * @param activityChineseName
	 */
	public void setActivityChineseName(String activityChineseName) {
		this.activityChineseName = activityChineseName;
	}

	public double getKcalPerUnit() {
		return this.kcalPerUnit;
	}

	/**
	 * 
	 * @param kcalPerUnit
	 */
	public void setKcalPerUnit(double kcalPerUnit) {
		this.kcalPerUnit = kcalPerUnit;
	}

}