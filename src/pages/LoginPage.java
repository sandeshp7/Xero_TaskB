package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	final WebDriver driver;

	// WebElements on Login page are defined here
	@FindBy(how = How.ID, using = "email")
	private WebElement emailID;

	@FindBy(how = How.ID, using = "password")
	private WebElement password;

	@FindBy(how = How.ID, using = "submitButton")
	private WebElement loginButton;

	// Methods for login page and implemented here
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage input_Email(String emailValue) {
		emailID.sendKeys(emailValue);
		return this;
	}

	public LoginPage input_Password(String passwordValue) {
		password.sendKeys(passwordValue);
		return this;
	}

	public DashboardPage click_Login() {
		loginButton.click();
		return PageFactory.initElements(driver, DashboardPage.class);
	}
}
