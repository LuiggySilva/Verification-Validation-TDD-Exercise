package projeto;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Invoice {

	private Integer code;
	private double value;
	private Date date;
	private Client client;
	
	public Invoice() {
        super();
    }
	
	public Invoice(Integer code, double value, String date, Client client) throws ParseException, InvocationTargetException {
		Date parsedDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
		
		this.verifyInstanceVariables(parsedDate, client, value);
		
		this.date = parsedDate;
        this.code = code;
        this.value = value;
        this.client = client;
    }
	
	public void verifyInstanceVariables(Date invoiceDate, Client client, double value) throws InvocationTargetException {
		if (inclusionDateIsAfterToInvoiceDate(invoiceDate, client))		
			throw new InvocationTargetException(null, "Inclusion Date is after the Invoice Date.");
		
		else if (invoiceValueIsLessThanOrEqualsToZero(value))
			throw new InvocationTargetException(null, "Value of invoice is less than or equals to zero.");
	}
	
	private boolean invoiceValueIsLessThanOrEqualsToZero(double value) {
		return value <= 0;
	}

	private boolean inclusionDateIsAfterToInvoiceDate(Date invoiceDate, Client client) {
		return client.getInclusion().after(invoiceDate);
	}

	public Integer getCode() {
		return this.code;
	}
	
	public double getValue() {
		return this.value;
	}
	
	public Date getDate() {
		return this.date;
	}

	public Client getClient() {
		return this.client;
	}
	
	public String toString() {
		return this.client.getName() + " (code: " + this.getCode() + ") - Value: " + this.getValue();
	}
}
