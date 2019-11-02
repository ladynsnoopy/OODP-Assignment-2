package cinema;

import java.util.ArrayList;

public class Customer {
	static int count = 0;
	private String name, mobileNum, email;
	private int custID;
	private ArrayList<Receipt> bookingHistory;
	public Customer(String name, String mobileNum, String email) {
		super();
		this.name = name;
		this.mobileNum = mobileNum;
		this.email = email;
		this.custID = count++;
		bookingHistory = new ArrayList<Receipt>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCustID() {
		return custID;
	}
	public void setCustID(int custID) {
		this.custID = custID;
	}
	public ArrayList<Receipt> getBookingHistory() {
		return bookingHistory;
	}
	public void addBookingHistory(Receipt a) {
		bookingHistory.add(a);
	}
	
	

}
