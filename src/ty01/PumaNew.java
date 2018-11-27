package ty01;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PumaNew {
	static {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	}
	
	public static boolean isClickable(WebElement elment, WebDriver driver) 
    {
        try{
            WebDriverWait wait = new WebDriverWait(driver, 6);
            wait.until(ExpectedConditions.elementToBeClickable(elment));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
	
	@Test
	public void test1() throws Exception {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://in.puma.com/");
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		Actions ac=new Actions(driver);
		
		//Validating Title
		Assert.assertTrue(driver.getTitle().contains("PUMA.COM"));
//		Assert.assertEquals("PUMA.COM | Forever Faster", driver.getTitle());  //other way to validate
		
		//Moving to Women Menu and click Running shoes
		ac.moveToElement(driver.findElement(By.xpath("//a[.=' WOMEN ']"))).perform();
		WebElement running = driver.findElement(By.xpath("//div[@class='digimeg-nav-chunk']//a[contains(@href,'/women/shoes/running')]"));
		Assert.assertTrue(isClickable(running, driver));
		running.click();
		
		//Validating Running Page
		Assert.assertTrue(driver.getTitle().contains("Running Shoes"));
		String PNameThisPage = driver.findElement(By.xpath("//ul[contains(@class,'col first last odd')]/li[3]//h2/a")).getText();
		String PPriceThisPage = driver.findElement(By.xpath("//ul[contains(@class,'col first last odd')]/li[3]//span[@class='price']")).getText();
		
		//Setting the product attribute value so it open in same tab not in new tab 
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("document.getElementsByClassName('product-image promainimg').setAttribute('target', 'self');");
		
		
		//Selecting 3rd Product
		driver.findElement(By.xpath("//ul[contains(@class,'col first last odd')]/li[3]/a")).click();
		//driver.findElement(By.xpath("//a[@proid='90854']")).click();//Alternate 3rd product path
		
		WebElement PNCP = driver.findElement(By.xpath("//h1[contains(.,'Hybrid Runner Unrest')]"));
		wait1.until(ExpectedConditions.visibilityOf(PNCP));
		String PNameCurrentPAge = PNCP.getText();
		
		WebElement PPCP = driver.findElement(By.xpath("//span[@id='product-price-90001']/span"));
		wait1.until(ExpectedConditions.visibilityOf(PPCP));
		String PPriceCurrentPage = PPCP.getText();

		//Validating the page with product details
		Assert.assertEquals(PNameThisPage, PNameCurrentPAge);
		Assert.assertEquals(PPriceThisPage, PPriceCurrentPage);
		
		Assert.assertTrue(driver.findElement(By.xpath("//button[@title='Add to Cart']")).getAttribute("class").contains("disable"));
		Assert.assertTrue(isClickable(driver.findElement(By.xpath("//button[@title='Add to Cart']")), driver));
		driver.findElement(By.xpath("//div[@class='product-size-click-btn']")).click();
		driver.findElement(By.xpath("//span[@id='180~73']")).click();
		
		WebElement AddToCart = driver.findElement(By.xpath("//button[@title='Add to Cart']"));
		wait1.until(ExpectedConditions.elementToBeClickable(AddToCart));
		AddToCart.click();
		
		
		Thread.sleep(2000);
		driver.quit();
		
	}

}
