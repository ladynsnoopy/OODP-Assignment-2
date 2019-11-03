package cinema;

import java.util.ArrayList;

public class MovieList {
	private ArrayList<Movie> movieArr = new ArrayList<Movie>();
	private String cineplexID;
	
	public MovieList(String cineplexID) {
		this.cineplexID=cineplexID;
	}
	
	public void addMovie(Movie m) {
		movieArr.add(m);
	}

	public ArrayList<Movie> getMovieArr() {
		return this.movieArr;
	}

	public void setMovieArr(ArrayList<Movie> aMovieArr) {
		this.movieArr = aMovieArr;
	}

	public String getCineplexID() {
		return this.cineplexID;
	}

	public void setCineplexID(String aCineplexID) {
		this.cineplexID = aCineplexID;
	}

}