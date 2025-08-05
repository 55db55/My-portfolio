package pl.selenium.at.tests.quizTests;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import base.LoggedInBaseTest;
import io.qameta.allure.Description;
import pages.POM.quizPOM.AIQuizPOM;
import utils.AllureScreenshotListener;
import utils.ScreenshotHelper;

@Listeners(AllureScreenshotListener.class)
public class AIQuiz extends LoggedInBaseTest {

    @Test
    @Description("Creating AI quiz")
    public void testAIQuiz() {
        AIQuizPOM aiQuiz = new AIQuizPOM(driver);

        aiQuiz.clickCreateQuizBtn();
        aiQuiz.clickChooseAIBtn();
        aiQuiz.enterQuizName("Test AI Selenium");
        aiQuiz.clickSelectAllChecbox();
        aiQuiz.clickNextBtn();
        aiQuiz.clickCreateQuizConfirmBtn();

        assertTrue(aiQuiz.isSpinnerDisplayed());

        ScreenshotHelper.takeScreenshot(driver, "Spinner is loading");

        assertTrue(aiQuiz.isQuizSuccessDisplayed());
        assertTrue(aiQuiz.getQuizSuccessText().contains("Test AI Selenium"));

        ScreenshotHelper.takeScreenshot(driver, "Quiz AI is created");
    }
}