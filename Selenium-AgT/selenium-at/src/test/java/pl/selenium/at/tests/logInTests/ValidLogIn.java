package pl.selenium.at.tests.logInTests;

import static org.testng.Assert.assertTrue;
import base.BaseFile;
import io.qameta.allure.Description;
import pages.POM.logInPOM.ValidLogInPOM;
import utils.AllureScreenshotListener;
import utils.ConfigProperties;
import utils.ScreenshotHelper;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AllureScreenshotListener.class)
public class ValidLogIn extends BaseFile {

    @Test
    @Description("Valid Log In Test")
    public void testValidLogIn() {
        ValidLogInPOM loginPage = new ValidLogInPOM(driver);

        ScreenshotHelper.takeScreenshot(driver, "Log in page is displayed");

        loginPage.clickLogInLChButton();
        loginPage.enterEmail(ConfigProperties.getProperty("email"));
        loginPage.enterPassword(ConfigProperties.getProperty("password"));

        ScreenshotHelper.takeScreenshot(driver, "Log in form is filled");

        loginPage.clickLogInButton();
        assertTrue(loginPage.isHomePageDisplayed());

        ScreenshotHelper.takeScreenshot(driver, "Homepage is displayed");
    }
}