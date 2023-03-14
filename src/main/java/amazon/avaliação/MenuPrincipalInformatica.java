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

public class MenuPrincipalInformatica {
	
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
	public void menuPrincipalNotebook() throws InterruptedException {
		driver.get(url);
		driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']/i")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='hmenu-content']/ul/li[19]/a/div")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("li:nth-child(6) > .hmenu-item > div")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Notebooks")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Notebook HP Intel Core i3 8GB 256GB SSD 15,6” - Windows 11"));
		
	}
	
	@Test
	public void menuPrincipalNotebookLenovo() throws InterruptedException {
		driver.get(url);
		driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']/i")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='hmenu-content']/ul/li[19]/a/div")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("li:nth-child(6) > .hmenu-item > div")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Notebooks")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='s-refinements']/div[31]/ul/li/span/a/div/label")).click();
		driver.findElement(By.className("s-image")).getText().contains("Notebook Lenovo IdeaPad 3i i5-1135G7 8GB 256GB SSD Placa de Vídeo Intel Iris Xe Windows 11 15.6', Cinza, 82MD0007BR");
		
	}
	
	@Test
	public void menuPrincipalNotebookLenovoValorMaior() throws InterruptedException {
		driver.get(url);
		driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']/i")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='hmenu-content']/ul/li[19]/a/div")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("li:nth-child(6) > .hmenu-item > div")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Notebooks")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='s-refinements']/div[31]/ul/li/span/a/div/label")).click();
		driver.findElement(By.xpath("//span[@id='a-autoid-0-announce']/span[2]")).click();
		driver.findElement(By.id("s-result-sort-select_2")).click();
		driver.findElement(By.className("a-offscreen")).getText().contains("R$ 26.035,94");
		driver.findElement(By.className("a-offscreen")).getText().contains("R$ 16.030,98");
	}
	
	@After
	public void finaliza() throws IOException {
		TakesScreenshot ss = (TakesScreenshot) DriverFactory.getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("screenshot.jpg"));
		
	//	driver.quit();

}

}
