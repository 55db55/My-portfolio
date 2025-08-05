package utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotHelper {

    @Attachment(value = "{screenshotName}", type = "image/png")
    public static byte[] takeScreenshot(WebDriver driver, String screenshotName) {
        Log.info("Taking screenshot: " + screenshotName);
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] takeScreenshot(WebDriver driver) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        return takeScreenshot(driver, "Screenshot_" + timestamp);
    }

    @Attachment(value = "Element: {elementName}", type = "image/png")
    public static byte[] takeElementScreenshot(WebElement element, String elementName) {
        Log.info("Taking element screenshot: " + elementName);
        return element.getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "❌ FAILED: {testName}", type = "image/png")
    public static byte[] takeFailureScreenshot(WebDriver driver, String testName) {
        Log.error("Test failed - taking screenshot: " + testName);
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "✅ SUCCESS: {testName}", type = "image/png")
    public static byte[] takeSuccessScreenshot(WebDriver driver, String testName) {
        Log.info("Test passed - taking screenshot: " + testName);
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}