package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Cinema;
import model.Showtime;
/**
 * A control class that will handle methods relating to the Showtime model. It
 * allows for creation, addition, search and editing for the <code>Showtime</code> objects, and updates the database accordingly each time.
 * 	
 * @author Lim Wai Leong
 * @author Oh Jun Teng
 * @author Edhie Wahidin Michelle
 * @author Myat Hmu Khin
 * @version 1.0
 * @since 2019-11-13
 * @see Showtime
 *
 */
public class ShowtimeController {
	/**
	 * <code>ArrayList&lt;Showtime&gt;</code> containing all <code>Showtime</code>
	 * objects.
	 */
	public static ArrayList<Showtime> showtimeArr = new ArrayList<Showtime>();

	/**
	 * Creates a <code>Showtime</code> object for every showtime entry in the
	 * database.
	 */
	public static void createShowtimes() {
		showtimeArr = CSVtoShowtime.csvToShowtimeObject();
	}

	public static void createShowtime(String cinemaID, String timing, String movietitle) {
		Cinema temp = null;

		for (int i = 0; i < CinemaController.cinemaArr.size(); i++) {
			if (cinemaID.equals(CinemaController.cinemaArr.get(i).getCinemaID())) {
				temp = CinemaController.cinemaArr.get(i);
				break;
			} else if (i == CinemaController.cinemaArr.size() - 1) {
				System.out.println("Invalid Cinema ID");
				return;
			}
		}
		String showtimes;
		Showtime showtime = new Showtime(temp, timing);
		showtimeArr.add(showtime);
		showtime.addShowtimeToCSV(showtime);
		// adding showtimeID to moviedatabase
		ArrayList<String> result = csvRW.search("moviedatabase", "Name", movietitle);
		if (result == null)
			System.out.println("This fucking shit is null");
		String id = result.get(0);

		if (result.get(10).equals("")) {
			showtimes = Integer.toString(showtime.getShowtimeID());
		} else {
			showtimes = result.get(10);
			List<String> items = Arrays.asList(showtimes.split("\\s*,\\s*"));
			ArrayList<String> showtimelist = new ArrayList<String>(items);
			showtimelist.add(Integer.toString(showtime.getShowtimeID()));
			showtimes = showtimelist.toString();
			showtimes = showtimes.substring(1, showtimes.length() - 1);
		}
		csvRW.editCSV("moviedatabase", id, "ShowtimeID", showtimes);

	}

	// TODO update showtimes
	// yo junteng mah man i think its right but pls double check for me HAHA
	/**
	 * Updates <code>Showtime</code> with new attributes.
	 * 
	 * @param showtimeID Unique ID for showtime
	 * @param cinemaID   Unique ID for cinema
	 * @param movietitle Title of movie in showtime to be updated
	 * @param timing     Timing of showtime to be updated
	 */
	public static void updateShowtimes(String showtimeID, String cinemaID, String movietitle, String timing) {
		Cinema temp = null;
		// checking if cinemaID exists
		for (int i = 0; i < CinemaController.cinemaArr.size(); i++) {
			if (cinemaID.equals(CinemaController.cinemaArr.get(i).getCinemaID())) {
				temp = CinemaController.cinemaArr.get(i);
				break;
			} else if (i == CinemaController.cinemaArr.size() - 1) {
				System.out.println("Invalid Cinema ID");
				return;
			}
		}
		csvRW.editCSV("showtimedatabase", showtimeID, "Timing", timing);
		System.out.println("Showtime updated");
		return;
	}

	/**
	 * Iterates through <code>showtimeArr</code> to return list of showtime
	 * information.<br>
	 * In format: ShowtimeID: ______ |Cinema: _______ |Timing: ______
	 * 
	 * @return List of showtime information as formatted above.
	 */
	public static String[] searchShowtimes() {
		ArrayList<String[]> list = csvRW.readCSV("showtimedatabase");
		String[] showtimes = new String[list.size()];
		int num = 0;
		for (int i = 0; i < list.size(); i++) {
			showtimes[num] = ("ShowtimeID: " + list.get(i)[0] + " |Cinema: " + list.get(i)[1] + " |Timing:"
					+ list.get(i)[2]);
			num++;
		}
		return showtimes;
	}

	/**
	 * Searches and returns a 2D array of showtime timings for a particular movie.
	 * Is meant to help in creating <code>Showtime</code> objects.
	 * 
	 * @param movieID movieID of target movie
	 * @return 2D array of showtime timings for a particular movie in
	 *         <code>[[ShowtimeID,Timing],[ShowtimeID,Timing],....]</code> format
	 * @see Showtime
	 */
	public static String[][] getShowtimesForMovie(int movieID) {
		ArrayList<String> result = csvRW.search("moviedatabase", "MovieID", Integer.toString(movieID));
		if (result == null)
			return null;
		String a = result.get(10); // Get all the showtimeID of the particular movie
		if (a.length() != 1) {
			String cut = a.substring(1, a.length() - 1);
			String[] arr = cut.split(","); // store all the showtimeID in a string array
			String[][] showtimes = new String[arr.length][2];
			for (int i = 0; i < arr.length; i++) {
				String[] inside = new String[2];
				ArrayList<String> b = csvRW.search("showtimedatabase", "ShowtimeID", arr[i].replaceAll("\\s+", ""));
				inside[0] = arr[i].replaceAll("\\s+", "");
				inside[1] = b.get(2);
				showtimes[i] = inside; // get timing for each showtimeID and store it into showtimes array
			}
			return showtimes;
		} else {
			String[][] showtimes = new String[1][2];
			String[] inside = new String[2];
			ArrayList<String> b = csvRW.search("showtimedatabase", "ShowtimeID", a.replaceAll("\\s+", ""));
			inside[0] = a;
			inside[1] = b.get(b.size() - 1);
			showtimes[0] = inside;
			return showtimes;
		}

	}

	/**
	 * Checks if showtime selected by customer exists as an object
	 * 
	 * @param show   2D array of showtimes and movies like [[ShowtimeID,Timing],...]
	 * @param target Target <code>showtimeID</code>
	 * @return 1 if <code>showtimeID</code> is found, -1 if no
	 */
	public static int checkValidityShowtime(String[][] show, int target) {
		for (int i = 0; i < show.length; i++) {
			if (target == Integer.parseInt(show[i][0])) {
				return 1;
			}

		}
		return -1;
	}
	
	/**
	 * Gets timing of showtime given <code>showtimeID</code>
	 * 
	 * @param show   2D array of <code>showtimeID</code> and timing
	 * @param target Target showtime
	 * @return Timing for target showtime
	 */
	public static String printRelevantShowTime(String[][] show, int target) {
		for (int i = 0; i < show.length; i++) {
			if (target == Integer.parseInt(show[i][0])) {
				return show[i][1];
			}

		}
		return "NOT VALID";
	}


}
