package cinema;

import java.util.ArrayList;

public class MovieList {
	private ArrayList<Movie> movieArr = new ArrayList<Movie>();
	private int cineplexID;
	
	public MovieList(ArrayList<Movie> movieArr, int cineplexID) {
		this.cineplexID=cineplexID;
		this.movieArr=movieArr;
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

	public int getCineplexID() {
		return this.cineplexID;
	}

	public void setCineplexID(int aCineplexID) {
		this.cineplexID = aCineplexID;
	}

}