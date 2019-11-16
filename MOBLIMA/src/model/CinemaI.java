package model;

/**
 * Interface for cinama, to allow ease of future implementation of different
 * kinds of cinema.
 * 
 * @author Lim Wai Leong
 * @author Oh Jun Teng
 * @author Edhie Wahidin Michelle
 * @author Myat Hmu Khin
 * @version 1.0
 * @since 2019-11-15
 *
 */
public interface CinemaI {

	/**
	 * Gets total number of rows of seats in a cinema
	 * 
	 * @return Total number of rows of seats in a cinema.
	 */
	public int getTotalRow();

	/**
	 * Changes total number of rows of seats in a cinema.
	 * 
	 * @param totalRow Total number of rows of seats in a cinema.
	 */
	public void setTotalRow(int totalRow);

	/**
	 * Gets total number of columns of seats in a cinema.
	 * 
	 * @return Total number of columns of seats in a cinema.
	 */
	public int getTotalCol();

	/**
	 * Changes total number of columns of seats in a cinema.
	 * 
	 * @param totalCol Total number of columns of seats in a cinema.
	 */
	public void setTotalCol(int totalCol);

	/**
	 * Gets total number of seats in a cinema.
	 * 
	 * @return Total number of seats in a cinema.
	 */
	public int getTotalNumSeat();

	/**
	 * Gets Unique <code>String</code> cinema ID.
	 * 
	 * @return Unique <code>String</code> cinema ID.
	 */
	public String getCinemaID();

	/**
	 * Gets type of cinema in <code>String</code>.
	 * 
	 * @return Type of cinema in <code>String</code>. Can be "Gold Class", "Normal".
	 */
	public String getType();

}
