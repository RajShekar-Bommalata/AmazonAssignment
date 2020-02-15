package utility;

import java.io.File;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import com.google.common.io.Files;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class TestUtil extends TestBase {

	public static void scrollDown() {
		Dimension dimensions = driver.manage().window().getSize();
		Double screenHeightStart = dimensions.getHeight() * 0.5;
		int scrollStart = screenHeightStart.intValue();
		Double screenHeightEnd = dimensions.getHeight() * 0.2;
		int scrollEnd = screenHeightEnd.intValue();

		new TouchAction((PerformsTouchActions) driver).press(PointOption.point(0, scrollStart))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(0, scrollEnd))
				.release().perform();
	}

	// This method only logs message in report and custom logs
	public static void logMessage(String msg) {
		Reporter.log(msg);
		log.info(msg);
	}

	// This method only logs message in report and custom logs. Also captures
	// screenshots
	public static void logMessageWithScreenShot(String msg, String SSname) {
		Reporter.log(msg);
		log.info(msg);
		takeScreenshot(SSname);
	}

	public static void takeScreenshot(String filename) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(src, new File("screenshots/" + filename + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Reporter.log("Captured snapshot of " + filename);
		log.info("Captured snapshot of " + filename);
	}

}
