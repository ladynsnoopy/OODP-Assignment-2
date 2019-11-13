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
	public static Calendar calendar = createCalendar();

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
	public static Calendar createCalendar() {
		ArrayList<String> holDates = new ArrayList<String>();
		holDates.add("20191111");
		holDates.add("20191125");
		holDates.add("20191124");
		holDates.add("20191115");
		ArrayList<String> wkndDates = new ArrayList<String>();
		wkndDates.add("20191109");
		wkndDates.add("20191110");
		wkndDates.add("20191116");
		wkndDates.add("20191117");
		wkndDates.add("20191123");
		wkndDates.add("20191124");
		wkndDates.add("20191130");
		Calendar c = new Calendar(holDates, wkndDates);
		return c;

	}

}
