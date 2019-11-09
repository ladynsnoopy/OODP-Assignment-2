package cinema;

import java.util.ArrayList;

/**
 * Calendar object that contains special dates that have special prices. Eg.
 * Weekends, holidays holArr contains holiday dates. weekendArr contains weekend
 * dates.
 * 
 * @author Lim Wai Leong
 * @version 1.0
 * @since 2019-11-09
 */
public class Calendar {
	/**
	 * ArrayList containing holiday dates in String format YYYYMMDD
	 */
	private ArrayList<String> holArr; // DATE = YYYYMMDD
	/**
	 * ArrayList containing weekend dates in String format YYYYMMDD
	 */
	private ArrayList<String> weekendArr;

	/**
	 * Constructor for Calendar object.
	 * 
	 * @param holArr     ArrayList containing holiday dates in String format
	 *                   YYYYMMDD
	 * @param weekendArr ArrayList containing weekend dates in String format
	 *                   YYYYMMDD
	 */
	public Calendar(ArrayList<String> holArr, ArrayList<String> weekendArr) {
		super();
		this.holArr = holArr;
		this.weekendArr = weekendArr;
	}

	/**
	 * @return ArrayList containing weekend dates in String format YYYYMMDD
	 */
	public ArrayList<String> getWeekendArr() {
		return weekendArr;
	}

	/**
	 * @param weekendArr ArrayList containing weekend dates in String format
	 *                   YYYYMMDD
	 */
	public void setWeekendArr(ArrayList<String> weekendArr) {
		this.weekendArr = weekendArr;
	}

	/**
	 * @return ArrayList ArrayList containing holiday dates in String format
	 *         YYYYMMDD
	 */
	public ArrayList<String> getHolArr() {
		return holArr;
	}

	/**
	 * @param hol ArrayList containing holiday dates in String format YYYYMMDD
	 */
	public void addHolArr(String hol) {
		holArr.add(hol);
	}
	/**
	 * @param hol ArrayList containing holiday dates in String format YYYYMMDD
	 */
	public void addWkndArr(String hol) {
		weekendArr.add(hol);
	}

	/**
	 * Checks if showtime date is holiday date
	 * 
	 * @param a showtime object to be checked
	 * @return boolean true if is holiday, false if not
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
	 * @param a showtime object to be checked
	 * @return boolean true if is weekend, false if not
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
