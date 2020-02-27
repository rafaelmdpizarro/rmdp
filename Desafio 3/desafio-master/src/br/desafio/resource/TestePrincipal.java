package br.desafio.resource;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

class TestePrincipal extends TestCase {

	/*@Test
	void testExecutaLojista() {
		fail("Not yet implemented");
	}*/

	@Test
	void testCalculaCarrinho() {
		
		 ArrayList<Integer> carrinhoTeste = new ArrayList<Integer>();
		 BigDecimal retornoEsperado = new BigDecimal("200.00");
		 
		 carrinhoTeste.add(1);
		 carrinhoTeste.add(2);
		 carrinhoTeste.add(3);
		 
		 Principal princ = new Principal(); 
		 BigDecimal retornoTeste = new BigDecimal("0.00");;
		 
		 retornoTeste = princ.calculaCarrinho(carrinhoTeste);
		 
		 assertEquals(retornoEsperado, retornoTeste);
	}

	@Test
	void testAplicaDesconto() {
		
		 BigDecimal valorCarrinho = new BigDecimal("155.00");
		 boolean descontoFilmeAcao = true;
		 BigDecimal retornoEsperado = new BigDecimal("132.53");
		  
		 
		 
		 Principal princ = new Principal(); 
		 BigDecimal retornoTeste = new BigDecimal("0.00");
		 
		 retornoTeste = princ.aplicaDesconto(valorCarrinho, descontoFilmeAcao);
		 
		 assertEquals(retornoEsperado, retornoTeste);
		
	}

}
