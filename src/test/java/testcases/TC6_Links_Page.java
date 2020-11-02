package testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;

public class TC6_Links_Page extends TestBase {

	public String expected_url_normal = "https://demoqa.com/";
	public String actual_url_normal;

	private String expected_url_api = "javascript:void(0)";
	private String actual_url_api;
	
	private String theTextIWant;

	@AfterMethod
	public void refresh_page() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.navigate().refresh();
	}

	@BeforeClass
	public void opening_RadioButton_page() {
		test = extent.createTest(this.getClass().getSimpleName().toUpperCase());
		driver.get("https://demoqa.com/links");
		String actual_Links_Header = Links_POM.links_header.getText();
		String expected_Links_Header = "Links";
		Assert.assertEquals(actual_Links_Header, expected_Links_Header);

	}

	@Test(priority = 23)
	private void testing_simpleLink_link() {
		Assert.assertTrue(Links_POM.links_simpleLink_link.isEnabled());
		actual_url_normal = Links_POM.links_simpleLink_link.getAttribute("href");
		Assert.assertEquals(actual_url_normal, expected_url_normal);
		Links_POM.links_simpleLink_link.click();
	}

	@Test(priority = 24)
	private void testing_dynamicLink_link() {
		Assert.assertTrue(Links_POM.links_dynamicLink_link.isEnabled());
		actual_url_normal = Links_POM.links_dynamicLink_link.getAttribute("href");
		Assert.assertEquals(actual_url_normal, expected_url_normal);
		Links_POM.links_dynamicLink_link.click();
	}

	@Test(priority = 25)
	private void testing_created_link() {
		try {
			Links_POM.links_linkResponse_link.getText();
		} catch (Exception e) {
			log.info("Response Message is not found");
		}
		Assert.assertTrue(Links_POM.links_Created_link.isDisplayed());
		actual_url_api = Links_POM.links_Created_link.getAttribute("href");
		Assert.assertEquals(actual_url_api, expected_url_api);
		Links_POM.links_Created_link.click();
		WebElement element = Links_POM.links_linkResponse_link;
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				System.out.println("Clicking on element with using java script click");
				theTextIWant = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].text;",element);
				System.out.println("**************************************************************************************Text Found  "+theTextIWant);
				//((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);				
			} else {
				System.out.println("Unable to click on element");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document "+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to click on element "+ e.getStackTrace());
		}
			Assert.assertEquals("Link has responded with staus 201 and status text Created",
					theTextIWant);
	}

	@Test(priority = 26)
	private void testing_links_noContent_link() {
		try {
			Links_POM.links_linkResponse_link.getText();
		} catch (Exception e) {
			log.info("Response Message is not found");
		}
		Assert.assertTrue(Links_POM.links_noContent_link.isDisplayed());
		actual_url_api = Links_POM.links_noContent_link.getAttribute("href");
		Assert.assertEquals(actual_url_api, expected_url_api);
		Links_POM.links_noContent_link.click();
		Assert.assertEquals("Link has responded with staus 204 and status text No Content",
				Links_POM.links_linkResponse_link.getText());
	}

	@Test(priority = 27)
	private void testing_links_links_moved_link() {
		try {
			Links_POM.links_linkResponse_link.getText();
		} catch (Exception e) {
			log.info("Response Message is not found");
		}
		Assert.assertTrue(Links_POM.links_moved_link.isEnabled());
		actual_url_api = Links_POM.links_moved_link.getAttribute("href");
		Assert.assertEquals(actual_url_api, expected_url_api);
		Links_POM.links_moved_link.click();
		Assert.assertEquals("Link has responded with staus 301 and status text Moved Permanently",
				Links_POM.links_linkResponse_link.getText());
	}

	@Test(priority = 28)
	private void testing_links_badRequest_link() {
		try {
			Links_POM.links_linkResponse_link.getText();
		} catch (Exception e) {
			log.info("Response Message is not found");
		}
		Assert.assertTrue(Links_POM.links_badRequest_link.isEnabled());
		actual_url_api = Links_POM.links_badRequest_link.getAttribute("href");
		Assert.assertEquals(actual_url_api, expected_url_api);
		Links_POM.links_badRequest_link.click();
		Assert.assertEquals("Link has responded with staus 400 and status text Bad Request",
				Links_POM.links_linkResponse_link.getText());
	}

	@Test(priority = 29)
	private void testing_links_links_unauthorized_link() {
		try {
			Links_POM.links_linkResponse_link.getText();
		} catch (Exception e) {
			log.info("Response Message is not found");
		}
		Assert.assertTrue(Links_POM.links_unauthorized_link.isEnabled());
		actual_url_api = Links_POM.links_unauthorized_link.getAttribute("href");
		Assert.assertEquals(actual_url_api, expected_url_api);
		Links_POM.links_unauthorized_link.click();
		Assert.assertEquals("Link has responded with staus 401 and status text Unauthorized",
				Links_POM.links_linkResponse_link.getText());
	}

	@Test(priority = 30)
	private void testing_links_forbidden_link() {
		try {
			Links_POM.links_linkResponse_link.getText();
		} catch (Exception e) {
			log.info("Response Message is not found");
		}
		Assert.assertTrue(Links_POM.links_forbidden_link.isEnabled());
		actual_url_api = Links_POM.links_forbidden_link.getAttribute("href");
		Assert.assertEquals(actual_url_api, expected_url_api);
		Links_POM.links_forbidden_link.click();
		Assert.assertEquals("Link has responded with staus 403 and status text Forbidden",
				Links_POM.links_linkResponse_link.getText());
	}

	@Test(priority = 31)
	private void testing_links_links_invalidUrl_link() {
		try {
			Links_POM.links_linkResponse_link.getText();
		} catch (Exception e) {
			log.info("Response Message is not found");
		}
		Assert.assertTrue(Links_POM.links_invalidUrl_link.isEnabled());
		actual_url_api = Links_POM.links_invalidUrl_link.getAttribute("href");
		Assert.assertEquals(actual_url_api, expected_url_api);
		Links_POM.links_invalidUrl_link.click();
		Assert.assertEquals("Link has responded with staus 404 and status text Not Found",
				Links_POM.links_linkResponse_link.getText());
	}

}
