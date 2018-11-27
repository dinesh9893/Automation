package ty01;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Craftsvilla_Login {
	static {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	}

	@Test
	public void test2() throws Exception {
		WebDriver driver=new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver, 15);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Properties p = new Properties();
		p.load(new FileInputStream("Craftvilla.properties"));
		driver.get("https://www.craftsvilla.com/");
		wait.until(ExpectedConditions.titleContains("Craftsvilla"));
		Thread.sleep(1500);
		driver.findElement(By.xpath("//span[.='Sign In']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emailId"))).sendKeys(p.getProperty("Inval_Login"));
		driver.findElement(By.id("continueBtn")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='error-msg']")));
		String exp_error = driver.findElement(By.xpath("//div[@class='error-msg']")).getText();
		Assert.assertEquals(p.getProperty("error_actual1"), exp_error);
		driver.navigate().refresh();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//span[.='Sign In']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emailId"))).sendKeys("");
		driver.findElement(By.id("continueBtn")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='error-msg']")));
		String exp_error2 = driver.findElement(By.xpath("//div[@class='error-msg']")).getText();
		Assert.assertEquals(p.getProperty("error_actual2"), exp_error2);
		Thread.sleep(2000);
		driver.close();
		Thread.sleep(1000);
		Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
	}
}
