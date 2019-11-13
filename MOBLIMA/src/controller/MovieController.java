package controller;

import java.util.ArrayList;

import model.Movie;

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

	// 1:title 2:type 3:status 4:synopsis 5:rating 6:director 7:cast 8:showtime shit
	// boundary class asks for which to change, if 1-5 use this function

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

}
