package utils;

import java.io.File;

public class Constantes {
	
	//Path Drivers
	
	public static final String pathDriverWindows = System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "windows" + File.separator;

	//Drivers
	
	public static final String chromeDriverWindows = "chromedriver.exe";

	//UrlSystem
	
	public static final String urlsystem = "https://www.unimed.coop.br/";
	
	//Formata de Data
	
    public static final String formatoDataWindows = "dd/MM/yyyy";
    
    public static final String formatoDataHoraWindows = "dd/MM/yyyy HH-mm-ss";
    
    public static final String formatoHoraDataBancoDados = "yyyy-MM-dd";
    
    public static final String formatoHoraDataHoraBancoDados = "yyyy-MM-dd HH-mm-ss";
    
}