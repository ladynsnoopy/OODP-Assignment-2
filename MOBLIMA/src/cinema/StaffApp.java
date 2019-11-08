package cinema;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StaffApp {
	public static ArrayList<Cineplex> cineplexArr = new ArrayList<Cineplex>();
	public static ArrayList<Cinema> cinemaArr = new ArrayList<Cinema>();
	public static ArrayList<Movie> movieArr = new ArrayList<Movie>();
	public static ArrayList<Showtime> showtimeArr = new ArrayList<Showtime>();

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
		System.out.println("Movie creation successful");
	}

	// 1:title 2:type 3:status 4:synopsis 5:rating 6:director 7:cast 8:showtime shit
	// boundary class asks for which to change, if 1-5 use this function
	public static void editMovieStringDetails(int selection, String moviename, String change) {
		ArrayList<String> result = csvRW.search("moviedatabase", "Name", moviename);
		String id = result.get(0);
		switch (selection) {
		case 1:
			csvRW.editCSV("moviedatabase", id, "Name", change);
			System.out.println("Movie title updated");
			break;
		case 2:
			csvRW.editCSV("moviedatabase", id, "Type", change);
			System.out.println("Type of movie updated");
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
			csvRW.editCSV("moviedatabase", id, "OverallRating", change);
			System.out.println("Rating updated");
			break;
		}
		// TODO finish edit of movie

	}

	// boundary class needs to check that CinemaID and movietitle exists
	public static void createShowtime(String cinemaID, String timing, String movietitle) {
		Cinema temp = null;
		String showtimes;
		for (int i = 0; i < cinemaArr.size(); i++) {
			if (cinemaID == cinemaArr.get(i).getCinemaID()) {
				temp = cinemaArr.get(i);
				break;
			} else if (i == cinemaArr.size() - 1) {
				System.out.println("Invalid Cinema ID");
				return;
			}
		}
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
		System.out.println("Showtime creation successful");
		return;
	}

	// TODO update showtimes
	// yo junteng mah man i think its right but pls double check for me HAHA
	public static void updateShowtimes(String showtimeID, String cinemaID, String movietitle, String timing) {
		Cinema temp = null;
		String movieID;
		// checking if cinemaID exists
		for (int i = 0; i < cinemaArr.size(); i++) {
			if (cinemaID == cinemaArr.get(i).getCinemaID()) {
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
					if (showtimes[j].equals(showtimeID)) {
						break;
					} else if (j == showtimes.length - 1) {
						System.out.println("ShowtimeID does not exist");
						return;
					}

				}
				break;
			} else if (i == moviedata.size() - 1) {
				System.out.println("Invalid Movie ID");
				return;
			}
		}
		csvRW.editCSV("showtimedatabase", showtimeID, "Timing", timing);
		System.out.println("Showtime updating successful");
		return;
	}

	// TODO configure ticket prices, holiday
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
			System.out.println("Weekend price updated");
			break;
		case (5):
			p.setPriceHol(newPrice);
			System.out.println("Holiday price updated");
			break;
		}
	}

	// not sure about this
	public static void configureHoliday(String hol, Calendar c) {
		c.addHolArr(hol);
		System.out.println("New holiday date added");
	}

}