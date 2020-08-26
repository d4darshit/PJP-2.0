package com.income.IO.Reader;

import java.util.ArrayList;

import com.income.Income;

public interface IncomeReader {

	ArrayList<Income> readIncome(String filepath);
}
