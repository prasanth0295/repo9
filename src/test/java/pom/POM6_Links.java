package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.TestBase;

public class POM6_Links extends TestBase {

	@FindBy(xpath = "//*[@class=\"main-header\"]")
	public WebElement links_header;

	@FindBy(id = "simpleLink")
	public WebElement links_simpleLink_link;

	@FindBy(id = "dynamicLink")
	public WebElement links_dynamicLink_link;

	@FindBy(id = "created")
	public WebElement links_Created_link;

	@FindBy(id = "no-content")
	public WebElement links_noContent_link;

	@FindBy(id = "moved")
	public WebElement links_moved_link;

	@FindBy(id = "bad-request")
	public WebElement links_badRequest_link;

	@FindBy(id = "unauthorized")
	public WebElement links_unauthorized_link;

	@FindBy(id = "forbidden")
	public WebElement links_forbidden_link;

	@FindBy(id = "invalid-url")
	public WebElement links_invalidUrl_link;

	@FindBy(xpath ="/html/body/div/div/div/div[2]/div[2]/div[1]/p[10]")
	public WebElement links_linkResponse_link;
	

	/*@FindBy(id="linkResponse")
	public WebElement links_linkResponse_link;*/

}
