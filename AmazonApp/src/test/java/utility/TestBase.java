package utility;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBase {
	protected static String appPath;
	protected static AndroidDriver<AndroidElement> driver;
	protected static Properties prop;
	protected static Logger log = Logger.getLogger("nativeApplicationLogger");
	protected DataReader datafile = new DataReader();

	@BeforeSuite
	public static void ReadProperties() {
		try {
			File config = new File("../AmazonApp/resources/config.properties");
			FileInputStream inStream = new FileInputStream(config);
			prop = new Properties();
			prop.load(inStream);
			log.info("Properties loaded successfully.");
		}

		catch (IOException e) {
			log.error("Properties File Not Found");
			e.printStackTrace();
		}
	}

	@BeforeSuite
	public void setup() throws IOException {
		try {
			File config = new File("../AmazonApp/resources/config.properties");
			FileInputStream inStream = new FileInputStream(config);
			prop = new Properties();
			prop.load(inStream);
			log.info("Properties loaded successfully.");
		}

		catch (IOException e) {
			log.error("Properties File Not Found");
			e.printStackTrace();
		}
		/**
		 * Define all required capabilities
		 */

		File app = new File(prop.getProperty("app.appPath"));
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("app.deviceId"));
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.getProperty("app.platformVersion"));
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getProperty("app.platformName"));
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, prop.getProperty("app.appPackage"));
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, prop.getProperty("app.appActivity"));
		cap.setCapability(MobileCapabilityType.NO_RESET, false);

		try {
			log.info("Setting Capabilities : " + cap);
			driver = new AndroidDriver<AndroidElement>(
					new URL("http://" + prop.getProperty("app.appiumServerURI") + "/wd/hub"), cap);
			log.info("Driver instance created");
		} catch (Exception e) {
			log.error("Unable to create driver instance");
			e.printStackTrace();
		}

		// Define implicit wait
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("app.implicitWait")),
				TimeUnit.SECONDS);
		// Define Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(prop.getProperty("app.explicitWait")));

		log.info("Driver Initialized");
		Reporter.log("Driver Initialized.....");

	}

	/**
	 * This method checks for the visibility of the element
	 */
	public void waitForElement(AndroidDriver<AndroidElement> driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(prop.getProperty("app.explicitWait")));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	@AfterSuite
	public void TeardownTest() {
		driver.closeApp();
		log.info("App Closed...");
		driver.quit();
		log.info("Session Ended...");
	}
}
