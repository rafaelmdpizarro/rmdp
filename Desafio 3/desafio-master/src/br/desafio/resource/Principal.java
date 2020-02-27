package br.desafio.resource;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Principal {
	
	//Relação dos IDs dos filmes
	private int FILME_ID_1 = 1;
	private int FILME_ID_2 = 2;
	private int FILME_ID_3 = 3;
	private int FILME_ID_4 = 4;
	private int FILME_ID_5 = 5;
	private int FILME_ID_6 = 6;

	// Declaração das variáveis que serão utilizadas no sistema.
	private int idFilme = 0;
	private int addFilme = 0;
	private ArrayList<Integer> carrinho;
	private boolean descontoFilmeAcao = false;
	private BigDecimal valorCarrinho = new BigDecimal("0.00");
	private BigDecimal valorComDesconto = new BigDecimal("0.00");
	
	/**
	 * Método principal responsável por realizar a escolha dos filmes para o carrinho de compras. 
	 */
	public void executaLojista () {
	
		//Inicialização do Array.
		carrinho = new ArrayList<>();
		
		do {
		
		//Componente JOption para a escolha dos IDs dos filmes que vão compor o carrinho 	
		idFilme = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o ID do filme desejado:\n\n\n"
																   + " 1 - Senhor dos Anéis.\n"
																   + " 2 - As Branquelas.\n"
																   + " 3 - Velozes e Furiosos 7.\n"
																   + " 4 - Velozes e Furiosos 6.\n"
																   + " 5 - The Scapegoat.\n"
																   + " 6 - Meu Malvado Favorito.\n\n\n"));
		//Adiciona o filme escolhido na list
		carrinho.add(idFilme);
		
		addFilme = JOptionPane.showConfirmDialog(null, "Deseja adicionar novo filme?");
		
		//Loop para continuar a escolha de filmes enquanto não selecionar a opção Não	
		}while (addFilme != 1 && addFilme != 2);
		
		//Verifica se carrrinho está vazio
		if (!carrinho.isEmpty()) {
			
			//Chama o método que vai calcular o valor do carrinho
			valorCarrinho = calculaCarrinho(carrinho);
			//Chama o método que vai calcular o desconto na compra dos filmes
			valorComDesconto = aplicaDesconto(valorCarrinho, descontoFilmeAcao);
			
			//Exibe através do componente JOption os valor do carrinho e o valor com desconto
			JOptionPane.showMessageDialog(null, "O valor total do carrinho sem desconto é de: R$ " + valorCarrinho + "\n\n"
											  + "O valor com desconto é de: R$ " + valorComDesconto + ".");
			
		}else {
			JOptionPane.showMessageDialog(null, "O carrinho está vazio.");
		}
		
	}
	
	/**
	 * Método responsável por calcular o valor do carrinho com os itens que foram adicionados
	 * @param carrinho
	 * @return
	 */
	public BigDecimal calculaCarrinho (ArrayList<Integer> carrinho) {
		
		//Percorre a lista com os Ids dos filmes.
		for (Integer itemCarrinho : carrinho) {
			
			//Para cada item do carrinho é verificado qual o filme respectivo para ser calculado o valor. 
			if (itemCarrinho == FILME_ID_1) {
				valorCarrinho = valorCarrinho.add(new BigDecimal("45.00"));
			}else if (itemCarrinho == FILME_ID_2) {
				valorCarrinho = valorCarrinho.add(new BigDecimal("55.00"));
			}else if (itemCarrinho == FILME_ID_3) {
				valorCarrinho = valorCarrinho.add(new BigDecimal("100.00"));   // Se o filme for do gênero de Ação, deverá ser adicionado 5% de Desconto.
				descontoFilmeAcao = true;                                     //  Esta flag controla isto para ser usada posteriomente no calculo de desconto. 
			}else if (itemCarrinho == FILME_ID_4) {
				valorCarrinho = valorCarrinho.add(new BigDecimal("55.00"));   // Se o filme for do gênero de Ação, deverá ser adicionado 5% de Desconto.
				descontoFilmeAcao = true;				                     //  Esta flag controla isto para ser usada posteriomente no calculo de desconto.
			}else if (itemCarrinho == FILME_ID_5) {
				valorCarrinho = valorCarrinho.add(new BigDecimal("100.00"));
			}else if (itemCarrinho == FILME_ID_6) {
				valorCarrinho = valorCarrinho.add(new BigDecimal("200.00"));
			}
			
		}
		
	 return valorCarrinho;
	 
	}

	/**
	 * Método responsável por calcular o desconto que será aplicado ao carrinho de compras.
	 * @param valorCarrinho
	 * @param descontoFilmeAcao
	 * @return
	 */
	public BigDecimal aplicaDesconto (BigDecimal valorCarrinho, boolean descontoFilmeAcao) {
		
		BigDecimal valorComDesconto = null;
		
		//Verifica o valor do carrinho para ser aplicado o desconto respectivo. 
		if (valorCarrinho.intValue() >= 100 && valorCarrinho.intValue() < 200) {
			valorComDesconto =  valorCarrinho.subtract((valorCarrinho.multiply(new BigDecimal("10"))).divide(new BigDecimal(("100"))));
		} else if (valorCarrinho.intValue() >= 200 && valorCarrinho.intValue() < 300) {
			valorComDesconto =  valorCarrinho.subtract((valorCarrinho.multiply(new BigDecimal("20"))).divide(new BigDecimal(("100"))));
		}else if (valorCarrinho.intValue() >= 300 && valorCarrinho.intValue() < 400) {
			valorComDesconto =  valorCarrinho.subtract((valorCarrinho.multiply(new BigDecimal("25"))).divide(new BigDecimal(("100"))));
		}else if (valorCarrinho. intValue() >= 400) {
			valorComDesconto =  valorCarrinho.subtract((valorCarrinho.multiply(new BigDecimal("30"))).divide(new BigDecimal(("100"))));
		}
		
		//Se no carrinho tiver algum filme do genero de Ação, será realizado mais 5% de Desconto.
		if (descontoFilmeAcao) {
			valorComDesconto =  valorComDesconto.subtract((valorComDesconto.multiply(new BigDecimal("5"))).divide(new BigDecimal(("100"))));
		}
		
		
		return valorComDesconto.setScale(2, RoundingMode.UP);
	
	}
	
	
	
}
	

