package cinema;

import java.util.ArrayList;

/**
 * Movie object that contains movie details, as well as an ArrayList<Review> of
 * reviews for the movie, and an ArrayList<Showtime> of showtimes for this
 * movie. Also contains average ratings left by reviewers.
 * 
 * @author Edhie Wahidin Michelle
 * @version 1.0
 * @since 2019-11-09
 *
 */
public class Movie {
	/**
	 * Unique movie ID for the movie
	 */
	private int movieID;
	/**
	 * Static counter that will increment every time a new movie object is created.
	 */
	private static int movie_counter = 1;
	/**
	 * Title of movie
	 */
	private String name;
	/**
	 * Showing status of movie. Can be "Coming Soon, Preview, Now Showing, End of
	 * Showing.
	 */
	private String showingStatus;
	/**
	 * Synopsis of movie
	 */
	private String synopsis;
	/**
	 * ArrayList<String> of names of cast members
	 */
	private ArrayList<String> cast;
	/*
	 * Name of director for the movie
	 */
	private String director;
	/**
	 * Type or genre of movie. Can be "Action, Horror, Romance, Animated"
	 */
	private String type;
	/**
	 * ArrayList of Review objects for this movie called reviewArr
	 */
	private ArrayList<Review> reviewArr = new ArrayList<Review>();
	/**
	 * ArrayList of Showtime objects for this movie called showtimeArr
	 */
	private ArrayList<Showtime> showtimeArr = new ArrayList<Showtime>();
	/**
	 * Average rating of movie left by users, stored in String format. Defaults to
	 * "NA" when no review has been left.
	 */
	private String overallUserRating = "NA";
	/**
	 * Rating of movie. Can be "G, PG, PG13, NC16, M18, R21".
	 */
	private String movieRating;
	/**
	 * Ticket sales for this movie. If no sales, default is int 0.
	 */
	private int ticketSales = 0;

	/**
	 * Adds a review to the ArrayList of Review objects.
	 * 
	 * @param r Review object to be inserted into ArrayList
	 */
	public void addReview(Review r) {
		reviewArr.add(r);
	}

	/**
	 * Adds a showtime to the ArrayList of Showtime objects.
	 * 
	 * @param s Showtime object to be inserted into ArrayList.
	 */
	public void addShowtime(Showtime s) {
		showtimeArr.add(s);
	}

	/**
	 * Constructor for Movie object
	 * 
	 * @param name          Title of movie
	 * @param showingStatus Showing status of movie. Can be "Coming Soon, Preview,
	 *                      Now Showing, End of Showing.
	 * @param synopsis      ArrayList<String> of names of cast members
	 * @param cast          ArrayList<String> of names of cast members
	 * @param director      Name of director for the movie
	 * @param type          Type or genre of movie. Can be "Action, Horror, Romance,
	 *                      Animated"
	 * @param movieRating   Rating of movie. Can be "G, PG, PG13, NC16, M18, R21".
	 */
	public Movie(String name, String showingStatus, String synopsis, ArrayList<String> cast, String director,
			String type, String movieRating) {
		this.movieID = movie_counter++;
		this.name = name;
		this.showingStatus = showingStatus;
		this.synopsis = synopsis;
		this.cast = cast;
		this.director = director;
		this.type = type;
		this.movieRating = movieRating;

	}

	/**
	 * Gets synopsis of movie
	 * 
	 * @return synopsis of movie
	 */
	public String getSynopsis() {
		return synopsis;
	}

	/**
	 * Changes synopsis of movie
	 * 
	 * @param synopsis of movie
	 */
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	/**
	 * Changes showing status of movie. Can be "Coming Soon, Preview, Now Showing,
	 * End of Showing.
	 * 
	 * @param showingStatus Showing status of movie. Can be "Coming Soon, Preview,
	 *                      Now Showing, End of Showing.
	 */
	public void setShowingStatus(String showingStatus) {
		this.showingStatus = showingStatus;
	}

	/**
	 * Changes showing status of movie. Can be "Coming Soon, Preview, Now Showing,
	 * End of Showing.
	 * 
	 * @return Showing Status
	 */
	public int getMovieID() {
		return this.movieID;
	}

	/**
	 * Changes Movie ID
	 * 
	 * @param aMovieID Unique Movie ID
	 */
	public void setMovieID(int aMovieID) {
		this.movieID = aMovieID;
	}

	/**
	 * Gets title of movie.
	 * 
	 * @return Title of movie
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Changes title of movie.
	 * 
	 * @param aName Title of movie
	 */
	public void setName(String aName) {
		this.name = aName;
	}

	/**
	 * Gets showing status of movie.
	 * 
	 * @return showing status of movie.
	 */
	public String getShowingStatus() {
		return this.showingStatus;
	}

	/**
	 * Gets type/genre of movie.
	 * 
	 * @return Type/genre of movie
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Sets type/genre of movie. Can be "Action, Horror, Romance, Animated".
	 * 
	 * @param a Type/genre of movie. Can be "Action, Horror, Romance, Animated"
	 */
	public void setType(String aType) {
		this.type = aType;
	}

	/**
	 * Gets ticket sales for the movie.
	 * 
	 * @return Ticket sales for the movie.
	 */
	public int getTicketSales() {
		return this.ticketSales;
	}

	/**
	 * Changes ticket sales.
	 * 
	 * @param aTicketSales Ticket Sales
	 */
	public void setTicketSales(int aTicketSales) {
		this.ticketSales = aTicketSales;
	}

	/**
	 * Gets ArrayList<String> of cast list.
	 * 
	 * @return ArrayList<String> of cast list
	 */
	public ArrayList<String> getCast() {
		return this.cast;
	}

	/**
	 * Changes ArrayList<String> of cast list.
	 * 
	 * @param aCast ArrayList<String> of cast list
	 */
	public void setCast(ArrayList<String> aCast) {
		this.cast = aCast;
	}

	/**
	 * Gets name of director of movie.
	 * 
	 * @return Name of director of movie.
	 */
	public String getDirector() {
		return this.director;
	}

	/**
	 * Changes name of director of movie.
	 * 
	 * @param aDirector Name of director of movie
	 */
	public void setDirector(String aDirector) {
		this.director = aDirector;
	}

	/**
	 * Gets ArrayList of Review objects under this movie.
	 * 
	 * @return ArrayList of Reviews under this movie
	 */
	public ArrayList<Review> getReviewArr() {
		return this.reviewArr;
	}

	/**
	 * Sets ArrayList of Review objects under this movie.
	 * 
	 * @param aReviewArr ArrayList of Review objects under this movie
	 */
	public void setReviewArr(ArrayList<Review> aReviewArr) {
		this.reviewArr = aReviewArr;
	}

	/**
	 * Gets ArrayList of Showtime objects under this movie.
	 * 
	 * @return ArrayList of Showtime objects under this movie
	 */
	public ArrayList<Showtime> getShowtimeArr() {
		return this.showtimeArr;
	}

	/**
	 * Changes ArrayList of Showtime objects under this movie.
	 * 
	 * @param aShowtimeArr ArrayList of Showtime objects under this movie
	 */
	public void setShowtimeArr(ArrayList<Showtime> aShowtimeArr) {
		this.showtimeArr = aShowtimeArr;
	}

	/**
	 * Calculates overall average user rating from all ratings in the reviews for
	 * this movie.
	 * 
	 * @return String of overall average user rating
	 */
	public String getOverallUserRating() {
		if (reviewArr.isEmpty())
			return this.overallUserRating;
		else {
			double avg = 0;
			for (int i = 0; i < reviewArr.size(); i++) {
				avg += (reviewArr.get(i).getRating());
			}
			avg /= reviewArr.size();
			this.overallUserRating = Double.toString(avg);
			return String.valueOf(avg);
		}

	}

	/**
	 * Calculates overall average user rating from all ratings in the reviews for
	 * this movie.
	 * 
	 * @return Double of overall average user rating
	 */
	public double getOverallUserRatingInDouble() {
		if (reviewArr.isEmpty())
			return 0;
		else {
			double avg = 0;
			for (int i = 0; i < reviewArr.size(); i++) {
				avg += (reviewArr.get(i).getRating());
			}
			avg /= reviewArr.size();
			this.overallUserRating = Double.toString(avg);
			return avg;
		}
	}

	/**
	 * Changes overall user rating.
	 * 
	 * @param anOverallRating Overall user rating.
	 */
	public void setOverallUserRating(String anOverallRating) {
		this.overallUserRating = anOverallRating;
	}

	/**
	 * Gets movie rating. Can be "G, PG, PG13, NC16, M18, R21".
	 * 
	 * @return Movie rating
	 */
	public String getMovieRating() {
		return this.movieRating;
	}

	/**
	 * Changes movie rating. Can be "G, PG, PG13, NC16, M18, R21".
	 * 
	 * @param aMovieRating Movie Rating. Can be "G, PG, PG13, NC16, M18, R21".
	 */
	public void setMovieRating(String aMovieRating) {
		this.movieRating = aMovieRating;
	}

	/**
	 * Gets an ArrayList<String> of review IDs.
	 * 
	 * @return ArrayList<String> of review IDs
	 */
	public ArrayList<String> getReviewIDs() {
		ArrayList<String> reviewIDs = new ArrayList<String>();
		for (int i = 0; i < reviewArr.size(); i++) {
			reviewIDs.add(Integer.toString(reviewArr.get(i).getReviewID()));
		}
		return reviewIDs;
	}

	/**
	 * Gets an ArrayList<String> of showtime IDs.
	 * 
	 * @return ArrayList<String> of showtime IDs
	 */
	public ArrayList<String> getShowtimeIDs() {
		ArrayList<String> showtimeIDs = new ArrayList<String>();
		for (int i = 0; i < showtimeArr.size(); i++) {
			showtimeIDs.add(Integer.toString(showtimeArr.get(i).getShowtimeID()));
		}
		return showtimeIDs;

	}

	/**
	 * Increments ticket sales by 1.
	 */
	public void increaseTicketSalesByOne() {
		ticketSales += 1;
	}
}