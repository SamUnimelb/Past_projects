package BasicEntities;

public class LeadTo {

	private int processID;
	private int diseaseID;

	public int getProcessID() {
		return this.processID;
	}

	/**
	 * 
	 * @param processID
	 */
	public void setProcessID(int processID) {
		this.processID = processID;
	}

	public int getDiseaseID() {
		return this.diseaseID;
	}

	/**
	 * 
	 * @param diseaseID
	 */
	public void setDiseaseID(int diseaseID) {
		this.diseaseID = diseaseID;
	}

}