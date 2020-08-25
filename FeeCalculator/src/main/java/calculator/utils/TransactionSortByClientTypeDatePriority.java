package calculator.utils;

import java.util.ArrayList;
import java.util.Comparator;

import calculator.Transaction;

public class TransactionSortByClientTypeDatePriority implements TransactionSort {

		@Override
		public ArrayList<Transaction> sortTransactions(ArrayList<Transaction> transactions) {
			
			transactions.sort(Comparator.comparingInt(Transaction :: getClientId)
	        		.thenComparing(Transaction::getTransactionType)
	                .thenComparing(Transaction::getTransactionDate)
	                .thenComparing(Transaction::getPriorityFlag));
	        
	        return  transactions;
		}
			
		
		
	}
