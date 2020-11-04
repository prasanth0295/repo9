package base;

import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom.POM11_PractiseForm;
import pom.POM1_TextBox;
import pom.POM21_BrowserWindows;
import pom.POM22_Alerts;
import pom.POM23_Frames;
import pom.POM2_CheckBox;
import pom.POM3_RadioButton;
import pom.POM4_WebTables;
import pom.POM5_Buttons;
import pom.POM6_Links;
import utils.TestUtils;

public class TestBase {

	public static WebDriver driver;

	public String timeStamp = new Date().toString().replace(" ", "_").replace(":", "_").trim();
	public String screenshotfilepath = "G:\\practiseSelenium\\maven2\\test-output\\screenshots\\Evidance of the method - "
			+ timeStamp + ".jpeg";
	
	public static POM1_TextBox TextBox_POM;
	public static POM2_CheckBox CheckBox_POM;
	public static POM3_RadioButton RadioButton_POM;
	public static POM4_WebTables WebTables_POM;
	public static POM5_Buttons Buttons_POM;
	public static POM6_Links Links_POM;
	public static POM11_PractiseForm PractiseForm_POM;
	public static POM21_BrowserWindows BrowserWindows_POM;
	public static POM22_Alerts Alerts_POM;
	public static POM23_Frames Frames_POM;
	
	public static int eleWidth;
	public static int eleHeight;
	public static int pointX;
	public static int pointY;
	
	public TestUtils utils;

	public static Logger log;

	public static ExtentTest test;
	public static ExtentReports extent;
	public static ExtentHtmlReporter htmlReporter;

	@AfterSuite
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

	@BeforeSuite
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		TextBox_POM = PageFactory.initElements(driver, POM1_TextBox.class);
		CheckBox_POM = PageFactory.initElements(driver, POM2_CheckBox.class);
		RadioButton_POM = PageFactory.initElements(driver, POM3_RadioButton.class);
		WebTables_POM = PageFactory.initElements(driver, POM4_WebTables.class);
		Buttons_POM = PageFactory.initElements(driver, POM5_Buttons.class);
		Links_POM = PageFactory.initElements(driver, POM6_Links.class);
		PractiseForm_POM = PageFactory.initElements(driver, POM11_PractiseForm.class);
		BrowserWindows_POM = PageFactory.initElements(driver, POM21_BrowserWindows.class);
		Alerts_POM = PageFactory.initElements(driver, POM22_Alerts.class);
		Frames_POM = PageFactory.initElements(driver, POM23_Frames.class);

		utils = new TestUtils();
		
		log = Logger.getLogger("devpinoyLogger");
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/ExtentReport.html");
		extent = new ExtentReports(); // create object of ExtentReports
		extent.attachReporter(htmlReporter);

		htmlReporter.config().setDocumentTitle("Automation Report"); // Tittle of Report
		htmlReporter.config().setReportName("Extent Report V4"); // Name of the report
		htmlReporter.config().setTheme(Theme.DARK);// Default Theme of Report

		// General information releated to application
		extent.setSystemInfo("Application Name", "Testing ToolsQA");
		extent.setSystemInfo("User Name", "Surya Prasanth");
		extent.setSystemInfo("Envirnoment", "Production");
	}
}
