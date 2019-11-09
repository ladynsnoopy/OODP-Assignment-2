package cinema;

import java.util.ArrayList;
import java.util.Random;

/**
 * Cineplex object that contains ArrayList of cinema objects belonging to the
 * cineplex, location of cineplex, unique cineplex ID.
 * 
 * @author Oh Jun Teng
 * @version 1.0
 * @since 2019-11-09
 *
 */
public class Cineplex {
	/**
	 * ArrayList of cinema objects belonging to the cineplex
	 */
	private ArrayList<Cinema> cinemaArr;
	/**
	 * Location of cineplex in String
	 */
	private String location;
	/**
	 * Unique cineplex ID
	 */
	private String CineplexID;

	/**
	 * Constructor of Cineplex object.
	 * 
	 * @param location   Location of cineplex in String
	 * @param cineplexID Unique cineplex ID
	 */
	public Cineplex(String location, String cineplexID) {
		super();
		this.location = location;
		this.CineplexID = cineplexID;
	}

	/**
	 * 
	 * @return ArrayList of cinema objects belonging to the cineplex
	 */
	public ArrayList<Cinema> getCinemaArr() {
		return cinemaArr;
	}

	/**
	 * 
	 * @param cinemaArr ArrayList of cinema objects belonging to the cineplex
	 */
	public void setCinemaArr(ArrayList<Cinema> cinemaArr) {
		this.cinemaArr = cinemaArr;
	}

	/**
	 * 
	 * @return Location of cineplex in String
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * 
	 * @param location Location of cineplex in String
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * 
	 * @return Unique cineplex ID
	 */
	public String getCineplexID() {
		return CineplexID;
	}

	/**
	 * 
	 * @param cineplexID Unique cineplex ID
	 */
	public void setCineplexID(String cineplexID) {
		CineplexID = cineplexID;
	}

}