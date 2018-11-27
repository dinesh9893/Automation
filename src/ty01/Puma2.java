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

public class Puma2 {
	static {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	}
	
	
	public static void main(String[] args) throws Exception {
		WebDriver driver=new ChromeDriver();
		//Actions ac=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://in.puma.com/");
		//List<WebElement> menus = driver.findElements(By.xpath("//ul[contains(@class,'digimeg-group')]/li"));
//		List<WebElement> menus = driver.findElements(By.xpath("//div[contains(@class,'digimeg-nav-item')]/div/div/ul/li//a"));
		String t = driver.findElement(By.xpath("(//a[.='Basket Heart'])[2]")).getText();
		System.out.println(t);
//		for(WebElement e:menus) {
//			//Thread.sleep(1000);
//			//ac.moveToElement(e).perform();
//			String alltext=e.getText();
//			System.out.println(alltext);
//			//Reporter.log(alltext,true);
//		}
		
		
		
		Thread.sleep(2000);
		driver.close();
	}

}
