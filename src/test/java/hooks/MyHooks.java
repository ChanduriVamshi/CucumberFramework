package hooks;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.CommonUtils;

public class MyHooks 
{
	public static WebDriver driver;
	
	@Before
	public void setup()
	{
		DriverFactory.initializeBrowser("chrome");
		driver = DriverFactory.getDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtils.PAGE_LOAD_TIME));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.IMPLICIT_WAIT_TIME));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@After
	public void tearDown(Scenario scenario)
	{
		String scenarioName = scenario.getName().replaceAll(" ", "");
		if(scenario.isFailed())
		{
			byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenarioName);
		}
		driver.quit();
	}
}
