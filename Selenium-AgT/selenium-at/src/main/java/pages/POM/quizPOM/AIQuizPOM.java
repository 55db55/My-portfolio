package pages.POM.quizPOM;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitHelper;

public class AIQuizPOM {

    private WebDriver driver;

    private By createQuizBtn = By.cssSelector("[data-testid='dashboard-create-quiz-button']");
    private By chooseAIBtn = By.cssSelector("[data-testid='start-quiz-creator-ai-button']");
    private By nameField = By.cssSelector("[data-testid='chat-quiz-form-name-textarea']");
    private By selectAllCheckbox = By.cssSelector("[data-testid='user-picker-select-all-checkbox']");
    private By nextBtn = By.cssSelector("[data-testid='chat-quiz-form-next-button']");
    private By createQuizConfirmBtn = By.cssSelector("[data-testid='finish-chat-quiz-creation-confirm-button']");
    private By spinner = By.xpath("//*[contains(text(), 'Question generation')]");
    private By quizSuccess = By.cssSelector("article:first-of-type h2[class*='QuizCard_desc']");

    public AIQuizPOM(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCreateQuizBtn() {
        WaitHelper.waitForElement(driver, createQuizBtn).click();
    }

    public void clickChooseAIBtn() {
        WaitHelper.waitForElement(driver, chooseAIBtn).click();
    }

    public void enterQuizName(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(nameField));
        input.clear();
        input.sendKeys(name);
    }

    public void clickSelectAllChecbox() {
        driver.findElement(selectAllCheckbox).click();
    }

    public void clickNextBtn() {
        driver.findElement(nextBtn).click();
    }

    public void clickCreateQuizConfirmBtn() {
        WaitHelper.waitForElement(driver, createQuizConfirmBtn).click();
    }

    public boolean isSpinnerDisplayed() {
        return WaitHelper.waitForElement(driver, spinner).isDisplayed();
    }

    public boolean isQuizSuccessDisplayed() {
        return WaitHelper.waitForElementWithTimeout(driver, quizSuccess, Duration.ofSeconds(20)).isDisplayed();
    }

    public String getQuizSuccessText() {
        return driver.findElement(quizSuccess).getText();
    }
}