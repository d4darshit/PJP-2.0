import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.income.Currency;
import com.income.Gender;
import com.income.Income;
import com.income.ReportGenerator;
import com.income.Summary;

class IncomeCalculatorTest {
	
	ArrayList<Summary> expected;
	ArrayList<Income> income;
	ReportGenerator reportGenerator;
	
	@BeforeEach
	public void setData() {
		income = new ArrayList<Income>();
		income.add(new Income("RJT","IND" , Gender.F, Currency.INR, 66000f));
		income.add(new Income("DEL","IND" , Gender.F, Currency.INR, 66000f));
		/*income.add(new Income("NYC","USA" , Gender.M, Currency.USD, 10000f));
		income.add(new Income("DC","UK" , Gender.M, Currency.SGD, 8000f));
		*/
		expected = new ArrayList<Summary>();
		
		expected.add(new Summary("IND", Gender.F,(double) 1000f ));
		/*expected.add(new Summary("UK", Gender.M,(double) 1000f ));
		expected.add(new Summary("USA", Gender.M,(double)  10000f));
		*/
		reportGenerator = new ReportGenerator();
		
		
	}
	@Test
	public void checkAgainstCustomeData() {
		Assertions.assertArrayEquals(expected.toArray(), reportGenerator.process(income).toArray());
	}
}
