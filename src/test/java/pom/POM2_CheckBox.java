package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class POM2_CheckBox {
	@FindBy(how = How.XPATH, using = "//div/button[1]")
	public WebElement expandAllButton;

	@FindBy(how = How.XPATH, using = "//div/button[2]")
	public WebElement collapseAllButton;

	@FindBy(how = How.XPATH, using = "//div[@class=\"check-box-tree-wrapper\"]")
	public WebElement checkBoxTree_wrapper;

	@FindBy(how = How.XPATH, using = "//span[text()=\"Home\"]")
	public WebElement checkBox_Home;

	@FindBy(how = How.XPATH, using = "//span[text()=\"Desktop\"]")
	public WebElement checkBox_Desktop;

	@FindBy(how = How.XPATH, using = "//span[text()=\"Documents\"]")
	public WebElement checkBox_Documents;

	@FindBy(how = How.XPATH, using = "//span[text()=\"Downloads\"]")
	public WebElement checkBox_Downloads;

	@FindBy(how = How.XPATH, using = "//span[text()=\"WorkSpace\"]")
	public WebElement checkBox_WorkSpace;

	@FindBy(how = How.XPATH, using = "//span[text()=\"Office\"]")
	public WebElement checkBox_Office;
	
	@FindBy (how = How.XPATH, using = "//*[@class=\"rct-node rct-node-parent rct-node-expanded\"]")
	public WebElement checkBox_expanded_Level1;

}
