package cinema;


import java.util.*;

public class csvTester {
	public static void main(String[] args) {
		// read data test
		// returns an array of string array
		// List<String[]> csvData = new ArrayList<String[]>();
		// csvData = csvRW.readCSV("staffdatabase");
		// example of going thru data-change the string to int
		// int i = Integer.parseInt(csvData.get(0)[0]);
		// System.out.println(i);
		// more example to just print all the data
//	for (int j=0; j<csvData.size();j++) {
//		System.out.println(csvData.get(j)[0]);
//	}

		// search example to find the row data is in
		// i can change this to return the whole row instead
		// search returns -1 if data not there
		// int a = csvRW.search("staffdatabase", "gv003");
		// System.out.println(a);

//	//adding example
//		ArrayList<String> addstuff = new ArrayList<String>();
//		addstuff.add("gv008");
//		addstuff.add("oh no, we are so bad, at this");
//		csvRW.writeToCSV("staffdatabase", addstuff);
		
//		ArrayList<String> castlist = new ArrayList<String>();
//		castlist.add("Michael Johnson");
//		castlist.add("Jane Doe");
//		ArrayList<String> directorlist = new ArrayList<String>();
//		directorlist.add("Michael Bay");
//		Review testreview = new Review(4,"Hello it's me","How have you been");
//		ArrayList<Review> review = new ArrayList<Review>();
//		review.add(testreview);
//		ArrayList<Showtime> showtimelist = new ArrayList<Showtime>();
//		Cineplex cine = new Cineplex("NTU");
//		Cinema Ctest = new Cinema("normal",10,10,cine);
//		Showtime test = new Showtime(Ctest,"7pm Sunday");
//		showtimelist.add(test);
//		Movie testermovie = new Movie("Test Movie","Showing","In which a movie is tested",castlist,directorlist,"Action",review,showtimelist,"PG13",0);
//		MovieToCSV a = new MovieToCSV();
//		a.addMovieToCSV(testermovie);
		
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter movie name to edit: ");
//		String mv_name = sc.next();
		ArrayList<String> result = csvRW.search("moviedatabase", "Movie ID", "0");
		System.out.println(result);
		
////	
//	//delete example
//	csvRW.delete("staffdatabase", 6);
//		csvRW.editCSV("staffdatabase", 3, 1, "yeehaw");
	}
}
