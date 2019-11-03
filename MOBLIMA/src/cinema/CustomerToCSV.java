package cinema;

import java.util.ArrayList;

public class CustomerToCSV {
	public void addCustomerToCSV(Customer customer) {
		ArrayList<String> data = new ArrayList<String>();
		data.add(Integer.toString(customer.getCustID()));
		data.add(customer.getName());
		data.add(customer.getMobileNum());
		data.add(customer.getEmail());
		data.add(customer.getTIDs().toString());
		csvRW.writeToCSV("customerdatabase", data);
	}
}
