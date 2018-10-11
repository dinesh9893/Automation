package qsp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A2 {

	static {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	}

		public static void main(String[] args) throws Exception  {
			WebDriver driver=new ChromeDriver();
			driver.get("file:///C:/Users/Dinesh/Desktop/Page1.html");
			
			//switch by using index of frame
			driver.switchTo().frame(0);
			driver.findElement(By.id("t2")).sendKeys("a");
			driver.switchTo().parentFrame();
			driver.findElement(By.id("t1")).sendKeys("a");
			
			//switch by using id of frame
			driver.switchTo().frame("f1");
			driver.findElement(By.id("t2")).sendKeys("b");
			driver.switchTo().parentFrame();
			driver.findElement(By.id("t1")).sendKeys("b");
			
			//switch by using path of frame(e) which is webelement type
			WebElement e = driver.findElement(By.id("f1"));
			driver.switchTo().frame(e);
			driver.findElement(By.id("t2")).sendKeys("c");
			driver.switchTo().defaultContent();
			driver.findElement(By.id("t1")).sendKeys("a");
			
		}

}
