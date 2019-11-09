package cinema;

import java.util.Scanner;

public class MainDisplayPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean loop = true;
		while (loop) {
			Scanner sc = new Scanner(System.in);
			System.out.println("---------Welcome to MOBLIMA---------");
			System.out.println("Enter (1) for access to user page");
			System.out.println("Enter (2) for access to staff page");
			System.out.println("Enter (3) to exit");
			int input;
			while (true) {
				if (sc.hasNextInt()) {
					input = sc.nextInt();
					if (input >= 1 && input < 4) {
						break;
					}
				} else {
					sc.next();
				}
				System.out.println("Invalid Input. Please enter 1 or 2 or 3: ");
			}
//		    sc.close();
			switch (input) {
			case 1:
				DisplayUserPage.displayUserPage();
				break;
			case 2:
				DisplayStaffPage.displayStaffPage();
				break;
			case 3:
				loop = false;
				break;
			}
		}
			
		
		

	}

}
