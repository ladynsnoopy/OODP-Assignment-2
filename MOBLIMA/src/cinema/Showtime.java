package cinema;

public class Showtime {
	private Cinema cinema;
	private String timing;
	private int showtimeID;
	private static int showtime_counter = 1;
	private boolean[][] seatingplan;
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

	// generates appropriate number of seats according to cinema size, then adds in
	// array
	public void generateSeats() {
		int count = 0;
		for (int i = 0; i < cinema.getTotalRow(); i++) {
			for (int j = 0; j < cinema.getTotalCol(); j++) {
				seatArr[count] = new Seat(i, j, false);
				count++;
			}
		}
	}

	public void setSeatingPlan() {
		for (int i = 0; i < cinema.getTotalNumSeat(); i++) {
			seatingplan[seatArr[i].getxCoor()][seatArr[i].getyCoor()] = seatArr[i].isOccupied();
		}
	}

}
