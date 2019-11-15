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

	public int getTotalRow();

	public void setTotalRow(int totalRow);

	public int getTotalCol();

	public void setTotalCol(int totalCol);

	public int getTotalNumSeat();

	public String getCinemaID();

	public String getType();

}
