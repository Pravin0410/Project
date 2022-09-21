package tests_extendR;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	static ExtentReports extent;

	@BeforeSuite
	public void StartReport() {
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/SparkReport.html");
		extent.attachReporter(spark);
	}

	@AfterSuite
	public void EndReport() {
		extent.flush();
	}
	
	public static String screenshot(WebDriver driver, ITestResult result) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		String screenshotpath = "C:\\Users\\ROHIT\\Downloads\\AutomationScreenshot\\"+result.getName()+dateName+".png";
		//String screenshotpath = "./Screenshots/ExecuteTestsScreenshots"+result.getName()+dateName+".png";
		File dsc = new File(screenshotpath);
		FileUtils.copyFile(src, dsc);
		return screenshotpath;
		
	}
}
