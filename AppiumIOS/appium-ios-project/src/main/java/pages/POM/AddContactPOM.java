package pages.POM;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitHelper;

public class AddContactPOM {

    private WebDriver driver;

    private By addButton = By.name("Dodaj");
    private By firstNameField = By.name("Imię");
    private By lastNameField = By.name("Nazwisko");
    private By companyName = By.name("Firma");
    private By addPhoneButton = By.name("dodaj telefon");
    private By phoneField = By.xpath("//XCUIElementTypeTextField[@value='Telefon']");
    private By addEmail = By.name("dodaj email");
    private By emailField = By.xpath("//XCUIElementTypeTextField[@value='Email']");
    private By ringtone = By.name("Dzwonek");
    private By chooseValley = By.name("Dolina");
    private By ringtoneOk = By.name("Gotowe");
    private By addAdress = By.name("dodaj adres");
    private By streetName = By.name("Ulica");
    private By zipCode = By.name("Kod");
    private By cityName = By.name("Miasto");
    private By addBirthDay = By.name("dodaj urodziny");
    private By notes = By.name("Notatki");
    private By okButton = By.name("OK");
    private String firstName;
    private String lastName;

    private By getNewUserLocator() {
        return By.name(firstName + " " + lastName);
    }

    public AddContactPOM(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddButton() {
        driver.findElement(addButton).click();
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
        this.firstName = firstName;
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
        this.lastName = lastName;
    }

    public void enterCompany(String company) {
        driver.findElement(companyName).sendKeys(company);
    }

    public void clickAddPhoneButton() {
        driver.findElement(addPhoneButton).click();
    }

    public void enterPhone(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void clickAddEmailButton() {
        driver.findElement(addEmail).click();
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void clickRingtone() {
        driver.findElement(ringtone).click();
    }

    public void chooseValley() {
        driver.findElement(chooseValley).click();
    }

    public void clickRingtoneOk() {
        driver.findElement(ringtoneOk).click();
    }

    public void clickAddAdress() {
        driver.findElement(addAdress).click();
    }

    public void enterStreet(String street) {
        driver.findElement(streetName).sendKeys(street);
    }

    public void enterZipCode(String zip) {
        driver.findElement(zipCode).sendKeys(zip);
    }

    public void enterCity(String city) {
        driver.findElement(cityName).sendKeys(city);
    }

    public void clickAddBirthDay() {
        driver.findElement(addBirthDay).click();
    }

    public void scrollDatePicker(String value, int wheelIndex) {
        List<WebElement> pickerWheels = driver.findElements(
                By.className("XCUIElementTypePickerWheel"));

        WebElement wheel = pickerWheels.get(wheelIndex);
        wheel.sendKeys(value);
    }

    public void enterBirthday(String date, String month, String year) {
        scrollDatePicker(date, 0);
        scrollDatePicker(month, 1);
        scrollDatePicker(year, 2);
    }

    public void enterNotes(String note) {
        driver.findElement(notes).sendKeys(note);
    }

    public void clickOkButton() {
        driver.findElement(okButton).click();
    }

    public boolean isContactAdded() {
        By newUser = getNewUserLocator();
        if (newUser == null) {
            return false;
        }
        return WaitHelper.waitForElement(driver, newUser).isDisplayed();
    }
}