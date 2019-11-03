package cinema;


import java.util.*;

public class csvTester {
	public static void main(String[] args) {


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
		String mv_name = sc.next();
		ArrayList<String> result = csvRW.search("moviedatabase", "Title", mv_name);
		String id = result.get(0);
		
		System.out.println("Movie details are:");
		for(int i=0; i <result.size();i++) {
			System.out.println(result.get(i));
		}
		
		System.out.println("Enter column name to edit:");
		String col_name = sc.next();
		System.out.println("Enter new data to be inserted:");
		String new_data = sc.next();
		
		csvRW.editCSV("moviedatabase", id , col_name , new_data);
		
		
		

//		
////	
//	//delete example
//	csvRW.delete("staffdatabase", 6);
//		csvRW.editCSV("staffdatabase", 3, 1, "yeehaw");
	}
}
