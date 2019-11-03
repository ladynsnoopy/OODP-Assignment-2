package cinema;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StaffApp {
	public static ArrayList<Cineplex> cineplexArr = new ArrayList<Cineplex>();
	public static ArrayList<Cinema> cinemaArr = new ArrayList<Cinema>();

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
		Cineplex cowboyTown = new Cineplex("NTU");
		Cineplex jurassicPark = new Cineplex("NUS");
		Cineplex theCentral = new Cineplex("SMU");

		cineplexArr.add(cowboyTown);
		cineplexArr.add(jurassicPark);
		cineplexArr.add(theCentral);

		Cinema a1 = new Cinema("Normal", 10, 10, cowboyTown);
		Cinema a2 = new Cinema("Normal", 10, 15, cowboyTown);
		Cinema a3 = new Cinema("Gold Class", 5, 5, cowboyTown);

		Cinema b1 = new Cinema("Normal", 10, 10, jurassicPark);
		Cinema b2 = new Cinema("Normal", 10, 15, jurassicPark);
		Cinema b3 = new Cinema("Gold Class", 5, 5, jurassicPark);

		Cinema c1 = new Cinema("Normal", 10, 10, theCentral);
		Cinema c2 = new Cinema("Normal", 10, 15, theCentral);
		Cinema c3 = new Cinema("Gold Class", 5, 5, theCentral);

		cinemaArr.add(a1); // ID 1
		cinemaArr.add(a2); // ID 2
		cinemaArr.add(a3); // ID 3
		cinemaArr.add(b1); // ID 4
		cinemaArr.add(b2); // ID 5
		cinemaArr.add(b3); // ID 6
		cinemaArr.add(c1); // ID 7
		cinemaArr.add(c2); // ID 8
		cinemaArr.add(c3); // ID 9
	}

	public static void createMovie(String name, String showingStatus, String synopsis, ArrayList<String> cast,
			ArrayList<String> director, String type, String movieRating) {
		Movie a = new Movie(name, showingStatus, synopsis, cast, director, type, movieRating);
		MovieToCSV.addMovieToCSV(a);
	}

	// 1:title 2:type 3:status 4:synopsis 5:rating 6:director 7:cast 8:showtime shit
	// boundary class asks for which to change, if 1-5 use this function
	public static void editMovieStringDetails(int selection, String change) {
		switch (selection) {
		case 1:

		}

	}

	public static void createShowtime(String cinemaID, String timing, String movietitle) {
		Cinema temp = null;
		String showtimes;
		for (int i = 0; i < cinemaArr.size(); i++) {
			if (cinemaID == cinemaArr.get(i).getCinemaID()) {
				temp = cinemaArr.get(i);
				break;
			}
		}
		Showtime showtime = new Showtime(temp, timing);
		ShowtimeToCSV.addShowtimeToCSV(showtime);
		//adding showtimeID to moviedatabase
		ArrayList<String> result = csvRW.search("moviedatabase", "Name", movietitle);
		String id = result.get(0);
		
		if (result.get(10) == null) {
			List<String> showtimelist = new ArrayList<String>();
			showtimelist.add(Integer.toString(showtime.getShowtimeID()));
			showtimes = showtimelist.toString();
		} else {
			showtimes = result.get(10);
			int stringsize = showtimes.length();
			showtimes = showtimes.substring(1, stringsize - 1); // cuts off brackets
			List<String> showtimelist = Arrays.asList(showtimes.split("\\s*,\\s*"));
			showtimelist.add(Integer.toString(showtime.getShowtimeID()));
			showtimes = showtimelist.toString();
		}
		csvRW.editCSV("moviedatabase", id, "Showtime", showtimes);
		
	}

}
