package model;

import java.util.ArrayList;

import controller.csvRW;

/**
 * Object containing staff username and password. To be used in verification of
 * staff login.
 * 
 * @author Oh Jun Teng
 * @version 1.0
 * @since 2019-11-13
 *
 */
public class Staff {
	/**
	 * Username of staff account
	 */
	private String username;
	/**
	 * Password of staff account
	 */
	private String password;

	/**
	 * Contructor for <code>Staff</code> class.
	 * @param username Username of staff account
	 * @param password Password of staff account
	 */
	public Staff(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	/**
	 * Gets username of staff account
	 * @return username of staff account
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Changes username of staff account
	 * @param username New username for staff account
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets password of staff account
	 * @return Password of staff account
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Changes password of staff account
	 * @param password New password of staff account
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Saves <code>Staff</code> object into database
	 * @param staff <code>Staff</code> object to be saved.
	 * @see csvRW#writeToCSV(String, ArrayList)
	 */
	public void addStaffToCSV(Staff staff) {
		ArrayList<String> data = new ArrayList<String>();
		data.add(staff.username);
		data.add(staff.password);
		csvRW.writeToCSV("staffdatabase", data);
	}
}
