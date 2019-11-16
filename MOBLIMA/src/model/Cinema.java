package model;

/**
 * Cinema object that contains details specific to each cinema. Eg. number of
 * rows and columns of seats in the cinema, total number of seats and a unique
 * CinemaID
 * 
 * @author Lim Wai Leong
 * @author Oh Jun Teng
 * @author Edhie Wahidin Michelle
 * @author Myat Hmu Khin
 * @version 1.0
 * @since 2019-11-09
 *
 */
public class Cinema implements CinemaI {
	/**
	 * Type of cinema in <code>String</code>. Can be "Gold Class", "Normal".
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
	 * Unique <code>String</code> cinema ID.
	 */
	private String cinemaID;

	/**
	 * Constructor for <code>Cinema</code> object.
	 * 
	 * @param type     Type of cinema in <code>String</code>. Can be "Gold Class",
	 *                 "Normal".
	 * @param totalRow Total number of rows of seats in a cinema.
	 * @param totalCol Total number of columns of seats in a cinema.
	 * @param cinemaID Unique <code>String</code> cinema ID.
	 */
	public Cinema(String type, int totalRow, int totalCol, String cinemaID) {
		super();
		this.type = type;
		this.totalRow = totalRow;
		this.totalCol = totalCol;
		this.cinemaID = cinemaID;
		this.totalNumSeat = totalRow * totalCol;
	}

	/**
	 * Gets type of cinema in <code>String</code>.
	 * 
	 * @return Type of cinema in <code>String</code>. Can be "Gold Class", "Normal".
	 */
	public String getType() {
		return type;
	}

	/**
	 * Changes type of cinema.
	 * 
	 * @param type Type of cinema in <code>String</code>. Can be "Gold Class",
	 *             "Normal".
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets total number of rows of seats in a cinema
	 * 
	 * @return Total number of rows of seats in a cinema.
	 */
	public int getTotalRow() {
		return totalRow;
	}

	/**
	 * Changes total number of rows of seats in a cinema.
	 * 
	 * @param totalRow Total number of rows of seats in a cinema.
	 */
	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}

	/**
	 * Gets total number of columns of seats in a cinema.
	 * 
	 * @return Total number of columns of seats in a cinema.
	 */
	public int getTotalCol() {
		return totalCol;
	}

	/**
	 * Changes total number of columns of seats in a cinema.
	 * 
	 * @param totalCol Total number of columns of seats in a cinema.
	 */
	public void setTotalCol(int totalCol) {
		this.totalCol = totalCol;
	}

	/**
	 * Gets total number of seats in a cinema.
	 * 
	 * @return Total number of seats in a cinema.
	 */
	public int getTotalNumSeat() {
		return totalNumSeat;
	}

	/**
	 * Changes total number of seats in a cinema.
	 * 
	 * @param totalNumSeat Total number of seats in a cinema.
	 */
	public void setTotalNumSeat(int totalNumSeat) {
		this.totalNumSeat = totalRow * totalCol;
	}

	/**
	 * Gets Unique <code>String</code> cinema ID.
	 * 
	 * @return Unique <code>String</code> cinema ID.
	 */
	public String getCinemaID() {
		return cinemaID;
	}

}