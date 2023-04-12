package projeto;

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
	
	public Invoice(Integer code, double value, String date, Client client) throws ParseException {
        super();
        
        this.code = code;
        this.value = value;
        
        SimpleDateFormat parsedDate = new SimpleDateFormat("dd/MM/yyyy");
        this.date = parsedDate.parse(date);

        this.client = client;
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
