package rough;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.google.common.io.Files;

import base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom.POM1_TextBox;

public class RoughFactory extends TestBase {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/text-box");
		POM1_TextBox pageObjects_TextBox_POM = PageFactory.initElements(driver, POM1_TextBox.class);
		pageObjects_TextBox_POM.fullNameTextBox.sendKeys("Prasanth");

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		BufferedImage fullImg = ImageIO.read(screenshot);
		
		Point point = pageObjects_TextBox_POM.fullNameTextBox.getLocation();
		int eleWidth = pageObjects_TextBox_POM.fullNameTextBox.getSize().getWidth();
		int eleHeight = pageObjects_TextBox_POM.fullNameTextBox.getSize().getHeight();
		BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
		ImageIO.write(eleScreenshot, "jpg", screenshot);
		File screenshotLocation = new File("G:\\practiseSelenium\\maven2\\test-output\\screenshots\\image.jpg");
		Files.copy(screenshot, screenshotLocation);
		driver.close();
	}

}
