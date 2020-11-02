package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class POM5_Buttons {
	
	@FindBy(xpath = "//div[text()=\"Buttons\"]")
	public WebElement buttons_header;
	
	@FindBy(xpath = "//*[text()=\"Double Click Me\"]")
	public WebElement buttons_double_click;
	

	@FindBy(xpath = "//*[text()=\"Right Click Me\"]")
	public WebElement buttons_right_click;
	

	@FindBy(xpath = "//*[text()=\"Click Me\"]")
	public WebElement buttons_left_click;
	
	@FindBy(xpath = "//p[@id=\"dynamicClickMessage\"]")
	public WebElement text_after_left_click;
	
	@FindBy(xpath = "//p[@id=\"rightClickMessage\"]")
	public WebElement text_after_right_click;
	
	@FindBy(xpath = "//p[@id=\"doubleClickMessage\"]")
	public WebElement text_after_double_click;
}
