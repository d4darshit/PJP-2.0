package calculator;

import java.util.Date;

public class Transaction {

	private int transactionId;
	private int clientId;
	private String securityId;
	private Transaction_Type transaction_type;
	private Date transactionDate;
	private double marketValue;
	private char priorityFlag;
	private double processingFee;
	
	public Transaction(int transactionId, int clientId, String securityId, Transaction_Type type, Date transactionDate,
			double marketValue, char priority) {
		super();
		this.transactionId = transactionId;
		this.clientId = clientId;
		this.securityId = securityId;
		this.transaction_type = type;
		this.transactionDate = transactionDate;
		this.marketValue = marketValue;
		this.priorityFlag = priority;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getSecurityId() {
		return securityId;
	}
	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}
	public Transaction_Type getTransactionType() {
		return transaction_type;
	}
	public void setType(Transaction_Type type) {
		this.transaction_type = type;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public double getMarketValue() {
		return marketValue;
	}
	public void setMarketValue(double marketValue) {
		this.marketValue = marketValue;
	}
	public char getPriorityFlag() {
		return priorityFlag;
	}
	public void setPriorityFlag(char priorityFlag) {
		this.priorityFlag = priorityFlag;
	}
	public double getProcessingFee() {
		return processingFee;
	}
	public void setProcessingFee(double processingFee) {
		this.processingFee = processingFee;
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", clientId=" + clientId + ", securityId=" + securityId
				+ ", transaction_type=" + transaction_type + ", transactionDate=" + transactionDate + ", marketValue="
				+ marketValue + ", priorityFlag=" + priorityFlag + ", processingFee=" + processingFee + "]";
	}
	

}
