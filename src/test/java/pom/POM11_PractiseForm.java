package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.TestBase;

public class POM11_PractiseForm extends TestBase {

	@FindBy(id="firstName")
	public WebElement firstName;
	
	@FindBy(id="lastName")
	public WebElement lastName;
	
	@FindBy(id="userEmail")
	public WebElement userEmail;
	
	@FindBy(id="userNumber")
	public WebElement userNumber;
	
	@FindBy(xpath="//*[@class=\"custom-control custom-radio custom-control-inline\"][1]")
	public WebElement radio_male;
	
	
	@FindBy(id="dateOfBirthInput")
	public WebElement dateOfBirthInput;
	
	@FindBy(id="subjectsContainer")
	public WebElement subjectsContainer;
	
	@FindBy(id="currentAddress")
	public WebElement currentAddress;
	
	@FindBy(id="state")
	public WebElement state;
	
	@FindBy(id="city")
	public WebElement city;
	
	@FindBy(id="submit")
	public WebElement submit;

	@FindBy(xpath = "//*[@class=\"main-header\"]")
	public WebElement header;
	
	
}
