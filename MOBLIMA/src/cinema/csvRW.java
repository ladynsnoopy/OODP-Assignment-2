package cinema;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Contains methods that handles read and write to CSV.
 * 
 * @author Lim Wai Leong
 * @version 1.0
 * @since 2019-11-09
 *
 */
public class csvRW {

	// Search for a specific row in database
	// Takes the column name eg "Title" and target string "Lego Movie"
	// Returns the entire row of details
	/**
	 * Searches for a specific row in database. Takes the column name eg "Title" and
	 * target string "Lego Movie". Returns the entire row of details.
	 * 
	 * @param dbname  Name of the database to be accessed.
	 * @param colname Name of the column to be searched.
	 * @param target  Target string to be found
	 * @return Entire row of details in <code>ArrayList</code> format. If search
	 *         finds nothing, returns <code>null</code>.
	 */
	public static ArrayList<String> search(String dbname, String colname, String target) {
		String path = "src\\cinema\\resources\\" + dbname + ".csv\\";
		BufferedReader in;
		// int count = 0; // no need a count variable can use size()
		try {
			in = new BufferedReader(new FileReader(path));
			String row;
			ArrayList<String[]> csvData = new ArrayList<String[]>();

			while ((row = in.readLine()) != null) {
				String[] rowData = row.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
				csvData.add(rowData);
			}
			in.close();
			int targetcol = 0;
			for (int j = 0; j < csvData.get(0).length; j++) {
				if (csvData.get(0)[j].equals(colname)) {
					targetcol = j;
					break;
				}
			}
			for (int i = 0; i < csvData.size(); i++) {
				if (csvData.get(i)[targetcol].equals(target)) {
					ArrayList<String> result = new ArrayList<String>(Arrays.asList(csvData.get(i)));
					return result;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Search for a specific row in database
	// Takes the column name eg "Title" and target string "Lego Movie"
	// Returns the every row that matches the result
	/**
	 * Searches for a specific row in database. Takes the column name eg "Title" and
	 * target string "Lego Movie". Returns the every row that matches the result
	 * 
	 * @param dbname  Target database name
	 * @param colname Target column name
	 * @param target  Target search keyword
	 * @return Every row that matches the result in the format
	 *         <code>ArrayList</code> of <code>String[]</code>. If no result can be
	 *         found, returns <code>null</code>.
	 * 
	 */
	public static ArrayList<String[]> searchMultipleRow(String dbname, String colname, String target) {
		String path = "src\\cinema\\resources\\" + dbname + ".csv\\";
		BufferedReader in;
		// int count = 0; // no need a count variable can use size()
		try {
			in = new BufferedReader(new FileReader(path));
			String row;
			ArrayList<String[]> csvData = new ArrayList<String[]>();

			while ((row = in.readLine()) != null) {
				String[] rowData = row.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
				// count++;
				csvData.add(rowData);
			}
			in.close();
			int targetcol = 0;
			for (int j = 0; j < csvData.get(0).length; j++) {
				if (csvData.get(0)[j].equals(colname)) {
					targetcol = j;
					break;
				}
			}
			ArrayList<String[]> result = new ArrayList<String[]>();
			for (int i = 0; i < csvData.size(); i++) {
				if (csvData.get(i)[targetcol].equals(target)) {
					result.add(csvData.get(i));
				}
			}
			return result;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Deletes row in database.
	/**
	 * Deletes selected row in the database.
	 * 
	 * @param dbname    Name of database to be changed.
	 * @param targetRow Index of targeted row to be deleted.
	 * 
	 */
	public static void delete(String dbname, int targetRow) {
		String path = "src\\cinema\\resources\\" + dbname + ".csv\\";
		try {
			BufferedReader in = new BufferedReader(new FileReader(path));
			StringBuffer sb = new StringBuffer("");
			int lineno = 0; // I changed here, should be zero
			String row;

			while ((row = in.readLine()) != null) {
				if (lineno != targetRow)
					sb.append(row + "\n");
				lineno++;
			}
			in.close();

			FileWriter fw = new FileWriter(new File(path));
			// Write entire string buffer into the file
			fw.write(sb.toString());
			fw.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Rewrites entire selected database.
	 * 
	 * @param dbname Name of database to be changed.
	 * @param data   Data to be added to database.
	 * 
	 */
	public static void rewrite(String dbname, ArrayList<String[]> data) {
		String path = "src\\cinema\\resources\\" + dbname + ".csv\\";
		try {
			for (int i = 0; i < data.size(); i++) {
				for (int j = 0; j < data.get(0).length; j++) {
					data.get(i)[j] = format(data.get(i)[j]);
				}
			}
			StringBuffer sb = new StringBuffer();
			FileWriter fw = new FileWriter(new File(path));
			for (int i = 0; i < data.size(); i++) {
				for (int j = 0; j < data.get(0).length; j++) {
					sb.append(data.get(i)[j]);
					sb.append(",");
				}
				sb.append("\n");
			}

			System.out.println(sb);
			// Write entire string buffer into the file
			fw.write(sb.toString());
			fw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// write data to bottom of csv file
	// takes in data as List<String>
	/**
	 * Takes in data as <code>List</code> of <code>String</code>. Then writes to the
	 * csv file at the bottom.
	 * 
	 * @param dbname Name of database to be changed.
	 * @param data   Data to be written to the database in <code>ArrayList</code> of
	 *               <code>String</code> format.
	 * 
	 */
	public static void writeToCSV(String dbname, ArrayList<String> data) {

		String path = "src\\cinema\\resources\\" + dbname + ".csv\\";
		String[] temp;
		for (int i = 0; i < data.size(); i++) {
			temp = data.get(i).split(",");
			if (temp.length > 1) {
				data.set(i, format(data.get(i)));
			}
		}
		try {
			FileWriter csvWriter = new FileWriter(path, true);
			csvWriter.append(String.join(",", data));
			csvWriter.append("\n");
			csvWriter.flush();
			csvWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Read database file based on name
	/**
	 * Reads selected database file and returns entire contents of file in
	 * <code>ArrayList</code> of <code>String[]</code> format.
	 * 
	 * @param dbname Name of database to be read.
	 * @return Entire contents of csv file in <code>ArrayList</code> of
	 *         <code>String[]</code> format.
	 * 
	 */
	public static ArrayList<String[]> readCSV(String dbname) {
		try {
			String path = "src\\cinema\\resources\\" + dbname + ".csv\\";
			BufferedReader in = new BufferedReader(new FileReader(path));
			String row;
			ArrayList<String[]> csvData = new ArrayList<String[]>();

			while ((row = in.readLine()) != null) {
				String[] rowData = row.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
				csvData.add(rowData);
			}
			in.close();
			return csvData;

		} catch (FileNotFoundException e) {
			System.out.println("File Error!" + e.getMessage());
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Edits only the selected attribute in the database.
	 * 
	 * @param dbname   Name of database to be changed.
	 * @param targetID Unique ID of the selected row.
	 * @param col_name Type of attribute to be changed.
	 * @param change   New attribute to be written in.
	 * 
	 */
	public static void editCSV(String dbname, String targetID, String col_name, String change) {
		String path = "src\\cinema\\resources\\" + dbname + ".csv\\";
		try {
			BufferedReader in = new BufferedReader(new FileReader(path));
			StringBuffer sb = new StringBuffer("");
			String row;
			String[] temp;
			temp = change.split(",");
			if (temp.length > 1)
				change = format(change);

			String head;
			head = in.readLine();
			sb.append(head + "\n");
			int targetcol = 0;
			String[] headData = head.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
			for (int j = 0; j < headData.length; j++) {
				if (headData[j].equals(col_name)) {
					targetcol = j;
					break;
				}
			}

			while ((row = in.readLine()) != null) {
				String[] rowData = row.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
				if (rowData[0].equals(targetID) == false) {
					sb.append(row + "\n");

				} else if (rowData[0].equals(targetID)) {
					int totalcol = rowData.length;
					for (int i = 0; i < totalcol; i++) {
						if (i == targetcol && i == totalcol - 1) {
							sb.append(change + "\n");
							break;
						} else if (i == targetcol) {
							sb.append(change);
							sb.append(",");
						} else if (i == totalcol - 1) {
							sb.append(rowData[i] + "\n");
						}

						else {
							sb.append(rowData[i]);
							sb.append(",");
						}

					}
				}
			}
			in.close();

			FileWriter fw = new FileWriter(new File(path));
			// Write entire string buffer into the file
			fw.write(sb.toString());
			fw.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Adds "" to a string
	 * 
	 * @param str <code>String</code> to be altered.
	 * @return Altered <code>String</code>
	 */
	public static String format(String str) {
		return "\"" + str + "\"";
	}
}
