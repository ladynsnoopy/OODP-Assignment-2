package cinema;

import java.util.Scanner;

public class MainDisplayPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("---------Welcome to MOBLIMA---------");
		System.out.println("Enter (1) for access to user page");
		System.out.println("Enter (2) for access to staff page");
		int input;
	    while (true){
	        if (sc.hasNextInt()){
	             input = sc.nextInt(); 
	             if (input == 1 || input == 2 ){ 
	                   break; 
	            }
	        }else{
	              sc.next();
	        }
	        System.out.println("Invalid Input. Please enter 1 or 2: ");
	    }
//	    sc.close();
		if(input == 1)
		{
			DisplayUserPage.displayUserPage(); 
			
		}
		else
		{
			DisplayStaffPage.displayStaffPage();
		}
		

	}

}
