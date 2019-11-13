package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.CinemaController;
import controller.ShowtimeController;
import controller.csvRW;

/**
 * Main boundary class between the user and the rest of the application.
 * Responsible for console display of menu options for the user. Calls
 * <code>UserDisplayPage</code> and <code>StaffDisplayPage</code> for menu
 * options for the respective modules.
 * 
 * @author Lim Wai Leong
 * @author Oh Jun Teng
 * @author Edhie Wahidin Michelle
 * @author Myat Hmu Khin
 * @version 1.0
 * @since 2019-11-13
 * @see DisplayUserPage
 * @see DisplayStaffPage
 *
 */
public class MainDisplayPage {

	/**
	 * Display of starting menu options when the program is started
	 * 
	 * @param args <code>main()</code> function
	 */
	public static void main(String[] args) {
		CinemaController.createCineplexAndCinemas();
		ShowtimeController.createShowtimes();
		DisplayUserPage UP = new DisplayUserPage();
		DisplayStaffPage SP = new DisplayStaffPage();
		boolean loop = true;
		while (loop) {
			Scanner sc = new Scanner(System.in);
			System.out.println("---------------Welcome to MOBLIMA--------------");
			System.out.println("Enter (1) for access to user page");
			System.out.println("Enter (2) for access to staff page");
			System.out.println("Enter (3) to exit");
			int input;
			while (true) {
				if (sc.hasNextInt()) {
					input = sc.nextInt();
					if (input >= 1 && input < 4) {
						break;
					}
				} else {
					sc.next();
				}
				System.out.println("Invalid Input. Please enter 1 or 2 or 3: ");
			}
//		    sc.close();
			switch (input) {
			case 1:
				UP.menu();
				break;
			case 2:
				if (loginVerification())
					SP.menu();
				else {
					System.out.println("Login failed");
				}
				break;
			case 3:
				loop = false;
				break;
			}
		}
	}

	/**
	 * Verifies login for staff into staff module
	 * 
	 * @return <code>true</code> if login is verified <br>
	 *         <code>false</code> if not verified
	 */
	public static boolean loginVerification() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Enter username:");
			String user = sc.next();
			System.out.println("Enter password:");
			String password = sc.next();
			if (csvRW.search("staffdatabase", "Username", user) == null) {
				System.out.println("Invalid username");
				return false;
			}
			ArrayList<String> staffDetails = new ArrayList<String>(csvRW.search("staffdatabase", "Username", user));
			if (staffDetails.get(1).contentEquals(password)) {
				System.out.println("Login successful");
				return true;
			} else {
				System.out.println("Invalid password");
				return false;
			}
		}

	}

}
