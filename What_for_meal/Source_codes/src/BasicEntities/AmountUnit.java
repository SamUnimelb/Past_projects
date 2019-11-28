package BasicEntities;

public class AmountUnit {

	private int measurementID;
	private String measurementName;
	private String measurementChineseName;
	private double measureAmount;

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

	public String getMeasurementName() {
		return this.measurementName;
	}

	/**
	 * 
	 * @param measurementName
	 */
	public void setMeasurementName(String measurementName) {
		this.measurementName = measurementName;
	}

	public String getMeasurementChineseName() {
		return this.measurementChineseName;
	}

	/**
	 * 
	 * @param measurementChineseName
	 */
	public void setMeasurementChineseName(String measurementChineseName) {
		this.measurementChineseName = measurementChineseName;
	}

	public double getMeasureAmount() {
		return this.measureAmount;
	}

	/**
	 * 
	 * @param measureAmount
	 */
	public void setMeasureAmount(double measureAmount) {
		this.measureAmount = measureAmount;
	}

}