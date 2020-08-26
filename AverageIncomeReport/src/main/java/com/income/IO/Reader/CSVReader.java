package com.income.IO.Reader;


import static com.income.IO.Constants.CSV_SEPARATOR;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.income.Currency;
import com.income.Gender;
import com.income.Income;

public class CSVReader implements IncomeReader{
	String line;
	ArrayList<Income> incomeList;
	public ArrayList<Income> readIncome(String filePath) {
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
			bufferedReader.readLine();
			incomeList = new ArrayList<Income>();
			while((line = bufferedReader.readLine())!=null) {
				
				String [] income = line.split(CSV_SEPARATOR);
				String city = (income[0]);
				String country = (income[1]);
				Gender gender = Gender.valueOf(income[2]);
				Currency currency = Currency.valueOf(income[3]);
				Float amount = Float.parseFloat(income[4]);
				incomeList.add(new Income(city,country,gender,currency,amount));
				
			}
			bufferedReader.close();
			

		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return incomeList;
	}

}
