package controller;

import java.util.ArrayList;

import model.Customer;
import model.Movie;
import model.Receipt;
import model.Review;
import model.Showtime;
import model.Ticket;
import view.DisplayUserPage;

/**
 * An control class that will handle methods relating to the customer module. It
 * will manage and control objects that are necessary to allow the customer
 * module to search/list movies, view movie details, check seat availability and
 * allow selection of seats, book and purchase movie tickets, and view past
 * booking history of the customer.
 * 
 * 
 * @author Myat Hmu Khin
 * @author Lim Wai Leong
 * @version 1.0
 * @since 2019-11-10
 *
 */

public class CustomerApp implements DisplayUserPage {
	/**
	 * Creates a new customer object
	 * 
	 * @param name      Name of customer
	 * @param mobileNum Mobile Number of a customer
	 * @param email     Email of a customer
	 * @see Customer
	 */

	public static void createCustomer(String name, String mobileNum, String email) {
		Customer a = new Customer(name, mobileNum, email);
		a.addCustomerToCSV(a);
	}

	/**
	 * Checks if a customer is an existing customer
	 * 
	 * @param email Email of a customer
	 * @return -1 if customer's email is not found in the customer database. Returns
	 *         Customer ID if customer's email is found in the customer database
	 */
	public static int customerExists(String email) {
		if (csvRW.search("customerdatabase", "Email", email) == null)
			return -1;
		else {
			return Integer.parseInt(csvRW.search("customerdatabase", "Email", email).get(0));
		}
	}

	// returns a string array of movies
	/**
	 * Returns names of all movies that exist in database.
	 * 
	 * @return <code>String</code> array of movie names
	 */
	public static String[] searchMovies() {
		ArrayList<String[]> list = csvRW.readCSV("moviedatabase");
		String[] movies = new String[list.size()];
		int num = 0;
		for (int i = 0; i < list.size(); i++) {
			movies[num] = list.get(i)[1];
			num++;
		}
		return movies;
	}

	// link to Movie class
	// returns a 2d string array of timings for a particular movie eg.
	// [[ShowtimeID,Timing],[ShowtimeID,Timing],....]
	//
	/**
	 * Searches and returns a 2D array of showtime timings for a particular movie.
	 * Is meant to help in creating <code>Showtime</code> objects.
	 * 
	 * @param movieID movieID of target movie
	 * @return 2D array of showtime timings for a particular movie in
	 *         <code>[[ShowtimeID,Timing],[ShowtimeID,Timing],....]</code> format
	 * @see Showtime
	 */
	public static String[][] getShowtimesForMovie(int movieID) {
		ArrayList<String> result = csvRW.search("moviedatabase", "MovieID", Integer.toString(movieID));
		if (result == null)
			return null;
		String a = result.get(10); // Get all the showtimeID of the particular movie
		if (a.length() != 1) {
			String cut = a.substring(1, a.length() - 1);
			String[] arr = cut.split(","); // store all the showtimeID in a string array
			String[][] showtimes = new String[arr.length][2];
			for (int i = 0; i < arr.length; i++) {
				String[] inside = new String[2];
				ArrayList<String> b = csvRW.search("showtimedatabase", "ShowtimeID", arr[i].replaceAll("\\s+", ""));
				inside[0] = arr[i].replaceAll("\\s+", "");
				inside[1] = b.get(2);
				showtimes[i] = inside; // get timing for each showtimeID and store it into showtimes array
			}
			return showtimes;
		} else {
			String[][] showtimes = new String[1][2];
			String[] inside = new String[2];
			ArrayList<String> b = csvRW.search("showtimedatabase", "ShowtimeID", a.replaceAll("\\s+", ""));
			inside[0] = a;
			inside[1] = b.get(b.size() - 1);
			showtimes[0] = inside;
			return showtimes;
		}

	}

	// gets all the details of a movie and stores into ArrayList<String>
	/**
	 * Searches and returns all details of target movie. Will print
	 * <code>No reviews has been written about this movie yet.</code> if no reviews
	 * can be found. <br>
	 * Otherwise will be in sequence of Name, Movie Type, Showing Status, Synopsis,
	 * Director, Cast, Overall Rating, Movie Age Rating, Comment, and User's Rating
	 * <br>
	 * Will call <code>searchforReview</code>.
	 * 
	 * @param movieID Unique <code>movieID</code> of target movie
	 * @return All details of a target movie stored in a
	 *         <code>ArrayList&lt;String&gt;</code>.
	 * @see CustomerApp#searchforReview(int)
	 */

	public static ArrayList<String> searchMovieDetails(int movieID) {
		ArrayList<String> movie_row = csvRW.search("moviedatabase", "MovieID", Integer.toString(movieID));
		ArrayList<String> result = new ArrayList<String>();
		result.add("-----------------------------------------------");
		result.add(movie_row.get(1));
		result.add("-----------------------------------------------");
		result.add("Movie Type: " + movie_row.get(2));
		result.add("Showing Status: " + movie_row.get(3));
		result.add("Synopsis: " + movie_row.get(4));
		result.add("Director: " + movie_row.get(5));
		String cutted = movie_row.get(6).substring(1, movie_row.get(6).length() - 1);
		result.add("Cast: " + cutted); // make sure cast is more than one
		result.add("Overall Rating: " + movie_row.get(7));
		result.add("Movie Age Rating: " + movie_row.get(11));
		result.add("-----------------------------------------------");
		String a = movie_row.get(9);
		if (a.equals("")) {
			result.add("No reviews has been written about this movie yet.");
			return result;
		} else if (a.length() == 1) { // if there is only one review
			String[] review = searchforReview(Integer.parseInt(a));
			result.add("Comment: " + review[1]);
			result.add("User's Rating: " + review[0]);
			result.add("-----------------------------------------------");

			return result;
		} else {

			String cut = a.substring(1, a.length() - 1); // if there are more than one review
			String[] arr = cut.split(","); // store all the showtimeID in a string array
			for (int j = 0; j < arr.length; j++) {
				String[] review = searchforReview(Integer.parseInt(arr[j]));
				result.add("Comment: " + review[1]);
				result.add("User Rating: " + review[0]);
			}
			return result;

		}
	}

	// returns an String array of size 2 containing the user rating and comment
	// given a particular reviewID
	/**
	 * Searches for review details (User rating, comment) given a target
	 * <code>reviewID</code>.
	 * 
	 * @param reviewID unique <code>reviewID</code> for target review
	 * @return <code>String</code> array of size 2 containing the user rating and
	 *         comment in indexes 0 and 1 respectively
	 */
	public static String[] searchforReview(int reviewID) {
		String a = Integer.toString(reviewID);
		ArrayList<String> result = csvRW.search("reviewdatabase", "ReviewID", a);
		String[] rating_comment = new String[2];
		rating_comment[0] = result.get(0);
		rating_comment[1] = result.get(1);
		return rating_comment;
	}

	/**
	 * Searches for matching <code>movieID</code> given movie title.
	 * 
	 * @param name Movie title of target movie
	 * @return <code>movieID</code> that matches target movie if target found. Else,
	 *         returns -1.
	 */
	public static int searchOneMovie(String name) {
		ArrayList<String> result = csvRW.search("moviedatabase", "Name", name);
		if (result != null)
			return Integer.parseInt(result.get(0)); // returns movieID given the movie name
		else
			return -1;
	}

	// this function deals with the seatingplan database when a ticket is bought
	/**
	 * Carries out purchase of ticket by customer when given <code>showtimeID</code>
	 * and x and y coordinates of desired seat.
	 * 
	 * @param showtimeID Unique <code>showtimeID</code> of target showtime
	 * @param x          X-coordinate of seat
	 * @param y          Y-coordinate of seat
	 * @return -1 if seat is already occupied. <br>
	 *         1 if purchase was successful.
	 * @see Ticket
	 */
	public static int buyTicket(int showtimeID, int x, int y) {

		ArrayList<String[]> occupied = csvRW.searchMultipleRow("seatingplandatabase", "ShowtimeID",
				Integer.toString(showtimeID)); // checks the seatingplan database to see which are the occupied seats
		boolean dontsearch = false;
		if (occupied == null) {
//			System.out.println("This shit was null");
			dontsearch = true; //
		}
		String target = Integer.toString(x) + "," + Integer.toString(y);
		if (dontsearch == false) {
			for (int k = 0; k < occupied.size(); k++) {
				if (occupied.get(k)[1].equals(csvRW.format(target)))
					return -1; // cannot buy this ticket because its occupied already
			}
		}

		// if seat is available for customer to buy, make the change to the seating plan
		// database
		ArrayList<String> new_occupied = new ArrayList<String>();
		new_occupied.add(Integer.toString(showtimeID));
		new_occupied.add(target);
		csvRW.writeToCSV("seatingplandatabase", new_occupied);
		for (int i = 0; i < ShowtimeController.showtimeArr.size(); i++) {
			if (showtimeID == ShowtimeController.showtimeArr.get(i).getShowtimeID()) {
				// mark the seat as occupied in the object
				// seat_index = yCoor * no of columns + xCoor
				int seat_index;
				seat_index = (y * ShowtimeController.showtimeArr.get(i).getCinema().getTotalCol()) + x;
				ShowtimeController.showtimeArr.get(i).getSeatArr()[seat_index].setOccupied(true);
			}
		}
		return 1; // purchase is successful

	}

	// returns TicketID
	// this function deals with the creation of the Ticket object, addition into the
	// Ticket database, alter the TicketSales in movie database
	// and alter movie object's ticket sales count
	/**
	 * Creates <code>Ticket</code> object according to <code>showtimeID</code>, age
	 * of movie-goer, and title of movie given. Will also write ticket details into
	 * ticket database, as well as increment <code>TicketSales</code> in movie
	 * database to reflect sales of new tickets, as well as in the appropriate
	 * <code>Movie</code> object.
	 * 
	 * @param showtimeID Unique ID of showtime selected by customer
	 * @param movietitle Title of movie selected by customer
	 * @param isAdult    Selection between age categories. 1 for child, 2 for adult
	 *                   and 3 for senior prices.
	 * @return Newly created <code>Ticket</code> object.
	 * @see Ticket
	 * @see Movie#increaseTicketSalesByOne()
	 */
	public static Ticket addTicket(int showtimeID, String movietitle, int isAdult) {
		// I have assumed that by this stage all the info entered for parameters is
		// correct
		int index = 0;
		for (int i = 0; i < ShowtimeController.showtimeArr.size(); i++) {
			if (showtimeID == ShowtimeController.showtimeArr.get(i).getShowtimeID()) {
				index = i; // get the index of the showtime object in the showtimeArr
				break;
			}
		}
		Ticket addnew = new Ticket(ShowtimeController.showtimeArr.get(index)); // create a new Ticket object
		addnew.setIsAdult(isAdult); // set the isAdult option of Ticket
		String cinetype = addnew.getShowtime().getCinema().getType();
		addnew.setFinalPrice(CalendarController.calendar, PriceController.price, cinetype); // set the final price of the Ticket based on
																			// holiday and
		// weekend dates in Calendar and Prices
		addnew.setMovietitle(movietitle);
		addnew.addTicketToCSV(addnew); // write new ticket to ticket database
		ArrayList<String> movie_row = csvRW.search("moviedatabase", "Name", movietitle);
		String id = movie_row.get(0);
		int ticketSalesCount = Integer.parseInt(movie_row.get(8)) + 1;
		csvRW.editCSV("moviedatabase", id, "TicketSales", Integer.toString(ticketSalesCount)); // increase ticketSales
																								// count in movie
																								// database
		// change the movie object's ticketSales count
		for (int k = 0; k < MovieController.movieArr.size(); k++) {
			if (searchOneMovie(movietitle) == MovieController.movieArr.get(k).getMovieID()) {
				MovieController.movieArr.get(k).increaseTicketSalesByOne();
				break;
			}
		}

		return addnew;
	}

	// returns String array of size 2 containing TID and total amount of a given
	// receipt
	/**
	 * Gets TID and total amount of receipt given
	 * <code>ArrayList&lt;Ticket&gt;</code> bought in this transaction by the
	 * customer, and payment mode.
	 * 
	 * @param arr         <code>ArrayList&lt;Ticket&gt;</code> of tickets bought in
	 *                    this transaction by the customer
	 * @param paymentmode Customer's choice of payment mode. May be "Cash, Credit or
	 *                    PayLah!"
	 * @return <code>String[2]</code> array containing TID and total amount in
	 *         respective indexes
	 * @see Receipt
	 */
	public static String[] addPayment(ArrayList<Ticket> arr, String paymentmode) {
		String[] result = new String[2];
		Receipt receipt = new Receipt(arr, paymentmode); // creates a new Receipt object
		receipt.calTotalAmt(); // calculates the total amount of the Receipt
		receipt.addReceiptToCSV(receipt); // writes it to the Receipt database
		result[0] = receipt.getTID(); //
		result[1] = Double.toString(receipt.getTotalAmt());
		return result;
	}

	// returns one 2D array of all the bookingHistory eg. [ [TID, Payment Mode,
	// Movie Name, Total Amount], ...]
	/**
	 * Gets all past booking history of customer, including past TIDs, payment mode,
	 * movie name, total amount paid, when given unique customer ID.
	 * 
	 * @param custID Unique customer ID of customer requesting booking history
	 * @return 2D array of all booking history in format: <br>
	 *         [ [TID, Payment Mode, Movie Name, Total Amount], ...]
	 */
	public static String[][] searchBookingHistory(int custID) {

		ArrayList<String> tids = csvRW.search("customerdatabase", "CustomerID", Integer.toString(custID));
		String a = tids.get(4); // Get all the receipt's TID of the customer
		if (a.length() > 15) {
			a = a.substring(1, a.length() - 1);
			String[] arr = a.split(","); // store the TIDs in a string array
			String[][] result = new String[arr.length][4];
			for (int i = 0; i < arr.length; i++) {
				String[] inside = new String[4];
				ArrayList<String> b = csvRW.search("paymentdatabase", "TID", arr[i].replaceAll("\\s", ""));
				inside[0] = arr[i];
				inside[1] = b.get(1);
				inside[2] = b.get(2);
				inside[3] = b.get(3);
				result[i] = inside; // get timing for each showtimeID and store it into showtimes array
			}
			return result;
		} else if (a.length() == 15) {
			String[][] result = new String[1][4];
			String[] inside = new String[4];
			ArrayList<String> b = csvRW.search("paymentdatabase", "TID", a);
			inside[0] = a;
			inside[1] = b.get(1);
			inside[2] = b.get(2);
			inside[3] = b.get(3);
			result[0] = inside;
			return result;
		} else {
			return null;
		}

	}

	/**
	 * Allows movie-goer to add review to a selected movie. Will update relevant
	 * <code>Movie</code> object.
	 * 
	 * @param rating     Movie-goer's rating out of 10 in integers
	 * @param comment    Comments left by Movie-goer
	 * @param userID     UserID of movie-goer who left the review
	 * @param movie_name Title of selected movie
	 * @see Movie#addReview(Review)
	 */
	public static void addReview(int rating, String comment, String userID, String movie_name) {

		Review a = new Review(rating, comment, userID);
		a.addReviewToCSV(a);
		ArrayList<String> movie_row = csvRW.search("moviedatabase", "Name", movie_name); // search for that movie in
																							// movie database
		String id = movie_row.get(0);
		String reviews = movie_row.get(9);
		for (int k = 0; k < MovieController.movieArr.size(); k++) {
			if (searchOneMovie(movie_name) == MovieController.movieArr.get(k).getMovieID()) {
				MovieController.movieArr.get(k).addReview(a); // add the review to the movie object in movieArr
				String userRating = MovieController.movieArr.get(k).getOverallUserRating();
				System.out.println("overall user rating: " + userRating);
				csvRW.editCSV("moviedatabase", id, "OverallRating", userRating); // write new Overall Rating to the
																					// movie database
				break;
			}
		}
		// if there are no reviews initially
		if (reviews.equals("")) {
			csvRW.editCSV("moviedatabase", id, "ReviewID", Integer.toString(a.getReviewID())); // write reviewID to
																								// movie database

		} else {
			// if there are more than one review
			if (reviews.length() != 1) {
				String cut = reviews.substring(1, reviews.length() - 1);
				String[] arr = cut.split(",");
				String b = "";
				for (int i = 0; i < arr.length; i++) {
					b += arr[i] + ",";
				}
				b += Integer.toString(a.getReviewID());
				csvRW.editCSV("moviedatabase", id, "ReviewID", b); // write reviewID to movie database
			} else {
				// if there is one review
				String b = reviews + "," + Integer.toString(a.getReviewID());
				csvRW.editCSV("moviedatabase", id, "ReviewID", b);
			}

		}

	}

	// returns everything in customer database except Transaction history given a
	// CustomerID
	/**
	 * Fetches all data stored about a customer. Includes name, mobile number, email
	 * and all past TIDs.
	 * 
	 * @param custID Unique customer ID
	 * @return <code>String[]</code> array of [name, mobile number, email, past
	 *         TIDs]
	 */
	public static String[] findCustomer(int custID) {
		ArrayList<String> row = csvRW.search("customerdatabase", "CustomerID", Integer.toString(custID));
		String[] result = new String[4];
		result[0] = row.get(0);
		result[1] = row.get(1);
		result[2] = row.get(2);
		result[3] = row.get(3);
		return result;
	}

	// writes to customer database for a new receipt
	/**
	 * Stores TID of new receipt when customer makes a purchase of tickets to keep
	 * track of past booking history.
	 * 
	 * @param custID Unique customer ID
	 * @param TID    TID to be inserted into customer database
	 * @see Receipt
	 */
	public static void addReceiptinCustomerDatabase(int custID, String TID) {
		ArrayList<String> cust_row = csvRW.search("customerdatabase", "CustomerID", Integer.toString(custID));
		String id = cust_row.get(0);
		String TIDS = cust_row.get(4);
		if (TIDS.equals("[]")) { // when there are no receipts initially
			csvRW.editCSV("customerdatabase", id, "TID", TID);

		} else {
			// if there are more than one receipt initially
			if (TIDS.length() < 15) {
				String[] arr = TIDS.split(",");
				String b = "";
				for (int i = 0; i < arr.length; i++) {
					b += arr[i] + ",";
				}
				b += TID;
				csvRW.editCSV("customerdatabase", id, "TID", b);
			} else {
				// if there is one TID
				String b = TIDS + "," + TID;
				csvRW.editCSV("customerdatabase", id, "TID", b);
			}
		}
	}

	// pass in 2d array of [[ShowtimeID,Timing],...] for the relevant movie
	// returns 1 if showtimeID is found in this array
	/**
	 * Checks if showtime selected by customer exists as an object
	 * 
	 * @param show   2D array of showtimes and movies like [[ShowtimeID,Timing],...]
	 * @param target Target <code>showtimeID</code>
	 * @return 1 if <code>showtimeID</code> is found, -1 if no
	 */
	public static int checkValidityShowtime(String[][] show, int target) {
		for (int i = 0; i < show.length; i++) {
			if (target == Integer.parseInt(show[i][0])) {
				return 1;
			}

		}
		return -1;
	}

	// returns a string containing the timing of showtime for a given showtimeID
	/**
	 * Gets timing of showtime given <code>showtimeID</code>
	 * 
	 * @param show   2D array of <code>showtimeID</code> and timing
	 * @param target Target showtime
	 * @return Timing for target showtime
	 */
	public static String printRelevantShowTime(String[][] show, int target) {
		for (int i = 0; i < show.length; i++) {
			if (target == Integer.parseInt(show[i][0])) {
				return show[i][1];
			}

		}
		return "NOT VALID";
	}

}
