package functionalTests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import projeto.CargoENUM;
import projeto.Funcionario;

class FuncionarioTestPE {

	// Técnica: Partição de Equivalência
	
	@Test
	void testFuncionarioComCargoInvalido() {
		// Teste com string vazia
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
	           () -> {
	        	   Funcionario funcionario = new Funcionario("funcionario", "funcionario@email.com", 1000.0, CargoENUM.DUMMY);
	           },
	           "ERRO: CARGO INVÁLIDO"
	    );
	    assertTrue(thrown.getMessage().contentEquals("Cargo do funcionário não existe!"));
	}
	
	@Test
	void testFuncionarioDesenvolvedorComSalarioNegativo() {
		// Teste com string vazia
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
	           () -> {
	        	   Funcionario funcionario = new Funcionario("funcionario", "funcionario@email.com", -10, CargoENUM.DESENVOLVEDOR);
	           },
	           "ERRO: SALÁRIO INVÁLIDO"
	    );
	    assertTrue(thrown.getMessage().contentEquals("Salário do funcionário menor ou igual a zero!"));
	}
	
	
	

	@Test
	void testFuncionarioDesenvolvedorSalarioMenor3000() {
		double salario = 1000.0;
		CargoENUM cargo = CargoENUM.DESENVOLVEDOR;
		
		Funcionario funcionario = new Funcionario("Luiggy", "luiggy@email.com", salario, cargo);

		assertEquals("ERRO: getSalario()", 900.0, funcionario.getSalarioLiquido(), 0.0);
	}

	@Test
	void testFuncionarioDesenvolvedorSalarioMaiorOuIgual3000() {
		double salario = 5000.0;
		CargoENUM cargo = CargoENUM.DESENVOLVEDOR;
		
		Funcionario funcionario = new Funcionario("Luiggy", "luiggy@email.com", salario, cargo);

		assertEquals("ERRO: getSalario()", 4000.0, funcionario.getSalarioLiquido(), 0.0);
	}
	
	
	

	@Test
	void testFuncionarioDBASalarioMenor2000() {
		double salario = 1000.0;
		CargoENUM cargo = CargoENUM.DBA;
		
		Funcionario funcionario = new Funcionario("Luiggy", "luiggy@email.com", salario, cargo);

		assertEquals("ERRO: getSalario()", 850.0, funcionario.getSalarioLiquido(), 0.0);
	}

	@Test
	void testFuncionarioDBASalarioMaiorOuIgual2000() {
		double salario = 4000.0;
		CargoENUM cargo = CargoENUM.DBA;
		
		Funcionario funcionario = new Funcionario("Luiggy", "luiggy@email.com", salario, cargo);

		assertEquals("ERRO: getSalario()", 3000.0, funcionario.getSalarioLiquido(), 0.0);
	}
	
	
	

	@Test
	void testFuncionarioTestadorSalarioMenor2000() {
		double salario = 1000.0;
		CargoENUM cargo = CargoENUM.TESTADOR;
		
		Funcionario funcionario = new Funcionario("Luiggy", "luiggy@email.com", salario, cargo);

		assertEquals("ERRO: getSalario()", 850.0, funcionario.getSalarioLiquido(), 0.0);
	}

	@Test
	void testFuncionarioTestadorSalarioMaiorOuIgual2000() {
		double salario = 5000.0;
		CargoENUM cargo = CargoENUM.TESTADOR;
		
		Funcionario funcionario = new Funcionario("Luiggy", "luiggy@email.com", salario, cargo);

		assertEquals("ERRO: getSalario()", 3750.0, funcionario.getSalarioLiquido(), 0.0);
	}
	
	
	

	@Test
	void testFuncionarioGerenteSalarioMenor5000() {
		double salario = 1000.0;
		CargoENUM cargo = CargoENUM.GERENTE;
		
		Funcionario funcionario = new Funcionario("Luiggy", "luiggy@email.com", salario, cargo);

		assertEquals("ERRO: getSalario()", 800.0, funcionario.getSalarioLiquido(), 0.0);
	}

	@Test
	void testFuncionarioGerenteSalarioMaiorOuIgual5000() {
		double salario = 8000.0;
		CargoENUM cargo = CargoENUM.GERENTE;
		
		Funcionario funcionario = new Funcionario("Luiggy", "luiggy@email.com", salario, cargo);

		assertEquals("ERRO: getSalario()", 5600.0, funcionario.getSalarioLiquido(), 0.0);
	}
	
}
