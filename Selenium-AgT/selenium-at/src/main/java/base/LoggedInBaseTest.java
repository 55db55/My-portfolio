package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.assertTrue;
import pages.POM.logInPOM.ValidLogInPOM;
import utils.ConfigProperties;

public class LoggedInBaseTest extends BaseFile {

    @BeforeMethod
    public void loginBeforeTest() {
        ValidLogInPOM loginPage = new ValidLogInPOM(driver);
        loginPage.clickLogInLChButton();
        loginPage.enterEmail(ConfigProperties.getProperty("email"));
        loginPage.enterPassword(ConfigProperties.getProperty("password"));
        loginPage.clickLogInButton();
        assertTrue(loginPage.isHomePageDisplayed());
    }

    @AfterMethod
    public void tearDownTest() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
        }
    }
}