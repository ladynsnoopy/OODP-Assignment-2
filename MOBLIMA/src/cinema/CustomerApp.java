package cinema;

import java.util.ArrayList;


// every time you create a showtime, insert it into arraylist in java 
public class CustomerApp {
	
	public static void createCustomer(String name, String mobileNum, String email) {
		Customer a = new Customer(name, mobileNum, email);
		CustomerToCSV.addCustomerToCSV(a);
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
	//TODO buyticket
	public int static buyTicket(int showtimeID, int x, int y)
	{
	
		ArrayList<String[]> occupied = csvRW.searchMultipleRow("seatingplandatabase", "ShowtimeID", Integer.toString(showtimeID));
		String target = Integer.toString(x) + ","+Integer.toString(y);
		for(int k = 0;k<occupied.size();k++)
		{
			if(occupied.get(k)[1].equals(target))
				return -1; // cannot buy this ticket because its occupied already
		}
		// if seat is available for customer to buy, make the change to the seatingplan database
		ArrayList<String> new_occupied = new ArrayList<String>;
		new_occupied.add(Integer.toString(showtimeID));
		new_occupied.add(target);
		csvRW.writeToCSV("seatingplandatabase", new_occupied);
		return 1; // purchase is succesful

		
	}
	
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

