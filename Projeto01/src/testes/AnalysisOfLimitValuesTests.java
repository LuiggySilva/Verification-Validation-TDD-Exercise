package testes;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

import projeto.Client;
import projeto.Filter;
import projeto.Invoice;

class AnalysisOfLimitValuesTests {

	@Test // value <= 0
	void test1() throws ParseException, InvocationTargetException {
		Exception exception2 = assertThrows(InvocationTargetException.class, () -> {
			Client c1 = new Client("Mano Max", this.getToday(), "AM"); // Client (name, inclusion date, estate)		
			
			new Invoice(1, 0.00, this.getToday(), c1); // Invoice (code, value, date, client)
		});
		
		assertEquals("Value of invoice is less than or equals to zero.", exception2.getMessage());
	}
	
	@Test // value <= 0
	void test2() throws ParseException, InvocationTargetException {
		Exception exception2 = assertThrows(InvocationTargetException.class, () -> {
			Client c1 = new Client("Mano Max", this.getToday(), "AM"); // Client (name, inclusion date, estate)		
			
			new Invoice(1, -1.00, this.getToday(), c1); // Invoice (code, value, date, client)
		});
		
		assertEquals("Value of invoice is less than or equals to zero.", exception2.getMessage());
	}
	
	@Test // value < 2000
	void test3() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", this.getToday(), "AM"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 1999.99, this.getToday(), c1); // Invoice (code, value, date, client)
		
		invoices[0] = i1c1;

		Invoice[] expectedInvoices = new Invoice[1];
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // value < 2000
	void test4() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", this.getToday(), "AM"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 1900.00, this.getToday(), c1); // Invoice (code, value, date, client)
		
		invoices[0] = i1c1;

		Invoice[] expectedInvoices = new Invoice[1];
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // value < 2000
	void test5() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", this.getToday(), "AM"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 1000.00, this.getToday(), c1); // Invoice (code, value, date, client)
		
		invoices[0] = i1c1;

		Invoice[] expectedInvoices = new Invoice[1];
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // value < 2000
	void test6() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", this.getToday(), "AM"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 100.00, this.getToday(), c1); // Invoice (code, value, date, client)
		
		invoices[0] = i1c1;

		Invoice[] expectedInvoices = new Invoice[1];
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // value < 2000
	void test7() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", this.getToday(), "AM"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 0.01, this.getToday(), c1); // Invoice (code, value, date, client)
		
		invoices[0] = i1c1;

		Invoice[] expectedInvoices = new Invoice[1];
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // value >= 2000
	void test8() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", this.getToday(), "AM"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 2000.00, this.getToday(), c1); // Invoice (code, value, date, client)
		
		invoices[0] = i1c1;

		Invoice[] expectedInvoices = new Invoice[1];
		
		expectedInvoices[0] = i1c1;
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // (2000 <= value <= 2500) AND ((actually date - 1 mouth) <= invoice date)
	void test9() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", this.getUpdatedMonthsOfTodayToString(-5), "GO"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 2500.00, this.getUpdatedMonthsOfTodayToString(-1), c1); // Invoice (code, value, date, client)
		
		invoices[0] = i1c1;

		Invoice[] expectedInvoices = new Invoice[1];
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // (2000 <= value <= 2500) AND ((actually date - 1 mouth) <= invoice date)
	void test10() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", this.getUpdatedMonthsOfTodayToString(-5), "GO"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 2450.00, this.getUpdatedMonthsOfTodayToString(-1), c1); // Invoice (code, value, date, client)
		
		invoices[0] = i1c1;

		Invoice[] expectedInvoices = new Invoice[1];
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // (2000 <= value <= 2500) AND ((actually date - 1 mouth) <= invoice date)
	void test11() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", this.getUpdatedMonthsOfTodayToString(-5), "GO"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 2250.00, this.getUpdatedMonthsOfTodayToString(-1), c1); // Invoice (code, value, date, client)
		
		invoices[0] = i1c1;

		Invoice[] expectedInvoices = new Invoice[1];
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // (2000 <= value <= 2500) AND ((actually date - 1 mouth) <= invoice date)
	void test12() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", this.getUpdatedMonthsOfTodayToString(-5), "GO"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 2050.00, this.getUpdatedMonthsOfTodayToString(-1), c1); // Invoice (code, value, date, client)
		
		invoices[0] = i1c1;

		Invoice[] expectedInvoices = new Invoice[1];
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // (2000 <= value <= 2500) AND ((actually date - 1 mouth) <= invoice date)
	void test13() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", this.getUpdatedMonthsOfTodayToString(-5), "GO"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 2000.00, this.getUpdatedMonthsOfTodayToString(-1), c1); // Invoice (code, value, date, client)
		
		invoices[0] = i1c1;

		Invoice[] expectedInvoices = new Invoice[1];
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // (value > 2500) AND ((actually date - 1 mouth) <= invoice date)
	void test14() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", this.getUpdatedMonthsOfTodayToString(-1), "GO"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 2500.01, this.getUpdatedDaysOfTodayToString(-10), c1); // Invoice (code, value, date, client)
		
		invoices[0] = i1c1;

		Invoice[] expectedInvoices = new Invoice[1];
		
		expectedInvoices[0] = i1c1;
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // (value > 2500) AND ((actually date - 1 mouth) <= invoice date)
	void test15() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", this.getUpdatedMonthsOfTodayToString(-1), "GO"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 2750.00, this.getUpdatedDaysOfTodayToString(-10), c1); // Invoice (code, value, date, client)
		
		invoices[0] = i1c1;

		Invoice[] expectedInvoices = new Invoice[1];
		
		expectedInvoices[0] = i1c1;
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // (value > 2500) AND ((actually date - 1 mouth) <= invoice date)
	void test16() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", this.getUpdatedMonthsOfTodayToString(-1), "GO"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 2250.00, this.getUpdatedDaysOfTodayToString(-9), c1); // Invoice (code, value, date, client)
		
		invoices[0] = i1c1;

		Invoice[] expectedInvoices = new Invoice[1];
		
		expectedInvoices[0] = i1c1;
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // (value > 2500) AND ((actually date - 1 mouth) <= invoice date)
	void test17() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", this.getUpdatedMonthsOfTodayToString(-1), "GO"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 2250.00, this.getUpdatedDaysOfTodayToString(-8), c1); // Invoice (code, value, date, client)
		
		invoices[0] = i1c1;

		Invoice[] expectedInvoices = new Invoice[1];
		
		expectedInvoices[0] = i1c1;
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // (value > 2500) AND ((actually date - 1 mouth) <= invoice date)
	void test18() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", this.getUpdatedMonthsOfTodayToString(-1), "GO"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 2250.00, this.getUpdatedDaysOfTodayToString(-2), c1); // Invoice (code, value, date, client)
		
		invoices[0] = i1c1;

		Invoice[] expectedInvoices = new Invoice[1];
		
		expectedInvoices[0] = i1c1;
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // (value > 2500) AND ((actually date - 1 mouth) <= invoice date)
	void test19() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", this.getUpdatedMonthsOfTodayToString(-1), "GO"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 3000.00, this.getToday(), c1); // Invoice (code, value, date, client)
		
		invoices[0] = i1c1;

		Invoice[] expectedInvoices = new Invoice[1];
		
		expectedInvoices[0] = i1c1;
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // (2500 <= value <= 3000) AND ((actually date - 1 mouth) <= inclusion date)
	void test20() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", this.getUpdatedMonthsOfTodayToString(-2), "SC"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 2950.00, this.getToday(), c1); // Invoice (code, value, date, client)
		
		invoices[0] = i1c1;

		Invoice[] expectedInvoices = new Invoice[1];
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // (2500 <= value <= 3000) AND ((actually date - 1 mouth) <= inclusion date)
	void test21() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", this.getUpdatedMonthsOfTodayToString(-2), "SC"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 2750.00, this.getToday(), c1); // Invoice (code, value, date, client)
		
		invoices[0] = i1c1;

		Invoice[] expectedInvoices = new Invoice[1];
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // (2500 <= value <= 3000) AND ((actually date - 1 mouth) <= inclusion date)
	void test22() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", this.getUpdatedMonthsOfTodayToString(-2), "SC"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 2550.00, this.getToday(), c1); // Invoice (code, value, date, client)
		
		invoices[0] = i1c1;

		Invoice[] expectedInvoices = new Invoice[1];
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // (2500 <= value <= 3000) AND ((actually date - 1 mouth) <= inclusion date)
	void test23() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", this.getUpdatedMonthsOfTodayToString(-2), "SC"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 2500.00, this.getToday(), c1); // Invoice (code, value, date, client)
		
		invoices[0] = i1c1;

		Invoice[] expectedInvoices = new Invoice[1];
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // (2500 <= value <= 3000) AND ((actually date - 1 mouth) <= inclusion date)
	void test24() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", this.getUpdatedMonthsOfTodayToString(-2), "SC"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 3000.01, this.getToday(), c1); // Invoice (code, value, date, client)
		
		invoices[0] = i1c1;

		Invoice[] expectedInvoices = new Invoice[1];
		
		expectedInvoices[0] = i1c1;
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // (value > 3000) AND ((actually date - 1 mouth) <= inclusion date)
	void test25() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", this.getUpdatedMonthsOfTodayToString(-2), "SC"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 3250.00, this.getToday(), c1); // Invoice (code, value, date, client)
		
		invoices[0] = i1c1;

		Invoice[] expectedInvoices = new Invoice[1];
		
		expectedInvoices[0] = i1c1;
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // (value > 3000) AND ((actually date - 1 mouth) > inclusion date)
	void test26() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", this.getUpdatedDaysOfTodayToString(-59), "SC"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 3250.00, this.getToday(), c1); // Invoice (code, value, date, client)
		
		invoices[0] = i1c1;

		Invoice[] expectedInvoices = new Invoice[1];
		
		expectedInvoices[0] = i1c1;
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // (value > 3000) AND ((actually date - 1 mouth) > inclusion date)
	void test27() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", this.getUpdatedDaysOfTodayToString(-51), "SC"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 3250.00, this.getToday(), c1); // Invoice (code, value, date, client)
		
		invoices[0] = i1c1;

		Invoice[] expectedInvoices = new Invoice[1];
		
		expectedInvoices[0] = i1c1;
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // (value > 3000) AND ((actually date - 1 mouth) > inclusion date)
	void test28() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", this.getUpdatedMonthsOfTodayToString(-3), "SC"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 3250.00, this.getToday(), c1); // Invoice (code, value, date, client)
		
		invoices[0] = i1c1;

		Invoice[] expectedInvoices = new Invoice[1];
		
		expectedInvoices[0] = i1c1;
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // (value > 4000) AND (south region)
	void test29() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", this.getUpdatedMonthsOfTodayToString(-2), "SC"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 4000.01, this.getToday(), c1); // Invoice (code, value, date, client)
		
		invoices[0] = i1c1;

		Invoice[] expectedInvoices = new Invoice[1];
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // (value > 4000) AND (south region)
	void test30() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", this.getUpdatedMonthsOfTodayToString(-2), "SC"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 4250.00, this.getToday(), c1); // Invoice (code, value, date, client)
		
		invoices[0] = i1c1;

		Invoice[] expectedInvoices = new Invoice[1];
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // (value > 4000) AND (south region)
	void test31() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", this.getUpdatedMonthsOfTodayToString(-2), "SC"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 4750.00, this.getToday(), c1); // Invoice (code, value, date, client)
		
		invoices[0] = i1c1;

		Invoice[] expectedInvoices = new Invoice[1];
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // (value > 4000) AND (south region)
	void test32() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", this.getUpdatedMonthsOfTodayToString(-2), "SC"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 4000.00, this.getToday(), c1); // Invoice (code, value, date, client)
		
		invoices[0] = i1c1;

		Invoice[] expectedInvoices = new Invoice[1];
		
		expectedInvoices[0] = i1c1;
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // (value > 4000) AND (south region)
	void test33() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", this.getUpdatedMonthsOfTodayToString(-2), "SC"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 3950.00, this.getToday(), c1); // Invoice (code, value, date, client)
		
		invoices[0] = i1c1;

		Invoice[] expectedInvoices = new Invoice[1];
		
		expectedInvoices[0] = i1c1;
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // (value > 4000) AND (south region)
	void test34() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", this.getUpdatedMonthsOfTodayToString(-2), "SC"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 3500.00, this.getToday(), c1); // Invoice (code, value, date, client)
		
		invoices[0] = i1c1;

		Invoice[] expectedInvoices = new Invoice[1];
		
		expectedInvoices[0] = i1c1;
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // (value > 4000) AND (not south region)
	void test35() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", this.getUpdatedMonthsOfTodayToString(-2), "AM"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 4000.01, this.getToday(), c1); // Invoice (code, value, date, client)
		
		invoices[0] = i1c1;

		Invoice[] expectedInvoices = new Invoice[1];
		
		expectedInvoices[0] = i1c1;
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // (value > 4000) AND (not south region)
	void test36() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", this.getUpdatedMonthsOfTodayToString(-2), "AM"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 4250.00, this.getToday(), c1); // Invoice (code, value, date, client)
		
		invoices[0] = i1c1;

		Invoice[] expectedInvoices = new Invoice[1];
		
		expectedInvoices[0] = i1c1;
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // (value > 4000) AND (not south region)
	void test37() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", this.getUpdatedMonthsOfTodayToString(-2), "AM"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 4750.00, this.getToday(), c1); // Invoice (code, value, date, client)
		
		invoices[0] = i1c1;

		Invoice[] expectedInvoices = new Invoice[1];
		
		expectedInvoices[0] = i1c1;
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // (value < 4000) AND (not south region)
	void test38() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", this.getUpdatedMonthsOfTodayToString(-2), "AM"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 3500.00, this.getToday(), c1); // Invoice (code, value, date, client)
		
		invoices[0] = i1c1;

		Invoice[] expectedInvoices = new Invoice[1];
		
		expectedInvoices[0] = i1c1;
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}

	private String getToday() {
		Date date = Calendar.getInstance().getTime();
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");  
		String today = dateFormat.format(date);
		return today;
	}

	private String getUpdatedMonthsOfTodayToString(Integer months) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, months);
		Date result = cal.getTime();
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");  
		String date = dateFormat.format(result);
		return date;
	}
	
	private String getUpdatedDaysOfTodayToString(Integer days) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_WEEK, days);
		Date result = cal.getTime();
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");  
		String date = dateFormat.format(result);
		return date;
	}
}
