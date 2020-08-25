package calculator.fileIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import calculator.Transaction;
import calculator.Transaction_Type;

public class CSVFileReader {

	String line;
	ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	public ArrayList<Transaction> readData() {
		try   
		{  
			String filePath = "E:\\PJP 2.0\\FeeCalculator\\input.csv";
			BufferedReader br = new BufferedReader(new FileReader(filePath));  
			br.readLine();
            while ((line = br.readLine()) != null) {
            	String[] transaction = line.split(","); 
                String eternalTransactionId = (transaction[0]);
            	String clientId = (transaction[1]);
            	String securityId = transaction[2];
            	Transaction_Type transactionType= Transaction_Type.valueOf(transaction[3]);
            	Date transactionDate = new SimpleDateFormat("MM/dd/yyyy").parse(transaction[4]);
            	double marketValue = Double.parseDouble(transaction[5]);
            	char priorityFlag = transaction[6].charAt(0);
            	
                transactions.add(new Transaction(Integer.parseInt(eternalTransactionId),Integer.parseInt(clientId)
                		,securityId,transactionType, transactionDate,marketValue,priorityFlag));
            }
            br.close();
            
		} catch (Exception e) {
			e.printStackTrace();
		}
		return transactions;
	}
}
