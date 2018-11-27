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


public class PumaNew2 {
	static {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	}
	
	public static boolean isClickable(WebElement el, WebDriver driver) 
    {
        try{
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.elementToBeClickable(el));
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
		driver.get("https://in.puma.com/catalog/product/view/id/90001/s/hybrid_runner_unrest-191507/category/59/?oid=858&csku=19150702");
		WebElement el = driver.findElement(By.xpath("//button[@title='Add to Cart']"));
		System.out.println(el.getAttribute("class"));
		//el.click();
		Assert.assertTrue(isClickable(el, driver));
		System.out.println("hello");
		
				
		
		
		
		Thread.sleep(3000);
		//driver.quit();
		
	}

}
