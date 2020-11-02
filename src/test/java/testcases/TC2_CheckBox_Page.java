package testcases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;

public class TC2_CheckBox_Page extends TestBase {

	public List<WebElement> expandedItems;
	public List<WebElement> checkedItemsWebElements;
	public List<String> expected_checkedItems_List;
	public List<String> actual_checkedItems_List;

	@BeforeClass
	public void opening_CheckBox_Page() {
		driver.get("https://demoqa.com/checkbox");
		test = extent.createTest(this.getClass().getSimpleName().toUpperCase());
		/*
		 * pointX = CheckBox_POM.checkBoxTree_wrapper.getLocation().getX();
		 * pointY = CheckBox_POM.checkBoxTree_wrapper.getLocation().getY();
		 * eleWidth =
		 * CheckBox_POM.checkBoxTree_wrapper.getSize().getWidth(); eleHeight
		 * = CheckBox_POM.checkBoxTree_wrapper.getSize().getHeight();
		 */

	}

	@BeforeMethod
	public void settingUp() {
		actual_checkedItems_List = new ArrayList<String>();
	}

	@Test(priority = 7)
	public void testing_Unexpanded_Expansion() {
		try {
			Assert.assertFalse(CheckBox_POM.checkBox_expanded_Level1.isDisplayed());
		} catch (NoSuchElementException e) {
			log.info("List is not expanded");
		}
	}

	@Test(priority = 8)
	public void testing_ExpandAll_Button() {
		Assert.assertTrue(CheckBox_POM.expandAllButton.isEnabled());
		CheckBox_POM.expandAllButton.click();
		expandedItems = driver.findElements(By.xpath("//li[@class=\"rct-node rct-node-parent rct-node-expanded\"]"));
		Assert.assertEquals(6, expandedItems.size());

	}

	@Test(priority = 9)
	public void testing_CollapseAll_Button() {
		Assert.assertTrue(CheckBox_POM.expandAllButton.isEnabled());
		CheckBox_POM.collapseAllButton.click();
		expandedItems = driver.findElements(By.xpath("//li[@class=\"rct-node rct-node-parent rct-node-expanded\"]"));
		Assert.assertEquals(0, expandedItems.size());
	}

	@Test(priority = 10)
	public void testing_desktop_checkBox_text_by_Checking() {
		CheckBox_POM.expandAllButton.click();
		Assert.assertFalse(CheckBox_POM.checkBox_Desktop.isSelected());
		CheckBox_POM.checkBox_Desktop.click();
		checkedItemsWebElements = driver.findElements(By.xpath("//span[@class=\"text-success\"]"));
		String[] expected_checkedItems = { "desktop", "notes", "commands" };
		expected_checkedItems_List = Arrays.asList(expected_checkedItems);

		Assert.assertEquals(expected_checkedItems_List.size(), checkedItemsWebElements.size());

		for (int i = 0; i < checkedItemsWebElements.size(); i++) {
			WebElement checkedElement = checkedItemsWebElements.get(i);
			actual_checkedItems_List.add(checkedElement.getText());
		}
		Assert.assertEquals(actual_checkedItems_List, expected_checkedItems_List);
	}

	@Test(priority = 11)
	public void testing_desktop_checkBox_text_by_UnChecking() {
		CheckBox_POM.checkBox_Desktop.click();
		Assert.assertFalse(CheckBox_POM.checkBox_Desktop.isSelected());
		checkedItemsWebElements = driver.findElements(By.xpath("//span[@class=\"text-success\"]"));
		Assert.assertEquals(0, checkedItemsWebElements.size());
	}

	@Test(priority = 12)
	public void testing_documents_checkBox_text_by_Checking() {
		CheckBox_POM.expandAllButton.click();
		Assert.assertFalse(CheckBox_POM.checkBox_Documents.isSelected());
		CheckBox_POM.checkBox_Documents.click();
		checkedItemsWebElements = driver.findElements(By.xpath("//span[@class=\"text-success\"]"));
		String[] expected_checkedItems = { "documents", "workspace", "react", "angular", "veu", "office", "public",
				"private", "classified", "general" };
		expected_checkedItems_List = Arrays.asList(expected_checkedItems);
		Assert.assertEquals(expected_checkedItems_List.size(), checkedItemsWebElements.size());

		for (int i = 0; i < checkedItemsWebElements.size(); i++) {
			WebElement checkedElement = checkedItemsWebElements.get(i);
			actual_checkedItems_List.add(checkedElement.getText());
		}
		Assert.assertEquals(actual_checkedItems_List, expected_checkedItems_List);
	}

	@Test(priority = 13)
	public void testing_documents_checkBox_text_by_UnChecking() {
		CheckBox_POM.checkBox_Documents.click();
		Assert.assertFalse(CheckBox_POM.checkBox_Documents.isSelected());
		checkedItemsWebElements = driver.findElements(By.xpath("//span[@class=\"text-success\"]"));
		Assert.assertEquals(0, checkedItemsWebElements.size());
	}

	@Test(priority = 14)
	public void testing_downloads_checkBox_text_by_Checking() {
		CheckBox_POM.expandAllButton.click();
		Assert.assertFalse(CheckBox_POM.checkBox_Downloads.isSelected());
		CheckBox_POM.checkBox_Downloads.click();
		checkedItemsWebElements = driver.findElements(By.xpath("//span[@class=\"text-success\"]"));
		String[] expected_checkedItems = { "downloads", "wordFile", "excelFile" };
		expected_checkedItems_List = Arrays.asList(expected_checkedItems);

		Assert.assertEquals(expected_checkedItems_List.size(), checkedItemsWebElements.size());

		for (int i = 0; i < checkedItemsWebElements.size(); i++) {
			WebElement checkedElement = checkedItemsWebElements.get(i);
			actual_checkedItems_List.add(checkedElement.getText());
		}
		Assert.assertEquals(actual_checkedItems_List, expected_checkedItems_List);
	}

	@Test(priority = 15)
	public void testing_downloads_checkBox_text_by_UnChecking() {
		CheckBox_POM.checkBox_Downloads.click();
		Assert.assertFalse(CheckBox_POM.checkBox_Downloads.isSelected());
		checkedItemsWebElements = driver.findElements(By.xpath("//span[@class=\"text-success\"]"));
		Assert.assertEquals(0, checkedItemsWebElements.size());
	}
}
