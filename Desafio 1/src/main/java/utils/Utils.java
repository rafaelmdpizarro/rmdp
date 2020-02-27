package utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Utils {
	
	public static boolean checkForValueContains (List<String> listString, String value){
		
		int tamanho = listString.size();
		int sucess = 0;
		
        for(int j = 0; j < tamanho; j++){
        	
            if(listString.get(j).contains(value))
            	sucess = sucess + 1;
        }
	    
	    if (sucess == tamanho) { 
	    	return true;
	    } else {	        
	    	return false;
	    }
	}
	
	public static boolean checkForValueNotContains (List<String> listString, String value){
		
		int tamanho = listString.size();
		int error = 0;
		
        for(int j = 0; j < tamanho; j++){
        	
            if(!listString.get(j).contains(value))
            	error = error + 1;
        }
	    
	    if (error == tamanho) { 
	    	return true;
	    } else {	        
	    	return false;
	    }
	}

	public static int randomInt(int qtd) {

		Random gerador = new Random();
		int num = 0;

		for (int i = 0; i < qtd; i++) {
			num = num + (gerador.nextInt());
		}

		return num;
	}

	public static void wait(int timeSeconds) {

		try {
			Thread.sleep(timeSeconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	private static Random rand = new Random();

	private static char[] letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

	public static String stringAleatoria(int nCaracter) {

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < nCaracter; i++) {
			int ch = rand.nextInt(letras.length);
			sb.append(letras[ch]);
		}

		return sb.toString();
	}

	public static void clickTeclaEnter() {

		Robot robot;
		try {
			robot = new Robot();
			robot.setAutoDelay(1500);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}


	public static String timestamp() {

		return new SimpleDateFormat(Constantes.formatoDataHoraWindows).format(new Date());

	}

	
}