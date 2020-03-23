package qa.cimb;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import qa.cimb.utility.PropertyReader;

public class CimbBase {

	public static WebDriver driver;
	public static Properties propertiesFile;
	

	/*
	 * Constructor for load from Initialization of base class
	 */
	public CimbBase() {

		PropertyReader pro = new PropertyReader();
		propertiesFile = pro.PropertyReaderfile();

	}

	public void launchBrowser(String url) throws InterruptedException {

		
		// Read File for Operating System
		String os = propertiesFile.getProperty("OS");
		
		// Read Property For Browser Selection
		String browserName = propertiesFile.getProperty("browserName");


		// Condition for Select Operating System
		if (os.equalsIgnoreCase("window")) {

			// condition for launch chrome browser
			if (browserName.equalsIgnoreCase("chrome")) {

				System.setProperty("webdriver.chrome.driver", "./driver/chromedriver79.exe");
				driver = new ChromeDriver();
				driver.manage().deleteAllCookies();

			} else {

				System.out.println("unable to find chrome browser");

			}
		}

		// Maximize the window
		driver.manage().window().maximize();
		// Enter url of the website
		driver.navigate().to(url);
		

	}

}