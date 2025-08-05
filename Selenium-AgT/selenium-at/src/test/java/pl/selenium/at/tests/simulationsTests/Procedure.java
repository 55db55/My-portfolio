package pl.selenium.at.tests.simulationsTests;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import base.LoggedInBaseTest;
import io.qameta.allure.Description;
import pages.POM.simulationsPOM.ProcedurePOM;
import utils.AllureScreenshotListener;
import utils.ScreenshotHelper;

@Listeners(AllureScreenshotListener.class)
public class Procedure extends LoggedInBaseTest {

    @Test
    @Description("Creating new procedure")
    public void creatingNewProcedure() {
        ProcedurePOM newProcedure = new ProcedurePOM(driver);

        newProcedure.clickMainMenu();
        newProcedure.clickCs();
        newProcedure.clickProcedureTab();
        newProcedure.clickNewProcedure();
        newProcedure.enterProcedureName("Test Selenium");
        newProcedure.enterStep1("Ask about WebDriverIO");
        newProcedure.clickAddAnotherStepBtn();
        newProcedure.enterStep2("Ask about Java");
        newProcedure.clickCreateNewProcedureBtn();
        newProcedure.clickCreateNewProcedureBtn();

        assertTrue(newProcedure.successMessageIsDisplayed());

        ScreenshotHelper.takeScreenshot(driver, "Success procedure created");
    }
}