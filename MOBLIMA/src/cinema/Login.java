package cinema;
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
		// do customer initialisation stuff
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
			case 1: StaffApp.movielistArr.pr
					break;
			case 2: // call search Movie function
					break;
			case 3: // call view seating plan function
					break;
			case 4: // call buyTicket function
					break;
			case 5: // call view BookingHistory
					break;
			case 6: // call view Top 5 movie
					break;
			case 7: // call view Top 5 movie
					break;
			}
			
		}
		
		
	}
	
	

}
