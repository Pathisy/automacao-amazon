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

public class AdicionarItensAoCarrinho {
	
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
	public void AddItemAoCarrinho() {
		driver.get(url);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("qualquer coisa serve");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.linkText("Qualquer Coisa Serve")).click();
		driver.findElement(By.id("add-to-cart-button")).click();
		driver.findElement(By.id("sw-gtc")).click();
		driver.findElement(By.id("activeCartViewForm")).getText().contains("Qualquer Coisa Serve");
	}
	
	@Test
	public void AddItemAoCarrinhoEValidarPreco() {
		driver.get(url);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("qualquer coisa serve");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.linkText("Qualquer Coisa Serve")).click();
		driver.findElement(By.id("add-to-cart-button")).click();
		driver.findElement(By.id("sw-gtc")).click();
		driver.findElement(By.id("a-autoid-0-announce")).click();
		driver.findElement(By.id("quantity_2")).click();
		driver.findElement(By.id("sc-subtotal-amount-buybox")).getText().contains("R$ 123,92");
		
	}
	
	@Test
	public void AddFogaoEGeladeiraAoCarrinho() throws InterruptedException {
		driver.get(url);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("fogão");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.linkText("Itatiaia Fogao Star 4Q Preto Bivolt")).click();
		driver.findElement(By.id("add-to-cart-button")).click();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("geladeira");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.linkText("Geladeira Frost Free Brastemp Inverse 2 Portas "
				+ "443L Evox BRE57AK 127V")).click();
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("attachSiNoCoverage")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("sw-gtc")).click();
		driver.findElement(By.id("sc-subtotal-label-buybox")).getText().contains("Subtotal  (2 itens):");
		
	}
	
	@Test
	public void AddItemAoCarrinhoEExcluir() {
		driver.get(url);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("garrafa");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.linkText("Garrafa Térmica Contigo Matterhorn Matter Black 591ml")).click();
		driver.findElement(By.id("add-to-cart-button")).click();
		driver.findElement(By.id("sw-gtc")).click();
		driver.findElement(By.className("a-color-link")).click();
		driver.findElement(By.id("sc-active-cart")).getText()
		.contains("Seu carrinho de compras da Amazon está vazio.");

	}
	
	@Test
	public void AddFogaoEGeladeiraAoCarrinhoEExcluir1() throws InterruptedException {
		driver.get(url);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("fogão");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.linkText("Itatiaia Fogao Star 4Q Preto Bivolt")).click();
		driver.findElement(By.id("add-to-cart-button")).click();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("geladeira");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.linkText("Geladeira Frost Free Brastemp Inverse 2 Portas "
				+ "443L Evox BRE57AK 127V")).click();
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("attachSiNoCoverage")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("sw-gtc")).click();
		driver.findElement(By.className("a-color-link")).click();
		driver.findElement(By.id("sc-subtotal-label-buybox")).getText().contains("Subtotal (1 item):");
		
	}
	
	@Test
	public void AddItemAoCarrinhoELoogin() {
		driver.get(url);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("qualquer coisa serve");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.linkText("Qualquer Coisa Serve")).click();
		driver.findElement(By.id("add-to-cart-button")).click();
		driver.findElement(By.id("sw-ptc-form")).click();
		driver.findElement(By.className("a-spacing-small")).getText().contains("Fazer login");
	}
   
	@After
	public void finaliza() throws IOException {
		TakesScreenshot ss = (TakesScreenshot) DriverFactory.getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("screenshot.jpg"));
		
		driver.quit();

}

}
