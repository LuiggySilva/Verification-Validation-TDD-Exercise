package projeto;
import java.text.ParseException;

public class Main {

	public static void main(String[] args) throws ParseException {
		Invoice[] invoices = new Invoice[20];
				
		// Cliente (nome, data de inclusao, estado)
		Client c1 = new Client("Mano Max", "01/01/2023", "PB");
		
		// Fatura (codigo, valor, data, Cliente)
		Invoice i1c1 = new Invoice(1, 1000, "01/02/2023", c1);
		Invoice i2c1 = new Invoice(2, 2000, "02/02/2023", c1);
		Invoice i3c1 = new Invoice(3, 3000, "03/02/2023", c1);
		Invoice i4c1 = new Invoice(4, 4000, "04/02/2023", c1);
		
		invoices[1] = i1c1;
		invoices[2] = i2c1;
		invoices[3] = i3c1;
		invoices[4] = i4c1;
	}

}
