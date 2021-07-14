package test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddContactDetailsPage;
import page.LoginInToWebsitePage;
import page.SideNavigationPage;
import util.BrowserFactory;

public class AddContactDetailsTest {

	WebDriver drivers;

	@Test
	public void addContact() throws InterruptedException {

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
		AddContactDetailsPage contacts = PageFactory.initElements(drivers, AddContactDetailsPage.class);
		contacts.enterFullName();
		contacts.selectCompanyName();
		contacts.enterEmailId();
		contacts.enterPhoneNumber();
		contacts.enterStreetAddress();
		contacts.enterCity();
		contacts.enterState();
		contacts.enterZip();
		contacts.enterCountry();
		contacts.sendEmailOption();
		contacts.save();
		contacts.assertAccountSummary();
		System.out.println("Landed on Accounting Summary");
		sideNavi.listCustomerPage();
		//contacts.checkIfContactAdded();
	}

}
