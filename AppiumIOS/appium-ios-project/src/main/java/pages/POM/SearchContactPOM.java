package pages.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchContactPOM {

    private WebDriver driver;

    private By searchFiled = By.name("Szukaj");

    public SearchContactPOM(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSearchField() {
        driver.findElement(searchFiled).click();
    }

    public void enterSearchText(String firstName) {
        driver.findElement(searchFiled).sendKeys(firstName);
    }

    public boolean isContactVisible(String firstName, String lastName, String email) {
        String contactXPath = String.format("//XCUIElementTypeCell[@label='%s %s, %s']", firstName, lastName, email);

        By contactOnList = By.xpath(contactXPath);
        return driver.findElement(contactOnList).isDisplayed();
    }
}