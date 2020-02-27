package stepDefinitions;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import page.PesquisaMedicosPage;
import page.TelaInicialPage;
import utils.Utils;

public class RealizarConsultasMedicos {
	
	TelaInicialPage telaInicialPage = new TelaInicialPage();
	PesquisaMedicosPage pesquisaMedicosPage = new PesquisaMedicosPage();
	
	String uf = "Rio de Janeiro";
	String cidade = "Rio de Janeiro";
	String unidade = "UNIMED RIO";
	String especialidade = "Dermatologia";
	
	List<String> especialidadesRetornoConsulta = new ArrayList<String>();
	List<String> cidadesRetornoConsulta = new ArrayList<String>();
	
	@Dado("^que eu esteja no portal da Unimed Coorp$")
	public void queEuEstejaNoPortalDaUnimedCoorp() {
		telaInicialPage.aguardarExibicaoDosMenus();

	}

	@Quando("^acessar Guia Medico$")
	public void acessarGuiaMedico() {
		telaInicialPage.clicarGuiaMedico();
		telaInicialPage.clicarBuscaDetalhada();
		telaInicialPage.informarEstado(uf);
		telaInicialPage.informarCidade(cidade);
		telaInicialPage.selecionarUnidade("UNIMED RIO");
		telaInicialPage.clicarBtnContinuar();		
	}

	@Quando("^realizo uma pesquisa de medicos no \"([^\"]*)\"$")
	public void realizoUmaPesquisaDeMedicosNoRioDeJaneiro(String cidade) {
		pesquisaMedicosPage.informarEstado(uf);
		pesquisaMedicosPage.informarCidade(cidade);
		pesquisaMedicosPage.informarEspecialidade(especialidade);
		pesquisaMedicosPage.clicarBtnPesquisar();
	}

	@Entao("^valido a apresentação dos resultados com a Especialidade e Cidade$")
	public void validoAApresentaçãoDosResultadosComAEspecialidadeECidade() {
		especialidadesRetornoConsulta = pesquisaMedicosPage.returnEspecialidadesConsulta();
		cidadesRetornoConsulta = pesquisaMedicosPage.returnCidadesConsulta();
		Assert.assertTrue(Utils.checkForValueContains(especialidadesRetornoConsulta, especialidade));
		Assert.assertTrue(Utils.checkForValueContains(cidadesRetornoConsulta, cidade));
	}

	@Entao("^valido nas paginas 1,2 e 3 do resultado, NAO apresentacao do resultado com cidade \"([^\"]*)\"$")
	public void validoNasPaginasEDoResultadoNAOApresentacaoDoResultadoComCidadeSaoPaulo(String cidade) {
		//Pagina 1
		
		especialidadesRetornoConsulta = pesquisaMedicosPage.returnEspecialidadesConsulta();
		cidadesRetornoConsulta = pesquisaMedicosPage.returnCidadesConsulta();
		Assert.assertTrue(Utils.checkForValueNotContains(especialidadesRetornoConsulta, especialidade));
		Assert.assertTrue(Utils.checkForValueNotContains(cidadesRetornoConsulta, cidade));
		
		//Pagina 2
		
		pesquisaMedicosPage.realizarPaginacao(2);
		especialidadesRetornoConsulta = pesquisaMedicosPage.returnEspecialidadesConsulta();
		cidadesRetornoConsulta = pesquisaMedicosPage.returnCidadesConsulta();
		Assert.assertTrue(Utils.checkForValueNotContains(especialidadesRetornoConsulta, especialidade));
		Assert.assertTrue(Utils.checkForValueNotContains(cidadesRetornoConsulta, cidade));
		
		//Pagina 3
		
		pesquisaMedicosPage.realizarPaginacao(3);
		especialidadesRetornoConsulta = pesquisaMedicosPage.returnEspecialidadesConsulta();
		cidadesRetornoConsulta = pesquisaMedicosPage.returnCidadesConsulta();
		Assert.assertTrue(Utils.checkForValueNotContains(especialidadesRetornoConsulta, especialidade));
		Assert.assertTrue(Utils.checkForValueNotContains(cidadesRetornoConsulta, cidade));
	}

}
