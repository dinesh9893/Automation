package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(id="logoutLink")
	private WebElement logout;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickLogout() {
		logout.click();;
	}

}
