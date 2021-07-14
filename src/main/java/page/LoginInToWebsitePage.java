package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginInToWebsitePage extends BasePage {

	WebDriver drivers;

	public LoginInToWebsitePage(WebDriver drivers) {
		drivers = this.drivers;
	}

	@FindBy(how = How.XPATH, using = "//div/input[@name='username']")
	WebElement ENTER_EMAILID_TO_LOGIN_ELEMENT;
    @FindBy(how=How.XPATH, using ="//div/input[@name='password']")WebElement ENTER_PASSWORD_TO_LOGIN_ELEMENT;
	@FindBy(how=How.XPATH, using="//div/button[@name='login']")WebElement CLICK_TO_LOGIN_ELEMENT;
	
	
	public void enterEmailId() {
		String email = getPropertiesData().getProperty("email");
		ENTER_EMAILID_TO_LOGIN_ELEMENT.sendKeys(email);

	}
	
	public void enterPassword() {
		String password=getPropertiesData().getProperty("password");
		ENTER_PASSWORD_TO_LOGIN_ELEMENT.sendKeys(password);
	}

	public void clickToLogin() {
		CLICK_TO_LOGIN_ELEMENT.click();
	}
}
