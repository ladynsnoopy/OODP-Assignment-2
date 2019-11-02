package cinema;

public class Receipt {
	private Ticket[] ticketArr;
	private String TID;
	private String paymentMode;
	
	public Receipt(Ticket[] ticketArr, String paymentMode) {
		super();
		this.ticketArr = ticketArr;
		this.paymentMode = paymentMode;
	}

	public Ticket[] getTicketArr() {
		return ticketArr;
	}
	public void setTicketArr(Ticket[] ticketArr) {
		this.ticketArr = ticketArr;
	}
	public String getTID() {
		return TID;
	}
	public void setTID(String tID) {
		TID = tID;
		//TODO setTid so that it adheres to the format given in the question: 
		//XXXYYYYMMDDhhmm (Y:year,M:month,D:day,h:hour,m:minutes,xxx:cinema code in letters)
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public double calTotalAmt()
	{
		double sum = 0;
		for(int i = 0; i< ticketArr.length;i++)
		{
			//remember to set before you get
			sum += ticketArr[i].getFinalPrice();
		}
		return sum;
	}
	

}
