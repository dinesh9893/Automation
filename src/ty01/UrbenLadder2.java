package ty01;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class UrbenLadder2 {
	static {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	}
	
	public static void takeSS(WebDriver driver) {
		Date d = new Date();
		String dateTime=d.toString().replaceAll(":", "-");
		String path="./photo/"+dateTime+".png";
		try {
			TakesScreenshot t=(TakesScreenshot)driver;
			File srcFile =t.getScreenshotAs(OutputType.FILE);
			File destFile=new File(path);
			FileUtils.copyFile(srcFile, destFile);
			}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test1() throws Exception {
		WebDriver driver=new ChromeDriver();
		Actions ac=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.urbanladder.com/");
		driver.findElement(By.xpath("//a[contains(@class,'hide-mobile')]")).click();
		List<WebElement> modules = driver.findElements(By.xpath("//ul[@class='topnav bodytext']/li"));
		for(WebElement mods:modules) {
			Thread.sleep(1000);
			ac.moveToElement(mods).perform();
			Thread.sleep(1000);
			takeSS(driver);
			//Thread.sleep(1000);
			String alltext=mods.getText();
			Reporter.log(alltext,true);
		}
		driver.close();
	}

}
