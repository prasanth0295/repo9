package testcases;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;

public class TC3_RadioButton_Page extends TestBase {

	@AfterMethod
	public void refresh_page() {
		driver.navigate().refresh();
	}

	@BeforeClass
	public void opening_RadioButton_page() {
		test = extent.createTest(this.getClass().getSimpleName().toUpperCase());
		driver.get("https://demoqa.com/radio-button");
		String actual_RadioButton_Header = RadioButton_POM.radiobutton_header.getText();
		String expected_RadioButton_Header = "Radio Button";

		Assert.assertEquals(actual_RadioButton_Header, expected_RadioButton_Header);

	}

	@Test(priority = 16)
	private void testing_status_of_radiobuttons() {
		Assert.assertNotEquals(RadioButton_POM.radiobutton_yesRadio_text.isSelected(),
				RadioButton_POM.radiobutton_yesRadio_text.isEnabled());

		Assert.assertNotEquals(RadioButton_POM.radiobutton_impressiveRadio_text.isSelected(),
				RadioButton_POM.radiobutton_impressiveRadio_text.isEnabled());

		Assert.assertEquals(RadioButton_POM.radiobutton_noRadio_text.isSelected(),
				RadioButton_POM.radiobutton_noRadio_text.isEnabled());

	}

	@Test(priority = 17)
	private void testing_Yes_radio_button() {
		RadioButton_POM.radiobutton_yesRadio.click();

		// Assert.assertTrue(RadioButton_POM.radiobutton_yesRadio.isSelected());
		String expected_text_shown = "Yes";
		String actual_text_shown = RadioButton_POM.radiobutton_textSuccess.getText();
		Assert.assertEquals(expected_text_shown, actual_text_shown);

	}

	@Test(priority = 18)
	private void testing_Impressive_radio_button() {
		RadioButton_POM.radiobutton_impressiveRadio.click();

		// Assert.assertTrue(RadioButton_POM.radiobutton_impressiveRadio.isSelected());
		String expected_text_shown = "Impressive";
		String actual_text_shown = RadioButton_POM.radiobutton_textSuccess.getText();
		Assert.assertEquals(expected_text_shown, actual_text_shown);
	}

	@Test(priority = 19)
	private void testing_No_radio_button() {
		RadioButton_POM.radiobutton_noRadio.click();

		Assert.assertFalse(RadioButton_POM.radiobutton_noRadio.isSelected());

		try {
			RadioButton_POM.radiobutton_textSuccess.getText();
		} catch (NoSuchElementException e) {
			log.info("NO button is not interactable");
		}

	}

}
