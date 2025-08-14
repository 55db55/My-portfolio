/// <reference types="cypress" />
import { standardSetup } from "../support/before-each"
import ChangePassword from "../support/page-objects/change-password.page"

describe("Change password", () => {
    let userData;

    beforeEach(() => {
        standardSetup()
    })

    before(() => {
        cy.fixture('user-data').then((data) => {
            userData = data;
        });
    });

    it("should allow user to change their password", () => {
        ChangePassword.hoverMainMenuTab();
        ChangePassword.settingsClick();
        ChangePassword.passwordClick();
        ChangePassword.enterOldPassword(userData.testUser.password);
        ChangePassword.enterNewPassword1(userData.testUser.password);
        ChangePassword.enterNewPassword2(userData.testUser.password);
        ChangePassword.changePasswordBtnClick();
        ChangePassword.changePasswordBtnClick();

        ChangePassword.successChangedPassword().should("be.visible");
    })
})