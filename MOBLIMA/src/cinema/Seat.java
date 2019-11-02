package cinema;

public class Seat {
	private int xCoor;
	private int yCoor;
	private boolean isOccupied;

	public Seat(int xCoor, int yCoor, boolean isOccupied) {
		super();
		this.xCoor = xCoor;
		this.yCoor = yCoor;
		this.isOccupied = isOccupied;
	}

	public int getxCoor() {
		return xCoor;
	}

	public void setxCoor(int xCoor) {
		this.xCoor = xCoor;
	}

	public int getyCoor() {
		return yCoor;
	}

	public void setyCoor(int yCoor) {
		this.yCoor = yCoor;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

}
