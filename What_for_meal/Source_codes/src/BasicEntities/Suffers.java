package BasicEntities;

import java.util.Calendar;

public class Suffers {

	private int rUserID;
	private int diseaseID;
        private Calendar recordTime;

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

        public Calendar getRecordTime(){ return recordTime;}
        
        public void setRecordTime(Calendar recordTime){ this.recordTime = recordTime;}
        
}//end class