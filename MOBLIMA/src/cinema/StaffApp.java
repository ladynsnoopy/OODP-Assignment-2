package cinema;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StaffApp {
	public static ArrayList<Cineplex> cineplexArr = new ArrayList<Cineplex>();
	public static ArrayList<Cinema> cinemaArr = new ArrayList<Cinema>();
	public static ArrayList<Movie> movieArr = new ArrayList<Movie>();
	public static ArrayList<Showtime> showtimeArr = new ArrayList<Showtime>();
	public static Calendar calendar = createCalendar();

	/**
	 * Creates a staff account so staff can login and saves login info to
	 * staffdatabase.
	 * 
	 * @param username Username of staff
	 * @param password Password of staff
	 */
	public static void createStaff(String username, String password) {
		Staff a = new Staff(username, password);
		StaffToCSV.addStaffToCSV(a);
	}

	/**
	 * Checks login information against staffdatabase.
	 * 
	 * @param username Username of staff
	 * @param password Password of staff
	 * @return 0 if all information matches. Returns -1 if password does not match.
	 *         Returns -2 if no such username exists.
	 */
	public static int login(String username, String password) {
		ArrayList<String[]> list = csvRW.readCSV("staffdatabase");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i)[0].equals(username)) {
				if (list.get(i)[1].equals(password)) {
					return 0;
				} else
					return -1; // if password does not match
			}
		}
		return -2; // if no such username exists
	}

	/**
	 * Creates all the pre-existing Cineplex and Cinema objects necessary for the
	 * program to continue. Add the created objects to the relevant public static
	 * ArrayList for other methods to access.
	 */
	public static void createCineplexAndCinemas() {
		ArrayList<Cinema> temp = new ArrayList<Cinema>();

		Cineplex cowboyTown = new Cineplex("NTU", "AA");
		Cineplex jurassicPark = new Cineplex("NUS", "BB");
		Cineplex theCentral = new Cineplex("SMU", "CC");

		cineplexArr.add(cowboyTown);
		cineplexArr.add(jurassicPark);
		cineplexArr.add(theCentral);

		Cinema a1 = new Cinema("Normal", 10, 10, "AA1");
		Cinema a2 = new Cinema("Normal", 15, 10, "AA2");
		Cinema a3 = new Cinema("Gold Class", 5, 5, "AA3");

		// temp = cineplexArr.get(0).getCinemaArr();
		temp.add(a1);
		temp.add(a2);
		temp.add(a3);
		cineplexArr.get(0).setCinemaArr(temp);

		Cinema b1 = new Cinema("Normal", 10, 10, "BB1");
		Cinema b2 = new Cinema("Normal", 15, 10, "BB2");
		Cinema b3 = new Cinema("Gold Class", 5, 5, "BB3");
		temp.clear();
		// temp = cineplexArr.get(1).getCinemaArr();
		temp.add(b1);
		temp.add(b2);
		temp.add(b3);
		cineplexArr.get(1).setCinemaArr(temp);

		Cinema c1 = new Cinema("Normal", 10, 10, "CC1");
		Cinema c2 = new Cinema("Normal", 15, 11, "CC2");
		Cinema c3 = new Cinema("Gold Class", 5, 5, "CC3");
		temp.clear();
		// temp = cineplexArr.get(0).getCinemaArr();
		temp.add(c1);
		temp.add(c2);
		temp.add(c3);
		cineplexArr.get(2).setCinemaArr(temp);

		cinemaArr.add(a1); // ID AA1
		cinemaArr.add(a2); // ID AA2
		cinemaArr.add(a3); // ID AA3
		cinemaArr.add(b1); // ID BB1
		cinemaArr.add(b2); // ID BB2
		cinemaArr.add(b3); // ID BB3
		cinemaArr.add(c1); // ID CC1
		cinemaArr.add(c2); // ID CC2
		cinemaArr.add(c3); // ID CC3

	}

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
		MovieToCSV.addMovieToCSV(a);
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
		}
		else if (csvRW.search("moviedatabase", "Name", title).get(3).equals("End of Showing")) {
			return false;
		}

		return true;
	}

	// boundary class needs to check that CinemaID and movietitle exists
	/**
	 * Takes in cinemeID, timing and movietitle. If cinemaID does not exists, prints
	 * error message and returns. Else, fetches the relevant cinema object and feeds
	 * into constructor of showtime object. Adds new showtime object to showtimeArr.
	 * Adds new showtime object to showtimedatabase. Adds showtimeID to
	 * moviedatabase for the relevant movie.
	 * 
	 * @param cinemaID   Cinema where showtime will be
	 * @param timing     Timing for showtime
	 * @param movietitle Title of movie to be showed in this showtime object
	 */
	public static void createShowtime(String cinemaID, String timing, String movietitle) {
		Cinema temp = null;

		for (int i = 0; i < cinemaArr.size(); i++) {
			if (cinemaID.equals(cinemaArr.get(i).getCinemaID())) {
				temp = cinemaArr.get(i);
				break;
			} else if (i == cinemaArr.size() - 1) {
				System.out.println("Invalid Cinema ID");
				return;
			}
		}
		String showtimes;
		Showtime showtime = new Showtime(temp, timing);
		showtimeArr.add(showtime);
		ShowtimeToCSV.addShowtimeToCSV(showtime);
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
	public static void updateShowtimes(String showtimeID, String cinemaID, String movietitle, String timing) {
		Cinema temp = null;
		String movieID;
		// checking if cinemaID exists
		for (int i = 0; i < cinemaArr.size(); i++) {
			if (cinemaID.equals(cinemaArr.get(i).getCinemaID())) {
				temp = cinemaArr.get(i);
				break;
			} else if (i == cinemaArr.size() - 1) {
				System.out.println("Invalid Cinema ID");
				return;
			}
		}
		// Check if movietitle exists
		ArrayList<String[]> moviedata = new ArrayList<String[]>(csvRW.readCSV("moviedatabase"));
		for (int i = 0; i < moviedata.size(); i++) {
			if (moviedata.get(i)[1].equals(movietitle)) {
				// check if showtimeID exists
				movieID = moviedata.get(i)[0];
				String[] showtimes = moviedata.get(1)[10].split(",");
				// if user tries to update new showtime a new one will be created
				for (int j = 0; j < showtimes.length; j++) {
					if (showtimes[j].equals(showtimeID))
						createShowtime(cinemaID, timing, movietitle);
				}
				break;
			} else if (i == moviedata.size() - 1) {
				System.out.println("Invalid Movie ID");
				return;
			}
		}
		csvRW.editCSV("showtimedatabase", showtimeID, "Timing", timing);
		return;
	}

	// TODO configure ticket prices, holiday
	/**
	 * Uses selection to determine what to change.
	 * 
	 * @param selection Selection of which type of price to change.
	 * @param p         Object Price to be changed.
	 * @param newPrice  New price to be set.
	 */
	public static void configureTicketprice(int selection, Price p, double newPrice) {
		switch (selection) {
		case (1):
			p.setPriceAdult(newPrice);
			System.out.println("Adult price updated");
			break;
		case (2):
			p.setPriceChild(newPrice);
			System.out.println("Child price updated");
			break;
		case (3):
			p.setPriceSenior(newPrice);
			System.out.println("Senior price updated");
			break;
		case (4):
			p.setPriceWeekend(newPrice);
			System.out.println("Weekend surcharge updated");
			break;
		case (5):
			p.setPriceHol(newPrice);
			System.out.println("Holiday surcharge updated");
			break;
		}
	}

	// not sure about this
	/**
	 * 
	 * @param selection Choice of what kind of date to add. "0" for holiday date,
	 *                  "1" for weekend date.
	 * @param date      date to be added to the calendar. Should be in
	 *                  <code>String</code> format YYYYMMDD.
	 * @param c         Calendar object date is to be added to.
	 */
	public static void configureDates(int selection, String date, Calendar c) {
		switch (selection) {
		case (1):
			c.addHolArr(date);
			System.out.println("Holiday date added");
			break;
		case (2):
			c.addWkndArr(date);
			System.out.println("Weekend date added");
			break;
		}
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
			for (int i = 0; i <= 5; i++) {
				output.add(String.format("%s : %d", movieObjArr.get(i).getName(),
						movieObjArr.get(i).getOverallUserRatingInDouble()));
			}
		case 2:
			Collections.sort(movieObjArr, salesComparator);
			for (int i = 0; i <= 5; i++) {
				output.add(String.format("%s : %d", movieObjArr.get(i).getName(), movieObjArr.get(i).getTicketSales()));
			}
		}
		return output;
	}

	/**
	 * Creates special dates that have special prices. Ie. holday dates and weekend
	 * dates.
	 * 
	 * @return calendar object
	 */
	public static Calendar createCalendar() {
		ArrayList<String> holDates = new ArrayList<String>();
		holDates.add("20191111");
		holDates.add("20191125");
		holDates.add("20191124");
		holDates.add("20191115");
		ArrayList<String> wkndDates = new ArrayList<String>();
		wkndDates.add("20191109");
		wkndDates.add("20191110");
		wkndDates.add("20191116");
		wkndDates.add("20191117");
		wkndDates.add("20191123");
		wkndDates.add("20191124");
		wkndDates.add("20191130");
		Calendar c = new Calendar(holDates, wkndDates);
		return c;

	}

}