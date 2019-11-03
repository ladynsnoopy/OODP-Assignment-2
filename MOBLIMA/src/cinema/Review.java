package cinema;

public class Review {
	private int rating;
	private String comment;
	private String userID;
	private int reviewID;
	private static int review_counter=1;

	public Review(int rating, String comment, String userID) {
		this.rating=rating;
		this.comment=comment;
		this.userID=userID;
		this.reviewID=review_counter++;
		
	}
	
	public int getRating() {
		return this.rating;
	}

	public void setRating(int aRating) {
		this.rating = aRating;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String aComment) {
		this.comment = aComment;
	}

	public String getUserID() {
		return this.userID;
	}

	public void setUserID(String aUserID) {
		this.userID = aUserID;
	}

	public int getReviewID() {
		return this.reviewID;
	}

	public void setReviewID(int aReviewID) {
		this.reviewID = aReviewID;
	}
}