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

class EquivalencePartitionTests {

	@Test // Inclusion Date > Invoice Date
	void pe_test1() throws ParseException {
		Exception exception = assertThrows(InvocationTargetException.class, () -> {
			Client c1 = new Client("Mano Max", "10/10/2023", "GO"); // Client (name, inclusion date, estate)		
			
			new Invoice(1, 1000.00, "10/08/2023", c1); // Invoice (code, value, date, client)
		});
		
		assertEquals("Inclusion Date is after the Invoice Date.", exception.getMessage());
	}

	@Test // value <= 0
	void pe_test2() throws ParseException {
		Exception exception = assertThrows(InvocationTargetException.class, () -> {
			Client c1 = new Client("Mano Max", "10/05/2023", "AM"); // Client (name, inclusion date, estate)		
			
			new Invoice(1, -1.00, "10/10/2023", c1); // Invoice (code, value, date, client)
		});
		
		assertEquals("Value of invoice is less than or equals to zero.", exception.getMessage());
		
		Exception exception2 = assertThrows(InvocationTargetException.class, () -> {
			Client c1 = new Client("Mano Max", "10/05/2023", "AM"); // Client (name, inclusion date, estate)		
			
			new Invoice(1, 0.00, "10/10/2023", c1); // Invoice (code, value, date, client)
		});
		
		assertEquals("Value of invoice is less than or equals to zero.", exception2.getMessage());
	}
	
	@Test // value < 2000
	void pe_test3() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", getToday(), "SC"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 1000.00, getToday(), c1); // Invoice (code, value, date, client)
		
		invoices[0] = i1c1;

		Invoice[] expectedInvoices = new Invoice[1];
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // (2000 <= value <= 2500) AND ((actually date - 1 month) <= invoice date)
	void pe_test4() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", getUpdatedMonthsOfTodayToString(-5), "AM"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 2250.00, getUpdatedMonthsOfTodayToString(-1), c1); // Invoice (code, value, date, client)

		invoices[0] = i1c1;
		
		Invoice[] expectedInvoices = new Invoice[1];
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // (2000 <= value <= 2500) AND ((actually date - 1 month) > invoice date)
	void pe_test5() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", getUpdatedMonthsOfTodayToString(-5), "AM"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 2250.00, getUpdatedDaysOfTodayToString(-1), c1); // Invoice (code, value, date, client)

		invoices[0] = i1c1;
		
		Invoice[] expectedInvoices = new Invoice[1];
		
		expectedInvoices[0] = i1c1;
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // (value > 2500) AND ((actually date - 1 month) <= invoice date)
	void pe_test6() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", getUpdatedMonthsOfTodayToString(-5), "SC"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 3000.00, getUpdatedMonthsOfTodayToString(-1), c1); // Invoice (code, value, date, client)

		invoices[0] = i1c1;
		
		Invoice[] expectedInvoices = new Invoice[1];
		
		expectedInvoices[0] = i1c1;
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // (value > 2500) AND ((actually date - 1 month) > invoice date)
	void pe_test7() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", getUpdatedMonthsOfTodayToString(-5), "AM"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 3000.00, getUpdatedMonthsOfTodayToString(-2), c1); // Invoice (code, value, date, client)

		invoices[0] = i1c1;
		
		Invoice[] expectedInvoices = new Invoice[1];
		
		expectedInvoices[0] = i1c1;
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // (2500 <= value <= 3000) AND ((actually date - 2 months) <= invoice date)
	void pe_test8() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", getUpdatedMonthsOfTodayToString(-5), "AM"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 2750.00, getUpdatedMonthsOfTodayToString(-2), c1); // Invoice (code, value, date, client)

		invoices[0] = i1c1;
		
		Invoice[] expectedInvoices = new Invoice[1];
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // (2500 <= value <= 3000) AND ((actually date - 2 months) > invoice date)
	void pe_test9() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", getUpdatedMonthsOfTodayToString(-5), "SC"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 2750.00, getUpdatedDaysOfTodayToString(-2), c1); // Invoice (code, value, date, client)

		invoices[0] = i1c1;
		
		Invoice[] expectedInvoices = new Invoice[1];
		
		expectedInvoices[0] = i1c1;
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // (value > 3000) AND ((actually date - 2 months) <= invoice date)
	void pe_test10() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", getUpdatedMonthsOfTodayToString(-5), "GO"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 3500.00, getUpdatedMonthsOfTodayToString(-2), c1); // Invoice (code, value, date, client)

		invoices[0] = i1c1;
		
		Invoice[] expectedInvoices = new Invoice[1];
		
		expectedInvoices[0] = i1c1;
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // (value > 3000) AND ((actually date - 2 months) > invoice date)
	void pe_test11() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", getUpdatedMonthsOfTodayToString(-5), "AM"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 3500.00, getUpdatedDaysOfTodayToString(-2), c1); // Invoice (code, value, date, client)

		invoices[0] = i1c1;
		
		Invoice[] expectedInvoices = new Invoice[1];
		
		expectedInvoices[0] = i1c1;
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // (value > 4000) AND (south region)
	void pe_test12() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", getUpdatedMonthsOfTodayToString(-5), "SC"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 4500.00, getUpdatedMonthsOfTodayToString(-2), c1); // Invoice (code, value, date, client)

		invoices[0] = i1c1;
		
		Invoice[] expectedInvoices = new Invoice[1];
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // (value > 4000) AND (not south region)
	void pe_test13() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", getUpdatedMonthsOfTodayToString(-5), "AM"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 4500.00, getUpdatedMonthsOfTodayToString(-2), c1); // Invoice (code, value, date, client)

		invoices[0] = i1c1;
		
		Invoice[] expectedInvoices = new Invoice[1];
		
		expectedInvoices[0] = i1c1;
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // (value <= 4000) AND (south region)
	void pe_test14() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", getUpdatedMonthsOfTodayToString(-5), "SC"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 3500.00, getUpdatedMonthsOfTodayToString(-2), c1); // Invoice (code, value, date, client)

		invoices[0] = i1c1;
		
		Invoice[] expectedInvoices = new Invoice[1];
		
		expectedInvoices[0] = i1c1;
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test // (value <= 4000) AND (not south region)
	void pe_test15() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", getUpdatedMonthsOfTodayToString(-5), "GO"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 3500.00, getUpdatedMonthsOfTodayToString(-2), c1); // Invoice (code, value, date, client)

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