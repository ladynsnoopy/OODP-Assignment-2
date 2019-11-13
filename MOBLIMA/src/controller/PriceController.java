package controller;

import model.Price;

public class PriceController {
	/**
	 * Initialization of <code>Price</code> object that modifies and determines
	 * final price of ticket
	 */
	public static Price price = new Price();

	/**
	 * Takes in cinemeID, timing and movietitle. If cinemaID does not exists, prints
	 * error message and returns. Else, fetches the relevant cinema object and feeds
	 * into constructor of showtime object. Adds new showtime object to showtimeArr.
	 * Adds new showtime object to showtimedatabase. Adds showtimeID to
	 * moviedatabase for the relevant movie.
	 * 
	 * @param cinemaID   Cinema where showtime will be
	 * @param timing     Timing for showtime
	 * @param movietitle Title of movie to be showed in this showtime object
	 */
	// TODO configure ticket prices, holiday
	/**
	 * Uses selection to determine what to change.
	 * 
	 * @param selection Selection of which type of price to change.
	 * @param p         Object Price to be changed.
	 * @param newPrice  New price to be set.
	 */
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
			System.out.println("Weekend surcharge updated");
			break;
		case (5):
			p.setPriceHol(newPrice);
			System.out.println("Holiday surcharge updated");
			break;
		case (6):
			p.setPriceGoldClass(newPrice);
			System.out.println("Gold class price updated");
		}
	}

}
