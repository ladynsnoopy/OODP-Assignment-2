package model;

/**
 * Seat object that contains x and y coordinates and occupied status for the
 * seat.
 * 
 * @author Lim Wai Leong
 * @author Oh Jun Teng
 * @author Edhie Wahidin Michelle
 * @author Myat Hmu Khin
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
	 * <code>true</code> if occupied, <code>false</code> if not
	 */
	private boolean isOccupied;

	/**
	 * Constructor for <code>Seat</code> object.
	 * 
	 * @param xCoor      x-coordinate location of seat
	 * @param yCoor      y-coordinate location of seat
	 * @param isOccupied <code>true</code> if occupied, <code>false</code> if not
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
