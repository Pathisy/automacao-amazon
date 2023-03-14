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


public class LoginLogout {

	String url;
	WebDriver driver;

	@Before
	public void iniciar() {

		url = ("https://www.amazon.com.br/");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Test
	public void login() throws InterruptedException {
		driver.get(url);
		driver.findElement(By.cssSelector("#nav-signin-tooltip .nav-action-inner")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("ap_email")).sendKeys("testepathisy@gmail.com");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("testeteste1!");
		driver.findElement(By.id("signInSubmit")).click();

	}

	@Test
	public void logout() throws InterruptedException {
		driver.get(url);
		driver.findElement(By.cssSelector("#nav-signin-tooltip .nav-action-inner")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("ap_email")).sendKeys("testepathisy@gmail.com");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("testeteste1!");
		driver.findElement(By.id("signInSubmit")).click();
		driver.findElement(By.id("nav-hamburger-menu")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Sair")).click();
	}

	@After
	public void finaliza() throws IOException {
		TakesScreenshot ss = (TakesScreenshot) DriverFactory.getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("screenshot.jpg"));
		
		driver.quit();
		
	}

}
