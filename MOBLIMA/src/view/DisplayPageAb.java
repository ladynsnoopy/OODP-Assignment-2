package view;

/**
 * Abstract class that implements <code>DisplayPage</code>. Allows more display
 * pages of the same format to be implemented more easily.
 * 
 * @author Lim Wai Leong
 * @author Oh Jun Teng
 * @author Edhie Wahidin Michelle
 * @author Myat Hmu Khin
 * @version 1.0
 * @since 2019-11-14
 * @see DisplayPage
 *
 */
public class DisplayPageAb implements DisplayPage {

	/**
	 * Constructor of <code>DisplayPageAb</code>. 
	 */
	public DisplayPageAb() {
		super();
	}

	/**
	 * Allows user to exit out of program while it's still running.
	 */
	public void enterToReturn() {
		System.out.println("Press enter to return\n"); // general function required for all display pages
		try {
			System.in.read();
		} catch (Exception e) {
		}
	}
}
