package cinema;

import java.util.ArrayList;

/**
 * Review object that contains rating, comments, userID, and a unique reviewID.
 * 
 * @author Oh Jun Teng
 * @version 1.0
 * @since 2109-11-13
 *
 */
public class Review {
	private int rating;
	private String comment;
	private String userID;
	private int reviewID;
	private static int review_counter = counterInit();

	/**
	 * Constructor of <code>Review</code> object. Requires rating, and comments
	 * given by customer, and unique customer ID of customer who left the review.
	 * Every new review will also increment counter for <code>ReviewID</code>
	 * ensuring that each review has an unique ID.
	 * 
	 * @param rating  Rating left by customer, integer value out of 10.
	 * @param comment Comment left by customer on movie
	 * @param userID  Unique ID of customer who left the review
	 */
	public Review(int rating, String comment, String userID) {
		this.rating = rating; // out of 10
		this.comment = comment;
		this.userID = userID;
		this.reviewID = review_counter++;

	}

	/**
	 * Counts number of entries of reviews, to act as counter for ID
	 * 
	 * @return <code>int</code> counter
	 */
	public static int counterInit() {
		ArrayList<String[]> data = new ArrayList<String[]>(csvRW.readCSV("reviewdatabase"));
		return data.size();
	}

	/**
	 * Gets rating of this review
	 * 
	 * @return rating of this review out of a scale of 10.
	 */
	public int getRating() {
		return this.rating;
	}

	/**
	 * Changes rating for this review
	 * 
	 * @param aRating New rating for this review
	 */
	public void setRating(int aRating) {
		this.rating = aRating;
	}

	/**
	 * Gets comment of this review
	 * 
	 * @return comment of this review
	 */
	public String getComment() {
		return this.comment;
	}

	/**
	 * Changes comment of this review
	 * 
	 * @param aComment New comment of this review
	 */
	public void setComment(String aComment) {
		this.comment = aComment;
	}

	/**
	 * Gets User ID of user who left the review
	 * 
	 * @return User ID of user who left the review
	 */
	public String getUserID() {
		return this.userID;
	}

	/**
	 * Changes User ID of user who left the review
	 * 
	 * @param aUserID New User ID of user
	 */
	public void setUserID(String aUserID) {
		this.userID = aUserID;
	}

	/**
	 * Gets unique Review ID of this review
	 * 
	 * @return Review ID of this review
	 */
	public int getReviewID() {
		return this.reviewID;
	}

	/**
	 * Changes Review ID of this review
	 * 
	 * @param aReviewID New review ID of this review
	 */
	public void setReviewID(int aReviewID) {
		this.reviewID = aReviewID;
	}

	/**
	 * Takes in <code>Review</code> object and writes all attributes and data into
	 * reviewdatabase. Utilizes csvRW.
	 * 
	 * @param review <code>Review</code> object to be written into database
	 * @see csvRW#writeToCSV(String, ArrayList)
	 */
	public void addReviewToCSV(Review review) {
		ArrayList<String> data = new ArrayList<String>();
		data.add(Integer.toString(review.rating));
		data.add(review.comment);
		data.add(review.userID);
		data.add(Integer.toString(review.reviewID));
		csvRW.writeToCSV("reviewdatabase", data);
	}
}