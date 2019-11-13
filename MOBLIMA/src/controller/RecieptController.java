package controller;

import java.util.ArrayList;

import model.CurrentTicket;
import model.Receipt;
/**
 * A control class that will handle methods relating to the Receipt model. It
 * allows for creation of the <code>Receipt</code> object, and updates the database accordingly.
 * 	
 * @author Lim Wai Leong
 * @author Oh Jun Teng
 * @author Edhie Wahidin Michelle
 * @author Myat Hmu Khin
 * @version 1.0
 * @since 2019-11-13
 * @see Reciept 
 *
 */
public class RecieptController {
	/**
	 * Stores TID of new receipt when customer makes a purchase of tickets to keep
	 * track of past booking history.
	 * 
	 * @param custID Unique customer ID
	 * @param TID    TID to be inserted into customer database
	 * @see Receipt
	 */
	public static void addReceiptinCustomerDatabase(int custID, String TID) {
		ArrayList<String> cust_row = csvRW.search("customerdatabase", "CustomerID", Integer.toString(custID));
		String id = cust_row.get(0);
		String TIDS = cust_row.get(4);
		if (TIDS.equals("[]")) { // when there are no receipts initially
			csvRW.editCSV("customerdatabase", id, "TID", TID);

		} else {
			// if there are more than one receipt initially
			if (TIDS.length() < 15) {
				String[] arr = TIDS.split(",");
				String b = "";
				for (int i = 0; i < arr.length; i++) {
					b += arr[i] + ",";
				}
				b += TID;
				csvRW.editCSV("customerdatabase", id, "TID", b);
			} else {
				// if there is one TID
				String b = TIDS + "," + TID;
				csvRW.editCSV("customerdatabase", id, "TID", b);
			}
		}
	}
	
	/**
	 * Gets TID and total amount of receipt given
	 * <code>ArrayList&lt;Ticket&gt;</code> bought in this transaction by the
	 * customer, and payment mode.
	 * 
	 * @param arr         <code>ArrayList&lt;Ticket&gt;</code> of tickets bought in
	 *                    this transaction by the customer
	 * @param paymentmode Customer's choice of payment mode. May be "Cash, Credit or
	 *                    PayLah!"
	 * @return <code>String[2]</code> array containing TID and total amount in
	 *         respective indexes
	 * @see Receipt
	 */
	public static String[] addPayment(ArrayList<CurrentTicket> arr, String paymentmode) {
		String[] result = new String[2];
		Receipt receipt = new Receipt(arr, paymentmode); // creates a new Receipt object
		receipt.calTotalAmt(); // calculates the total amount of the Receipt
		receipt.addReceiptToCSV(receipt); // writes it to the Receipt database
		result[0] = receipt.getTID(); //
		result[1] = Double.toString(receipt.getTotalAmt());
		return result;
	}
}
