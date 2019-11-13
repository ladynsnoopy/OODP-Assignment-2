package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import model.Calendar;
import model.Cinema;
import model.Cineplex;
import model.Movie;
import model.Price;
import model.Showtime;
import model.Staff;
import view.DisplayStaffPage;
import view.DisplayUserPage;

/**
 * A control class that will handle methods relating to the staff module. It
 * will manage and control objects that are necessary to allow the staff to
 * login, create/update/remove movie listing, create/update/remove cinema
 * showtimes and the movies to be shown, and configure system settings.
 * 
 * @author Lim Wai Leong
 * @author Oh Jun Teng
 * @version 1.0
 * @since 2019-11-13
 *
 *
 */
public class StaffController implements DisplayStaffPage, DisplayUserPage {

	/**
	 * Creates a staff account so staff can login and saves login info to
	 * staffdatabase.
	 * 
	 * @param username Username of staff
	 * @param password Password of staff
	 */
	public static void createStaff(String username, String password) {
		Staff a = new Staff(username, password);
		a.addStaffToCSV(a);
	}

	// boundary class needs to check that CinemaID and movietitle exists

	// not sure about this

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

}