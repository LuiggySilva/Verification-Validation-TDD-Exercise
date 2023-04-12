package testes;

import projeto.CargoENUM;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import projeto.Funcionario;

public class FuncionarioTest {

	@Test
	void testFuncionarioConstructor() {
		String nome = "Luiggy";
		String email = "luiggy@email.com";
		double salario = 10000;
		CargoENUM cargo = CargoENUM.GERENTE;
		
		Funcionario funcionario = new Funcionario(nome, email, salario, cargo);
		
		assertEquals("ERRO: getNome()", nome, funcionario.getNome()); 
		assertEquals("ERRO: getEmail()", email, funcionario.getEmail()); 
		assertEquals("ERRO: getSalario()", salario, funcionario.getSalario(), 0); 
		assertEquals("ERRO: getCargo()", cargo.getCargo(), funcionario.getCargo()); 
	}	
	
	@Test
	void testFuncionarioSetMethods() {
		String nome1 = "Luiggy";
		String email1 = "luiggy@email.com";
		Double salario1 = 10000.0;
		CargoENUM cargo1 = CargoENUM.GERENTE;
		
		Funcionario funcionario = new Funcionario(nome1, email1, salario1, cargo1);
		
		assertEquals("ERRO: getNome()", nome1, funcionario.getNome()); 
		assertEquals("ERRO: getEmail()", email1, funcionario.getEmail()); 
		assertEquals("ERRO: getSalario()", salario1, funcionario.getSalario(), 0); 
		assertEquals("ERRO: getCargo()", cargo1.getCargo(), funcionario.getCargo()); 
		
		String nome2 = "Irineu";
		String email2 = "irineu@email.com";
		Double salario2 = 5000.0;
		CargoENUM cargo2 = CargoENUM.DBA;
		
		funcionario.setNome(nome2);
		funcionario.setEmail(email2);
		funcionario.setSalario(salario2);
		funcionario.setCargo(cargo2);
		
		assertEquals("ERRO: setNome()", nome2, funcionario.getNome()); 
		assertEquals("ERRO: setEmail()", email2, funcionario.getEmail()); 
		assertEquals("ERRO: setSalario()", salario2, funcionario.getSalario(), 0); 
		assertEquals("ERRO: setCargo()", cargo2.getCargo(), funcionario.getCargo()); 
	}

	@Test
	void testFuncionarioEmptyNameConstructorException() {
		// Teste com string vazia
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
	           () -> {
	        	   Funcionario funcionario = new Funcionario ("", "funcionario@email.com", 1000.0,  CargoENUM.DBA);
	           },
	           "ERRO: Criação de funcionário com nome vazio"
	    );
	    assertTrue(thrown.getMessage().contentEquals("Nome do funcionário vazio!"));
	}
	
	@Test
	void testFuncionarioEmptySetNameException() {
		// Teste com string vazia
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
	           () -> {
	        	   Funcionario funcionario = new Funcionario("funcionario", "funcionario@email.com", 1000.0, CargoENUM.DBA);
	        	   funcionario.setNome("");
	           },
	           "ERRO: Alteração de funcionário com nome vazio"
	    );
	    assertTrue(thrown.getMessage().contentEquals("Nome do funcionário vazio!"));
	}
	
	@Test
	void testFuncionarioEmptyEmailConstructorException() {
		// Testando com string vazia
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
	           () -> {
	        	   Funcionario funcionario = new Funcionario("luiggy", "", 1000.0, CargoENUM.DBA);
	           },
	           "ERRO: Criação de funcionário com email vazio"
	    );
	    assertTrue(thrown.getMessage().contentEquals("Email do funcionário vazio!"));
	}
	
	@Test
	void testFuncionarioEmptySetEmailException() {
		// Testando com string vazia
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
	           () -> {
	        	   Funcionario funcionario = new Funcionario("luiggy", "luiggy@email.com", 1000.0, CargoENUM.DBA);
	        	   funcionario.setEmail("");
	           },
	           "ERRO: Alteração de funcionário com email vazio"
	    );
	    assertTrue(thrown.getMessage().contentEquals("Email do funcionário vazio!"));
	}
	
	@Test
	void testFuncionarioInvalidSalaryConstructorException() {
		// Testando com o valor igual a zero
		IllegalArgumentException thrown1 = assertThrows(
				IllegalArgumentException.class,
	           () -> {
	        	   Funcionario funcionario = new Funcionario("luiggy", "luiggy@email.com", 0.0, CargoENUM.DBA);
	           },
	           "ERRO: Criação de funcionário com salario igual a zero"
	    );
		assertTrue(thrown1.getMessage().contentEquals("Salário do funcionário menor ou igual a zero!"));
		
		// Testando com o valor negativo
		IllegalArgumentException thrown2 = assertThrows(
				IllegalArgumentException.class,
	           () -> {
	        	   Funcionario funcionario = new Funcionario("luiggy", "luiggy@email.com", -1.0, CargoENUM.DBA);
	           },
	           "ERRO: Criação de funcionário com salario menor ou igual a zero"
	    );
		assertTrue(thrown2.getMessage().contentEquals("Salário do funcionário menor ou igual a zero!"));
	}
	
	@Test
	void testFuncionarioInvalidSetSalaryException() {
		// Testando com o valor igual a zero
		IllegalArgumentException thrown1 = assertThrows(
				IllegalArgumentException.class,
	           () -> {
	        	   Funcionario funcionario = new Funcionario("luiggy", "luiggy@email.com", 1000.0, CargoENUM.DBA);
	        	   funcionario.setSalario(0.0);
	           },
	           "ERRO: Alteração de funcionário com salario igual a zero"
	    );
		assertTrue(thrown1.getMessage().contentEquals("Salário do funcionário menor ou igual a zero!"));
		
		// Testando com o valor negativo
		IllegalArgumentException thrown2 = assertThrows(
				IllegalArgumentException.class,
	           () -> {
	        	   Funcionario funcionario = new Funcionario("luiggy", "luiggy@email.com", 1000.0, CargoENUM.DBA);
	        	   funcionario.setSalario(-1.0);
	           },
	           "ERRO: Alteração de funcionário com salario menor ou igual a zero"
	    );
		assertTrue(thrown2.getMessage().contentEquals("Salário do funcionário menor ou igual a zero!"));
	}
	
	@Test
	void testFuncionarioGetNetSalaryDESENVOLVEDOR() {
		// Valor bem maior
		Funcionario funcionario1 = new Funcionario("luiggy", "luiggy@email.com", 10000.0, CargoENUM.DESENVOLVEDOR);
		assertEquals("ERRO: Salário liquído do desenvolvedor incorreto", 8000, funcionario1.getSalarioLiquido(), 0);
		// Valor bem menor
		Funcionario funcionario2 = new Funcionario("luiggy", "luiggy@email.com", 1000.0, CargoENUM.DESENVOLVEDOR);
		assertEquals("ERRO: Salário liquído do desenvolvedor incorreto", 900, funcionario2.getSalarioLiquido(), 0);
		// Valor proximo do limite superior
		Funcionario funcionario3 = new Funcionario("luiggy", "luiggy@email.com", 2999.99, CargoENUM.DESENVOLVEDOR);
		assertEquals("ERRO: Salário liquído do desenvolvedor incorreto", 2699.991, funcionario3.getSalarioLiquido(), 0);
		// Valor proximo do limite inferior
		Funcionario funcionario4 = new Funcionario("luiggy", "luiggy@email.com", 3000.01, CargoENUM.DESENVOLVEDOR);
		assertEquals("ERRO: Salário liquído do desenvolvedor incorreto", 2400.008, funcionario4.getSalarioLiquido(), 0.008000000003);
		// Valor igual ao limite
		Funcionario funcionario5 = new Funcionario("luiggy", "luiggy@email.com", 3000.0, CargoENUM.DESENVOLVEDOR);
		assertEquals("ERRO: Salário liquído do desenvolvedor incorreto", 2400, funcionario5.getSalarioLiquido(), 0);
	}
	
	@Test
	void testFuncionarioGetNetSalaryDBA() {
		// Valor bem maior
		Funcionario funcionario1 = new Funcionario("luiggy", "luiggy@email.com", 10000.0, CargoENUM.DBA);
		assertEquals("ERRO: Salário liquído do desenvolvedor incorreto", 7500, funcionario1.getSalarioLiquido(), 0);
		// Valor bem menor
		Funcionario funcionario2 = new Funcionario("luiggy", "luiggy@email.com", 1000.0, CargoENUM.DBA);
		assertEquals("ERRO: Salário liquído do desenvolvedor incorreto", 850, funcionario2.getSalarioLiquido(), 0);
		// Valor proximo do limite superior
		Funcionario funcionario3 = new Funcionario("luiggy", "luiggy@email.com", 1999.99, CargoENUM.DBA);
		assertEquals("ERRO: Salário liquído do desenvolvedor incorreto", 1699.9915, funcionario3.getSalarioLiquido(), 0);
		// Valor proximo do limite inferior
		Funcionario funcionario4 = new Funcionario("luiggy", "luiggy@email.com", 2000.01, CargoENUM.DBA);
		assertEquals("ERRO: Salário liquído do desenvolvedor incorreto", 1500.0075, funcionario4.getSalarioLiquido(), 0);
		// Valor igual ao limite
		Funcionario funcionario5 = new Funcionario("luiggy", "luiggy@email.com", 2000.0, CargoENUM.DBA);
		assertEquals("ERRO: Salário liquído do desenvolvedor incorreto", 1500, funcionario5.getSalarioLiquido(), 0);		
	}

	@Test
	void testFuncionarioGetNetSalaryTESTADOR() {
		// Valor bem maior
		Funcionario funcionario1 = new Funcionario("luiggy", "luiggy@email.com", 10000.0, CargoENUM.TESTADOR);
		assertEquals("ERRO: Salário liquído do desenvolvedor incorreto", 7500, funcionario1.getSalarioLiquido(), 0);
		// Valor bem menor
		Funcionario funcionario2 = new Funcionario("luiggy", "luiggy@email.com", 1000.0, CargoENUM.TESTADOR);
		assertEquals("ERRO: Salário liquído do desenvolvedor incorreto", 850, funcionario2.getSalarioLiquido(), 0);
		// Valor proximo do limite superior
		Funcionario funcionario3 = new Funcionario("luiggy", "luiggy@email.com", 1999.99, CargoENUM.TESTADOR);
		assertEquals("ERRO: Salário liquído do desenvolvedor incorreto", 1699.9915, funcionario3.getSalarioLiquido(), 0);
		// Valor proximo do limite inferior
		Funcionario funcionario4 = new Funcionario("luiggy", "luiggy@email.com", 2000.01, CargoENUM.TESTADOR);
		assertEquals("ERRO: Salário liquído do desenvolvedor incorreto", 1500.0075, funcionario4.getSalarioLiquido(), 0);
		// Valor igual ao limite
		Funcionario funcionario5 = new Funcionario("luiggy", "luiggy@email.com", 2000.0, CargoENUM.TESTADOR);
		assertEquals("ERRO: Salário liquído do desenvolvedor incorreto", 1500, funcionario5.getSalarioLiquido(), 0);		
	}

	@Test
	void testFuncionarioGetNetSalaryGERENTE() {
		// Valor bem maior
		Funcionario funcionario1 = new Funcionario("luiggy", "luiggy@email.com", 10000.0, CargoENUM.GERENTE);
		assertEquals("ERRO: Salário liquído do desenvolvedor incorreto", 7000, funcionario1.getSalarioLiquido(), 0);
		// Valor bem menor
		Funcionario funcionario2 = new Funcionario("luiggy", "luiggy@email.com", 1000.0, CargoENUM.GERENTE);
		assertEquals("ERRO: Salário liquído do desenvolvedor incorreto", 800, funcionario2.getSalarioLiquido(), 0);
		// Valor proximo do limite superior
		Funcionario funcionario3 = new Funcionario("luiggy", "luiggy@email.com", 4999.99, CargoENUM.GERENTE);
		assertEquals("ERRO: Salário liquído do desenvolvedor incorreto", 3999.992, funcionario3.getSalarioLiquido(), 0.0019999999997);
		// Valor proximo do limite inferior
		Funcionario funcionario4 = new Funcionario("luiggy", "luiggy@email.com", 5000.01, CargoENUM.GERENTE);
		assertEquals("ERRO: Salário liquído do desenvolvedor incorreto", 3500.007, funcionario4.getSalarioLiquido(), 0.0070000000005);
		// Valor igual ao limite
		Funcionario funcionario5 = new Funcionario("luiggy", "luiggy@email.com", 5000.0, CargoENUM.GERENTE);
		assertEquals("ERRO: Salário liquído do desenvolvedor incorreto", 3500, funcionario5.getSalarioLiquido(), 0);		
	}
	
}
