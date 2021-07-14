package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SideNavigationPage extends BasePage {

	WebDriver drivers;

	public SideNavigationPage(WebDriver drivers) {
		drivers = this.drivers;
	}

	@FindBy(how = How.XPATH, using = "//div/h2[contains(text(),' Dashboard ')]")
	WebElement DASHBOARD_PAGE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//li[3]/a/i[@class='icon-users']/following-sibling::span[1]")
	WebElement CUSTOMER_PAGE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//li/child::a[contains(text(),'Add Customer')]")
	WebElement ADD_CUSTOMER_LINK;
	@FindBy(how = How.XPATH, using = "//div/h2[text()=' Contacts ']")
	WebElement CONTACT_PAGE_VALIDATION_ELEMENT;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using="List Customers")
	WebElement LIST_CUSTOMER_PAGE_CLICK_ELEMENT;

	public void dashBoardPageAssertion() {
		assertPages(DASHBOARD_PAGE_ELEMENT.getText(), "Dashboard", "DashBoard Page not Found");
	}

	public void customerPage() throws InterruptedException {
		Thread.sleep(1000);
		CUSTOMER_PAGE_ELEMENT.click();

	}

	public void addCustomer() throws InterruptedException {
		 Thread.sleep(1000);
		ADD_CUSTOMER_LINK.click();
	}

	public void contactPageAssertion() {
		assertPages(CONTACT_PAGE_VALIDATION_ELEMENT.getText(), "Contacts", "Contact Page not Found");
	}
	public void listCustomerPage() {
		LIST_CUSTOMER_PAGE_CLICK_ELEMENT.click();
	}
}
