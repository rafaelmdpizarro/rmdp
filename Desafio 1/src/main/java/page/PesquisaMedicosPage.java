package page;

import java.util.ArrayList;
import java.util.List;

import core.BasePage;
import utils.Utils;

public class PesquisaMedicosPage extends BasePage {
	
	public void informarEstado(String estado){

		String xpath = "//div[contains(text(),'Estado')]/../div//input";
		
		Utils.wait(5);
		dsl.clicarBotaoXpath("//form[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/*");
		Utils.wait(2);
		dsl.clicarBotao("titulo_o_que_voce_procura");
		dsl.escreverXpathEnter(xpath, estado);
		Utils.wait(1);
	}
	
	public void informarCidade(String cidade){
		
		String xpath = "//div[contains(text(),'Cidade')]/../div//input";
		
		Utils.wait(2);
		dsl.clicarBotao("titulo_o_que_voce_procura");
		Utils.wait(2);
		dsl.escreverXpathEnter(xpath, cidade);
		Utils.wait(1);
	}
	
	public void informarEspecialidade(String especialidade){
		
		//Dermatologia
		
		String xpath = "//div[contains(text(),'Especialidade ou Área de Atuação')]/../div//input";
		
		Utils.wait(2);
		dsl.clicarBotao("titulo_o_que_voce_procura");
		Utils.wait(2);
		dsl.escreverXpathEnter(xpath, especialidade);
		Utils.wait(1);
	}
	
	public void clicarBtnPesquisar(){
		
		dsl.clicarBotao("btn_pesquisar");
		Utils.wait(5);
		
		dsl.webDriverWaitXPath(2, "//div[1]/span[1]/p[1]");
	}
	
	public List<String> returnEspecialidadesConsulta() {
		
		List<String> listEspecialidades = new ArrayList<String>();
		listEspecialidades = dsl.listWebElement("//div[1]/p[1]/span[2]");
		
		return listEspecialidades;
	}
	
	public List<String> returnCidadesConsulta() {
		
		List<String> listCidades = new ArrayList<String>();
		listCidades = dsl.listWebElement("//div[1]/span[1]/p[1]");
		
		return listCidades;
	
	}
	
	public void realizarPaginacao(int x) {

		dsl.clicarBotaoXpath("//a[contains(text(),'"+x+"')]");
		Utils.wait(10);
	
	}

}