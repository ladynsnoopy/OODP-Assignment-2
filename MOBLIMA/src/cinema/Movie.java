package cinema;

import java.util.ArrayList;

public class Movie {
	private int movieID;
	private String name;
	private String showingStatus;
	private ArrayList<String> cast;
	private ArrayList<String> director;
	private String type;
	private ArrayList<Review> reviewArr = new ArrayList<Review>();
	private ArrayList<Showtime> showtimeArr = new ArrayList<Showtime>();
	private String overallUserRating = "NA";
	private String movieRating;
	private int ticketSales;

	public void addReview(Review r) {
		reviewArr.add(r);
	}
	public void addShowtime(Showtime s) {
		showtimeArr.add(s);
	}

	public Movie(int movieID, String name, String showingStatus, ArrayList<String> cast, ArrayList<String> director,
			String type, ArrayList<Review> reviewArr, ArrayList<Showtime> showtimeArr, String overallUserRating,
			String movieRating, int ticketSales) {
		this.movieID = movieID;
		this.name = name;
		this.showingStatus = showingStatus;
		this.cast = cast;
		this.director = director;
		this.type = type;
		this.reviewArr = reviewArr;
		this.showtimeArr = showtimeArr;
		this.overallUserRating = overallUserRating;
		this.movieRating = movieRating;
		this.ticketSales = ticketSales;

	}

	public int getMovieID() {
		return this.movieID;
	}

	public void setMovieID(int aMovieID) {
		this.movieID = aMovieID;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String aName) {
		this.name = aName;
	}

	public String getShowingStatus() {
		return this.showingStatus;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String aType) {
		this.type = aType;
	}

	public int getTicketSales() {
		return this.ticketSales;
	}

	public void setTicketSales(int aTicketSales) {
		this.ticketSales = aTicketSales;
	}

	public ArrayList<String> getCast() {
		return this.cast;
	}

	public void setCast(ArrayList<String> aCast) {
		this.cast = aCast;
	}

	public ArrayList<String> getDirector() {
		return this.director;
	}

	public void setDirector(ArrayList<String> aDirector) {
		this.director = aDirector;
	}

	public ArrayList<Review> getReviewArr() {
		return this.reviewArr;
	}

	public void setReviewArr(ArrayList<Review> aReviewArr) {
		this.reviewArr = aReviewArr;
	}

	public ArrayList<Showtime> getShowtimeArr() {
		return this.showtimeArr;
	}

	public void setShowtimeArr(ArrayList<Showtime> aShowtimeArr) {
		this.showtimeArr = aShowtimeArr;
	}

	public String getOverallUserRating() {
		return this.overallUserRating;
	}

	public void setOverallUserRating(String aOverallUserRating) {
		this.overallUserRating = aOverallUserRating;
	}

	public String getMovieRating() {
		return this.movieRating;
	}

	public void setMovieRating(String aMovieRating) {
		this.movieRating = aMovieRating;
	}
}