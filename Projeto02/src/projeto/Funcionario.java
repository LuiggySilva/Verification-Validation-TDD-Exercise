package projeto;

public class Funcionario {

	private String nome;
	private String email;
	private double salario;
	private CargoENUM cargo;

	public Funcionario(String nome, String email, double salario, CargoENUM cargo) {
		this.setNome(nome);
		this.setEmail(email);
		this.setSalario(salario);
		this.setCargo(cargo);
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		if (nome == "") {
			throw new IllegalArgumentException("Nome do funcionário vazio!");
		}
		this.nome = nome;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		if (email == "") {
			throw new IllegalArgumentException("Email do funcionário vazio!");
		}
		this.email = email;
	}

	public double getSalario() {
		return this.salario;
	}

	public void setSalario(double salario) {
		if (salario <= 0) {
			throw new IllegalArgumentException("Salário do funcionário menor ou igual a zero!");
		}
		this.salario = salario;
	}

	public String getCargo() {
		return this.cargo != null ? this.cargo.getCargo() : null;
	}

	public void setCargo(CargoENUM cargo) {
		this.cargo = cargo;
	}

	public double getSalarioLiquido() {
		double salarioLiquido = this.salario;
		double desconto = 0;
		
		switch (this.cargo) {
			case DESENVOLVEDOR: {
				if (this.salario < DescontoENUM.DESENVOLVEDOR_LIMITE_SALARIO_DESCONTO.getValor()) {
					desconto = this.salario * DescontoENUM.DESENVOLVEDOR_MENOR_DESCONTO.getValor();
				} else {
					desconto = this.salario * DescontoENUM.DESENVOLVEDOR_MAIOR_DESCONTO.getValor();					
				}
				salarioLiquido -= desconto;
				break;
			}
			case DBA: {
				if (this.salario < DescontoENUM.DBA_LIMITE_SALARIO_DESCONTO.getValor()) {
					desconto = this.salario * DescontoENUM.DBA_MENOR_DESCONTO.getValor();
				} else {
					desconto = this.salario * DescontoENUM.DBA_MAIOR_DESCONTO.getValor();					
				}
				salarioLiquido -= desconto;
				break;
			}
			case TESTADOR: {
				if (this.salario < DescontoENUM.TESTADOR_LIMITE_SALARIO_DESCONTO.getValor()) {
					desconto = this.salario * DescontoENUM.TESTADOR_MENOR_DESCONTO.getValor();
				} else {
					desconto = this.salario * DescontoENUM.TESTADOR_MAIOR_DESCONTO.getValor();					
				}
				salarioLiquido -= desconto;
				break;
			}
			case GERENTE: {
				if (this.salario < DescontoENUM.GERENTE_LIMITE_SALARIO_DESCONTO.getValor()) {
					desconto = this.salario * DescontoENUM.GERENTE_MENOR_DESCONTO.getValor();
				} else {
					desconto = this.salario * DescontoENUM.GERENTE_MAIOR_DESCONTO.getValor();					
				}
				salarioLiquido -= desconto;
				break;
			}
			default : {
				desconto = 0;
				salarioLiquido -= desconto;
			}
		}
		
		return salarioLiquido;
	}

}
