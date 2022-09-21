package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DemoPage2 {

	WebDriver driver;
	Properties prop1;

	public DemoPage2(WebDriver driver, Properties prop1) {
		this.driver = driver;
		this.prop1 = prop1;
	}

	By country = By.xpath("//select[@id='country']");
	By address = By.xpath("//input[@id='address']");
	By email = By.xpath("//input[@id='email']");
	By phone = By.xpath("//input[@id='phone']");
	By save_button = By.xpath("//button[@id='save']");
	By saved_conformation = By.xpath("//span[@class='tp-saved']");

	public void verifyPageUrl() {
		String heading_ev = "https://example.testproject.io/web/";
		String heading_av = driver.getCurrentUrl();
		Assert.assertEquals(heading_av, heading_ev);
	}

	public void selectCountry() throws Exception {
		WebElement country1 = driver.findElement(country);
		Select select_country = new Select(country1);
		select_country.selectByVisibleText(prop1.getProperty("country1"));
		Thread.sleep(3000);
		String country_av = select_country.getFirstSelectedOption().getText();
		String country_ev = prop1.getProperty("country1");
		Assert.assertEquals(country_av, country_ev);
		System.out.println(country_av);
		Thread.sleep(2000);
	}

	public void clearCountry() throws Exception {
		WebElement country1 = driver.findElement(country);
		Select select_country = new Select(country1);
		select_country.selectByVisibleText("");
		Thread.sleep(2000);
		String country_av = select_country.getFirstSelectedOption().getText();
		String country_ev = "";
		Assert.assertEquals(country_av, country_ev);
		System.out.println(country_av);
		Thread.sleep(2000);
	}

	public void enterAddress() throws Exception {
		driver.findElement(address).sendKeys(prop1.getProperty("address1"));
		Thread.sleep(3000);
		String address_av = driver.findElement(address).getAttribute("value");
		String address_ev = prop1.getProperty("address1");
		Assert.assertEquals(address_av, address_ev);
	}

	public void clearAddress() throws Exception {
		driver.findElement(address).clear();
		Thread.sleep(2000);
		String address_av = driver.findElement(address).getAttribute("value");
		String address_ev = "";
		Assert.assertEquals(address_av, address_ev);
	}

	public void enterEmail() throws Exception {
		driver.findElement(email).sendKeys(prop1.getProperty("email1"));
		Thread.sleep(3000);
		String email_av = driver.findElement(email).getAttribute("value");
		String email_ev = prop1.getProperty("email1");
		Assert.assertEquals(email_av, email_ev);
	}

	public void clearEmail() throws Exception {
		driver.findElement(email).clear();
		Thread.sleep(2000);
		String email_av = driver.findElement(email).getAttribute("value");
		String email_ev = "";
		Assert.assertEquals(email_av, email_ev);
	}

	public void enterPhone() throws Exception {
		driver.findElement(phone).sendKeys(prop1.getProperty("phone1"));
		Thread.sleep(3000);
		String phone_av = driver.findElement(phone).getAttribute("value");
		String phone_ev = prop1.getProperty("phone1");
		Assert.assertEquals(phone_av, phone_ev);
	}

	public void clearPhone() throws Exception {
		driver.findElement(phone).clear();
		Thread.sleep(2000);
		String phone_av = driver.findElement(phone).getAttribute("value");
		String phone_ev = "";
		Assert.assertEquals(phone_av, phone_ev);
	}

	public void clickOnSaveButton() throws Exception {
		driver.findElement(save_button).click();
		Thread.sleep(3000);
	}

	public void confirmSubmition() {
		String saved_conformation_av = driver.findElement(saved_conformation).getText();
		String saved_conformation_ev = "Saved";
		Assert.assertEquals(saved_conformation_av, saved_conformation_ev);
	}

}
