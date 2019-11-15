package model;

import java.util.ArrayList;

import controller.csvRW;

/**
 * Object containing attributes of tickets, such as showtime, movie title,
 * unique ticket ID and price of ticket.
 * 
 * @author Lim Wai Leong
 * @author Oh Jun Teng
 * @author Edhie Wahidin Michelle
 * @author Myat Hmu Khin
 * @version 1.0
 * @since 2019-11-13
 *
 */
public class CurrentTicket extends TicketAb {

	/**
	 * Final price of the ticket after multipliers have been applied.
	 */
	private double finalPrice;

	/**
	 * Constructor for <code>CurrentTicket</code> object.
	 * 
	 * @param showtime <code>Showtime</code> for which this ticket applies to.
	 */
	public CurrentTicket(Showtime showtime) {
		super(showtime);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets final price of this ticket after all multipliers have been carried out
	 * on it
	 * 
	 * @return Final price of this ticket
	 */
	public double getFinalPrice() {
		return finalPrice;
	}

	// set isWeekend isAdult before final price
	/**
	 * Applies all needed multipliers to the base price and saves it to final price.
	 * 
	 * @param calendar <code>Calendar</code> object that contains all special dates.
	 *                 (Eg. Holidays or weekends)
	 * @param price    <code>Price</code> object that applies modifiers to base
	 *                 price
	 * @param cinetype Type of cinema (Eg. Gold Class, Normal)
	 * @see Calendar
	 * @see Price
	 */
	public void setFinalPrice(Calendar calendar, Price price, String cinetype) {
		double base = 0;
		boolean isHols = calendar.checkHols(super.getShowtime());
		switch (super.getIsAdult()) {
		// base price depending if child adult or senior
		// if holidays, will add to base price
		// if weekend then multiplied
		case (1): {
			base = price.getPriceChild();
			break;
		}
		case (2): {
			base = price.getPriceAdult();
			break;
		}
		case (3): {
			base = price.getPriceSenior();
			break;
		}

		}
		if (isHols) {
			base += price.getPriceHol();
		}
		if (calendar.checkHols(super.getShowtime())) { // only using getShowtime
			base *= price.getPriceWeekend();
		}
		if (cinetype.equals("Gold Class")) {
			base += price.getPriceGoldClass();
		}
		finalPrice = base;

	}

	/**
	 * Stores <code>Ticket</code> object into ticket database
	 * 
	 * @param ticket <code>Ticket</code> object to be stored.
	 * @see csvRW#writeToCSV(String, ArrayList)
	 */
	public void addTicketToCSV(CurrentTicket ticket) {
		ArrayList<String> data = new ArrayList<String>();
		data.add(Integer.toString(super.getTicketID()));
		data.add(super.getMovietitle());
		data.add(Double.toString(ticket.finalPrice));
		csvRW.writeToCSV("ticketdatabase", data);
	}

}
