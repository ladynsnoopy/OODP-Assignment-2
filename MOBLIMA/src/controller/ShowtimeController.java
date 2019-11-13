package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Cinema;
import model.Showtime;

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

}
