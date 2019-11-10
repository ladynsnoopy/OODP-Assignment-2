package cinema;

import java.util.ArrayList;

/**
 * An control class that will handle methods relating to the customer module. It
 * will manage and control objects that are neccessary to allow the customer
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
// every time you create a showtime, insert it into arraylist in java 
public class CustomerApp {

	public static void createCustomer(String name, String mobileNum, String email) {
		Customer a = new Customer(name, mobileNum, email);
		CustomerToCSV.addCustomerToCSV(a);
	}

	// returns customerID if it exists
	public static int customerExists(String email) {
		if (csvRW.search("customerdatabase", "Email", email) == null)
			return -1;
		else {
			return Integer.parseInt(csvRW.search("customerdatabase", "Email", email).get(0));
		}
	}

	// returns a string array of movies
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
	// returns a string array of timings for a particular movie
	public static String[][] getShowtimesForMovie(int movieID) {
		ArrayList<String> result = csvRW.search("moviedatabase", "MovieID", Integer.toString(movieID));
		String a = result.get(10); // Get all the showtimeID of the particular movie
		if (a.length() != 1) {
			System.out.println(a);
			String cut = a.substring(1, a.length() - 1);
			String[] arr = cut.split(","); // store all the showtimeID in a string array
			String[][] showtimes = new String[arr.length][2];
			for (int i = 0; i < arr.length; i++) {
				String[] inside = new String[2];
				ArrayList<String> b = csvRW.search("showtimedatabase", "ShowtimeID", arr[i].replaceAll("\\s+", ""));
				inside[0] = arr[i];
				inside[1] = b.get(2);
				showtimes[i] = inside; // get timing for each showtimeID and store it into showtimes array
			}
			return showtimes;
		} else {
			String[][] showtimes = new String[1][2];
			String[] inside = new String[2];
			ArrayList<String> b = csvRW.search("showtimedatabase", "ShowtimeID", a);
			inside[0] = a;
			inside[1] = b.get(b.size() - 1);
			showtimes[0] = inside;
			return showtimes;
		}

	}

	public static ArrayList<String> searchMovieDetails(int movieID) {
		ArrayList<String> movie_row = csvRW.search("moviedatabase", "MovieID", Integer.toString(movieID));
		ArrayList<String> result = new ArrayList<String>();
		result.add("Name: " + movie_row.get(1));
		result.add("Movie Type: " + movie_row.get(2));
		result.add("Showing Status: " + movie_row.get(3));
		result.add("Sypnosis: " + movie_row.get(4));
		result.add("Director: " + movie_row.get(5));
		String cutted = movie_row.get(6).substring(1, movie_row.get(6).length() - 1);
		result.add("Cast: " + cutted); // make sure cast is more than one
		result.add("Overall Rating: " + movie_row.get(7));
		result.add("Movie Age Rating: " + movie_row.get(11));
		String a = movie_row.get(9);
		if (a.equals("")) {
			result.add("No reviews has been written about this movie yet.");
			return result;
		} else if (a.length() == 1) {
			String[] review = searchforReview(Integer.parseInt(a));
			result.add("Comment: "+ review[1]);
			result.add("User's Rating: "+ review[0]);

			return result;
		} else {

			String cut = a.substring(1, a.length() - 1);
			String[] arr = cut.split(","); // store all the showtimeID in a string array
			for (int j = 0; j < arr.length; j++) {
				String[] review = searchforReview(Integer.parseInt(arr[j]));
				result.add("Comment: "+ review[1]);
				result.add("User Rating: "+ review[0]);
 			}
			return result;

		}
	}

	public static String[] searchforReview(int reviewID) {
		String a = Integer.toString(reviewID);
		ArrayList <String> result = csvRW.search("reviewdatabase", "ReviewID",a);
		String[] rating_comment = new String[2];
		rating_comment[0] = result.get(0);
		rating_comment[1] = result.get(1);
		return rating_comment;
	}

	public static int searchOneMovie(String name) {
		ArrayList<String> result = csvRW.search("moviedatabase", "Name", name);
		if (result != null)
			return Integer.parseInt(result.get(0)); // returns movieID
		else
			return -1;
	}

	// TODO havent test the buyTicket()
	public static int buyTicket(int showtimeID, int x, int y) {

		ArrayList<String[]> occupied = csvRW.searchMultipleRow("seatingplandatabase", "ShowtimeID",
				Integer.toString(showtimeID));
		boolean dontsearch = false;
		if (occupied == null) {
			System.out.println("This shit was null");
			dontsearch = true;
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
		for (int i = 0; i < StaffApp.showtimeArr.size(); i++) {
			if (showtimeID == StaffApp.showtimeArr.get(i).getShowtimeID()) {
				// mark the seat as occupied in the object
				// seat_index = yCoor * no of columns + xCoor
				int seat_index;
				seat_index = (y * StaffApp.showtimeArr.get(i).getCinema().getTotalCol()) + x;
				StaffApp.showtimeArr.get(i).getSeatArr()[seat_index].setOccupied(true);
			}
		}
		return 1; // purchase is successful

	}

	// returns TicketID
	public static Ticket addTicket(int showtimeID, String movietitle, int isAdult) {
		// I have assumed that by this stage all the info entered for parameters is
		// correct
		int index = 0;
		for (int i = 0; i < StaffApp.showtimeArr.size(); i++) {
			if (showtimeID == StaffApp.showtimeArr.get(i).getShowtimeID()) {
				index = i;
				break;
			}
		}
		Ticket addnew = new Ticket(StaffApp.showtimeArr.get(index));
		addnew.setIsAdult(isAdult);
		// TODO make a global Price object
		Price prices = new Price(9.00, 6.50, 5.00, 1.1, 3.00);
		addnew.setFinalPrice(StaffApp.calendar, prices);
		addnew.setMovietitle(movietitle);
		TicketToCSV.addTicketToCSV(addnew); // write new ticket to ticketdatabase
		ArrayList<String> movie_row = csvRW.search("moviedatabase", "Name", movietitle);
		String id = movie_row.get(0);
		int ticketSalesCount = Integer.parseInt(movie_row.get(8)) + 1;
		csvRW.editCSV("moviedatabase", id, "TicketSales", Integer.toString(ticketSalesCount)); // increase ticketSales
																								// count in movie
																								// database
		// change the movie object ticketSales count
		for (int k = 0; k < StaffApp.movieArr.size(); k++) {
			if (searchOneMovie(movietitle) == StaffApp.movieArr.get(k).getMovieID()) {
				StaffApp.movieArr.get(k).increaseTicketSalesByOne();
				System.out.println("Movie object ticket count increased");
				break;
			}
		}

		return addnew;
	}

	// returns transaction id
	public static String[] addPayment(ArrayList<Ticket> arr, String paymentmode) {
		String[] result = new String[2];
		Receipt receipt = new Receipt(arr, paymentmode);
		receipt.calTotalAmt();
		ReceiptToCSV.addReceiptToCSV(receipt);
		result[0] = receipt.getTID();
		result[1] = Double.toString(receipt.getTotalAmt());
		return result;
	}

	// returns one 2D array of all the bookingHistory
	public static String[][] searchBookingHistory(int custID) {

		ArrayList<String> tids = csvRW.search("customerdatabase", "CustomerID", Integer.toString(custID));
		String a = tids.get(4); // Get all the receipt's TID of the customer
		if (a.length() != 1) {
			String[] arr = a.split(","); // store the TIDs in a string array
			String[][] result = new String[arr.length][4];
			for (int i = 0; i < arr.length; i++) {
				String[] inside = new String[4];
				ArrayList<String> b = csvRW.search("paymentdatabase", "TID", arr[i]);
				if(b == null)
					System.out.println("THIS IS NULL");
				inside[0] = arr[i];
				inside[1] = b.get(1);
				inside[2] = b.get(2);
				inside[3] = b.get(3);
				result[i] = inside; // get timing for each showtimeID and store it into showtimes array
			}
			return result;
		} else {
			String[][] result = new String[1][4];
			String[] inside = new String[4];
			ArrayList<String> b = csvRW.search("paymentdatabase", "TID",a);
			inside[0] = a;
			inside[1] = b.get(1);
			inside[2] = b.get(2);
			inside[3] = b.get(3);
			result[0] = inside;
			return result;
		}
		
	}

	public static void addReview(int rating, String comment, String userID, String movie_name) {

		Review a = new Review(rating, comment, userID);
		ReviewToCSV.addReviewToCSV(a);
		ArrayList<String> movie_row = csvRW.search("moviedatabase", "Name", movie_name);
		String id = movie_row.get(0);
		String reviews = movie_row.get(9);
		for (int k = 0; k < StaffApp.movieArr.size(); k++) {
			if (searchOneMovie(movie_name) == StaffApp.movieArr.get(k).getMovieID()) {
				StaffApp.movieArr.get(k).addReview(a);
				String userRating = Double.toString(StaffApp.movieArr.get(k).getOverallUserRatingInDouble());
				csvRW.editCSV("moviedatabase", id, "OverallRating", userRating);
				break;
			}
		}
		// if there are no reviews
		if (reviews.equals("")) {
			csvRW.editCSV("moviedatabase", id, "ReviewID", Integer.toString(a.getReviewID()));

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
				csvRW.editCSV("moviedatabase", id, "ReviewID", b);
			} else {
				// if there is one review
				String b = reviews + "," + Integer.toString(a.getReviewID());
				csvRW.editCSV("moviedatabase", id, "ReviewID", b);
			}

		}

	}

	// returns everything in customer database except Transaction history
	public static String[] findCustomer(int custID) {
		ArrayList<String> row = csvRW.search("customerdatabase", "CustomerID", Integer.toString(custID));
		String[] result = new String[4];
		result[0] = row.get(0);
		result[1] = row.get(1);
		result[2] = row.get(2);
		result[3] = row.get(3);
		return result;
	}

	public static void addReceiptinCustomerDatabase(int custID, String TID) {
		ArrayList<String> cust_row = csvRW.search("customerdatabase", "CustomerID", Integer.toString(custID));
		String id = cust_row.get(0);
		System.out.println("id:"+ id);
		String TIDS = cust_row.get(4);
		System.out.println("TIDS:"+ TIDS);
		if (TIDS.equals("[]")) {
			csvRW.editCSV("customerdatabase", id, "TID", TID);

		} else {
			// if there are more than one TID
			if (TIDS.length() != 1) {
				String cut = TIDS.substring(1, TIDS.length() - 1);
				String[] arr = cut.split(",");
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

	// TODO view sorted top 5

}

