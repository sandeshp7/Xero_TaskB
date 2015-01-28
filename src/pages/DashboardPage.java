package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.internal.thread.TestNGThread;

public class DashboardPage {

	final WebDriver driver;

	// WebElements on dashboard page are defined here
	@FindBy(how = How.ID, using = "Dashboard")
	private WebElement dashboardLink;

	@FindBy(how = How.ID, using = "Accounts")
	private WebElement accountsLink;

	@FindBy(how = How.XPATH, using = "//a[text()='Sales']")
	private WebElement salesLink;

	// Methods for dashboard page and implemented here
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDashboardVisible() {
		return dashboardLink.isDisplayed();
	}

	public DashboardPage click_Accounts() {
		try {
			TestNGThread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		accountsLink.click();

		return this;
	}

	public AccountsPage click_Sales() {
		salesLink.click();
		return PageFactory.initElements(driver, AccountsPage.class);
	}

	public AccountsPage navigateToSalesPage() {
		driver.get("https://go.xero.com/Accounts/Receivable/Dashboard/");
		return PageFactory.initElements(driver, AccountsPage.class);
	}

}
