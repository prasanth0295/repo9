package testcases;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;

public class TC5_Buttons_Page extends TestBase {

	private boolean display_status;
	
	@AfterMethod
	public void refresh_page() {
		driver.navigate().refresh();
	}

	@BeforeClass
	public void opening_RadioButton_page() {
		test = extent.createTest(this.getClass().getSimpleName().toUpperCase());
		driver.get("https://demoqa.com/buttons");
		String actual_RadioButton_Header = Buttons_POM.buttons_header.getText();
		String expected_RadioButton_Header = "Buttons";

		Assert.assertEquals(actual_RadioButton_Header, expected_RadioButton_Header);

	}
	@Test(priority = 20)
	private void testing_left_click_button() {
		
	
		Assert.assertEquals("Click Me", Buttons_POM.buttons_left_click.getText());
		try {
			display_status = Buttons_POM.text_after_left_click.isDisplayed();
		} catch (NoSuchElementException e) {
			Assert.assertFalse(display_status);
		}
		Buttons_POM.buttons_left_click.click();
		Assert.assertTrue(Buttons_POM.text_after_left_click.isDisplayed());
		Assert.assertEquals("You have done a dynamic click", Buttons_POM.text_after_left_click.getText());
	}

	@Test(priority = 21)
	private void testing_right_click_button() {
	
		Assert.assertEquals("Right Click Me", Buttons_POM.buttons_right_click.getText());
		try {
			display_status = Buttons_POM.text_after_right_click.isDisplayed();
		} catch (NoSuchElementException e) {
			Assert.assertFalse(display_status);
		}
		Buttons_POM.buttons_right_click.click();
		try {
			display_status = Buttons_POM.text_after_right_click.isDisplayed();
		} catch (NoSuchElementException e) {
			Assert.assertFalse(display_status);
		}
		new Actions(driver).contextClick(Buttons_POM.buttons_right_click).build().perform();
		Assert.assertTrue(Buttons_POM.text_after_right_click.isDisplayed());
		Assert.assertEquals("You have done a right click", Buttons_POM.text_after_right_click.getText());
	}

	@Test(priority = 22)
	private void testing_double_click_button() {
		Assert.assertEquals("Double Click Me", Buttons_POM.buttons_double_click.getText());
		try {
			display_status = Buttons_POM.text_after_double_click.isDisplayed();
		} catch (NoSuchElementException e) {
			Assert.assertFalse(display_status);
		}
		Buttons_POM.buttons_double_click.click();
		try {
			display_status = Buttons_POM.text_after_double_click.isDisplayed();
		} catch (NoSuchElementException e) {
			Assert.assertFalse(display_status);
		}

		new Actions(driver).contextClick(Buttons_POM.buttons_right_click).build().perform();
		try {
			display_status = Buttons_POM.text_after_double_click.isDisplayed();
		} catch (NoSuchElementException e) {
			Assert.assertFalse(display_status);
		}
		new Actions(driver).doubleClick(Buttons_POM.buttons_double_click).build().perform();
		Assert.assertTrue(Buttons_POM.text_after_double_click.isDisplayed());
		Assert.assertEquals("You have done a double click", Buttons_POM.text_after_double_click.getText());
	}

}
