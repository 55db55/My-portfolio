package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.Log;

public class BaseFile {

    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        Log.info("Setting up WebDriver");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        Log.info("Navigating to the login page");
        driver.get("https://example.com/login"); 
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}