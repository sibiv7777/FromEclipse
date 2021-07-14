package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AddContactDetailsPage extends BasePage {

	WebDriver drivers;

	public AddContactDetailsPage(WebDriver drivers) {
		drivers = this.drivers;
	}

	@FindBy(how = How.NAME, using = "account")
	WebElement ENTER_FULL_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//div/child::select[@id='cid']")
	WebElement SELECT_COMPANY_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//div/child::input[@id='email']")
	WebElement ENTER_EMAIL_ID_ELEMENT;
	@FindBy(how = How.XPATH, using = "//div/child::input[@name='phone']")
	WebElement ENTER_PHONE_NUMBER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//div/child::input[@name='address']")
	WebElement ENTER_STREET_ADDRESS_ELEMENT;
	@FindBy(how = How.XPATH, using = "//div/child::input[@name='city']")
	WebElement ENTER_CITY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//div/child::input[@name='state']")
	WebElement ENTER_STATE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//div/child::input[@name='zip']")
	WebElement ENTER_ZIP_ELEMENT;
	@FindBy(how = How.XPATH, using = "//div/child::select[@name='country']")
	WebElement SELECT_COUNTRY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//div/child::label[contains(text(),'No')]")
	WebElement SELECT_WELCOME_EMAIL_YES_OR_NO_ELEMENT;
	@FindBy(how = How.XPATH, using = "//div/child::button[@id='submit']")
	WebElement SAVE_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//th[contains(text(),'Accounting Summary')]")
	WebElement FOUND_ACCOUNT_SUMMARY_PAGE;
	@FindBy(how = How.XPATH, using = "//div/child::button[2][text()='OK']")
	WebElement CONFIRM_DELETION_BUTTON_ELEMENT;

	// @FindBy(how=How.ID_OR_NAME, using="Contact Deleted Successfully") WebElement
	// ASSERT_DELETION_BUTTON_ELEMENT;

	String fullname;

	public String enterFullName() throws InterruptedException {

		int num = randomData();
		fullname = getPropertiesData().getProperty("fullName");
		fullname = fullname + num;
		Thread.sleep(1000);
		ENTER_FULL_NAME_ELEMENT.sendKeys(fullname);
		return fullname;
	}

	public void selectCompanyName() {
		String companyName = getPropertiesData().getProperty("companyName");
		selectDropDownitem(SELECT_COMPANY_NAME_ELEMENT, companyName);
	}

	public void enterEmailId() {
		int num = randomData();
		String Email = getPropertiesData().getProperty("contactEmail");
		Email = num + Email;
		ENTER_EMAIL_ID_ELEMENT.sendKeys(Email);
	}

	public void enterPhoneNumber() {
		int num = randomData();

		String phoneNumber = getPropertiesData().getProperty("phoneNumber");
		phoneNumber = phoneNumber + num;
		ENTER_PHONE_NUMBER_ELEMENT.sendKeys(phoneNumber);
	}

	public void enterStreetAddress() {
		String streetAddress = getPropertiesData().getProperty("streetAddress");
		ENTER_STREET_ADDRESS_ELEMENT.sendKeys(streetAddress);

	}

	public void enterCity() {
		String city = getPropertiesData().getProperty("city");
		ENTER_CITY_ELEMENT.sendKeys(city);

	}

	public void enterState() {
		String state = getPropertiesData().getProperty("state");
		ENTER_STATE_ELEMENT.sendKeys(state);

	}

	public void enterZip() {
		String zip = getPropertiesData().getProperty("zip");
		ENTER_ZIP_ELEMENT.sendKeys(zip);

	}

	public void enterCountry() throws InterruptedException {
		String country = getPropertiesData().getProperty("country");
		selectDropDownitem(SELECT_COUNTRY_ELEMENT, country);

	}

	public void sendEmailOption() {
		SELECT_WELCOME_EMAIL_YES_OR_NO_ELEMENT.click();

	}

	public void save() throws InterruptedException {
		SAVE_BUTTON_ELEMENT.click();
		Thread.sleep(1000);
	}

	public void assertAccountSummary() throws InterruptedException {
		Thread.sleep(2000);
		assertPages(FOUND_ACCOUNT_SUMMARY_PAGE.getText(), "Accounting Summary", "Did not find Accounting Summary");
	}

//	public void checkIfContactAdded() throws InterruptedException {
//
//		String before = "//tr[";
//		String after = "]/td[3]";
//		// tr[1]/td[3]
//		
//		for (int j = 1; j <= 10; j = j + 1) {
//			WebElement together = drivers.findElement(By.xpath(before+ j + after));
//			String full=together.getText();
//			System.out.println(together);
//	//		Assert.assertEquals(together, full, "Matches");
//	if(full.equalsIgnoreCase(fullname)) {
//		System.out.println("name matches");
//	}
//		}
//		
//
//	}
}
