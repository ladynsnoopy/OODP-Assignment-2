package view;

import java.util.Scanner;

import model.Calendar;
import model.Price;
import model.Showtime;
import controller.StaffApp;

import java.util.ArrayList;

/**
 * Boundary class between <code>MainDisplayPage</code> and
 * <code>StaffApp</code>. Provides printing and display of options in staff
 * module.
 * 
 * @author Lim Wai Leong
 * @version 1.0
 * @since 2019-11-09
 * @see StaffApp
 * @see MainDisplayPage
 *
 */
public interface DisplayStaffPage extends MainDisplayPage {

	/**
	 * Displays the initial menu page shown to the staff after login. Calls the
	 * appropriate methods for each menu option.
	 * 
	 */
	public static void displayStaffPage() {
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
				enterToReturn();
				break;
			case 2:
				editMovieDetails();
				enterToReturn();
				break;
			case 3:
				addShowtime();
				enterToReturn();
				break;
			case 4:
				editShowtimeDetails();
				enterToReturn();
				break;
			case 5:
				editTicketPrice();
				enterToReturn();
				break;
			case 6:
				newHolidayDate();
				enterToReturn();
				break;
			case 7:
				newWeekendDate();
				enterToReturn();
				break;
			case 8:
				viewInfo();
				enterToReturn();
				break;
			case 9:
				newStaffacc();
				enterToReturn();
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
	public static void viewInfo() {
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
				enterToReturn();
				break;
			case 2:
				displayAllShowtimes();
				enterToReturn();
				break;
			case 3:
				displayHolWkndDates();
				enterToReturn();
				break;
			case 4:
				displayPrices();
				enterToReturn();
				break;
			case 5:
				DisplayUserPage.displayTopMovies(2);
				enterToReturn();
				break;
			case 6:
				DisplayUserPage.displayTopMovies(1);
				enterToReturn();
				break;
			case 7:
				enterToReturn();
				return;
			}
		}

	}

	/**
	 * Displays all the <code>Showtime</code> entries from showtime database.
	 */
	public static void displayAllShowtimes() {
		String[] arr = StaffApp.searchShowtimes();
		System.out.println("Showtime List:");
		System.out.println("---------------------------");
		for (int i = 1; i < arr.length; i++) {
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
			ArrayList<String> holArr = new ArrayList<String>(StaffApp.calendar.getHolArr());
			System.out.println("Holiday dates are:");
			for (int i = 0; i < holArr.size(); i++) {
				System.out.println(holArr.get(i).substring(0, 4) + "/" + holArr.get(i).substring(4, 6) + "/"
						+ holArr.get(i).substring(6, 8));
			}
			break;
		case 2:
			ArrayList<String> WkndArr = new ArrayList<String>(StaffApp.calendar.getWeekendArr());
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
		System.out.println("Adult price:      $" + StaffApp.price.getPriceAdult());
		System.out.println("Child price:      $" + StaffApp.price.getPriceChild());
		System.out.println("Senior price:     $" + StaffApp.price.getPriceSenior());
		System.out.println("Weekend price:    " + ((double) StaffApp.price.getPriceWeekend() * 100) + "% surcharge");
		System.out.println("Holiday price:    $" + StaffApp.price.getPriceHol() + " flat increase");
		System.out.println("Gold class price: $" + StaffApp.price.getPriceGoldClass());
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

	/**
	 * Edits selected movie details. Gets user input to decide which movie to edit.
	 * First performs a check in the database to determine if the movie exists. It
	 * then uses selection to determine which attribute of the movie to edit.
	 * 
	 */
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

	
	public static void newStaffacc() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter new username:");
		String newUser = sc.nextLine();
		System.out.println("Enter new passwork:");
		String newPw = sc.nextLine();
		StaffApp.createStaff(newUser, newPw);
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

		StaffApp.createShowtime(cinemaID, timing, movie);
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

		System.out.println("Enter showtimeID to edit:");
		String showtimeID = sc.next();
		System.out.println("Enter new timing for the showtime:");
		String timing = sc.next();
		StaffApp.updateShowtimes(showtimeID, cinemaID, movie, timing);

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
			while (true) {
				if (sc.hasNextInt()) {
					input = sc.nextInt();
					if (input >= 1 && input <= 5) {
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
					StaffApp.configureTicketprice(1, StaffApp.price, newPrice);
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
					StaffApp.configureTicketprice(2, StaffApp.price, newPrice);
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
					StaffApp.configureTicketprice(3, StaffApp.price, newPrice);
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
					StaffApp.configureTicketprice(4, StaffApp.price, newPrice);
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
					StaffApp.configureTicketprice(5, StaffApp.price, newPrice);
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
		StaffApp.configureDates(1, Integer.toString(date), StaffApp.calendar);
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
		StaffApp.configureDates(2, Integer.toString(date), StaffApp.calendar);
	}


	/**
	 * Selection statement to act as confirmation for actions
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
	public static void enterToReturn() {
		System.out.println("Press enter to return\n");
		try {
			System.in.read();
		} catch (Exception e) {
		}
	}
}
