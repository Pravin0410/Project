package tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.DemoPage2;

public class ExecuteTests2 {

	static WebDriver driver;
	static Properties prop1;
	static DemoPage2 dmp2;

	@Test(priority = 0)
	public void Test_PageUrl() {
		driver = ExecuteTests.driver;
		prop1 = ExecuteTests.prop1;
		dmp2 = new DemoPage2(driver, prop1);
		dmp2.verifyPageUrl();
	}

	@Test(priority = 1)
	public void Test_Country() throws Exception {
		dmp2.selectCountry();
		dmp2.clearCountry();
		dmp2.selectCountry();
	}

	@Test(priority = 2)
	public void Test_Address() throws Exception {
		dmp2.enterAddress();
		dmp2.clearAddress();
		dmp2.enterAddress();
	}

	@Test(priority = 3)
	public void Test_Email() throws Exception {
		dmp2.enterEmail();
		dmp2.clearEmail();
		dmp2.enterEmail();
}						

	@Test(priority = 4)
	public void Test_Phone() throws Exception {
		dmp2.enterPhone();
		dmp2.clearPhone();
		dmp2.enterPhone();
	}
	
	@Test(priority=5)
	public void Test_Submit_Details() throws Exception {
		dmp2.clickOnSaveButton();
		dmp2.confirmSubmition();
	}

}
