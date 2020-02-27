package core;

public class Propriedades {
	
	public static boolean FECHAR_BROWSER = true;
	
	public static Browsers browser = Browsers.CHROME;
	
	public enum Browsers {
		CHROME
	}
	
	public static TipoExecucao tipoExecucao = TipoExecucao.LOCAL;
	
	public enum TipoExecucao {
		LOCAL
	}
	
	public static Ambientes ambiente = Ambientes.HOMOLOGACAO;
	
	public enum Ambientes {
		HOMOLOGACAO
	}

}