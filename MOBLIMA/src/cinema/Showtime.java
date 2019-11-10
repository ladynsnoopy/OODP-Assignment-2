package cinema;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Showtime {
	private Cinema cinema;
	private String timing;
	private int showtimeID;
	private static int showtime_counter = 1;
	// boolean 2D array to keep track of occupied status of seats in a 2D form
	private boolean[][] seatingplan;
	// list of seats that are in this Showtime
	private Seat[] seatArr;

	public Showtime(Cinema cinema, String timing) {
		super();
		this.cinema = cinema;
		this.timing = timing;
		this.showtimeID = showtime_counter++;
		this.seatArr = new Seat[cinema.getTotalRow() * cinema.getTotalCol()];
		this.seatingplan = new boolean[cinema.getTotalRow()][cinema.getTotalCol()];
		this.generateSeats();
	}

	public Cinema getCinema() {
		return cinema;
	}

	public String getTiming() {
		return timing;
	}

	public void setTiming(String timing) {
		this.timing = timing;
	}

	public int getShowtimeID() {
		return showtimeID;
	}

	public void setShowtimeID(int showtimeID) {
		this.showtimeID = showtimeID;
	}

	public boolean[][] getSeatingplan() {
		return seatingplan;
	}

	public Seat[] getSeatArr() {
		return seatArr;
	}

	/**
	 * generates appropriate number of seats according to cinema size, then adds into seatArr
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
	 * Sets seating plan for this Showtime</br>
	 * 
	 * Seating plan in terms of seat[] index: </br>
	 * 0,1,2,3,4,5 </br>
	 * 6,7,8,9,10,11</br>
	 *  etc</br>
	 * 
	 * so seat index = yCoor * no of columns + xCoor</br>
	 * 
	 * Will change the boolean 2D array to reflect the occupied status of the seats in seating plan</br>
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

	public static void addShowtimeToCSV(Showtime showtime) {
		ArrayList<String> data = new ArrayList<String>();
		data.add(Integer.toString(showtime.getShowtimeID()));
		data.add(showtime.getCinema().getCinemaID());
		data.add(showtime.getTiming());
		csvRW.writeToCSV("showtimedatabase", data);
	
	}

}
