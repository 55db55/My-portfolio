package pages.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.appium.java_client.MobileBy;
import utils.WaitHelper;

public class EditContactPOM {

    private WebDriver driver;

    private String firstName;
    private String lastName;

    private By editButton = By.name("Edycja");
    private By firstNameField = By.name("Imię");
    private By lastNameField = By.name("Nazwisko");
    private By companyName = By.name("Firma");
    private By phoneField = MobileBy
            .iOSNsPredicateString("type == 'XCUIElementTypeTextField' AND placeholderValue == 'Telefon'");
    private By emailField = MobileBy
            .iOSNsPredicateString("type == 'XCUIElementTypeTextField' AND placeholderValue == 'Email'");
    private By streetName = By.name("Ulica");
    private By zipCode = By.name("Kod");
    private By cityName = By.name("Miasto");
    private By notes = By.name("Notatki");
    private By okButton = By.name("OK");

    public EditContactPOM(WebDriver driver) {
        this.driver = driver;
    }

    public void setContactDetails(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void clickContactDetails() {
        By contactLocator = By.xpath(String.format(
                "//XCUIElementTypeCell[contains(@name,'%s %s')]",
                firstName,
                lastName));
        driver.findElement(contactLocator).click();
    }

    public void clickEditButton() {
        driver.findElement(editButton).click();
    }

    public void editFirstName(String newFirstName) {
        driver.findElement(firstNameField).clear();
        driver.findElement(firstNameField).sendKeys(newFirstName);
        this.firstName = newFirstName;
    }

    public boolean isFirstNameUpdated(String newFirstName) {
        return driver.findElement(firstNameField).getText().equals(newFirstName);
    }

    public void editLastName(String newLastName) {
        driver.findElement(lastNameField).clear();
        driver.findElement(lastNameField).sendKeys(newLastName);
        this.lastName = newLastName;
    }

    public boolean isLastNameUpdated(String newLastName) {
        return driver.findElement(lastNameField).getText().equals(newLastName);
    }

    public void editCompany(String newCompany) {
        driver.findElement(companyName).clear();
        driver.findElement(companyName).sendKeys(newCompany);
    }

    public boolean isCompanyUpdated(String newCompany) {
        return driver.findElement(companyName).getText().equals(newCompany);
    }

    public void editPhone(String newPhone) {
        driver.findElement(phoneField).clear();
        driver.findElement(phoneField).sendKeys(newPhone);
    }

    public boolean isPhoneUpdated(String newPhone) {
        return driver.findElement(phoneField).getText().equals(newPhone);
    }

    public void editEmail(String newEmail) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(newEmail);
    }

    public boolean isEmailUpdated(String newEmail) {
        return driver.findElement(emailField).getText().equals(newEmail);
    }

    public void editStreet(String newStreet) {
        driver.findElement(streetName).clear();
        driver.findElement(streetName).sendKeys(newStreet);
    }

    public boolean isStreetUpdated(String newStreet) {
        return driver.findElement(streetName).getText().equals(newStreet);
    }

    public void editZipCode(String newZip) {
        driver.findElement(zipCode).clear();
        driver.findElement(zipCode).sendKeys(newZip);
    }

    public boolean isZipCodeUpdated(String newZip) {
        return driver.findElement(zipCode).getText().equals(newZip);
    }

    public void editCity(String newCity) {
        driver.findElement(cityName).clear();
        driver.findElement(cityName).sendKeys(newCity);
    }

    public boolean isCityUpdated(String newCity) {
        return driver.findElement(cityName).getText().equals(newCity);
    }

    public void editNotes(String newNote) {
        driver.findElement(notes).clear();
        driver.findElement(notes).sendKeys(newNote);
    }

    public boolean isNotesUpdated(String newNote) {
        return driver.findElement(notes).getText().equals(newNote);
    }

    public void clickOkButton() {
        driver.findElement(okButton).click();
    }

    private By getEditedUserLocator() {
        return By.name(firstName + " " + lastName);
    }

    public boolean isContactEdited() {
        By editedUser = getEditedUserLocator();
        if (editedUser == null) {
            return false;
        }
        return WaitHelper.waitForElement(driver, editedUser).isDisplayed();
    }
}