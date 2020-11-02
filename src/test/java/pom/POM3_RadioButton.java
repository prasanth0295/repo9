package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class POM3_RadioButton {

	@FindBy(xpath = "//div[text()=\"Radio Button\"]")
	public WebElement radiobutton_header;

	@FindBy(id = "yesRadio")
	public WebElement radiobutton_yesRadio_text;

	@FindBy(xpath = "//*[@for=\"yesRadio\"]")
	public WebElement radiobutton_yesRadio;

	@FindBy(id = "impressiveRadio")
	public WebElement radiobutton_impressiveRadio_text;

	@FindBy(xpath = "//*[@for=\"impressiveRadio\"]")
	public WebElement radiobutton_impressiveRadio;

	@FindBy(id = "noRadio")
	public WebElement radiobutton_noRadio_text;

	@FindBy(xpath = "//*[@for=\"noRadio\"]")
	public WebElement radiobutton_noRadio;

	@FindBy(xpath = "//*[@class=\"text-success\"]")
	public WebElement radiobutton_textSuccess;

}
