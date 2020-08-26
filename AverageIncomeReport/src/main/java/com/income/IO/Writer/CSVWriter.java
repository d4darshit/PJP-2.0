package com.income.IO.Writer;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import com.income.Summary;
import static com.income.IO.Constants.CSV_SEPARATOR;


public class CSVWriter implements IncomeWriter {

	private String fileName;

	public CSVWriter(String fileName) {
		super();
		this.fileName = fileName;
	}

	@Override
	public void writeSummary(ArrayList<Summary> summaryData) {
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));

			StringBuffer position = new StringBuffer();
			position.append("Country/City" + CSV_SEPARATOR + "Gender" + CSV_SEPARATOR + "Average Income (USD)");
			bufferedWriter.write(position.toString());
			bufferedWriter.newLine();

			for (Summary summary : summaryData) {
				position = new StringBuffer();
				position.append(summary.getLocation());
				position.append(CSV_SEPARATOR);
				position.append(summary.getGender());
				position.append(CSV_SEPARATOR);
				position.append(summary.getAverageAmount());

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

	

