package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import base.TestBase;

public class TC4_WebTables_Page extends TestBase {
	@BeforeClass
	private void opening_RadioButton_page() {
		test = extent.createTest(this.getClass().getSimpleName().toUpperCase());
		driver.get("https://demoqa.com/webtables");
		String actual_RadioButton_Header = WebTables_POM.webtable_heading.getText();
		String expected_RadioButton_Header = "Web Tables";

		Assert.assertEquals(actual_RadioButton_Header, expected_RadioButton_Header);
	}

}
