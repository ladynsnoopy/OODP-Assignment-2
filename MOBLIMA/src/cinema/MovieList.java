package cinema;

import java.util.ArrayList;

public class MovieList {
	private ArrayList<Movie> movieArr = new ArrayList<Movie>();
	
	
	public void addMovie(Movie m) {
		movieArr.add(m);
	}

	public ArrayList<Movie> getMovieArr() {
		return this.movieArr;
	}

	public void setMovieArr(ArrayList<Movie> aMovieArr) {
		this.movieArr = aMovieArr;
	}

}