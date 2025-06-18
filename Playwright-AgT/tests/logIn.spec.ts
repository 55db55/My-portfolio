import { test, expect } from '@playwright/test';
import { LogInPOM } from '../PageObject/logInPOM';
import { TestUser } from '../constants/credentials';

test('LogIn', async ({ page }) => {
    const logIn = new LogInPOM(page);

    await logIn.goToLoginPage();
    await logIn.logIn(TestUser.EMAIL, TestUser.PASSWORD);

    await expect(logIn.homeHeading).toBeVisible();
})