package controller;

import java.util.ArrayList;

import model.Cinema;
import model.Cineplex;

/**
 * A control class that will handle methods relating to the cinema model. It
 * allows for the initialization of cinemas and cineplexes .
 * 
 * @author Lim Wai Leong
 * @author Oh Jun Teng
 * @version 1.0
 * @since 2019-11-13
 *
 *
 */
public class CinemaController {

	/**
	 * <code>ArrayList&lt;Cineplex&gt;</code> containing all <code>Cineplexes</code>
	 * objects.
	 */
	public static ArrayList<Cineplex> cineplexArr = new ArrayList<Cineplex>();
	/**
	 * <code>ArrayList&lt;Cinema&gt;</code> containing all <code>Cinema</code>
	 * objects.
	 */
	public static ArrayList<Cinema> cinemaArr = new ArrayList<Cinema>();

	/**
	 * Creates all the pre-existing Cineplex and Cinema objects necessary for the
	 * program to continue. Add the created objects to the relevant public static
	 * ArrayList for other methods to access.
	 */
	public static void createCineplexAndCinemas() {
		ArrayList<Cinema> temp = new ArrayList<Cinema>();

		Cineplex cowboyTown = new Cineplex("NTU", "AA");
		Cineplex jurassicPark = new Cineplex("NUS", "BB");
		Cineplex theCentral = new Cineplex("SMU", "CC");

		cineplexArr.add(cowboyTown);
		cineplexArr.add(jurassicPark);
		cineplexArr.add(theCentral);

		Cinema a1 = new Cinema("Normal", 10, 10, "AA1");
		Cinema a2 = new Cinema("Normal", 15, 10, "AA2");
		Cinema a3 = new Cinema("Gold Class", 5, 5, "AA3");

		// temp = cineplexArr.get(0).getCinemaArr();
		temp.add(a1);
		temp.add(a2);
		temp.add(a3);
		cineplexArr.get(0).setCinemaArr(temp);

		Cinema b1 = new Cinema("Normal", 10, 10, "BB1");
		Cinema b2 = new Cinema("Normal", 15, 10, "BB2");
		Cinema b3 = new Cinema("Gold Class", 5, 5, "BB3");
		temp.clear();
		// temp = cineplexArr.get(1).getCinemaArr();
		temp.add(b1);
		temp.add(b2);
		temp.add(b3);
		cineplexArr.get(1).setCinemaArr(temp);

		Cinema c1 = new Cinema("Normal", 10, 10, "CC1");
		Cinema c2 = new Cinema("Normal", 15, 11, "CC2");
		Cinema c3 = new Cinema("Gold Class", 5, 5, "CC3");
		temp.clear();
		// temp = cineplexArr.get(0).getCinemaArr();
		temp.add(c1);
		temp.add(c2);
		temp.add(c3);
		cineplexArr.get(2).setCinemaArr(temp);

		cinemaArr.add(a1); // ID AA1
		cinemaArr.add(a2); // ID AA2
		cinemaArr.add(a3); // ID AA3
		cinemaArr.add(b1); // ID BB1
		cinemaArr.add(b2); // ID BB2
		cinemaArr.add(b3); // ID BB3
		cinemaArr.add(c1); // ID CC1
		cinemaArr.add(c2); // ID CC2
		cinemaArr.add(c3); // ID CC3

	}

}
