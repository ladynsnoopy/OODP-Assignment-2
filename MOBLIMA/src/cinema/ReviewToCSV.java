package cinema;

import java.util.ArrayList;

/**
 * Control class to store <code>Review</code> object into reviewdatabase.
 * 
 * @author Edhie Wahidin Michelle
 * @version 1.0
 * @since 2019-11-10
 *
 */
public class ReviewToCSV {
	/**
	 * Takes in <code>Review</code> object and writes all attributes and data into
	 * reviewdatabase. Utilizes csvRW.
	 * 
	 * @param review <code>Review</code> object to be written into database
	 * @see csvRW#writeToCSV(String, ArrayList)
	 */
	public static void addReviewToCSV(Review review) {
		ArrayList<String> data = new ArrayList<String>();
		data.add(Integer.toString(review.getRating()));
		data.add(review.getComment());
		data.add(review.getUserID());
		data.add(Integer.toString(review.getReviewID()));
		csvRW.writeToCSV("reviewdatabase", data);
	}

}
