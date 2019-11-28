package BasicEntities;

import java.util.Calendar;

public class RegisteredUser {

	private int userid;
	private String username;
	private String password;
	private String email;
	private Calendar registeredTime;

	public int getUserid() {
		return this.userid;
	}

	/**
	 * 
	 * @param re_userid
	 */
	public void setUserid(int re_userid) {
		this.userid = re_userid;
	}

	public String getUsername() {
		return this.username;
	}

	/**
	 * 
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public Calendar getRegisteredTime() {
		return this.registeredTime;
	}

	/**
	 * 
	 * @param registeredTime
	 */
	public void setRegisteredTime(Calendar registeredTime) {
		this.registeredTime = registeredTime;
	}

}