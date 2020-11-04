package testcases;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;

public class TC22_Alerts_Page extends TestBase {

	@BeforeClass
	public void opening_BrowserWindows_Page() {
		driver.get("https://demoqa.com/alerts");
		test = extent.createTest(this.getClass().getSimpleName().toUpperCase());
	}
	
	@AfterMethod
	public void refresh_page() {
		driver.navigate().refresh();
	}

	@Test(priority = 35)
	public void testing_alert_button() {
		Assert.assertTrue(Alerts_POM.Alerts_alertButton.isEnabled());
		Assert.assertEquals(Alerts_POM.Alerts_alertButton.getText(), "Click me");
		Alerts_POM.Alerts_alertButton.click();
			driver.switchTo().alert().accept();
	}

	@Test(priority = 36)
	public void testing_timed_alert_button() {
		Assert.assertTrue(Alerts_POM.Alerts_timerAlertButton.isEnabled());
		Assert.assertEquals(Alerts_POM.Alerts_timerAlertButton.getText(), "Click me");
		Alerts_POM.Alerts_timerAlertButton.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		try {
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert is NOT Open");
			log.error("Timed Alert is NOT Open");
		}
	}

	@Test(priority = 37)
	public void testing_confirm_button() {
		Assert.assertTrue(Alerts_POM.Alerts_confirmButton.isEnabled());
		Assert.assertEquals(Alerts_POM.Alerts_confirmButton.getText(), "Click me");
		Alerts_POM.Alerts_confirmButton.click();
		driver.switchTo().alert().dismiss();
		Assert.assertEquals(Alerts_POM.Alerts_confirmResult.getText(), "You selected Cancel");
		Alerts_POM.Alerts_confirmButton.click();
		driver.switchTo().alert().accept();
		Assert.assertEquals(Alerts_POM.Alerts_confirmResult.getText(), "You selected Ok");
	}


	@Test(priority = 38)
	public void testing_prompt_button() {
		Assert.assertTrue(Alerts_POM.Alerts_promtButton.isEnabled());
		Assert.assertEquals(Alerts_POM.Alerts_promtButton.getText(), "Click me");
		Alerts_POM.Alerts_promtButton.click();
		driver.switchTo().alert().dismiss();
		Alerts_POM.Alerts_promtButton.click();
		String text_to_enter = "Prasanth";
		driver.switchTo().alert().sendKeys(text_to_enter);
		driver.switchTo().alert().accept();
		Assert.assertEquals(Alerts_POM.Alerts_promptResult.getText(), "You entered "+text_to_enter);
	}

	
}
