package cinema;

/**
 * Price object that determines the pricing of each ticket according to each
 * criteria. Criteria consists of age group, and showtime date.
 * 
 * @author Myat Hmu Khin
 * @version 1.0
 * @since 2019-11-10
 *
 */
public class Price {
	/**
	 * Pricing for an adult movie-goer.
	 */
	private double priceAdult;
	/**
	 * Pricing for a child movie-goer.
	 */
	private double priceChild;
	/**
	 * Pricing for a senior movie-goer.
	 */
	private double priceSenior;
	/**
	 * Pricing for when selected showtime is on a weekend. Is in percentage of
	 * increase to base price.
	 */
	private double priceWeekend; // percentage based
	/**
	 * Pricing for when selected showtime is on a holiday date. Is in terms of flat
	 * increment to base price.
	 */
	private double priceHol; // add price to base

	// TODO should we initialize default values for prices?
	/**
	 * Default constructor for <code>Price</code> object.
	 */
	private double priceGoldClass;
	public Price() {
		this.priceAdult = 7.5;
		this.priceChild = 5.0;
		this.priceSenior = 6.0;
		this.priceWeekend = 0.2;
		this.priceHol = 1.0;
		this.priceGoldClass = 10.0;
	}

	/**
	 * Constructor for <code>Price</code> object.
	 * 
	 * @param priceAdult     Pricing for an adult movie-goer
	 * @param priceChild     Pricing for a child movie-goer
	 * @param priceSenior    Pricing for a senior movie-goer
	 * @param priceWeekend   Pricing for when selected showtime is on a weekend. Is in
	 *                       percentage of increase to base price.
	 * @param priceHol       Pricing for when selected showtime is on a holiday date.
	 *                       Is in terms of flat increment to base price.
	 * @param priceGoldClass Pricing for when selected showtime is at a gold class cinema. Is in
	 * 						 terms of flat increment to base price.                   
	 */
	public Price(double priceAdult, double priceChild, double priceSenior, double priceWeekend, double priceHol, double priceGoldClass) {
		super();

		this.priceAdult = priceAdult;
		this.priceChild = priceChild;
		this.priceSenior = priceSenior;
		this.priceWeekend = priceWeekend;
		this.priceHol = priceHol;
		this.priceGoldClass = priceGoldClass;
	}
	/**
	 * 
	 * @return Current Gold Class pricing
	 */

	public double getPriceGoldClass() {
		return priceGoldClass;
	}
	/**
	 * Changes gold class pricing
	 * @param priceGoldClass
	 */

	public void setPriceGoldClass(double priceGoldClass) {
		this.priceGoldClass = priceGoldClass;
	}

	/**
	 * Gets adult pricing
	 * 
	 * @return Current adult pricing
	 */
	public double getPriceAdult() {
		return priceAdult;
	}

	/**
	 * Changes adult pricing
	 * 
	 * @param priceAdult New adult pricing
	 */
	public void setPriceAdult(double priceAdult) {
		this.priceAdult = priceAdult;
	}

	/**
	 * Gets child pricing
	 * 
	 * @return Current child pricing
	 */
	public double getPriceChild() {
		return priceChild;
	}

	/**
	 * Changes child pricing
	 * 
	 * @param priceChild New child pricing
	 */
	public void setPriceChild(double priceChild) {
		this.priceChild = priceChild;
	}

	/**
	 * Gets senior pricing
	 * 
	 * @return Current senior pricing
	 */
	public double getPriceSenior() {
		return priceSenior;
	}

	/**
	 * Changes senior pricing
	 * 
	 * @param priceSenior New senior pricing
	 */
	public void setPriceSenior(double priceSenior) {
		this.priceSenior = priceSenior;
	}

	/**
	 * Gets weekend pricing. Is in percentage of increase to base price.
	 * 
	 * @return Current weekend pricing
	 */
	public double getPriceWeekend() {
		return priceWeekend;
	}

	/**
	 * Changes weekend pricing. Is in percentage of increase to base price.
	 * 
	 * @param priceWeekend New weekend pricing
	 */
	public void setPriceWeekend(double priceWeekend) {
		this.priceWeekend = priceWeekend;
	}

	/**
	 * Gets holiday pricing. Is in terms of flat increment to base price.
	 * 
	 * @return Current holiday pricing
	 */
	public double getPriceHol() {
		return priceHol;
	}

	/**
	 * Changes holiday pricing. Is in terms of flat increment to base price.
	 * 
	 * @param priceHol New holiday pricing
	 */
	public void setPriceHol(double priceHol) {
		this.priceHol = priceHol;
	}

}
