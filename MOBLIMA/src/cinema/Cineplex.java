package cinema;

import java.util.ArrayList;
import java.util.Random;

public class Cineplex {
	private ArrayList<Cinema> cinemaArr;
	private String location;
	private String CineplexID;

	public Cineplex(String location, String cineplexID) {
		super();
//		this.cinemaArr = cinemaArr;
		this.location = location;
		this.CineplexID = cineplexID;
	}
	//generate random letters
//	public static String generateRandomChars(String candidateChars, int length) {
//	    StringBuilder sb = new StringBuilder();
//	    Random random = new Random();
//	    for (int i = 0; i < length; i++) {
//	        sb.append(candidateChars.charAt(random.nextInt(candidateChars
//	                .length())));
//	    }
//
//	    return sb.toString();
//	}
	
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