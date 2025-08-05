package pages.POM.logInPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitHelper;

public class InvalidLogInPOM {

        private WebDriver driver;

        private By logInLChButton = By.cssSelector("[data-testid='login-live-chat-button']");
        private By logInBtn = By.cssSelector("[data-testid='login-form-button']");
        private By errorMessage = By.cssSelector("[class*='lc-FieldError-module__field-error']");

        public InvalidLogInPOM(WebDriver driver) {
                this.driver = driver;
        }

        public void clickLogInLChButton() {
                WaitHelper.waitForElement(driver, logInLChButton).click();
        }

        public void logInBtn() {
                WaitHelper.waitForElement(driver, logInBtn).click();
        }

        public boolean isErrorMessageDisplayed() {
                return WaitHelper.waitForElement(driver, errorMessage).isDisplayed();
        }
}