package util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	static WebDriver drivers;
	static String browser;
	static String browser1;
	static Properties prop;
	static String url;

	public static void init() {

		Properties prop = new Properties();
		try {
		//	InputStream reader = new FileInputStream("./src/main/java/ExternalData/config.properties");
		FileReader reader=new FileReader("./src/main/java/ExternalData/config.properties");
	
		prop.load(reader);
			browser = prop.getProperty("browser");
			browser1 = prop.getProperty("browser1");
			url = prop.getProperty("url");

		} catch (Exception e) {
			e.printStackTrace();
		}
		// return init();
	}

	static String choose;

	public static WebDriver selectBrowserAndLaunch() {
         init();
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("Which browser will you like to use. chrome or edge?");
			choose = scan.nextLine();

			if (choose.equalsIgnoreCase(browser)) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				drivers = new ChromeDriver();
				drivers.get(url);
				drivers.manage().window().maximize();
				drivers.manage().deleteAllCookies();
			}

			else if (choose.equalsIgnoreCase(browser1)) {
				// System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				WebDriverManager.edgedriver().setup();
				drivers = new EdgeDriver();
				drivers.get(url);
				drivers.manage().window().maximize();
				drivers.manage().deleteAllCookies();

			}
		} while (!choose.equalsIgnoreCase("chrome") && !choose.equalsIgnoreCase("edge"));

		return drivers;

	}
}