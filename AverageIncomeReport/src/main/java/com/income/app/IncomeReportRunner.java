package com.income.app;

import java.util.ArrayList;
import java.util.Scanner;

import com.income.Income;
import com.income.ReportGenerator;
import com.income.Summary;
import com.income.IO.Reader.CSVReader;
import com.income.IO.Reader.IncomeReader;
import com.income.IO.Writer.CSVWriter;

public class IncomeReportRunner {

	private static String INPUT_FILE = "E:\\PJP 2.0\\AverageIncomeReport\\resources\\input.csv";
	private static String OUTPUT_FILE = "E:\\PJP 2.0\\AverageIncomeReport\\resources\\output.csv";
	static ArrayList<Income> income;
	static IncomeReader incomeReader;
	private static ArrayList<Summary> summary;
	private static CSVWriter incomeWriter;
	
	public static void main(String[] args) {
		
		System.out.println("Please enter the input file!");
		
		Scanner scanner = new Scanner(System.in);
		INPUT_FILE = scanner.nextLine();
		System.out.println("Please enter the output file");
		OUTPUT_FILE = scanner.nextLine();
		scanner.close();
		
		//load file
		incomeReader = new CSVReader();
		income = incomeReader.readIncome(INPUT_FILE);
		//process data
		
		summary = ReportGenerator.process(income);
		incomeWriter = new CSVWriter(OUTPUT_FILE);
		incomeWriter.writeSummary(summary);
		
		
		
		
	
	}
}
