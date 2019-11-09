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
	//2. View movie details � including reviews and ratings 
	//3. Check seat availability and selection of seat/s. 
	//4. Book and purchase ticket 
	//5. View booking history 
	//6. List the Top 5 ranking by ticket sales OR by overall reviewers� ratings 
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
			System.out.println("Enter (8) to add review. ");
			int input;
			while (true) {
				if (sc.hasNextInt()) {
					input = sc.nextInt();
					if (input >= 1 && input <= 8) {
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
			case 4: if(displayBuyTicket(custID) == 1) 
					{
						String[] info = CustomerApp.findCustomer(custID);
						System.out.println("Customer ID: "+info[0]);
						System.out.println("Customer Name: "+info[1]);
						System.out.println("Mobile Number: "+info[2]);
						System.out.println("Email: "+info[3]);
						
					}
					break;
			case 5: displayBookingHistory(custID);
					break;
			case 6: // call view Top 5 movie
					displayTopMovies(2);
					break;
			case 7: // call view Top 5 movie
					displayTopMovies(1);
					break;
			case 8: displayAddReview(custID);
				break;
			} 
			sc.close();
			
		}
		
		
	}
	// returns customerID of the current user
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
	public static void displayTopMovies(int selection)
	{
		switch(selection) {
		case 1:
			System.out.println("Top 5 movies by overall reviewers' ratings:");
			break;
		case 2:
			System.out.println("Top 5 movies by ticket sales:");
			break;
		}
		for (int i=0; i<=5; i++)
		{
			System.out.println(StaffApp.showTopMovies(selection).get(i));
		};
	}
	public static void displaySearchMovie()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("What is the name of the movie you would like to search for?");
		String name = sc.nextLine();
		int ID = CustomerApp.searchOneMovie(name);
		if(ID != -1)
		{
			System.out.println("Showtimes for "+ name+":");
			System.out.println("-----------------------------------------");
			String[][] showtimes = CustomerApp.getShowtimesForMovie(ID);
			for(int i = 0; i< showtimes.length;i++)
			{
				System.out.println("Showtime ID: "+ showtimes[i][0]);
				System.out.println("Time and Date: "+ showtimes[i][1]);
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
	public static void displayAddReview(int custID)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("What is the name of the movie you would like to add a review for?");
		String moviename = sc.nextLine();
		if(CustomerApp.searchOneMovie(moviename) != -1)
		{
			System.out.println("What would you rate this movie upon 10?");
			int rating = sc.nextInt();
			System.out.println("What are your comments about this movie?");
			String comment = sc.nextLine(); 
			CustomerApp.addReview(rating, comment, Integer.toString(custID), moviename);
			System.out.println("Thank you for your review.");
		}
		else
		{
			System.out.println("This is not a valid movie name. Please try again.");
		}
			
	}
	public static int checkValidityShowtime(String[][] show, int target)
	{
		for(int i = 0; i< show.length;i++)
		{
			if(target == Integer.parseInt(show[i][0]))
			{
				return 1;
			}
				
		}
		return -1;
	}
	public static String printRelevantShowTime(String[][] show, int target)
	{
		for(int i = 0; i< show.length;i++)
		{
			if(target == Integer.parseInt(show[i][0]))
			{
				return show[i][1];
			}
				
		}
		return "NOT VALID";
	}
	public static String getPaymentMode(int payment)
	{
		String result;
		switch(payment)
		{
		case 1: result = "Cash"; break;
		case 2: result = "Credit/Debit Card"; break;
		case 3: result = "PayLah"; break;
		default: result = "invalid"; break;
		}
		return result;
	}
	

	public static int displayBuyTicket(int custID) {
		Scanner sc = new Scanner(System.in);
		System.out.println("What is the name of the movie you would like to buy?");
		String name = sc.nextLine();
		int ID = CustomerApp.searchOneMovie(name); // this function checks the name of movie is valid
		if (ID != -1) {
			// prints show times for the movie
			System.out.println("Showtimes for " + name + ":");
			System.out.println("-----------------------------------------");
			String[][] showtimes = CustomerApp.getShowtimesForMovie(ID);
			for (int i = 0; i < showtimes.length; i++) {
				System.out.println("Showtime ID: " + showtimes[i][0]);
				System.out.println("Time and Date: " + showtimes[i][1]);
				System.out.println("-----------------------------------------");
			}
			System.out.println("Enter the showtime ID that you would like to buy: ");
			int showID;
			int numSeat;
			int index = 0;
			while (true) {
				if (sc.hasNextInt()) {
					showID = sc.nextInt();
					if (checkValidityShowtime(showtimes, showID) == 1) { // this function checks that showID entered is
																			// valid
						break;
					}
				} else {
					sc.next();
				}
				System.out.println("Invalid Input. Please enter a valid showtime ID.");

			}
			// prints seating plan of that show time for customers to choose
			for (int i = 0; i < StaffApp.showtimeArr.size(); i++) {
				if (showID == StaffApp.showtimeArr.get(i).getShowtimeID()) {
					SeatingPlan.printSeatingPlan(StaffApp.showtimeArr.get(i));
					index = i;
					break;
				}
			}
			System.out.println("How many seats do you want to purchase?");
			while (true) {
				if (sc.hasNextInt()) {
					numSeat = sc.nextInt();
					if (numSeat > 0 && numSeat < StaffApp.showtimeArr.get(index).getCinema().getTotalNumSeat()) { // checks that number of seats to be purchased is reasonable
						break;
					}
				} else {
					sc.next();
				}
				System.out.println("Invalid Input. Please enter a valid number of seats.");
			}
			int x, y;
			boolean keep_loop = true;
			Ticket [] ticketArr = new Ticket[3];
			for (int h = 0; h < numSeat; h++) {
				while (keep_loop) { // TODO the logic here may be a bit wrong
					System.out.println("Please enter the x,y position of the seats:");
					while (true) {
						if (sc.hasNextInt()) {
							x = sc.nextInt(); // TODO please check here
							y = sc.nextInt();
							if (x >= 0 && x < StaffApp.showtimeArr.get(index).getCinema().getTotalCol() && y >= 0
									&& y < StaffApp.showtimeArr.get(index).getCinema().getTotalRow()) {
								break;
							}
						} else {
							sc.next();
						}
						System.out.println("Invalid Input. Please enter a valid x,y position.");
					}
					int purchase = CustomerApp.buyTicket(showID, x, y);
					String timing = printRelevantShowTime(showtimes, showID);
					if (purchase == 1) {
						System.out.println("Enter the movie goer type:");
						System.out.println("(1) for child");
						System.out.println("(2) for adult");
						System.out.println("(3) for senior citizen");
						int num = 0;
						while (true) {
							if (sc.hasNextInt()) {
								num = sc.nextInt();
								if (num >= 1 && num <=3) {
									break;
								}
							} else {
								sc.next();
							}
							System.out.println("Invalid Input. Please enter a valid number between 1 and 3.");
						}
						ticketArr[h] = CustomerApp.addTicket(showID,name,num);
						System.out.printf("\nPurchase of Ticket %d,%d for %s at %s is successful.\n", x, y, name,
									timing);
						break;
						
						
					} else {
						System.out.printf("\nYou cannot purchase seat %d,%d as it is already occupied.\n", x, y);
					}
				} 
			}
			int paymentmode;
			System.out.println("What will be your mode of payment?");
			System.out.println("(1) for Cash");
			System.out.println("(2) for Credit/Debit Card");
			System.out.println("(3) for PayLah");
			while (true) {
				if (sc.hasNextInt()) {
					paymentmode = sc.nextInt();
					if (paymentmode >= 1 && paymentmode<=3) {
						break;
					}
				} else {
					sc.next();
				}
				System.out.println("Invalid Input. Please enter a valid number between 1 and 3.");
			}
			String payment = getPaymentMode(paymentmode);
			String TID = CustomerApp.addPayment(ticketArr, payment);
			CustomerApp.addReceiptinCustomerDatabase(custID,TID); // add the stupid receipt into the customer database
			System.out.println("Transaction ID: " +TID);
			System.out.println("Number of tickets purchased: "+ numSeat);
			System.out.println("Payment Mode: "+ payment);
			sc.close();
			return 1;
		} else {
			System.out.println("This movie [" + name + "] is not found.");
			sc.close();
			return -1; // unsuccessful buying ticket because movie name entered is not found
		}

	}

}
