import { test, expect } from '@playwright/test';
import { LogInPOM } from '../PageObject/logInPOM';
import { CreateQuizAITestErrorMessagesPOM } from '../PageObject/createQuizAITestErrorMessagesPOM';
import { TestUser } from '../constants/credentials';

test.beforeEach(async ({ page }) => {
    const logIn = new LogInPOM(page);

    await logIn.goToLoginPage();
    await logIn.logIn(TestUser.EMAIL, TestUser.PASSWORD);

    await expect(logIn.homeHeading).toBeVisible({ timeout: 100000 });
})

test('createQuizAITestErrorMessages', async ({ page }) => {
    const createQuizAITestErrorMessagesPOM = new CreateQuizAITestErrorMessagesPOM(page);

    await createQuizAITestErrorMessagesPOM.createQuizAITestErrorMessages();

    await expect(createQuizAITestErrorMessagesPOM.errorMasseageQuizNameIsRequired).toBeVisible();
    await expect(createQuizAITestErrorMessagesPOM.lackOfQuizNameIcon).toBeVisible();
})