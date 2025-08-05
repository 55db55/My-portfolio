package pl.selenium.at.tests.quizTests;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import base.LoggedInBaseTest;
import io.qameta.allure.Description;
import pages.POM.quizPOM.AIQuizErrorPOM;
import utils.AllureScreenshotListener;
import utils.ScreenshotHelper;

@Listeners(AllureScreenshotListener.class)
public class AIQuizError extends LoggedInBaseTest {

    @Test
    @Description("Checking errors when creating AI quiz")
    public void testAIQuizError() {
        AIQuizErrorPOM aiQuizError = new AIQuizErrorPOM(driver);

        aiQuizError.clickCreateQuizBtn();
        aiQuizError.clickChooseAIBtn();
        aiQuizError.clickNextBtn();

        assertTrue(aiQuizError.isNameRequiredDisplayed());

        ScreenshotHelper.takeScreenshot(driver, "Error is displayed");

        aiQuizError.enterQuizName("Test AI Selenium Error");
        aiQuizError.clickNextBtn();

        assertTrue(aiQuizError.userRequiredError().contains("At least one user is required"));

        ScreenshotHelper.takeScreenshot(driver, "Error is displayed");
    }
}