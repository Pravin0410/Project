package tests;

import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Config {
	
	private By heading = By.xpath("//h1[contains(text(),'Automation')]");
	

	public WebDriver openwebsite () {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ROHIT\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://example.testproject.io/web/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		
		String heading_ev = "Community Powered Test Automation";
		String heading_av = driver.findElement(heading).getText();
		Assert.assertEquals(heading_av, heading_ev);
		return driver;
		
	}


	public Properties propertiesFileData() throws Exception {
		Properties prop = new Properties();
		FileReader file1 = new FileReader("./PropertiesFiles/UserData.properties");
		prop.load(file1);
		return prop ;
	}
}
