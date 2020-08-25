package calculator;

public class TransactionFees {
	
	public TransactionFees() {
	
	}
	
	public int getFees(Transaction_Type transactionType) {
		
		
		if(transactionType == Transaction_Type.BUY) return 50;
		else if( transactionType==Transaction_Type.SELL) return 100;
		else if(transactionType==Transaction_Type.DEPOSIT) return 50;
		return 100;
		
	}
}
