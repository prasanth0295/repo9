package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.TestBase;

public class POM21_BrowserWindows extends TestBase{

	@FindBy(id="tabButton")
	public WebElement BrowserWindows_tabButton;
	
	@FindBy(id="windowButton")
	public WebElement BrowserWindows_windowButton;
	
	@FindBy(id="messageWindowButton")
	public WebElement BrowserWindows_messageWindowButton;
	
	@FindBy(id="sampleHeading")
	public WebElement BrowserWindows_newTab;
	
	@FindBy(xpath="/html/body")
	public WebElement BrowserWindows_newMessageWindow;
	}
