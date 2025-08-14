import LogIn from "./page-objects/log-in.page.cy"
import { apiBaseUrl } from "./api-data";

export const standardSetup = () => {
    cy.fixture('user-data').then((userData) => {
        cy.visit(`${apiBaseUrl()}/login`);
        LogIn.logInExternalUser();
        LogIn.enterEmail(userData.testUser.email);
        LogIn.enterPassword(userData.testUser.password);
        LogIn.logInClick();
        LogIn.logInClick();
        LogIn.homeBannerVisible();
    })
}