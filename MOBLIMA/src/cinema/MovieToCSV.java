package cinema;

import java.util.ArrayList;

public class MovieToCSV {
	public void addMovieToCSV(Movie movie) {
		ArrayList<String> data = new ArrayList<String>();
		data.add(Integer.toString(movie.getMovieID()));
		data.add(movie.getName());
		data.add(movie.getType());
		data.add(movie.getShowingStatus());
		data.add(movie.getSynopsis());
		data.add(movie.getDirector().toString());
		data.add(movie.getCast().toString());
		data.add(movie.getOverallUserRating());
		data.add(Integer.toString(movie.getTicketSales()));
		data.add(movie.getReviewIDs().toString());
		data.add(movie.getShowtimeIDs().toString());
		data.add(movie.getMovieRating());
		csvRW.writeToCSV("moviedatabase", data);
	}
}
