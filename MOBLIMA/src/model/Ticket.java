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
public class Ticket {
	/**
	 * <code>Showtime</code> object that ticket belongs to.
	 */
	private Showtime showtime;
	/**
	 * Title of the movie to be watched
	 */
	private String movietitle;
	/**
	 * Selection between Adult, Child, and Senior age groups.<br>
	 * 1: Child <br>
	 * 2: Adult <br>
	 * 3: Senior <br>
	 */
	private int isAdult;
//	private boolean isWeekend;
	/**
	 * Unique ticket ID
	 */
	private int ticketID;
	/**
	 * Counter to constantly create new and unique ticket IDs
	 */
	static int counter = counterInit();
	/**
	 * Final price of the ticket, after all multipliers have been carried out on the
	 * base price.
	 */
	private double finalPrice;

	/**
	 * Contructor for <code>Ticket</code> object
	 * 
	 * @param showtime <code>Showtime</code> object that this ticket belongs to.
	 */
	public Ticket(Showtime showtime) {
		super();
		this.showtime = showtime;
		this.ticketID = counter++;
	}

	/**
	 * Counts number of entries in data to act as counter for ID
	 * 
	 * @return <code>int</code> counter
	 */
	public static int counterInit() {
		ArrayList<String[]> data = new ArrayList<String[]>(csvRW.readCSV("ticketdatabase"));
		return data.size();
	}

	/**
	 * Gets selection of age group
	 * 
	 * @return Selection of age group
	 * @see Ticket#isAdult
	 */
	public int getIsAdult() {
		return isAdult;
	}

	/**
	 * Changes selection of age group
	 * 
	 * @param isAdult New selection of age group
	 * @see Ticket#isAdult
	 */
	public void setIsAdult(int isAdult) {
		this.isAdult = isAdult;
	}

//	public boolean isWeekend() {
//		return isWeekend;
//	}
//
//	public void setWeekend(boolean isWeekend) {
//		this.isWeekend = isWeekend;
//	}

	/**
	 * Gets unique ticket ID for this ticket
	 * 
	 * @return Unique ticket ID for this ticket
	 */
	public int getTicketID() {
		return ticketID;
	}

	/**
	 * Changes unique ticket ID for this ticket
	 * 
	 * @param ticketID New unique ticket ID for this ticket
	 */
	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
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

	/**
	 * Gets <code>Showtime</code> object that this ticket belongs to
	 * 
	 * @return <code>Showtime</code> object that this ticket belongs to
	 */
	public Showtime getShowtime() {
		return showtime;
	}

	/**
	 * Gets movie title for this ticket
	 * 
	 * @return Movie title for this ticket
	 */
	public String getMovietitle() {
		return movietitle;
	}

	/**
	 * Changes movie title for this ticket
	 * 
	 * @param movietitle New movie title for this ticket
	 */
	public void setMovietitle(String movietitle) {
		this.movietitle = movietitle;
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
		boolean isHols = calendar.checkHols(showtime);
		switch (isAdult) {
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
		if (calendar.checkHols(showtime)) {
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
	public void addTicketToCSV(Ticket ticket) {
		ArrayList<String> data = new ArrayList<String>();
		data.add(Integer.toString(ticket.ticketID));
		data.add(ticket.movietitle);
		data.add(Double.toString(ticket.finalPrice));
		csvRW.writeToCSV("ticketdatabase", data);
	}

}
