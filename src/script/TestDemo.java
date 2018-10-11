package script;

import org.testng.annotations.Test;

import genric.BaseTest;
import page.LoginPage;

public class TestDemo extends BaseTest {
	@Test
	public void testA() {
		LoginPage lp=new LoginPage(driver);
		lp.setUserName("admin");
		lp.setPassWord("admin123");
		lp.clickLogin();
	}

}
