package cinema;

import java.util.ArrayList;

public class StaffToCSV {
	public static void addStaffToCSV(Staff staff) {
		ArrayList<String> data = new ArrayList<String>();
		data.add(staff.getUsername());
		data.add(staff.getPassword());
		csvRW.writeToCSV("staffdatabase", data);
	}
}
