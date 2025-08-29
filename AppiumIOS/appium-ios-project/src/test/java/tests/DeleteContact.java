package tests;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pages.POM.DeleteContactPOM;
import utils.ConfigProperties;
import utils.ScreenshotHelper;

public class DeleteContact extends BaseTest {

    @Test
    public void testDeleteContact() {
        DeleteContactPOM deleteContact = new DeleteContactPOM(driver);

        String firstName = ConfigProperties.getProperty("newFirstName");
        String lastName = ConfigProperties.getProperty("newLastName");
        deleteContact.setContactDetails(firstName, lastName);

        deleteContact.longPressContact();

        deleteContact.clickDeleteContact();
        assertTrue(deleteContact.isConfirmationModalDisplayed());

        ScreenshotHelper.takeScreenshot(driver, "Confirmation modal to dete displayed");

        deleteContact.clickDeleteContactButton();
        assertTrue(deleteContact.isContactDeleted());
    }
}