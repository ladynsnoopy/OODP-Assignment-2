package cinema;

import java.util.ArrayList;

public class ShowtimeToCSV {
	public static void addShowtimeToCSV(Showtime showtime) {
		ArrayList<String> data = new ArrayList<String>();
		data.add(Integer.toString(showtime.getShowtimeID()));
		data.add(showtime.getCinema().getCinemaID());
		data.add(showtime.getTiming());
		csvRW.writeToCSV("showtimedatabase", data);
	
	}
}
