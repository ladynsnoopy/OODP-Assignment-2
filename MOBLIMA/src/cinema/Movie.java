package cinema;

import java.util.ArrayList;

/**
 * 
 * Movie object that contains movie details. Also contains
 * <code>ArrayList</code> of <code>Review</code> objects for the movie, and an
 * <code>ArrayList</code> of <code>Showtime</code> objects for this movie. Also
 * contains average ratings left by reviewers.
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
	 * <code>Static</code> counter that will increment every time a new movie object
	 * is created.
	 */
	private static int movie_counter = 1;
	/**
	 * Title of movie
	 */
	private String name;
	/**
	 * Showing status of movie. Can be
	 * <code>Coming Soon, Preview, Now Showing, End of
	 * Showing</code>.
	 */
	private String showingStatus;
	/**
	 * Synopsis of movie
	 */
	private String synopsis;
	/**
	 * <code>ArrayList</code> of names of cast members
	 */
	private ArrayList cast;
	/*
	 * Name of director for the movie
	 */
	private String director;
	/**
	 * Type or genre of movie. Can be <code>Action, Horror, Romance, Animated</code>
	 */
	private String type;
	/**
	 * <code>ArrayList</code> of <code>Review</code> objects for this movie called
	 * <code>reviewArr</code>
	 * 
	 * @see Review
	 */
	private ArrayList<Review> reviewArr = new ArrayList<Review>();
	/**
	 * <code>ArrayList</code> of <code>Showtime</code> objects for this movie called
	 * <code>showtimeArr</code>
	 * 
	 * @see Showtime
	 */
	private ArrayList<Showtime> showtimeArr = new ArrayList<Showtime>();
	/**
	 * Average rating of movie left by users, stored in <code>String</code> format.
	 * Defaults to <code>NA</code> when no review has been left.
	 */
	private String overallUserRating = "NA";
	/**
	 * Rating of movie. Can be <code>G, PG, PG13, NC16, M18, R21</code>. Default is
	 * <code>NA</code>.
	 */
	private String movieRating;
	/**
	 * Ticket sales for this movie. If no sales, default is <code>int 0</code>.
	 */
	private int ticketSales = 0;

	/**
	 * Adds a <code>Review</code> to the <code>ArrayList</code> of
	 * <code>Review</code> objects.
	 * 
	 * @param r <code>Review</code> object to be inserted into
	 *          <code>ArrayList</code>
	 * @see Review
	 */
	public void addReview(Review r) {
		reviewArr.add(r);
	}

	/**
	 * Adds a <code>Showtime</code> to the <code>ArrayList</code> of
	 * <code>Showtime</code> objects.
	 * 
	 * @param s <code>Showtime</code> object to be inserted into
	 *          <code>ArrayList</code>.
	 * @see Showtime
	 */
	public void addShowtime(Showtime s) {
		showtimeArr.add(s);
	}

	/**
	 * Constructor for Movie object
	 * 
	 * @param name          Title of movie
	 * @param showingStatus Showing status of movie. Can be
	 *                      <code>Coming Soon, Preview,
	 *                      Now Showing, End of Showing</code>.
	 * @param synopsis      <code>ArrayList</code> of names of cast members
	 * @param cast          <code>ArrayList</code> of names of cast members
	 * @param director      Name of director for the movie
	 * @param type          Type or genre of movie. Can be
	 *                      <code>Action, Horror, Romance,
	 *                      Animated</code>
	 * @param movieRating   Rating of movie. Can be
	 *                      <code>G, PG, PG13, NC16, M18, R21</code>.
	 */
	public Movie(String name, String showingStatus, String synopsis, ArrayList cast, String director,
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
	 * Changes showing status of movie. Can be
	 * <code>Coming Soon, Preview, Now Showing,
	 * End of Showing</code>.
	 * 
	 * @param showingStatus Showing status of movie. Can be
	 *                      <code>Coming Soon, Preview,
	 *                      Now Showing, End of Showing</code>.
	 */
	public void setShowingStatus(String showingStatus) {
		this.showingStatus = showingStatus;
	}

	/**
	 * Changes showing status of movie. Can be
	 * <code>Coming Soon, Preview, Now Showing,
	 * End of Showing</code>.
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
	 * Sets type/genre of movie. Can be
	 * <code>Action, Horror, Romance, Animated</code>.
	 * 
	 * @param aType Type/genre of movie. Can be
	 *          <code>Action, Horror, Romance, Animated</code>
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
	 * Gets <code>ArrayList</code> of cast list.
	 * 
	 * @return <code>ArrayList</code> of cast list
	 */
	public ArrayList getCast() {
		return this.cast;
	}

	/**
	 * Changes <code>ArrayList</code> of cast list.
	 * 
	 * @param aCast <code>ArrayList</code> of cast list
	 */
	public void setCast(ArrayList aCast) {
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
	 * Gets <code>ArrayList</code> of <code>Review</code> objects under this movie.
	 * 
	 * @return <code>ArrayList</code> of <code>Reviews</code> under this movie
	 * @see Review
	 */
	public ArrayList<Review> getReviewArr() {
		return this.reviewArr;
	}

	/**
	 * Sets <code>ArrayList</code> of <code>Review</code> objects under this movie.
	 * 
	 * @param aReviewArr <code>ArrayList</code> of <code>Review</code> objects under
	 *                   this movie
	 * @see Review
	 */
	public void setReviewArr(ArrayList<Review> aReviewArr) {
		this.reviewArr = aReviewArr;
	}

	/**
	 * Gets <code>ArrayList</code> of <code>Showtime</code> objects under this
	 * movie.
	 * 
	 * @return <code>ArrayList</code> of <code>Showtime</code> objects under this
	 *         movie
	 * @see Showtime
	 */
	public ArrayList<Showtime> getShowtimeArr() {
		return this.showtimeArr;
	}

	/**
	 * Changes <code>ArrayList</code> of <code>Showtime</code> objects under this
	 * movie.
	 * 
	 * @param aShowtimeArr <code>ArrayList</code> of <code>Showtime</code> objects
	 *                     under this movie
	 * @see Showtime
	 */
	public void setShowtimeArr(ArrayList<Showtime> aShowtimeArr) {
		this.showtimeArr = aShowtimeArr;
	}

	/**
	 * Calculates overall average user rating from all ratings in the reviews for
	 * this movie.
	 * 
	 * @return <code>String</code> of overall average user rating
	 * @see Review#getRating()
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
	 * @return <code>Double</code> of overall average user rating
	 * @see Review#getRating()
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
	 * Gets movie rating. Can be <code>G, PG, PG13, NC16, M18, R21</code>.
	 * 
	 * @return Movie rating
	 */
	public String getMovieRating() {
		return this.movieRating;
	}

	/**
	 * Changes movie rating. Can be <code>G, PG, PG13, NC16, M18, R21</code>.
	 * 
	 * @param aMovieRating Movie Rating. Can be
	 *                     <code>G, PG, PG13, NC16, M18, R21</code>.
	 */
	public void setMovieRating(String aMovieRating) {
		this.movieRating = aMovieRating;
	}

	/**
	 * Gets an <code>ArrayList</code> of <code>Review</code> IDs.
	 * 
	 * @return <code>ArrayList</code> of <code>Review</code> IDs
	 * @see Review#getReviewID()
	 */
	public ArrayList getReviewIDs() {
		ArrayList reviewIDs = new ArrayList();
		for (int i = 0; i < reviewArr.size(); i++) {
			reviewIDs.add(Integer.toString(reviewArr.get(i).getReviewID()));
		}
		return reviewIDs;
	}

	/**
	 * Gets an <code>ArrayList</code> of <code>Showtime</code> IDs.
	 * 
	 * @return ArrayList of <code>Showtime</code> IDs
	 * @see Showtime#getShowtimeID()
	 */
	public ArrayList getShowtimeIDs() {
		ArrayList showtimeIDs = new ArrayList();
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

	/**
	 * Takes in <code>Movie</code> object and writes all attributes and data into
	 * moviedatabase. Utilizes csvRW.
	 * 
	 * @param movie customer <code>Movie</code> object to be written into database
	 * @see csvRW#writeToCSV(String, ArrayList)
	 */
	public static void addMovieToCSV(Movie movie) {
		ArrayList<String> data = new ArrayList<String>();
		data.add(Integer.toString(movie.getMovieID()));
		data.add(movie.getName());
		data.add(movie.getType());
		data.add(movie.getShowingStatus());
		data.add(movie.getSynopsis());
		data.add(movie.getDirector());
		String castData = movie.getCast().toString();
		castData = castData.substring(1, castData.length() - 1);
		data.add(castData);
		data.add(movie.getOverallUserRating());
		data.add(Integer.toString(movie.getTicketSales()));
		String reviewData = movie.getReviewIDs().toString();
		reviewData = reviewData.substring(1, reviewData.length() - 1);
		data.add(reviewData);
		String showtimeData = movie.getShowtimeIDs().toString();
		showtimeData = showtimeData.substring(1, showtimeData.length() - 1);
		data.add(showtimeData);
		data.add(movie.getMovieRating());
		csvRW.writeToCSV("moviedatabase", data);
	}

}