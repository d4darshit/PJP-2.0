package datetime.history;

import java.io.Serializable;
import java.util.ArrayList;

import datetime.DateTime;

public class History implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ArrayList<DateTime> objects;
	DateTime result;
	String result_str;
	int result_int;
	public int choice;
	int n;
	public History(){
		objects = new ArrayList<DateTime>();
	}
	public History(DateTime d1,DateTime d2,int choice,DateTime result) {
		
		objects = new ArrayList<DateTime>();
		objects.add(d1);
		objects.add(d2);
		this.choice = choice;
		this.result = result;
	}
	public History(DateTime d1,int choice,DateTime result) {
		objects = new ArrayList<DateTime>();
		objects.add(d1);
		this.choice = choice;
		this.result = result;
	}
	public History(DateTime d1,int n,int choice,DateTime result) {
		objects = new ArrayList<DateTime>();
		this.n = n;
		objects.add(d1);
		this.choice = choice;
		this.result = result;
	}
	public History(DateTime d1,int choice,String result_str) {
		objects = new ArrayList<DateTime>();
		this.choice = choice;
		this.result_str = result_str;
		objects.add(d1);
	}
	public History(DateTime date1, int n, int choice, int result_int) {
		objects = new ArrayList<DateTime>();
		this.choice = choice;
		this.n = n;
		this.result_int = result_int;
		objects.add(date1);
	}
	public History(DateTime date1, int choice2, int result_int2) {
		objects = new ArrayList<DateTime>();
		objects.add(date1);
		this.choice = choice2;
		this.result_int = result_int2;
		
	}
	@Override
	public String toString() {
		return "Input: " + objects + ", result=" + result +  result_str 
				+ result_int + ", choice=" + choice + ", n=" + n + "]";
	}
	
	
}
