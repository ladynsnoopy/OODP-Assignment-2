package cinema;

import java.util.ArrayList;
// TODO need to push ticket database also
public class TicketToCSV {
	public static void addTicketToCSV(Ticket ticket)
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add(Integer.toString(ticket.getTicketID()));
		data.add(ticket.getMovietitle());
		data.add(Double.toString(ticket.getFinalPrice()));
		csvRW.writeToCSV("ticketdatabase", data);
	}


}
