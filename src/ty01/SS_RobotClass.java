package ty01;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SS_RobotClass {
	static {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	}
	@Test
	public void test1() throws Exception {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.seleniumhq.org/");
		Robot r=new Robot();
		Rectangle scrSize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage tmpIMG = r.createScreenCapture(scrSize);
		ImageIO.write(tmpIMG, "png",new File("./photo/"+driver.getTitle()+".png"));
		Thread.sleep(1500);
		driver.close();
	}

}
