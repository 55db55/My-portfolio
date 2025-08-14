class ChangePassword {

    mainMenuTab() {
        return cy.get('[class*="AppSidebar_inner"]')
    }

    settings() {
        return cy.get('[data-testid="app-sidebar-list-item-settings"]')
    }

    password() {
        return cy.get('[data-testid="settings-nav-password"]')
    }

    oldPasswordField() {
        return cy.get('[data-testid="change-password-form-old-password-field"]')
    }

    newPasswordField1() {
        return cy.get('[data-testid="change-password-form-new-password-field"]')
    }

    newPasswordField2() {
        return cy.get('[data-testid="change-password-form-new-password-confirm-field"]')
    }

    changePasswordBtn() {
        return cy.get('[data-testid="change-password-form-change-password-button"]')
    }

    successChangedPassword() {
        return cy.contains('Password was successfully changed', { timeout: 10000 })
    }

    hoverMainMenuTab() {
        this.mainMenuTab().click()
    }

    settingsClick() {
        this.settings().click()
    }

    passwordClick() {
        this.password().click()
    }

    enterOldPassword(oldPassword) {
        this.oldPasswordField().type(oldPassword)
    }

    enterNewPassword1(newPassword) {
        this.newPasswordField1().type(newPassword)
    }

    enterNewPassword2(newPassword) {
        this.newPasswordField2().type(newPassword)
    }

    changePasswordBtnClick() {
        this.changePasswordBtn().click()
    }
}
export default new ChangePassword();