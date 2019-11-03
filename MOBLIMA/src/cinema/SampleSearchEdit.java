package cinema;

import java.util.ArrayList;
import java.util.Scanner;

public class SampleSearchEdit {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter movie name to edit: ");
		String mv_name = sc.next();
		ArrayList<String> result = csvRW.search("moviedatabase", "Name", mv_name);
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
	}

}
