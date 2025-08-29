package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected AppiumDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability("platformVersion", "18.6");
        capabilities.setCapability("deviceName", "iPhone 16 Pro");
        capabilities.setCapability("bundleId", "com.apple.MobileAddressBook");
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("newCommandTimeout", 300);
        capabilities.setCapability("showXcodeLog", true);
        capabilities.setCapability("language", "pl");
        capabilities.setCapability("locale", "pl_PL");

        driver = new AppiumDriver<>(new URL("http://localhost:4723"), capabilities);
    }

    public WebDriver getDriver() {
        return driver;
    }
}