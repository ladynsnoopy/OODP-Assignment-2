package model;

import java.util.ArrayList;

/**
 * Calendar object that contains special dates that have special prices. Eg.
 * Weekends, holidays. <code>holArr</code> contains holiday dates.
 * <code>weekendArr</code> contains weekend dates.
 * 
 * @author Lim Wai Leong
 * @author Oh Jun Teng
 * @author Edhie Wahidin Michelle
 * @author Myat Hmu Khin
 * @version 1.0
 * @since 2019-11-09
 */
public class Calendar {
	/**
	 * <code>ArrayList</code> containing holiday dates in <code>String</code> format
	 * YYYYMMDD
	 */
	private ArrayList<String> holArr; // DATE = YYYYMMDD
	/**
	 * <code>ArrayList</code> containing weekend dates in <code>String</code> format
	 * YYYYMMDD
	 */
	private ArrayList<String> weekendArr;

	/**
	 * Constructor for <code>Calendar</code> object.
	 * 
	 * @param holArr     <code>ArrayList</code> containing holiday dates in
	 *                   <code>String</code> format YYYYMMDD
	 * @param weekendArr <code>ArrayList</code> containing weekend dates in
	 *                   <code>String</code> format YYYYMMDD
	 */
	public Calendar(ArrayList<String> holArr, ArrayList<String> weekendArr) {
		super();
		this.holArr = holArr;
		this.weekendArr = weekendArr;
	}

	/**
	 * Gets <code>ArrayList</code> containing weekend dates
	 * 
	 * @return <code>ArrayList</code> containing weekend dates in
	 *         <code>String</code> format YYYYMMDD
	 */
	public ArrayList<String> getWeekendArr() {
		return weekendArr;
	}

	/**
	 * Changes <code>ArrayList</code> containing weekend dates
	 * 
	 * @param weekendArr New <code>ArrayList</code> containing weekend dates in
	 *                   <code>String</code> format YYYYMMDD
	 */
	public void setWeekendArr(ArrayList<String> weekendArr) {
		this.weekendArr = weekendArr;
	}

	/**
	 * Gets ArrayList <code>ArrayList</code> containing holiday dates.
	 * 
	 * @return ArrayList <code>ArrayList</code> containing holiday dates in
	 *         <code>String</code> format YYYYMMDD
	 */
	public ArrayList<String> getHolArr() {
		return holArr;
	}

	/**
	 * Adds new holiday date to <code>Calendar</code>
	 * 
	 * @param hol Holiday dates in <code>String</code> format YYYYMMDD
	 */
	public void addHolArr(String hol) {
		holArr.add(hol);
	}

	/**
	 * Adds new weekend date to <code>Calendar</code>
	 * 
	 * @param hol Weekend dates in <code>String</code> format YYYYMMDD
	 */
	public void addWkndArr(String hol) {
		weekendArr.add(hol);
	}

	/**
	 * Checks if <code>Showtime</code> date is holiday date
	 * 
	 * @param a <code>Showtime</code> object to be checked
	 * @return <code>true</code> if is holiday, <code>false</code> if not
	 */
	public boolean checkHols(Showtime a) {
		boolean isHols = false;
		for (int i = 0; i < holArr.size(); i++) {
			if (a.getTiming().equals(holArr.get(i))) {
				isHols = true;
				break;
			}
		}
		return isHols;
	}

	/**
	 * Checks if a showtime is during the weekend.
	 * 
	 * @param a <code>Showtime</code> object to be checked
	 * @return <code>true</code> if is weekend, <code>false</code> if not
	 */
	public boolean checkWeekend(Showtime a) {
		boolean isWeekend = false;
		for (int i = 0; i < weekendArr.size(); i++) {
			if (a.getTiming().equals(weekendArr.get(i))) {
				isWeekend = true;
				break;
			}
		}
		return isWeekend;
	}

}
