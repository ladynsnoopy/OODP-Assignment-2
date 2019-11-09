package cinema;

public class Price {
	private double priceAdult;
	private double priceChild;
	private double priceSenior;
	private double priceWeekend; // percentage based
	private double priceHol; // add price to base
	
	
	//TODO should we initialize default values for prices?
	public Price(double priceAdult, double priceChild, double priceSenior, double priceWeekend,
			double priceHol) {
		super();
	
		this.priceAdult = priceAdult;
		this.priceChild = priceChild;
		this.priceSenior = priceSenior;
		this.priceWeekend = priceWeekend;
		this.priceHol = priceHol;
	}
	public double getPriceAdult() {
		return priceAdult;
	}
	public void setPriceAdult(double priceAdult) {
		this.priceAdult = priceAdult;
	}
	public double getPriceChild() {
		return priceChild;
	}
	public void setPriceChild(double priceChild) {
		this.priceChild = priceChild;
	}
	public double getPriceSenior() {
		return priceSenior;
	}
	public void setPriceSenior(double priceSenior) {
		this.priceSenior = priceSenior;
	}
	public double getPriceWeekend() {
		return priceWeekend;
	}
	public void setPriceWeekend(double priceWeekend) {
		this.priceWeekend = priceWeekend;
	}
	public double getPriceHol() {
		return priceHol;
	}
	public void setPriceHol(double priceHol) {
		this.priceHol = priceHol;
	}

}
