package cinema;

import java.util.ArrayList;

public class StaffApp {
	public static void createStaff(String username, String password) {
		Staff a = new Staff(username, password);
		StaffToCSV.addStaffToCSV(a);
	}

	public static int login(String username, String password) {
		ArrayList<String[]> list = csvRW.readCSV("staffdatabase");
		for(int i=0;i<list.size();i++) {
			if(list.get(i)[0].equals(username)) {
				if(list.get(i)[1].equals(password)) {
					return 0;
				}
				else
					return -1;
			}
		}
		return -2; //if no such username exists
	}
	
	public static void createMovie(String name, String showingStatus, String synopsis, ArrayList<String> cast, ArrayList<String> director, String type, String movieRating) {
		Movie a = new Movie(name, showingStatus, synopsis, cast, director, type, movieRating);
		MovieToCSV.addMovieToCSV(a);
	}
	
	//1:title 2:type 3:status 4:synopsis 5:rating 6:director 7:cast 8:showtime shit
	//boundary class asks for which to change, if 1-5 use this function
	public static void editMovieStringDetails(int selection, String change) {
		
	}
	
}
