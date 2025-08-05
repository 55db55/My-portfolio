package pages.POM.simulationsPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitHelper;

public class ProcedurePOM {
    private WebDriver driver;

    private By mainMenu = By.cssSelector("[data-testid='app-sidebar-home-link']");
    private By cs = By.cssSelector("[data-testid='app-sidebar-list-item-simulator']");
    private By procedureTab = By.cssSelector("[data-testid='simulations-procedures-tab']");
    private By newProcedure = By.cssSelector("[data-testid='simulations-new-procedure-button']");
    private By procedureName = By.cssSelector("[data-testid='procedure-name-input']");
    private By step1 = By.cssSelector("[data-testid='procedure-step-0-name-input']");
    private By addAnotherStepBtn = By.cssSelector("[data-testid='procedure-add-step-button']");
    private By step2 = By.cssSelector("[data-testid='procedure-step-1-name-input']");
    private By createNewProcedureBtn = By.cssSelector("[data-testid='procedure-create-button']");
    private By successProcedureAdded = By.xpath("//*[contains(text(), 'Procedure was successfully added')]");

    public ProcedurePOM(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMainMenu() {
        WaitHelper.waitForElement(driver, mainMenu).click();
    }

    public void clickCs() {
        WaitHelper.waitForElement(driver, cs).click();
    }

    public void clickProcedureTab() {
        WaitHelper.waitForElement(driver, procedureTab).click();
    }

    public void clickNewProcedure() {
        WaitHelper.waitForElement(driver, newProcedure).click();
    }

    public void enterProcedureName(String name) {
        WaitHelper.waitForElement(driver, procedureName).sendKeys("name");
    }

    public void enterStep1(String stepOfProcedure) {
        driver.findElement(step1).sendKeys(stepOfProcedure);
    }

    public void clickAddAnotherStepBtn() {
        driver.findElement(addAnotherStepBtn).click();
    }

    public void enterStep2(String stepOfProcedure) {
        WaitHelper.waitForElement(driver, step2).sendKeys(stepOfProcedure);
    }

    public void clickCreateNewProcedureBtn() {
        WaitHelper.waitForElement(driver, createNewProcedureBtn).click();
    }

    public boolean successMessageIsDisplayed() {
        return WaitHelper.waitForElement(driver, successProcedureAdded).isDisplayed();
    }
}