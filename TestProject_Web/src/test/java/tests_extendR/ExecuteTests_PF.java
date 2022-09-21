package tests_extendR;

import java.io.File;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pages_PF.DemoPage1_PF;
import tests_PF.Config_PF;

public class ExecuteTests_PF {

	static WebDriver driver;
	static Properties prop1;
	static DemoPage1_PF dmp1;
	static ExtentReports extent;
	static ExtentTest test;

	@BeforeClass
	public void startClass() {
//		 extent = new ExtentReports();
//		 ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
//		 extent.attachReporter(spark);
		extent = ExtentReporterNG.extent;
	}

	@AfterClass
	public void endClass() {
		//extent.flush();
	}

	@Test(priority = 0)
	public void Test_OpenWebsite() throws Exception {
		test = extent.createTest("Open Website");
		Config_PF config = new Config_PF();
		driver = config.openwebsite();
		prop1 = config.propertiesFileData();
	}

	@Test(priority = 1)
	public void Test_Username() throws Exception {
		test = extent.createTest("Test Username");
		dmp1 = new DemoPage1_PF(driver, prop1);
		dmp1.enterFullName();
		test.info("Enter Full Name");
		dmp1.clearFullname();
		dmp1.enterFullName();
	}

	@Test(priority = 2)
	public void Test_Password() throws Exception {
		test = extent.createTest("Test Password");
		dmp1.enterPassword();
		dmp1.clearPassword();
		dmp1.enterPassword();
	}

	@Test(priority = 3, dependsOnMethods = { "Test_Username", "Test_OpenWebsite" })
	public void Validate_Username() throws Exception {
		test = extent.createTest("Validate Username");
		dmp1.clearFullname();
		dmp1.clickOnLoginButton();
		dmp1.checkUsernameErrorMessage();
		test.info("Check username validation message");
	}

	@Test(priority = 4, dependsOnMethods = { "Test_Password", "Test_OpenWebsite" })
	public void Validate_Password() throws Exception {
		test = extent.createTest("Validate Password");
		dmp1.clearPassword();
		dmp1.clickOnLoginButton();
		dmp1.checkPasswordErrorMessage();
	}

	@Test(priority = 5)
	public void TestLogin_ValidInput() throws Exception {
		test = extent.createTest("Test Login For Valid Input");
		dmp1.enterFullName();
		dmp1.enterPassword();
		dmp1.clickOnLoginButton();
	}

	@AfterMethod
	public void screenshot(ITestResult result) throws Exception {
		if (ITestResult.FAILURE == result.getStatus()) {
			test.log(Status.FAIL, "Test Failed - "+result.getName());
			test.log(Status.FAIL,result.getThrowable());
			String screenshotpath = ExtentReporterNG.screenshot(driver,result);
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(screenshotpath).build());
		} else if (ITestResult.SUCCESS == result.getStatus()) {
			test.log(Status.PASS, "Test Passed");
		} else {
			test.log(Status.SKIP, "Test Skipped");
		}
	}

}
