package genric;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest implements IAutoConst{
	
	public WebDriver driver;
	public String url=Utility.getPropertyValue(CONFIG_PATH,"URL");
	String ITO=Utility.getPropertyValue(CONFIG_PATH,"ITO");
	long duration=Long.parseLong(ITO);
	
	static {
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(FIREFOX_KEY, FIREFOX_VALUE);
	}
	
	@BeforeMethod
	public void openApp()
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);
		driver.get(url);
	}

	@AfterMethod
	public void closingApp()
	{
		driver.close();
	}
	
}
