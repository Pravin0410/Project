package pages_PF;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DemoPage1_PF {

	WebDriver driver;
	Properties prop1;

	@FindBy(xpath="//input[@id='name']") WebElement username ;
	@FindBy(xpath="//input[@id='password']") WebElement password ;
	@FindBy(xpath="//button[@id='login']") WebElement loginButton ;
	@FindBy(xpath="//div[@class='invalid-feedback'][contains(text(),'name')]") WebElement username_errorMsg ;
	@FindBy(xpath="//div[@class='invalid-feedback'][contains(text(),'Password')]") WebElement password_errorMsg ;
		
	public DemoPage1_PF(WebDriver driver, Properties prop1) {
		this.driver = driver;
		this.prop1 = prop1;
		PageFactory.initElements(driver,this);
	}

	public void enterFullName() throws InterruptedException {
		username.sendKeys(prop1.getProperty("username1"));
		Thread.sleep(2000);
		String username_input_txt_ev = prop1.getProperty("username1");
		String username_input_txt_av = username.getAttribute("value");
		Assert.assertEquals(username_input_txt_av, username_input_txt_ev);	
	}

	public void clearFullname() throws InterruptedException {
		username.clear();
		Thread.sleep(2000);
		String username_input_txt_ev ="";
		String username_input_txt_av = username.getAttribute("value");
		Assert.assertEquals(username_input_txt_av, username_input_txt_ev);	
	}

	public void enterPassword() throws InterruptedException {
		password.sendKeys(prop1.getProperty("password1"));
		Thread.sleep(2000);
		String password_input_txt_ev = prop1.getProperty("password1");
		String password_input_txt_av = password.getAttribute("value");
		Assert.assertEquals(password_input_txt_av, password_input_txt_ev);
	}

	public void clearPassword() throws InterruptedException {
		password.clear();
		Thread.sleep(2000);
		String password_input_txt_ev = "";
		String password_input_txt_av = password.getAttribute("value");
		Assert.assertEquals(password_input_txt_av, password_input_txt_ev);
	}

	public void clickOnLoginButton() throws Exception {
		loginButton.click();
		Thread.sleep(4000);
	}

	public void checkUsernameErrorMessage() {
		String username_errorMsg_ev = "Please provide your full ";
		String username_errorMsg_av = username_errorMsg.getText();
		Assert.assertEquals(username_errorMsg_av, username_errorMsg_ev);
	}

	public void checkPasswordErrorMessage() {
		String username_errorMsg_ev = "Password is invalid";
		String password_errorMsg_av = password_errorMsg.getText();
		Assert.assertEquals(password_errorMsg_av, username_errorMsg_ev);
	}

}
