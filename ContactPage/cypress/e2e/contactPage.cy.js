/// <reference types = "cypress" />

import ContactPage from "../support/PageObjectModel/contactPagePOM.cy"

describe("Testing contact page", () => {

      beforeEach(() => {
            cy.visit("https://agenttrainer.ai/contact");
      })

      it("Testing if for correct data form is submitted", () => {
            ContactPage.typeName("abc");
            ContactPage.typeEmail("test@example.com");
            ContactPage.typeMessage("abcd");
            ContactPage.chceckCheckboxMessage();
            ContactPage.sendMessage();

            ContactPage.messageWasSentShouldBeDisplayed();
      })

      it("Testing incorrect name", () => {
            ContactPage.typeName("b");
            ContactPage.typeEmail("test@example.com");
            ContactPage.typeMessage("abcd");
            ContactPage.chceckCheckboxMessage();
            ContactPage.sendMessage();

            ContactPage.errorNameShouldBeDisplayed();
      })

      it("Testing incorrect email", () => {
            ContactPage.typeName("abc");
            ContactPage.typeEmail("test");
            ContactPage.typeMessage("abcd");
            ContactPage.chceckCheckboxMessage();
            ContactPage.sendMessage();

            ContactPage.errorEmainShouldBeDisplayed();
      })

      it("Testing incorrect message", () => {
            ContactPage.typeName("abc");
            ContactPage.typeEmail("test@example.com");
            ContactPage.typeMessage("b");
            ContactPage.chceckCheckboxMessage();
            ContactPage.sendMessage();

            ContactPage.errorMessageShouldBeDisplayed();
      })
})