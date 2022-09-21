package pages;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DemoPage1 {

	WebDriver driver;
	Properties prop1;

	public DemoPage1(WebDriver driver, Properties prop1) {
		this.driver = driver;
		this.prop1 = prop1;
	}

	private By username = By.xpath("//input[@id='name']");
	private By password = By.xpath("//input[@id='password']");
	private By loginButton = By.xpath("//button[@id='login']");
	private By username_errorMsg = By.xpath("//div[@class='invalid-feedback'][contains(text(),'name')]");
	private By password_errorMsg = By.xpath("//div[@class='invalid-feedback'][contains(text(),'Password')]");

	public void enterFullName() throws InterruptedException {
		driver.findElement(username).sendKeys(prop1.getProperty("username1"));
		Thread.sleep(2000);
		String username_input_txt_ev = prop1.getProperty("username1");
		String username_input_txt_av = driver.findElement(username).getAttribute("value");
		Assert.assertEquals(username_input_txt_av, username_input_txt_ev);	
	}

	public void clearFullname() throws InterruptedException {
		driver.findElement(username).clear();
		Thread.sleep(2000);
		String username_input_txt_ev ="";
		String username_input_txt_av = driver.findElement(username).getAttribute("value");
		Assert.assertEquals(username_input_txt_av, username_input_txt_ev);	
	}

	public void enterPassword() throws InterruptedException {
		driver.findElement(password).sendKeys(prop1.getProperty("password1"));
		Thread.sleep(2000);
		String password_input_txt_ev = prop1.getProperty("password1");
		String password_input_txt_av = driver.findElement(password).getAttribute("value");
		Assert.assertEquals(password_input_txt_av, password_input_txt_ev);
	}

	public void clearPassword() throws InterruptedException {
		driver.findElement(password).clear();
		Thread.sleep(2000);
		String password_input_txt_ev = "";
		String password_input_txt_av = driver.findElement(password).getAttribute("value");
		Assert.assertEquals(password_input_txt_av, password_input_txt_ev);
	}

	public void clickOnLoginButton() throws Exception {
		driver.findElement(loginButton).click();
		Thread.sleep(4000);
	}

	public void checkUsernameErrorMessage() {
		String username_errorMsg_ev = "Please provide your full ";
		String username_errorMsg_av = driver.findElement(username_errorMsg).getText();
		Assert.assertEquals(username_errorMsg_av, username_errorMsg_ev);
	}

	public void checkPasswordErrorMessage() {
		String username_errorMsg_ev = "Password is invalid";
		String password_errorMsg_av = driver.findElement(password_errorMsg).getText();
		Assert.assertEquals(password_errorMsg_av, username_errorMsg_ev);
	}

}
