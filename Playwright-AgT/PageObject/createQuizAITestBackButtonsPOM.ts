import { expect, Locator, Page } from '@playwright/test';

export class CreateQuizAITestBackButtonsPOM {

    private page: Page;
    readonly createNewQuizButtonOnDashboard: Locator;
    readonly chooseQuziAIButton: Locator;
    readonly backCreatingQuizAIButton1: Locator;
    readonly quizAINameField: Locator;
    readonly youAreAboutToCancelCreatingYourQuizWindow: Locator;
    readonly notWantToCancelButton: Locator;
    readonly selectAllCheckbox: Locator;
    readonly acceptAINextButton: Locator;
    readonly ChooseAmountOfAIQuestionsWindowMessage: Locator;
    readonly backCreatingQuizAIButton2: Locator;
    readonly createQuizButton: Locator;
    readonly manageQuizzesHeader: Locator;
    readonly createdAIQuiz: Locator;

    constructor(page: Page) {
        this.page = page
        this.createNewQuizButtonOnDashboard = page.getByRole('button', { name: 'Create quiz' })
        this.chooseQuziAIButton = page.getByRole('button', { name: 'Configure' }).first()
        this.quizAINameField = page.getByRole('textbox', { name: 'Quiz name Quiz name' })
        this.selectAllCheckbox = page.locator('label').filter({ hasText: 'Select all' }).locator('svg')
        this.backCreatingQuizAIButton1 = page.getByRole('button', { name: 'Back' })
        this.youAreAboutToCancelCreatingYourQuizWindow = page.getByRole('heading', { name: 'You\'re about to cancel' })
        this.notWantToCancelButton = page.getByRole('button', { name: 'Go back' })
        this.acceptAINextButton = page.locator('button').filter({ hasText: 'Next' })
        this.ChooseAmountOfAIQuestionsWindowMessage = page.getByRole('heading', { name: 'You\'re about to complete' })
        this.backCreatingQuizAIButton2 = page.getByRole('button', { name: 'Back' })
        this.createQuizButton = page.getByRole('button', { name: 'Create quiz' })
        this.manageQuizzesHeader = page.getByText('Manage your quizzes')
        this.createdAIQuiz = page.locator('a').filter({ hasText: 'QUIZdraftQuizAITestBackButtons' }).first()
    }

    async createQuizAITestBackButtons(quizAIName) {
        await this.createNewQuizButtonOnDashboard.click()
        await this.chooseQuziAIButton.click()
        await this.quizAINameField.fill(quizAIName)
        await this.selectAllCheckbox.click()
        await this.backCreatingQuizAIButton1.click()

        await expect(this.youAreAboutToCancelCreatingYourQuizWindow).toBeVisible()

        await this.notWantToCancelButton.click()
        await this.acceptAINextButton.click()

        await expect(this.ChooseAmountOfAIQuestionsWindowMessage).toBeVisible()

        await this.backCreatingQuizAIButton2.click()
        await this.acceptAINextButton.click()
        await this.createQuizButton.click()
    }
}