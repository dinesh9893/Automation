package script;


import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genric.BaseTest;
import genric.Result;
import genric.Utility;
@Listeners(Result.class)
public class TestDemo extends BaseTest   {
	@Test
	public void testA() throws Exception {
		String data=Utility.getXLData(INPUT_PATH, "sheet1", 0, 0);
		Reporter.log("Data:"+data,true);
		
		int r=Utility.getXLRowCount(INPUT_PATH, "sheet1");
		Reporter.log("Row:"+r,true);
		
		String p=Utility.getPhoto(driver, PHOTO_PATH);
		Reporter.log("Photo"+p,true);
		
	}
	

}
