package ty01;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UL_New {
	static {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	}
	@Test
	public void test1() throws Exception {
		WebDriver driver=new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver, 15);
		Actions ac=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.urbanladder.com/");
		driver.findElement(By.xpath("//a[contains(@class,'hide-mobile')]")).click();
		Assert.assertTrue(driver.getTitle().contains("Furniture Online"));
		Thread.sleep(500);
		ac.moveToElement(driver.findElement(By.xpath("//span[@class='topnav_itemname' and contains(.,'Living')]"))).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[.='Lounge Chairs']")).click();
		wait.until(ExpectedConditions.titleContains("Lounge Chairs"));
		driver.findElement(By.xpath("//div[@data-taxon='lounge_chairs']//li[3]//a[@class='product-title-block']")).click();
		wait.until(ExpectedConditions.titleContains("Genoa Wing Chair"));
		String UniCode_price = driver.findElement(By.xpath("//div[@class='buy_details clearfix  current']//div[@class='price discounted-price']")).getText();
		int price=Integer.parseInt(UniCode_price.substring(1, UniCode_price.length()).replaceAll(",", ""));
		int range=20000;
		if(price>=range) {
			System.out.println(price+" is the Product Price and it's Rs.20,000 or Higher");
		}
		else{
			System.out.println(price+" is the Product Price and it's lower than Rs.20,000");
		}
		driver.findElement(By.xpath("//div[@class='buy_details clearfix  current']//button[contains(.,'Add to Cart')]")).click();
		wait.until(ExpectedConditions.titleContains("Shopping Cart"));
		System.out.println("Product is Added to Cart succesfully.");
		Thread.sleep(1500);
		driver.close();
	}

}
