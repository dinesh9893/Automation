package script;


import org.testng.annotations.Test;

import genric.BaseTest;
import genric.Utility;
import page.HomePage;
import page.LoginPage;

public class TestLoginLogout extends BaseTest {
	
	@Test(priority=1, groups= {"login","smoke"})
	public void testLoginLogout() {
		String sheet="TestLoginLogout";
		String un=Utility.getXLData(INPUT_PATH, sheet, 1, 0);
		String pw=Utility.getXLData(INPUT_PATH, sheet, 1, 1);
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(un);
		lp.setPassWord(pw);
		lp.clickLogin();
		
		HomePage h=new HomePage(driver);
		h.clickLogout();
	}

}
