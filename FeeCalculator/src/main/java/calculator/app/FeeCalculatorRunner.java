package calculator.app;
import java.util.ArrayList;

import calculator.Calculator;
import calculator.Transaction;
import calculator.fileIO.CSVFileReader;
import calculator.fileIO.CSVFileWriter;
import calculator.utils.TransactionSort;
import calculator.utils.TransactionSortByClientTypeDatePriority;

public class FeeCalculatorRunner {

	static ArrayList<Transaction> transactions;
	static TransactionSort transactionSort;
	private static String fileName="E:\\PJP 2.0\\FeeCalculator\\output.csv";
	
	public static void main(String[] args) {
		
		CSVFileReader reader = new CSVFileReader();
		System.out.println("The calculator has started");
		
		// Load all the transactions from memory
		transactions = reader.readData();

		System.out.println("Calculating processing fee for each transaction");
		//Calculate Processing Fee
		Calculator calculator = new Calculator();
		transactions = calculator.calculate(transactions);
		calculator = null;
		
		System.out.println("Sorting all the transactions");
		//Sort transactions 
		transactionSort = new TransactionSortByClientTypeDatePriority();
		transactions = transactionSort.sortTransactions(transactions);
		transactionSort = null;
		//Write all the transaction to file
		
		CSVFileWriter.write(transactions, fileName);
		System.out.println("Summary is ready! Please open the output file!");
		
	}
}
