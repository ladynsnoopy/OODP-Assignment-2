package controller;

import java.util.ArrayList;
import model.Calendar;

/**
 * A control class that will handle methods relating to the calendar model. 
 * It allows staff to initialize the <code>Calendar</code> object and modify weekend/holidaydates. 
 * 
 * @author Lim Wai Leong
 * @author Oh Jun Teng
 * @author Edhie Wahidin Michelle
 * @author Myat Hmu Khin
 * @version 1.0
 * @since 2019-11-13
 * @see Calendar
 *
 */

public class CalendarController {
	/**
	 * Initialization of <code>Calendar</code> object that contains all special
	 * dates that affect price.
	 */
	public static Calendar calendar = new Calendar();

	/**
	 * 
	 * @param selection Choice of what kind of date to add. "0" for holiday date,
	 *                  "1" for weekend date.
	 * @param date      date to be added to the calendar. Should be in
	 *                  <code>String</code> format YYYYMMDD.
	 * @param c         Calendar object date is to be added to.
	 */
	public static void configureDates(int selection, String date, Calendar c) {
		switch (selection) {
		case (1):
			c.addHolArr(date);
			System.out.println("Holiday date added");
			break;
		case (2):
			c.addWkndArr(date);
			System.out.println("Weekend date added");
			break;
		}
	}

	/**
	 * Creates special dates that have special prices. Ie. holday dates and weekend
	 * dates.
	 * 
	 * @return calendar object
	 */


}
