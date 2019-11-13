package controller;

import java.util.Comparator;

import model.Movie;

/**
 * Implements <code>Comparator</code> in order to sort <code>Movie</code> via
 * ticket sales.
 * 
 * @author Lim Wai Leong
 * @author Oh Jun Teng
 * @author Edhie Wahidin Michelle
 * @author Myat Hmu Khin
 * @version 1.0
 * @since 2019-11-10
 * @see OverallRatingComparator
 */
public class TicketSalesComparator implements Comparator<Movie> {
	/**
	 * Compare two <code>Movie</code> objects according to their ticket sales. If
	 * ratings of first object is larger, will return positive integer. If ratings
	 * of second object is larger, will return negative integer. Else, returns 0.
	 */
	public int compare(Movie first, Movie second) {
		return (second.getTicketSales() - first.getTicketSales());
	}

}
