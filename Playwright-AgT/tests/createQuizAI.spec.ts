import { test, expect } from '@playwright/test';
import { LogInPOM } from '../PageObject/logInPOM';
import { CreateQuizAIPOM } from '../PageObject/createQuizAIPOM';

test.beforeEach(async ({ page }) => {
    const logIn = new LogInPOM(page);

    await logIn.goToLoginPage();
    await logIn.logIn('test@example.com', 'Password1');

    await expect(logIn.homeHeading).toBeVisible();
})

test('createQuizAI', async ({ page }) => {
    const createQuizAIPOM = new CreateQuizAIPOM(page);

    await createQuizAIPOM.createQuizAI('Quiz AI')
    await createQuizAIPOM.expectQuizAICreated()
})