import { test, expect } from '@playwright/test';
import { LogInPOM } from '../PageObject/logInPOM';

test('LogIn', async ({ page }) => {
    const logIn = new LogInPOM(page);

    await logIn.goToLoginPage();
    await logIn.logIn('test@example.com', 'Password1');

    await expect(logIn.homeHeading).toBeVisible();
})