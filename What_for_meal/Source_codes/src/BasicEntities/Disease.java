package BasicEntities;

public class Disease {

	private int idDisease;
	private String diseaseName;
	private String diseaseChineseName;
	private String diseaseDescription;
	private String diseaseChineseDescrip;
	private int seriousLevel;

	public int getIdDisease() {
		return this.idDisease;
	}

	/**
	 * 
	 * @param idDisease
	 */
	public void setIdDisease(int idDisease) {
		this.idDisease = idDisease;
	}

	public String getDiseaseName() {
		return this.diseaseName;
	}

	/**
	 * 
	 * @param diseaseName
	 */
	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}

	public String getDiseaseChineseName() {
		return this.diseaseChineseName;
	}

	/**
	 * 
	 * @param diseaseChineseName
	 */
	public void setDiseaseChineseName(String diseaseChineseName) {
		this.diseaseChineseName = diseaseChineseName;
	}

	public String getDiseaseDescription() {
		return this.diseaseDescription;
	}

	/**
	 * 
	 * @param diseaseDescription
	 */
	public void setDiseaseDescription(String diseaseDescription) {
		this.diseaseDescription = diseaseDescription;
	}

	public String getDiseaseChineseDescrip() {
		return this.diseaseChineseDescrip;
	}

	/**
	 * 
	 * @param diseaseChineseDescrip
	 */
	public void setDiseaseChineseDescrip(String diseaseChineseDescrip) {
		this.diseaseChineseDescrip = diseaseChineseDescrip;
	}

	public int getSeriousLevel() {
		return this.seriousLevel;
	}

	/**
	 * 
	 * @param seriousLevel
	 */
	public void setSeriousLevel(int seriousLevel) {
		this.seriousLevel = seriousLevel;
	}

}