package tests;

import java.io.File;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import pages.DemoPage1;

public class ExecuteTests {

	static WebDriver driver;
	static Properties prop1;
    static DemoPage1 dmp1;

	@Test(priority = 0)
	public void Test_OpenWebsite() throws Exception {
		Config config = new Config();
		driver = config.openwebsite();
		prop1 = config.propertiesFileData();
	}

	@Test(priority = 1)
	public void Test_Username() throws Exception {
		dmp1 = new DemoPage1(driver, prop1);
		dmp1.enterFullName();
		dmp1.clearFullname();
		dmp1.enterFullName();
	}

	@Test(priority = 2)
	public void Test_Password() throws Exception {
		dmp1.enterPassword();
		dmp1.clearPassword();
		dmp1.enterPassword();
	}

	@Test(priority = 3,dependsOnMethods= {"Test_Username","Test_OpenWebsite"})
	public void Validate_Username() throws Exception {
		dmp1.clearFullname();
		dmp1.clickOnLoginButton();
		dmp1.checkUsernameErrorMessage();
	}

	@Test(priority = 4,dependsOnMethods= {"Test_Password","Test_OpenWebsite"})
	public void Validate_Password() throws Exception {
		dmp1.clearPassword();
		dmp1.clickOnLoginButton();
		dmp1.checkPasswordErrorMessage();
	}
	
	@Test(priority=5)
	public void TestLogin_ValidInput() throws Exception {
		dmp1.enterFullName();
		dmp1.enterPassword();
		dmp1.clickOnLoginButton();
	}
	
	//@Test(priority = 5,dependsOnMethods= {"Test_OpenWebsite"})
	public void Test_window() {
		ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
		tab.add("current window");
		tab.add("last window");
		System.out.println("printing....."+ tab.get(0));
	}
	
	@AfterMethod
	public void screenshot (ITestResult result) throws Exception {
		if(ITestResult.FAILURE==result.getStatus()) {
			TakesScreenshot screenshot = (TakesScreenshot)driver;
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			File dsc = new File("C:\\Users\\ROHIT\\Downloads\\AutomationScreenshot\\"+result.getName()+".png");
			FileUtils.copyFile(src, dsc);
		}
	}
}
