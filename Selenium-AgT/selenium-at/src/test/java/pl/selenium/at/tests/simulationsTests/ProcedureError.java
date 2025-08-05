package pl.selenium.at.tests.simulationsTests;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import base.LoggedInBaseTest;
import io.qameta.allure.Description;
import pages.POM.simulationsPOM.ProcedureErrorPOM;
import utils.AllureScreenshotListener;
import utils.ScreenshotHelper;

@Listeners(AllureScreenshotListener.class)
public class ProcedureError extends LoggedInBaseTest {

    @Test
    @Description("Errors when creating new procedure")
    public void errorsWhenCreatingNewProcedure() {
        ProcedureErrorPOM procedureError = new ProcedureErrorPOM(driver);

        procedureError.clickMainMenu();
        procedureError.clickCs();
        procedureError.clickProcedureTab();
        procedureError.clickNewProcedure();
        procedureError.clickCreateNewProcedureBtn();

        assertTrue(procedureError.isProcedureNameRequiredDisplayed());
        assertTrue(procedureError.isStepRequiredDisplayed());

        ScreenshotHelper.takeScreenshot(driver, "Errors when creating new procedure");
    }
}