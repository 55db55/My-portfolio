package pages.POM.quizPOM;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitHelper;

public class AIQuizErrorPOM {

    private WebDriver driver;

    private By createQuizBtn = By.cssSelector("[data-testid='dashboard-create-quiz-button']");
    private By chooseAIBtn = By.cssSelector("[data-testid='start-quiz-creator-ai-button']");
    private By nextBtn = By.cssSelector("[data-testid='chat-quiz-form-next-button']");
    private By nameRequired = By.cssSelector("[data-testid='chat-quiz-form-name-textarea']");
    private By nameField = By.cssSelector("[data-testid='chat-quiz-form-name-textarea']");
    private By userRequired = By.xpath("//p[contains(text(), 'At least one user is required')]");

    public AIQuizErrorPOM(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCreateQuizBtn() {
        WaitHelper.waitForElement(driver, createQuizBtn).click();
    }

    public void clickChooseAIBtn() {
        WaitHelper.waitForElement(driver, chooseAIBtn).click();
    }

    public void clickNextBtn() {
        WaitHelper.waitForElement(driver, nextBtn).click();
    }

    public boolean isNameRequiredDisplayed() {
        return WaitHelper.waitForElement(driver, nameRequired).isDisplayed();
    }

    public void enterQuizName(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(nameField));
        input.clear();
        input.sendKeys(name);
    }

    public String userRequiredError() {
        return WaitHelper.waitForElement(driver, userRequired).getText();
    }
}