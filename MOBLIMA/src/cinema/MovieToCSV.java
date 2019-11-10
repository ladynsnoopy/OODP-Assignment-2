package cinema;

import java.util.ArrayList;

/**
 * Control class to store <code>Movie</code> object into moviedatabase.
 * 
 * @author Oh Jun Teng
 * @version 1.0
 * @since 2019-11-10
 *
 */
public class MovieToCSV {
	/**
	 * Takes in <code>Movie</code> object and writes all attributes and data into
	 * moviedatabase. Utilizes csvRW.
	 * 
	 * @param movie customer <code>Movie</code> object to be written into database
	 * @see csvRW#writeToCSV(String, ArrayList)
	 */
	public static void addMovieToCSV(Movie movie) {
		ArrayList<String> data = new ArrayList<String>();
		data.add(Integer.toString(movie.getMovieID()));
		data.add(movie.getName());
		data.add(movie.getType());
		data.add(movie.getShowingStatus());
		data.add(movie.getSynopsis());
		data.add(movie.getDirector());
		String castData = movie.getCast().toString();
		castData = castData.substring(1, castData.length() - 1);
		data.add(castData);
		data.add(movie.getOverallUserRating());
		data.add(Integer.toString(movie.getTicketSales()));
		String reviewData = movie.getReviewIDs().toString();
		reviewData = reviewData.substring(1, reviewData.length() - 1);
		data.add(reviewData);
		String showtimeData = movie.getShowtimeIDs().toString();
		showtimeData = showtimeData.substring(1, showtimeData.length() - 1);
		data.add(showtimeData);
		data.add(movie.getMovieRating());
		csvRW.writeToCSV("moviedatabase", data);
	}
}