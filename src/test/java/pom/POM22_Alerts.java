package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.TestBase;

public class POM22_Alerts extends TestBase {
	@FindBy(id = "alertButton")
	public WebElement Alerts_alertButton;

	@FindBy(id = "timerAlertButton")
	public WebElement Alerts_timerAlertButton;

	@FindBy(id = "confirmButton")
	public WebElement Alerts_confirmButton;

	@FindBy(id = "promtButton")
	public WebElement Alerts_promtButton;

	@FindBy(id = "confirmResult")
	public WebElement Alerts_confirmResult;

	@FindBy(id = "promptResult")
	public WebElement Alerts_promptResult;

}
