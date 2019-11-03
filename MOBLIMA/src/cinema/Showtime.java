package cinema;

public class Showtime {
	private Cinema cinema;
	private String timing;
	private int showtimeID;
	private static int showtime_counter=1;
	private boolean[][] seatingplan;

	public Showtime(Cinema cinema, String timing) {
		super();
		this.cinema = cinema;
		this.timing = timing;
		this.showtimeID = showtime_counter++;
		this.seatingplan = new boolean[cinema.getTotalRow()][cinema.getTotalCol()];
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

	public void setSeatingPlan() {
		for (int i = 0; i < cinema.getTotalNumSeat(); i++) {
			seatingplan[cinema.getSeatArr()[i].getxCoor()][cinema.getSeatArr()[i].getyCoor()] = cinema.getSeatArr()[i]
					.isOccupied();
		}
	}

}
