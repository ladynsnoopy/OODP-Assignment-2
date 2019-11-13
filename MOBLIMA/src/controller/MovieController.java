package controller;

import java.util.ArrayList;
import java.util.Collections;

import model.Movie;


/**
 * A control class that will handle methods relating to the movie model. It
 * allows for the creation, search and editing of movie objects.
 * @author Lim Wai Leong
 * @author Oh Jun Teng
 * @author Edhie Wahidin Michelle
 * @author Myat Hmu Khin
 * @version 1.0
 * @since 2019-11-13
 *
 *
 */
public class MovieController {
	/**
	 * <code>ArrayList&lt;Movie&gt;</code> containing all <code>Movie</code>
	 * objects.
	 */
	public static ArrayList<Movie> movieArr = new ArrayList<Movie>();

	/**
	 * Creates a Movie object. Adds the newly created object to movieArr. Adds the
	 * movie with all relevent details into moviedatabase.
	 * 
	 * @param name          Movie title
	 * @param showingStatus Status can be Coming Soon, Preview, Now Showing, End Of
	 *                      Showing
	 * @param synopsis      Synopsis of movie
	 * @param cast          Cast of movie
	 * @param director      Director of movie
	 * @param type          Genre of movie. Eg. Action, adventure, etc.
	 * @param movieRating   Rating of move. Eg. PG13, PG, etc
	 */
	public static void createMovie(String name, String showingStatus, String synopsis, ArrayList<String> cast,
			String director, String type, String movieRating) {
		Movie a = new Movie(name, showingStatus, synopsis, cast, director, type, movieRating);
		movieArr.add(a);
		a.addMovieToCSV(a);
	}

	/**
	 * Edits movie details (title, type, showing status, synopsis, rating, director,
	 * cast list) in the moviedatabase. Uses selection to determine what attribute
	 * to alter.
	 * 
	 * @param selection Selection of what to edit
	 * @param moviename Name of movie to edit
	 * @param change    The change to be implemented.
	 */
	public static void editMovieStringDetails(int selection, String moviename, String change) {
		ArrayList<String> result = csvRW.search("moviedatabase", "Name", moviename);
		String id = result.get(0);
		switch (selection) {
		case 1:
			csvRW.editCSV("moviedatabase", id, "Name", change);
			System.out.println("Title updated");
			break;
		case 2:
			csvRW.editCSV("moviedatabase", id, "Type", change);
			System.out.println("Type updated");
			break;
		case 3:
			csvRW.editCSV("moviedatabase", id, "ShowingStatus", change);
			System.out.println("Showing status updated");
			break;
		case 4:
			csvRW.editCSV("moviedatabase", id, "Synopsis", change);
			System.out.println("Synopsis updated");
			break;
		case 5:
			csvRW.editCSV("moviedatabase", id, "Rating", change);
			System.out.println("Rating updated");
			break;
		case 6:
			csvRW.editCSV("moviedatabase", id, "Director", change);
			System.out.println("Director updated");
			break;
		case 7:
			// Must put in the entire cast list
			csvRW.editCSV("moviedatabase", id, "Cast", change);
			System.out.println("Cast updated");
			break;
		}
	}

	/**
	 * Returns names of all movies that exist in database.
	 * 
	 * @return <code>String</code> array of movie names
	 */
	public static String[] searchMovies() {
		ArrayList<String[]> list = csvRW.readCSV("moviedatabase");
		String[] movies = new String[list.size()];
		int num = 0;
		for (int i = 0; i < list.size(); i++) {
			movies[num] = list.get(i)[1];
			num++;
		}
		return movies;
	}

	/**
	 * Checks that movie exists in moviedatabase when given title of movie.
	 * 
	 * 
	 * @param title Title of movie.
	 * @return boolean value true if exists, false if not.
	 */
	public static boolean movieExists(String title) {

		if (csvRW.search("moviedatabase", "Name", title) == null) {
			return false;
		} else if (csvRW.search("moviedatabase", "Name", title).get(3).equals("End of Showing")) {
			return false;
		}

		return true;
	}

	/**
	 * Depending on selection, returns top 5 movies.
	 * 
	 * @param selection Selection of which sort to return.
	 * @return If selection == 1, returns sorted by overall rating. If selection ==
	 *         2, returns sorted by total sales.
	 */
	public static ArrayList<String> showTopMovies(int selection) {
		ArrayList<Movie> movieObjArr = CSVtoMovie.csvToMovieObject();
		OverallRatingComparator ratingsComparator = new OverallRatingComparator();
		TicketSalesComparator salesComparator = new TicketSalesComparator();
		ArrayList<String> output = new ArrayList<String>();

		// 1: sort by overall rating, 2: sort by total sales
		switch (selection) {
		case 1:
			Collections.sort(movieObjArr, ratingsComparator);
			for (int i = 0; i < 5; i++) {
				output.add(String.format("%s : %s", movieObjArr.get(i).getName(),
						movieObjArr.get(i).getOverallUserRating()));
			}
		case 2:
			Collections.sort(movieObjArr, salesComparator);
			for (int i = 0; i < 5; i++) {
				output.add(String.format("%s : %d", movieObjArr.get(i).getName(), movieObjArr.get(i).getTicketSales()));
			}
		}
		return output;
	}

	/**
	 * Searches for matching <code>movieID</code> given movie title.
	 * 
	 * @param name Movie title of target movie
	 * @return <code>movieID</code> that matches target movie if target found. Else,
	 *         returns -1.
	 */
	public static int searchOneMovie(String name) {
		ArrayList<String> result = csvRW.search("moviedatabase", "Name", name);
		if (result != null)
			return Integer.parseInt(result.get(0)); // returns movieID given the movie name
		else
			return -1;
	}

	/**
	 * Searches and returns all details of target movie. Will print
	 * <code>No reviews has been written about this movie yet.</code> if no reviews
	 * can be found. <br>
	 * Otherwise will be in sequence of Name, Movie Type, Showing Status, Synopsis,
	 * Director, Cast, Overall Rating, Movie Age Rating, Comment, and User's Rating
	 * <br>
	 * Will call <code>searchforReview</code>.
	 * 
	 * @param movieID Unique <code>movieID</code> of target movie
	 * @return All details of a target movie stored in a
	 *         <code>ArrayList&lt;String&gt;</code>.
	 * @see CustomerController#searchforReview(int)
	 */

	public static ArrayList<String> searchMovieDetails(int movieID) {
		ArrayList<String> movie_row = csvRW.search("moviedatabase", "MovieID", Integer.toString(movieID));
		ArrayList<String> result = new ArrayList<String>();
		result.add("-----------------------------------------------");
		result.add(movie_row.get(1));
		result.add("-----------------------------------------------");
		result.add("Movie Type: " + movie_row.get(2));
		result.add("Showing Status: " + movie_row.get(3));
		result.add("Synopsis: " + movie_row.get(4));
		result.add("Director: " + movie_row.get(5));
		String cutted = movie_row.get(6).substring(1, movie_row.get(6).length() - 1);
		result.add("Cast: " + cutted); // make sure cast is more than one
		result.add("Overall Rating: " + movie_row.get(7));
		result.add("Movie Age Rating: " + movie_row.get(11));
		result.add("-----------------------------------------------");
		String a = movie_row.get(9);
		if (a.equals("")) {
			result.add("No reviews has been written about this movie yet.");
			return result;
		} else if (a.length() == 1) { // if there is only one review
			String[] review = ReviewController.searchforReview(Integer.parseInt(a));
			result.add("Comment: " + review[1]);
			result.add("User's Rating: " + review[0]);
			result.add("-----------------------------------------------");

			return result;
		} else {

			String cut = a.substring(1, a.length() - 1); // if there are more than one review
			String[] arr = cut.split(","); // store all the showtimeID in a string array
			for (int j = 0; j < arr.length; j++) {
				String[] review = ReviewController.searchforReview(Integer.parseInt(arr[j]));
				result.add("Comment: " + review[1]);
				result.add("User Rating: " + review[0]);
			}
			return result;

		}
	}
}
