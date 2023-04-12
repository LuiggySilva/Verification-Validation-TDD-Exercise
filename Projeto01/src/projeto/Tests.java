package projeto;

import static org.junit.Assert.assertArrayEquals;

import java.util.Date;
import java.text.ParseException;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;  

import org.junit.jupiter.api.Test;

class Tests {

	@Test
	public void lessThen2000() throws ParseException {
		Client c1 = new Client("Mano Max", "01/01/2023", "PB"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[3];
		
		Invoice i1c1 = new Invoice(1, 1000.00, "01/02/2023", c1); // Invoice (code, value, date, client)
		Invoice i2c1 = new Invoice(2, 2000.00, "02/02/2023", c1);
		Invoice i3c1 = new Invoice(3, 3000.00, "03/02/2023", c1);
		
		invoices[0] = i1c1;
		invoices[1] = i2c1;
		invoices[2] = i3c1;
		
		Invoice[] expectedInvoices = new Invoice[3];
		expectedInvoices[1] = i2c1;
		expectedInvoices[2] = i3c1;
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test
	public void biggerThen2000andLessThen2500andLessOrEqualOneMonth() throws ParseException {
		Client c1 = new Client("Mano Max", "01/01/2023", "PB"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[9];
		
		Invoice i1c1 = new Invoice(1, 2250.00, getUpdatedMonthsOfTodayToString(-2), c1); // Invoice (code, value, date, client)
		Invoice i2c1 = new Invoice(2, 2250.00, getUpdatedMonthsOfTodayToString(-1), c1);
		Invoice i3c1 = new Invoice(3, 2250.00, getUpdatedDaysOfTodayToString(-2), c1);
		Invoice i4c1 = new Invoice(4, 2250.00, getUpdatedDaysOfTodayToString(-1), c1);
		Invoice i5c1 = new Invoice(5, 2250.00, getToday(), c1);
		Invoice i6c1 = new Invoice(6, 2250.00, getUpdatedDaysOfTodayToString(1), c1);
		Invoice i7c1 = new Invoice(7, 2250.00, getUpdatedDaysOfTodayToString(2), c1);
		Invoice i8c1 = new Invoice(8, 2250.00, getUpdatedMonthsOfTodayToString(1), c1);
		Invoice i9c1 = new Invoice(9, 2250.00, getUpdatedMonthsOfTodayToString(2), c1);
		
		invoices[0] = i1c1;
		invoices[1] = i2c1;
		invoices[2] = i3c1;
		invoices[3] = i4c1;
		invoices[4] = i5c1;
		invoices[5] = i6c1;
		invoices[6] = i7c1;
		invoices[7] = i8c1;
		invoices[8] = i9c1;
		
		Invoice[] expectedInvoices = new Invoice[9];
		expectedInvoices[2] = i3c1;
		expectedInvoices[3] = i4c1;
		expectedInvoices[4] = i5c1;
		expectedInvoices[5] = i6c1;
		expectedInvoices[6] = i7c1;
		expectedInvoices[7] = i8c1;
		expectedInvoices[8] = i9c1;
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test
	public void biggerThen2500andLessThen3000andLessOrEqualTwoMonth() throws ParseException {
		Client c1 = new Client("Mano Max", "01/01/2023", "PB"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[9];
		
		Invoice i1c1 = new Invoice(1, 2750.00, getUpdatedMonthsOfTodayToString(-3), c1); // Invoice (code, value, date, client)
		Invoice i2c1 = new Invoice(2, 2750.00, getUpdatedMonthsOfTodayToString(-2), c1);
		Invoice i3c1 = new Invoice(3, 2750.00, getUpdatedDaysOfTodayToString(-2), c1);
		Invoice i4c1 = new Invoice(4, 2750.00, getUpdatedDaysOfTodayToString(-1), c1);
		Invoice i5c1 = new Invoice(5, 2750.00, getToday(), c1);
		Invoice i6c1 = new Invoice(6, 2750.00, getUpdatedDaysOfTodayToString(1), c1);
		Invoice i7c1 = new Invoice(7, 2750.00, getUpdatedDaysOfTodayToString(2), c1);
		Invoice i8c1 = new Invoice(8, 2750.00, getUpdatedMonthsOfTodayToString(2), c1);
		Invoice i9c1 = new Invoice(9, 2750.00, getUpdatedMonthsOfTodayToString(3), c1);
		
		invoices[0] = i1c1;
		invoices[1] = i2c1;
		invoices[2] = i3c1;
		invoices[3] = i4c1;
		invoices[4] = i5c1;
		invoices[5] = i6c1;
		invoices[6] = i7c1;
		invoices[7] = i8c1;
		invoices[8] = i9c1;
		
		Invoice[] expectedInvoices = new Invoice[9];
		expectedInvoices[2] = i3c1;
		expectedInvoices[3] = i4c1;
		expectedInvoices[4] = i5c1;
		expectedInvoices[5] = i6c1;
		expectedInvoices[6] = i7c1;
		expectedInvoices[7] = i8c1;
		expectedInvoices[8] = i9c1;
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test
	public void biggerThen4000andIsSouthernStatest() throws ParseException {
		Client c1 = new Client("Mano Max", "01/01/2023", "SC"); // Client (name, inclusion date, estate)		
		
		Invoice[] invoices = new Invoice[5];
		
		Invoice i1c1 = new Invoice(1, 3500.00, getUpdatedMonthsOfTodayToString(-3), c1); // Invoice (code, value, date, client)
		Invoice i2c1 = new Invoice(2, 3999.99, getUpdatedMonthsOfTodayToString(-2), c1);
		Invoice i3c1 = new Invoice(3, 4000.00, getUpdatedDaysOfTodayToString(-2), c1);
		Invoice i4c1 = new Invoice(4, 4000.01, getUpdatedDaysOfTodayToString(-1), c1);
		Invoice i5c1 = new Invoice(5, 5000.00, getToday(), c1);
		
		invoices[0] = i1c1;
		invoices[1] = i2c1;
		invoices[2] = i3c1;
		invoices[3] = i4c1;
		invoices[4] = i5c1;
		
		Invoice[] expectedInvoices = new Invoice[5];
		expectedInvoices[0] = i1c1;
		expectedInvoices[1] = i2c1;
		expectedInvoices[2] = i3c1;
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test
	public void moreThenOneClient() throws ParseException {
		Client c1 = new Client("Mano Max", "01/01/2023", "PB"); // Client (name, inclusion date, estate)		
		Client c2 = new Client("Luiggy Silva", "01/01/2022", "PR");
		
		Invoice[] invoices = new Invoice[8];
		
		Invoice i1c1 = new Invoice(1, 3500.00, "01/02/2023", c1); // Invoice (code, value, date, client)
		Invoice i2c1 = new Invoice(2, 3999.99, "01/02/2023", c1);
		Invoice i3c1 = new Invoice(3, 4000.00, "01/02/2023", c1);
		Invoice i4c1 = new Invoice(4, 4000.01, "01/02/2023", c1);
		Invoice i5c1 = new Invoice(5, 5000.00, "01/02/2023", c1);
		
		Invoice i1c2 = new Invoice(1, 1000.00, "01/02/2023", c2);
		Invoice i2c2 = new Invoice(2, 5000.00, "01/02/2023", c2);
		Invoice i3c2 = new Invoice(3, 3500.00, "01/02/2023", c2);
		
		invoices[0] = i1c1;
		invoices[1] = i2c1;
		invoices[2] = i3c1;
		invoices[3] = i4c1;
		invoices[4] = i5c1;
		invoices[5] = i1c2;
		invoices[6] = i2c2;
		invoices[7] = i3c2;
		
		Invoice[] expectedInvoices = new Invoice[8];
		expectedInvoices[0] = i1c1;
		expectedInvoices[1] = i2c1;
		expectedInvoices[2] = i3c1;
		expectedInvoices[3] = i4c1;
		expectedInvoices[4] = i5c1;
		expectedInvoices[7] = i3c2;
		
		Filter filter = new Filter(invoices);
		Invoice[] filteredInvoices = filter.getFilteredInvoices();
		
		assertArrayEquals(filteredInvoices, expectedInvoices);
	}
	
	@Test
	public void noInvoice() throws ParseException {	
		Invoice[] invoices = new Invoice[3];
						
		Invoice[] expectedInvoices = new Invoice[3];
		
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
