package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.LoginInToWebsitePage;
import page.SideNavigationPage;
import util.BrowserFactory;

public class SideNavigationTest {

	WebDriver drivers;

	@Test
	public void sidenavigationTest() throws InterruptedException {

		drivers = BrowserFactory.selectBrowserAndLaunch();
		LoginInToWebsitePage login = PageFactory.initElements(drivers, LoginInToWebsitePage.class);
		login.enterEmailId();
		login.enterPassword();
		login.clickToLogin();
		SideNavigationPage sideNavi = PageFactory.initElements(drivers, SideNavigationPage.class);
		sideNavi.dashBoardPageAssertion();
		System.out.println("Landed on DashBoard Page");
		sideNavi.customerPage();
		sideNavi.addCustomer();
		sideNavi.contactPageAssertion();
		System.out.println("Landed on Contacts Page ");
	}

}
