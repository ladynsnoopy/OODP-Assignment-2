package cinema;

import java.util.ArrayList;

public class Movie {
	private int movieID;
	private static int movie_counter = 1;
	private String name;
	private String showingStatus;
	private String synopsis;
	private ArrayList<String> cast;
	private String director;
	private String type;
	private ArrayList<Review> reviewArr = new ArrayList<Review>();
	private ArrayList<Showtime> showtimeArr = new ArrayList<Showtime>();
	private String overallUserRating = "NA";
	private String movieRating;
	private int ticketSales=0;

	public void addReview(Review r) {
		reviewArr.add(r);
	}

	public void addShowtime(Showtime s) {
		showtimeArr.add(s);
	}


	public Movie(String name, String showingStatus, String synopsis, ArrayList<String> cast, String director, String type,String movieRating) {
		this.movieID = movie_counter++;
		this.name = name;
		this.showingStatus = showingStatus;
		this.synopsis = synopsis;
		this.cast = cast;
		this.director = director;
		this.type = type;
		this.movieRating = movieRating;

	}
	
	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public void setShowingStatus(String showingStatus) {
		this.showingStatus = showingStatus;
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

	public String getDirector() {
		return this.director;
	}

	public void setDirector(String aDirector) {
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
		if(reviewArr.isEmpty())
			return this.overallUserRating;
		else {
			double avg=0;
			for (int i=0;i<reviewArr.size();i++) {
				avg += (reviewArr.get(i).getRating());				
			}
			avg /= reviewArr.size();
			this.overallUserRating = Double.toString(avg);
			return String.valueOf(avg);
		}
			
	}

	public double getOverallUserRatingInDouble() {
		if(reviewArr.isEmpty())
			return 0;
		else {
			double avg=0;
			for (int i=0;i<reviewArr.size();i++) {
				avg += (reviewArr.get(i).getRating());				
			}
			avg /= reviewArr.size();
			this.overallUserRating = Double.toString(avg);
			return avg;
		}	
	}

	public void setOverallUserRating(String anOverallRating) {
		this.overallUserRating = anOverallRating;
	}

	public String getMovieRating() {
		return this.movieRating;
	}

	public void setMovieRating(String aMovieRating) {
		this.movieRating = aMovieRating;
	}
	public ArrayList<String> getReviewIDs() {
		ArrayList<String> reviewIDs = new ArrayList<String>();
		for(int i=0;i<reviewArr.size();i++) {
			reviewIDs.add(Integer.toString(reviewArr.get(i).getReviewID()));
		}
		return reviewIDs;
	}
	public ArrayList<String> getShowtimeIDs() {
		ArrayList<String> showtimeIDs = new ArrayList<String>();
		for(int i=0; i<showtimeArr.size();i++) {
			showtimeIDs.add(Integer.toString(showtimeArr.get(i).getShowtimeID()));
		}
		return showtimeIDs;

	}
	public void increaseTicketSalesByOne()
	{
		ticketSales += 1;
	}
}