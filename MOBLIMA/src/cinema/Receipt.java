package cinema;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Receipt {
	//private Ticket[] ticketArr;
	private ArrayList<Ticket> ticketArr;
	private String TID;
	private String paymentMode;
	private double totalAmt = 0;

	public Receipt(ArrayList<Ticket> arr, String paymentMode) {
		super();
		this.ticketArr = arr;
		this.paymentMode = paymentMode;
		this.TID = arr.get(0).getShowtime().getCinema().getCinemaID() + this.getCurrentDateTime();
	}

	public String getTID() {
		return TID;
	}


	public ArrayList<Ticket> getTicketArr() {
		return ticketArr;
	}

	public void setTicketArr(ArrayList<Ticket> ticketArr) {
		this.ticketArr = ticketArr;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public void calTotalAmt() {
		double sum = 0;
		for (int i = 0; i < ticketArr.size(); i++) {
			// remember to set before you get
			sum += ticketArr.get(i).getFinalPrice();
		}
		totalAmt = sum;
	}
	public double getTotalAmt()
	{
		return totalAmt;
	}

	public String getCurrentDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");
		Date date = new Date();
		return dateFormat.format(date);
	}


	/**
	 * Takes in <code>Receipt</code> object and writes all attributes and data into
	 * paymentdatabase. Utilizes csvRW.
	 * 
	 * @param receipt <code>Receipt</code> object to be written into database
	 * @see csvRW#writeToCSV(String, ArrayList)
	 */
	public void addReceiptToCSV(Receipt receipt) {
		ArrayList<String> data = new ArrayList<String>();
		data.add(receipt.TID);
		data.add(receipt.paymentMode);
		data.add(receipt.ticketArr.get(0).getMovietitle());
		data.add(Double.toString(receipt.totalAmt));
		csvRW.writeToCSV("paymentdatabase", data);
	}


}
