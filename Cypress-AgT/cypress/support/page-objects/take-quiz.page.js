class TakingQuiz {

    mainMenuTab() {
        return cy.get('[class*="AppSidebar_inner"]')
    }

    quizzesTab() {
        return cy.get('[data-testid="app-sidebar-list-item-your-quizzes"]')
    }

    startQuizBtn() {
        return cy.get('[data-testid="quizzes-table-start-quiz-button"]')
    }

    continueBtn() {
        return cy.get('[data-testid="start-quiz-modal-continue-button"]')
    }

    readyCheckbox() {
        return cy.get('[data-testid="start-quiz-agreement-checkbox"]')
    }

    startBtn() {
        return cy.get('[data-testid="start-quiz-start-button"]')
    }

    finishQuizBtn() {
        return cy.get('[data-testid="quiz-finish-button"]')
    }

    completeQuizBtn() {
        return cy.get('[data-testid="quiz-finish-modal-complete-quiz-button"]')
    }

    goToDashboardBtn() {
        return cy.get('[data-testid="finished-quiz-dashboard-button"]')
    }

    completedQuizTab() {
        return cy.get('[data-testid="your-quizzes-finished-link"]')
    }

    hoverMainMenuTab() {
        this.mainMenuTab().click()
    }

    quizzesTabClick() {
        this.quizzesTab().click()
    }

    startQuizBtnClick() {
        this.startQuizBtn().click()
    }

    continueBtnClick() {
        this.continueBtn().click()
    }

    readyCheckboxClick() {
        this.readyCheckbox().click()
    }

    startBtnClick() {
        this.startBtn().click()
    }

    finishQuizBtnClick() {
        this.finishQuizBtn().click()
    }

    completeQuizBtnClick() {
        this.CompleteQuizBtn().click()
    }

    goToDashboardBtnClick() {
        this.goToDashboardBtn().click()
    }
}
export default new TakingQuiz()