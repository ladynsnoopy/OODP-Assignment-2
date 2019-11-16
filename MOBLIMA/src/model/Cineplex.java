package model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Cineplex object that contains <code>ArrayList</code> of <code>Cinema</code>
 * objects belonging to this cineplex, location of cineplex, unique cineplex ID.
 * 
 * @author Lim Wai Leong
 * @author Oh Jun Teng
 * @author Edhie Wahidin Michelle
 * @author Myat Hmu Khin
 * @version 1.0
 * @since 2019-11-09
 *
 */
public class Cineplex {
	/**
	 * <code>ArrayList</code> of <code>Cinema</code> objects belonging to the
	 * cineplex.
	 * 
	 * @see Cinema
	 */
	private ArrayList<Cinema> cinemaArr;
	/**
	 * Location of cineplex in <code>String</code>
	 * 
	 */
	private String location;
	/**
	 * Unique cineplex ID
	 */
	private String CineplexID;

	/**
	 * Constructor of <code>Cineplex</code> object.
	 * 
	 * @param location   Location of cineplex in <code>String</code>
	 * @param cineplexID Unique cineplex ID
	 */
	public Cineplex(String location, String cineplexID) {
		super();
		this.location = location;
		this.CineplexID = cineplexID;
	}

	/**
	 * Gets <code>ArrayList</code> of <code>Cinema</code> objects belonging to this
	 * cineplex
	 * 
	 * @return <code>ArrayList</code> of <code>Cinema</code> objects belonging to
	 *         this cineplex
	 * @see Cinema
	 */
	public ArrayList<Cinema> getCinemaArr() {
		return cinemaArr;
	}

	/**
	 * Changes <code>ArrayList</code> of <code>Cinema</code> objects belonging to
	 * this cineplex
	 * 
	 * @param cinemaArr <code>ArrayList</code> of <code>Cinema</code> objects
	 *                  belonging to this cineplex
	 * @see Cinema
	 */
	public void setCinemaArr(ArrayList<Cinema> cinemaArr) {
		this.cinemaArr = cinemaArr;
	}

	/**
	 * Gets location of cineplex in <code>String</code>
	 * 
	 * @return Location of cineplex in <code>String</code>
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Changes location of cineplex
	 * 
	 * @param location Location of cineplex in <code>String</code>
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Gets unique cineplex ID
	 * 
	 * @return Unique cineplex ID
	 */
	public String getCineplexID() {
		return CineplexID;
	}

	/**
	 * Changes unique cineplex ID
	 * 
	 * @param cineplexID Unique cineplex ID
	 */
	public void setCineplexID(String cineplexID) {
		CineplexID = cineplexID;
	}

}