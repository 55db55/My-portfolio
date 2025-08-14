///< reference types = "cypress" />
import { standardSetup } from "../support/before-each"
import ChangeName from "../support/page-objects/change-name.page"

describe("User profile name", () => {
    beforeEach(() => {
        standardSetup()
    })

    it("should allow user to update their display name", () => {
        ChangeName.hoverMainMenuTab();
        ChangeName.settingsClick();
        ChangeName.personalInfoClick();
        ChangeName.enterName("ExternalUser1");
        ChangeName.saveChangesBtnClick();

        ChangeName.successBanner().should("be.visible")
        ChangeName.successBanner().should("contain.text", "User data was successfully changed")
    })
})        