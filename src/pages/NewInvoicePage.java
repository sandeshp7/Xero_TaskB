package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.internal.thread.TestNGThread;

public class NewInvoicePage {
	final WebDriver driver;

	// WebElements on New Invoice page are defined here
	@FindBy(how = How.ID, using = "StartDate")
	private WebElement startDateField;

	@FindBy(how = How.ID, using = "DueDateDay")
	private WebElement dueDateDay;

	// Methods for NEw invoice page and implemented here
	public NewInvoicePage(WebDriver driver) {
		this.driver = driver;
	}

	public NewInvoicePage input_StartDate(String startDate) {
		startDateField.sendKeys(startDate);
		return this;
	}

	public NewInvoicePage input_DueDateDay(String dueDate) {
		dueDateDay.sendKeys(dueDate);
		return this;
	}

	public NewInvoicePage select_SaveAsState(String id) {
		driver.findElement(By.id(id)).click();
		return this;
	}

	public NewInvoicePage input_PaidToField(String paidToValue) {
		driver.findElement(By.xpath("//input[contains(@id,'PaidToName')]"))
				.sendKeys(paidToValue);
		try {
			TestNGThread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='search-item']")).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}

	public NewInvoicePage input_Reference() {
		driver.findElement(
				By.xpath("//div[@class='controls']/input[contains(@id,'Reference')]"))
				.sendKeys("[Week]");
		return this;
	}

	public NewInvoicePage input_Item(String item) {
		driver.findElement(
				By.xpath("//div[contains(@class,'x-grid3-col-colPriceList')]"))
				.click();
		driver.findElement(
				By.xpath("//div[contains(@class,'x-small-editor')]//input"))
				.sendKeys(item);
		try {
			TestNGThread.sleep(2000);
			driver.findElement(
					By.xpath("//div[contains(@class,'x-combo-list-item')]"))
					.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}

	public AccountsPage click_Save() {
		driver.findElement(By.xpath("//span[text()='Save']")).click();
		return PageFactory.initElements(driver, AccountsPage.class);
	}
}
