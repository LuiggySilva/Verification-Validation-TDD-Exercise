package testes;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

import projeto.Client;
import projeto.Filter;
import projeto.Invoice;

class DecisionTableTests {

	@Test
	void test1() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", this.getDateWithMonthSetFromToday(-1), "SC"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 1000.00, this.getToday(), c1); // Invoice (code, value, date, client)

		invoices[0] = i1c1;
		
		Invoice[] expectedInvoices = new Invoice[1];
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}

	@Test
	void test2() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", this.getDateWithMonthSetFromToday(-1), "AM"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 2250.00, this.getDateWithMonthSetFromToday(-1), c1); // Invoice (code, value, date, client)

		invoices[0] = i1c1;
		
		Invoice[] expectedInvoices = new Invoice[1];
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test
	void test3() throws ParseException, InvocationTargetException {
		Client c1 = new Client("Mano Max", this.getDateWithMonthSetFromToday(-2), "GO"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 2250.00, this.getDateWithMonthSetFromToday(-1), c1); // Invoice (code, value, date, client)

		invoices[0] = i1c1;
		
		Invoice[] expectedInvoices = new Invoice[1];
		
		expectedInvoices[0] = i1c1;
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test
	void test4() throws ParseException, InvocationTargetException {
		
		Client c1 = new Client("Mano Max", this.getDateWithMonthSetFromToday(-2), "SC"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 2750.00, this.getToday(), c1); // Invoice (code, value, date, client)

		invoices[0] = i1c1;
		
		Invoice[] expectedInvoices = new Invoice[1];
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test
	void test5() throws ParseException, InvocationTargetException {
		
		Client c1 = new Client("Mano Max", this.getDateWithMonthSetFromToday(-3), "AM"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 2750.00, this.getToday(), c1); // Invoice (code, value, date, client)

		invoices[0] = i1c1;
		
		Invoice[] expectedInvoices = new Invoice[1];
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test
	void test6() throws ParseException, InvocationTargetException {
		
		Client c1 = new Client("Mano Max", this.getToday(), "SC"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 4500.00, this.getToday(), c1); // Invoice (code, value, date, client)

		invoices[0] = i1c1;
		
		Invoice[] expectedInvoices = new Invoice[1];
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test
	void test7() throws ParseException, InvocationTargetException {
		
		Client c1 = new Client("Mano Max", this.getToday(), "AM"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[1];
		
		Invoice i1c1 = new Invoice(1, 4500.00, this.getToday(), c1); // Invoice (code, value, date, client)

		invoices[0] = i1c1;
		
		Invoice[] expectedInvoices = new Invoice[1];
		
		expectedInvoices[0] = i1c1;
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	private String getToday() {
		Date today = Calendar.getInstance().getTime();
		return this.getFormatedDate(today);
	}

	private String getDateWithMonthSetFromToday(Integer months) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, months);
		Date result = cal.getTime();
		
		return this.getFormatedDate(result);
	}
	
	private String getDateWithDaysSetFromToday(Integer days) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_WEEK, days);
		Date result = cal.getTime();
		
		return this.getFormatedDate(result);
	}
	
	private String getFormatedDate(Date date) {
		return new SimpleDateFormat("dd/MM/YYYY").format(date);
	}
}
