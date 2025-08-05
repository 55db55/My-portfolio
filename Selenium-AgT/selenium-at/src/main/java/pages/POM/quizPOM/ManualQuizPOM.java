package pages.POM.quizPOM;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitHelper;

public class ManualQuizPOM {

    private WebDriver driver;

    private By createQuizBtn = By.cssSelector("[data-testid='dashboard-create-quiz-button']");
    private By chooseManualBtn = By.cssSelector("[data-testid='start-quiz-creator-manual-button']");
    private By nameField = By.name("name");
    private By addQuestionBtn = By.cssSelector("[data-testid='manual-quiz-form-add-question-button']");
    private By questionNameField = By.name("title");
    private By multipleChoiceCheckbox = By.cssSelector("input[type='radio'][value='CHECKBOX']");
    private By addAnswerBtn = By.cssSelector("[data-testid='add-answer-button']");
    private By answerField = By.name("answers[0].title");
    private By answerCheckbox = By.cssSelector("[data-testid='correct-answer-checkbox-0']");
    private By saveQuizBtn = By.cssSelector("[data-testid='save-question-button']");
    private By selectAllCheckbox = By.cssSelector("[data-testid='user-picker-select-all-checkbox']");
    private By saveAndPublish = By.cssSelector("[data-testid='manual-quiz-form-publish-button']");
    private By createQuizConfirmBtn = By.cssSelector("[data-testid='manual-quiz-completion-create-button']");
    private By quizSuccess = By.cssSelector("article:first-of-type h2[class*='QuizCard_desc']");

    public ManualQuizPOM(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCreateQuizBtn() {
        WaitHelper.waitForElement(driver, createQuizBtn).click();
    }

    public void clickChooseManualBtn() {
        WaitHelper.waitForElement(driver, chooseManualBtn).click();
    }

    public void enterQuizName(String name) {
        WaitHelper.waitForElement(driver, nameField).sendKeys(name);
    }

    public void clickAddQuestionBtn() {
        driver.findElement(addQuestionBtn).click();
    }

    public void enterQuestionName(String questionName) {
        WaitHelper.waitForElement(driver, questionNameField).sendKeys(questionName);
    }

    public boolean multipleChoiceIsSelected() {
        return driver.findElement(multipleChoiceCheckbox).isSelected();
    }

    public void clickAddAnswerBtn() {
        driver.findElement(addAnswerBtn).click();
    }

    public void enterAnswer(String answer) {
        WaitHelper.waitForElement(driver, answerField).sendKeys(answer);
    }

    public void selectAnswerCheckbox() {
        driver.findElement(answerCheckbox).click();
    }

    public void clickSaveQuizBtn() {
        driver.findElement(saveQuizBtn).click();
    }

    public void selectAllCheckbox() {
        WaitHelper.waitForElement(driver, selectAllCheckbox).click();
    }

    public void clickSaveAndPublish() {
        driver.findElement(saveAndPublish).click();
    }

    public void clickCreateQuizConfirmBtn() {
        WaitHelper.waitForElement(driver, createQuizConfirmBtn).click();
    }

    public boolean isQuizSuccessDisplayed() {
        return WaitHelper.waitForElementWithTimeout(driver, quizSuccess, Duration.ofSeconds(20)).isDisplayed();
    }

    public String getQuizSuccessText() {
        return driver.findElement(quizSuccess).getText();
    }
}