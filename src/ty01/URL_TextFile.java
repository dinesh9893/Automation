package ty01;

import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class URL_TextFile {
	public static void main(String[] args) throws Exception{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://in.yahoo.com/");
		PrintWriter writer = new PrintWriter("AllLinks.txt", "UTF-8");
		List<WebElement> alllinks = driver.findElements(By.tagName("a"));
		for(WebElement e:alllinks) {
			String url=e.getAttribute("href");
			if(!(url==null)||!url.isEmpty())
			writer.write(url+"\n");
			}
		writer.close();
		Thread.sleep(1000);
		driver.close();
	}

}
