package pages.POM.logInPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitHelper;

public class ValidLogInPOM {

    private WebDriver driver;

    private By logInLChButton = By.cssSelector("[data-testid='login-live-chat-button']");
    private By emailFiled = By.name("email");
    private By passwordField = By.id("sign-in-password-field");
    private By logInBtn = By.cssSelector("[data-testid='login-form-button']");
    private By homePage = By.cssSelector("[data-testid='app-header-title']");

    public ValidLogInPOM(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogInLChButton() {
        WaitHelper.waitForElement(driver, logInLChButton).click();
    }

    public void enterEmail(String email) {
        WaitHelper.waitForElement(driver, emailFiled).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogInButton() {
        driver.findElement(logInBtn).click();
    }

    public boolean isHomePageDisplayed() {
        return WaitHelper.waitForElement(driver, homePage).isDisplayed();
    }
}