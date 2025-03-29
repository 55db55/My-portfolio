import { test, expect } from '@playwright/test';
import { LogInPOM } from '../PageObject/logInPOM';
import { CreateQuizAITestErrorMessagesPOM } from '../PageObject/createQuizAITestErrorMessagesPOM';

test.beforeEach(async ({ page }) => {
    const logIn = new LogInPOM(page);

    await logIn.goToLoginPage();
    await logIn.logIn('test@example.com', 'Password1');

    await expect(logIn.homeHeading).toBeVisible({ timeout: 100000 });
})

test('createQuizAITestErrorMessages', async ({ page }) => {
    const createQuizAITestErrorMessagesPOM = new CreateQuizAITestErrorMessagesPOM(page);

    await createQuizAITestErrorMessagesPOM.createQuizAITestErrorMessages();

    await expect(createQuizAITestErrorMessagesPOM.errorMasseageQuizNameIsRequired).toBeVisible();
    await expect(createQuizAITestErrorMessagesPOM.lackOfQuizNameIcon).toBeVisible();
})