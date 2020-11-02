package listeners;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.google.common.io.Files;

import base.TestBase;

public class CustomListener extends TestBase implements ITestListener {

	/*
	 * public int eleWidth; public int eleHeight; public int pointX; public int
	 * pointY;
	 */

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult result) {
		String passedMethod = result.getMethod().getMethodName().toUpperCase();
		System.out.println("Method passed is : " + passedMethod);
		String fileName = passedMethod + " at " + timeStamp;
		String screenshotPath = "G:\\practiseSelenium\\maven2\\test-output\\screenshots\\Pass Evidance of the method - "
				+ fileName + ".jpeg";
		screenshot(screenshotPath);
		// screenshotElement(screenshotPath);
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult result) {

		String failedMethod = result.getMethod().getMethodName().toUpperCase();
		System.out.println("Method failed is : " + failedMethod);
		log.info("Failed Method : " + failedMethod);
		String fileName = failedMethod + " at " + timeStamp;
		String screenshotPath = "G:\\practiseSelenium\\maven2\\test-output\\screenshots\\Fail Evidance of the method - "
				+ fileName + ".jpeg";
		screenshot(screenshotPath);
		// screenshotElement(screenshotPath);

		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));

	}

	public void screenshotElement(String screenshotPath) {

		try {
			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			BufferedImage fullImg = ImageIO.read(file);
			BufferedImage eleScreenshot = fullImg.getSubimage(pointX, pointY, eleWidth, eleHeight);
			ImageIO.write(eleScreenshot, "jpeg", file);
			Files.copy(file, new File(screenshotPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Reporter.log("Evidance of the Test");
		Reporter.log("<hr>");
		Reporter.log(
				"<a href='" + screenshotPath + "'> <img src='" + screenshotPath + "' height='200' width='400'/> </a>");
	}

	void screenshot(String screenshotPath) {
		try {
			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			Files.copy(file, new File(screenshotPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Reporter.log("Evidance of the Test");
		Reporter.log("<hr>");
		Reporter.log(
				"<a href='" + screenshotPath + "'> <img src='" + screenshotPath + "' height='200' width='400'/> </a>");
		try {
			test.addScreenCaptureFromPath(screenshotPath, "Evidance of the Test");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
