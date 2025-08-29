package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.Map;

public class IOSHelper {

    private final AppiumDriver driver;

    public IOSHelper(AppiumDriver driver) {
        this.driver = driver;
    }

    public void swipeUp() {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("direction", "up");
            params.put("velocity", 2500);

            ((JavascriptExecutor) driver).executeScript("mobile: swipe", params);
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
    }

    public void swipeDown() {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("direction", "down");
            params.put("velocity", 2500);

            ((JavascriptExecutor) driver).executeScript("mobile: swipe", params);
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
    }

    public void tap(int x, int y) {
        Map<String, Object> params = new HashMap<>();
        params.put("x", x);
        params.put("y", y);

        ((JavascriptExecutor) driver).executeScript("mobile: tap", params);
    }

    public void scroll(String direction) {
        ((JavascriptExecutor) driver).executeScript("mobile: scroll",
                ImmutableMap.of("direction", direction));
    }
}