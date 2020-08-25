package calculator;

import java.util.ArrayList;
import java.util.Iterator;

public class Calculator {

	private double processingFee;
	private ArrayList<Transaction> transactions;
	private ArrayList<Transaction> processedTransactions;
	Iterator<Transaction> iterator;
	TransactionFees transactionFees = new TransactionFees();
	
	public ArrayList<Transaction> calculate(ArrayList<Transaction> passedTransactions) {
		processedTransactions = new ArrayList<Transaction>();
		transactions = passedTransactions;
		iterator = passedTransactions.iterator();
		while(iterator.hasNext()) {
			Transaction transaction = iterator.next();
			if(isIntraDayTransaction(transaction)) {
				intraDayTransactions(transaction, iterator);
			} else {
				normalTransactions(transaction);
			}
		}
		return processedTransactions;
	}
	
	private boolean isIntraDayTransaction(Transaction transaction) {
		boolean isIntraDayTransaction = false;
		if (transactions.size() > 0) {
			Transaction squareOffTransaction = null;
			Iterator<Transaction> innerIterator = transactions.iterator();
			while (innerIterator.hasNext()) {
				Transaction currentTransaction = (Transaction) innerIterator.next();
				if (currentTransaction.getClientId()==transaction.getClientId()
						&& currentTransaction.getSecurityId().equals(transaction.getSecurityId())
						&& currentTransaction.getTransactionDate().equals(transaction.getTransactionDate())) {
					if ((currentTransaction.getTransactionType()==Transaction_Type.BUY) 
							&& (currentTransaction.getTransactionType()==Transaction_Type.SELL)
							|| (currentTransaction.getTransactionType()==Transaction_Type.SELL)
									&& currentTransaction.getTransactionType()==Transaction_Type.BUY) {
						isIntraDayTransaction = true;
						squareOffTransaction = currentTransaction;
						break;
					}
				}
			}

			if (squareOffTransaction != null) {
				intraDayTransactions(squareOffTransaction,innerIterator);
			}

		} else {
			isIntraDayTransaction = false;
		}
		return isIntraDayTransaction;
	}

	private void intraDayTransactions(Transaction transaction, Iterator<Transaction> innerIterator) {
		processingFee = 10;
		transaction.setProcessingFee(processingFee);
		innerIterator.remove();
		processedTransactions.add(transaction);
	}
	
	private void normalTransactions(Transaction transaction) {
		if(transaction.getPriorityFlag()=='Y') {
			processingFee = 500;
		} else {
			TransactionFees transactionFees = new TransactionFees();
			processingFee = transactionFees.getFees(transaction.getTransactionType());
		}
		transaction.setProcessingFee(processingFee);
		processedTransactions.add(transaction);
	}
	
}
