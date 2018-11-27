package ty01;

import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Craftsvilla_Sarees {
	static {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	}

	@Test
	public void test2() throws Exception {
		WebDriver driver=new ChromeDriver();
		Actions ac=new Actions(driver);
		WebDriverWait wait=new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.craftsvilla.com/");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("SAREES")));
		ac.moveToElement(driver.findElement(By.linkText("SAREES"))).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Embroidered Sarees']")));
		driver.findElement(By.xpath("//a[.='Embroidered Sarees']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h1[@class='product-name']")).getText().contains("Emroidered Sarees"));
		List<WebElement> priceAll = driver.findElements(By.xpath("//div[@class='product-row']//p/span[1]"));
		TreeSet<Integer> ts=new TreeSet<>();
		for(WebElement e:priceAll) {
			int price = Integer.parseInt(e.getText().substring(2,6));
			ts.add(price);
		}
		driver.findElement(By.xpath("//span[contains(.,'"+ts.last()+"')]/../../a")).click();
		Thread.sleep(3000);
		driver.close();
		Thread.sleep(1000);
		Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
	}
}
