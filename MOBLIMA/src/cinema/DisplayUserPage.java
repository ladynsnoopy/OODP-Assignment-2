package cinema;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Boundary class between <code>MainDisplayPage</code> and
 * <code>CustomerApp</code>. Provides printing and display of options in
 * movie-goer module.
 * 
 * @author Myat Hmu Khin
 * @version 1.0
 * @since 2019-11-13
 * @see CustomerApp
 * @see MainDisplayPage
 *
 */
interface DisplayUserPage extends MainDisplayPage {

	/**
	 * Displays the initial menu page shown to user after login. Calls the
	 * appropriate methods for each menu option.
	 */
	public static void displayUserPage() {
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		int custID = custLogin(); // custID is the customer ID of the customer using the App now;
		while (loop) {
			System.out.println("What would you like to do?");
			System.out.println();
			System.out.println("Enter (1) to view list of movies.");
			System.out.println("Enter (2) to search for a particular movie.");
			System.out.println("Enter (3) to purchase a ticket.");
			System.out.println("Enter (4) to view your booking history.");
			System.out.println("Enter (5) to view list of top 5 movies by ticket sales.");
			System.out.println("Enter (6) to view list of top 5 movies by overall reviewers' ratings.");
			System.out.println("Enter (7) to add review. ");
			System.out.println("Enter (8) to exit.");
			int input;
			while (true) {
				if (sc.hasNextInt()) {
					input = sc.nextInt();
					if (input >= 1 && input <= 8) {
						break;
					}
				} else {
					sc.next();
				}
				System.out.println("Invalid Input. Please enter a number between 1 and 7.");

			}
			switch (input) {
			case 1:
				displayAllMovie();
				break;
			case 2:
				displaySearchMovie();
				break;
			case 3:
				if (displayBuyTicket(custID) == 1) {
					String[] info = CustomerApp.findCustomer(custID);
					System.out.println("Customer ID: " + info[0]);
					System.out.println("Customer Name: " + info[1]);
					System.out.println("Mobile Number: " + info[2]);
					System.out.println("Email: " + info[3]);
					System.out.println();
				}
				break;
			case 4:
				displayBookingHistory(custID);
				break;
			case 5:
				displayTopMovies(2);
				break;
			case 6:
				displayTopMovies(1);
				break;
			case 7:
				displayAddReview(custID);
				break;
			case 8:
				loop = false;
				break;
			}

		}

	}

	/**
	 * Gets unique customer ID if it already exists in database via asking for user
	 * email using input. If no record exists in database, creates a new
	 * <code>Customer</code> object and adds it to database.
	 * 
	 * @return Unique customer ID
	 * @see Customer
	 */
	public static int custLogin() {
		// do customer initialization
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your email: ");
		String email = sc.nextLine();
		if (CustomerApp.customerExists(email) == -1) // if customer is not in the database
		{
			System.out.println("Please enter your Name and Mobile Number");
			String name = sc.nextLine();
			String mobileNum = sc.nextLine();
			CustomerApp.createCustomer(name, mobileNum, email); // make a new customer and add to database
		}
		int ID = CustomerApp.customerExists(email); // returns CustID
		return ID;
	}

	/**
	 * Displays all movies.
	 */
	public static void displayAllMovie() {
		String[] arr = CustomerApp.searchMovies();
		System.out.println("Movie List:");
		System.out.println("-----------------------------------------------");
		for (int i = 1; i < arr.length; i++) {
			System.out.println(i + ". " + arr[i]);
		}
		System.out.println();
	}

	/**
	 * Displays top 5 movies based on either ratings or sales.
	 * 
	 * @param selection Choice between top 5 ratings or sales. </br>
	 *                  1 for ratings, 2 for sales.
	 */
	public static void displayTopMovies(int selection) {
		switch (selection) {
		case 1:
			System.out.println("Top 5 movies by overall reviewers' ratings:");
			break;
		case 2:
			System.out.println("Top 5 movies by ticket sales:");
			break;
		}
		for (int i = 0; i < 5; i++) {
			System.out.println(StaffApp.showTopMovies(selection).get(i));
		}
		;
	}

	/**
	 * Displays movie details of target movie selected by customer via input, as
	 * well as list of showtimes available for that movie.
	 * 
	 * @see Movie
	 */
	public static void displaySearchMovie() {
		Scanner sc = new Scanner(System.in);
		System.out.println("What is the name of the movie you would like to search for?");
		String name = sc.nextLine();
		int ID = CustomerApp.searchOneMovie(name);
		if (ID != -1) {
			ArrayList<String> movieDetails = CustomerApp.searchMovieDetails(ID); // gets all relevant movie details
			for (int i = 0; i < movieDetails.size(); i++) {
				System.out.println(movieDetails.get(i));
			}
			System.out.println("Do you want to see the showtimes for this movie?");
			System.out.println("Enter (1) for Yes");
			System.out.println("Enter (2) for No");
			int ans;
			while (true) {
				if (sc.hasNextInt()) {
					ans = sc.nextInt();
					if (ans == 1 || ans == 2) {
						break;
					}
				} else {
					sc.next();
				}
				System.out.println("Invalid Input. Please enter either 1 and 2.");
			}
			if (ans == 1) {
				System.out.println();
				System.out.println("Showtimes for " + name + ":");
				System.out.println("-----------------------------------------------"); // prints out all the showtimes
				String[][] showtimes = CustomerApp.getShowtimesForMovie(ID);
				if (showtimes == null) {
					System.out.println("No showtimes are available yet.");
					return;
				}
				for (int i = 0; i < showtimes.length; i++) {
					String showstring = showtimes[i][1];
					System.out.println("Showtime ID: " + showtimes[i][0]);
					System.out.println("Time and Date: " + showstring.substring(0, 2) + "-" + showstring.substring(2, 4)
							+ "-" + showstring.substring(4, 6) + " " + showstring.substring(6));
					System.out.println("-----------------------------------------------");
				}
			} else {
				return;
			}

		} else {
			System.out.println("This movie [" + name + "] is not found.");
		}

	}

	/**
	 * Displays past booking history of customer.
	 * 
	 * @param ID Unique customer ID
	 * 
	 */
	public static void displayBookingHistory(int ID) {
		System.out.println("Booking History:");
		System.out.println("-----------------------------------------------");
		String[][] bookHist = CustomerApp.searchBookingHistory(ID);
		if (bookHist != null) {
			for (int i = 0; i < bookHist.length; i++) {

				System.out.println("Transaction ID: " + bookHist[i][0]);
				System.out.println("Payment Mode: " + bookHist[i][1]);
				System.out.println("Movie Name: " + bookHist[i][2]);
				System.out.println("Amount: $" + bookHist[i][3]);
				System.out.println();

			}
		} else {
			System.out.println("You have not booked any tickets before.");
			System.out.println();
		}

	}

	/**
	 * Displays process for adding a new review to a movie by a customer. Includes
	 * error-checking.
	 * 
	 * @param custID Unique customer ID
	 */
	public static void displayAddReview(int custID) {
		Scanner sc = new Scanner(System.in);
		System.out.println("What is the name of the movie you would like to add a review for?");
		String moviename = sc.nextLine();
		if (CustomerApp.searchOneMovie(moviename) != -1) {
			System.out.println("What would you rate this movie upon 10?");
			int rating = sc.nextInt();
			System.out.println("What are your comments about this movie?");
			sc.nextLine();
			String comment = sc.nextLine();
			System.out.println("Thank you for your review.");
			CustomerApp.addReview(rating, comment, Integer.toString(custID), moviename);
		} else {
			System.out.println("This is not a valid movie name. Please try again.");
		}

	}

	/**
	 * Checks that payment mode is valid.
	 * 
	 * @param payment User-inputted payment mode
	 * @return Valid payment mode
	 */
	public static String getPaymentMode(int payment) {
		String result;
		switch (payment) {
		case 1:
			result = "Cash";
			break;
		case 2:
			result = "Credit/Debit Card";
			break;
		case 3:
			result = "PayLah";
			break;
		default:
			result = "invalid";
			break;
		}
		return result;
	}

	/**
	 * Display for buying of ticket(s) by a customer. Includes error-checking.
	 * 
	 * @param custID Unique customer ID
	 * @return 1 if ticket-buying is successful, -1 if not.
	 */
	public static int displayBuyTicket(int custID) {
		Scanner sc = new Scanner(System.in);
		System.out.println("What is the name of the movie you would like to buy?");
		String name = sc.nextLine();
		int ID = CustomerApp.searchOneMovie(name); // this function checks the name of movie is valid
		if (ID != -1) {
			// prints show times for the movie
			System.out.println("Showtimes for " + name + ":");
			System.out.println("-----------------------------------------------");
			String[][] showtimes = CustomerApp.getShowtimesForMovie(ID);
			for (int i = 0; i < showtimes.length; i++) {
				String showstring = showtimes[i][1];
				String timedate = showstring.substring(0, 2) + "-" + showstring.substring(2, 4) + "-"
						+ showstring.substring(4, 6) + " " + showstring.substring(6);
				System.out.println("Showtime ID: " + showtimes[i][0]);
				System.out.println("Time and Date: " + timedate);
				System.out.println("-----------------------------------------------");
			}
			System.out.println("Enter the showtime ID that you would like to buy: ");
			int showID;
			int numSeat;
			int index = 0;
			while (true) {
				if (sc.hasNextInt()) {
					showID = sc.nextInt();
					if (CustomerApp.checkValidityShowtime(showtimes, showID) == 1) { // this function checks that showID entered
																			// belongs to that movie/is valid
						break;
					}
				} else {
					sc.next();
				}
				System.out.println("Invalid Input. Please enter a valid showtime ID.");

			}
			// prints seating plan of that show time for customers to choose
			for (int i = 0; i < StaffApp.showtimeArr.size(); i++) {
				if (showID == StaffApp.showtimeArr.get(i).getShowtimeID()) {
					SeatingPlan.printSeatingPlan(StaffApp.showtimeArr.get(i));
					index = i;
					break;
				}
			}
			System.out.println("How many seats do you want to purchase?");
			while (true) {
				if (sc.hasNextInt()) {
					numSeat = sc.nextInt();
					if (numSeat > 0 && numSeat < StaffApp.showtimeArr.get(index).getCinema().getTotalNumSeat()) {
						// checks that number of seats to be purchased is reasonable
						break;
					}
				} else {
					sc.next();
				}
				System.out.println("Invalid Input. Please enter a valid number of seats.");
			}
			int x, y;
			boolean keep_loop = true;
			ArrayList<Ticket> ticketArr = new ArrayList<Ticket>(); // make a new ticketArr to create a receipt object
			for (int h = 0; h < numSeat; h++) {
				while (keep_loop) {
					System.out.println("Please enter the x,y position of the seats:");
					while (true) {
						if (sc.hasNextInt()) {
							x = sc.nextInt();
							y = sc.nextInt();
							if (x >= 0 && x < StaffApp.showtimeArr.get(index).getCinema().getTotalCol() && y >= 0
									&& y < StaffApp.showtimeArr.get(index).getCinema().getTotalRow()) {
								// checks that x,y is valid compared to cinema rows and columns
								break;
							}
						} else {
							sc.next();
						}
						System.out.println("Invalid Input. Please enter a valid x,y position.");
					}
					int purchase = CustomerApp.buyTicket(showID, x, y);
					String timing = CustomerApp.printRelevantShowTime(showtimes, showID);
					String timingformatted = timing.substring(0, 2) + "-" + timing.substring(2, 4) + "-"
							+ timing.substring(4, 6) + " " + timing.substring(6);
					if (purchase == 1) {
						System.out.println("Enter the movie goer type:");
						System.out.println("(1) for child");
						System.out.println("(2) for adult");
						System.out.println("(3) for senior citizen");
						int num = 0;
						while (true) {
							if (sc.hasNextInt()) {
								num = sc.nextInt();
								if (num >= 1 && num <= 3) {
									break;
								}
							} else {
								sc.next();
							}
							System.out.println("Invalid Input. Please enter a valid number between 1 and 3.");
						}
						ticketArr.add(CustomerApp.addTicket(showID, name, num)); // adding to the TicketArr
						System.out.printf("You are buying Ticket %d,%d to watch %s at %s.\n", x, y, name,
								timingformatted);
						break;

					} else {
						System.out.printf("You cannot purchase seat %d,%d as it is already occupied.\n", x, y);
					}
				}
			}
			int paymentmode;
			System.out.println("What will be your mode of payment?");
			System.out.println("(1) for Cash");
			System.out.println("(2) for Credit/Debit Card");
			System.out.println("(3) for PayLah");
			while (true) {
				if (sc.hasNextInt()) {
					paymentmode = sc.nextInt();
					if (paymentmode >= 1 && paymentmode <= 3) {
						break;
					}
				} else {
					sc.next();
				}
				System.out.println("Invalid Input. Please enter a valid number between 1 and 3.");
			}
			String payment = getPaymentMode(paymentmode);
			String[] result = CustomerApp.addPayment(ticketArr, payment); // create receipt object and adds to the
																			// payment database
			CustomerApp.addReceiptinCustomerDatabase(custID, result[0]); // update booking history in customer database
			System.out.println("Thank you for buying our tickets.");
			System.out.println("Here is your receipt:");
			System.out.println("-----------------------------------------------");
			System.out.println("Transaction ID: " + result[0]);
			System.out.println("-----------------------------------------------");
			System.out.println();
			System.out.println("Number of tickets purchased: " + numSeat);
			System.out.println("Payment Mode: " + payment);
			for (int p = 0; p < ticketArr.size(); p++) {
				ticketArr.get(p).getFinalPrice();
				System.out.println("Ticket " + (p + 1) + ": $" + ticketArr.get(p).getFinalPrice());
			}
			System.out.println("Total Amount: $" + result[1]);
			System.out.println();
			System.out.println("-----------------------------------------------");
			System.out.println();
			return 1;
		} else {
			System.out.println("This movie [" + name + "] is not found.");
			return -1; // unsuccessful buying ticket because movie name entered is not found
		}

	}

}
