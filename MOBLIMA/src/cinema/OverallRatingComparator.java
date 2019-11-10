package cinema;

import java.util.Comparator;

/**
 * Implements <code>Comparator</code> in order to sort <code>Movie</code> via
 * review ratings
 * 
 * @author Edhie Wahidin Michelle
 * @version 1.0
 * @since 2019-11-10
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
		return (int) (first.getOverallUserRatingInDouble() * 10 - second.getOverallUserRatingInDouble() * 10);
	}

}
