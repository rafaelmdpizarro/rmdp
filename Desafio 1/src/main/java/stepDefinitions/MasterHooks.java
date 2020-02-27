package stepDefinitions;

import java.io.IOException;

import core.DriverFactory;
import core.Propriedades;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class MasterHooks extends DriverFactory {
	
	@Before
	public void setup(Scenario cenario) {
		
		String browserStr = Propriedades.browser.toString();
		String tipoExecucaoStr = Propriedades.tipoExecucao.toString();
		
		System.out.println("Before ........" + cenario.getName());
		System.out.println("O browser e " + browserStr);
		System.out.println("O tipo de execucao e " + tipoExecucaoStr);
		
	}
	
	@After
	public void finalizar(Scenario result) throws IOException {
		
		System.out.println("After ........");
		
		// Fechando Browser
		if (Propriedades.FECHAR_BROWSER) {
			killDriver();
		}
		
	}
}