package functionalTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

import projeto.CargoENUM;
import projeto.Funcionario;

class FuncionarioTestAVL {
	
	// Técnica: Análise de Valores Limite
	
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
	void testFuncionarioDesenvolvedorComSalarioZero() {
		// Teste com string vazia
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
	           () -> {
	        	   Funcionario funcionario = new Funcionario("funcionario", "funcionario@email.com", 0, CargoENUM.DESENVOLVEDOR);
	           },
	           "ERRO: SALÁRIO INVÁLIDO"
	    );
	    assertTrue(thrown.getMessage().contentEquals("Salário do funcionário menor ou igual a zero!"));
	}
	
	@Test
	void testFuncionarioDesenvolvedorSalarioBaixoDesconto10() {
		double salario = 10.0;
		CargoENUM cargo = CargoENUM.DESENVOLVEDOR;
		
		Funcionario funcionario = new Funcionario("Luiggy", "luiggy@email.com", salario, cargo);

		assertEquals("ERRO: getSalario()", 9.0, funcionario.getSalarioLiquido(), 0.0);
	}
	
	@Test
	void testFuncionarioDesenvolvedorSalarioAltoDesconto10() {
		double salario = 2999.99;
		CargoENUM cargo = CargoENUM.DESENVOLVEDOR;
		
		Funcionario funcionario = new Funcionario("Luiggy", "luiggy@email.com", salario, cargo);

		assertEquals("ERRO: getSalario()", 2699.991, funcionario.getSalarioLiquido(), 0.0);
	}
	
	@Test
	void testFuncionarioDesenvolvedorSalarioAltoDesconto20() {
		double salario = 3000.0;
		CargoENUM cargo = CargoENUM.DESENVOLVEDOR;
		
		Funcionario funcionario = new Funcionario("Luiggy", "luiggy@email.com", salario, cargo);

		assertEquals("ERRO: getSalario()", 2400.0, funcionario.getSalarioLiquido(), 0.0);
	}
	
	@Test
	void testFuncionarioDesenvolvedorSalarioUmPoucoMaisAltoDesconto20() {
		double salario = 3000.01;
		CargoENUM cargo = CargoENUM.DESENVOLVEDOR;
		
		Funcionario funcionario = new Funcionario("Luiggy", "luiggy@email.com", salario, cargo);

		assertEquals("ERRO: getSalario()", 2400.008, funcionario.getSalarioLiquido(), 0.008000000003);
	}

	@Test
	void testFuncionarioDesenvolvedorSalarioMuitoAltoDesconto20() {
		double salario = 6000.0;
		CargoENUM cargo = CargoENUM.DESENVOLVEDOR;
		
		Funcionario funcionario = new Funcionario("Luiggy", "luiggy@email.com", salario, cargo);

		assertEquals("ERRO: getSalario()", 4800.00, funcionario.getSalarioLiquido(), 0.0);
	}
	
	
	
	
	@Test
	void testFuncionarioDBAComSalarioNegativo() {
		// Teste com string vazia
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
	           () -> {
	        	   Funcionario funcionario = new Funcionario("funcionario", "funcionario@email.com", -10, CargoENUM.DBA);
	           },
	           "ERRO: SALÁRIO INVÁLIDO"
	    );
	    assertTrue(thrown.getMessage().contentEquals("Salário do funcionário menor ou igual a zero!"));
	}

	@Test
	void testFuncionarioDBAComSalarioZero() {
		// Teste com string vazia
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
	           () -> {
	        	   Funcionario funcionario = new Funcionario("funcionario", "funcionario@email.com", 0, CargoENUM.DBA);
	           },
	           "ERRO: SALÁRIO INVÁLIDO"
	    );
	    assertTrue(thrown.getMessage().contentEquals("Salário do funcionário menor ou igual a zero!"));
	}
	
	@Test
	void testFuncionarioDBASalarioBaixoDesconto15() {
		double salario = 10.0;
		CargoENUM cargo = CargoENUM.DBA;
		
		Funcionario funcionario = new Funcionario("Luiggy", "luiggy@email.com", salario, cargo);

		assertEquals("ERRO: getSalario()", 8.5, funcionario.getSalarioLiquido(), 0.0);
	}
	
	@Test
	void testFuncionarioDBASalarioAltoDesconto15() {
		double salario = 1999.99;
		CargoENUM cargo = CargoENUM.DBA;
		
		Funcionario funcionario = new Funcionario("Luiggy", "luiggy@email.com", salario, cargo);

		assertEquals("ERRO: getSalario()", 1699.9915, funcionario.getSalarioLiquido(), 0.0);
	}
	
	@Test
	void testFuncionarioDBASalarioAltoDesconto25() {
		double salario = 2000.0;
		CargoENUM cargo = CargoENUM.DBA;
		
		Funcionario funcionario = new Funcionario("Luiggy", "luiggy@email.com", salario, cargo);

		assertEquals("ERRO: getSalario()", 1500.0, funcionario.getSalarioLiquido(), 0.0);
	}
	
	@Test
	void testFuncionarioDBASalarioUmPoucoMaisAltoDesconto25() {
		double salario = 2000.01;
		CargoENUM cargo = CargoENUM.DBA;
		
		Funcionario funcionario = new Funcionario("Luiggy", "luiggy@email.com", salario, cargo);

		assertEquals("ERRO: getSalario()", 1500.008, funcionario.getSalarioLiquido(), 0.008000000003);
	}

	@Test
	void testFuncionarioDBASalarioMuitoAltoDesconto25() {
		double salario = 4000.0;
		CargoENUM cargo = CargoENUM.DBA;
		
		Funcionario funcionario = new Funcionario("Luiggy", "luiggy@email.com", salario, cargo);

		assertEquals("ERRO: getSalario()", 3000.0, funcionario.getSalarioLiquido(), 0.0);
	}
	
	
	
	
	@Test
	void testFuncionarioTestadorComSalarioNegativo() {
		// Teste com string vazia
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
	           () -> {
	        	   Funcionario funcionario = new Funcionario("funcionario", "funcionario@email.com", -10, CargoENUM.TESTADOR);
	           },
	           "ERRO: SALÁRIO INVÁLIDO"
	    );
	    assertTrue(thrown.getMessage().contentEquals("Salário do funcionário menor ou igual a zero!"));
	}

	@Test
	void testFuncionarioTestadorComSalarioZero() {
		// Teste com string vazia
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
	           () -> {
	        	   Funcionario funcionario = new Funcionario("funcionario", "funcionario@email.com", 0, CargoENUM.TESTADOR);
	           },
	           "ERRO: SALÁRIO INVÁLIDO"
	    );
	    assertTrue(thrown.getMessage().contentEquals("Salário do funcionário menor ou igual a zero!"));
	}
	
	@Test
	void testFuncionarioTestadorSalarioBaixoDesconto15() {
		double salario = 10.0;
		CargoENUM cargo = CargoENUM.TESTADOR;
		
		Funcionario funcionario = new Funcionario("Luiggy", "luiggy@email.com", salario, cargo);

		assertEquals("ERRO: getSalario()", 8.5, funcionario.getSalarioLiquido(), 0.0);
	}
	
	@Test
	void testFuncionarioTestadorSalarioAltoDesconto15() {
		double salario = 1999.99;
		CargoENUM cargo = CargoENUM.TESTADOR;
		
		Funcionario funcionario = new Funcionario("Luiggy", "luiggy@email.com", salario, cargo);

		assertEquals("ERRO: getSalario()", 1699.9915, funcionario.getSalarioLiquido(), 0.0);
	}
	
	@Test
	void testFuncionarioTestadorSalarioAltoDesconto25() {
		double salario = 2000.0;
		CargoENUM cargo = CargoENUM.TESTADOR;
		
		Funcionario funcionario = new Funcionario("Luiggy", "luiggy@email.com", salario, cargo);

		assertEquals("ERRO: getSalario()", 1500.0, funcionario.getSalarioLiquido(), 0.0);
	}
	
	@Test
	void testFuncionarioTestadorSalarioUmPoucoMaisAltoDesconto25() {
		double salario = 2000.01;
		CargoENUM cargo = CargoENUM.TESTADOR;
		
		Funcionario funcionario = new Funcionario("Luiggy", "luiggy@email.com", salario, cargo);

		assertEquals("ERRO: getSalario()", 1500.008, funcionario.getSalarioLiquido(), 0.008000000003);
	}

	@Test
	void testFuncionarioTestadorSalarioMuitoAltoDesconto25() {
		double salario = 4000.0;
		CargoENUM cargo = CargoENUM.TESTADOR;
		
		Funcionario funcionario = new Funcionario("Luiggy", "luiggy@email.com", salario, cargo);

		assertEquals("ERRO: getSalario()", 3000.0, funcionario.getSalarioLiquido(), 0.0);
	}
	
	
	
	

	@Test
	void testFuncionarioGerenteComSalarioNegativo() {
		// Teste com string vazia
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
	           () -> {
	        	   Funcionario funcionario = new Funcionario("funcionario", "funcionario@email.com", -10, CargoENUM.GERENTE);
	           },
	           "ERRO: SALÁRIO INVÁLIDO"
	    );
	    assertTrue(thrown.getMessage().contentEquals("Salário do funcionário menor ou igual a zero!"));
	}

	@Test
	void testFuncionarioGerenteComSalarioZero() {
		// Teste com string vazia
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
	           () -> {
	        	   Funcionario funcionario = new Funcionario("funcionario", "funcionario@email.com", 0, CargoENUM.GERENTE);
	           },
	           "ERRO: SALÁRIO INVÁLIDO"
	    );
	    assertTrue(thrown.getMessage().contentEquals("Salário do funcionário menor ou igual a zero!"));
	}
	
	@Test
	void testFuncionarioGerenteSalarioBaixoDesconto20() {
		double salario = 10.0;
		CargoENUM cargo = CargoENUM.GERENTE;
		
		Funcionario funcionario = new Funcionario("Luiggy", "luiggy@email.com", salario, cargo);

		assertEquals("ERRO: getSalario()", 8.0, funcionario.getSalarioLiquido(), 0.0);
	}
	
	@Test
	void testFuncionarioGerenteSalarioAltoDesconto20() {
		double salario = 4999.99;
		CargoENUM cargo = CargoENUM.GERENTE;
		
		Funcionario funcionario = new Funcionario("Luiggy", "luiggy@email.com", salario, cargo);

		assertEquals("ERRO: getSalario()", 3999.992, funcionario.getSalarioLiquido(), 0.0019999999997);
	}
	
	@Test
	void testFuncionarioGerenteSalarioAltoDesconto30() {
		double salario = 5000.0;
		CargoENUM cargo = CargoENUM.GERENTE;
		
		Funcionario funcionario = new Funcionario("Luiggy", "luiggy@email.com", salario, cargo);

		assertEquals("ERRO: getSalario()", 3500.0, funcionario.getSalarioLiquido(), 0.0);
	}
	
	@Test
	void testFuncionarioGerenteSalarioUmPoucoMaisAltoDesconto30() {
		double salario = 5000.01;
		CargoENUM cargo = CargoENUM.GERENTE;
		
		Funcionario funcionario = new Funcionario("Luiggy", "luiggy@email.com", salario, cargo);

		assertEquals("ERRO: getSalario()", 3500.007, funcionario.getSalarioLiquido(), 0.0070000000005);
	}

	@Test
	void testFuncionarioGerenteSalarioMuitoAltoDesconto30() {
		double salario = 9000.0;
		CargoENUM cargo = CargoENUM.GERENTE;
		
		Funcionario funcionario = new Funcionario("Luiggy", "luiggy@email.com", salario, cargo);

		assertEquals("ERRO: getSalario()", 6300.00, funcionario.getSalarioLiquido(), 0.0);
	}
	
}
