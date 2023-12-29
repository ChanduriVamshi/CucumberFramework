package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import pages.LoginPage;

public class Login
{
	WebDriver driver;
	
	LoginPage loginPage;
	DashboardPage dashboardPage;
	
	@Given("User navigates to login page")
	public void user_navigates_to_login_page() throws Exception 
	{
		driver = DriverFactory.getDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(10000);
	}

	@When("User enters valid username {string} and valid password {string}")
	public void user_enters_valid_username_and_valid_password(String username, String password) 
	{
		driver = DriverFactory.getDriver();
		loginPage = new LoginPage(driver);
		
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
	}

	@And("User clicks on login")
	public void user_clicks_on_login() 
	{
		dashboardPage = loginPage.clickOnLogin();
	}

	@Then("User should be able to login successfully")
	public void user_should_be_able_to_login_successfully() throws Exception 
	{
		Thread.sleep(10000);
		Assert.assertTrue(dashboardPage.getHeaderText().contains("Dashboard"));
	}

	@When("^User enters invalid username (.+)$")
	public void user_enters_invalid_username(String username) 
	{
		loginPage = new LoginPage(driver);
		loginPage.enterUsername(username);
	}
	
	@And("^User enters invalid password (.+)$")
	public void user_enters_invalid_password(String password) 
	{
		loginPage.enterPassword(password);
	}

	@Then("User should not be able to login successfully")
	public void user_should_not_be_able_to_login_successfully() throws Exception 
	{
		Thread.sleep(10000);
		Assert.assertTrue(loginPage.getInvalidCredentialsText().contains("Invalid credentials"));
	}

}
