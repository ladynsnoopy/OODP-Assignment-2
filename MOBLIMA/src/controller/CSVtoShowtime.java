package controller;

import java.util.ArrayList;

import model.Showtime;

/**
 * Control class to convert showtime entries in database to java objects.
 * 
 * @author Lim Wai Leong
 * @version 1.0
 * @since 2019-11-13
 *
 */
public class CSVtoShowtime {
	/**
	 * Reads database and creates a <code>Showtime</code> object for every entry in
	 * database.
	 * 
	 * @return <code>ArrayList&lt;Showtime&gt;</code> of created <code>Showtime</code>
	 *         objects
	 */
	public static ArrayList<Showtime> csvToShowtimeObject() {
		ArrayList<String[]> db = csvRW.readCSV("showtimedatabase");
		ArrayList<Showtime> ShowtimeObjArr = new ArrayList<Showtime>();

		for (int i = 1; i < db.size(); i++) {
			String[] element = db.get(i);
			int showtimeID = Integer.parseInt(element[0]);
			String cinema = element[1];
			String timing = element[2];
			int k = 0;
			for (int j = 0; j < StaffApp.cinemaArr.size(); j++) {
				if (StaffApp.cinemaArr.get(j).getCinemaID().contains(cinema)) {
					k = j;
					break;
				}
			}
			Showtime o = new Showtime(StaffApp.cinemaArr.get(k), timing);
			o.setShowtimeID(showtimeID);

			ShowtimeObjArr.add(o);

		}
		return ShowtimeObjArr;
	}

}
