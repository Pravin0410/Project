package pages_PF;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DemoPage2_PF {

	WebDriver driver;
	Properties prop1;

	@FindBy(xpath = "//select[@id='country']")
	WebElement country;
	@FindBy(xpath = "//input[@id='address']")
	WebElement address;
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phone;
	@FindBy(xpath = "//button[@id='save']")
	WebElement save_button;
	@FindBy(xpath = "//span[@class='tp-saved']")
	WebElement saved_conformation;

	public DemoPage2_PF(WebDriver driver, Properties prop1) {
		this.driver = driver;
		this.prop1 = prop1;
		PageFactory.initElements(driver, this);
	}

	public void verifyPageUrl() {
		String heading_ev = "https://example.testproject.io/web/";
		String heading_av = driver.getCurrentUrl();
		Assert.assertEquals(heading_av, heading_ev);
	}

	public void selectCountry() throws Exception {
		Select select_country = new Select(country);
		select_country.selectByVisibleText(prop1.getProperty("country1"));
		Thread.sleep(3000);
		String country_av = select_country.getFirstSelectedOption().getText();
		String country_ev = prop1.getProperty("country1");
		Assert.assertEquals(country_av, country_ev);
		System.out.println(country_av);
		Thread.sleep(2000);
	}

	public void clearCountry() throws Exception {
		Select select_country = new Select(country);
		select_country.selectByVisibleText("");
		Thread.sleep(2000);
		String country_av = select_country.getFirstSelectedOption().getText();
		String country_ev = "";
		Assert.assertEquals(country_av, country_ev);
		System.out.println(country_av);
		Thread.sleep(2000);
	}

	public void enterAddress() throws Exception {
		address.sendKeys(prop1.getProperty("address1"));
		Thread.sleep(3000);
		String address_av = address.getAttribute("value");
		String address_ev = prop1.getProperty("address1");
		Assert.assertEquals(address_av, address_ev);
	}

	public void clearAddress() throws Exception {
		address.clear();
		Thread.sleep(2000);
		String address_av = address.getAttribute("value");
		String address_ev = "";
		Assert.assertEquals(address_av, address_ev);
	}

	public void enterEmail() throws Exception {
		email.sendKeys(prop1.getProperty("email1"));
		Thread.sleep(3000);
		String email_av = email.getAttribute("value");
		String email_ev = prop1.getProperty("email1");
		Assert.assertEquals(email_av, email_ev);
	}

	public void clearEmail() throws Exception {
		email.clear();
		Thread.sleep(2000);
		String email_av = email.getAttribute("value");
		String email_ev = "";
		Assert.assertEquals(email_av, email_ev);
	}

	public void enterPhone() throws Exception {
		phone.sendKeys(prop1.getProperty("phone1"));
		Thread.sleep(3000);
		String phone_av = phone.getAttribute("value");
		String phone_ev = prop1.getProperty("phone1");
		Assert.assertEquals(phone_av, phone_ev);
	}

	public void clearPhone() throws Exception {
		phone.clear();
		Thread.sleep(2000);
		String phone_av = phone.getAttribute("value");
		String phone_ev = "";
		Assert.assertEquals(phone_av, phone_ev);
	}

	public void clickOnSaveButton() throws Exception {
		save_button.click();
		Thread.sleep(3000);
	}

	public void confirmSubmition() {
		String saved_conformation_av = saved_conformation.getText();
		String saved_conformation_ev = "Saved";
		Assert.assertEquals(saved_conformation_av, saved_conformation_ev);
	}

}
