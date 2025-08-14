class LogIn {

    logInExternalUserButton() {
        return cy.get('[data-testid="login-credentials-button"]')
    }

    emailField() {
        return cy.get('input[name="email"]')
    }

    passwordField() {
        return cy.get('input[name="password"]')
    }

    logInBtn() {
        return cy.get('[data-testid="login-form-login-button"]')
    }

    homeBanner() {
        return cy.get('[data-testid="app-header-title"]')
    }

    logInExternalUser() {
        this.logInExternalUserButton().click();
    }

    enterEmail(email) {
        this.emailField().type(email);
    }

    enterPassword(password) {
        this.passwordField().type(password);
    }

    logInClick() {
        this.logInBtn().click();
    }

    homeBannerVisible() {
        return cy.get('[data-testid="app-header-title"]').should("be.visible");
    }
}
export default new LogIn();