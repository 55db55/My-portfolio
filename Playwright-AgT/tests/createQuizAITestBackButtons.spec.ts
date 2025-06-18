import { test, expect } from '@playwright/test';
import { LogInPOM } from '../PageObject/logInPOM';
import { CreateQuizAITestBackButtonsPOM } from '../PageObject/createQuizAITestBackButtonsPOM';
import { TestUser } from '../constants/credentials';

test.beforeEach(async ({ page }) => {
    const logIn = new LogInPOM(page);

    await logIn.goToLoginPage();
    await logIn.logIn(TestUser.EMAIL, TestUser.PASSWORD);

    await expect(logIn.homeHeading).toBeVisible({ timeout: 100000 });
})

test('createQuizAITestBuckButtons', async ({ page }) => {
    const createQuizAITestBuckButtonsPOM = new CreateQuizAITestBackButtonsPOM(page);

    await createQuizAITestBuckButtonsPOM.createQuizAITestBackButtons('QuizAITestBackButtons');

    await expect(createQuizAITestBuckButtonsPOM.manageQuizzesHeader).toBeVisible();
    await expect(createQuizAITestBuckButtonsPOM.createdAIQuiz).toBeVisible();
})