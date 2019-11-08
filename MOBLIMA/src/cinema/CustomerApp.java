package cinema;

import java.util.ArrayList;


// every time you create a showtime, insert it into arraylist in java 
public class CustomerApp {
	
	public static void createCustomer(String name, String mobileNum, String email) {
		Customer a = new Customer(name, mobileNum, email);
		CustomerToCSV.addCustomerToCSV(a);
	}
    // returns customerID if it exists
	public static int customerExists(String email) {
		if (csvRW.search("customerdatabase", "Email", email) == null)
			return -1;
		else
		{
			return Integer.parseInt(csvRW.search("customerdatabase", "Email", email).get(0));
		}
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
	// link to Movie class
	// returns a string array of timings for a particular movie
	public static String[][] getShowtimesForMovie(int movieID)
	{
		ArrayList <String> result = csvRW.search("moviedatabase", "MovieID",Integer.toString(movieID));
		String a = result.get(10); // Get all the showtimeID of the particular movie
		String cut = a.substring(1,a.length()-1); // cut away the ""
		String[] arr = cut.split(","); // store all the showtimeID in a string array
		String[][] showtimes = new String[arr.length][];
		String[] inside = new String[2];
		for(int i = 0; i<arr.length;i++)
		{
			ArrayList<String> b = csvRW.search("showtimedatabase", "ShowtimeID",arr[i]); 
			inside[0] = b.get(1);
			inside[1] = b.get(b.size()-1);
			showtimes[i] = inside;// get timing for each showtimeID and store it into showtimes array
		}
		return showtimes;
		
	
		
		
		
	}
	public static int searchOneMovie(String name)
	{
		ArrayList <String> result = csvRW.search("moviedatabase", "Name", name);
		if(result != null)
			return Integer.parseInt(result.get(0)); // returns movieID
		else 
			return -1;
	}
	//TODO buyticket
	public static int buyTicket(int showtimeID, int x, int y)
	{
	
		ArrayList<String[]> occupied = csvRW.searchMultipleRow("seatingplandatabase", "ShowtimeID", Integer.toString(showtimeID));
		boolean dontsearch = false;
		if(occupied == null)
			dontsearch = true;
		String target = Integer.toString(x) + ","+Integer.toString(y);
		if(dontsearch == false)
		{
			for(int k = 0;k<occupied.size();k++)
			{
				if(occupied.get(k)[1].equals(target))
					return -1; // cannot buy this ticket because its occupied already
			}
		}
		
		// if seat is available for customer to buy, make the change to the seatingplan database
		ArrayList<String> new_occupied = new ArrayList<String>;
		new_occupied.add(Integer.toString(showtimeID));
		new_occupied.add(target);
		csvRW.writeToCSV("seatingplandatabase", new_occupied);
		return 1; // purchase is successful

		
	}

	
	// returns one 2D array of all the bookingHistory  
	public static String[][] searchBookingHistory(int custID)
	{
	
		ArrayList<String> tids = csvRW.search("customerdatabase", "CustomerID",Integer.toString(custID)); 
		String a = tids.get(4); // Get all the receipt's TID of the customer 
		String cut = a.substring(1,a.length()-1); // cut away the ""
		String[] arr = cut.split(",");  // store the TIDs in a string array
		String[][] main = new String[arr.length][];
		for(int i = 0;i<arr.length;i++)
		{
			ArrayList<String> b = csvRW.search("paymentdatabase", "TID",arr[i]);
			String [] stockArr = new String[b.size()];
			for(int k = 0; k<b.size();k++)
			{
				stockArr[k] = b.get(k);
			}
			main[i] = stockArr;
		}
		return main;
		
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

