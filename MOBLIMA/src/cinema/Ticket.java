package cinema;

import java.util.ArrayList;

public class Ticket {
	private Showtime showtime;
	private String movietitle;
	private int isAdult;
//	private boolean isWeekend;
	private int ticketID;
	static int counter = counterInit();
	private double finalPrice;
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
	
	public int getIsAdult() {
		return isAdult;
	}

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

	public int getTicketID() {
		return ticketID;
	}
	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}
	public double getFinalPrice() {
		return finalPrice;
	}
	public Showtime getShowtime() {
		return showtime;
	}

	public String getMovietitle() {
		return movietitle;
	}

	public void setMovietitle(String movietitle) {
		this.movietitle = movietitle;
	}

	//set isWeekend isAdult before final price
	public void setFinalPrice(Calendar a, Price b, String cinetype) {
		double base = 0;
		boolean isHols = a.checkHols(showtime);
		switch (isAdult) {
		//base price depending if child adult or senior
		//if holidays, will add to base price
		//if weekend then multiplied 
		case (1): {
			base = b.getPriceChild();
			break;
		}
		case (2): {
			base = b.getPriceAdult();
			break;
		}
		case (3): {
			base = b.getPriceSenior();
			break;
		}

		}
		if(isHols)
		{
			base += b.getPriceHol();
		}
		if(a.checkHols(showtime))
		{
			base *= b.getPriceWeekend();
		}
		if(cinetype.equals("Gold Class"))
		{
			base += b.getPriceGoldClass();
		}
		finalPrice = base;	
		
	}
	
	public void addTicketToCSV(Ticket ticket)
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add(Integer.toString(ticket.ticketID));
		data.add(ticket.movietitle);
		data.add(Double.toString(ticket.finalPrice));
		csvRW.writeToCSV("ticketdatabase", data);
	}
	

}
