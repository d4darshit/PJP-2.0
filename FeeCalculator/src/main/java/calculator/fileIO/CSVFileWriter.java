package calculator.fileIO;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import calculator.Transaction;

public class CSVFileWriter {

	private static final String CSV_SEPARATOR = ",";

	public static void write(ArrayList<Transaction> transactions, String fileName) {
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));

			StringBuffer position = new StringBuffer();
			position.append("Client ID" + CSV_SEPARATOR + "Transaction Type" + CSV_SEPARATOR + "Transaction Date"
					+ CSV_SEPARATOR + "Priority" + CSV_SEPARATOR + "Processing Fee");
			bufferedWriter.write(position.toString());
			bufferedWriter.newLine();

			for (Transaction transaction : transactions) {
				position = new StringBuffer();
				position.append(transaction.getClientId());
				position.append(CSV_SEPARATOR);
				position.append(transaction.getTransactionType());
				position.append(CSV_SEPARATOR);
				position.append(transaction.getTransactionDate());
				position.append(CSV_SEPARATOR);
				position.append(transaction.getPriorityFlag());
				position.append(CSV_SEPARATOR);
				position.append(transaction.getProcessingFee());
				position.append(CSV_SEPARATOR);

				bufferedWriter.write(position.toString());
				bufferedWriter.newLine();
			}
			bufferedWriter.flush();
			bufferedWriter.close();
		} catch (UnsupportedEncodingException e) {
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}
}
