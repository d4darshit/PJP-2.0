package com.income;

import static java.util.stream.Collectors.groupingBy;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ReportGenerator {


	private static Map<String, Map<String, Double>> groupedIncomeData;
	static Summary summaryObj;
	static ArrayList<Summary> summaryReturn;
	public static ArrayList<Summary> process(ArrayList<Income> inputIncomeData) {
		ArrayList<Income> processedIncomeData = inputIncomeData;
		ArrayList<Summary> summary = new ArrayList<Summary>();

	
		 groupedIncomeData = processedIncomeData.stream().collect(
				groupingBy(Income::getLocation, Collectors.groupingBy(Income::getGender,
						Collectors.averagingDouble(Income::getAmount))));
		 
		 // Sort the map
		 TreeMap<String, Map<String, Double>> sortedIncomeData = new TreeMap<String, Map<String, Double>>();
			sortedIncomeData.putAll(groupedIncomeData);
		 
		 		
		 for (String location : sortedIncomeData.keySet()) {
				Map<String, Double> generateAverageIncome = (Map<String, Double>) sortedIncomeData.get(location);

				for (String gender : generateAverageIncome.keySet()) {
					Double amount = generateAverageIncome.get(gender);
					summaryObj = new Summary(location, Gender.valueOf(gender), amount); 
					
					summary.add(summaryObj);
					
				}
			}
		
		
		return summary;
	}
}
