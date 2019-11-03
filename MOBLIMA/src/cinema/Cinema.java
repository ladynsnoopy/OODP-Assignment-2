package cinema;

public class Cinema {
	private String type;
	private int totalRow;
	private int totalCol;
	private int totalNumSeat;
	private String cinemaID;
//	private static int cine_counter = 1;

	public Cinema(String type, int totalRow, int totalCol, Cineplex cineplex, String cinemaID) {
		super();
		this.type = type;
		this.totalRow = totalRow;
		this.totalCol = totalCol;
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

	public String getCinemaID() {
		return cinemaID;
	}

}