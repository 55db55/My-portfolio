package pages.POM.simulationsPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitHelper;

public class ProcedureErrorPOM {
    private WebDriver driver;

    private By mainMenu = By.cssSelector("[data-testid='app-sidebar-home-link']");
    private By cs = By.cssSelector("[data-testid='app-sidebar-list-item-simulator']");
    private By procedureTab = By.cssSelector("[data-testid='simulations-procedures-tab']");
    private By newProcedure = By.cssSelector("[data-testid='simulations-new-procedure-button']");
    private By createNewProcedureBtn = By.cssSelector("[data-testid='procedure-create-button']");
    private By nameProcedureRequired = By.xpath("//*[contains(text(), 'Procedure name is required')]");
    private By stepRequired = By
            .xpath("//div[@data-slot='error-message'][contains(text(), 'Procedure name is required')]");

    public ProcedureErrorPOM(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMainMenu() {
        driver.findElement(mainMenu).click();
    }

    public void clickCs() {
        driver.findElement(cs).click();
    }

    public void clickProcedureTab() {
        WaitHelper.waitForElement(driver, procedureTab).click();
    }

    public void clickNewProcedure() {
        WaitHelper.waitForElement(driver, newProcedure).click();
    }

    public void clickCreateNewProcedureBtn() {
        WaitHelper.waitForElement(driver, createNewProcedureBtn).click();
    }

    public boolean isProcedureNameRequiredDisplayed() {
        return WaitHelper.waitForElement(driver, nameProcedureRequired).isDisplayed();
    }

    public boolean isStepRequiredDisplayed() {
        return WaitHelper.waitForElement(driver, stepRequired).isDisplayed();
    }
}