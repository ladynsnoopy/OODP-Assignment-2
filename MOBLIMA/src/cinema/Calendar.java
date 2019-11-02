package cinema;

import java.util.ArrayList;

public class Calendar {
	private ArrayList<String> holArr; // DATE = YYYYMMDD
	public Calendar(ArrayList<String> holArr) {
		super();
		this.holArr = holArr;
	}
	public ArrayList<String> getHolArr() {
		return holArr;
	}
	public void addHolArr(String hol) {
		holArr.add(hol);
	}
	public boolean checkHols(Showtime a) {
		boolean isHols = false;
		for(int i = 0;i< holArr.size();i++)
		{
			if(showtime.getTiming().equals(holArr.get(i)))
			{
				isHols = true;
				break;
			}
		}
		return isHols;
	}

	

}
