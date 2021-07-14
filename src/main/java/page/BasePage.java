package page;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {

	public static Properties getPropertiesData() {

		Properties prop = new Properties();
		try {
			InputStream input = new FileInputStream("./src/main/java/ExternalData/config.properties");
			prop.load(input);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return prop;

	}

	public void assertPages(String actual, String expected, String message) {
		Assert.assertEquals(actual, expected, message);
	}

	public void explicitWait(WebDriver drivers, int time, WebElement Element) {
		WebDriverWait wait = new WebDriverWait(drivers, time);
		wait.until(ExpectedConditions.visibilityOf(Element));
	}

	public int randomData() {

		Random rand = new Random();
		int num = rand.nextInt(9999);
		return num;
	}

	public void selectDropDownitem(WebElement Element, String Name) {

		Select sel = new Select(Element);
		sel.selectByVisibleText(Name);

	}

}
