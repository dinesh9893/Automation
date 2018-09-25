package qsp;

import java.io.File;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class A {
//	@Test
//	public void test() {
//		Reporter.log("hello",true);
//	}


//	static {
//		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
//		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
//	}
//
//		public static void main(String[] args) throws Exception  {
//			WebDriver driver=new ChromeDriver();
//			driver.get("http://google.com");
//			}
			
	
	
	
	public static void main(String[] args) throws Exception {
		Workbook w = WorkbookFactory.create(new File("./data/Book2.xlsx"));
		String sh = w.getSheet("sheet1").getRow(0).getCell(0).toString();
		System.out.println(sh);
		
	}
		}

