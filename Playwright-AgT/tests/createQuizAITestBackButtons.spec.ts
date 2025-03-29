import { test, expect } from '@playwright/test';
import { LogInPOM } from '../PageObject/logInPOM';
import { CreateQuizAITestBackButtonsPOM } from '../PageObject/createQuizAITestBackButtonsPOM';

test.beforeEach(async ({ page }) => {
    const logIn = new LogInPOM(page);

    await logIn.goToLoginPage();
    await logIn.logIn('test@example.com', 'Password1');

    await expect(logIn.homeHeading).toBeVisible({ timeout: 100000 });
})

test('createQuizAITestBuckButtons', async ({ page }) => {
    const createQuizAITestBuckButtonsPOM = new CreateQuizAITestBackButtonsPOM(page);

    await createQuizAITestBuckButtonsPOM.createQuizAITestBackButtons('QuizAITestBackButtons')

    await expect(createQuizAITestBuckButtonsPOM.manageQuizzesHeader).toBeVisible();
    await expect(createQuizAITestBuckButtonsPOM.createdAIQuiz).toBeVisible()
})