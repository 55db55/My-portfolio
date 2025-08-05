package pl.selenium.at.tests.logInTests;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import base.BaseFile;
import io.qameta.allure.Description;
import pages.POM.logInPOM.InvalidLogInPOM;
import utils.AllureScreenshotListener;
import utils.ScreenshotHelper;

@Listeners(AllureScreenshotListener.class)
public class InvalidLogIn extends BaseFile {

    @Test
    @Description("Invalid Log In Test")
    public void testInvalidLogIn() {
        InvalidLogInPOM loginPageErrors = new InvalidLogInPOM(driver);

        ScreenshotHelper.takeScreenshot(driver, "Log in page is displayed");

        loginPageErrors.clickLogInLChButton();
        loginPageErrors.logInBtn();
        assertTrue(loginPageErrors.isErrorMessageDisplayed());

        ScreenshotHelper.takeScreenshot(driver, "Error messages are displayed");
    }
}