package com.datetime.modal;

import java.util.Calendar;
import java.util.Scanner;

import org.springframework.stereotype.Component;
@Component
public class DateTimeBO {
	public DateTime scanDateObject() {
		System.out.println("Please enter date in dd mm yy format");
		System.out.println("If the date is 20/08/2020 Enter like\n20 08 2020");
		Scanner scan =  new Scanner(System.in);
		String s = scan.nextLine();
		String array[] = s.split(" ");
		if(array.length!=3)
		{
			System.out.println("Please enter valid date!");
			return null;
		}
		DateTime obj = new DateTime(array[0],array[1],array[2]); 
		
		return obj;
	}

	public DateTime addTwoDates(DateTime date,DateTime date2) {
		date.dateObject.add(Calendar.DATE, date2.dateObject.get(Calendar.DATE));
		date.dateObject.add(Calendar.MONTH, date2.dateObject.get(Calendar.MONTH));
		date.dateObject.add(Calendar.YEAR, date2.dateObject.get(Calendar.YEAR));
		return date;
	} 
	public DateTime subtractTwoDates(DateTime date,DateTime date2) {
		date.dateObject.add(Calendar.DATE, -1*date2.dateObject.get(Calendar.DATE));
		date.dateObject.add(Calendar.MONTH, -1*date2.dateObject.get(Calendar.MONTH));
		date.dateObject.add(Calendar.YEAR, -1*date2.dateObject.get(Calendar.YEAR));
		return date;
		
	}
	public DateTime addNDays(DateTime date,int n) {
		date.dateObject.add(Calendar.DATE, n);
		return date;
		
	}
	public DateTime subtractNDays(DateTime date,int n) {
		date.dateObject.add(Calendar.DATE, -1*n);
		return date;
	}
	public DateTime addNWeeks(DateTime date,int n) {
		date.dateObject.add(Calendar.WEEK_OF_YEAR, n);
		return date;
		
	}
	public DateTime subtractNWeeks(DateTime date,int n) {
		date.dateObject.add(Calendar.WEEK_OF_YEAR, -1*n);
		return date;
		
	}
	public DateTime addNMonths(DateTime date,int n) {
		date.dateObject.add(Calendar.MONTH, n);
		return date;
		
	}
	public DateTime subtractNMonths(DateTime date,int n){
		date.dateObject.add(Calendar.MONTH, -1*n);
		return date;
		
	}
	public DateTime addNYears(DateTime date,int n){
		date.dateObject.add(Calendar.YEAR, n);
		return date;
		
	}
	public DateTime subtractNYears(DateTime date,int n){
		date.dateObject.add(Calendar.YEAR, -1*n);
		return date;
		
	}
	public String determineDayOfWeek(DateTime date) {
		String[] strDays = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thusday",
		        "Friday", "Saturday" };
		return strDays[date.dateObject.get(Calendar.DAY_OF_WEEK)-1];
	}
	public int determineWeekOfYear(DateTime date) {
		return date.dateObject.get(Calendar.WEEK_OF_YEAR);
	}
	public DateTime enteringLanguagePhrase(String s) {
		return null;
		
	}
}

