package cinema;

import java.util.ArrayList;
import java.util.Random;

public class Cineplex {
	private ArrayList<Cinema> cinemaArr;
	private String location;
	private String CineplexID;

	public Cineplex(String location, String cineplexID) {
		super();
		this.location = location;
		this.CineplexID = cineplexID;
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

	public String getCineplexID() {
		return CineplexID;
	}

	public void setCineplexID(String cineplexID) {
		CineplexID = cineplexID;
	}

}