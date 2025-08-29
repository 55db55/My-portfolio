package utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.ByteArrayInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotHelper {

    public static byte[] takeScreenshot(WebDriver driver, String screenshotName) {
        Log.info("Taking screenshot: " + screenshotName);
        byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        attachPng(bytes, screenshotName);
        return bytes;
    }

    public static byte[] takeScreenshot(WebDriver driver) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        String name = "Screenshot_" + timestamp;
        byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        attachPng(bytes, name);
        return bytes;
    }

    public static byte[] takeElementScreenshot(WebElement element, String elementName) {
        Log.info("Taking element screenshot: " + elementName);
        byte[] bytes = element.getScreenshotAs(OutputType.BYTES);
        attachPng(bytes, "Element: " + elementName);
        return bytes;
    }

    public static byte[] takeFailureScreenshot(WebDriver driver, String testName) {
        Log.error("Test failed - taking screenshot: " + testName);
        byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        attachPng(bytes, "❌ FAILED: " + testName);
        return bytes;
    }

    public static byte[] takeSuccessScreenshot(WebDriver driver, String testName) {
        Log.info("Test passed - taking screenshot: " + testName);
        byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        attachPng(bytes, "✅ SUCCESS: " + testName);
        return bytes;
    }

    private static void attachPng(byte[] bytes, String name) {
        try {
            Allure.addAttachment(name, "image/png", new ByteArrayInputStream(bytes), ".png");
        } catch (Throwable t) {
            Log.warn("Failed to attach screenshot to Allure: " + t.getMessage());
        }
    }
}