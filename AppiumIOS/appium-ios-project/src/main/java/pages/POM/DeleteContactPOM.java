package pages.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import java.util.HashMap;
import java.util.Map;

public class DeleteContactPOM {

    private AppiumDriver<WebElement> driver;

    private String firstName;
    private String lastName;
    private By userToDelete;
    private By deleteContact = By.name("Usuń kontakt");
    private By confirmationDeleteModal;
    private By deleteContactButton = By.name("Usuń kontakt");

    public DeleteContactPOM(WebDriver driver) {
        this.driver = (AppiumDriver<WebElement>) driver;
    }

    public void setContactDetails(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userToDelete = By.name(firstName + " " + lastName);
        this.confirmationDeleteModal = By
                .name("Czy na pewno chcesz usunąć wizytówkę „" + firstName + " " + lastName + "”?");
    }

    public void longPressContact() {
        try {
            WebElement element = driver.findElement(By.name(firstName + " " + lastName));

            Map<String, Object> params = new HashMap<>();
            params.put("elementId", ((RemoteWebElement) element).getId());
            params.put("duration", 1.0);
            ((JavascriptExecutor) driver).executeScript("mobile: touchAndHold", params);

            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.visibilityOfElementLocated(By.name("Usuń kontakt")));

        } catch (Exception e) {
            System.out.println("Nie można wykonać long press: " + e.getMessage());
        }
    }

    public void clickDeleteContact() {
        driver.findElement(deleteContact).click();
    }

    public boolean isConfirmationModalDisplayed() {
        return driver.findElement(confirmationDeleteModal).isDisplayed();
    };

    public void clickDeleteContactButton() {
        driver.findElement(deleteContactButton).click();
    }

    public boolean isContactDeleted() {
        return driver.findElements(userToDelete).isEmpty();
    }
}