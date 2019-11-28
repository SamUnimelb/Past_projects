package BasicEntities;

public class Process {

	private int processID;
	private String processName;
	private String processChineseName;
	private String processDescrip;
	private String processChineseDescrip;

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

	public String getProcessName() {
		return this.processName;
	}

	/**
	 * 
	 * @param processName
	 */
	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getProcessChineseName() {
		return this.processChineseName;
	}

	/**
	 * 
	 * @param processChineseName
	 */
	public void setProcessChineseName(String processChineseName) {
		this.processChineseName = processChineseName;
	}

	public String getProcessDescrip() {
		return this.processDescrip;
	}

	/**
	 * 
	 * @param processDescrip
	 */
	public void setProcessDescrip(String processDescrip) {
		this.processDescrip = processDescrip;
	}

	public String getProcessChineseDescrip() {
		return this.processChineseDescrip;
	}

	/**
	 * 
	 * @param processChineseDescrip
	 */
	public void setProcessChineseDescrip(String processChineseDescrip) {
		this.processChineseDescrip = processChineseDescrip;
	}

}