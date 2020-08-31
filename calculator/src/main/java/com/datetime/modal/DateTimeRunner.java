package com.datetime.modal;
import java.util.ArrayList;
import java.util.Scanner;

import com.datetime.history.History;

public class DateTimeRunner {

	static ArrayList<History> session;
	public static void printMenu() {
		
		System.out.println("Please select a number from the given menu");
		System.out.println("1 - Addition of two dates");
		System.out.println("2 - Subtraction of two dates");
		System.out.println("3 - Add n days to a given date");
		System.out.println("4 - Subtract n days to a given date");
		System.out.println("5 - Add n weeks to a given date");
		System.out.println("6 - Subtract n weeks to a given date");
		System.out.println("7 - Add n months to a given date");
		System.out.println("8 - Subtract n months to a given date");
		System.out.println("9 - Add n years to a given date");
		System.out.println("10 - Subtract n years to a given date");
		System.out.println("11 - Determining Day for a given date");
		System.out.println("12 - Determining Week for a given date");			
		System.out.println("13 - Entering Language phrases");
		System.out.println("14 - History of the session");
		System.out.println("99 -  Exit!");
		
	}
	
	public static void main(String[] args) {	
		
		session = new ArrayList<History>();
		DateTime date1;
		DateTime date2;
		DateTime result;
		String result_str;
		int result_int;
		int n;
		Scanner sc = new Scanner(System.in);
		DateTimeBO object = new DateTimeBO();
		History historyObj = null;
		int choice;
	
	 do{
		printMenu();
		choice = sc.nextInt();
		switch (choice) {
		case 1:
			
			date1 = object.scanDateObject();			
			date2 = object.scanDateObject();
			result = object.addTwoDates(date1, date2);
			System.out.println(result);
			historyObj = new History(date1, date2, choice,result);
			session.add(historyObj);
			historyObj = null;
			break;
		case 2:
			
			date1 = object.scanDateObject();
			date2 = object.scanDateObject();
			result = object.subtractTwoDates(date1, date2);
			System.out.println(result);
			historyObj = new History(date1, date2, choice,result);
			session.add(historyObj);
			historyObj = null;
			break;
		case 3:
			date1 = object.scanDateObject();
			n = sc.nextInt();
			result = object.addNDays(date1, n);
			System.out.println(result);
			historyObj = new History(date1, choice,result);
			session.add(historyObj);
			historyObj = null;
			break;
		case 4:
			historyObj = new History();
			date1 = object.scanDateObject();
			n = sc.nextInt();
			result = object.subtractNDays(date1, n);
			System.out.println(result);
			session.add(new History(date1,n,choice,result));
			break;
		case 5:
			historyObj = new History();
			date1 = object.scanDateObject();
			n = sc.nextInt();
			result = object.addNWeeks(date1, n);
			System.out.println(result);
			session.add(new History(date1, n, choice, result));
			break;
		case 6:
			date1 = object.scanDateObject();
			n = sc.nextInt();
			result = object.subtractNWeeks(date1, n);
			System.out.println(result);
			session.add(new History(date1, n, choice, result));
			break;
		case 7:
			date1 = object.scanDateObject();
			n = sc.nextInt();
			result = object.addNMonths(date1, n);
			System.out.println(result);
			session.add(new History(date1, n, choice, result));
			break;
		case 8:
			date1 = object.scanDateObject();
			n = sc.nextInt();
			result =  object.subtractNMonths(date1, n);
			System.out.println(result);
			session.add(new History(date1, n, choice, result));
			break;
		case 9:
			date1 = object.scanDateObject();
			n = sc.nextInt();
			result = object.addNYears(date1, n);
			System.out.println(result);
			session.add(new History(date1, n, choice, result));
			break;
		case 10:
			date1 = object.scanDateObject();
			n = sc.nextInt();
			result = object.subtractNYears(date1, n);
			System.out.println(result);
			session.add(new History(date1, n, choice, result));
			break;
		case 11:
			date1 = object.scanDateObject();
			n = sc.nextInt();
			result_str = object.determineDayOfWeek(date1);
			System.out.println(result_str);
			session.add(new History(date1, choice, result_str));
			break;	
		case 12:		
			date1 = object.scanDateObject(); 
			result_int = object.determineWeekOfYear(date1);
			System.out.println(result_int);
			session.add(new History(date1,choice,result_int));
			break;	
		case 13:
			// Need to add this functionality!
			System.out.println("Currently working on it!");
			break;	
		case 14:
			showHistory();
			break;	
		case 99:
			return;
			
		default:
			System.out.println("Please enter a valid option!");
			break;
		};
	}while(choice!=10);
	
	 sc.close();
		
	}

	private static void showHistory() {
			System.out.println("History of the session \n Press any key to pause/start");
			
			int iterator = 0;
			while(iterator<session.size()) {
				System.out.println("Choice: "+session.get(iterator).choice+" Date: "+session.get(iterator).objects);
				iterator++;
			}
			
			
	}
}
