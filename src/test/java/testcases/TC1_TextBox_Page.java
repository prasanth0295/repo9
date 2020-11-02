package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;

public class TC1_TextBox_Page extends TestBase {

	@BeforeClass
	public void opening_TextBox_Page() {
		driver.get("https://demoqa.com/text-box");
		test = extent.createTest(this.getClass().getSimpleName().toUpperCase());	
		/*pointX = TextBox_POM.textBox_form.getLocation().getX();
		pointY = TextBox_POM.textBox_form.getLocation().getY();
		eleWidth = TextBox_POM.textBox_form.getSize().getWidth();
		eleHeight = TextBox_POM.textBox_form.getSize().getHeight();*/

	}

	@Test(priority = 1)
	public void testing_userName_shadow_enteringText() {
		String userName_shadow_expected = "Full Name";
		String userName_shadow_actual = TextBox_POM.fullNameTextBox.getAttribute("placeholder");
		Assert.assertEquals(userName_shadow_expected, userName_shadow_actual);
		Assert.assertTrue(TextBox_POM.fullNameTextBox.isEnabled());
		TextBox_POM.fullNameTextBox.sendKeys("Surya Prasanth Vaddepati");
	}

	@Test(priority = 6)
	public void testing_form_by_entering_Invalid_Email() {
		driver.navigate().refresh();
		TextBox_POM.fullNameTextBox.sendKeys("Surya Prasanth Vaddepati");
		TextBox_POM.userEmailTextBox.sendKeys("prasanthvaddepatigmail.com");
		TextBox_POM.currentAddressTextBox.sendKeys("Hyderabad");
		TextBox_POM.permanentAddressTextBox.sendKeys("Bapatla");
		TextBox_POM.textbox_submit_button.click();
		Assert.assertFalse(TextBox_POM.textbox_output_form.isDisplayed());
	}

	@Test(priority = 2)
	public void testing_userEmail_shadow_entering_Valid_Text() {
		TextBox_POM.fullNameTextBox.clear();
		String userName_shadow_expected = "name@example.com";
		String userName_shadow_actual = TextBox_POM.userEmailTextBox.getAttribute("placeholder");
		Assert.assertEquals(userName_shadow_expected, userName_shadow_actual);
		Assert.assertTrue(TextBox_POM.userEmailTextBox.isEnabled());
		TextBox_POM.userEmailTextBox.sendKeys("prasanthvaddepati@gmail.com");
	}

	@Test(priority = 3)
	public void testing_currentAddress_shadow_enteringText() {
		TextBox_POM.userEmailTextBox.clear();
		String userName_shadow_expected = "Current Address";
		String userName_shadow_actual = TextBox_POM.currentAddressTextBox.getAttribute("placeholder");
		Assert.assertEquals(userName_shadow_expected, userName_shadow_actual);
		Assert.assertTrue(TextBox_POM.currentAddressTextBox.isEnabled());
		TextBox_POM.currentAddressTextBox.sendKeys("Hyderabad");
	}

	@Test(priority = 4)
	public void testing_permanenAddress_shadow_enteringText() {
		TextBox_POM.currentAddressTextBox.clear();
		Assert.assertTrue(TextBox_POM.permanentAddressTextBox.isEnabled());
		TextBox_POM.permanentAddressTextBox.sendKeys("Bapatla");
	}

	@Test(priority = 5)
	public void testing_submit_button_with_ValidData() {
		driver.navigate().refresh();
		TextBox_POM.fullNameTextBox.sendKeys("Surya Prasanth Vaddepati");
		TextBox_POM.userEmailTextBox.sendKeys("prasanthvaddepati@gmail.com");
		TextBox_POM.currentAddressTextBox.sendKeys("Hyderabad");
		TextBox_POM.permanentAddressTextBox.sendKeys("Bapatla");
		TextBox_POM.textbox_submit_button.click();
		Assert.assertTrue(TextBox_POM.textbox_output_form.isDisplayed());
	}
}
