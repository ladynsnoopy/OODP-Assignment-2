package cinema;

import java.util.ArrayList;

public class Cineplex {
	private ArrayList<Cinema> cinemaArr;
	private String location;
	private int CineplexID;

	public Cineplex(ArrayList<Cinema> cinemaArr, String location, int cineplexID) {
		super();
		this.cinemaArr = cinemaArr;
		this.location = location;
		CineplexID = cineplexID;
	}

	public ArrayList<Cinema> getCinemaArr() {
		return cinemaArr;
	}

	public void setCinemaArr(ArrayList<Cinema> cinemaArr) {
		this.cinemaArr = cinemaArr;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getCineplexID() {
		return CineplexID;
	}

	public void setCineplexID(int cineplexID) {
		CineplexID = cineplexID;
	}

}
