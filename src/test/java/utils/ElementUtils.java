package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils 
{
	WebDriver driver;
	
	public ElementUtils(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement waitForElement(WebElement ele, long durationInSeconds)
	{
		WebElement webElement = null;
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement =  wait.until(ExpectedConditions.elementToBeClickable(ele));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return webElement;
	}
	
	public Alert waitForAlert(long durationInSeconds)
	{
		Alert alert = null;
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			alert =  wait.until(ExpectedConditions.alertIsPresent());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return alert;
	}
	
	public WebElement waitForElementVisibility(WebElement ele, long durationInSeconds)
	{
		WebElement webElement = null;
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement =  wait.until(ExpectedConditions.visibilityOf(ele));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return webElement;
	}
	
	public void clickOnElement(WebElement ele, long durationInSeconds)
	{
		waitForElement(ele, durationInSeconds).click();
	}
	
	public void typeTextIntoElement(WebElement ele, String textToBeTyped, long durationInSeconds)
	{
		WebElement webElement = waitForElement(ele, durationInSeconds);
		webElement.click();
		webElement.clear();
		webElement.sendKeys(textToBeTyped);
	}
	
	public void selectOptionInDropdown(WebElement ele, String dropdownOption, long durationInSeconds)
	{
		waitForElement(ele, durationInSeconds);
		Select select = new Select(ele);
		select.selectByVisibleText(dropdownOption);
	}
	
	public void acceptAlert(long durationInSeconds)
	{
		Alert alert = waitForAlert(durationInSeconds);
		alert.accept();
	}
	
	public void dismissAlert(long durationInSeconds)
	{
		Alert alert = waitForAlert(durationInSeconds);
		alert.dismiss();
	}
	
	public String getAlertText(long durationInSeconds)
	{
		Alert alert = waitForAlert(durationInSeconds);
		return alert.getText();
	}
	
	public void sendAlertKeys(String alertMessage, long durationInSeconds)
	{
		Alert alert = waitForAlert(durationInSeconds);
		alert.sendKeys(alertMessage);
	}
	
	public void mouseHover(WebElement ele, long durationInSeconds)
	{
		WebElement webElement = waitForElementVisibility(ele, durationInSeconds);
		Actions actions = new Actions(driver);
		actions.moveToElement(webElement).build().perform();
	}
	
	public void javaScriptClick(WebElement ele, long durationInSeconds)
	{
		WebElement webElement = waitForElementVisibility(ele, durationInSeconds);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", webElement);
	}
	
	public void javaScriptSendKeys(WebElement ele, String textToBeTyped, long durationInSeconds)
	{
		WebElement webElement = waitForElementVisibility(ele, durationInSeconds);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value='"+textToBeTyped+"'", webElement);
	}
	
	public String getTextFromElement(WebElement ele, long durationInSeconds)
	{
		WebElement webElement = waitForElementVisibility(ele, durationInSeconds);
		return webElement.getText();
	}
	
	public boolean displayStatusOfElement(WebElement ele, long durationInSeconds)
	{
		WebElement webElement = waitForElementVisibility(ele, durationInSeconds);
		return webElement.isDisplayed();
	}
	
}
