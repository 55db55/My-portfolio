package tests;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pages.POM.SearchContactPOM;
import utils.ConfigProperties;
import utils.ScreenshotHelper;

public class SearchContact extends BaseTest {

    @Test
    public void searchContact() {

        SearchContactPOM searchContact = new SearchContactPOM(driver);

        searchContact.clickSearchField();
        searchContact.enterSearchText(ConfigProperties.getProperty("firstName"));

        String firstName = ConfigProperties.getProperty("firstName");
        String lastName = ConfigProperties.getProperty("lastName");
        String email = ConfigProperties.getProperty("email");
        assertTrue(searchContact.isContactVisible(firstName, lastName, email));

        ScreenshotHelper.takeScreenshot(driver, "Contact searched");
    }
}