package ty01;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Furlenko {
	static {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	}
	
	@Test
	public void test1() throws Exception {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.furlenco.com/");
		driver.findElement(By.xpath("//div[.='Bengaluru']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[.='Living Room'])[2]")).click();
		Thread.sleep(3000);
		String txt = driver.findElement(By.xpath("//span[contains(.,'Rent our Pico Three-seater')]/../../..")).getText();
		Reporter.log(txt,true);
	}

}
