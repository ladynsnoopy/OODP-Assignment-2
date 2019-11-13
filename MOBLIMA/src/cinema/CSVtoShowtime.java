package cinema;

import java.util.ArrayList;

public class CSVtoShowtime {
	public static ArrayList<Showtime> csvToShowtimeObject() {
		ArrayList<String[]> db = csvRW.readCSV("showtimedatabase");
		ArrayList<Showtime> ShowtimeObjArr = new ArrayList<Showtime>();

		for (int i = 1; i < db.size(); i++) {
			String[] element = db.get(i);
			int showtimeID = Integer.parseInt(element[0]);
			String cinema = element[1];
			String timing = element[2];
			int k=0;
			for (int j = 0; j < StaffApp.cinemaArr.size(); j++) {
				if (StaffApp.cinemaArr.get(j).getCinemaID().contains(cinema)) {
					k=j;
					break;
				}
			}
			Showtime o = new Showtime(StaffApp.cinemaArr.get(k), timing);
			o.setShowtimeID(showtimeID);
			
			ShowtimeObjArr.add(o);

		}
		return ShowtimeObjArr;
	}

}
