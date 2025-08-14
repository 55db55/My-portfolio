class ChangeName {

    mainMenuTab() {
        return cy.get('[class*="AppSidebar_inner"]')
    }

    settings() {
        return cy.get('[data-testid="app-sidebar-list-item-settings"]')
    }

    personalInfo() {
        return cy.get('[data-testid="settings-nav-personal"]')
    }

    nameField() {
        return cy.get('input[name="fullName"]')
    }

    saveChangesBtn() {
        return cy.get('[data-testid="edit-user-data-save-changes-button"]')
    }

    successBanner() {
        return cy.get('[data-content=""] > div')
    }

    hoverMainMenuTab() {
        this.mainMenuTab().click()
    }

    settingsClick() {
        this.settings().click()
    }

    personalInfoClick() {
        this.personalInfo().click()
    }

    enterName(newName) {
        this.nameField().type(newName)
    }

    saveChangesBtnClick() {
        this.saveChangesBtn().click()
    }
}
export default new ChangeName()