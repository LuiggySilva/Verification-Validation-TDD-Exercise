package projeto;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;

public class Filter {

	private Invoice[] filteredInvoices;
	
	public Filter() {
		super();
	}
	
	public Filter(Invoice[] invoices) {
		filteredInvoices = new Invoice[invoices.length];
		
		for (int i = 0; i < invoices.length; i++) {			
			Invoice invoice = invoices[i];
			
			if (invoice == null) continue;
			
			if (valueLessThan(invoice, 2000)) {
				filteredInvoices[i] = null;
				
			} else if (valueInBetween(invoice, 2000, 2500)
					&& dateLessThanOrEqual(invoice, 1)) { // 1 mouth
				filteredInvoices[i] = null;
				
			} else if (valueInBetween(invoice, 2500, 3000)
					&& dateLessThanOrEqual(invoice, 2)) { // 2 mouths
				filteredInvoices[i] = null;
				
			} else if (valueBiggerThan(invoice, 4000)
					&& isSouthernStates(invoice)) {
				filteredInvoices[i] = null;
			} else {
				filteredInvoices[i] = invoice;
			}
	    }
	}
	
	private boolean isSouthernStates(Invoice invoice) {
		String[] southernStates = {"PR", "SC", "RS"};
		return Arrays.asList(southernStates).contains(invoice.getClient().getEstate());
	}

	private boolean dateLessThanOrEqual(Invoice invoice, Integer mouth) {
		LocalDate today = LocalDate.now();
		return invoice.getDate().before(decrementMonths(today, mouth)) ||
				invoice.getDate().equals(decrementMonths(today, mouth));
	}

	private boolean valueBiggerThan(Invoice invoice, int min) {
		return invoice.getValue() > min;
	}

	private boolean valueInBetween(Invoice invoice, int min, int max) {
		return min < invoice.getValue() && invoice.getValue() < max;
	}

	private boolean valueLessThan(Invoice invoice, int max) {
		return invoice.getValue() < max;
	}

	public Date decrementMonths(LocalDate today, Integer months) {
		return Date.from(today.minusMonths(months).atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	public Invoice[] getFilteredInvoices() {
		return this.filteredInvoices;
	}
}
