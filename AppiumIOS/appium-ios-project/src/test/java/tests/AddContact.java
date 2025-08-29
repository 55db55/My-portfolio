package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.POM.AddContactPOM;
import utils.ConfigProperties;
import utils.ScreenshotHelper;

@Listeners(AllureScreenshotListener.class)
public class AddContact extends BaseTest {

    @Test
    public void addContact() {

        AddContactPOM addContact = new AddContactPOM(driver);

        addContact.clickAddButton();

        String firstName = ConfigProperties.getProperty("firstName");
        addContact.enterFirstName(firstName);

        String lastName = ConfigProperties.getProperty("lastName");
        addContact.enterLastName(lastName);

        String company = ConfigProperties.getProperty("company");
        addContact.enterCompany(company);

        addContact.clickAddPhoneButton();

        String phone = ConfigProperties.getProperty("phone");
        addContact.enterPhone(phone);

        addContact.clickAddEmailButton();

        String email = ConfigProperties.getProperty("email");
        addContact.enterEmail(email);

        addContact.clickAddAdress();
        addContact.clickRingtone();
        addContact.chooseValley();
        addContact.clickRingtoneOk();

        String street = ConfigProperties.getProperty("street");
        addContact.enterStreet(street);

        String zipCode = ConfigProperties.getProperty("zipCode");
        addContact.enterZipCode(zipCode);

        String city = ConfigProperties.getProperty("city");
        addContact.enterCity(city);

        addContact.clickAddBirthDay();
        addContact.enterBirthday("1", "Lutego", "2000");

        String note = ConfigProperties.getProperty("note");
        addContact.enterNotes(note);

        addContact.clickOkButton();
        assertTrue(addContact.isContactAdded());

        ScreenshotHelper.takeScreenshot(driver, "Contact added");
    }
}