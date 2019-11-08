package cinema;

import java.util.ArrayList;


// every time you create a showtime, insert it into arraylist in java 
public class CustomerApp {
	
	public static void createCustomer(String name, String mobileNum, String email) {
		Customer a = new Customer(name, mobileNum, email);
		CustomerToCSV.addCustomerToCSV(a);
	}

	public static int customerExists(String email) {
		if (csvRW.search("customerdatabase", "Email", email) == null)
			return -1;
		return 1;
	}
	
	// returns a string array of movies
	public static String[] searchMovies() {
		ArrayList<String[]> list = csvRW.readCSV("moviedatabase");
		String[] movies = new String[list.size()];
		int num = 0;
		for (int i = 0; i < list.size(); i++) {
			movies[num] = list.get(i)[1];
			num++;
		}
		return movies;
	}
	// returns a string array of timings for a particular movie
	public static String[] getShowtimesForMovie(int movieID)
	{
		ArrayList <String> result = csvRW.search("moviedatabase", "MovieID",Integer.toString(movieID));
		String a = result.get(result.size()-2); // Get all the showtimeID of the particular movie
		String[] arr = a.split(","); // store all the showtimeID in a string array
		String[] showtimes = new String[arr.length];
		for(int i = 0; i<arr.length;i++)
		{
			ArrayList<String> b = csvRW.search("showtimedatabase", "ShowtimeID",arr[i]); 
			showtimes[i] = b.get(b.size()-1); // get timing for each showtimeID and store it into showtimes array
		}
		return showtimes;
		
	
		
		
		
	}
//	public static buyTicket(int showtimeID, int x, int y)
//	{
//		//TODO buyticket
//	}
	
	// returns one array list of all the bookingHistory  
	public static ArrayList<String> searchBookingHistory(int custID)
	{
	
		ArrayList<String> tids = csvRW.search("customerdatabase", "CustomerID",Integer.toString(custID)); 
		String a = tids.get(tids.size()-1); // Get all the receipt's TID of the customer 
		String[] arr = a.split(",");  // store the TIDs in a string array
		ArrayList<String> finallist = new ArrayList<String>();
		for(int i = 0;i<arr.length;i++)
		{
			ArrayList<String> b = csvRW.search("paymentdatabase", "TID",arr[i]);
			finallist.addAll(b); 
		}
		return finallist;
		
	}
	public static void addReview(int rating, String comment, String userID, String movie_name)
	{
		
		Review a = new Review(rating,comment,userID);
		ReviewToCSV.addReviewToCSV(a);
		ArrayList<String> movie_row = csvRW.search("moviedatabase", "Name", movie_name);
		String id = movie_row.get(0);
		String reviews = movie_row.get(9);
		if(reviews.equals(""))
		{
			csvRW.editCSV("moviedatabase",id,"ReviewID",Integer.toString(a.getReviewID()));
			
		}
		else
		{
			String[] arr = reviews.split(",");
			String b = "";
			for(int i = 0; i<arr.length;i++)
			{
				b += arr[i]+",";
			}
			b += Integer.toString(a.getReviewID());
			csvRW.editCSV("moviedatabase",id,"ReviewID",b);
			
		}
			
			
	}
	
	//TODO view sorted top 5

}

