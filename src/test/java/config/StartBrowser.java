package config;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import java.lang.reflect.Method;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import com.aventstack.extentreports.reporter.ExtentXReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;

public class StartBrowser {
	public static WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public ExtentXReporter extentxReporter;
	public ExtentReports extent;
	public static ExtentTest parentTest;
	public static ExtentTest childTest;

	@BeforeTest
	public void report() {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("Report/MyReport.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@BeforeMethod
	public void Method(Method method) {
		parentTest = extent.createTest(method.toString());
	}

	@Test
	public void launch() {
		driver.get("http://google.com");
	}

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
		extent.flush();
	}

}
