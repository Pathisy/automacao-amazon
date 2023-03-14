package amazon.avaliação;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import bases.DriverFactory;

public class ConsultarProdutos {
	
	String url;
	WebDriver driver;
	
	@Before
	public void iniciar() {

		url = ("https://www.amazon.com.br/");
		System.setProperty("webdriver.chrome.driver", "C:\\Pathisy\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}
	
	@Test
	public void consultarBicicleta() {
		driver.get(url);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bicicleta aro 29");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.linkText("BICICLETA ARO 29 KSW XLT COLOR - 21V CAMBIOS SHIMANO")).click();
		
	}
	
	@Test
	public void consultarItemInexistente() {
		driver.get(url);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("item_inexistente_012345 +23453"); //o item citado no e-mail não aparece a mensagem
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.id("s-skipLinkTargetForMainSearchResults")).getText().
		contains("Nenhum resultado para item_inexistente_012345 +23453.");
	
	}
	
	@After
	public void finaliza() throws IOException {
		TakesScreenshot ss = (TakesScreenshot) DriverFactory.getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("screenshot.jpg"));
		
		driver.quit();

}
}
