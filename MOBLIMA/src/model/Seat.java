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
	 * Gets x-coordinate of seat
	 * 
	 * @return x-coordinate of seat
	 */
	public int getxCoor() {
		return xCoor;
	}

	/**
	 * Changes x-coordinate of seat
	 * 
	 * @param xCoor New x-coordinate of seat
	 */
	public void setxCoor(int xCoor) {
		this.xCoor = xCoor;
	}

	/**
	 * Gets y-coordinate of seat.
	 * 
	 * @return y-coordinate of seat
	 */
	public int getyCoor() {
		return yCoor;
	}

	/**
	 * Changes y-coordinate of seat
	 * 
	 * @param yCoor New y-coordinate of seat
	 */
	public void setyCoor(int yCoor) {
		this.yCoor = yCoor;
	}

	/**
	 * Gets occupied status of seat
	 * 
	 * @return <code>true</code> if occupied, <code>false</code> if not
	 */
	public boolean isOccupied() {
		return isOccupied;
	}

	/**
	 * Changes occupied status of seat
	 * 
	 * @param isOccupied New occupied status of seat. <code>true</code> if occupied,
	 *                   <code>false</code> if not
	 */
	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

}
