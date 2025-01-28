class ContactPage {

    getEnterYourName() {
        return cy.get('input[placeholder="Enter your name"]')
    }
    getEnterEmail() {
        return cy.get('input[name="email"]')
    }

    getEnterMessage() {
        return cy.get('textarea[name="message"]')
    }

    getCheckBoxMessage() {
        return cy.get(".Checkbox_input__unbYz")
    }

    getSendMessageBtn() {
        return cy.get('button[type="submit"]')
    }

    typeName(name) {
        this.getEnterYourName().type(name, { force: true })
    }

    typeEmail(email) {
        this.getEnterEmail().type(email, { force: true })
    }
    
    typeMessage(message) {
        this.getEnterMessage().type(message, { force: true })
    }

    chceckCheckboxMessage() {
        this.getCheckBoxMessage().check({ force: true });
    }

    sendMessage() {
        this.getSendMessageBtn().click()
    }

    messageWasSentShouldBeDisplayed() {
        return cy.get('.InformationModal_wrapper__NxvAg', { timeout: 10000 }).should("be.visible")
    }

    errorNameShouldBeDisplayed() {
        return cy.get('[id$="-description"]').should("contain", "Min. 2 characters")
    }

    errorEmainShouldBeDisplayed() {
        return cy.get('[id$="-description"]').should("contain", "Email is invalid");
    }

    errorMessageShouldBeDisplayed() {
        return cy.get('[id$="-description"]').should("contain", "Min. 4 characters");
    }
}

export default new ContactPage();