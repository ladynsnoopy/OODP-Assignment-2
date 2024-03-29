package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import controller.csvRW;

/**
 * Showtime object that represent a particular instance of a movie showing at a
 * particular time.<br>
 * Contains <code>Cinema</code> class that the cinema this showtime is located
 * at belongs to, timing of showtime, seatingplan of the showtime, and list of
 * <code>Seat</code> objects that are contained in this <code>Showtime</code>.
 * 
 * @author Lim Wai Leong
 * @author Oh Jun Teng
 * @author Edhie Wahidin Michelle
 * @author Myat Hmu Khin
 * @version 1.0
 * @since 2019-11-10
 *
 */
public class Showtime {
	/**
	 * <code>Cinema</code> class that the cinema this showtime is located at belongs
	 * to
	 */
	private CinemaI cinema;
	/**
	 * Timing that this showtime will be at in YYYYMMDDHHmm format
	 */
	private String timing;
	/**
	 * Unique showtime ID for this <code>Showtime</code>
	 */
	private int showtimeID;
	/**
	 * Counter that will increment for every new <code>Showtime</code> object
	 */
	private static int showtime_counter = counterInit();
	// boolean 2D array to keep track of occupied status of seats in a 2D form
	/**
	 * Boolean representation of seating plan. <code>true</code> if seat is
	 * occupied, <code>false</code> if seat is unoccupied. Provided x and y
	 * coordinates of a particular seat, can check if seat is occupied in
	 * <code>seatingplan[x-coor][y-coor]</code>.
	 */
	private boolean[][] seatingplan;
	// list of seats that are in this Showtime
	/**
	 * Simple list of <code>Seat</code> objects that belong to this
	 * <code>Showtime</code>.
	 * 
	 * @see Seat
	 */
	private Seat[] seatArr;

	/**
	 * Constructor of <code>Showtime</code> object.<br>
	 * Size of <code>searArr</code> will be determined by total number of rows and
	 * columns fetched from <code>Cinema</code> class.<br>
	 * Size of <code>boolean</code> seatingplan will be determined by total number
	 * of rows and columns fetched from <code>Cinema</code> class.
	 * 
	 * @param cinema <code>Cinema</code> object showtime is located in
	 * @param timing Timing of this showtime in YYYYMMDDHHmm format
	 * @see Seat
	 */
	public Showtime(CinemaI cinema, String timing) {
		super();
		this.cinema = cinema;
		this.timing = timing;
		this.showtimeID = showtime_counter++;
		this.seatArr = new Seat[cinema.getTotalRow() * cinema.getTotalCol()];
		this.seatingplan = new boolean[cinema.getTotalRow()][cinema.getTotalCol()];
		this.generateSeats();
	}

	/**
	 * Gets <code>Cinema</code> object that this showtime belongs to
	 * 
	 * @return <code>Cinema</code> object that this showtime belongs to
	 */
	public CinemaI getCinema() {
		return cinema;
	}

	/**
	 * Gets timing of showtime
	 * 
	 * @return Timing of this showtime
	 */
	public String getTiming() {
		return timing;
	}

	/**
	 * Changes timing of this showtime
	 * 
	 * @param timing Timing of this showtime in YYYYMMDDHHmm format
	 */
	public void setTiming(String timing) {
		this.timing = timing;
	}

	/**
	 * Gets unique showtime ID of this showtime
	 * 
	 * @return <code>ShowtimeID</code> of this showtime
	 */
	public int getShowtimeID() {
		return showtimeID;
	}

	/**
	 * Changes showtime ID for this showtime
	 * 
	 * @param showtimeID New showtime ID for this showtime
	 */
	public void setShowtimeID(int showtimeID) {
		this.showtimeID = showtimeID;
	}

	/**
	 * Gets <code>boolean</code> representation of seating plan of this showtime.
	 * 
	 * @return <code>boolean</code> 2D array representing occupation status of seats
	 *         in seating plan
	 */
	public boolean[][] getSeatingplan() {
		return seatingplan;
	}

	/**
	 * Gets array of <code>Seat</code> objects belonging to this showtime.
	 * 
	 * @return Array of <code>Seat</code> objects belonging to this showtime
	 */
	public Seat[] getSeatArr() {
		return seatArr;
	}

	/**
	 * Generates appropriate number of seats according to cinema size, then adds
	 * into <code>seatArr</code>
	 */
	private void generateSeats() {
		int count = 0;
		for (int i = 0; i < cinema.getTotalRow(); i++) {
			for (int j = 0; j < cinema.getTotalCol(); j++) {
				seatArr[count] = new Seat(j, i, false);
				count++;
			}
		}
	}

	/**
	 * Sets seating plan for this <code>Showtime</code>
	 * 
	 * Seating plan in terms of <code>seat[]</code> index:<br>
	 * 0,1,2,3,4,5 <br>
	 * 6,7,8,9,10,11 <br>
	 * etc
	 * 
	 * so seat index = yCoor * no of columns + xCoor
	 * 
	 * Will change the boolean 2D array to reflect the occupied status of the seats
	 * in seating plan
	 */
	public void setSeatingPlan() {
		ArrayList<String[]> seats_occupied;
		int x, y, seat_index;
		String coors = null;
		seats_occupied = csvRW.readCSV("seatingplandatabase");
		for (int i = 1; i < seats_occupied.size(); i++) {
			if (Integer.parseInt(seats_occupied.get(i)[0]) == this.showtimeID) {
				// changes the x and y coordinates into an ArrayList of [xCoor,yCoor]
				coors = seats_occupied.get(i)[1];
				coors = coors.substring(1, coors.length() - 1);
				List<String> coordinates = new ArrayList<String>(Arrays.asList(coors.split(",")));
				x = Integer.parseInt(coordinates.get(0));
				y = Integer.parseInt(coordinates.get(1));
				// sets the appropriate seat to occupied status
				seat_index = (y * this.cinema.getTotalCol()) + x;
				this.seatArr[seat_index].setOccupied(true);
			}
		}
		// updates boolean array according to occupied status of seat
		for (int i = 0; i < cinema.getTotalNumSeat(); i++) {
			seatingplan[seatArr[i].getyCoor()][seatArr[i].getxCoor()] = seatArr[i].isOccupied();
		}
	}

	/**
	 * Counts number of entries in data to act as counter for ID
	 * 
	 * @return <code>int</code> counter
	 */
	public static int counterInit() {
		ArrayList<String[]> data = new ArrayList<String[]>(csvRW.readCSV("Showtimedatabase"));
		return data.size();
	}

	/**
	 * Takes in this <code>Showtime</code> object and writes all attributes and data
	 * into reviewdatabase. Utilizes csvRW.
	 * 
	 * @param showtime this <code>Showtime</code> object to be written into database
	 * @see csvRW#writeToCSV(String, ArrayList)
	 */
	public void addShowtimeToCSV(Showtime showtime) {
		ArrayList<String> data = new ArrayList<String>();
		data.add(Integer.toString(showtime.showtimeID));
		data.add(showtime.cinema.getCinemaID());
		data.add(showtime.timing);
		csvRW.writeToCSV("showtimedatabase", data);

	}

}
