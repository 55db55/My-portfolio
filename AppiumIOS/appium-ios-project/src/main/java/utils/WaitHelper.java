package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;
import org.openqa.selenium.NoSuchElementException;

public class WaitHelper {
    private static final Duration TIMEOUT = Duration.ofSeconds(10);
    private static final Duration POLLING = Duration.ofMillis(500);

    public static WebElement waitForElement(WebDriver driver, By locator) {
        return waitForElementWithTimeout(driver, locator, TIMEOUT);
    }

    public static WebElement waitForElementWithTimeout(WebDriver driver, By locator, Duration timeout) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(timeout)
                .pollingEvery(POLLING)
                .ignoring(NoSuchElementException.class);

        return wait.until(d -> {
            WebElement element = d.findElement(locator);
            if (element.isDisplayed()) {
                return element;
            }
            return null;
        });
    }
}