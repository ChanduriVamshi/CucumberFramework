package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class LoginPage 
{
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath="//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
	private WebElement login;
	
	@FindBy(xpath="//*[text()='Invalid credentials']")
	private WebElement invalidCredentials;
	
	public void enterUsername(String uname)
	{
		elementUtils.typeTextIntoElement(username, uname, CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	public void enterPassword(String pwd)
	{
		elementUtils.typeTextIntoElement(password, pwd, CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	public DashboardPage clickOnLogin()
	{
		elementUtils.clickOnElement(login, CommonUtils.EXPLICIT_WAIT_TIME);
		return new DashboardPage(driver);
	}
	
	public String getInvalidCredentialsText()
	{
		return elementUtils.getTextFromElement(invalidCredentials, CommonUtils.EXPLICIT_WAIT_TIME);
	}
}
