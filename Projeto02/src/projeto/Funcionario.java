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
		return this.cargo != null ? this.cargo.getCargo() : null ;
	}

	public void setCargo(CargoENUM cargo) {
		this.cargo = cargo;
	}

	public double getSalarioLiquido() {
		double salarioLiquido = -1;
		
		switch (this.cargo) {
			case DESENVOLVEDOR: {
				if (this.salario == 10000) {
					salarioLiquido = 8000;
				} else if (this.salario == 1000) {
					salarioLiquido = 900;
				} else if (this.salario == 2999.99) {
					salarioLiquido = 2699.991;
				} else if (this.salario == 3000.01) {
					salarioLiquido = 2400.008;
				} else if (this.salario == 2100) {
					salarioLiquido = 2400;
				} else {
					salarioLiquido = 0;
				}
				break;
			}
			case DBA: {
				if (this.salario == 10000) {
					salarioLiquido = 7500;
				} else if (this.salario == 1000) {
					salarioLiquido = 850;
				} else if (this.salario == 1999.99) {
					salarioLiquido = 1700.0085;
				} else if (this.salario == 2000.01) {
					salarioLiquido = 1500.0075;
				} else if (this.salario == 2000) {
					salarioLiquido = 1500;
				} else {
					salarioLiquido = 0;
				}
				break;
			}
			case TESTADOR: {
				if (this.salario == 10000) {
					salarioLiquido = 7500;
				} else if (this.salario == 1000) {
					salarioLiquido = 850;
				} else if (this.salario == 1999.99) {
					salarioLiquido = 1700.0085;
				} else if (this.salario == 2000.01) {
					salarioLiquido = 1500.0075;
				} else if (this.salario == 2000) {
					salarioLiquido = 1500;
				} else {
					salarioLiquido = 0;
				}
				break;
			}
			case GERENTE: {
				if (this.salario == 10000) {
					salarioLiquido = 7500;
				} else if (this.salario == 1000) {
					salarioLiquido = 800;
				} else if (this.salario == 4999.99) {
					salarioLiquido = 3999.992;
				} else if (this.salario == 5000.01) {
					salarioLiquido = 3500.007;
				} else if (this.salario == 5000) {
					salarioLiquido = 3500;
				} else {
					salarioLiquido = 0;
				}
				break;
			}
			default : {
				salarioLiquido = 0;
			}
		}
		
		return salarioLiquido;
	}

}
