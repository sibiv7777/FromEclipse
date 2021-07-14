package test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.LoginInToWebsitePage;
import util.BrowserFactory;

public class LoginInToWebsiteTest {

	WebDriver drivers;
	
	@Test
	public void loginIntoWebsite() {
		
		drivers = BrowserFactory.selectBrowserAndLaunch();
		LoginInToWebsitePage login=	PageFactory.initElements(drivers, LoginInToWebsitePage.class );
	   	login.enterEmailId(); 
	   	login.enterPassword();
	   	login.clickToLogin();
	
	}
}
