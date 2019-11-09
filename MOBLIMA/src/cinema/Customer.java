package cinema;

import java.util.ArrayList;

/**
 * Customer object that contains unique customer ID, name, mobile number, email,
 * and an <code>ArrayList<Receipt></code> of receipts of previous bookings.
 * 
 * @author Myat Hmu Khin
 * @version 1.0
 * @since 2019-11-09
 *
 */
public class Customer {
	/**
	 * <code>Static</code> counter that will increment every time a
	 * <code>Customer</code> object is created.
	 */
	static int count = 1;
	/**
	 * Customer name, mobile number and email in <code>String</code> format.
	 */
	private String name, mobileNum, email;
	/**
	 * Unique customer ID.
	 */
	private int custID;
	/**
	 * <code>ArrayList<Receipt></code> of receipts of previous bookings.
	 * 
	 * @see Receipt
	 */
	private ArrayList<Receipt> bookingHistory;

	/**
	 * Constructor for <code>Customer</code> object.
	 * 
	 * @param name      Name of customer in <code>String</code> format
	 * @param mobileNum Mobile number of customer in <code>String</code> format
	 * @param email     Email of customer in <code>String</code> format.
	 */
	public Customer(String name, String mobileNum, String email) {
		super();
		this.name = name;
		this.mobileNum = mobileNum;
		this.email = email;
		this.custID = count++;
		bookingHistory = new ArrayList<Receipt>();
	}

	/**
	 * Gets name of customer.
	 * 
	 * @return Name of customer in <code>String</code> format
	 */
	public String getName() {
		return name;
	}

	/**
	 * Changes name of customer.
	 * 
	 * @param name Name of customer in <code>String</code> format
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets mobile number of customer.
	 * 
	 * @return Mobile number of customer in <code>String</code> format
	 */
	public String getMobileNum() {
		return mobileNum;
	}

	/**
	 * Changes mobile number of customer.
	 * 
	 * @param mobileNum Mobile number of customer in <code>String</code> format
	 */
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	/**
	 * Gets email of customer.
	 * 
	 * @return Email of customer in <code>String</code> format
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Changes email of customer.
	 * 
	 * @param email Email of customer in <code>String</code> format
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets customer ID.
	 * 
	 * @return Unique customer ID in <code>int</code>
	 */
	public int getCustID() {
		return custID;
	}

	/**
	 * Changes customer ID.
	 * 
	 * @param custID Unique customer ID in <code>int</code>
	 */
	public void setCustID(int custID) {
		this.custID = custID;
	}

	/**
	 * Gets lists of previous receipts in <code>ArrayList<Receipt></code> format.
	 * 
	 * @return <code>ArrayList<Receipt></code> of receipts of previous bookings
	 * @see Receipt
	 */
	public ArrayList<Receipt> getBookingHistory() {
		return bookingHistory;
	}

	/**
	 * Adds to booking history
	 * 
	 * @param a <code>Receipt</code> object.
	 * @see Receipt
	 */
	public void addBookingHistory(Receipt a) {
		bookingHistory.add(a);
	}

	/**
	 * Gets ticket IDs of receipts in booking history in
	 * <code>ArrayList<String></code> format.
	 * 
	 * @return Ticket IDs of receipts in booking history in
	 *         <code>ArrayList<String></code> format.
	 * @see Receipt#getTID()
	 */
	public ArrayList<String> getTIDs() {
		ArrayList<String> bookinghistory = new ArrayList<String>();
		for (int i = 0; i < bookingHistory.size(); i++) {
			bookinghistory.add(bookingHistory.get(i).getTID());
		}
		return bookinghistory;
	}

}
