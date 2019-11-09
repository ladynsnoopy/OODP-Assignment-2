package cinema;

import java.util.ArrayList;

public class ReviewToCSV {
	public static void addReviewToCSV(Review review)
	{
		ArrayList<String> data = new ArrayList<String>();
		data.add(Integer.toString(review.getRating()));
		data.add(review.getComment());
		data.add(review.getUserID());
		data.add(Integer.toString(review.getReviewID()));
		csvRW.writeToCSV("reviewdatabase", data);
	}

}
