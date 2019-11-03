package cinema;

import java.util.ArrayList;
import java.util.List;

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
		ArrayList<String> addstuff = new ArrayList<String>();
		addstuff.add("gv019");
		addstuff.add("hahaha,lol help,yeeeeeee");
		csvRW.writeToCSV("staffdatabase", addstuff);
////	
//	//delete example
//	csvRW.delete("staffdatabase", 6);
//		csvRW.editCSV("staffdatabase", 3, 1, "yeehaw");
	}
}
