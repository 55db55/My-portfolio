package pl.selenium.at.tests.quizTests;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import base.LoggedInBaseTest;
import io.qameta.allure.Description;
import pages.POM.quizPOM.ManualQuizErrorPOM;
import utils.AllureScreenshotListener;
import utils.ScreenshotHelper;

@Listeners(AllureScreenshotListener.class)
public class ManualQuizError extends LoggedInBaseTest {

    @Test
    @Description("Creating manual quiz with error")
    public void testManualQuizError() {
        ManualQuizErrorPOM manualQuizError = new ManualQuizErrorPOM(driver);

        manualQuizError.clickCreateQuizBtn();
        manualQuizError.clickChooseManualBtn();
        manualQuizError.clickSaveAndPublish();

        ScreenshotHelper.takeScreenshot(driver, "Error message is displayed");

        assertTrue(manualQuizError.nameError().contains("Quiz name is required"));
        assertTrue(manualQuizError.questionError().contains("Min one question is required"));

        manualQuizError.clickAddQuestionBtn();
        manualQuizError.clickSaveQuizBtn();

        ScreenshotHelper.takeScreenshot(driver, "Error message is displayed");

        assertTrue(manualQuizError.questionNameError().contains("Question is required"));
        assertTrue(manualQuizError.min1answerError().contains("At least one answer must be added"));

        manualQuizError.enterQuestionName("Selenium error what is?");
        manualQuizError.clickAddAnswerBtn();
        manualQuizError.enterAnswer("A testing framework");
        manualQuizError.clickSaveQuizBtn();

        ScreenshotHelper.takeScreenshot(driver, "Error message is displayed");

        assertTrue(
                manualQuizError.correctAnswerCheckedError().contains("At least one answer must be matched as correct"));

        manualQuizError.selectAnswerCheckbox();
        manualQuizError.clickSaveQuizBtn();
        manualQuizError.enterQuizName("Test Selenium Error");
        manualQuizError.clickSaveAndPublish();

        ScreenshotHelper.takeScreenshot(driver, "Error message is displayed");

        assertTrue(manualQuizError.userRequiredError().contains("At least one user is required"));
    }
}