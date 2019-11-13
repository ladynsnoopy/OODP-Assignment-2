package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import model.Calendar;
import model.Cinema;
import model.Cineplex;
import model.Movie;
import model.Price;
import model.Showtime;
import model.Staff;
import view.DisplayStaffPage;
import view.DisplayUserPage;

/**
 * A control class that will handle methods relating to the staff module. It
 * will manage and control objects that are necessary to allow the staff to
 * login, create/update/remove movie listing, create/update/remove cinema
 * showtimes and the movies to be shown, and configure system settings.
 * 
 * @author Lim Wai Leong
 * @author Oh Jun Teng
 * @version 1.0
 * @since 2019-11-13
 *
 *
 */
public class StaffController implements DisplayStaffPage, DisplayUserPage {

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




}