package genric;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public abstract class BaseTest implements IAutoConst{
	
	public WebDriver driver;
	public String url=Utility.getPropertyValue(CONFIG_PATH,"URL");
	String ITO=Utility.getPropertyValue(CONFIG_PATH,"ITO");
	long duration=Long.parseLong(ITO);
	
	static {
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(FIREFOX_KEY, FIREFOX_VALUE);
	}
	
	@Parameters({"ip","browser"})
	@BeforeMethod(alwaysRun=true)
	public void openApp(@Optional("localhost")String ip,@Optional("chrome")String browser)
	{
		driver=Utility.openBrowser(driver, ip, browser);
		driver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);
		driver.get(url);
	}

	@AfterMethod(alwaysRun=true)
	public void closingApp(ITestResult result)
	{
		String name = result.getName();
		int status = result.getStatus();
		if (status == 2) {
			Utility.getPhoto(driver, PHOTO_PATH);
			Reporter.log("Test:" + name + " is Failed", true);
		} else {
			Reporter.log("Test:" + name + " is Passed", true);
		}
		driver.close();
	}
	
}
