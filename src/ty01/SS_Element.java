package ty01;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SS_Element {
	static {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	}
	@Test
	public void test1() throws Exception {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.seleniumhq.org/");
		WebElement elm = driver.findElement(By.xpath("//div[@id='sidebar']/img[@alt='Selenium Logo']"));
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		BufferedImage  fullImg = ImageIO.read(screenshot);
		Point point = elm.getLocation();
		int eleWidth = elm.getSize().getWidth();
		int eleHeight = elm.getSize().getHeight();
		BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
		ImageIO.write(eleScreenshot, "png", screenshot);
		File screenshotLocation = new File("./photo/"+elm.getAttribute("alt")+".png");
		FileUtils.copyFile(screenshot, screenshotLocation);
		Thread.sleep(1500);
		driver.close();
	}

}
