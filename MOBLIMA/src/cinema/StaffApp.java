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
	
	public static void createStaff(String username, String password) {
		Staff a = new Staff(username, password);
		StaffToCSV.addStaffToCSV(a);
	}

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

	public static void createCineplexAndCinemas() {
		Cineplex cowboyTown = new Cineplex("NTU", "AA");
		Cineplex jurassicPark = new Cineplex("NUS", "BB");
		Cineplex theCentral = new Cineplex("SMU", "CC");

		cineplexArr.add(cowboyTown);
		cineplexArr.add(jurassicPark);
		cineplexArr.add(theCentral);

		Cinema a1 = new Cinema("Normal", 10, 10, cowboyTown, "AA1");
		Cinema a2 = new Cinema("Normal", 15, 10, cowboyTown, "AA2");
		Cinema a3 = new Cinema("Gold Class", 5, 5, cowboyTown, "AA3");

		Cinema b1 = new Cinema("Normal", 10, 10, jurassicPark, "BB1");
		Cinema b2 = new Cinema("Normal", 15, 10, jurassicPark, "BB2");
		Cinema b3 = new Cinema("Gold Class", 5, 5, jurassicPark, "BB3");

		Cinema c1 = new Cinema("Normal", 10, 10, theCentral, "CC1");
		Cinema c2 = new Cinema("Normal", 15, 11, theCentral, "CC2");
		Cinema c3 = new Cinema("Gold Class", 5, 5, theCentral, "CC3");

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

	public static void createMovie(String name, String showingStatus, String synopsis, ArrayList<String> cast,
			String director, String type, String movieRating, String cineplexID) {
		Movie a = new Movie(name, showingStatus, synopsis, cast, director, type, movieRating);
		movieArr.add(a);
		MovieToCSV.addMovieToCSV(a);
	}

	// 1:title 2:type 3:status 4:synopsis 5:rating 6:director 7:cast 8:showtime shit
	// boundary class asks for which to change, if 1-5 use this function
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
		case 7:
			csvRW.editCSV("moviedatabase", id, "Cast", change);
			System.out.println("Cast updated");
		}
	}
	
	public static boolean movieExists(String title) {
		if (csvRW.search("moviedatabase", "Name", title) == null)
			return false;
		return true;
	}
	

	// boundary class needs to check that CinemaID and movietitle exists
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
		ShowtimeToCSV.addShowtimeToCSV(showtime);
		// adding showtimeID to moviedatabase
		ArrayList<String> result = csvRW.search("moviedatabase", "Name", movietitle);
		String id = result.get(0);

		if (result.get(10).equals("")) {
			System.out.println(showtime.getShowtimeID());
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
	//yo junteng mah man i think its right but pls double check for me HAHA
	public static void updateShowtimes(String showtimeID, String cinemaID, String movietitle, String timing) {
		Cinema temp = null;
		String movieID;
		//checking if cinemaID exists
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
				//if user tries to update new showtime a new one will be created
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
		csvRW.editCSV("showtimedatabase", showtimeID , "Timing", timing);
		return;
	}

	// TODO configure ticket prices, holiday
	public static void configureTicketprice(int selection, Price p, double newPrice) {
		switch(selection) {
		case(1):
			p.setPriceAdult(newPrice);
		case(2):
			p.setPriceChild(newPrice);
		case(3):
			p.setPriceSenior(newPrice);
		case(4):
			p.setPriceWeekend(newPrice);
		case(5):
			p.setPriceHol(newPrice);
		}
	}

	//not sure about this
	public static void configureHoliday (String hol, Calendar c) {
		c.addHolArr(hol);
	}
	

	public static ArrayList<String> showTopMovies (int selection) {
		ArrayList<Movie> movieObjArr = CSVtoMovie.csvToMovieObject();
		OverallRatingComparator ratingsComparator = new OverallRatingComparator();
		TicketSalesComparator salesComparator = new TicketSalesComparator();
		ArrayList<String> output = new ArrayList<String>();

		// 1: sort by overall rating, 2: sort by total sales
		switch(selection) {
		case 1:
			Collections.sort(movieObjArr, ratingsComparator);
			for (int i=0; i<=5; i++) {
				output.add(String.format("%s : %d", movieObjArr.get(i).getName(), movieObjArr.get(i).getOverallUserRatingInDouble()));
			}
		case 2:
			Collections.sort(movieObjArr, salesComparator);
			for (int i=0; i<=5; i++) {
				output.add(String.format("%s : %d", movieObjArr.get(i).getName(), movieObjArr.get(i).getTicketSales()));
			}
		}
		return output;
	}
	
	
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