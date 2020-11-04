package testcases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;

public class TC21_BrowserWindows_Page extends TestBase {
	private Set window_handles;
	private String existing_window;
	private String new_window;

	@BeforeClass
	public void opening_BrowserWindows_Page() {
		driver.get("https://demoqa.com/browser-windows");
		test = extent.createTest(this.getClass().getSimpleName().toUpperCase());

	}

	@BeforeMethod
	private void setting_Handles_set() {
		window_handles = new TreeSet();
	}

	@Test(priority = 32)
	private void testing_New_Tab_Button() {
		Assert.assertTrue(BrowserWindows_POM.BrowserWindows_tabButton.isEnabled());
		existing_window = driver.getWindowHandle();
		BrowserWindows_POM.BrowserWindows_tabButton.click();
		window_handles = driver.getWindowHandles();
		Assert.assertNotNull(window_handles.size());
		log.info(window_handles);
		String new_window = switchToNew(window_handles, existing_window);
		driver.switchTo().window(new_window);
		log.info("Message in the new tab ------------------------------------------ "
				+ BrowserWindows_POM.BrowserWindows_newTab.getText());
		driver.switchTo().window(existing_window);
		log.info("Title of the existing tab **************************************" + driver.getTitle());
	}

	@Test(priority = 33)
	private void testing_New_Window_Button() {
		Assert.assertTrue(BrowserWindows_POM.BrowserWindows_windowButton.isEnabled());
		BrowserWindows_POM.BrowserWindows_windowButton.click();
		window_handles = driver.getWindowHandles();
		Assert.assertNotNull(window_handles.size());
		log.info(window_handles);
		driver.switchTo().window(new_window);
		log.info("Title of the new window ----------------------------" + driver.getTitle());
		driver.switchTo().window(existing_window);
		log.info("Title of the existing window *****************************" + driver.getTitle());
	}

	@Test(priority = 34)
	private void testing_New_Window_with_Message_Button() {
		Assert.assertTrue(BrowserWindows_POM.BrowserWindows_messageWindowButton.isEnabled());
		BrowserWindows_POM.BrowserWindows_messageWindowButton.click();
		window_handles = driver.getWindowHandles();
		Assert.assertNotNull(window_handles.size());
		log.info(window_handles);
		driver.switchTo().window(new_window);
		log.info("Message in the new window ----------------------------------"
				+ BrowserWindows_POM.BrowserWindows_newMessageWindow.getText());
		driver.switchTo().window(existing_window);
		log.info("Title of the existing message window ******************" + driver.getTitle()
				+ " ***********************************");
	}

	private String switchToNew(Set window_handles, String existing_window) {

		Iterator itr = window_handles.iterator();
		ArrayList handles_list = new ArrayList();
		while (itr.hasNext()) {
			String handle = itr.next().toString();
			handles_list.add(handle);
		}
		for (int i = 0; i < handles_list.size(); i++) {
			if (handles_list.get(i).equals(existing_window)) {

			} else {
				new_window = handles_list.get(i).toString();
			}
		}
		return new_window;
	}

}
