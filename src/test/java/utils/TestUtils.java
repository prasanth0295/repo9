package utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import com.google.common.io.Files;

import base.TestBase;

public class TestUtils extends TestBase {

	public void takeScreenshot(int pointX, int pointY, int eleWidth, int eleHeight) throws IOException {

		String screenshotPath = "G:\\practiseSelenium\\maven2\\test-output\\screenshots\\Evidance of the Test - "
				+ timeStamp + ".jpeg";

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		BufferedImage fullImg = ImageIO.read(file);

		BufferedImage eleScreenshot = fullImg.getSubimage(pointX, pointY, eleWidth, eleHeight);
		ImageIO.write(eleScreenshot, "jpeg", file);
		File screenshotLocation = new File(screenshotPath);
		Files.copy(file, new File(screenshotPath));
		Reporter.log("Evidance of the Test");
		Reporter.log("<hr>");
		Reporter.log("<br>");
		
		Reporter.log(
				"<a href='" + screenshotPath + "'> <img src='" + screenshotPath + "' height='100' width='400'/> </a>");
	}
	
	public void takeScreenshot(String screenshotpath) throws IOException {

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(file, new File(screenshotpath));
		Reporter.log("Evidance of the Test");
		Reporter.log("<hr>");
		Reporter.log("<br>");
		
		Reporter.log(
				"<a href='" + screenshotpath + "'> <img src='" + screenshotpath + "' height='200' width='400'/> </a>");
	}

}
