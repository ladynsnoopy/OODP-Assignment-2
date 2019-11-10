package cinema;

import java.util.ArrayList;

public class Staff {
	private String username;
	private String password;

	public Staff(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void addStaffToCSV(Staff staff) {
		ArrayList<String> data = new ArrayList<String>();
		data.add(staff.username);
		data.add(staff.password);
		csvRW.writeToCSV("staffdatabase", data);
	}
}
