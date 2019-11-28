package BasicEntities;

public class VendorUser {

	private int vendorID;
	private String vUsername;
	private String vPassword;
	private String vName;
	private String vChineseName;
	private String vEmail;

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

	public String getVUsername() {
		return this.vUsername;
	}

	/**
	 * 
	 * @param vUsername
	 */
	public void setVUsername(String vUsername) {
		this.vUsername = vUsername;
	}

	public String getVPassword() {
		return this.vPassword;
	}

	/**
	 * 
	 * @param vPassword
	 */
	public void setVPassword(String vPassword) {
		this.vPassword = vPassword;
	}

	public String getVName() {
		return this.vName;
	}

	/**
	 * 
	 * @param vName
	 */
	public void setVName(String vName) {
		this.vName = vName;
	}

	public String getVChineseName() {
		return this.vChineseName;
	}

	/**
	 * 
	 * @param vChineseName
	 */
	public void setVChineseName(String vChineseName) {
		this.vChineseName = vChineseName;
	}

	public String getVEmail() {
		return this.vEmail;
	}

	/**
	 * 
	 * @param vEmail
	 */
	public void setVEmail(String vEmail) {
		this.vEmail = vEmail;
	}

}