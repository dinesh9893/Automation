package ty01;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumHQ_BrokenLinks {
	static {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	}
	@Test
	public void test1() throws Exception {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.seleniumhq.org/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		String url="";
		for(WebElement e:links) {
			url = e.getAttribute("href");
			if(url == null || url.isEmpty()) {
				System.out.println(": URL is empty or broken : ");
				continue;
				}
			 if(!url.startsWith(driver.getCurrentUrl())){
	                System.out.println("URL belongs to another domain, skipping it.");
	                continue;
	            }
			 try {
				 HttpURLConnection uc = (HttpURLConnection)(new URL(url).openConnection());
	                uc.setRequestMethod("HEAD");
	                uc.connect();
	                int respCode = uc.getResponseCode();
	                if(respCode >= 400){
	                    System.out.println(url+" is a broken link");
	                }
	                else{
//	                    System.out.println(url+" is a valid link");
	                }
	                    
	            } catch (Exception ex) {
	                ex.printStackTrace();
	            } 
		}
		Thread.sleep(2500);
		driver.close();
	}
}
