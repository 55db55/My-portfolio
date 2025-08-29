package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import pages.POM.EditContactPOM;
import utils.ConfigProperties;
import utils.ScreenshotHelper;

public class EditContact extends BaseTest {

    @Test
    public void editContact() {

        EditContactPOM editContact = new EditContactPOM(driver);

        String firstName = ConfigProperties.getProperty("firstName");
        String lastName = ConfigProperties.getProperty("lastName");
        editContact.setContactDetails(firstName, lastName);

        editContact.clickContactDetails();
        editContact.clickEditButton();

        String newFirstName = ConfigProperties.getProperty("newFirstName");
        editContact.editFirstName(newFirstName);
        assertTrue(editContact.isFirstNameUpdated(newFirstName));

        String newLastName = ConfigProperties.getProperty("newLastName");
        editContact.editLastName(newLastName);
        assertTrue(editContact.isLastNameUpdated(newLastName));

        ScreenshotHelper.takeScreenshot(driver, "Name edited");

        String newCompany = ConfigProperties.getProperty("newCompany");
        editContact.editCompany(newCompany);
        assertTrue(editContact.isCompanyUpdated(newCompany));

        ScreenshotHelper.takeScreenshot(driver, "Company edited");

        String newPhone = ConfigProperties.getProperty("newPhone");
        editContact.editPhone(newPhone);
        assertTrue(editContact.isPhoneUpdated(newPhone));

        ScreenshotHelper.takeScreenshot(driver, "Phone edited");

        String newEmail = ConfigProperties.getProperty("newEmail");
        editContact.editEmail(newEmail);
        assertTrue(editContact.isEmailUpdated(newEmail));

        ScreenshotHelper.takeScreenshot(driver, "Email edited");

        String newStreet = ConfigProperties.getProperty("newStreet");
        editContact.editStreet(newStreet);
        assertTrue(editContact.isStreetUpdated(newStreet));

        String newZipCode = ConfigProperties.getProperty("newZipCode");
        editContact.editZipCode(newZipCode);
        assertTrue(editContact.isZipCodeUpdated(newZipCode));

        String newCity = ConfigProperties.getProperty("newCity");
        editContact.editCity(newCity);
        assertTrue(editContact.isCityUpdated(newCity));

        ScreenshotHelper.takeScreenshot(driver, "Adress edited");

        String newNote = ConfigProperties.getProperty("newNote");
        editContact.editNotes(newNote);
        assertTrue(editContact.isNotesUpdated(newNote));

        ScreenshotHelper.takeScreenshot(driver, "Note edited");

        editContact.clickOkButton();
        assertTrue(editContact.isContactEdited());

        ScreenshotHelper.takeScreenshot(driver, "Contact edited");
    }
}