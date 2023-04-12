package projeto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {

	private String name;
	private Date inclusion;
	private String estate;

	public Client() {
        super();
    }
	
	public Client(String name, String inclusion, String estate) throws ParseException {
        super();
        
        this.name = name;
        
        SimpleDateFormat parsedDate = new SimpleDateFormat("dd/MM/yyyy");
        this.inclusion = parsedDate.parse(inclusion);
        
        this.estate = estate;
    }

	public String getName() {
		return this.name;
	}

	public String getEstate() {
		return this.estate;
	}
	
	public Date getInclusion() {
		return this.inclusion;
	}
}
