package controller;

import model.Showtime;

/**
 * Control class that takes in Showtime class and collects the necessary
 * information to print the seating plan
 * 
 * @author Lim Wai Leong
 * @author Oh Jun Teng
 * @author Edhie Wahidin Michelle
 * @author Myat Hmu Khin
 * @version 1.0
 * @since 2019-11-10
 *
 */
public class SeatingPlan {

	/**
	 * 
	 * Prints out seating plan in the format of:<br>
	 * Cinema: 1<br>
	 * 
	 * --------------SCREEN--------------<br>
	 * 0 1 2 3 4 5 6 7 8 9 <br>
	 * 0 O O O O O O O O O O <br>
	 * 1 O O O O O O O O O O <br>
	 * 2 O O O O O O O O O O <br>
	 * 3 O O O O O O X O O O <br>
	 * 4 O O O O O O O O O O <br>
	 * 5 O O O O O X X O O O <br>
	 * 6 O O O O O O O X O O <br>
	 * 7 X O O O O O O O O O <br>
	 * 8 O O O O O O O X O O <br>
	 * 9 O O O O O O O O O O <br>
	 * 10 O O O O O X O O O O <br>
	 * 11 O O O O O O O O O O <br>
	 * 12 O O O O O O O O O O <br>
	 * 13 O O O O O O O O O O <br>
	 * 14 O O O O O O O O O O <br>
	 * <br>
	 * Key:<br>
	 * O: Unoccupied seat<br>
	 * X: Occupied seat<br>
	 * 
	 * 
	 * 
	 * @param showtime Showtime that the seating plan to be printed belongs to.
	 */
	public static void printSeatingPlan(Showtime showtime) {
		showtime.setSeatingPlan();
		System.out.println("Cinema: " + showtime.getCinema().getCinemaID());
		System.out.println();
		System.out.println("--------------SCREEN--------------");
		System.out.print("    ");
		for (int i = 0; i < showtime.getCinema().getTotalCol(); i++) {
			System.out.print((i) + " ");
		}
		System.out.println();
		for (int j = 0; j < showtime.getCinema().getTotalRow(); j++) {
			if (j < 10) {
				System.out.print((j) + "   ");
			} else {
				System.out.print((j) + "  ");
			}
			for (int k = 0; k < showtime.getCinema().getTotalCol(); k++) {
				if (showtime.getSeatingplan()[j][k] == true)
					System.out.print("X ");
				else
					System.out.print("O ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("Key:");
		System.out.println("    O: Unoccupied seat");
		System.out.println("    X: Occupied seat");
	}
}
