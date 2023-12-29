package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage 
{
	WebDriver driver;
	
	public DashboardPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//h6[text()='Dashboard']")
	private WebElement dashboardHeader;
	
	@FindBy(xpath="//ul[@class='oxd-main-menu']/li[8]/a")
	private WebElement dashboardOption;
	
	public String getHeaderText()
	{
		String dashboardHeaderText = dashboardHeader.getText();
		return dashboardHeaderText;
	}
	
}
