package controller;

import java.util.ArrayList;

import model.CurrentTicket;
import model.Movie;

/**
 * A control class that will handle methods relating to the Ticket model. It
 * allows for creation and addition for the <code>Ticket</code>
 * objects, and updates the database accordingly each time.
 * 
 * @author Lim Wai Leong
 * @author Oh Jun Teng
 * @author Edhie Wahidin Michelle
 * @author Myat Hmu Khin
 * @version 1.0
 * @since 2019-11-13
 *
 *
 */
public class TicketController {
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
	public static CurrentTicket addTicket(int showtimeID, String movietitle, int isAdult) {
		// I have assumed that by this stage all the info entered for parameters is
		// correct
		int index = 0;
		for (int i = 0; i < ShowtimeController.showtimeArr.size(); i++) {
			if (showtimeID == ShowtimeController.showtimeArr.get(i).getShowtimeID()) {
				index = i; // get the index of the showtime object in the showtimeArr
				break;
			}
		}
		CurrentTicket addnew = new CurrentTicket(ShowtimeController.showtimeArr.get(index)); // create a new Ticket
																								// object
		addnew.setIsAdult(isAdult); // set the isAdult option of Ticket
		String cinetype = addnew.getShowtime().getCinema().getType();
		addnew.setFinalPrice(CalendarController.calendar, PriceController.price, cinetype); // set the final price of
																							// the Ticket based on
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
			if (MovieController.searchOneMovie(movietitle) == MovieController.movieArr.get(k).getMovieID()) {
				MovieController.movieArr.get(k).increaseTicketSalesByOne();
				break;
			}
		}

		return addnew;
	}

}
