package pl.selenium.at.tests.quizTests;

import static org.testng.Assert.assertTrue;
import base.LoggedInBaseTest;
import io.qameta.allure.Description;
import pages.POM.quizPOM.ManualQuizPOM;
import utils.AllureScreenshotListener;
import utils.ScreenshotHelper;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AllureScreenshotListener.class)
public class ManualQuiz extends LoggedInBaseTest {

    @Test
    @Description("Creating manual quiz")
    public void testManualQuiz() {
        ManualQuizPOM manualQuiz = new ManualQuizPOM(driver);

        manualQuiz.clickCreateQuizBtn();
        manualQuiz.clickChooseManualBtn();
        manualQuiz.enterQuizName("Test Selenium");
        manualQuiz.clickAddQuestionBtn();
        manualQuiz.enterQuestionName("What is Selenium?");

        assertTrue(manualQuiz.multipleChoiceIsSelected());

        manualQuiz.clickAddAnswerBtn();
        manualQuiz.enterAnswer("A testing framework");
        manualQuiz.selectAnswerCheckbox();
        manualQuiz.clickSaveQuizBtn();
        manualQuiz.selectAllCheckbox();

        ScreenshotHelper.takeScreenshot(driver, "Questions are added");

        manualQuiz.clickSaveAndPublish();
        manualQuiz.clickCreateQuizConfirmBtn();

        assertTrue(manualQuiz.isQuizSuccessDisplayed());
        assertTrue(manualQuiz.getQuizSuccessText().contains("Test Selenium"));

        ScreenshotHelper.takeScreenshot(driver, "Quiz is created");
    }
}