package cinema;

public class Receipt {
	private Ticket[] ticketArr;
	private String TID;
	private String paymentMode;
	
	public Receipt(Ticket[] ticketArr, String tID, String paymentMode) {
		super();
		this.ticketArr = ticketArr;
		TID = tID;
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
			sum += ticketArr[i].getFinalPrice();
		}
		return sum;
	}
	

}
