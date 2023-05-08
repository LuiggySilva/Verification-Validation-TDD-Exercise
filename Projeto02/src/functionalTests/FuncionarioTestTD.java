package functionalTests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import projeto.CargoENUM;
import projeto.Funcionario;

class FuncionarioTestTD {

	@Test
	void test01() {
		double salario = 1000.0;
		CargoENUM cargo = CargoENUM.DESENVOLVEDOR;
		
		Funcionario funcionario = new Funcionario("Luiggy", "luiggy@email.com", salario, cargo);

		assertEquals("ERRO: getSalario()", 900.0, funcionario.getSalarioLiquido(), 0.0);
	}

	@Test
	void test02() {
		double salario = 4500.0;
		CargoENUM cargo = CargoENUM.DESENVOLVEDOR;
		
		Funcionario funcionario = new Funcionario("Luiggy", "luiggy@email.com", salario, cargo);

		assertEquals("ERRO: getSalario()", 3600.0, funcionario.getSalarioLiquido(), 0.0);
	}

	@Test
	void test03() {
		double salario = 8000.0;
		CargoENUM cargo = CargoENUM.DESENVOLVEDOR;
		
		Funcionario funcionario = new Funcionario("Luiggy", "luiggy@email.com", salario, cargo);

		assertEquals("ERRO: getSalario()", 6400.0, funcionario.getSalarioLiquido(), 0.0);
	}
	
	
	
	
	@Test
	void test04() {
		double salario = 1000.0;
		CargoENUM cargo = CargoENUM.DBA;
		
		Funcionario funcionario = new Funcionario("Luiggy", "luiggy@email.com", salario, cargo);

		assertEquals("ERRO: getSalario()", 850.0, funcionario.getSalarioLiquido(), 0.0);
	}

	@Test
	void test05() {
		double salario = 3000.0;
		CargoENUM cargo = CargoENUM.DBA;
		
		Funcionario funcionario = new Funcionario("Luiggy", "luiggy@email.com", salario, cargo);

		assertEquals("ERRO: getSalario()", 2250.0, funcionario.getSalarioLiquido(), 0.0);
	}

	@Test
	void test06() {
		double salario = 6000.0;
		CargoENUM cargo = CargoENUM.DBA;
		
		Funcionario funcionario = new Funcionario("Luiggy", "luiggy@email.com", salario, cargo);

		assertEquals("ERRO: getSalario()", 4500.0, funcionario.getSalarioLiquido(), 0.0);
	}
	
	
	
	
	@Test
	void test07() {
		double salario = 1000.0;
		CargoENUM cargo = CargoENUM.TESTADOR;
		
		Funcionario funcionario = new Funcionario("Luiggy", "luiggy@email.com", salario, cargo);

		assertEquals("ERRO: getSalario()", 850.0, funcionario.getSalarioLiquido(), 0.0);
	}

	@Test
	void test08() {
		double salario = 3000.0;
		CargoENUM cargo = CargoENUM.TESTADOR;
		
		Funcionario funcionario = new Funcionario("Luiggy", "luiggy@email.com", salario, cargo);

		assertEquals("ERRO: getSalario()", 2250.0, funcionario.getSalarioLiquido(), 0.0);
	}

	@Test
	void test09() {
		double salario = 6000.0;
		CargoENUM cargo = CargoENUM.TESTADOR;
		
		Funcionario funcionario = new Funcionario("Luiggy", "luiggy@email.com", salario, cargo);

		assertEquals("ERRO: getSalario()", 4500.0, funcionario.getSalarioLiquido(), 0.0);
	}
	
	
	
	
	@Test
	void test10() {
		double salario = 1000.0;
		CargoENUM cargo = CargoENUM.GERENTE;
		
		Funcionario funcionario = new Funcionario("Luiggy", "luiggy@email.com", salario, cargo);

		assertEquals("ERRO: getSalario()", 800.0, funcionario.getSalarioLiquido(), 0.0);
	}

	@Test
	void test11() {
		double salario = 8000.0;
		CargoENUM cargo = CargoENUM.GERENTE;
		
		Funcionario funcionario = new Funcionario("Luiggy", "luiggy@email.com", salario, cargo);

		assertEquals("ERRO: getSalario()", 5600.0, funcionario.getSalarioLiquido(), 0.0);
	}

}
