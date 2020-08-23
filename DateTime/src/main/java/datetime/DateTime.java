package datetime;

import java.util.Calendar;

public class DateTime {

	Calendar dateObject;
	
	public DateTime() {
		
	}

	public DateTime(String string, String string2, String string3) {

		int date = Integer.parseInt(string);
		int month = Integer.parseInt(string2)-1;
		int year = Integer.parseInt(string3);
		dateObject = Calendar.getInstance();
		dateObject.set(Calendar.DATE, date);
		dateObject.set(Calendar.MONTH, month);
		dateObject.set(Calendar.YEAR, year);
		
	}
	

	public DateTime(int date, int month, int year) {
		dateObject = Calendar.getInstance();
		dateObject.set(Calendar.DATE, date);
		dateObject.set(Calendar.MONTH, month-1);
		dateObject.set(Calendar.YEAR, year);
		
	}

	public Calendar getDate() {
		return dateObject;
	}

	public void setDate(Calendar date) {
		this.dateObject = date;
	}

	@Override
	public String toString() {
		return ""+dateObject.get(Calendar.DATE)+"/"+(dateObject.get(Calendar.MONTH)+1)+"/"+dateObject.get(Calendar.YEAR);
	}
	
}
