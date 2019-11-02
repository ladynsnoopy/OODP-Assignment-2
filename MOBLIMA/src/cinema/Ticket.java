package cinema;

public class Ticket {
	private Showtime showtime;
	private int isAdult;
	private boolean isWeekend;
	private int ticketID;
	static int counter = 0;
	private double finalPrice;
	public Ticket(Showtime showtime) {
		super();
		this.showtime = showtime;
		this.ticketID = counter++;
	}
	public int getTicketID() {
		return ticketID;
	}
	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}
	public double getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(Calendar a, Price b) {
		double base = 0;
		boolean isHols = a.checkHols(showtime);
		switch (isAdult) {
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
		if(isWeekend)
		{
			base *= b.getPriceWeekend();
		}
		finalPrice = base;	
		
	}
	
	
	

}
