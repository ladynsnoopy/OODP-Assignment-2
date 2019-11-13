package controller;

import java.util.ArrayList;

import model.Movie;
import model.Review;
/**
 * A control class that will handle methods relating to the Review model. It
 * allows for additon and search for the <code>Review</code> objects, and updates the database accordingly each time.
 * 	
 * @author Lim Wai Leong
 * @author Oh Jun Teng
 * @author Edhie Wahidin Michelle
 * @author Myat Hmu Khin
 * @version 1.0
 * @since 2019-11-13
 *
 *
 */
public class ReviewController {
	/**
	 * Searches for review details (User rating, comment) given a target
	 * <code>reviewID</code>.
	 * 
	 * @param reviewID unique <code>reviewID</code> for target review
	 * @return <code>String</code> array of size 2 containing the user rating and
	 *         comment in indexes 0 and 1 respectively
	 */
	public static String[] searchforReview(int reviewID) {
		String a = Integer.toString(reviewID);
		ArrayList<String> result = csvRW.search("reviewdatabase", "ReviewID", a);
		String[] rating_comment = new String[2];
		rating_comment[0] = result.get(0);
		rating_comment[1] = result.get(1);
		return rating_comment;
	}
	
	/**
	 * Allows movie-goer to add review to a selected movie. Will update relevant
	 * <code>Movie</code> object.
	 * 
	 * @param rating     Movie-goer's rating out of 10 in integers
	 * @param comment    Comments left by Movie-goer
	 * @param userID     UserID of movie-goer who left the review
	 * @param movie_name Title of selected movie
	 * @see Movie#addReview(Review)
	 */
	public static void addReview(int rating, String comment, String userID, String movie_name) {

		Review a = new Review(rating, comment, userID);
		a.addReviewToCSV(a);
		ArrayList<String> movie_row = csvRW.search("moviedatabase", "Name", movie_name); // search for that movie in
																							// movie database
		String id = movie_row.get(0);
		String reviews = movie_row.get(9);
		for (int k = 0; k < MovieController.movieArr.size(); k++) {
			if (MovieController.searchOneMovie(movie_name) == MovieController.movieArr.get(k).getMovieID()) {
				MovieController.movieArr.get(k).addReview(a); // add the review to the movie object in movieArr
				String userRating = MovieController.movieArr.get(k).getOverallUserRating();
				System.out.println("overall user rating: " + userRating);
				csvRW.editCSV("moviedatabase", id, "OverallRating", userRating); // write new Overall Rating to the
																					// movie database
				break;
			}
		}
		// if there are no reviews initially
		if (reviews.equals("")) {
			csvRW.editCSV("moviedatabase", id, "ReviewID", Integer.toString(a.getReviewID())); // write reviewID to
																								// movie database

		} else {
			// if there are more than one review
			if (reviews.length() != 1) {
				String cut = reviews.substring(1, reviews.length() - 1);
				String[] arr = cut.split(",");
				String b = "";
				for (int i = 0; i < arr.length; i++) {
					b += arr[i] + ",";
				}
				b += Integer.toString(a.getReviewID());
				csvRW.editCSV("moviedatabase", id, "ReviewID", b); // write reviewID to movie database
			} else {
				// if there is one review
				String b = reviews + "," + Integer.toString(a.getReviewID());
				csvRW.editCSV("moviedatabase", id, "ReviewID", b);
			}

		}

	}

}
