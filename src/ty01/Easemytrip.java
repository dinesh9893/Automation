package ty01;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Easemytrip {
	static {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	}
	
	@Test
	public void test1() throws Exception {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.easemytrip.com/");
		Thread.sleep(2000);
		driver.findElement(By.id("FromSector_show")).sendKeys("Delhi");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[.='Delhi(DEL)']")).click();
		driver.findElement(By.id("Editbox13_show")).sendKeys("blr");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[.='Bangalore(BLR)']")).click();
		driver.findElement(By.id("ddate")).click();
		driver.findElement(By.id("snd_2_06/11/2018")).click();
		driver.findElement(By.id("rdate")).click();
		driver.findElement(By.id("frth_3_21/11/2018")).click();
		//driver.findElement(By.xpath("(//a[@class='dropbtn_n'])[1]")).click();
		driver.findElement(By.xpath("//input[@onclick='VisitValidatorIndex();']")).click();
//		Thread.sleep(10000);
//		driver.findElement(By.xpath("//div[.='Price']")).click();
//		driver.findElement(By.xpath("//div[.='Time']")).click();
		driver.findElement(By.id("out2")).click();
		driver.findElement(By.id("in2")).click();
		
		
		
		Thread.sleep(3000);
		driver.close();
	}

}
