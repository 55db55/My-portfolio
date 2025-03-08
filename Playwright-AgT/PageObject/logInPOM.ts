import { Locator, Page } from '@playwright/test';
export class LogInPOM {

    private page: Page;
    readonly logInAsLiveChatUserBtn: Locator;
    readonly usernameField: Locator;
    readonly passwordField: Locator;
    readonly logInButton: Locator;
    readonly homeHeading: Locator;

    constructor(page: Page) {
        this.page = page
        this.logInAsLiveChatUserBtn = page.getByRole('button', { name: 'Log in as LiveChat user' })
        this.usernameField = page.getByRole('textbox', { name: 'name@work-email.com' })
        this.passwordField = page.getByRole('textbox', { name: 'Enter your password' })
        this.logInButton = page.getByTestId('login-form-button')
        this.homeHeading = page.getByRole('heading', { name: 'Home' })
    }

    async goToLoginPage() {
        await this.page.goto('__login-app_url__');
    }

    async logIn(username: string, password: string) {
        await this.logInAsLiveChatUserBtn.click()
        await this.usernameField.fill(username)
        await this.passwordField.fill(password)
        await this.logInButton.click()
    }
}