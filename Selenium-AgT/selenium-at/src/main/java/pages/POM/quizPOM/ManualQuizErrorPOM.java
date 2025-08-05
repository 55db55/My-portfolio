package pages.POM.quizPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitHelper;

public class ManualQuizErrorPOM {
    private WebDriver driver;

    private By createQuizBtn = By.cssSelector("[data-testid='dashboard-create-quiz-button']");
    private By chooseManualBtn = By.cssSelector("[data-testid='start-quiz-creator-manual-button']");
    private By saveAndPublish = By.cssSelector("[data-testid='manual-quiz-form-publish-button']");
    private By nameRequired = By.cssSelector("[data-slot='error-message']");
    private By questionRequired = By.xpath(
            "//div[contains(@class, 'ManualQuizForm_questions')]//small[contains(text(), 'Min one question is required')]");
    private By addQuestionBtn = By.cssSelector("[data-testid='manual-quiz-form-add-question-button']");
    private By saveQuizBtn = By.cssSelector("[data-testid='save-question-button']");
    private By questionNameRequired = By
            .xpath("//div[@data-slot='error-message'][contains(text(), 'Question is required')]");
    private By min1answerRequired = By.xpath("//small[contains(text(), 'At least one answer must be added')]");
    private By questionNameFiled = By.name("title");
    private By addAnswerBtn = By.cssSelector("[data-testid='add-answer-button']");
    private By answerField = By.name("answers[0].title");
    private By answerCheckbox = By.cssSelector("[data-testid='correct-answer-checkbox-0']");
    private By correctAnswerChecked = By
            .xpath("//small[contains(text(), 'At least one answer must be matched as correct')]");
    private By nameField = By.name("name");
    private By userRequired = By.xpath("//p[contains(text(), 'At least one user is required')]");

    public ManualQuizErrorPOM(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCreateQuizBtn() {
        WaitHelper.waitForElement(driver, createQuizBtn).click();
    }

    public void clickChooseManualBtn() {
        WaitHelper.waitForElement(driver, chooseManualBtn).click();
    }

    public void clickSaveAndPublish() {
        WaitHelper.waitForElement(driver, saveAndPublish).click();
    }

    public String nameError() {
        return driver.findElement(nameRequired).getText();
    }

    public String questionError() {
        return driver.findElement(questionRequired).getText();
    }

    public void clickAddQuestionBtn() {
        driver.findElement(addQuestionBtn).click();
    }

    public void clickSaveQuizBtn() {
        driver.findElement(saveQuizBtn).click();
    }

    public String questionNameError() {
        WaitHelper.waitForElement(driver, questionNameRequired);
        return driver.findElement(questionNameRequired).getText();
    }

    public String min1answerError() {
        return driver.findElement(min1answerRequired).getText();
    }

    public void enterQuestionName(String questionName) {
        driver.findElement(questionNameFiled).sendKeys(questionName);
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

    public String correctAnswerCheckedError() {
        return driver.findElement(correctAnswerChecked).getText();
    }

    public void enterQuizName(String name) {
        WaitHelper.waitForElement(driver, nameField).sendKeys(name);
    }

    public String userRequiredError() {
        return WaitHelper.waitForElement(driver, userRequired).getText();
    }
}