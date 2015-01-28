package automationFramework;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class BasePage {
	public WebDriver driver = null;

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
		// Runs on firefox.
		driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://login.xero.com/");
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		driver.quit();
	}

	public WebDriver getDriver() {
		return this.driver;
	}

}
