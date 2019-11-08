package cinema;
import java.util.ArrayList;
import java.util.Scanner;
public class Login {
	public static  void menu()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("---------Welcome to MOBLIMA---------");
		System.out.println("Enter (1) for access to staff page");
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
	    sc.close();
		if(input == 1)
		{
			// user module 
			
		}
		else if(input == 2)
		{
			// staff module
		}
		
		
	}
	//Movie-goer module 1. Search/List movie 
	//2. View movie details – including reviews and ratings 
	//3. Check seat availability and selection of seat/s. 
	//4. Book and purchase ticket 
	//5. View booking history 
	//6. List the Top 5 ranking by ticket sales OR by overall reviewers’ ratings 
	public static  void displayUserPage()
	{
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		int custID = custLogin(); // custID is the customer ID of the customer using the App now;
		System.out.println("Please enter your email: ");
		while(loop)
		{
			System.out.println("What would you like to do?");
			System.out.println("Enter (1) to view list of movies.");
			System.out.println("Enter (2) to search for a particular movie.");
			System.out.println("Enter (3) to view seating plan.");
			System.out.println("Enter (4) to purchase a ticket.");
			System.out.println("Enter (5) to view your booking history.");
			System.out.println("Enter (6) to view list of top 5 movies by ticket sales.");
			System.out.println("Enter (7) to view list of top 5 movies by overall reviewers' ratings.");
			System.out.println("Enter (8) to view ");
			int input;
			while (true) {
				if (sc.hasNextInt()) {
					input = sc.nextInt();
					if (input >= 1 && input <= 7) {
						break;
					}
				} else {
					sc.next();
				}
				System.out.println("Invalid Input. Please enter a number between 1 and 7.");

			}
			switch(input)
			{
			case 1: displayAllMovie();
					
					break;
			case 2: displaySearchMovie();
					break;
			case 3: // call view seating plan function
					break;
			case 4: // call buyTicket function
					break;
			case 5: displayBookingHistory(custID);
					break;
			case 6: // call view Top 5 movie
					break;
			case 7: // call view Top 5 movie
					break;
			} 
			sc.close();
			
		}
		
		
	}
	public static int custLogin()
	{
		// do customer initialization
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your email: ");
		String email = sc.nextLine();
		if(CustomerApp.customerExists(email) == -1)
		{
			System.out.println("Please enter your Name and Mobile Number");
			String name = sc.nextLine();
			String mobileNum = sc.nextLine();
			CustomerApp.createCustomer(name, mobileNum, email);
		}
		int ID = CustomerApp.customerExists(email);
		return ID;
	}
	public static void displayAllMovie()
	{
		String [] arr = CustomerApp.searchMovies();
		System.out.println("Movie List:");
		System.out.println("---------------------------");
		for(int i = 1; i<arr.length;i++)
		{
			System.out.println(i+". "+ arr[i]);
		}
	}
	public static void displaySearchMovie()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("What movie would you like to search for?");
		String name = sc.nextLine();
		int ID = CustomerApp.searchOneMovie(name);
		if(ID != -1)
		{
			System.out.println("Showtimes for "+ name+":");
			System.out.println("-----------------------------------------");
			String[][] showtimes = CustomerApp.getShowtimesForMovie(ID);
			for(int i = 0; i< showtimes.length;i++)
			{
				System.out.println(showtimes[i][1] + " CinemaID: "+showtimes[i][0]);
				System.out.println("-----------------------------------------");
			}
			
		}
		else
		{
			System.out.println("This movie ["+ name+"] is not found.");
		}
		sc.close();
		
	}
	public static void displayBookingHistory(int ID)
	{
		System.out.println("Booking History:");
		System.out.println("---------------------");
		String[][] bookHist = CustomerApp.searchBookingHistory(ID);
		for(int i = 0; i<bookHist.length;i++)
		{
			
			
			System.out.println("Transaction ID: "+bookHist[i][0]);
			System.out.println("Payment Mode: "+bookHist[i][1]);
			System.out.println("Movie Name: "+bookHist[i][2]);
			System.out.println("Amount: $"+bookHist[i][3]);
			System.out.println();
			
		}
		
	}
	
	

}
