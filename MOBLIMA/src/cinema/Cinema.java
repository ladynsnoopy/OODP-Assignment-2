package cinema;

public class Cinema {
	private String type;
	private int totalRow;
	private int totalCol;
	private int totalNumSeat;
	private Seat[] seatArr;
	private int cinemaID;

	public Cinema(String type, int totalRow, int totalCol, int cinemaID) {
		super();
		this.type = type;
		this.totalRow = totalRow;
		this.totalCol = totalCol;
		this.seatArr = new Seat[totalRow * totalCol];
		this.generateSeats();
		this.cinemaID = cinemaID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}

	public int getTotalCol() {
		return totalCol;
	}

	public void setTotalCol(int totalCol) {
		this.totalCol = totalCol;
	}

	public int getTotalNumSeat() {
		return totalNumSeat;
	}

	public void setTotalNumSeat(int totalNumSeat) {
		this.totalNumSeat = totalRow * totalCol;
	}

	public int getCinemaID() {
		return cinemaID;
	}

	public void setCinemaID(int cinemaID) {
		this.cinemaID = cinemaID;
	}

	public Seat[] getSeatArr() {
		return seatArr;
	}

	// generates appropriate number of seats according to cinema size, then adds in
	// array
	public void generateSeats() {
		int count = 0;
		for (int i = 0; i < totalRow; i++) {
			for (int j = 0; j < totalCol; j++) {
				seatArr[count] = new Seat(i, j, false);
				count++;
			}
		}
	}

}
