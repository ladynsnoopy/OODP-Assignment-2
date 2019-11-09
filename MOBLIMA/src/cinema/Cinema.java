package cinema;

/**
 * Cinema object that contains number of rows and columns of seats in the
 * cinema, total number of seats and has a unique CinemaID
 * 
 * @author Jun Teng
 * @version 1.0
 * @since 2019-11-09
 *
 */
public class Cinema {
	/**
	 * Type of cinema in String. Can be "Gold Class", "Normal".
	 */
	private String type;
	/**
	 * Total number of rows of seats in a cinema.
	 */
	private int totalRow;
	/**
	 * Total number of columns of seats in a cinema.
	 */
	private int totalCol;
	/**
	 * Total number of seats in a cinema.
	 */
	private int totalNumSeat;
	/**
	 * Unique String cinema ID.
	 */
	private String cinemaID;

	/**
	 * Constructor for cinema object.
	 * 
	 * @param type     Type of cinema in String. Can be "Gold Class", "Normal".
	 * @param totalRow Total number of rows of seats in a cinema.
	 * @param totalCol Total number of columns of seats in a cinema.
	 * @param cineplex Total number of seats in a cinema.
	 * @param cinemaID Unique String cinema ID.
	 */
	public Cinema(String type, int totalRow, int totalCol, Cineplex cineplex, String cinemaID) {
		super();
		this.type = type;
		this.totalRow = totalRow;
		this.totalCol = totalCol;
		this.cinemaID = cinemaID;
		this.totalNumSeat = totalRow * totalCol;
	}

	/**
	 * 
	 * @return Type of cinema in String. Can be "Gold Class", "Normal".
	 */
	public String getType() {
		return type;
	}

	/**
	 * 
	 * @param type Type of cinema in String. Can be "Gold Class", "Normal".
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 
	 * @return Total number of rows of seats in a cinema.
	 */
	public int getTotalRow() {
		return totalRow;
	}

	/**
	 * 
	 * @param totalRow Total number of rows of seats in a cinema.
	 */
	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}

	/**
	 * 
	 * @return Total number of columns of seats in a cinema.
	 */
	public int getTotalCol() {
		return totalCol;
	}

	/**
	 * 
	 * @param totalCol Total number of columns of seats in a cinema.
	 */
	public void setTotalCol(int totalCol) {
		this.totalCol = totalCol;
	}

	/**
	 * 
	 * @return Total number of seats in a cinema.
	 */
	public int getTotalNumSeat() {
		return totalNumSeat;
	}

	/**
	 * 
	 * @param totalNumSeat Total number of seats in a cinema.
	 */
	public void setTotalNumSeat(int totalNumSeat) {
		this.totalNumSeat = totalRow * totalCol;
	}

	/**
	 * 
	 * @return Unique String cinema ID.
	 */
	public String getCinemaID() {
		return cinemaID;
	}

}