package cinema;

import java.util.ArrayList;

/**
 * Control class to store <code>Customer</code> object into customerdatabase.
 * 
 * @author Oh Jun Teng
 * @version 1.0
 * @since 2019-11-10
 *
 */
public class CustomerToCSV {
	/**
	 * Takes in <code>Customer</code> object and writes all attributes and data into
	 * customerdatabase. Utilizes csvRW.
	 * 
	 * @param customer <code>Customer</code> object to be written into database
	 * @see csvRW#writeToCSV(String, ArrayList)
	 */
	public static void addCustomerToCSV(Customer customer) {
		ArrayList<String> data = new ArrayList<String>();
		data.add(Integer.toString(customer.getCustID()));
		data.add(customer.getName());
		data.add(customer.getMobileNum());
		data.add(customer.getEmail());
		data.add(customer.getTIDs().toString());
		csvRW.writeToCSV("customerdatabase", data);
	}
}
