package cinema;

import java.util.ArrayList;
import java.util.Arrays;

public class CSVtoMovie {
	public static void csvToMovieObject() {
        ArrayList<String[]> db = csvRW.readCSV("moviedatabase");

        for (int i=0; i < db.size(); i++) {
            int movieID = Integer.parseInt(db.get(i)[0]); // SET
            String name = db.get(i)[1];
            String showingStatus = db.get(i)[3];
            String synopsis = db.get(i)[4];
            ArrayList<String> cast = new ArrayList<String>(Arrays.asList(db.get(i)[6].split(",")));
            String director = db.get(i)[5];
            String type = db.get(i)[2];
            ArrayList<Review> reviewArr = new ArrayList<Review>(); // NULL
            ArrayList<Showtime> showtimeArr = new ArrayList<Showtime>(); // NULL
            String overallUserRating = db.get(i)[7]; // SET
            String movieRating = db.get(i)[11];
            int ticketSales = Integer.parseInt(db.get(i)[8]); // SET

            Movie o = new Movie(name, showingStatus, synopsis, cast, director, type, movieRating);
                o.setMovieID(movieID);
                o.setOverallUserRating(overallUserRating);
                o.setTicketSales(ticketSales);
		}
	}
}
