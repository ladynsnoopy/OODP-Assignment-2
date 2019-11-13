package controller;

import java.util.Comparator;

import model.Movie;

/**
 * Implements <code>Comparator</code> in order to sort <code>Movie</code> via
 * review ratings
 * 
 * @author Lim Wai Leong
 * @author Oh Jun Teng
 * @author Edhie Wahidin Michelle
 * @author Myat Hmu Khin
 * @version 1.0
 * @since 2019-11-10
 * @see TicketSalesComparator
 *
 */
public class OverallRatingComparator implements Comparator<Movie> {
	@Override
	/**
	 * Compare two <code>Movie</code> objects according to their ratings. If ratings
	 * of first object is larger, will return positive integer. If ratings of second
	 * object is larger, will return negative integer. Else, returns 0.
	 */
	public int compare(Movie first, Movie second) {
		// multiplying by 10 so as to ensure comparison between decimal points for
		// differences like 0.1
		if(Double.parseDouble(first.getOverallUserRating()) > Double.parseDouble(second.getOverallUserRating()))
		{
			return -1;
		}
		else if(Double.parseDouble(first.getOverallUserRating())== Double.parseDouble(second.getOverallUserRating()))
		{
			return 0;
		}
		else
			return 1;
	}

}
