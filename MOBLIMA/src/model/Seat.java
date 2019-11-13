package model;

/**
 * Seat object that contains x and y coordinates and occupied status for the
 * seat.
 * 
 * @author Oh Jun Teng
 * @version 1.0
 * @since 2019-11-09
 */
public class Seat {
	/**
	 * X-coordinate of the seat
	 */
	private int xCoor;
	/**
	 * Y-coordinate of the seat
	 */
	private int yCoor;
	/**
	 * true if occupied, false if not
	 */
	private boolean isOccupied;

	/**
	 * Constructor for Seat object.
	 * 
	 * @param xCoor      x-coordinate location of seat
	 * @param yCoor      y-coordinate location of seat
	 * @param isOccupied true if occupied, false if not
	 */
	public Seat(int xCoor, int yCoor, boolean isOccupied) {
		super();
		this.xCoor = xCoor;
		this.yCoor = yCoor;
		this.isOccupied = isOccupied;
	}

	/**
	 * @return x-coordinates.
	 */
	public int getxCoor() {
		return xCoor;
	}

	/**
	 * @param xCoor x-coordinate of seat
	 */
	public void setxCoor(int xCoor) {
		this.xCoor = xCoor;
	}

	/**
	 * @return y-coordinate of seat
	 */
	public int getyCoor() {
		return yCoor;
	}

	/**
	 * @param yCoor y-coordinate of seat
	 */
	public void setyCoor(int yCoor) {
		this.yCoor = yCoor;
	}

	/**
	 * @return true if occupied, false if not
	 */
	public boolean isOccupied() {
		return isOccupied;
	}

	/**
	 * @param isOccupied true if occupied, false if not
	 */
	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

}
