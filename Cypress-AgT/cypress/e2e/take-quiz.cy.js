/// <reference types="cypress" />
import { standardSetup } from "../support/before-each"
import TakingQuiz from "../support/page-objects/taking-quiz.page"

describe("Taking Quiz", () => {
    beforeEach(() => {
        standardSetup()
    })

    it("Taking quiz by External user", () => {
        TakingQuiz.hoverMainMenuTab();
        TakingQuiz.quizzesTabClick();
        TakingQuiz.startQuizBtnClick();
        TakingQuiz.continueBtnClick();
        TakingQuiz.readyCheckboxClick();
        TakingQuiz.startBtnClick({ timeout: 10000 });
        TakingQuiz.finishQuizBtnClick();
        TakingQuiz.completeQuizBtn().click();
        TakingQuiz.goToDashboardBtn().should("be.visible");
        TakingQuiz.goToDashboardBtn().click();
        TakingQuiz.completedQuizTab().should("be.visible");
    })
})