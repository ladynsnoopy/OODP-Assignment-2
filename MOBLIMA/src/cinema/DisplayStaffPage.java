package cinema;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Boundary class specifically for staff operations. Will be called by
 * <code>MainDisplayPage</code> when staff module is selected. Mainly contains
 * of menu options as well as preventing errors from occuring due to the input.
 * 
 * @author Myat Hmu Khin
 * @author Lim Wai Leong
 * @author Edhie Wahidin Michelle
 * @version 1.0
 * @since 2019-11-10
 *
 */
public class DisplayStaffPage {
//TODO @jun teng finish commenting documentation
	public static void displayStaffPage() {
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		Price p = new Price();
		Calendar c = StaffApp.calendar;
		// do customer initialisation stuff
		while (loop) {
			System.out.println("What would you like to do?");
			System.out.println("Enter (1) to add a new movie.");
			System.out.println("Enter (2) to edit existing movie details");
			System.out.println("Enter (3) to add a new showtime");
			System.out.println("Enter (4) to edit existing showtime details");
			System.out.println("Enter (5) to edit ticket prices");
			System.out.println("Enter (6) to add a new holiday date");
			System.out.println("Enter (7) to add a new weekend date");
			System.out.println("Enter (8) to view list of top 5 movies by ticket sales.");
			System.out.println("Enter (9) to view list of top 5 movies by overall reviewers' ratings.");
			System.out.println("Enter (10) to exit");
			int input;
			while (true) {
				if (sc.hasNextInt()) {
					input = sc.nextInt();
					if (input >= 1 && input <= 10) {
						break;
					}
				} else {
					sc.next();
				}
				System.out.println("Invalid Input. Please enter a number between 1 and 7.");

			}
			switch (input) {
			case 1:
				addMovie();
				System.out.println("Press enter to return\n");
				try {
					System.in.read();
				} catch (Exception e) {
				}
				break;
			case 2:
				editMovieDetails();
				System.out.println("Press enter to return\n");
				try {
					System.in.read();
				} catch (Exception e) {
				}
				break;
			case 3:
				addShowtime();
				System.out.println("Press enter to return\n");
				try {
					System.in.read();
				} catch (Exception e) {
				}
				break;
			case 4:
				editShowtimeDetails();
				System.out.println("Press enter to return\n");
				try {
					System.in.read();
				} catch (Exception e) {
				}
				break;
			case 5:
				editTicketPrice(p);
				System.out.println("Press enter to return\n");
				try {
					System.in.read();
				} catch (Exception e) {
				}
				break;
			case 6:
				newHolidayDate(c);
				System.out.println("Press enter to return\n");
				try {
					System.in.read();
				} catch (Exception e) {
				}
				break;
			case 7:
				newWeekendDate(c);
				System.out.println("Press enter to return\n");
				try {
					System.in.read();
				} catch (Exception e) {
				}
				break;
			case 8:
				DisplayUserPage.displayTopMovies(2);
				break;
			case 9:
				DisplayUserPage.displayTopMovies(1);
				break;
			case 10: // call view Top 5 movie
				loop = false;
				break;
			}

		}

	}

	public static void addMovie() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of the movie:");
		String name = sc.nextLine();
		System.out.println("Enter the showing status of the movie:");
		String showingStatus = sc.nextLine();
		System.out.println("Enter the synopsis:");
		String synopsis = sc.nextLine();
		System.out.println("Enter cast members(separated by commas):");
		String cast = sc.nextLine();
		ArrayList<String> castList = new ArrayList<String>();
		String[] castArr = cast.split(",");
		for (String s : castArr)
			castList.add(s);
		System.out.println("Enter director:");
		String director = sc.nextLine();
		System.out.println("Enter type(genre) of movie:");
		String type = sc.nextLine();
		System.out.println("Enter the age rating for the movie:");
		String movieRating = sc.nextLine();
		System.out.println("Press (1) to confirm details");
		System.out.println("Press (2) to re-enter details");
		System.out.println("Press (3) to cancel and return to menu");
		int input;
		while (true) {
			if (sc.hasNextInt()) {
				input = sc.nextInt();
				if (input >= 1 && input <= 3) {
					break;
				}
			} else {
				sc.next();
			}
			System.out.println("Invalid Input. Please enter a number between 1 and 3.");
		}
//		sc.close();
		switch (input) {
		case (1):
			StaffApp.createMovie(name, showingStatus, synopsis, castList, director, type, movieRating);
			return;
		case (2):
			addMovie();
			return;
		case (3):
			return;

		}

	}

	public static void editMovieDetails() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name of movie to edit:");
		String name = sc.nextLine();
		if (!StaffApp.movieExists(name)) {
			System.out.println("Movie does not exist");
			editMovieDetails();
			return;
		}

		Boolean loop = true;
		int input;
		String change;
		while (loop) {
			System.out.println("Enter (1) to edit movie title");
			System.out.println("Enter (2) to edit movie type(genre)");
			System.out.println("Enter (3) to edit showing status");
			System.out.println("Enter (4) to edit movie synopsis");
			System.out.println("Enter (5) to edit movie rating");
			System.out.println("Enter (6) to edit movie director");
			System.out.println("Enter (7) to edit movie cast");
			while (true) {
				if (sc.hasNextInt()) {
					input = sc.nextInt();
					if (input >= 1 && input <= 8) {
						sc.nextLine();
						break;
					}
				} else
					sc.next();
			}

			switch (input) {
			case (1):
				System.out.println("Enter new title:");
				change = sc.nextLine();
				input = editConfirmation();
				switch (input) {
				case (1):
					StaffApp.editMovieStringDetails(1, name, change);
					return;
				case (2):
					continue;
				case (3):
					return;
				}
				break;
			case (2):
				System.out.println("Enter new type for movie:");
				change = sc.nextLine();
				input = editConfirmation();
				switch (input) {
				case (1):
					StaffApp.editMovieStringDetails(2, name, change);
					return;
				case (2):
					continue;
				case (3):
					return;
				}
				break;
			case (3):
				// TODO remove showtimes when status set to end of showing
				System.out.println("Enter new showing status:");
				change = sc.nextLine();
				input = editConfirmation();
				switch (input) {
				case (1):
					StaffApp.editMovieStringDetails(3, name, change);
					return;
				case (2):
					continue;
				case (3):
					return;
				}
				break;
			case (4):
				System.out.println("Enter new synopsis:");
				change = sc.nextLine();
				input = editConfirmation();
				switch (input) {
				case (1):
					StaffApp.editMovieStringDetails(4, name, change);
					return;
				case (2):
					continue;
				case (3):
					return;
				}
				break;
			case (5):
				System.out.println("Enter new rating:");
				change = sc.nextLine();
				input = editConfirmation();
				switch (input) {
				case (1):
					StaffApp.editMovieStringDetails(5, name, change);
					return;
				case (2):
					continue;
				case (3):
					return;
				}
				break;
			case (6):
				System.out.println("Enter new director name:");
				change = sc.nextLine();
				input = editConfirmation();
				switch (input) {
				case (1):
					StaffApp.editMovieStringDetails(6, name, change);
					return;
				case (2):
					continue;
				case (3):
					return;
				}
				break;
			case (7):
				System.out.println("Enter new cast:");
				change = sc.nextLine();
				input = editConfirmation();
				switch (input) {
				case (1):
					StaffApp.editMovieStringDetails(7, name, change);
					return;
				case (2):
					continue;
				case (3):
					return;
				}
				break;
			}
		}
	}

	public static void addShowtime() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the movie to be added");
		String movie = sc.nextLine();
		System.out.println(movie);
		if (!StaffApp.movieExists(movie)) {
			System.out.println("Movie does not exist");
			addShowtime();
			return;
		}
		boolean loop = true;
		StaffApp.createCineplexAndCinemas();
		String cinemaID = null;
		while (loop) {
			System.out.println("Enter cinema to add showtime:");
			cinemaID = sc.nextLine();
			for (int i = 0; i < StaffApp.cinemaArr.size(); i++) {
				if (cinemaID.equals(StaffApp.cinemaArr.get(i).getCinemaID())) {
					loop = false;
					break;
				} else if (i == StaffApp.cinemaArr.size() - 1) {
					System.out.println("Invalid Cinema ID");
					continue;
				}
			}
		}
		while (true) {
			System.out.println("Enter date for new showtime (YYMMDD)");
			String date = sc.next();
			System.out.println("Enter time for new showtime (24h format)");
			String time = sc.next();
			String timing = date + time;

			System.out.println("Press (1) to confirm edit");
			System.out.println("Press (2) to re-enter edit");
			System.out.println("Press (3) to cancel and return to menu");
			int input;
			while (true) {
				if (sc.hasNextInt()) {
					input = sc.nextInt();
					if (input >= 1 && input <= 3) {
						sc.nextLine();
						break;
					}
				} else {
					sc.next();
				}
				System.out.println("Invalid Input. Please enter a number between 1 and 3.");
			}
			switch (input) {
			case (1):
				StaffApp.createShowtime(cinemaID, timing, movie);
				return;
			case (2):
				continue;
			case (3):
				return;
			}
		}

	}

	public static void editShowtimeDetails() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the movie to be updated:");
		String movie = sc.nextLine();
		System.out.println(movie);
		if (!StaffApp.movieExists(movie)) {
			System.out.println("Movie does not exist");
			editShowtimeDetails();
			return;
		}
		boolean loop = true;
		StaffApp.createCineplexAndCinemas();
		String cinemaID = null;
		while (loop) {
			System.out.println("Enter cinema to update showtime:");
			cinemaID = sc.nextLine();
			for (int i = 0; i < StaffApp.cinemaArr.size(); i++) {
				if (cinemaID.equals(StaffApp.cinemaArr.get(i).getCinemaID())) {
					loop = false;
					break;
				} else if (i == StaffApp.cinemaArr.size() - 1) {
					System.out.println("Invalid Cinema ID");
					continue;
				}
			}
		}

		ArrayList<String> moviedata = new ArrayList<String>(csvRW.search("moviedatabase", "Name", movie));
		String existingIDs = moviedata.get(10);

		System.out.println("Enter showtimeID to edit:");
		String showtimeID = sc.next();

		if (existingIDs.contains(showtimeID)) {
			System.out.println("Enter new timing for the showtime:");
			String timing = sc.next();
			StaffApp.updateShowtimes(showtimeID, cinemaID, movie, timing);
			return;
		} else {
			System.out.println("Showtime does not exist for movie");
			System.out.println("Returning to menu");
			return;
		}

	}

	public static void editTicketPrice(Price p) {
		Scanner sc = new Scanner(System.in);
		int input;
		boolean loop = true;
		double newPrice;

		while (loop) {
			System.out.println("Enter (1) to edit adult price");
			System.out.println("Enter (2) to edit child price");
			System.out.println("Enter (3) to edit senior price");
			System.out.println("Enter (4) to edit weekend percentage surcharge");
			System.out.println("Enter (5) to edit flat holiday surcharge");
			while (true) {
				if (sc.hasNextInt()) {
					input = sc.nextInt();
					if (input >= 1 && input <= 8) {
						sc.nextLine();
						break;
					}
				} else
					sc.next();
			}

			switch (input) {
			case (1):
				while (true) {
					System.out.println("Enter new adult price:");
					if (sc.hasNextDouble()) {
						newPrice = sc.nextDouble();
						break;
					} else {
						sc.next();
						System.out.println("Invalid input");
						continue;
					}
				}
				input = editConfirmation();
				switch (input) {
				case (1):
					StaffApp.configureTicketprice(1, p, newPrice);
					return;
				case (2):
					continue;
				case (3):
					return;
				}
				break;
			case (2):
				while (true) {
					System.out.println("Enter new child price:");
					if (sc.hasNextDouble()) {
						newPrice = sc.nextDouble();
						break;
					} else {
						sc.next();
						System.out.println("Invalid input");
						continue;
					}
				}
				input = editConfirmation();
				switch (input) {
				case (1):
					StaffApp.configureTicketprice(2, p, newPrice);
					return;
				case (2):
					continue;
				case (3):
					return;
				}
				break;
			case (3):
				while (true) {
					System.out.println("Enter new senior price:");
					if (sc.hasNextDouble()) {
						newPrice = sc.nextDouble();
						break;
					} else {
						sc.next();
						System.out.println("Invalid input");
						continue;
					}
				}
				input = editConfirmation();
				switch (input) {
				case (1):
					StaffApp.configureTicketprice(3, p, newPrice);
					return;
				case (2):
					continue;
				case (3):
					return;
				}
				break;
			case (4):
				while (true) {
					System.out.println("Enter new weekend percentage surcharge:");
					if (sc.hasNextDouble()) {
						newPrice = sc.nextDouble();
						newPrice = newPrice / 100;
						break;
					} else {
						sc.next();
						System.out.println("Invalid input");
						continue;
					}
				}
				input = editConfirmation();
				switch (input) {
				case (1):
					StaffApp.configureTicketprice(4, p, newPrice);
					return;
				case (2):
					continue;
				case (3):
					return;
				}
				break;
			case (5):
				while (true) {
					System.out.println("Enter new flat holiday surcharge:");
					if (sc.hasNextDouble()) {
						newPrice = sc.nextDouble();
						break;
					} else {
						sc.next();
						System.out.println("Invalid input");
						continue;
					}
				}
				input = editConfirmation();
				switch (input) {
				case (1):
					StaffApp.configureTicketprice(5, p, newPrice);
					return;
				case (2):
					continue;
				case (3):
					return;
				}
				break;

			}

		}
	}

	public static void newHolidayDate(Calendar c) {
		Scanner sc = new Scanner(System.in);

		int date;
		while (true) {
			System.out.println("Enter a new holiday date(YYYYMMDD):");
			if (sc.hasNextInt()) {
				date = sc.nextInt();
				break;
			} else {
				sc.next();
			}
			System.out.println("Invalid Input");
		}
		StaffApp.configureDates(1, Integer.toString(date), c);
	}

	public static void newWeekendDate(Calendar c) {
		Scanner sc = new Scanner(System.in);

		int date;
		while (true) {
			System.out.println("Enter a new weekend date(YYYYMMDD):");
			if (sc.hasNextInt()) {
				date = sc.nextInt();
				break;
			} else {
				sc.next();
			}
			System.out.println("Invalid Input");
		}
		StaffApp.configureDates(2, Integer.toString(date), c);
	}

	public static int editConfirmation() {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Press (1) to confirm edit");
		System.out.println("Press (2) to re-enter edit");
		System.out.println("Press (3) to cancel and return to menu");
		int input;
		while (true) {
			if (sc1.hasNextInt()) {
				input = sc1.nextInt();
				if (input >= 1 && input <= 3) {
					sc1.nextLine();
					break;
				}
			} else {
				sc1.next();
			}
			System.out.println("Invalid Input. Please enter a number between 1 and 3.");
		}
		return input;
	}

}
