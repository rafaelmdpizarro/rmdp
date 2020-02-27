package core;

import java.util.HashMap;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import core.Propriedades.TipoExecucao;
import utils.Constantes;

public class DriverFactory {

	protected static WebDriver driver;
	private static Platform platform;
	
	protected DriverFactory() {
	}

	public static WebDriver getDriver() {
		
		if(Propriedades.tipoExecucao == TipoExecucao.LOCAL){
		
				if (driver == null) {
					switch (Propriedades.browser) {
					case CHROME:
						executeChrome(BasePage.url);
						break;
					}
				}
		}
		
		return driver;
	}
	
	public static void executeChrome(String urlSystem){
		
		//Path Download - Inicio
		
	    HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
	    chromePrefs.put("profile.default_content_settings.popups", 0);
	    
	    ChromeOptions options = new ChromeOptions();
	    options.setExperimentalOption("prefs", chromePrefs);
	    options.addArguments("--test-type");
	    options.addArguments("--disable-extensions");
	    
	    //Path Download - Fim

		String driverpathChrome = getReportFileLocation();
		System.setProperty("webdriver.chrome.driver", driverpathChrome);
		
		driver = new ChromeDriver(options);
		
		getDriver().get(urlSystem);
		driver.manage().window().maximize();
	}

    private static Platform getCurrentPlatform () {
        
    	if (platform == null) {
        	
            String operSys = System.getProperty("os.name").toLowerCase();
            System.out.println(operSys.toUpperCase());
            
            if (operSys.contains("win")) {
                platform = Platform.WINDOWS;
            	} else {
                platform = Platform.LINUX;
            	}
        }
        
        return platform;
    }
    
    private static String getReportFileLocation () {
        String reportFileLocation = null;
        
        String browser = Propriedades.browser.toString();
        platform = getCurrentPlatform();
        
        if ((platform.toString().equals("WINDOWS")) && (browser.equals("CHROME"))) {
        	reportFileLocation = Constantes.pathDriverWindows + Constantes.chromeDriverWindows;
        }
        
        return reportFileLocation;
    }
	
	public static void killDriver() {
		if (driver != null) {
			driver.quit();			
			driver = null;
		}
	}
}
