package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.internal.thread.TestNGThread;

public class AccountsPage {
	final WebDriver driver;
	
	//WebElements on Accounts page are defined here
	@FindBy(how = How.ID, using = "page_title")
    private WebElement pageTitle;
	
	@FindBy(how = How.LINK_TEXT, using = "Repeating")
    private WebElement repeatingLink;
	
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "New Repeating Invoice")
    private WebElement newRepeatingInvoiceLink;
	
	//Methods for accounts page and implemented here
	public AccountsPage(WebDriver driver) {
        this.driver = driver;
    }
	
	public boolean isPage(String pageName) {


		return pageTitle.getText().contains(pageName);
	}
	
	public AccountsPage click_Repeating() {
		repeatingLink.click();
		return this;
	}
	
	public NewInvoicePage add_RepeatingInvoice() {
		newRepeatingInvoiceLink.click();
		return PageFactory.initElements(driver, NewInvoicePage.class);
	}
	
	public AccountsPage approve_RepeatingInvoice() {
		driver.findElement(By.xpath("//tbody/tr//input[@name='selectedInvoices']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Approve')]")).click();
		try {
			TestNGThread.sleep(2000);
			driver.findElement(By.xpath("//span[text()='OK']")).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public AccountsPage delete_RepeatingInvoice() {
		driver.findElement(By.xpath("//tbody/tr//input[@name='selectedInvoices']")).click();
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		try {
			TestNGThread.sleep(2000);
			driver.findElement(By.xpath("//span[text()='OK']")).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public boolean isInvoiceAdded() {
		try {
			TestNGThread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return driver.findElement(By.xpath("//tbody/tr")).isDisplayed();
	
	}
	
	public boolean isInvoiceApproved() {
		try {
			TestNGThread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return driver.findElement(By.xpath("//tbody/tr/td[contains(text(),'Approved')]")).isDisplayed();
	}
	
	public boolean isInvoiceDeleted() {

		try {
			TestNGThread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return driver.findElement(By.xpath("//div[contains(@class,'document')]")).getText().contains("There are no items to display.");
	}
	
}
