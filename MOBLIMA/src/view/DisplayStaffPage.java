package view;

import java.util.Scanner;

import model.Calendar;
import model.Price;
import model.Showtime;
import controller.CalendarController;
import controller.CinemaController;
import controller.MovieController;
import controller.PriceController;
import controller.ShowtimeController;
import controller.StaffController;

import java.util.ArrayList;

/**
 * Boundary class between <code>MainDisplayPage</code> and
 * <code>controller</code> package. Provides printing and display of options in
 * staff module. Inherits from parent class <code>DisplayPageAb</code>.
 * 
 * @author Lim Wai Leong
 * @author Oh Jun Teng
 * @author Edhie Wahidin Michelle
 * @author Myat Hmu Khin
 * @version 1.0
 * @since 2019-11-09
 * @see controller
 * @see MainDisplayPage
 * @see DisplayPageAb
 *
 */
public class DisplayStaffPage extends DisplayPageAb {

	/**
	 * Displays the initial menu page shown to the staff after login. Calls the
	 * appropriate methods for each menu option.
	 * 
	 */
	public void menu() {
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
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
			System.out.println("Enter (8) to view information");
			System.out.println("Enter (9) to add a new staff account");
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
				System.out.println("Invalid Input. Please enter a number between 1 and 9.");

			}
			switch (input) {
			case 1:
				addMovie();
				super.enterToReturn();
				break;
			case 2:
				editMovieDetails();
				super.enterToReturn();
				break;
			case 3:
				addShowtime();
				super.enterToReturn();
				break;
			case 4:
				editShowtimeDetails();
				super.enterToReturn();
				break;
			case 5:
				editTicketPrice();
				super.enterToReturn();
				break;
			case 6:
				newHolidayDate();
				super.enterToReturn();
				break;
			case 7:
				newWeekendDate();
				super.enterToReturn();
				break;
			case 8:
				viewInfo();
				break;
			case 9:
				newStaffacc();
				super.enterToReturn();
				break;
			case 10:
				loop = false;
				break;
			}

		}

	}

	/**
	 * Displays the menu page shown to the staff after selecting the view info
	 * option
	 * 
	 */
	public void viewInfo() {
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter (1) to view list of movies.");
			System.out.println("Enter (2) to view list of showtimes");
			System.out.println("Enter (3) to view list of holiday/weekend dates");
			System.out.println("Enter (4) to view list of prices/surcharges");
			System.out.println("Enter (5) to view list of top 5 movies by ticket sales.");
			System.out.println("Enter (6) to view list of top 5 movies by overall reviewers' ratings.");
			System.out.println("Enter (7) to return to staff menu.");
			int input;
			while (true) {
				if (sc.hasNextInt()) {
					input = sc.nextInt();
					if (input >= 1 && input <= 7) {
						break;
					}
				} else {
					sc.next();
				}
				System.out.println("Invalid Input. Please enter a number between 1 and 8.");
			}
			switch (input) {
			case 1:
				DisplayUserPage.displayAllMovie();
				super.enterToReturn();
				break;
			case 2:
				displayAllShowtimes();
				super.enterToReturn();
				break;
			case 3:
				displayHolWkndDates();
				super.enterToReturn();
				break;
			case 4:
				displayPrices();
				super.enterToReturn();
				break;
			case 5:
				DisplayUserPage.displayTopMovies(2);
				super.enterToReturn();
				break;
			case 6:
				DisplayUserPage.displayTopMovies(1);
				super.enterToReturn();
				break;
			case 7:
				super.enterToReturn();
				return;
			}
		}

	}

	/**
	 * Displays all the <code>Showtime</code> entries from showtime database.
	 */
	public static void displayAllShowtimes() {
		String[] arr = ShowtimeController.searchShowtimes();
		System.out.println("Showtime List:");
		System.out.println("---------------------------");
		for (int i = 0; i < arr.length - 1; i++) {
			System.out.println(arr[i]);
		}
	}

	/**
	 * Displays the holiday dates and weekend dates from the <code>Calendar</code>
	 * object.
	 */
	public static void displayHolWkndDates() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter (1) to view list of holiday dates.");
		System.out.println("Enter (2) to view list of weekend dates");
		int input;
		while (true) {
			if (sc.hasNextInt()) {
				input = sc.nextInt();
				if (input >= 1 && input <= 2) {
					break;
				}
			} else {
				sc.next();
			}
			System.out.println("Invalid Input. Please enter a number between 1 and 8.");
		}
		switch (input) {
		case 1:
			ArrayList<String> holArr = new ArrayList<String>(CalendarController.calendar.getHolArr());
			System.out.println("Holiday dates are:");
			for (int i = 0; i < holArr.size(); i++) {
				System.out.println(holArr.get(i).substring(0, 4) + "/" + holArr.get(i).substring(4, 6) + "/"
						+ holArr.get(i).substring(6, 8));
			}
			break;
		case 2:
			ArrayList<String> WkndArr = new ArrayList<String>(CalendarController.calendar.getWeekendArr());
			System.out.println("Holiday dates are:");
			for (int i = 0; i < WkndArr.size(); i++) {
				System.out.println(WkndArr.get(i).substring(0, 4) + "/" + WkndArr.get(i).substring(4, 6) + "/"
						+ WkndArr.get(i).substring(6, 8));
			}
			break;
		}
	}

	/**
	 * Displays all the prices from the <code>Price</code> object.
	 */
	public static void displayPrices() {
		System.out.println("Adult price:      $" + PriceController.price.getPriceAdult());
		System.out.println("Child price:      $" + PriceController.price.getPriceChild());
		System.out.println("Senior price:     $" + PriceController.price.getPriceSenior());
		System.out.println(
				"Weekend price:    " + ((double) PriceController.price.getPriceWeekend() * 100) + "% surcharge");
		System.out.println("Holiday price:    $" + PriceController.price.getPriceHol() + " flat increase");
		System.out.println("Gold class price: $" + PriceController.price.getPriceGoldClass());
		System.out.println("3D movie price:   $" + PriceController.price.getPrice3D() + " flat increase");
		System.out.println();
	}

	/**
	 * Allows staff to add a new movie. Takes input from user for the movie details.
	 * Creates a new <code>Movie</code> object with the details and adds it into the
	 * movie database.
	 * 
	 */
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
		int input = editConfirmation();
		switch (input) {
		case (1):
			MovieController.createMovie(name, showingStatus, synopsis, castList, director, type, movieRating);
			System.out.println("Movie added successfully");
			return;
		case (2):
			addMovie();
			return;
		case (3):
			return;

		}

	}

	/**
	 * Edits selected movie details. Gets user input to decide which movie to edit.
	 * First performs a check in the database to determine if the movie exists. It
	 * then uses selection to determine which attribute of the movie to edit.
	 * 
	 */
	public static void editMovieDetails() {
		Scanner sc = new Scanner(System.in);
		DisplayUserPage.displayAllMovie();
		System.out.println("Enter name of movie to edit:");
		String name = sc.nextLine();
		if (!MovieController.movieExists(name)) {
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
					if (input >= 1 && input <= 7) {
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
					MovieController.editMovieStringDetails(1, name, change);
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
					MovieController.editMovieStringDetails(2, name, change);
					return;
				case (2):
					continue;
				case (3):
					return;
				}
				break;
			case (3):
				System.out.println("Enter new showing status:");
				change = sc.nextLine();
				input = editConfirmation();
				switch (input) {
				case (1):
					MovieController.editMovieStringDetails(3, name, change);
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
					MovieController.editMovieStringDetails(4, name, change);
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
					MovieController.editMovieStringDetails(5, name, change);
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
					MovieController.editMovieStringDetails(6, name, change);
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
					MovieController.editMovieStringDetails(7, name, change);
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

	/**
	 * Display for creation of new staff accoun.
	 */
	public static void newStaffacc() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter new username:");
		String newUser = sc.nextLine();
		System.out.println("Enter new password:");
		String newPw = sc.nextLine();
		StaffController.createStaff(newUser, newPw);
		System.out.println("New staff account created");
		return;
	}

	/**
	 * Gets user input for the showtime details for staff to add a new showtime.
	 * Checks if the details are valid. Gets input for new time and edits the
	 * database
	 * 
	 * @see Showtime
	 * 
	 */
	public static void addShowtime() {
		Scanner sc = new Scanner(System.in);
		DisplayUserPage.displayAllMovie();
		System.out.println("Enter the movie to add a new showtime for:");
		String movie = sc.nextLine();
		if (!MovieController.movieExists(movie)) {
			System.out.println("Movie does not exist");
			addShowtime();
			return;
		}
		boolean loop = true;
		CinemaController.createCineplexAndCinemas();
		String cinemaID = null;
		while (loop) {
			System.out.println("Enter cinema to add showtime:");
			System.out.println("List of cinema IDs:");
			System.out.println("AA1, AA2, AA3, BB1, BB2, BB3, CC1, CC2, CC3");
			cinemaID = sc.nextLine();
			for (int j = 0; j < CinemaController.cinemaArr.size(); j++) {
				if (cinemaID.equals(CinemaController.cinemaArr.get(j).getCinemaID())) {
					loop = false;
					break;
				} else if (j == CinemaController.cinemaArr.size() - 1) {
					System.out.println("Invalid Cinema ID");
					continue;
				}
			}
		}
		System.out.println("Enter date for new showtime (YYYYMMDD)");
		String date = sc.next();
		System.out.println("Enter time for new showtime (24h format)");
		String time = sc.next();
		String timing = date + time;

		int input = editConfirmation();

		switch (input) {
		case (1):
			ShowtimeController.createShowtime(cinemaID, timing, movie);
			System.out.println("New showtime added successfuly");
			return;
		case (2):
			addShowtime();
			return;
		case (3):
			return;

		}

	}

	/**
	 * Gets user input to determine which showtime is to be edited. Checks are done
	 * to ensure a existing showtime is edited. Gets input for new time and edits
	 * the database.
	 * 
	 * @see Showtime
	 */
	public static void editShowtimeDetails() {
		Scanner sc = new Scanner(System.in);
		DisplayUserPage.displayAllMovie();
		System.out.println("Enter the movie to be updated:");
		String movie = sc.nextLine();
		if (!MovieController.movieExists(movie)) {
			System.out.println("Movie does not exist");
			editShowtimeDetails();
			return;
		}
		boolean loop = true;
		System.out.println("List of showtimes: ");
		int ID = MovieController.searchOneMovie(movie);
		String[][] showtimes = ShowtimeController.getShowtimesForMovie(ID);
		for (int i = 0; i < showtimes.length; i++) {
			String showstring = showtimes[i][1];
			String timedate = showstring.substring(0, 4) + "-" + showstring.substring(4, 6) + "-"
					+ showstring.substring(6, 8) + " " + showstring.substring(8);
			System.out.println("Showtime ID: " + showtimes[i][0]);
			System.out.println("Time and Date: " + timedate);
			System.out.println("-----------------------------------------------");
		}
		System.out.println("Enter showtimeID to edit:");
		String showtimeID = sc.next();
		System.out.println("Enter date for new showtime (YYYYMMDD)");
		String date = sc.next();
		System.out.println("Enter time for new showtime (24h format)");
		String time = sc.next();
		String timing = date + time;
		ShowtimeController.updateShowtimes(showtimeID, movie, timing);
		System.out.println("Showtime updated successfully");
	}

	/**
	 * Edits the attributes of the <code>Price</code> object. Uses selection to
	 * determine which attribute to edit.
	 * 
	 * @see Price
	 * 
	 */
	public static void editTicketPrice() {
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
			System.out.println("Enter (6) to edit Gold class price");
			System.out.println("Enter (7) to edit 3D movie price");
			while (true) {
				if (sc.hasNextInt()) {
					input = sc.nextInt();
					if (input >= 1 && input <= 7) {
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
					PriceController.configureTicketprice(1, PriceController.price, newPrice);
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
					PriceController.configureTicketprice(2, PriceController.price, newPrice);
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
					PriceController.configureTicketprice(3, PriceController.price, newPrice);
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
					PriceController.configureTicketprice(4, PriceController.price, newPrice);
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
					PriceController.configureTicketprice(5, PriceController.price, newPrice);
					return;
				case (2):
					continue;
				case (3):
					return;
				}
				break;
			case (6):
				while (true) {
					System.out.println("Enter new gold class price:");
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
					PriceController.configureTicketprice(6, PriceController.price, newPrice);
					return;
				case (2):
					continue;
				case (3):
					return;
				}
				break;
			case (7):
				while (true) {
					System.out.println("Enter new 3D movie price:");
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
					PriceController.configureTicketprice(7, PriceController.price, newPrice);
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

	/**
	 * Adds a new holiday date to the <code>Calendar</code> object.
	 * 
	 * @see Calendar#addHolArr(String)
	 * 
	 */
	public static void newHolidayDate() {
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
		CalendarController.configureDates(1, Integer.toString(date), CalendarController.calendar);
	}

	/**
	 * Adds a new weekend date to the <code>Calendar</code> object
	 * 
	 * @see Calendar#addWkndArr(String)
	 */
	public static void newWeekendDate() {
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
		CalendarController.configureDates(2, Integer.toString(date), CalendarController.calendar);
	}

	/**
	 * Selection statement to act as confirmation for actions
	 * 
	 * @return input of scanner
	 */
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

	/**
	 * Program will only continue after enter key is inputed. Method is used between
	 * selection of options
	 * 
	 */

}
