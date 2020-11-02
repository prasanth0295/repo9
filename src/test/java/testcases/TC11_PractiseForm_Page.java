package testcases;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;

public class TC11_PractiseForm_Page extends TestBase {

	public List<String> all_Valid_List;

	@AfterMethod
	public void refresh_page() {
		driver.navigate().refresh();
	}

	@BeforeClass
	public void opening_RadioButton_page() {

		test = extent.createTest(this.getClass().getSimpleName().toUpperCase());
		driver.get("https://demoqa.com/automation-practice-form");
		String actual_Header = PractiseForm_POM.header.getText();
		String expected_Header = "Practice Form";

		Assert.assertEquals(actual_Header, expected_Header);
		String[] all_Valid = { "Surya Prasanth", "Vaddepati", "prasanthvaddepati@gmail.com", "Male", "9502933677", "29-02-1996",
				"Sattenapalli", "NCR", "Delhi" };
		all_Valid_List = Arrays.asList(all_Valid);
	}

	@Test
	private void all_Valid_Data() {
		PractiseForm_POM.firstName.sendKeys(all_Valid_List.get(0));
		PractiseForm_POM.lastName.sendKeys(all_Valid_List.get(1));
		PractiseForm_POM.userEmail.sendKeys(all_Valid_List.get(2));
		if(all_Valid_List.get(3)=="Male") {
			PractiseForm_POM.radio_male.click();
		}
		PractiseForm_POM.userNumber.sendKeys(all_Valid_List.get(4));
		PractiseForm_POM.dateOfBirthInput.sendKeys(all_Valid_List.get(5));
		PractiseForm_POM.currentAddress.sendKeys(all_Valid_List.get(6));
//		PractiseForm_POM.state.sendKeys(all_Valid_List.get(7));
	//	PractiseForm_POM.city.sendKeys(all_Valid_List.get(8));
		PractiseForm_POM.submit.submit();
	}

}
