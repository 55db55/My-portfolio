import { expect, Locator, Page } from '@playwright/test';

export class CreateQuizAITestErrorMessagesPOM {
    
    private page: Page;
    readonly createNewQuizButtonOnDashboard: Locator;
    readonly chooseQuziAIButton: Locator;
    readonly acceptAINextButton: Locator;
    readonly errorMasseageQuizNameIsRequired: Locator;
    readonly lackOfQuizNameIcon: Locator;

    constructor(page: Page) {
        this.page = page
        this.createNewQuizButtonOnDashboard = page.getByRole('button', { name: 'Create quiz' })
        this.chooseQuziAIButton = page.getByRole('button', { name: 'Configure' }).first()
        this.acceptAINextButton = page.getByRole('button', { name: 'Next' })
        this.errorMasseageQuizNameIsRequired = page.getByText('Quiz name is required')
        this.lackOfQuizNameIcon = page.getByRole('main').locator('div').filter({ hasText: 'Add quiz name The name of the' }).locator('path')
    }

    async createQuizAITestErrorMessages() {
        await this.createNewQuizButtonOnDashboard.click()
        await this.chooseQuziAIButton.click()
        await this.acceptAINextButton.click()
    }
}