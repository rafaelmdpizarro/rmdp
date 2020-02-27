package core;
import static core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DSL {
	
	/********* TextField e TextArea ************/
	
	public void escrever(By by, String texto){
		getDriver().findElement(by).clear();
		getDriver().findElement(by).sendKeys(texto);
	}
	
	public void escrever(String id_campo, String texto){
		escrever(By.id(id_campo), texto);
	}
	
	public void escreverIdInputFile(String id, String texto){
		getDriver().findElement(By.id(id)).sendKeys(texto);
	}
	
	public void escreverName(String name, String texto){
		escrever(By.name(name), texto);
	}

	public void escreverXpathEnter(String xpath, String texto){
		getDriver().findElement(By.xpath(xpath)).sendKeys(texto, Keys.ENTER);
	}
	
	/********* WebDriver - Wait ************/
	
	public void webDriverWaitXPath(int time, String xpath){
	
	//Espera
		
	WebDriverWait wait = new WebDriverWait(getDriver(), time * 1000);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	
	}
	
	public void webDriverWaitId(int time, String id){
		
	//Espera
		
	WebDriverWait wait = new WebDriverWait(getDriver(), time * 1000);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
	
	}
	
	/********* Botao ************/
	
	public void clicarBotao(String id) {
		getDriver().findElement(By.id(id)).click();
	}
	
	public void clicarBotaoXpath(String xpath) {
		getDriver().findElement(By.xpath(xpath)).click();
	}
	
	/*********  Retornar Tamanho WebElement   ************/
	
	public List<String> listWebElement(String xpath) {
		List<String> listWebElement = new ArrayList<String>();
		List<WebElement> list = getDriver().findElements(By.xpath(xpath));
		int x = list.size();
		
		for (int y = 0; y < x; y++) {
			listWebElement.add(list.get(y).getText());
		}
		
		return listWebElement;
	}
	
}