package cinema;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Control class that converts all movies stored in database to Movie objects.
 * Utilizes <code>csvRW</code>.
 * 
 * @see Movie
 * @see csvRW
 * @author Edhie Wahidin Michelle
 * @version 1.0
 * @since 2019-11-10
 *
 */
public class CSVtoMovie {
	/**
	 * 
	 * Returns <code>ArrayList</code> of <code>Movie</code> containing all movies
	 * that exist in moviedatabase.
	 * 
	 * @return <code>ArrayList</code> of <code>Movie</code> containing all movies
	 *         that exist in moviedatabase
	 */
	public static ArrayList<Movie> csvToMovieObject() {
		ArrayList<String[]> db = csvRW.readCSV("moviedatabase");
		ArrayList<Movie> movieObjArr = new ArrayList<Movie>();

		for (int i =1; i<db.size(); i++) {
			String [] element = db.get(i);
			if (!element[3].equals("End of Showing")) {
				int movieID = Integer.parseInt(element[0]); // SET
				String name = element[1];
				String showingStatus = element[3];
				String synopsis = element[4];
				ArrayList<String> cast = new ArrayList<String>(Arrays.asList(element[6].split(",")));
				String director = element[5];
				String type = element[2];
				ArrayList<Review> reviewArr = new ArrayList<Review>(); // NULL
				ArrayList<Showtime> showtimeArr = new ArrayList<Showtime>(); // NULL
				String overallUserRating = element[7]; // SET
				String movieRating = element[11];
				int ticketSales = Integer.parseInt(element[8]); // SET

				Movie o = new Movie(name, showingStatus, synopsis, cast, director, type, movieRating);
				o.setMovieID(movieID);
				o.setOverallUserRating(overallUserRating);
				o.setTicketSales(ticketSales);
				movieObjArr.add(o);
			}
		}
		return movieObjArr;
	}
	
	
	
}
