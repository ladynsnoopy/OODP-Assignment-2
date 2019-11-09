package cinema;

import java.util.ArrayList;

public class ReceiptToCSV {
	public static void addReceiptToCSV(Receipt receipt) {
		ArrayList<String> data = new ArrayList<String>();
		data.add(receipt.getTID());
		data.add(receipt.getPaymentMode());
		data.add(receipt.getTicketArr().get(0).getMovietitle());
		data.add(Double.toString(receipt.getTotalAmt()));
		csvRW.writeToCSV("paymentdatabase", data);
	}
}
