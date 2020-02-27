package page;

import core.BasePage;
import utils.Utils;

public class TelaInicialPage extends BasePage {
	
	//             SubMenu               //
	
	public void aguardarExibicaoDosMenus() {
		
		String xpath = "//a[contains(text(),'Guia Médico')]";
		
		dsl.webDriverWaitXPath(1, xpath);
	}

	public void clicarGuiaMedico(){
		
		String xpath = "//a[contains(text(),'Guia Médico')]";
		
		dsl.clicarBotaoXpath(xpath);
		dsl.webDriverWaitId(1, "busca_detalhada");
	}
	
	public void clicarBuscaDetalhada(){
		
		String id = "texto_selecione_unimed";
		
		dsl.clicarBotao("busca_detalhada");
		dsl.webDriverWaitId(1, id);
		Utils.wait(1);
	}
	
	public void informarEstado(String estado){

		String xpath = "//div[contains(text(),'Estado')]/../div//input";
		
		Utils.wait(2);
		dsl.clicarBotaoXpath("//form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/*");
		Utils.wait(5);
		dsl.clicarBotao("texto_selecione_unimed");
		dsl.escreverXpathEnter(xpath, estado);
		Utils.wait(1);
	}
	
	public void informarCidade(String cidade){
		
		String xpath = "//div[contains(text(),'Cidade')]/../div//input";
		
		Utils.wait(2);
		dsl.clicarBotao("texto_selecione_unimed");
		Utils.wait(2);
		dsl.escreverXpathEnter(xpath, cidade);
		Utils.wait(5);
	}
	
	public void selecionarUnidade(String unidade){
		
		dsl.webDriverWaitXPath(1, "//div[contains(text(), '"+unidade+"')]/preceding::input[@type='radio']");
		
		dsl.clicarBotaoXpath("//div[contains(text(), '"+unidade+"')]/preceding::input[@type='radio']");
		Utils.wait(1);
	}
	
	public void clicarBtnContinuar(){
		
		dsl.clicarBotaoXpath("//button[@class='btn btn-success']");
		Utils.wait(1);
	}
	
}