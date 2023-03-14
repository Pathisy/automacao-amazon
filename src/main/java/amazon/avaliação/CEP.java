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

public class CEP {
	
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
	public void buscaFrigideiraECep() throws InterruptedException {
		driver.get(url);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("frigideira");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.linkText
				("Jogo de Frigideiras de Alumínio com Revestimento Interno de Antiaderente 3 Peças Tramontina Bergamo Vermelho")).click();
		driver.findElement(By.id("contextualIngressPtLabel_deliveryShortLine")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("GLUXZipUpdateInput_0")).sendKeys("06010");
		driver.findElement(By.id("GLUXZipUpdateInput_1")).sendKeys("067");
		driver.findElement(By.id("GLUXZipUpdate")).click();
		driver.findElement(By.className("a-link-normal")).getText().contains("Entrega GRÁTIS");
	   
	}
	
	@Test
	public void buscaCopoECep() throws InterruptedException {
		driver.get(url);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("copo");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.linkText("Conjunto 6 Copos 300ml Oca Nadir")).click();
		driver.findElement(By.id("contextualIngressPtLabel_deliveryShortLine")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("GLUXZipUpdateInput_0")).sendKeys("00000");
		driver.findElement(By.id("GLUXZipUpdateInput_1")).sendKeys("000");
		driver.findElement(By.id("GLUXZipUpdate")).click();
		driver.findElement(By.className("GLUX_Hidden")).getText().contains("Insira um CEP válido");
	
	}
	
	@After
	public void finaliza() throws IOException {
		TakesScreenshot ss = (TakesScreenshot) DriverFactory.getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("screenshot.jpg"));
		
		driver.quit();

}
}

