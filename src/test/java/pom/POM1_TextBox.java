package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class POM1_TextBox {
	@FindBy(how = How.XPATH, using = "//*[@id=\"userName\"]")
	public WebElement fullNameTextBox;

	@FindBy(how = How.XPATH, using = "//*[@id=\"userName-wrapper\"]")
	public WebElement fullNameTextBox_Wrapper;

	@FindBy(how = How.XPATH, using = "//*[@id=\"userEmail\"]")
	public WebElement userEmailTextBox;

	@FindBy(how = How.XPATH, using = "//*[@id=\"userEmail-wrapper\"]")
	public WebElement userEmailTextBox_Wrapper;

	@FindBy(how = How.XPATH,using = "//*[@id=\"currentAddress\"]")
	public WebElement currentAddressTextBox;

	@FindBy(how = How.XPATH, using = "//*[@id=\"currentAddress-wrapper\"]")
	public WebElement currentAddressTextBox_Wrapper;

	@FindBy(how = How.XPATH, using = "//textarea[@id=\"permanentAddress\"]")
	public WebElement permanentAddressTextBox;

	@FindBy(how = How.XPATH, using = "//*[@id=\"permanentAddress-wrapper\"]")
	public WebElement permanentAddressTextBox_Wrapper;
	
	@FindBy(how = How.XPATH, using = "//form[@id=\"userForm\"]")
	public WebElement textBox_form;
	
	@FindBy(how = How.XPATH, using = "//button[@id=\"submit\"]")
	public WebElement textbox_submit_button;
	
	@FindBy(how = How.XPATH, using = "//div[@id=\"output\"]")
	public WebElement textbox_output_form;
}
