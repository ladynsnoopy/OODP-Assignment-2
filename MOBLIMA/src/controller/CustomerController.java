package controller;

import java.util.ArrayList;

import model.Customer;
import view.DisplayUserPage;

/**
 * A control class that will handle methods relating to the customer model.
 * Contains methods that create and handle the customer object and it's attributes. 
 * 
 * @author Myat Hmu Khin
 * @author Lim Wai Leong
 * @version 1.0
 * @since 2019-11-10
 *
 */

public class CustomerController implements DisplayUserPage {
	/**
	 * Creates a new customer object
	 * 
	 * @param name      Name of customer
	 * @param mobileNum Mobile Number of a customer
	 * @param email     Email of a customer
	 * @see Customer
	 */

	public static void createCustomer(String name, String mobileNum, String email) {
		Customer a = new Customer(name, mobileNum, email);
		a.addCustomerToCSV(a);
	}

	/**
	 * Checks if a customer is an existing customer
	 * 
	 * @param email Email of a customer
	 * @return -1 if customer's email is not found in the customer database. Returns
	 *         Customer ID if customer's email is found in the customer database
	 */
	public static int customerExists(String email) {
		if (csvRW.search("customerdatabase", "Email", email) == null)
			return -1;
		else {
			return Integer.parseInt(csvRW.search("customerdatabase", "Email", email).get(0));
		}
	}

	/**
	 * Gets all past booking history of customer, including past TIDs, payment mode,
	 * movie name, total amount paid, when given unique customer ID.
	 * 
	 * @param custID Unique customer ID of customer requesting booking history
	 * @return 2D array of all booking history in format: <br>
	 *         [ [TID, Payment Mode, Movie Name, Total Amount], ...]
	 */
	public static String[][] searchBookingHistory(int custID) {

		ArrayList<String> tids = csvRW.search("customerdatabase", "CustomerID", Integer.toString(custID));
		String a = tids.get(4); // Get all the receipt's TID of the customer
		if (a.length() > 15) {
			a = a.substring(1, a.length() - 1);
			String[] arr = a.split(","); // store the TIDs in a string array
			String[][] result = new String[arr.length][4];
			for (int i = 0; i < arr.length; i++) {
				String[] inside = new String[4];
				ArrayList<String> b = csvRW.search("paymentdatabase", "TID", arr[i].replaceAll("\\s", ""));
				inside[0] = arr[i];
				inside[1] = b.get(1);
				inside[2] = b.get(2);
				inside[3] = b.get(3);
				result[i] = inside; // get timing for each showtimeID and store it into showtimes array
			}
			return result;
		} else if (a.length() == 15) {
			String[][] result = new String[1][4];
			String[] inside = new String[4];
			ArrayList<String> b = csvRW.search("paymentdatabase", "TID", a);
			inside[0] = a;
			inside[1] = b.get(1);
			inside[2] = b.get(2);
			inside[3] = b.get(3);
			result[0] = inside;
			return result;
		} else {
			return null;
		}

	}

	/**
	 * Fetches all data stored about a customer. Includes name, mobile number, email
	 * and all past TIDs.
	 * 
	 * @param custID Unique customer ID
	 * @return <code>String[]</code> array of [name, mobile number, email, past
	 *         TIDs]
	 */
	public static String[] findCustomer(int custID) {
		ArrayList<String> row = csvRW.search("customerdatabase", "CustomerID", Integer.toString(custID));
		String[] result = new String[4];
		result[0] = row.get(0);
		result[1] = row.get(1);
		result[2] = row.get(2);
		result[3] = row.get(3);
		return result;
	}

}
