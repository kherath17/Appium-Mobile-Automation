package tests;


import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {

	static AppiumDriver<MobileElement> driver;

	@BeforeTest
	public void setUp() {
		try {

			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "MYA-L22");
			//cap.setCapability(MobileCapabilityType.UDID, "R9KBB18109219830");
			cap.setCapability(MobileCapabilityType.UDID,"192.168.8.104:5555");
			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
			cap.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");

			URL url = new URL("http://0.0.0.0:4723/wd/hub");
			driver = new AppiumDriver<MobileElement>(url, cap);

		} catch (Exception exp) {
			System.out.println("Cause is " + exp.getCause());
			System.out.println("Message is " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	@Test
	public void sampleTest() {
		System.out.println("Inside the tests");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
