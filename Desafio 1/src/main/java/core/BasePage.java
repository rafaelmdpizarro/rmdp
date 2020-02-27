package core;

import utils.Constantes;

public class BasePage {

	protected static DSL dsl;
	
	static String url = Constantes.urlsystem;

	public BasePage() {
		dsl = new DSL();
	}

}