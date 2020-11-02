package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestingParallel  {
	
	public WebDriver driver;

	@AfterMethod
	private void close() {
		driver.quit();
	}
		
	@Test
	private void m1() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
	}

	@Test
	private void m2() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://www.facebook.com");
		System.out.println(driver.getTitle());
	}

	@Test
	private void m3() {
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
		driver.get("https://www.amazon.com");
		System.out.println(driver.getTitle());
	}
}
