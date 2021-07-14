package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import util.BrowserFactory;

public class LaunchBrowserTest {

	WebDriver drivers;

	@Test
	public void launchBrowser() {
	//	BrowserFactory.init();
		drivers = BrowserFactory.selectBrowserAndLaunch();
	}

}
