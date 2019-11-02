package cinema;

import java.util.ArrayList;

public class Cineplex {
	private ArrayList<Cinema> cinemaArr;
	private String location;
	private String CineplexID;

	public Cineplex(ArrayList<Cinema> cinemaArr, String location) {
		super();
		this.cinemaArr = cinemaArr;
		this.location = location;
		this.CineplexID = cineplex_counter++;
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
