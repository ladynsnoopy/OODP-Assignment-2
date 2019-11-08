package cinema;

public class SeatingPlan {

	public static void printSeatingPlan(Showtime showtime) {
		showtime.setSeatingPlan();
		System.out.println("Cinema: " + showtime.getCinema().getCinemaID());
		System.out.println();
		System.out.println("--------------SCREEN--------------");
		System.out.print("    ");
		for (int i = 0; i < showtime.getCinema().getTotalCol(); i++) {
			System.out.print((i + 1) + " ");
		}
		System.out.println();
		for (int j = 0; j < showtime.getCinema().getTotalRow(); j++) {
			if (j < 9) {
				System.out.print((j + 1) + "   ");
			} else {
				System.out.print((j + 1) + "  ");
			}
			for (int k = 0; k < showtime.getCinema().getTotalCol(); k++) {
				if (showtime.getSeatingplan()[j][k] == true)
					System.out.print("X ");
				else
					System.out.print("O ");
			}
			System.out.println();
		}
		System.out.println("Key:");
		System.out.println("    O: Unoccupied seat");
		System.out.println("    X: Occupied seat");
	}
}
