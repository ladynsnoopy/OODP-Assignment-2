package cinema;

import java.util.Comparator;

public class OverallRatingComparator implements Comparator<Movie> {
	public int compare(Movie first, Movie second) {
		//multiplying by 10 so as to ensure comparison between decimal points for differences like 0.1
	       return (int) (first.getOverallUserRatingInInt()*10 - second.getOverallUserRatingInInt()*10);
	    }

}
