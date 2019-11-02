package cinema;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Receipt {
	private Ticket[] ticketArr;
	private String TID;
	private String paymentMode;

	public Receipt(Ticket[] ticketArr, String paymentMode) {
		super();
		this.ticketArr = ticketArr;
		this.paymentMode = paymentMode;
		this.TID = ticketArr[0].getShowtime().getCinema().getCinemaID() + this.getCurrentDateTime();
	}

	public Ticket[] getTicketArr() {
		return ticketArr;
	}

	public void setTicketArr(Ticket[] ticketArr) {
		this.ticketArr = ticketArr;
	}

	public String getTID() {
		return TID;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public double calTotalAmt() {
		double sum = 0;
		for (int i = 0; i < ticketArr.length; i++) {
			// remember to set before you get
			sum += ticketArr[i].getFinalPrice();
		}
		return sum;
	}

	public String getCurrentDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");
		Date date = new Date();
		return dateFormat.format(date);
	}

}
