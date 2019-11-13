package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import controller.csvRW;

/**
 * Receipt object that contains <code>ArrayList</code> of <code>Ticket</code>
 * objects bought in the same transaction by the same customer, TID, payment
 * mode, and total amount paid.
 * 
 * @author Myat Hmu Khin
 * @author Oh Jun Teng
 * @version 1.0
 * @since 2019-11-10
 *
 */
public class Receipt {
	// private Ticket[] ticketArr;
	/**
	 * <code>ArrayList</code> of <code>Ticket</code> objects that were bought in
	 * this transaction.
	 * 
	 * @see Ticket
	 */
	private ArrayList<Ticket> ticketArr;
	/**
	 * Unique transaction ID of this <code>Receipt</code>. In format
	 * XXXYYYYMMDDhhmm.
	 */
	private String TID;
	/**
	 * Mode of payment by which customer paid for the movie tickets. Can be "Cash,
	 * Credit or PayLah!"
	 */
	private String paymentMode;
	/**
	 * Total amount paid by customer for all tickets bought.
	 */
	private double totalAmt = 0;

	/**
	 * Constructor of <code>Receipt</code> object.
	 * 
	 * @param arr         <code>ArrayList</code> of <code>Ticket</code> objects
	 *                    bought in this transaction
	 * @param paymentMode Mode of payment by which customer paid for the movie
	 *                    tickets. Can be "Cash, Credit or PayLah!"
	 */
	public Receipt(ArrayList<Ticket> arr, String paymentMode) {
		super();
		this.ticketArr = arr;
		this.paymentMode = paymentMode;
		this.TID = arr.get(0).getShowtime().getCinema().getCinemaID() + this.getCurrentDateTime();
	}

	/**
	 * Gets TID
	 * 
	 * @return TID in format XXXYYYYMMDDhhmm
	 */
	public String getTID() {
		return TID;
	}

	/**
	 * Gets <code>ArrayList</code> of <code>Ticket</code> objects bought in this
	 * transaction
	 * 
	 * @return <code>ArrayList</code> of <code>Ticket</code> objects bought in this
	 *         transaction
	 */
	public ArrayList<Ticket> getTicketArr() {
		return ticketArr;
	}

	/**
	 * Changes <code>ArrayList</code> of <code>Ticket</code> objects bought in this
	 * transaction
	 * 
	 * @param ticketArr <code>ArrayList</code> of <code>Ticket</code> objects bought
	 *                  in this transaction
	 */
	public void setTicketArr(ArrayList<Ticket> ticketArr) {
		this.ticketArr = ticketArr;
	}

	/**
	 * Gets payment mode.
	 * 
	 * @return Mode of payment by which customer paid for the movie tickets. Can be
	 *         "Cash, Credit or PayLah!"
	 */
	public String getPaymentMode() {
		return paymentMode;
	}

	/**
	 * Changes mode of payment by which customer paid for the movie tickets.
	 * 
	 * @param paymentMode Mode of payment by which customer paid for the movie
	 *                    tickets. Can be "Cash, Credit or PayLah!"
	 */
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	/**
	 * Calculates total amount to be paid by customer by adding prices of all
	 * <code>Ticket</code> objects under this <code>Receipt</code>.
	 */
	public void calTotalAmt() {
		double sum = 0;
		for (int i = 0; i < ticketArr.size(); i++) {
			// remember to set before you get
			sum += ticketArr.get(i).getFinalPrice();
		}
		totalAmt = sum;
	}

	/**
	 * Gets total amount to be paid by customer for tickets.
	 * 
	 * @return Total amount to be paid by customer for tickets
	 */
	public double getTotalAmt() {
		return totalAmt;
	}

	/**
	 * Gets current date and time at time of purchase and convert into yyyyMMddHHmm
	 * <code>String</code> format.
	 * 
	 * @return Current date and time in yyyyMMddHHmm <code>String</code> format
	 */
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
