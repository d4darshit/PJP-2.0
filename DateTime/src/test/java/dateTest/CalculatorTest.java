package dateTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import datetime.DateTime;
import datetime.DateTimeBO;

public class CalculatorTest {

	DateTimeBO object;
	
	@BeforeEach
	public void setObject() {
		object = new DateTimeBO();
	}
	
	@Test
	public void whenTwoDatesAdded() {
		String expected = "2/1/4000";
		String actual =  object.addTwoDates(new DateTime(1,1,2000), new DateTime(1,1,2000)).toString();
		Assertions.assertEquals(expected,actual);
	}
	@Test
	public void whenTwoDatesSubtracted() {
		String expected = "2/3/1";
		String actual = object.subtractTwoDates(new DateTime(3,3,2002), new DateTime(1,1,2001)).toString();
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void whenNDaysAddedToGivenDate() {
		String expected = "30/8/2020";
		String actual =  object.addNDays(new DateTime(23,8,2020), 7).toString();
		Assertions.assertEquals(expected, actual);
		
	}
	@Test 
	public void whenNDaysSubtractedToGivenDate() {
		String expected = "16/8/2020";
		String actual =  object.subtractNDays(new DateTime(23,8,2020), 7).toString();
		Assertions.assertEquals(expected, actual);
		
	}
	@Test 
	public void whenNWeeksAddedToGivenDate() {
		String expected = "30/8/2020";
		String actual =  object.addNWeeks(new DateTime(23,8,2020), 1).toString();
		Assertions.assertEquals(expected, actual);
		
	}
	
	@Test 
	public void whenNWeeksSubtractedToGivenDate() {
		String expected = "16/8/2020";
		String actual =  object.subtractNWeeks(new DateTime(23,8,2020), 1).toString();
		Assertions.assertEquals(expected, actual);
	}

	@Test 
	public void whenNMonthsAddedToGivenDate() {
		String expected = "23/9/2020";
		String actual =  object.addNMonths(new DateTime(23,8,2020), 1).toString();
		Assertions.assertEquals(expected, actual);
	}
	@Test 
	public void whenNMonthsSubtractedToGivenDate() {
		String expected = "23/7/2020";
		String actual =  object.subtractNMonths(new DateTime(23,8,2020), 1).toString();
		Assertions.assertEquals(expected, actual);
	}
	@Test 
	public void whenNYearsAddedToGivenDate() {
		String expected = "23/8/2021";
		String actual =  object.addNYears(new DateTime(23,8,2020), 1).toString();
		Assertions.assertEquals(expected, actual);
	}
	@Test 
	public void whenNYearsSubtractedToGivenDate() {
		String expected = "23/8/2019";
		String actual =  object.subtractNYears(new DateTime(23,8,2020), 1).toString();
		Assertions.assertEquals(expected, actual);
		
	}
	@Test
	public void determiningDayForGivenDate() {
		Assertions.assertEquals("Sunday", object.determineDayOfWeek(new DateTime(23,8,2020)));
	}
	@Test
	public void determingNumberofWeekForGivenDate() {
		Assertions.assertEquals(35, object.determineWeekOfYear(new DateTime(23,8,2020)));
	}
	
	
	
	
	@AfterEach
	public void destroyObject() {
		object = null;
	}
}
