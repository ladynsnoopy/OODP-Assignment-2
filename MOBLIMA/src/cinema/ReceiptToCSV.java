package cinema;

import java.util.ArrayList;

/**
 * Control class to store <code>Receipt</code> object into paymentdatabase.
 * 
 * @author Myat Hmu Khin
 * @version 1.0
 * @since 2019-11-10
 *
 */
public class ReceiptToCSV {
	/**
	 * Takes in <code>Receipt</code> object and writes all attributes and data into
	 * paymentdatabase. Utilizes csvRW.
	 * 
	 * @param receipt <code>Receipt</code> object to be written into database
	 * @see csvRW#writeToCSV(String, ArrayList)
	 */
	public static void addReceiptToCSV(Receipt receipt) {
		ArrayList<String> data = new ArrayList<String>();
		data.add(receipt.getTID());
		data.add(receipt.getPaymentMode());
		data.add(receipt.getTicketArr().get(0).getMovietitle());
		data.add(Double.toString(receipt.getTotalAmt()));
		csvRW.writeToCSV("paymentdatabase", data);
	}
}
