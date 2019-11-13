package controller;


import java.util.ArrayList;

import model.Staff;
import view.DisplayStaffPage;
import view.DisplayUserPage;

/**
 * A control class that will handle methods relating to the staff model. 
 * Contains methods that verify login and create new staff objects
 * 
 * 
 * @author Lim Wai Leong
 * @author Oh Jun Teng
 * @author Edhie Wahidin Michelle
 * @author Myat Hmu Khin
 * @version 1.0
 * @since 2019-11-13
 * @see Staff
 *
 */
public class StaffController {

	/**
	 * Creates a staff account so staff can login and saves login info to
	 * staffdatabase.
	 * 
	 * @param username Username of staff
	 * @param password Password of staff
	 */
	public static void createStaff(String username, String password) {
		Staff a = new Staff(username, password);
		a.addStaffToCSV(a);
	}

	/**
	 * Checks login information against staffdatabase.
	 * 
	 * @param username Username of staff
	 * @param password Password of staff
	 * @return 0 if all information matches. Returns -1 if password does not match.
	 *         Returns -2 if no such username exists.
	 */
	public static int login(String username, String password) {
		ArrayList<String[]> list = csvRW.readCSV("staffdatabase");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i)[0].equals(username)) {
				if (list.get(i)[1].equals(password)) {
					return 0;
				} else
					return -1; // if password does not match
			}
		}
		return -2; // if no such username exists
	}



}