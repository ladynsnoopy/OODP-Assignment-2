package cinema;

import java.util.ArrayList;

public class Calendar {
	private ArrayList<String> holArr; // DATE = YYYYMMDD
	private ArrayList<String> weekendArr;
	public Calendar(ArrayList<String> holArr, ArrayList<String> weekendArr) {
		super();
		this.holArr = holArr;
		this.weekendArr = weekendArr;
	}
	public ArrayList<String> getWeekendArr() {
		return weekendArr;
	}
	public void setWeekendArr(ArrayList<String> weekendArr) {
		this.weekendArr = weekendArr;
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
			if(a.getTiming().equals(holArr.get(i)))
			{
				isHols = true;
				break;
			}
		}
		return isHols;
	}
	public boolean checkWeekend(Showtime a) {
		boolean isWeekend = false;
		for(int i = 0;i< weekendArr.size();i++)
		{
			if(a.getTiming().equals(weekendArr.get(i)))
			{
				isWeekend= true;
				break;
			}
		}
		return isWeekend;
	}

	

}
