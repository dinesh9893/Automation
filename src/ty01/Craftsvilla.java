package ty01;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Craftsvilla {
	static {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	}

	@Test
	public void test2() throws Exception {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.craftsvilla.com/");
		driver.findElement(By.linkText("SAREES")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@title='Above 5000']")).click();
		String pricestr = driver.findElement(By.xpath("//a[contains(.,'Sareemall')]/..//span")).getText();
		String price1=pricestr.substring(2, pricestr.length());
		int price=Integer.parseInt(price1);
		Reporter.log(price1,true);
		
		
		
		
	}

}
