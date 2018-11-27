package ty01;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Puma {
	static {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	}
	
	@Test
	public void test1() throws Exception {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://in.puma.com/");
		//List<WebElement> menus = driver.findElements(By.xpath("//ul[contains(@class,'digimeg-group')]/li"));
		List<WebElement> menus = driver.findElements(By.xpath("//div[contains(@class,'digimeg-nav-item')]/div/div/ul/li"));
		
		for(WebElement e:menus) {
			String alltext=e.getText();
			System.out.println(alltext);
			Reporter.log(alltext,true);
		}
		Thread.sleep(2000);
		driver.close();
	}

}
