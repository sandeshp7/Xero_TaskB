package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.AccountsPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.NewInvoicePage;
import automationFramework.BasePage;
import static org.testng.Assert.assertTrue;

public class RepeatingInvoiceTest extends BasePage {
	protected final String userName = "sandeshp7@gmail.com";
	protected final String password = "Wolverine@7";

/*
 * This is a test to verify if the user can add a repeating invoice	
 */
  @Test
  public void TestUserCanAddRepeatingInvoice() {
	  
	  //initializing LoginPage
	  LoginPage LoginPageObj = PageFactory.initElements(driver, LoginPage.class);
	  
	  //Using page object chaining patter to login and return dashboard page object
	  DashboardPage dashboardPageObj = LoginPageObj
			  .input_Email(userName)
			  .input_Password(password)
			  .click_Login();
	  
	  //checking if login was successful
	  assertTrue(dashboardPageObj
			  .isDashboardVisible(), "Dashboard page did not load");
	  
	  //Navigating to sales page
	  AccountsPage accountsPageObj = dashboardPageObj
			  .navigateToSalesPage();
	  
	  //checking if sales page is loaded
	  assertTrue(accountsPageObj
			  .isPage("Sales"), "Sales page did not load");
	  
	  //Navigating to add new repeating invoice page
	  NewInvoicePage newInvoicePageObj = accountsPageObj
			  .click_Repeating()
			  .add_RepeatingInvoice();
	  
	  //Adding repeating invoice and checking if it has been added successfully.
	  assertTrue(newInvoicePageObj
			  .input_StartDate("31 Mar 2015")
			  .input_DueDateDay("5")
			  .select_SaveAsState("saveAsDraft")
			  .input_PaidToField("ABC")
			  .input_Reference()
			  .input_Item("BOOK")
			  .click_Save()
			  .isInvoiceAdded(),"Repeating invoice did not save");
  }
  
  /*
   * This is a test to verify if the user can approve a saved repeating invoice	
   */
  @Test(dependsOnMethods = { "TestUserCanAddRepeatingInvoice" })
  public void TestUserCanApproveSavedInvoice() {
	  
	//initializing LoginPage
	  LoginPage LoginPageObj = PageFactory.initElements(driver, LoginPage.class);
	  
	//Using page object chaining patter to login and return dashboard page object
	  DashboardPage dashboardPageObj = LoginPageObj
			  .input_Email(userName)
			  .input_Password(password)
			  .click_Login();
	  
	//checking if login was successful
	  assertTrue(dashboardPageObj
			  .isDashboardVisible(), "Dashboard page did not load");
	  
	//Navigating to sales page
	  AccountsPage accountsPageObj = dashboardPageObj
			  .navigateToSalesPage();
	  
	  //checking if sales page is loaded
	  assertTrue(accountsPageObj
			  .isPage("Sales"), "Sales page did not load");
	  
	  //Approving the saved invoice and checking if it has been approved
	  assertTrue(accountsPageObj
			  .click_Repeating()
			  .approve_RepeatingInvoice()
			  .isInvoiceApproved(),"Repeating invoice did not get approved");
  }
  
  /*
   * This is a test to verify if the user can delete a saved repeating invoice	
   */
  @Test(dependsOnMethods = { "TestUserCanAddRepeatingInvoice" })
  public void TestUserCanDeleteInvoice() {
	//initializing LoginPage
	  LoginPage LoginPageObj = PageFactory.initElements(driver, LoginPage.class);
	  
	//Using page object chaining patter to login and return dashboard page object
	  DashboardPage dashboardPageObj = LoginPageObj
			  .input_Email(userName)
			  .input_Password(password)
			  .click_Login();
	  
	//checking if login was successful
	  assertTrue(dashboardPageObj
			  .isDashboardVisible(), "Dashboard page did not load");
	  
	//Navigating to sales page
	  AccountsPage accountsPageObj = dashboardPageObj
			  .navigateToSalesPage();
	  
	  //checking if sales page is loaded
	  assertTrue(accountsPageObj
			  .isPage("Sales"), "Sales page did not load");
	  
	  //Deleting the saved invoice and checking if it has been deleted.
	  assertTrue(accountsPageObj
			  .click_Repeating()
			  .delete_RepeatingInvoice()
			  .isInvoiceDeleted(),"Repeating invoice is not deleted ");
  }
 
}
