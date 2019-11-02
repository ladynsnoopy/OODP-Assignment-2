package cinema;

import java.util.Comparator;

public class TicketSalesComparator implements Comparator<Movie> {
	
	 public int compare(Movie first, Movie second) {
	       return (first.getTicketSales() - second.getTicketSales());
	    }

}
