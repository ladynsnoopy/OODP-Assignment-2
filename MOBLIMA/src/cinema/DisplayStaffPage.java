package cinema;

import java.util.Scanner;
import java.util.ArrayList;

public class DisplayStaffPage {

	public static void displayUserPage() {
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		// do customer initialisation stuff
		while (loop) {
			System.out.println("What would you like to do?");
			System.out.println("Enter (1) to add a new movie.");
			System.out.println("Enter (2) to edit existing movie details");
			System.out.println("Enter (3) to add a new showtime");
			System.out.println("Enter (4) to edit existing showtime details");
			System.out.println("Enter (5) to edit ticket prices");
			System.out.println("Enter (6) to add a new holiday date");
			System.out.println("Enter (7) to view list of top 5 movies by ticket sales.");
			System.out.println("Enter (8) to view list of top 5 movies by overall reviewers' ratings.");
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
			switch (input) {
			case 1:
				addMovie();
				System.out.println("Press enter to return\n");
				try {
					System.in.read();
				} catch (Exception e) {
				}
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

	public static void addMovie() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of the movie:");
		String name = sc.nextLine();
		System.out.println("Enter the showing status of the movie:");
		String showingStatus = sc.nextLine();
		System.out.println("Enter the synopsis:");
		String synopsis = sc.nextLine();
		System.out.println("Enter cast members(separated by commas):");
		String cast = sc.nextLine();
		ArrayList<String> castList = new ArrayList<String>();
		String[] castArr = cast.split(",");
		for (String s : castArr)
			castList.add(s);
		System.out.println("Enter director:");
		String director = sc.nextLine();
		System.out.println("Enter type(genre) of movie:");
		String type = sc.nextLine();
		System.out.println("Enter the age rating for the movie:");
		String movieRating = sc.nextLine();
		System.out.println("Press (1) to confirm details");
		System.out.println("Press (2) to re-enter details");
		System.out.println("Press (3) to cancel and return to menu");
		int input;
		while (true) {
			if (sc.hasNextInt()) {
				input = sc.nextInt();
				if (input >= 1 && input <= 3) {
					break;
				}
			} else {
				sc.next();
			}
			System.out.println("Invalid Input. Please enter a number between 1 and 3.");
		}
		sc.close();
		switch (input) {
		case (1):
			StaffApp.createMovie(name, showingStatus, synopsis, castList, director, type, movieRating, "1");
			return;
		case (2):
			addMovie();
			return;
		case (3):
			return;

		}
		
	}

	public static void editMovieDetails() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter (1) to edit movie title");
		System.out.println("Enter (2) to edit movie type(genre)");
		System.out.println("Enter (3) to edit showing status");
		System.out.println("Enter (4) to edit movie synopsis");
		System.out.println("Enter (5) to edit movie rating");
		System.out.println("Enter (6) to edit movie director");
		System.out.println("Enter (7) to edit movie cast");
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

		}
	}

}
